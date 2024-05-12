<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>인사평가</title>
  <!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"> -->
  <!-- <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet"> -->
</head>
<link rel="stylesheet" href="emplist.css">
<body>
  <!-- <script src="https://kit.fontawesome.com/a81368914c.js"></script> -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<c:set value="${fn:length(emplist)}" var="empSize"></c:set>

  <div class="div_head">
    <h1>
      <img id="shinhan"src="../log/신한마크-removebg-preview.png" alt="신한마크 이미지" width="50" height="50">
      사원관리 프로그램<span class="smalltitle">(인사관리)</span>
    </h1>
  </div>
  <p>기본정보</p>
  <div class="inner_body">
		<button onclick="sidebar.open()"><img id="menu_img" alt="메뉴" src="Vector.png" width="10" height="7">
    </button>
   <aside class="side_bar js-side_bar">
    <div id="sidebarText">
    <ul id="check_menu" style="list-style: none">
	    <li><p class="sidebarFont">평가 항목 메뉴</p>
        <ul style="list-style: none;">
           <li><a href="../check/checklist.do" class="sidebarAtag">조회</a></li>         
        </ul>
	   </li>
   	</ul>
        <button onclick="sidebar.close()">Close</button>
    </div>
    </aside>
    <!-- 오버레이 요소 추가 -->
  <div class="overlay" onclick="sidebar.close()"></div>
</div>
  <table border="1" id="table1">
    <caption>기업정보</caption>
        <tr class="table1_tr1">
          <th>회사명</th>
          <td>신한DS 금융SW아카데미</td>
        </tr>
        <tr>
          <th>대표자</th>
          <td>정진</td>
        </tr>
        <tr class="table1_tr3">
          <th>소재지</th>
          <td>서울시 마포구 월드컵북로4길 77</td>
        </tr>
  </table>
  <table border="1" id="table2">
    <caption>담당자 정보</caption>
        <tr class="table2_tr1">
          <th>부서명</th>
          <td>3기 6회차</td>
        </tr>
        <tr>
          <th>직급</th>
          <td>교육생</td>
        </tr>
        <tr>
          <th>성명</th>
          <td>권대현</td>
        </tr>
        <tr class="table2_tr4">
          <th>contect</th>
          <td>@daenim_</td>
        </tr>
  </table>
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
    <thead>
      <tr id="tr1">
        <th>사원번호</th>
        <th>성명</th>
        <th>생년월일</th>
        <th>부서명</th>
        <th>직급</th>
        <th>입사일</th>
      </tr>
    </thead>
    <tbody>
    		<c:forEach items="${emplist }" var="emp">
        <tr id="tr2" style="cursor:pointer;" onClick="location.href='../check/checkemp.do?empid=${emp.employee_id }'">
          <td>${emp.employee_id }</td>
          <td>${emp.name }</td>
          <td>${emp.birthdate }</td>
          <td>${emp.department }</td>
          <td>${emp.rank }</td>
          <td>${emp.join_date }</td>
        </tr>
    		</c:forEach>
    </tbody>
  </table>
  </div>
  <div class="page">
    <ul class="pagination modal">
      <li><a href="#" class="first">처음으로</a></li>
      <li id="leftArrow"><a href="#" class="arrow left">◀</a></li>
      <!-- <li><a href="#" class="active num">1</a></li>
      <li><a href="#" class="num">2</a></li>
      <li><a href="#" class="num">3</a></li>
      <li><a href="#" class="num">4</a></li>
      <li><a href="#" class="num">5</a></li> -->
      <li><a href="#" class="arrow right">▶</a></li>
      <li><a href="#" class="last">끝으로</a></li>
    </ul>
  </div> 

</body>
<script>
window.addEventListener('DOMContentLoaded', function () {
		rowsPerPage = 10; // 한 페이지에 보여질 행의 수
		table = document.getElementById('table3'); // 테이블 요소 가져오기
		tbody = table.querySelector('tbody'); // tbody 요소 가져오기
		rows = Array.from(tbody.querySelectorAll('tr')); // tbody의 모든 행 가져오기
		numOfContent = ${empSize};
		  /*const showButton = 5; */
		/*   const maxPage = Math.ceil(numOfContent / rowsPerPage);
		  let pageGroup = Math.ceil(currentPage / pageCount); */
		showButton = 5;
		pageGroup = 1;
	});
</script>
<script src="emplist.js"></script>

</html>