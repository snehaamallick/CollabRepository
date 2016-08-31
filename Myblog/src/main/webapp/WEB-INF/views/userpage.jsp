<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link rel="stylesheet" href="my-style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>


<%@ include file='inlineheader.jsp'%>
<!--  ========= Body ========= -->
<br><br><br>
<table id="myTable" class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
                
                
                <th>Email</th>
                
                <th></th>
            </tr>
            </thead>
            <c:forEach items="${listfromtable}" var="user">
                <tr>
                    
                    <td>${user.email}</td>
                 
                    <td>
                        <a href="<spring:url value="/user/basicdetail/editdetail/${user.userId}" />"><span class="glyphicon glyphicon-pencil"></span></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
<a href="<spring:url value="/user/basicdetail/editdetail/${user.userId}" />"><span class="glyphicon glyphicon-pencil"></span></a>

<img src="resources/images/${param.user}.png" alt="unable to load"/>

 
  </body>
</html>