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

package co.oslc.refimpl.rm.gen.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONObject;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
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

import co.oslc.refimpl.rm.gen.RMManager;
import co.oslc.refimpl.rm.gen.RMConstants;
import org.eclipse.lyo.oslc.domains.rm.Oslc_rmDomainConstants;
import org.eclipse.lyo.oslc.domains.rm.Oslc_rmDomainConstants;
import co.oslc.refimpl.rm.gen.servlet.ServiceProviderCatalogSingleton;
import org.eclipse.lyo.oslc.domains.Person;
import org.eclipse.lyo.oslc.domains.rm.Requirement;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@OslcService(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_SHAPES_DOMAIN)
@Path("serviceProviders/{serviceProviderId}/service1/requirements")
public class RequirementsService
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public RequirementsService()
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
        title = "RequirementQC",
        label = "Requirements Query Capability",
        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH,
        resourceTypes = {Oslc_rmDomainConstants.REQUIREMENT_TYPE},
        usages = {}
    )
    @GET
    @Path("query")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public Requirement[] queryRequirements(
                                                    @PathParam("serviceProviderId") final String serviceProviderId ,
                                                     @QueryParam("oslc.where") final String where,
                                                     @QueryParam("page") final String pageString,
                                                    @QueryParam("limit") final String limitString) throws IOException, ServletException
    {
        int page=0;
        int limit=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != limitString) {
            limit = Integer.parseInt(limitString);
        }

        // Start of user code queryRequirements
        // Here additional logic can be implemented that complements main action taken in RMManager
        // End of user code

        final List<Requirement> resources = RMManager.queryRequirements(httpServletRequest, serviceProviderId, where, page, limit);
        return resources.toArray(new Requirement [resources.size()]);
    }

    @GET
    @Path("query")
    @Produces({ MediaType.TEXT_HTML })
    public Response queryRequirementsAsHtml(
                                    @PathParam("serviceProviderId") final String serviceProviderId ,
                                       @QueryParam("oslc.where") final String where,
                                       @QueryParam("page") final String pageString,
                                    @QueryParam("limit") final String limitString) throws ServletException, IOException
    {
        int page=0;
        int limit=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != limitString) {
            limit = Integer.parseInt(limitString);
        }

        // Start of user code queryRequirementsAsHtml
        // End of user code

        final List<Requirement> resources = RMManager.queryRequirements(httpServletRequest, serviceProviderId, where, page, limit);

        if (resources!= null) {
            httpServletRequest.setAttribute("resources", resources);
            // Start of user code queryRequirementsAsHtml_setAttributes
            // End of user code

            httpServletRequest.setAttribute("queryUri",
                    uriInfo.getAbsolutePath().toString() + "?oslc.paging=true");
            if (resources.size() > limit) {
                resources.remove(resources.size() - 1);
                httpServletRequest.setAttribute("nextPageUri",
                        uriInfo.getAbsolutePath().toString() + "?oslc.paging=true&amp;page=" + (page + 1));
            }
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirementscollection.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @OslcDialog
    (
         title = "RequirementSD",
         label = "Requirements Selection Dialog",
         uri = "serviceProviders/{serviceProviderId}/service1/requirements/selector",
         hintWidth = "0px",
         hintHeight = "0px",
         resourceTypes = {Oslc_rmDomainConstants.REQUIREMENT_TYPE},
         usages = {}
    )
    @GET
    @Path("selector")
    @Consumes({ MediaType.TEXT_HTML, MediaType.WILDCARD })
    public void RequirementSelector(
        @QueryParam("terms") final String terms
        , @PathParam("serviceProviderId") final String serviceProviderId
        ) throws ServletException, IOException
    {
        try {
            // Start of user code RequirementSelector_init
            // End of user code

            httpServletRequest.setAttribute("selectionUri",UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(uriInfo.getPath()).build().toString());
            // Start of user code RequirementSelector_setAttributes
            // End of user code

            if (terms != null ) {
                httpServletRequest.setAttribute("terms", terms);
                final List<Requirement> resources = RMManager.RequirementSelector(httpServletRequest, serviceProviderId, terms);
                if (resources!= null) {
                            httpServletRequest.setAttribute("resources", resources);
                            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirementselectorresults.jsp");
                            rd.forward(httpServletRequest, httpServletResponse);
                }
                //a empty search should return an empty list and not NULL!
                throw new WebApplicationException(Status.NOT_FOUND);

            } else {
                try {
                    RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirementselector.jsp");
                    rd.forward(httpServletRequest, httpServletResponse);
                } catch (Exception e) {
                    throw new ServletException(e);
                }
            }
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }
    }

    /**
     * Create a single Requirement via RDF/XML, XML or JSON POST
     *
     * @throws IOException
     * @throws ServletException
     */
    @OslcCreationFactory
    (
         title = "RequirementCF",
         label = "Requirements Creation Factory",
         resourceShapes = {OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH},
         resourceTypes = {Oslc_rmDomainConstants.REQUIREMENT_TYPE},
         usages = {}
    )
    @POST
    @Path("create")
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public Response createRequirement(
            @PathParam("serviceProviderId") final String serviceProviderId ,
            final Requirement aResource
        ) throws IOException, ServletException
    {
        try {
            Requirement newResource = RMManager.createRequirement(httpServletRequest, aResource, serviceProviderId);
            httpServletResponse.setHeader("ETag", RMManager.getETagFromRequirement(newResource));
            return Response.created(newResource.getAbout()).entity(newResource).header(RMConstants.HDR_OSLC_VERSION, RMConstants.OSLC_VERSION_V2).build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
        }
    }

    /**
     * OSLC delegated creation dialog for a single resource
     *
     * @throws IOException
     * @throws ServletException
     */
    @GET
    @Path("creator")
    @Consumes({MediaType.WILDCARD})
    public void RequirementCreator(
                @PathParam("serviceProviderId") final String serviceProviderId
        ) throws IOException, ServletException
    {
        // Start of user code RequirementCreator
        // End of user code

        httpServletRequest.setAttribute("creatorUri", UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(uriInfo.getPath()).build().toString());
        httpServletRequest.setAttribute("serviceProviderId", serviceProviderId);

        RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirementcreator.jsp");
        rd.forward(httpServletRequest, httpServletResponse);
    }

    /**
     * Backend creator for the OSLC delegated creation dialog.
     *
     * Accepts the input in FormParams and returns a small JSON response
     */
    @OslcDialog
    (
         title = "RequirementCD",
         label = "Requirements Creation Dialog",
         uri = "serviceProviders/{serviceProviderId}/service1/requirements/creator",
         hintWidth = "0px",
         hintHeight = "0px",
         resourceTypes = {Oslc_rmDomainConstants.REQUIREMENT_TYPE},
         usages = {}
    )
    @POST
    @Path("creator")
    @Consumes({ MediaType.APPLICATION_FORM_URLENCODED})
    public void createRequirementFromDialog(
            @PathParam("serviceProviderId") final String serviceProviderId
        ) {
        try {
            Requirement newResource = null;

            Requirement aResource = new Requirement();

            String[] paramValues;

            paramValues = httpServletRequest.getParameterValues("title");
            if (paramValues != null) {
                    if (paramValues.length == 1) {
                        if (paramValues[0].length() != 0)
                            aResource.setTitle(paramValues[0]);
                        // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                    }

            }
            paramValues = httpServletRequest.getParameterValues("description");
            if (paramValues != null) {
                    if (paramValues.length == 1) {
                        if (paramValues[0].length() != 0)
                            aResource.setDescription(paramValues[0]);
                        // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                    }

            }
            paramValues = httpServletRequest.getParameterValues("identifier");
            if (paramValues != null) {
                    if (paramValues.length == 1) {
                        if (paramValues[0].length() != 0)
                            aResource.setIdentifier(paramValues[0]);
                        // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                    }

            }
            paramValues = httpServletRequest.getParameterValues("shortTitle");
            if (paramValues != null) {
                    if (paramValues.length == 1) {
                        if (paramValues[0].length() != 0)
                            aResource.setShortTitle(paramValues[0]);
                        // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                    }

            }
            paramValues = httpServletRequest.getParameterValues("subject");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addSubject(paramValues[i]);
                    }
            }
            paramValues = httpServletRequest.getParameterValues("creator");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addCreator(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("contributor");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addContributor(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("created");
            if (paramValues != null) {
                    if (paramValues.length == 1) {
                        if (paramValues[0].length() != 0)
                            aResource.setCreated(new SimpleDateFormat("M/D/y").parse(paramValues[0]));
                        // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                    }

            }
            paramValues = httpServletRequest.getParameterValues("modified");
            if (paramValues != null) {
                    if (paramValues.length == 1) {
                        if (paramValues[0].length() != 0)
                            aResource.setModified(new SimpleDateFormat("M/D/y").parse(paramValues[0]));
                        // else, there is an empty value for that parameter, and hence ignore since the parameter is not actually set.
                    }

            }
            paramValues = httpServletRequest.getParameterValues("serviceProvider");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addServiceProvider(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("instanceShape");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addInstanceShape(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("elaboratedBy");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addElaboratedBy(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("elaborates");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addElaborates(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("specifiedBy");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addSpecifiedBy(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("specifies");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addSpecifies(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("affectedBy");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addAffectedBy(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("trackedBy");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addTrackedBy(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("implementedBy");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addImplementedBy(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("validatedBy");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addValidatedBy(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("satisfiedBy");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addSatisfiedBy(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("satisfies");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addSatisfies(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("decomposedBy");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addDecomposedBy(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("decomposes");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addDecomposes(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("constrainedBy");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addConstrainedBy(new Link(new URI(paramValues[i])));
                    }
            }
            paramValues = httpServletRequest.getParameterValues("constrains");
            if (paramValues != null) {
                    for(int i=0; i<paramValues.length; i++) {
                        aResource.addConstrains(new Link(new URI(paramValues[i])));
                    }
            }

            newResource = RMManager.createRequirementFromDialog(httpServletRequest, aResource, serviceProviderId);

            if (newResource != null) {
                httpServletRequest.setAttribute("newResource", newResource);
                httpServletRequest.setAttribute("newResourceUri", newResource.getAbout().toString());

                // Send back to the form a small JSON response
                httpServletResponse.setContentType("application/json");
                httpServletResponse.setStatus(Status.CREATED.getStatusCode());
                httpServletResponse.addHeader("Location", newResource.getAbout().toString());
                PrintWriter out = httpServletResponse.getWriter();

                JSONObject oslcResponse = new JSONObject();
                JSONObject newResourceJson = new JSONObject();
                newResourceJson.put("rdf:resource", newResource.getAbout().toString());
                // Start of user code OSLC Resource Label
                newResourceJson.put("oslc:label", newResource.toString());
                // End of user code
                oslcResponse.put("oslc:results", new Object[]{newResourceJson});

                out.print(oslcResponse.toString());
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new WebApplicationException(e);
        }
    }
    @GET
    @Path("{requirementId}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON})
    public Requirement getRequirement(
                @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("requirementId") final String requirementId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code getResource_init
        // End of user code

        final Requirement aRequirement = RMManager.getRequirement(httpServletRequest, serviceProviderId, requirementId);

        if (aRequirement != null) {
            // Start of user code getRequirement
            // End of user code
            httpServletResponse.addHeader(RMConstants.HDR_OSLC_VERSION, RMConstants.OSLC_VERSION_V2);
            return aRequirement;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{requirementId}")
    @Produces({ MediaType.TEXT_HTML })
    public Response getRequirementAsHtml(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("requirementId") final String requirementId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getRequirementAsHtml_init
        // End of user code

        final Requirement aRequirement = RMManager.getRequirement(httpServletRequest, serviceProviderId, requirementId);

        if (aRequirement != null) {
            httpServletRequest.setAttribute("aRequirement", aRequirement);
            // Start of user code getRequirementAsHtml_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirement.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{requirementId}")
    @Produces({OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML})
    public Compact getRequirementCompact(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("requirementId") final String requirementId
        ) throws ServletException, IOException, URISyntaxException
    {
        String iconUri = OSLC4JUtils.getPublicURI() + "/images/ui_preview_icon.gif";
        String smallPreviewHintHeight = "10em";
        String smallPreviewHintWidth = "45em";
        String largePreviewHintHeight = "20em";
        String largePreviewHintWidth = "45em";

        // Start of user code getRequirementCompact_init
        //TODO: adjust the preview height & width values from the default values provided above.
        // End of user code

        final Requirement aRequirement = RMManager.getRequirement(httpServletRequest, serviceProviderId, requirementId);

        if (aRequirement != null) {
            final Compact compact = new Compact();

            compact.setAbout(aRequirement.getAbout());
            compact.setTitle(aRequirement.toString());

            compact.setIcon(new URI(iconUri));

            //Create and set attributes for OSLC preview resource
            final Preview smallPreview = new Preview();
            smallPreview.setHintHeight(smallPreviewHintHeight);
            smallPreview.setHintWidth(smallPreviewHintWidth);
            smallPreview.setDocument(UriBuilder.fromUri(aRequirement.getAbout()).path("smallPreview").build());
            compact.setSmallPreview(smallPreview);

            final Preview largePreview = new Preview();
            largePreview.setHintHeight(largePreviewHintHeight);
            largePreview.setHintWidth(largePreviewHintWidth);
            largePreview.setDocument(UriBuilder.fromUri(aRequirement.getAbout()).path("largePreview").build());
            compact.setLargePreview(largePreview);

            httpServletResponse.addHeader(RMConstants.HDR_OSLC_VERSION, RMConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            return compact;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{requirementId}/smallPreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getRequirementAsHtmlSmallPreview(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("requirementId") final String requirementId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getRequirementAsHtmlSmallPreview_init
        // End of user code

        final Requirement aRequirement = RMManager.getRequirement(httpServletRequest, serviceProviderId, requirementId);

        if (aRequirement != null) {
            httpServletRequest.setAttribute("aRequirement", aRequirement);
            // Start of user code getRequirementAsHtmlSmallPreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirementsmallpreview.jsp");
            httpServletResponse.addHeader(RMConstants.HDR_OSLC_VERSION, RMConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            rd.forward(httpServletRequest, httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{requirementId}/largePreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getRequirementAsHtmlLargePreview(
        @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("requirementId") final String requirementId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getRequirementAsHtmlLargePreview_init
        // End of user code

        final Requirement aRequirement = RMManager.getRequirement(httpServletRequest, serviceProviderId, requirementId);

        if (aRequirement != null) {
            httpServletRequest.setAttribute("aRequirement", aRequirement);
            // Start of user code getRequirementAsHtmlLargePreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/co/oslc/refimpl/rm/gen/requirementlargepreview.jsp");
            httpServletResponse.addHeader(RMConstants.HDR_OSLC_VERSION, RMConstants.OSLC_VERSION_V2);
            addCORSHeaders(httpServletResponse);
            rd.forward(httpServletRequest, httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }
    @DELETE
    @Path("{requirementId}")
    public Response deleteRequirement(
                @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("requirementId") final String requirementId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code deleteRequirement_init
        // End of user code
        final Requirement aResource = RMManager.getRequirement(httpServletRequest, serviceProviderId, requirementId);

        if (aResource != null) {
            // Start of user code deleteRequirement
            // End of user code
            boolean deleted = RMManager.deleteRequirement(httpServletRequest, serviceProviderId, requirementId);
            if (deleted)
                return Response.ok().header(RMConstants.HDR_OSLC_VERSION, RMConstants.OSLC_VERSION_V2).build();
            else
                throw new WebApplicationException(Status.INTERNAL_SERVER_ERROR);
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @PUT
    @Path("{requirementId}")
    @Consumes({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_JSON_LD, OslcMediaType.TEXT_TURTLE, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON })
    public Response updateRequirement(
            @HeaderParam("If-Match") final String eTagHeader,
            @PathParam("serviceProviderId") final String serviceProviderId, @PathParam("requirementId") final String requirementId ,
            final Requirement aResource
        ) throws IOException, ServletException
    {
        // Start of user code updateRequirement_init
        // End of user code
        final Requirement originalResource = RMManager.getRequirement(httpServletRequest, serviceProviderId, requirementId);

        if (originalResource != null) {
            try {
                final String originalETag = RMManager.getETagFromRequirement(originalResource);

                if ((eTagHeader == null) || (originalETag.equals(eTagHeader))) {
                    // Start of user code updateRequirement
                    // End of user code
                    final Requirement updatedResource = RMManager.updateRequirement(httpServletRequest, aResource, serviceProviderId, requirementId);
                    httpServletResponse.setHeader("ETag", RMManager.getETagFromRequirement(updatedResource));
                    return Response.ok().header(RMConstants.HDR_OSLC_VERSION, RMConstants.OSLC_VERSION_V2).build();
                }
                else {
                    throw new WebApplicationException(Status.PRECONDITION_FAILED);
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new WebApplicationException(e);
            }

        }
        else {
            throw new WebApplicationException(Status.NOT_FOUND);
        }
    }

}
