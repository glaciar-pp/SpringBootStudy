<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
	<script src="/js/chatForm.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/chatbot.css">
	<%@ include file="../common/heading.jsp" %>
	<style>
		th, td { text-align: center; }
	</style>
</head>
<body>
	<%@ include file="../common/top.jsp" %>
    <div id="wrap" style="margin-top: 80px;">
      <!-- Header -->
      <div id="chatHeader">
        <span>챗봇</span>
        <button id="btnClose">X</button>
      </div>
    <h3>챗봇 서비스</h3>

    <!-- 응답 메시지 출력  -->
    <div id="chatBox"></div><br>

    <!-- 질문 메시지 입력 폼 -->
    <form id="chatForm">
      <input type="text" id="message" name="message" size="30" placeholder="질문을 입력하세요">
      <input type="submit" value="전송">
    </form>
    <br><br>
    <a href="/">index 페이지로 이동</a>
    </div>
    
     <%@ include file="../common/bottom.jsp" %>
  </body>
</html>