<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />
        <spring:url value="/resources/common.css" var="common" />
        <link href="${common}" rel="stylesheet" />
<title>Categories List</title>
</head>
<body>
<div class="container">
<div class="row">
	<div class="col-md-12">
	<label for="product_id">Add Category</label>
    <input type="text" name="category" id="category" placeholder="Category"/>
    <button id="AddButton" name="AddButton">Add</button>
</div>
</div>
</div>


<button id="DeleteButton" name="DeleteButton">Delete</button>
<table id="categoriesTable" class="display" cellspacing="0" width="100%" style="overflow-x:auto">
 
<thead>
 
<tr>
<th>Category ID</th>
 
<th>Name</th>
 
</tr>
 
</thead>
</table>
<script>
$(document).ready(function(){
var data =eval('${categories}');
var table = $('#categoriesTable').DataTable( {
"aaData": data,
"aoColumns": [
{ "mData": "category_id"},
{ "mData": "category_name"}
]
});
$("#categoriesTable tbody").on('click', 'tr', function(){
	if($(this).hasClass('selected')){
		$(this).removeClass('selected');
	}
	else{
		$(this).addClass('selected');
	}
});

$("#AddButton").click(function(){
	var value = $("#category").val();
	window.location = "http://localhost:18080/PMP-backend/categories/add/"+value+"";
})

$("#DeleteButton").click(function(){
	var ids = "";
	var arr = table.rows('.selected').data();
	Array.from(arr).forEach(function(row){
		ids=row["category_id"]+","+ids;
	});
	window.location ="http://localhost:18080/PMP-backend/categories/delete?ids="+ids+"";
});
});
</script>
</body>
</html>