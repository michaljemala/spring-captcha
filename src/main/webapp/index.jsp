<%@ page session="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
<div>
 <h1>Home Page</h1>
 <p>Anyone can view this page.</p>
 <% if (request.getUserPrincipal() != null) { %>
 <p>Your are logged as: <%= request.getUserPrincipal().getName() %></p>
 <% } %>
 <sec:authorize url='/secure'>
 <p>You can currently access "/secure" URLs.</p>
 </sec:authorize>
 <p><a href="secure">Go to a secured page (bob/secret)</a></p>
</div>
</body>
</html>