<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <style>
  td
{
  padding-top: 10px;
  padding-bottom: 10px;}
  </style>
</head>
<body>

<c:url var="addAction" value="/openforum/addforum" ></c:url>
<div align="center">
		<form:form action="${addAction}" method="POST" commandName="forum">
<table >
<tr>
                    <td colspan="2" align="center"><h2>Create New Forum:</h2></td>
                </tr>
                
                
                
                
         <tr>
        
        <td><label for="category">Category</label>
                <label class="checkbox-inline"><form:radiobutton path="fCategory" id="category" value="java" />Java</label>
                <label class="checkbox-inline"><form:radiobutton path="fCategory" id="category" value="springmvc" />Spring MVC</label>
                <label class="checkbox-inline"><form:radiobutton path="fCategory" id="category" value="angularjs" />AngularJS</label></td>
    </tr>
                
                
<tr>
        <td>Add Title :</td>
        <td><form:textarea style="width: 300px; height: 35px;" path="fTitle"/></td>
    </tr>
    <tr>
        <td>Add Blog :</td>
        <td><form:textarea style="width: 300px; height: 150px;" path="fcontent"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="submit" value="Add Forum"></td>
    </tr>
</table>
</form:form>


</body>
</html>