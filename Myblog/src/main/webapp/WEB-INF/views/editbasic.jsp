<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="inlineheader.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Edit Product</h1>


            <p class="lead">Please update the product information here:</p>
        </div>

        <c:url var="addAction" value="/adminpage/add"></c:url>
	<form:form action="${addAction}" commandName="student" enctype="multipart/form-data" method="POST">
		<table>
			<c:if test="${!empty user.email}">
				<tr>
					<td><form:label path="userId">
							<spring:message text="ID" />
						</form:label></td>
					<td><form:input path="userId" readonly="true" size="8"
							disabled="true" /> <form:hidden path="userId" /></td>
				</tr>
			</c:if>
			<tr>
				<td><form:label path="email">
						<spring:message text="Email" />
					</form:label></td>
				<td><form:input path="email" /></td>
				<td align="left"><form:errors path="email" cssClass="error"/></td>
			</tr>
			<tr>
				<td><form:label path="password">
						<spring:message text="Password" />
					</form:label></td>
				<td><form:password path="password" /></td>
				 <td align="left"><form:errors path="password" cssClass="error"/></td>
			</tr>
			
			
			<tr>
				<td colspan="2"><c:if test="${!empty user.email}">
						<input type="submit" value="<spring:message text="Edit Student"/>" />
					
					</c:if></td>
			</tr>
			<tr>
    	
		</table>
	</form:form>

