<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script type="text/javascript">
    function count(type)  {
    	  // 결과를 표시할 element
    	  const resultElement = document.getElementById('result');
    	  
    	  // 현재 화면에 표시된 값
    	  let number = resultElement.innerText;
    	  
    	  // 더하기/빼기
    	  if(type === 'plus') {
    	    number = parseInt(number) + 1;
    	  }else if(type === 'minus')  {
    	    number = parseInt(number) - 1;
    	  }
    	  
    	  // 결과 출력
    	  resultElement.innerText = number;
    	}
    </script>
</head>
<body>
<!--     <button onclick="count">입장</button> -->
    <input type='button'
       onclick='count("plus")'
       value='+'/>
	<input type='button'
	       onclick='count("minus")'
	       value='-'/>
	<div id='result'>0</div>
</body>
</html>