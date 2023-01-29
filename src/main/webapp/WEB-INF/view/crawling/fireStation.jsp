<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>food Ingredients Detect</title>
</head>
<body>
	<h3>식재료 찾기</h3>
	<hr>
	<table border="1">
		<tr>
			<th>No.</th><th>이름</th><th>주소</th><th>전화번호</th>
		</tr>
	<c:forEach var="station" items="${stationList}" varStatus="loop">
		<tr>
			<td>${loop.count}</td>
			<td>${station.name}</td>
			<td>${station.addr}</td>
			<td>${station.tel}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>