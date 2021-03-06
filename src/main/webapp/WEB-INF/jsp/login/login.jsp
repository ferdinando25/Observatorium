<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="<c:url value='/resource/css/login.css'/>">
	
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900'>
	<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/css?family=Montserrat:400,700'>
	<link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
	
	<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="info">
    			[PLACE HOLDER]
  		</div>
	</div>
	<div class="form">
  		<div class="thumbnail">[PH]</div>
  		<c:forEach var="error" items="${errors}">
  			<div class="erro">${error.category}</div>
		</c:forEach>
  		<form  action ="<c:url value="/login/autenticar" />"  method="post" class="login-form">
	    		<input name ="usuario.usu_email" type="text" placeholder="usuário"/>
	    		<input name ="usuario.usu_senha" type="password" placeholder="senha"/>
	    		<button type="submit" name="buttonLogin">login</button>
  		</form>
  		<p class="message">Não Registrado? <a href="<c:url value="/cadastrar/usuario" />">Cadastre-se aqui</a></p>
	</div>
</body>
</html>