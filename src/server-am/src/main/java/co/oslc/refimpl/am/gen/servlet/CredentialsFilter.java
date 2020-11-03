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
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package co.oslc.refimpl.am.gen.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.oauth.OAuth;
import net.oauth.OAuthException;
import net.oauth.OAuthMessage;
import net.oauth.OAuthProblemException;
import net.oauth.server.OAuthServlet;

import org.eclipse.lyo.server.oauth.consumerstore.FileSystemConsumerStore;
import org.eclipse.lyo.server.oauth.core.OAuthConfiguration;
import org.eclipse.lyo.server.oauth.core.OAuthRequest;
import org.eclipse.lyo.server.oauth.core.token.SimpleTokenStrategy;
import org.eclipse.lyo.server.oauth.core.AuthenticationException;

import co.oslc.refimpl.am.gen.auth.AuthenticationApplication;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code

public class CredentialsFilter implements Filter {
    //For debugging, it might be convenient sometimes to deactivate oauth authentication. By enabling this flag, all http requests are no longer protected.
    private static final Boolean ignoreResourceProtection = false;
    // Start of user code override_ignoreResourceProtection
    // End of user code

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    /**
     * Check if the resource is protected
     * 
     * @param requestUri the uri of the resource which will be checked
     * @return true - the resource is protected, otherwise false
     */
    private boolean isProtectedResource(HttpServletRequest httpRequest) {
        if (ignoreResourceProtection) {
            return false;
        }
        String pathInfo = httpRequest.getPathInfo();

        //'protectedResource' defines the basic set of requests that needs to be protected. 
        //You can override this defintion in the user protected code block below.
        boolean protectedResource = !pathInfo.startsWith("/rootservices") && !pathInfo.startsWith("/oauth");
        // Start of user code isProtectedResource
        // End of user code
        return protectedResource;
    }

    @Override
    public void destroy() {
    }

    /**
     * Check for OAuth or BasicAuth credentials and challenge if not found.
     * 
     * Store the application connection in the HttpSession for retrieval in the REST services.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {

        if (servletRequest instanceof HttpServletRequest && servletResponse instanceof HttpServletResponse) {
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            HttpServletResponse response = (HttpServletResponse) servletResponse;

            if (isProtectedResource(request)) {
                AuthenticationApplication authenticationApplication = AuthenticationApplication.getApplication();
                
                //String clientRequestURL = UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(request.getPathInfo()).build().toString();
                OAuthMessage message = OAuthServlet.getMessage(request, null);
                // First check if this is an OAuth request.
                if (message.getToken() != null) {
                    try {
                        OAuthRequest oAuthRequest = new OAuthRequest(request);
                        oAuthRequest.validate();
                        String applicationConnector = authenticationApplication.getApplicationConnector(message.getToken());
                        if (applicationConnector == null) {
                            // Start of user code nullApplicationConnectorForOauth
                            // End of user code
                            throw new OAuthProblemException(OAuth.Problems.TOKEN_REJECTED);
                        }
                        authenticationApplication.bindApplicationConnectorToSession(request, applicationConnector);
                    } catch (OAuthException e) {
                        // Start of user code oauthException
                        // End of user code
                        OAuthServlet.handleException(response, e, AuthenticationApplication.OAUTH_REALM);
                        return;
                    }
                } 
                else {
                    // This is not an OAuth request, so check for basic authentication
                    // Start of user code basicAuth_Init
                    // End of user code
                    String applicationConnector = authenticationApplication.getApplicationConnectorFromSession(request);
                    if (null == applicationConnector) {
                        // Start of user code basicAuth_nullConnector
                        // End of user code
                        try {
                            authenticationApplication.loginWithBasicAuthentication(request);
                            if (null == authenticationApplication.getApplicationConnectorFromSession(request)) {
                                //So the login still failed
                                throw new AuthenticationException();
                            }
                        } catch (AuthenticationException e) {
                            authenticationApplication.sendUnauthorizedResponse(response, e);
                            return;
                        } 
                    }
                    // Start of user code basicAuth_final
                    // End of user code
                }
            } else {
                // Start of user code resource_not_protected
                // End of user code
            }
        }
        chain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        OAuthConfiguration config = OAuthConfiguration.getInstance();
        AuthenticationApplication authenticationApplication = AuthenticationApplication.getApplication();

        // Validates a user's ID and password.
        config.setApplication(authenticationApplication);

        /*
         * Override some SimpleTokenStrategy methods so that we can keep the
         * BugzillaConnection associated with the OAuth tokens.
         */
        config.setTokenStrategy(new SimpleTokenStrategy() {
            @Override
            public void markRequestTokenAuthorized(HttpServletRequest httpRequest, String requestToken)
                    throws OAuthProblemException {
                authenticationApplication.putApplicationConnector(requestToken, authenticationApplication.getApplicationConnectorFromSession(httpRequest));
                super.markRequestTokenAuthorized(httpRequest, requestToken);
            }

            @Override
            public void generateAccessToken(OAuthRequest oAuthRequest) throws OAuthProblemException, IOException {
                String requestToken = oAuthRequest.getMessage().getToken();
                super.generateAccessToken(oAuthRequest);
                authenticationApplication.moveApplicationConnector(requestToken, oAuthRequest.getAccessor().accessToken);
            }
        });

        try {
            // For now, hard-code the consumers.
            config.setConsumerStore(new FileSystemConsumerStore(authenticationApplication.getOslcConsumerStoreFilename()));
        } catch (Throwable t) {
            System.err.println("Error initializing the OAuth consumer store: " + t.getMessage());
        }
    }
}
