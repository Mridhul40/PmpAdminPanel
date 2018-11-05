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
<title>Sellers List</title>
</head>
<body>
<button id="ApproveButton" name="ApproveButton">Approve</button>
<button id="RejectButton" name="RejectButton">Reject</button>
<table id="sellersTable" class="display" cellspacing="0" width="100%" style="overflow-x:auto">
 
<thead>
 
<tr>
<th>Seller ID</th>
 
<th>Name</th>
 
<th>Company Name</th>
 
<th>Address</th>
 
<th>Email</th>

<th>Telephone</th>

<th>Status</th>
 
</tr>
 
</thead>
</table>
<script>
$(document).ready(function(){
var data =eval('${sellers}');
var table = $('#sellersTable').DataTable( {
"aaData": data,
"aoColumns": [
{ "mData": "seller_id"},
{ "mData": "owner_name"},
{ "mData": "company_name"},
{ "mData": "address"},
{ "mData": "email"},
{ "mData": "telephone"},
{ "mData": "status"}
]
});

$("#sellersTable tbody").on('click', 'tr', function(){
	if($(this).hasClass('selected')){
		$(this).removeClass('selected');
	}
	else{
		$(this).addClass('selected');
	}
});

$("#sellersTable tbody").on('dblclick', 'tr', function(){
	sellerid = this.childNodes[0].innerText;
	window.location = "http://localhost:18080/PMP-backend/sellers/details/"+sellerid+"";
});

$("#ApproveButton").click(function(){
	var ids = "";
	var arr = table.rows('.selected').data();
	Array.from(arr).forEach(function(row){
		ids=row["seller_id"]+","+ids;
	});
	window.location ="http://localhost:18080/PMP-backend/sellers/status/APPROVED?ids="+ids+"";
});

$("#RejectButton").click(function(){
	var ids = "";
	var arr = table.rows('.selected').data();
	Array.from(arr).forEach(function(row){
		ids=row["seller_id"]+","+ids;
	});
	window.location ="http://localhost:18080/PMP-backend/sellers/status/REJECTED?ids="+ids+"";
});
});
</script>
</body>
</html>