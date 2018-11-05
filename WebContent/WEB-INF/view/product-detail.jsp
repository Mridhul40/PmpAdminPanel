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
  <h2>Product: ${product.name} by ${product.seller.company_name}</h2>
  <div class="row" style="display:inline-flex">
  	<div class="col-md-4">
  		<img src="${product.primary_image}"></img>
  	</div>
  	<div class="col-md-8">
  		<form action="" name="details">

    <label for="product_id">Product ID</label>
    <input type="text" name="product_id" id="product_id" value="${product.product_id}" disabled/>

    <label for="name">Name</label>
    <input type="text" name="name" id="name" value="${product.name}" disabled/>

    <label for="short_desc">Short Description</label>
    <input type="text" name="short_desc" id="short_desc" value="${product.short_description}" disabled/>

    <label for="long_desc">Long Description</label>
    <input type="text" name="long_desc" id="long_desc" value="${product.long_description}" disabled/>
    
    <label for="dimensions">Dimensions</label>
    <input type="text" name="dimensions" id="dimensions" value="${product.dimensions}" disabled/>
    
    <label for="categories">Category</label>
    <input type="text" name="categories" id="categories" value="${product.categories}" disabled/>
    
    <label for="price">Price</label>
    <input type="text" name="price" id="price" value="${product.ymp}" disabled/>
    
    <label for="status">Status</label>
    <select name="status" id="status">
      <option value="NEW">New</option>
      <option value="APPROVED">Approved</option>
      <option value="REJECTED">Rejected</option>
      <option value="REVIEW">Review</option>
     </select>

    <button type="submit">Update Status</button>

  </form>
  	</div>
  </div>
  
</div>

<script>
	$("#status").selectmenu();
	$("#status").val("${product.status}");
	$("#status").selectmenu("refresh");
</script>
</body>
</html>