<!DOCTYPE html>
<html>
<body>

The start of experiments
	<g:render template="form" contextPath ="/leaderboard"/>
	
	<g:set var="num" value="${1}" />
		<g:while test="${num < 5 }">
		    <p>Number ${num++}</p>
		</g:while>
	</body>
</html>
