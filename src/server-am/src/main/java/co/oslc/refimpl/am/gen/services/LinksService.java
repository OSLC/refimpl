// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *
 *     Michael Fiedler     - initial API and implementation for Bugzilla adapter
 *     Jad El-khoury       - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Jim Amsden          - Support for UI Preview (494303)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package co.oslc.refimpl.am.gen.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONException;
import org.apache.wink.json4j.JSONObject;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.eclipse.lyo.oslc4j.core.OSLC4JConstants;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Compact;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.Preview;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

import co.oslc.refimpl.am.gen.AMManager;
import co.oslc.refimpl.am.gen.AMConstants;
import org.eclipse.lyo.oslc.domains.am.Oslc_amDomainConstants;
import org.eclipse.lyo.oslc.domains.am.Oslc_amDomainConstants;
import co.oslc.refimpl.am.gen.servlet.ServiceProviderCatalogSingleton;
import org.eclipse.lyo.oslc.domains.am.LinkType;
import org.eclipse.lyo.oslc.domains.Person;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@OslcService(Oslc_amDomainConstants.ARCHITECTURE_MANAGEMENT_DOMAIN)
@Path("service2/linkTypes")
@Api(value = "OSLC Service for {" + Oslc_amDomainConstants.LINKTYPE_LOCALNAME + "}")
public class LinksService
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    private static final Logger log = LoggerFactory.getLogger(LinksService.class);

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public LinksService()
    {
        super();
    }

    private void addCORSHeaders (final HttpServletResponse httpServletResponse) {
        //UI preview can be blocked by CORS policy.
        //add select CORS headers to every response that is embedded in an iframe.
        httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.addHeader("Access-Control-Allow-Methods", "GET, OPTIONS, HEAD");
        httpServletResponse.addHeader("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        httpServletResponse.addHeader("Access-Control-Allow-Credentials", "true");
    }

    @OslcQueryCapability
    (
        title = "LinkTypeQC",
        label = "LinkType Query Capability",
        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_amDomainConstants.LINKTYPE_PATH,
        resourceTypes = {Oslc_amDomainConstants.LINKTYPE_TYPE},
        usages = {}
    )
    @GET
    @Path("query")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    @ApiOperation(
        value = "Query capability for resources of type {" + Oslc_amDomainConstants.LINKTYPE_LOCALNAME + "}",
        notes = "Query capability for resources of type {" + "<a href=\"" + Oslc_amDomainConstants.LINKTYPE_TYPE + "\">" + Oslc_amDomainConstants.LINKTYPE_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_amDomainConstants.LINKTYPE_PATH + "\">" + Oslc_amDomainConstants.LINKTYPE_LOCALNAME + "</a>" + "}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML
    )
    public LinkType[] queryLinkTypes(
                                                    
                                                     @QueryParam("oslc.where") final String where,
                                                     @QueryParam("oslc.prefix") final String prefix,
                                                     @QueryParam("page") final String pageString,
                                                    @QueryParam("oslc.pageSize") final String pageSizeString) throws IOException, ServletException
    {
        int page=0;
        int pageSize=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != pageSizeString) {
            pageSize = Integer.parseInt(pageSizeString);
        }

        // Start of user code queryLinkTypes
        // Here additional logic can be implemented that complements main action taken in AMManager
        // End of user code

        final List<LinkType> resources = AMManager.queryLinkTypes(httpServletRequest, where, prefix, page, pageSize);
        httpServletRequest.setAttribute("queryUri",
                uriInfo.getAbsolutePath().toString() + "?oslc.paging=true");
        if (resources.size() > pageSize) {
            resources.remove(resources.size() - 1);
            httpServletRequest.setAttribute(OSLC4JConstants.OSLC4J_NEXT_PAGE,
                    uriInfo.getAbsolutePath().toString() + "?oslc.paging=true&oslc.pageSize=" + pageSize + "&page=" + (page + 1));
        }
        return resources.toArray(new LinkType [resources.size()]);
    }

    @GET
    @Path("query")
    @Produces({ MediaType.TEXT_HTML })
    @ApiOperation(
        value = "Query capability for resources of type {" + Oslc_amDomainConstants.LINKTYPE_LOCALNAME + "}",
        notes = "Query capability for resources of type {" + "<a href=\"" + Oslc_amDomainConstants.LINKTYPE_TYPE + "\">" + Oslc_amDomainConstants.LINKTYPE_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_amDomainConstants.LINKTYPE_PATH + "\">" + Oslc_amDomainConstants.LINKTYPE_LOCALNAME + "</a>" + "}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML
    )
    public void queryLinkTypesAsHtml(
                                    
                                       @QueryParam("oslc.where") final String where,
                                       @QueryParam("oslc.prefix") final String prefix,
                                       @QueryParam("page") final String pageString,
                                    @QueryParam("oslc.pageSize") final String pageSizeString) throws ServletException, IOException
    {
        int page=0;
        int pageSize=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != pageSizeString) {
            pageSize = Integer.parseInt(pageSizeString);
        }

        // Start of user code queryLinkTypesAsHtml
        // End of user code

        final List<LinkType> resources = AMManager.queryLinkTypes(httpServletRequest, where, prefix, page, pageSize);

        if (resources!= null) {
            httpServletRequest.setAttribute("resources", resources);
            // Start of user code queryLinkTypesAsHtml_setAttributes
            // End of user code

            httpServletRequest.setAttribute("queryUri",
                    uriInfo.getAbsolutePath().toString() + "?oslc.paging=true");
            if (resources.size() > pageSize) {
                resources.remove(resources.size() - 1);
                httpServletRequest.setAttribute(OSLC4JConstants.OSLC4J_NEXT_PAGE,
                        uriInfo.getAbsolutePath().toString() + "?oslc.paging=true&oslc.pageSize=" + pageSize + "&page=" + (page + 1));
            }
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/am/gen/linktypescollection.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
            return;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @OslcDialog
    (
         title = "LinkTypeSD",
         label = "LinkType Selection Dialog",
         uri = "service2/linkTypes/selector",
         hintWidth = "0px",
         hintHeight = "0px",
         resourceTypes = {Oslc_amDomainConstants.LINKTYPE_TYPE},
         usages = {}
    )
    @GET
    @Path("selector")
    @Consumes({ MediaType.TEXT_HTML, MediaType.WILDCARD })
    public void LinkTypeSelector(
        @QueryParam("terms") final String terms
        
        ) throws ServletException, IOException
    {
        // Start of user code LinkTypeSelector_init
            // End of user code

        httpServletRequest.setAttribute("selectionUri",UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(uriInfo.getPath()).build().toString());
        // Start of user code LinkTypeSelector_setAttributes
            // End of user code

        if (terms != null ) {
            httpServletRequest.setAttribute("terms", terms);
            final List<LinkType> resources = AMManager.LinkTypeSelector(httpServletRequest, terms);
            if (resources!= null) {
                        httpServletRequest.setAttribute("resources", resources);
                        RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/am/gen/linktypeselectorresults.jsp");
                        rd.forward(httpServletRequest, httpServletResponse);
                        return;
            }
            log.error("A empty search should return an empty list and not NULL!");
            throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);

        } else {
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/am/gen/linktypeselector.jsp");
            rd.forward(httpServletRequest, httpServletResponse);
            return;
        }
    }

    /**
     * Create a single LinkType via RDF/XML, XML or JSON POST
     *
     * @throws IOException
     * @throws ServletException
     */
    @OslcCreationFactory
    (
         title = "LinkTypeCF",
         label = "LinkType Creation Factory",
         resourceShapes = {OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_amDomainConstants.LINKTYPE_PATH},
         resourceTypes = {Oslc_amDomainConstants.LINKTYPE_TYPE},
         usages = {}
    )
    @POST
    @Path("create")
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    @ApiOperation(
        value = "Creation factory for resources of type {" + Oslc_amDomainConstants.LINKTYPE_LOCALNAME + "}",
        notes = "Creation factory for resources of type {" + "<a href=\"" + Oslc_amDomainConstants.LINKTYPE_TYPE + "\">" + Oslc_amDomainConstants.LINKTYPE_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_amDomainConstants.LINKTYPE_PATH + "\">" + Oslc_amDomainConstants.LINKTYPE_LOCALNAME + "</a>" + "}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE
    )
    public Response createLinkType(
            
            final LinkType aResource
        ) throws IOException, ServletException
    {
        LinkType newResource = AMManager.createLinkType(httpServletRequest, aResource);
        httpServletResponse.setHeader("ETag", AMManager.getETagFromLinkType(newResource));
        return Response.created(newResource.getAbout()).entity(newResource).header(AMConstants.HDR_OSLC_VERSION, AMConstants.OSLC_VERSION_V2).build();
    }

}
