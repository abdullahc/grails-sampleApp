



<div class="fieldcontain ${hasErrors(bean: requirementInstance, field: 'title', 'error')} ">
	<label for="title">
		<g:message code="requirement.title.label" default="Title" />
		
	</label>
	<g:textField name="title" maxlength="45" value="${requirementInstance?.title}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: requirementInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="requirement.description.label" default="Description" />
		
	</label>
	<g:textField name="description" maxlength="45" value="${requirementInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: requirementInstance, field: 'stories', 'error')} ">
	<label for="stories">
		<g:message code="requirement.stories.label" default="Stories" />
		
	</label>
	
</div>

