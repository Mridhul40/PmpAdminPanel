<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet" />
        <spring:url value="/resources/common.css" var="common" />
        <link href="${common}" rel="stylesheet" />
<title>Products List</title>
</head>
<body>
<button id="ApproveButton" name="ApproveButton">Approve</button>
<button id="RejectButton" name="RejectButton">Reject</button>
<table id="productsTable" class="display" cellspacing="0" width="100%" style="overflow-x:auto">
 
<thead>
 
<tr>

<th>Product</th>

<th>Product Code </th>
 
<th>Name</th>
 
<th>Short Description</th>
 
<th>Long Description</th>
 
<th>Dimensions</th>

<th>Catergory</th>

<th>Price</th>

<th>Status</th>
 
</tr>
 
</thead>
</table>
<script>
$(document).ready(function(){
var data =eval('${products}');
var table = $('#productsTable').DataTable( {
"aaData": data,
"aoColumns": [
{ "mData": "primary_image", "render": function(data){ return "<img src='"+data+"' height='50px' width='50px'></img>"}},
{ "mData": "product_id"},
{ "mData": "name"},
{ "mData": "short_description"},
{ "mData": "long_description"},
{ "mData": "dimensions"},
{ "mData": "categories"},
{ "mData": "ymp"},
{ "mData": "status"}
]
});

$("#productsTable tbody").on('click', 'tr', function(){
	if($(this).hasClass('selected')){
		$(this).removeClass('selected');
	}
	else{
		$(this).addClass('selected');
	}
});

$("#productsTable tbody").on('dblclick', 'tr', function(){
	productid = this.childNodes[1].innerText;
	window.location = "http://localhost:18080/PMP-backend/products/details/"+productid+"";
});


$("#ApproveButton").click(function(){
	var ids = "";
	var arr = table.rows('.selected').data();
	Array.from(arr).forEach(function(row){
		ids=row["product_id"]+","+ids;
	});
	window.location ="http://localhost:18080/PMP-backend/products/status/APPROVED?ids="+ids+"";
});

$("#RejectButton").click(function(){
	var ids = "";
	var arr = table.rows('.selected').data();
	Array.from(arr).forEach(function(row){
		ids=row["product_id"]+","+ids;
	});
	window.location ="http://localhost:18080/PMP-backend/products/status/REJECTED?ids="+ids+"";
});
});
</script>
</body>
</html>