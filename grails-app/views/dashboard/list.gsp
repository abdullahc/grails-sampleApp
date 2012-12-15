<!DOCTYPE html>
<html>
<head>

		<r:require module="jquery-ui"/>
		<r:require module="backbone"/>
		<r:layoutResources />

    <script type="text/javascript">
        $(document).ready(function()
        {
          $("#datepicker").datepicker({dateFormat: 'yy/mm/dd'});
        })
    </script>

</head>
<body>
<g:set var="entityName" value="${message(code: 'project.label', default: 'Project')}" />
This is just straight gsp
	<g:render template="form"></g:render>
	
	<g:set var="num" value="${1}" />
		<g:while test="${num < 5 }">
		    <p>Number ${num++}</p>
		</g:while>
               Example of getting model data from controller function
                  
				<g:each var="requirement" in="${requirementInstanceList}"> 
						${requirement.description}<br/> 
						${requirement.title}<br/> 
				<hr/> 
				</g:each> 

	Example of loading Jquery UI 2
	<div id="datepicker"></div>
	
	Exmample of Jquery Ajax call
	<div id="ajaxResult">the result  </div>
	
	

	<script type="text/javascript">

	function refresh(){

	$("#ajaxResult").html("Results: <br>");
	$.ajax({
		  type: "GET",
		  url: "${request.contextPath}/dashboard/ajax",
		  data: { name: "John", location: "Boston" }
		}).done(function( msg ) {
		      $.each(msg["results"], function(index) {
			      
				  $("#ajaxResult").append(msg["results"][index]["description"]);
				  $("#ajaxResult").append("<br>");
		        });

		});

	}
	
	</script>
	
	<a href="#" onclick= "javascript:refresh()"> refresh here</a>
	
	
<g:applyLayout name="empty">
  <g:include controller="requirement" action="create"/>
</g:applyLayout>



	
	
	
	
	</body>
	
</html>
