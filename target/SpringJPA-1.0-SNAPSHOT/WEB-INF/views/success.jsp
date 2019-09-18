<%-- 
    Document   : success
    Created on : Jul 8, 2019, 10:54:37 AM
    Author     : thanosparaskevas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Success</title>
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/css/uikit.min.css" />

    </head>
    <body>
        <div class="success">
		Confirmation message : ${success}
		<br>
		
               <a class="uk-button uk-button-primary" href="<c:url value='/trainers' />">Back to trainers</a>
	</div>
    </body>
</html>
