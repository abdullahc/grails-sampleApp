

<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'story.label', default: 'Story')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-story" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-story" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list story">
			
				<g:if test="${storyInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="story.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${storyInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${storyInstance?.description}">
				<li class="fieldcontain">
					<span id="description-label" class="property-label"><g:message code="story.description.label" default="Description" /></span>
					
						<span class="property-value" aria-labelledby="description-label"><g:fieldValue bean="${storyInstance}" field="description"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${storyInstance?.requirements}">
				<li class="fieldcontain">
					<span id="requirements-label" class="property-label"><g:message code="story.requirements.label" default="Requirements" /></span>
					
						<g:each in="${storyInstance.requirements}" var="r">
						<span class="property-value" aria-labelledby="requirements-label"><g:link controller="requirement" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${storyInstance?.id}" />
					<g:link class="edit" action="edit" id="${storyInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
