<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller Details</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<spring:url value="/resources/form-style.css" var="common" />
        <link href="${common}" rel="stylesheet" />
</head>
<body>
	<div class="container">
  <h2>Seller: ${seller.owner_name}</h2>
  <form action="" name="details">

    <label for="seller_id">Seller ID</label>
    <input type="text" name="seller_id" id="seller_id" value="${seller.seller_id}" disabled/>

    <label for="name">Name</label>
    <input type="text" name="name" id="name" value="${seller.owner_name}" disabled/>

    <label for="company_name">Company Name</label>
    <input type="text" name="company_name" id="company_name" value="${seller.company_name}" disabled/>

    <label for="address">Address</label>
    <input type="text" name="address" id="address" value="${seller.address}" disabled/>
    
    <label for="email">Email</label>
    <input type="email" name="email" id="email" value="${seller.email}" disabled/>
    
    <label for="telephone">Telephone</label>
    <input type="text" name="telephone" id="telephone" value="${seller.telephone}" disabled/>
    
    <label for="status">Status</label>
    <select name="status" id="status">
      <option value="NEED_APPROVAL">Need Approval</option>
      <option value="APPROVED">Approved</option>
      <option value="REJECTED">Rejected</option>
     </select>

    <button type="submit">Update Status</button>

  </form>
</div>

<script>
	$("#status").selectmenu();
	$("#status").val("${seller.status}");
	$("#status").selectmenu("refresh");
</script>
</body>
</html>