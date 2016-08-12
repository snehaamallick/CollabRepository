<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
</head>
<body>
 
 <div class="container">
 <h2 style="font-family:forte ;color:#1A5880;">SIGN UP!</h2>
<c:url var="addAction" value="/register/add" ></c:url>
<form:form action="${addAction}" commandName="user" method="POST">
<form role="form">
<table>
    <c:if test="${!empty name}">
    <tr>
        <td>
            <form:label path="userid">
                <spring:message text="User ID"/>
            </form:label>
        </td>
        <td>
            <form:input path="userid" readonly="true" size="8"  disabled="true" />
            <form:hidden path="userid" />
        </td> 
    </tr>
    </c:if>
    <tr>
     
        <td>
            
            <form:label path="name" >
                <spring:message text="Name"/>
            </form:label>
        </td>
        <td>
        <div class="form-group">
            <form:input path="name" class="form-control" id="name" placeholder="Enter Name"/>
             </div>
        </td> 
        
    </tr>
   
    <tr>
        <td>
            <form:label path="email">
                <spring:message text="Email ID"/>
            </form:label>
        </td>
        <td>
        <div class="form-group">
            <form:input path="email" class="form-control" id="name" placeholder="Enter Email"/>
            </div>
        </td>
    </tr>
    <tr>
        <td>
            <form:label path="username">
                <spring:message text="User Name"/>
            </form:label>
        </td>
        <td>
        <div class="form-group">
            <form:input path="username"  class="form-control" id="name" placeholder="Enter User Name" />
            </div>
        </td>
    </tr>
    
    <tr>
        <td>
            <form:label path="password">
                <spring:message text="Password"/>
            </form:label>
        </td>
        <td>
        <div class="form-group">
            <form:input path="password" class="form-control" id="name" placeholder="Enter Password"/>
            </div>
        </td>
    </tr>
    <tr>
        <td colspan="2">
            <c:if test="${empty name}">
                <input type="submit" class="btn btn-default"
                    value="<spring:message text="Register"/>"/>
            </c:if>
        </td>
    </tr>
</table>  
</form>
</form:form>
</div>

<a href="signin" id="link" class="btn btn-success" role="button">Login</a>
 <!--  ========= footer======= -->
	
</body>
</html>