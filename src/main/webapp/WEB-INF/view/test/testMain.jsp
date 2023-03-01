<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <%@ include file="../common/heading.jsp" %>
</head>

<body style="margin-bottom:100px">
	<%@ include file="../common/aside.jsp" %>
	<div class="container-fluid">
		<header id="header">
			<a href="/goodM/user/main" class="logo"><strong><img src="/img/logo.png" alt="" width="30px" height="30px"></strong> by 멀캠가네 둘째 조</a>
		</header>
		<!-- Content -->
		<!-- 제목 -->
		<h2>자가진단 테스트</h2>
		<button type="button" class="btn">조기정신증(CAPE-15)</button>
		<button type="button" class="btn">조기정신증(mKPQ-16)</button>
		<button type="button" class="btn">우울증(PHQ-9)</button>
		<button type="button" class="btn">조울증(K-MDQ)</button>
		<button type="button" class="btn">불안증(GAD-7)</button>
		<button type="button" class="btn">알코올(AUDIT-K)</button>
		<button type="button" class="btn">인터넷게임(IGUESS)</button>
		<button type="button" class="btn">스트레스(PSS)</button>
		
			
	</div>
<%@ include file="../common/bottom.jsp" %>
</body>
</html>