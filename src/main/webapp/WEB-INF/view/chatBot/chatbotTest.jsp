<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
    <title>chatbotTest demo</title>
    <script src="https://unpkg.com/vue"></script>
    <script src="/js/chatbotTest.umd.min.js"></script>
    <link rel="stylesheet" href="/css/chatbotTest.css">
	<%@ include file="../common/heading.jsp" %>
    <style>
        th, td { text-align: center; }
    </style>
    
</head>
<body>
<%@ include file="../common/top.jsp" %>

    <div class="container" style="margin-top: 80px;">
        <div class="row">
            <%@ include file="../common/aside.jsp" %>
            
            <!-- =================== main =================== -->
<form action="/goodM/chatbotTest" method="post" enctype="multipart/form-data">
  <div id="app"></div>
  <script type="text/javascript">
    window.onload=function () {
      const chatBot = chatbotTest.build({
        el: '#app',
        apiUrl: 'https://ex9av8bv0e.apigw.ntruss.com/custom_chatbot/prod/',
        apiVersion: 'v2',
        apiToken: 'aXNtRHVoU1pWbk5Rc3VSZUtEc2hpeWR6SHBweWdrekU=',
        log: true,
        callbacks: {
          success: function (res) {
            const question = res[0];
            const answer = res[1];
            console.log('test reply question : ', question);
            console.log('test reply answer : ', answer);
          },
          error: function (err) {
            console.log('test reply error response: ', err);
          }
        }
      });
      chatBot.sendParamsConfig('open');
    }
  </script>
</form>
  </div>
  </div>
      <%@ include file="../common/bottom.jsp" %>
</body>
</html>