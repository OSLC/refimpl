<%--To avoid the overriding of any manual code changes upon subsequent code generations, disable "Generate JSP Files" option in the Adaptor model.--%>
<!DOCTYPE html>
<%--
 Copyright (c) 2020 Contributors to the Eclipse Foundation
 
 See the NOTICE file(s) distributed with this work for additional
 information regarding copyright ownership.
 
 This program and the accompanying materials are made available under the
 terms of the Eclipse Distribution License 1.0 which is available at
 http://www.eclipse.org/org/documents/edl-v10.php.
 
 SPDX-License-Identifier: BSD-3-Simple

 This file is generated by Lyo Designer (https://www.eclipse.org/lyo/)
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.eclipse.lyo.oslc4j.core.model.ServiceProviderCatalog" %>
<%@ page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider" %>
<%@page import="javax.ws.rs.core.UriBuilder"%>
<%@page import="org.eclipse.lyo.oslc4j.core.OSLC4JUtils"%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
ServiceProviderCatalog catalog = (ServiceProviderCatalog)request.getAttribute("catalog");
String catalogUrl = UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path("/catalog/singleton").build().toString();
%>

<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Service Provider Catalog - RM OSLC Adapter</title>

    <link href="<c:url value="/static/css/bootstrap-4.0.0-beta.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/static/css/adaptor.css"/>" rel="stylesheet">

    <script src="<c:url value="/static/js/jquery-3.2.1.min.js"/>"></script>
    <script src="<c:url value="/static/js/popper-1.11.0.min.js"/>"></script>
    <script src="<c:url value="/static/js/bootstrap-4.0.0-beta.min.js"/>"></script>

  </head>
  <body>
  <nav class="navbar navbar-expand-lg sticky-top navbar-light bg-light">
    <div class="container">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item"><a class="nav-link" href="<c:url value="/"/>"><%= application.getServletContextName() %></a></li>
        <li class="nav-item"><a class="nav-link" href="<c:url value="<%= catalogUrl %>"/>">Service Provider Catalog</a></li>
        <li class="nav-item"><a class="nav-link" href="<c:url value="/swagger-ui/index.jsp"/>">Swagger UI</a></li>
      </ul>
    </div>
  </nav>

  <div class="container">
    <div class="page-header">
      <h1>RM Service Provider Catalogue</h1>
    </div>

  	<h2>Service Providers</h2>
    <% if (catalog.getServiceProviders().length == 0) {%>
        <div class="alert alert-primary" role="alert">
            <h4 class="alert-heading">No Service Providers defined for this server!</h4>
            <hr>
            <p>
                Modify the method <code>getServiceProviderInfos()</code>
                in the class <code>co.oslc.refimpl.rm.gen.RMManager</code>, to return the expected set of Service Provider resources.
            </p>
        </div>
    <% } %>
    <% for (ServiceProvider s : catalog.getServiceProviders()) { %>
      <div>
      <p class="lead">
      <a href=" <%= s.getAbout() %>">
        <%= s.getTitle() %>
      </a>
      <br>
      <em>
        <small><%= s.getDescription() %></small>
      </em>
      </p>
      </div>
    <% } %>
  </div>
  <footer class="footer">
    <div class="container">
      <p class="text-muted">
        OSLC Adaptor was generated using <a href="http://eclipse.org/lyo">Eclipse Lyo</a>.
      </p>
    </div>
  </footer>
</body>
</html>
