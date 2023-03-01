<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
 <%@ include file="../common/heading.jsp" %>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
  <script type="text/javascript">
  function getScores() {
    const result = {};
    const questions = document.querySelectorAll('.question');
    questions.forEach((question, index) => {
      const qName = 's' + (index + 1);
      const qNodeList = question.querySelectorAll('input[name="' + qName + '"]:checked');
      let qScore = 0;
      qNodeList.forEach((node) => {
        qScore += parseInt(node.value);
      });
      result[qName] = qScore;
    }); 
    document.getElementById('result').innerText = JSON.stringify(result);
  }
</script>
</head>

<body style="margin-bottom:100px">
	<%@ include file="../common/aside.jsp" %>
	<div class="container-fluid">
		<header id="header">
			<a href="/goodM/user/main" class="logo"><strong><img src="/img/logo.png" alt="" width="30px" height="30px"></strong> by 멀캠가네 둘째 조</a>
		</header>
		<!-- Content -->
		<!-- 제목 -->
		<h2>정신건강 자가진단</h2>
	<p>지난 1년 동안 귀하가 가장 우울 또는 불안했거나 스트레스가 가장 많았던 한달을 떠올려 보십시오.<br>
    만약 그런 시기가 없었다면 지난 12개월 중 대표적인 달을 떠올려 주십시오.    
	</p>
    <table class="table">
		<tr>
			<th>항목</th>
			<th>한달내내</th>
			<th>한달 중 대부분</th>
			<th>한달 중 절반정도</th>
			<th>한달 중 며칠</th>
			<th>전혀 없었다</th>
		</tr>
		 <tr class="question">
		    <td >1. 아무런 이유없이 기운이 없던 적이 얼마나 됩니까?</td>
		    <td><input type="radio" name="s1" value="1"></td>
		    <td><input type="radio" name="s1" value="2"></td>
		    <td><input type="radio" name="s1" value="3"></td>
		    <td><input type="radio" name="s1" value="4"></td>
		    <td><input type="radio" name="s1" value="5"></td>
		</tr>
		<tr class="question">
		    <td>2. 신경이 예민했던 날은 얼마나 됩니까?</td>
		    <td><input type="radio" name="s2" value="1"></td>
		    <td><input type="radio" name="s2" value="2"></td>
		    <td><input type="radio" name="s2" value="3"></td>
		    <td><input type="radio" name="s2" value="4"></td>
		    <td><input type="radio" name="s2" value="5"></td>
		</tr>
		<tr class="question">
		    <td>3. 신경이 너무 예민해서 귀하를 안정시킬 수 있는 것이 아무것도 없다고 느끼신 적이 얼마나 됩니까?</td>
		    <td><input type="radio" name="s3" value="1"></td>
		    <td><input type="radio" name="s3" value="2"></td>
		    <td><input type="radio" name="s3" value="3"></td>
		    <td><input type="radio" name="s3" value="4"></td>
		    <td><input type="radio" name="s3" value="5"></td>
		</tr>
		<tr class="question">
		    <td>4. 희망이 없다고 느끼신 적이 얼마나 됩니까?</td>
		    <td><input type="radio" name="s4" value="1"></td>
		    <td><input type="radio" name="s4" value="2"></td>
		    <td><input type="radio" name="s4" value="3"></td>
		    <td><input type="radio" name="s4" value="4"></td>
		    <td><input type="radio" name="s4" value="5"></td>
		</tr>
		<tr class="question">
		    <td>5. 안절부절 못하거나 조바심을 냈던 적은 얼마나 됩니까?</td>
		    <td><input type="radio" name="s5" value="1"></td>
		    <td><input type="radio" name="s5" value="2"></td>
		    <td><input type="radio" name="s5" value="3"></td>
		    <td><input type="radio" name="s5" value="4"></td>
		    <td><input type="radio" name="s5" value="5"></td>
		</tr>
		<tr class="question">
		    <td>6. 안절부절 못하거나 조바심을 내서 가만히 앉아있을 수 없다고 느끼신 적이 얼마나 됩니까?</td>
		    <td><input type="radio" name="s6" value="1"></td>
		    <td><input type="radio" name="s6" value="2"></td>
		    <td><input type="radio" name="s6" value="3"></td>
		    <td><input type="radio" name="s6" value="4"></td>
		    <td><input type="radio" name="s6" value="5"></td>
		</tr>
		<tr class="question">
		    <td>7. 우울했던 적이 얼마나 됩니까?</td>
		    <td><input type="radio" name="s7" value="1"></td>
		    <td><input type="radio" name="s7" value="2"></td>
		    <td><input type="radio" name="s7" value="3"></td>
		    <td><input type="radio" name="s7" value="4"></td>
		    <td><input type="radio" name="s7" value="5"></td>
		</tr>
		<tr class="question">
		    <td>8. 우울하여 기운을 북돋을 수 있는 것이 아무것도 없다고 느끼신 적이 얼마나 됩니까?</td>
		    <td><input type="radio" name="s8" value="1"></td>
		    <td><input type="radio" name="s8" value="2"></td>
		    <td><input type="radio" name="s8" value="3"></td>
		    <td><input type="radio" name="s8" value="4"></td>
		    <td><input type="radio" name="s8" value="5"></td>
		</tr>
		<tr class="question">
		    <td>9. 매사가 힘들다고 느끼신 적은 얼마나 됩니까?</td>
		    <td><input type="radio" name="s9" value="1"></td>
		    <td><input type="radio" name="s9" value="2"></td>
		    <td><input type="radio" name="s9" value="3"></td>
		    <td><input type="radio" name="s9" value="4"></td>
		    <td><input type="radio" name="s9" value="5"></td>
		</tr>
		<tr class="question">
		    <td>10. 자신을 가치없는 사람처럼 느끼신 적은 얼마나 됩니까?</td>
		    <td><input type="radio" name="s10" value="1"></td>
		    <td><input type="radio" name="s10" value="2"></td>
		    <td><input type="radio" name="s10" value="3"></td>
		    <td><input type="radio" name="s10" value="4"></td>
		    <td><input type="radio" name="s10" value="5"></td>
		</tr>
    </table>

	<button onclick="getScores()">Get scores</button>
	<p id="result"></p>

</div>
<%@ include file="../common/bottom.jsp" %>
</body>
</html>