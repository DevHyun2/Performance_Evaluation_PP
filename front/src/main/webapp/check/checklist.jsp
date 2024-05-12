<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인사평가</title>
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<link rel="stylesheet" href="checklist.css">
	<script src="checklist.js"></script>
</head>
<body>
<c:set value="${fn:length(checklist)}" var="checkSize"></c:set>
	<div class="div_head">
    <h1>
      <img id="shinhan"src="../log/신한마크-removebg-preview.png" alt="신한마크 이미지" width="50" height="50">
      사원관리 프로그램<span class="smalltitle">(인사관리)</span>
    </h1>
  </div>
<div id="container">
  <p>인사평가</p>
  <div id="table3Area">
  <div id="select_menu">
  <select name="select_option" id="select_option">
    <option value="all">전체</option>
    <option value="department">부서명</option>
    <option value="rank">직급명</option>
    <option value="employee_id">사원번호</option>
  </select>
  <input type="text" id="input_search">
  <button id="button_search" onclick="search()">조회</button>
</div>
  <table border="1" id="table3">
  		<caption>
  			인사 평가 항목
  			<button id="insertButton">항목 추가</button>
  			<button id="checkButton" onclick="checkDo()">평가 하기</button>
  		</caption>
    <thead>
      <tr id="tr1">
        <th>번호</th>
        <th>부서</th>
        <th>직급</th>
        <th>평가항목</th>
        <th>평가내용</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
    		<c:forEach items="${checklist }" var="check">
        <tr id="tr2">
          <td>${check.check_id }</td>
          <td>${check.department }</td>
          <td>${check.rank }</td>
          <td>${check.check_name }</td>
          <td>${check.description }</td>
          <td id="lasttd"><button id="deleteButton">삭제</button></td>
        </tr>
    		</c:forEach>
    </tbody>
  </table>
  </div>
  <div class="page">
    <ul class="pagination modal">
      <li><a href="#" class="first">처음으로</a></li>
      <li id="leftArrow"><a href="#" class="arrow left">◀</a></li>
      <li><a href="#" class="arrow right">▶</a></li>
      <li><a href="#" class="last">끝으로</a></li>
    </ul>
  </div>
 </div>
</body>
<script>
window.addEventListener('DOMContentLoaded', function () {
		rowsPerPage = 10; // 한 페이지에 보여질 행의 수
		table = document.getElementById('table3'); // 테이블 요소 가져오기
		tbody = table.querySelector('tbody'); // tbody 요소 가져오기
		rows = Array.from(tbody.querySelectorAll('tr')); // tbody의 모든 행 가져오기
		numOfContent = ${checkSize};
		  /*const showButton = 5; */
		/*   const maxPage = Math.ceil(numOfContent / rowsPerPage);
		  let pageGroup = Math.ceil(currentPage / pageCount); */
		showButton = 5;
		pageGroup = 1;
	});
</script>
<script src="checklist.js"></script>
</html>