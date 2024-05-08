<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>EmpInfo</title>
  <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/a81368914c.js"></script>
</head>
<link rel="stylesheet" href="emplist.css">
<body>
  <div class="div_head">
    <h1>
      <img src="../log/신한마크-removebg-preview.png" alt="신한마크 이미지" width="50" height="50">
      사원관리 프로그램<span class="smalltitle">(인사관리)</span>
    </h1>
  </div>
  <p>기본정보</p>
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
  <div id="select_menu">
    <select name="select_option">
      <option>전체</option>
      <option>부서명</option>
      <option>직급명</option>
      <option>사원번호</option>
    </select>
    <input type="text">
  </div>
  <div id="table3Area">
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
        <tr id="tr2">
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
      <li><a href="#" class="arrow left">◀</a></li>
      <li><a href="#" class="active num">1</a></li>
      <li><a href="#" class="num">2</a></li>
      <li><a href="#" class="arrow right">▶</a></li>
      <li><a href="#" class="last">끝으로</a></li>
    </ul>
  </div>
</body>
<script>
  window.addEventListener('DOMContentLoaded', function () {
    const rowsPerPage = 10; // 한 페이지에 보여질 행의 수
    const table = document.getElementById('table3'); // 테이블 요소 가져오기
    const tbody = table.querySelector('tbody'); // tbody 요소 가져오기
    const rows = Array.from(tbody.querySelectorAll('tr')); // tbody의 모든 행 가져오기

    // 초기에는 처음 10개의 행만 보이도록 설정
    showRows(0, rowsPerPage);

    // 페이지 번호를 클릭할 때마다 호출되는 함수
    function handlePageClick(event) {
      event.preventDefault();
      const pageNum = parseInt(event.target.textContent); // 클릭한 페이지 번호 가져오기
      if (isNaN(pageNum)) return; // 숫자가 아닌 경우 처리
      const startIndex = (pageNum - 1) * rowsPerPage; // 해당 페이지의 시작 인덱스 계산
      const endIndex = startIndex + rowsPerPage; // 해당 페이지의 마지막 인덱스 계산
      showRows(startIndex, endIndex);
    }

    // 특정 범위의 행을 보이도록 설정하는 함수
    function showRows(start, end) {
      rows.forEach((row, index) => {
        if (index >= start && index < end) {
          row.style.display = ''; // 보이기
        } else {
          row.style.display = 'none'; // 숨기기
        }
      });
    }

    // 페이지 번호 링크에 이벤트 리스너 추가
    const pageLinks = document.querySelectorAll('.pagination.modal .num');
    pageLinks.forEach(link => {
      link.addEventListener('click', handlePageClick);
    });

    // 처음으로 버튼 이벤트 리스너 추가
    const firstButton = document.querySelector('.pagination.modal .first');
    firstButton.addEventListener('click', function (event) {
      event.preventDefault();
      showRows(0, rowsPerPage);
    });

    // 끝으로 버튼 이벤트 리스너 추가
    const lastButton = document.querySelector('.pagination.modal .last');
    lastButton.addEventListener('click', function (event) {
      event.preventDefault();
      const lastIndex = Math.ceil(rows.length / rowsPerPage) * rowsPerPage;
      showRows(lastIndex - rowsPerPage, lastIndex);
    });

 // << 버튼 이벤트 리스너 추가
    const prevButton = document.querySelector('.pagination.modal .arrow.left');
    prevButton.addEventListener('click', function (event) {
      event.preventDefault();
      const activeLink = document.querySelector('.pagination.modal .num.active');
      if (!activeLink) return;
      const currentPage = parseInt(activeLink.textContent);
      if (currentPage > 1) {
        const prevPageIndex = currentPage - 1; // 이전 페이지의 번호 계산
        // 수정된 부분: 페이지 링크들을 순회하며 이전 페이지 링크를 찾는 로직
        pageLinks.forEach(link => {
          if (parseInt(link.textContent) === prevPageIndex) {
            // 이전 페이지 링크를 클릭하는 대신, 직접 showRows를 호출하여 이전 페이지를 보이도록 함
            const startIndex = (prevPageIndex - 1) * rowsPerPage;
            const endIndex = startIndex + rowsPerPage;
            showRows(startIndex, endIndex);
            // active 클래스 갱신
            document.querySelector('.pagination.modal .num.active').classList.remove('active');
            link.classList.add('active');
          }
        });
      }
    });

    // >> 버튼 이벤트 리스너 추가
    const nextButton = document.querySelector('.pagination.modal .arrow.right');
    nextButton.addEventListener('click', function (event) {
      event.preventDefault();
      const activeLink = document.querySelector('.pagination.modal .num.active');
      if (!activeLink) return;
      const currentPage = parseInt(activeLink.textContent);
      const lastIndex = Math.ceil(rows.length / rowsPerPage);
      if (currentPage < lastIndex) {
        showRows(currentPage * rowsPerPage, (currentPage + 1) * rowsPerPage);
      }
    });
  });
</script>

</html>