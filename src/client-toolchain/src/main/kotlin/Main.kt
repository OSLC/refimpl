import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import org.eclipse.lyo.oslc.domains.rm.Requirement
import org.eclipse.lyo.oslc.domains.rm.RequirementCollection
import org.eclipse.lyo.oslc4j.client.OslcClient
import org.eclipse.lyo.oslc4j.core.model.AbstractResource
import org.eclipse.lyo.oslc4j.core.model.CreationFactory
import org.eclipse.lyo.oslc4j.core.model.Link
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider
import org.eclipse.lyo.oslc4j.core.model.ServiceProviderCatalog
import java.net.URI
import java.util.Date
import javax.ws.rs.core.Response

private val NS_REQUIREMENT = URI.create("http://open-services.net/ns/rm#Requirement")
private val NS_REQUIREMENT_COLL = URI.create("http://open-services.net/ns/rm#RequirementCollection")

fun main() {
    println("Populating OSLC RefImpl servers with sample data.\n")
    val client = OslcClient()
    val rm_spc = "http://localhost:8800/services/catalog/singleton"

    val rmCatalog = client.getResource(rm_spc, ServiceProviderCatalog::class.java)

    println("Fetched the ${rmCatalog.title}")

    val spUris = rmCatalog.serviceProviders.map { it.about }
    val providers = client.getResources(spUris, ServiceProvider::class.java)

    var reqGen = RandomResourceGen(::genRequirement)
    var reqCollGen = RandomResourceGen(::genRequirementColl)

    providers.forEach { sp ->
        println("-> contains ${sp.title}")
        sp.services.forEach { svc ->
            println("   -> contains a Service with (CF filter):")
            svc.creationFactories.forEach { cf ->
                println("      -> ${cf.label}")
//                cf.resourceShapes.forEach {
//                    println("        ~> ${it} shape")
//                }
                cf.resourceTypes.forEach { cfType ->
                    // TODO Andrew@2019-09-24: delete all resources of this type
                    println("        ~> ${cfType} type")
                    if (cfType == NS_REQUIREMENT) {
                        val requirementLinks = postResources(client, cf, sp, 0, reqGen)
                        println("Created ${requirementLinks.size} Requirements")
                    } else if (cfType == NS_REQUIREMENT_COLL) {
                        val reqCollectionLinks = postResources(client, cf, sp, 1, reqCollGen)
                        println("Created ${reqCollectionLinks.size} Requirement Collections")
                    }
                }
            }
        }
    }

}


fun <T: AbstractResource> postResources(client: OslcClient, cf: CreationFactory, sp: ServiceProvider, count: Int, generator: RandomResourceGen<T>): Set<Link> {
    val createdUrls = HashSet<Link>()
    val resources = generator.generate(sp, count)
    val responsesAsync: List<Deferred<Pair<Response, T>>> = resources.map { r ->
        GlobalScope.async {
            Pair(client.createResource(cf.creation.toString(), r, "text/turtle"), r)
        }
    }
    runBlocking {
        val responses: List<Pair<Response, T>> = responsesAsync.awaitAll()
        responses.forEach { (response, r) ->
            if (response.status < 400) {
                val headers = response.headers
                val url: String? = headers["Location"]?.single() as String
                if(url != null) {
                    createdUrls.add(Link(URI.create(url), "TBD"))
                    println("$r created at $url")
                }
            } else {
                println("Failed to create $r")
            }
        }
    }
    return createdUrls
}

fun genRequirement(sp: ServiceProvider, id: Int): Requirement {
    val r = Requirement()
    r.apply {
        shortTitle = "${sp.identifier.toUpperCase()}-$id"
        identifier = "req_$id"
        title = "Requirement no. $id"
        description = "Requirement no. $id was generated by a 'client-toolchain' project. Edit its to change how these resources look."
        modified = Date()
    }
    return r
}

fun genRequirementColl(sp: ServiceProvider, id: Int): RequirementCollection {
    val r = RequirementCollection()
    r.apply {
        shortTitle = "${sp.identifier.toUpperCase()}-C$id"
        identifier = "rq_coll_$id"
        title = "Requirement Collection no. $id"
        description = "Requirement Collecion no. $id was generated by a 'client-toolchain' project. Edit its to change how these resources look."
        modified = Date()
    }
    return r
}