<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value='/static/css/tutorial.css'/>" type="text/css" />
<title>Secured Page</title>
</head>
<body>
<div>
<h1>Secure Page</h1>
<p>This is a protected page and it can be viewed only after successfully autheticated.</p>
<p><a href="../">Go back</a></p>
<p><a href="../j_spring_security_logout">Logout</a></p>
</div>
</body>
</html>