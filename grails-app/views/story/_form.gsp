



<div class="fieldcontain ${hasErrors(bean: storyInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="story.name.label" default="Name" />
		
	</label>
	<g:textField name="name" maxlength="45" value="${storyInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: storyInstance, field: 'description', 'error')} ">
	<label for="description">
		<g:message code="story.description.label" default="Description" />
		
	</label>
	<g:textField name="description" maxlength="45" value="${storyInstance?.description}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: storyInstance, field: 'requirements', 'error')} ">
	<label for="requirements">
		<g:message code="story.requirements.label" default="Requirements" />
		
	</label>
	<g:select name="requirements" from="${Requirement.list()}" multiple="multiple" optionKey="id" size="5" value="${storyInstance?.requirements*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: storyInstance, field: 'startDate', 'error')} required">
	<label for="startDate">
		<g:message code="story.startDate.label" default="Start Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="startDate" precision="day"  value="${storyInstance?.startDate}"  />
</div>

