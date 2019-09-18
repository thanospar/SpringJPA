<%-- 
    Document   : trainers
    Created on : Jul 5, 2019, 12:08:35 PM
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
        <title>Trainers</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/uikit/3.1.6/css/uikit.min.css" />
         <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
        <script type="text/javascript" language="javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>  
        
        <script type="text/javascript">
            $(document).ready(function () {
                $('#trainers').DataTable();
            });
        </script>

    </head>
    <body>
        <div class="uk-section uk-section-medium uk-section-muted ">
            <div class="uk-container uk-container-expand">
                <h2 class=" uk-padding-small uk-text-center">Trainers</h2>
                <span class="green" uk-icon="user">Admin</span>

                <a class="uk-button uk-button-primary" href="<c:url value='/register' />">Add New </a>
                <!--        <p> </p>-->
                <table id="trainers" class="uk-table uk-table-hover uk-table-divider">
                    <thead>
                        <tr>
                            <th>Firstname</th>
                            <th>Lastname</th>
                            <th>Subject</th>

                            <th width="100"></th>
                            <th width="100"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="tr">
                            <tr>
                                <td>${tr.firstName}</td>
                                <td>${tr.lastName}</td>
                                <td>${tr.subject}</td>

                                <td><a href="<c:url value='/edit-${tr.trainerId}-trainer' />" class="uk-button uk-button-default 

                                       custom-width">edit</a></td>
                                <td><a href="<c:url value='/delete-${tr.trainerId}-trainer' />" class="uk-button uk-button-danger	 

                                       custom-width">delete</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
       <script src="/static/js/uikit-icons.js"></script>
    </body>
</html>
