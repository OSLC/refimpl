// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2020 Jad El-khoury and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package co.oslc.refimpl.cm.gen.services;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import co.oslc.refimpl.cm.gen.CMConstants;
import co.oslc.refimpl.cm.gen.auth.AuthenticationApplication;
import co.oslc.refimpl.cm.gen.servlet.ServiceProviderCatalogSingleton;

// Start of user code imports
// End of user code

/**
 * Jazz Root Services Service, see:
 * https://jazz.net/wiki/bin/view/Main/RootServicesSpec
 * https://jazz.net/wiki/bin/view/Main/RootServicesSpecAddendum2
 */

@Path("rootservices")
public class RootServicesService {
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    /**
     * Return a Rational Jazz compliant root services document
     * 
     * See https://jazz.net/wiki/bin/view/Main/RootServicesSpec
     */
    @GET
    @Produces({ OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML })
    public Response getRootServices() {
        String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" +
                "<rdf:Description \n" +
                "    xmlns:oslc_cm=\"http://open-services.net/xmlns/cm/1.0/\"" + "\n" +
                "    xmlns:oslc_am=\"http://open-services.net/ns/am#\"" + "\n" +
                "    xmlns:oslc_rm=\"http://open-services.net/xmlns/rm/1.0/\"" + "\n" +
                "    xmlns:dc=\"http://purl.org/dc/terms/\"" + "\n" +
                "    xmlns:jfs=\"http://jazz.net/xmlns/prod/jazz/jfs/1.0/\"" + "\n" +
                "    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n" +
                "    rdf:about=\"" + UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path("rootservices").build().toString() + "\">\n" +
                "    <dc:title>Root Services</dc:title>" + "\n" +
                "    <oslc_am:amServiceProviders rdf:resource=\"" + ServiceProviderCatalogSingleton.getUri() + "\" />" + "\n" +
                "    <oslc_rm:rmServiceProviders rdf:resource=\"" + ServiceProviderCatalogSingleton.getUri() + "\" />" + "\n" +
                "    <oslc_cm:cmServiceProviders rdf:resource=\"" + ServiceProviderCatalogSingleton.getUri() + "\" />" + "\n" +
                "    <jfs:oauthRealmName>" + AuthenticationApplication.OAUTH_REALM + "</jfs:oauthRealmName>" + "\n" +
                "    <jfs:oauthDomain>" + OSLC4JUtils.getPublicURI() + "</jfs:oauthDomain>" + "\n" +
                "    <jfs:oauthRequestConsumerKeyUrl rdf:resource=\"" + UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path("oauth/requestKey").build().toString() + "\"/>" + "\n" +
                "    <jfs:oauthApprovalModuleUrl rdf:resource=\"" + UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path("oauth/approveKey").build().toString() + "\"/>" + "\n" +
                "    <jfs:oauthRequestTokenUrl rdf:resource=\"" + UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path("oauth/requestToken").build().toString() + "\"/>" + "\n" +
                "    <jfs:oauthUserAuthorizationUrl rdf:resource=\"" + UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path("oauth/authorize").build().toString() + "\"/>" + "\n" +
                "    <jfs:oauthAccessTokenUrl rdf:resource=\"" + UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path("oauth/accessToken").build().toString() + "\"/>" + "\n" +
                "    </rdf:Description>" + "\n";
        MediaType mediaType = MediaType.valueOf("application/rdf+xml");
        ResponseBuilder builder = Response.ok(response, mediaType);
        builder.type("application/rdf+xml; charset=UTF-8");
        builder.header(CMConstants.HDR_OSLC_VERSION, CMConstants.OSLC_VERSION_V2);
        return builder.build();
    }
}
