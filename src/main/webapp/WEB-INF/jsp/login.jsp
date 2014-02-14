<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Login Page</title>
</head>
<body>
<h3>Login</h3>
<c:if test="${not empty param.error}">
  <p style="color:red;">
    Login attempt was not successful: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
  </p>
</c:if>
<form action="<c:url value='j_spring_security_check' />" method='POST'>
  <table>
    <tbody>
      <tr>
        <th>User:</th>
        <td><input type='text' name='j_username' value=''/></td>
      </tr>
      <tr>
        <th>Password:</th>
        <td><input type='password' name='j_password' /></td>
      </tr>
      <c:if test="${not empty captchaEnc}">
        <tr>
          <th>Captcha:</th>
          <td>
            <img src="data:image/png;base64,${captchaEnc}"/></br>
            <input type='text' name='j_captcha' />
          </td>
        </tr>
      </c:if>
      <tr>
        <td colspan='2'><input name="submit" type="submit" value="Login" /></td>
      </tr>
    </tbody>
  </table>
</form>
</body>
</html>