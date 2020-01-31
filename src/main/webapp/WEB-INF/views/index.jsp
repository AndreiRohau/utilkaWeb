<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- CSS & JS-->
<spring:url value="/resources/js/jquery-3.3.1.js" var="jquery_3_3_1_js" />
<script src="${jquery_3_3_1_js}" type="text/javascript"></script>
<spring:url value="/resources/css/bootstrap.css" var="bootstrap" />
<link href="${bootstrap}" rel="stylesheet" />
<spring:url value="/resources/css/bootstrap.css.map" var="bootstrap_map" />
<link href="${bootstrap_map}" type="text/plain" />

<spring:url value="/resources/js/index.js" var="image_js" />
<script src="${image_js}" type="text/javascript"></script>
<spring:url value="/resources/css/index.css" var="image_css" />
<link href="${image_css}" rel="stylesheet" />

<title>Upload image</title>
</head>
<body>

	<hr/>
	<hr/>

	<form id="addCarForm" name="addCarForm" action="${pageContext.request.contextPath}/car/add/" method="POST">
		<div class="form-group">
			<label>
				<input form="addCarForm" class="btn btn-default" type="text" placeholder="name" name="name"/>
			</label>
			<label>
				<input form="addCarForm" class="btn btn-default" type="text" placeholder="price" name="price"/>
			</label>
			<input form="addCarForm" class="btn btn-default" type="button" value="addCar" onclick="addCar()">
		</div>
	</form>

	<form id="getAllCarsForm" name="getAllCarsForm" action="${pageContext.request.contextPath}/car/getAll" method="GET">
		<div class="form-group">
			<input class="btn btn-default" type="button" value="Get all images" onclick="getAllCars()">
		</div>
	</form>

	<div id="carsContainer" onchange="countTotalPrice()"></div>

	<div id="totalPrice">
		<!-- EMPTY - total price -->
	</div>

	<hr/>
	<hr/>
</body>
</html>