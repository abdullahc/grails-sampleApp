



<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="project.name.label" default="Name" />
		
	</label>
	<g:textField name="name" maxlength="45" value="${projectInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="project.description.label" default="Description" />
		
	</label>
	<g:textField name="description" maxlength="45" value="${projectInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'url', 'error')} ">
	<label for="url">
		<g:message code="project.url.label" default="Url" />
		
	</label>
	<g:textField name="url" maxlength="45" value="${projectInstance?.url}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'stories', 'error')} ">
	<label for="stories">
		<g:message code="project.stories.label" default="Stories" />
		
	</label>
	<g:select name="stories" from="${Story.list()}" multiple="multiple" optionKey="id" size="5" value="${projectInstance?.stories*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'users', 'error')} ">
	<label for="users">
		<g:message code="project.users.label" default="Users" />
		
	</label>
	<g:select name="users" from="${User.list()}" multiple="multiple" optionKey="id" size="5" value="${projectInstance?.users*.id}" class="many-to-many"/>
</div>

