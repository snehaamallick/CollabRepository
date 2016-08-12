<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML>

<html>
<head>
<title>userdetails</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery.js"></script>
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css">
<script type="text/javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	 <script src="http://code.angularjs.org/1.4.8/angular.js"></script>  
   <script src="http://code.angularjs.org/1.4.8/angular-resource.js"></script>  
   <script src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>  
   <script>  
     var app = angular.module('MyForm', ['ui.bootstrap', 'ngResource']);  
     app.controller('myCtrl', function ($scope) {  
       $scope.predicate = 'name';  
       $scope.reverse = true;  
       $scope.currentPage = 1;  
       $scope.order = function (predicate) {  
         $scope.reverse = ($scope.predicate === predicate) ? !$scope.reverse : false;  
         $scope.predicate = predicate;  
       };  
       $scope.users = ${myJson};  //This code is extracting the string object being sent from controller
       $scope.totalUsers = $scope.users.length;  
       $scope.numPerPage = 5;  
       $scope.paginate = function (value) {  
         var begin, end, index;  
         begin = ($scope.currentPage - 1) * $scope.numPerPage;  
         end = begin + $scope.numPerPage;  
         index = $scope.users.indexOf(value);  
         return (begin <= index && index < end);  
       };  
     });  
   </script>  
</head>
<body>
	<!--  ========= Table to populate data ======= -->
	<body ng-app="MyForm">  
   <div ng-controller="myCtrl">  
     <h3>List of Users</h3>  
     <div class="container-fluid">  
       <hr />  
       <table class="table table-striped">  
          <thead>  
           <tr>  
            <!-- Heading Part -->   
             <th>  
               <a href="" ng-click="order('username')">User Name</a>  
             </th>  
             <th><a href="" ng-click="order('name')">Name</a> </th>  
             <th><a href="" ng-click="order('email')">Email</a> </th>  
                
                       
           </tr>  
         </thead>
         <tbody>  
         <!-- Search Box -->
           <tr>    
            <td> <input type="text" ng-model="search.username" /></td>
             <td> <input type="text" ng-model="search.name" /> </td>  
              <td><input type="text" ng-model="search.username" /> </td>    
            </tr>  
        
 <tr ng-repeat="element in users | orderBy:predicate:reverse | filter:paginate| filter:search" ng-class-odd="'odd'">
       
          
        
             <!-- Content Part --> 
             <td>{{element.username}}</td>  
             <td>{{element.name}}</td>  
             <td>{{element.email}}</td> 
              <td><a href="<c:url value='/edit/{{element.userid}}' />" >Edit</a></td>
            	<td><a href="<c:url value='/remove/{{element.userid}}' />" >Delete</a></td>
           </tr>
       
         </tbody>  
       </table>  
       <pagination total-items="totalItems" ng-model="currentPage"  
             max-size="5" boundary-links="true"  
             items-per-page="numPerPage" class="pagination-sm">  
       </pagination>  
     </div>    
	

</body>

</html>