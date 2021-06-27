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
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page import="org.eclipse.lyo.oslc4j.core.model.ServiceProvider"%>
<%@page import="java.util.List" %>
<%@page import="org.eclipse.lyo.oslc.domains.rm.Requirement"%>
<%@page import="org.eclipse.lyo.oslc4j.core.OSLC4JUtils"%>
<%@page import="javax.ws.rs.core.UriBuilder"%>

<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>

<%
  String creatorUri = (String) request.getAttribute("creatorUri");
  String serviceProviderId = (String) request.getAttribute("serviceProviderId");
%>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <title>RequirementCD</title>
    <script src="<c:url value="/static/js/delegated-ui.js"/>"></script>
  </head>
  <body style="padding: 10px;">
    <div id="bugzilla-body">
    <form id="Create" method="POST" class="enter_bug_form">
        <table style="clear: both;">
          <tr>
            <td>
            <label for="title">title: </LABEL>
            <%
            out.write("<input name=\"title\" type=\"text\" style=\"width: 400px\" id=\"title\" >");
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="description">description: </LABEL>
            <%
            out.write("<input name=\"description\" type=\"text\" style=\"width: 400px\" id=\"description\" >");
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="identifier">identifier: </LABEL>
            <%
            out.write("<input name=\"identifier\" type=\"text\" style=\"width: 400px\" id=\"identifier\" >");
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="shortTitle">shortTitle: </LABEL>
            <%
            out.write("<input name=\"shortTitle\" type=\"text\" style=\"width: 400px\" id=\"shortTitle\" >");
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="subject">subject: </LABEL>
            <%
            out.write("<input name=\"subject\" type=\"text\" style=\"width: 400px\" id=\"subject\" >");
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="creator">creator: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="contributor">contributor: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="created">created: </LABEL>
            <%
            out.write("<input name=\"created\" type=\"text\" style=\"width: 400px\" id=\"created\" >");
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="modified">modified: </LABEL>
            <%
            out.write("<input name=\"modified\" type=\"text\" style=\"width: 400px\" id=\"modified\" >");
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="serviceProvider">serviceProvider: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="instanceShape">instanceShape: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="elaboratedBy">elaboratedBy: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="elaborates">elaborates: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="specifiedBy">specifiedBy: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="specifies">specifies: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="affectedBy">affectedBy: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="trackedBy">trackedBy: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="implementedBy">implementedBy: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="validatedBy">validatedBy: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="satisfiedBy">satisfiedBy: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="satisfies">satisfies: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="decomposedBy">decomposedBy: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="decomposes">decomposes: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="constrainedBy">constrainedBy: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td>
            <label for="constrains">constrains: </LABEL>
            <%
            %>
            </td>
          </tr>
          <tr>
            <td></td>
            <td>
              <input type="button"
                value="Submit"
                onclick="javascript: create( '<%= creatorUri %>' )">
              <input type="reset">
            </td>
          </tr>
        </table>
        <div style="width: 500px;">
        </div>
      </form>

      <div style="clear: both;"></div>
    </div>
  </body>
</html>
