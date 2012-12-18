
<%@ page import="com.xlnc.agile.PersonAuthority" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'personAuthority.label', default: 'PersonAuthority')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-personAuthority" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-personAuthority" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<th><g:message code="personAuthority.authority.label" default="Authority" /></th>
					
						<th><g:message code="personAuthority.person.label" default="Person" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${personAuthorityInstanceList}" status="i" var="personAuthorityInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${personAuthorityInstance.id}">${fieldValue(bean: personAuthorityInstance, field: "authority")}</g:link></td>
					
						<td>${fieldValue(bean: personAuthorityInstance, field: "person")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${personAuthorityInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
