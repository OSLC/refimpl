<%--To avoid the overriding of any manual code changes upon subsequent code generations, disable "Generate JSP Files" option in the Adaptor model.--%>
<!DOCTYPE html>
<%--
 Copyright (c) 2011, 2012, 2017 IBM Corporation and others.

 All rights reserved. This program and the accompanying materials
 are made available under the terms of the Eclipse Public License v1.0
 and Eclipse Distribution License v. 1.0 which accompanies this distribution.

 The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 and the Eclipse Distribution License is available at
 http://www.eclipse.org/org/documents/edl-v10.php.

 Contributors:

  Sam Padgett     - initial API and implementation
  Michael Fiedler - adapted for OSLC4J
  Jad El-khoury   - initial implementation of code generator (422448)
  Frédéric Loiret - Switch the template to Bootstrap (519699)

 This file is generated by org.eclipse.lyo.oslc4j.codegenerator
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="org.eclipse.lyo.oslc4j.core.model.Link" %>
<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="org.eclipse.lyo.oslc4j.core.model.OslcConstants"%>
<%@page import="org.eclipse.lyo.oslc4j.core.OSLC4JUtils"%>
<%@page import="org.eclipse.lyo.oslc4j.core.annotation.OslcPropertyDefinition"%>
<%@page import="org.eclipse.lyo.oslc4j.core.annotation.OslcName"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="java.net.URI"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map"%>
<%@page import="javax.xml.namespace.QName"%>
<%@page import="javax.ws.rs.core.UriBuilder"%>

<%@page import="org.eclipse.lyo.oslc.domains.rm.RequirementCollection"%>
<%@page import="org.eclipse.lyo.oslc.domains.rm.Oslc_rmDomainConstants"%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
  RequirementCollection aRequirementCollection = (RequirementCollection) request.getAttribute("aRequirementCollection");
%>

<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title><%= aRequirementCollection.toString() %></title>

  <link href="<c:url value="/static/css/bootstrap-4.0.0-beta.min.css"/>" rel="stylesheet">
  <link href="<c:url value="/static/css/adaptor.css"/>" rel="stylesheet">

  <script src="<c:url value="/static/js/jquery-3.2.1.min.js"/>"></script>
  <script src="<c:url value="/static/js/popper-1.11.0.min.js"/>"></script>
  <script src="<c:url value="/static/js/bootstrap-4.0.0-beta.min.js"/>"></script>
</head>

<body>

<!-- Begin page content -->
<div>
    <% Method method = null; %>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getTitle"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aRequirementCollection.getTitle() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aRequirementCollection.getTitle().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getDescription"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aRequirementCollection.getDescription() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aRequirementCollection.getDescription().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getIdentifier"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aRequirementCollection.getIdentifier() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aRequirementCollection.getIdentifier().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getShortTitle"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aRequirementCollection.getShortTitle() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aRequirementCollection.getShortTitle().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getSubject"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        Iterator<String> subjectItr = aRequirementCollection.getSubject().iterator();
        while(subjectItr.hasNext()) {
            out.write("<li>" + subjectItr.next().toString() + "</li>");
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getCreator"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getCreator()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/co/oslc/refimpl/rm/gen/persontohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getContributor"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getContributor()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                %>
                <li>
                <jsp:include page="/co/oslc/refimpl/rm/gen/persontohtml.jsp">
                    <jsp:param name="resourceUri" value="<%=next.getValue()%>"/> 
                    </jsp:include>
                </li>
                <%
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getCreated"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aRequirementCollection.getCreated() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aRequirementCollection.getCreated().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getModified"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <%
        if (aRequirementCollection.getModified() == null) {
            out.write("<em>null</em>");
        }
        else {
            out.write(aRequirementCollection.getModified().toString());
        }
        %>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getServiceProvider"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getServiceProvider()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getInstanceShape"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getInstanceShape()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getElaboratedBy"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getElaboratedBy()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getElaborates"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getElaborates()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getSpecifiedBy"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getSpecifiedBy()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getSpecifies"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getSpecifies()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getAffectedBy"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getAffectedBy()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getTrackedBy"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getTrackedBy()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getImplementedBy"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getImplementedBy()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getValidatedBy"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getValidatedBy()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getSatisfiedBy"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getSatisfiedBy()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getSatisfies"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getSatisfies()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getDecomposedBy"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getDecomposedBy()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getDecomposes"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getDecomposes()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getConstrainedBy"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getConstrainedBy()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getConstrains"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getConstrains()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
    <dl class="dl-horizontal">
        <% method = RequirementCollection.class.getMethod("getUses"); %>
        <dt><a href="<%=method.getAnnotation(OslcPropertyDefinition.class).value() %>"><%=method.getAnnotation(OslcName.class).value()%></a></dt>
        <dd>
        <ul>
        <%
        for(Link next : aRequirementCollection.getUses()) {
            if (next.getValue() == null) {
                out.write("<li>" + "<em>null</em>" + "</li>");
            }
            else {
                out.write("<li>" + "<a href=\"" + next.getValue().toString() + "\" class=\"oslc-resource-link\">" + next.getValue().toString() + "</a>" + "</li>");
            }
        }
        %>
        </ul>
        
        </dd>
    </dl>
</div>
<%
Map<QName, Object> extendedProperties = aRequirementCollection.getExtendedProperties();
if (!extendedProperties.isEmpty()) {
%>
    <div>
    <%
    for (Map.Entry<QName, Object> entry : extendedProperties.entrySet()) 
    {
        QName key = entry.getKey();
        Object value = entry.getValue();
    %>
    <dl class="row">
        <dt  class="col-sm-2 text-right"><a href="<%=key.getNamespaceURI() + key.getLocalPart() %>"><%=key.getLocalPart()%></a></dt>
        <dd class="col-sm-9"><%= value.toString()%></dd>
    </dl>
    <%
    }
    %>
    </div>
<%
}
%>
</body>
</html>
