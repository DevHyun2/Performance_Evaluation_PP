<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>EmpInfo</title>
  <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	
</head>
<link rel="stylesheet" href="emplist.css">
<body>
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
    <ul id="check_menu" style="list-style: none">
	    <li><a>평가 항목 메뉴</a>
        <ul style="list-style: none;">
           <li><a href="#none" >조회</a></li>
           <!-- <li><a href="#none" >생성</a></li>
           <li><a href="#none" >수정</a></li>
           <li><a href="#none" >제거</a></li> -->
        </ul>
	   </li>
   </ul>
        <button onclick="sidebar.close()">SideBar Close</button>
    </aside>
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
  const rowsPerPage = 10; // 한 페이지에 보여질 행의 수
  const table = document.getElementById('table3'); // 테이블 요소 가져오기
  const tbody = table.querySelector('tbody'); // tbody 요소 가져오기
  const rows = Array.from(tbody.querySelectorAll('tr')); // tbody의 모든 행 가져오기
 	const numOfContent = ${empSize};
  /*const showButton = 5; */
/*   const maxPage = Math.ceil(numOfContent / rowsPerPage);
  let pageGroup = Math.ceil(currentPage / pageCount); */
  const showButton = 5;
	const pageGroup = 1;
  // 초기에는 처음 10개의 행만 보이도록 설정
  showRows(0, rowsPerPage);
  pageMax();
  $(".num").eq(0).addClass("active");
  
  function pageMax() {
	  console.log("test");
	  const totalPage = Math.ceil(numOfContent / rowsPerPage);
	  let str = "";
	  for(let i = pageGroup; i < pageGroup + showButton && i <= totalPage; i++){
		  str += "<li><a href='#' class='num'>"+ i +"</a></li>"
	  }
	  $("#leftArrow").after(str);
  } 

  // 페이지 번호를 클릭할 때마다 호출되는 함수
  function handlePageClick(event) {
    event.preventDefault();
    const pageNum = parseInt(event.target.textContent); // 클릭한 페이지 번호 가져오기
    if (isNaN(pageNum)) return; // 숫자가 아닌 경우 처리
    const startIndex = (pageNum - 1) * rowsPerPage; // 해당 페이지의 시작 인덱스 계산
    const endIndex = startIndex + rowsPerPage; // 해당 페이지의 마지막 인덱스 계산
    showRows(startIndex, endIndex);
    updateActiveState(pageNum);
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

  // 활성 페이지 상태 업데이트
  function updateActiveState(activePage) {
    pageLinks.forEach(link => {
      const pageNum = parseInt(link.textContent);
      if (pageNum === activePage) {
        link.classList.add('active');
      } else {
        link.classList.remove('active');
      }
    });
  }

  // 처음으로 버튼 이벤트 리스너 추가
  const firstButton = document.querySelector('.pagination.modal .first');
  firstButton.addEventListener('click', function (event) {
    event.preventDefault();
    showRows(0, rowsPerPage);
    updateActiveState(1);
  });

  // 끝으로 버튼 이벤트 리스너 추가
  const lastButton = document.querySelector('.pagination.modal .last');
  lastButton.addEventListener('click', function (event) {
    event.preventDefault();
    const totalPages = Math.ceil(rows.length / rowsPerPage);
    const lastIndex = (totalPages - 1) * rowsPerPage;
    showRows(lastIndex, lastIndex + rowsPerPage);
    updateActiveState(totalPages);
  });

  // >> 버튼 이벤트 리스너 추가
  const nextButton = document.querySelector('.pagination.modal .arrow.right');
  nextButton.addEventListener('click', function (event) {
    event.preventDefault();
    const activeLink = document.querySelector('.pagination.modal .num.active');
    const currentPage = parseInt(activeLink.textContent);
    const totalPages = Math.ceil(rows.length / rowsPerPage);
    if (currentPage < totalPages) {
      const startIndex = currentPage * rowsPerPage;
      showRows(startIndex, startIndex + rowsPerPage);
      updateActiveState(currentPage + 1);
      if(currentPage % showButton == 0) {
    	  		pageGroup += 5;
    	  		//다시 랜더링
    	  		pageMax();
      }
    }
  });

  // << 버튼 이벤트 리스너 추가
  const prevButton = document.querySelector('.pagination.modal .arrow.left');
  prevButton.addEventListener('click', function (event) {
    event.preventDefault();
    const activeLink = document.querySelector('.pagination.modal .num.active');
    const currentPage = parseInt(activeLink.textContent);
    if (currentPage > 1) {
      const startIndex = (currentPage - 2) * rowsPerPage;
      showRows(startIndex, startIndex + rowsPerPage);
      updateActiveState(currentPage - 1);
    }
  });
});
</script>
<script>
function search() {
    // 선택된 옵션 가져오기
    var selectedOption = document.getElementById("select_option").value;
    // 입력값 가져오기
    var inputValue = document.getElementById("input_search").value.trim().toUpperCase();
    // 테이블의 행 가져오기
    var rows = document.getElementById("table3").getElementsByTagName("tbody")[0].getElementsByTagName("tr");
    
    // 각 행을 순회하며 필터링
    for (var i = 0; i < rows.length; i++) {
        var row = rows[i];
        var cells = row.getElementsByTagName("td");
        var showRow = false;
        
        // 선택된 옵션에 따라 필터링
        switch(selectedOption) {
            case "all":
                // 모든 행을 표시
                showRow = true;
                break;
            case "department":
                // 부서명이 일치하면 표시
                if (cells[3].innerHTML.trim().toUpperCase() === inputValue) {
                    showRow = true;
                }
                break;
            case "rank":
                // 직급이 일치하면 표시
                if (cells[4].innerHTML.trim().toUpperCase() === inputValue) {
                    showRow = true;
                }
                break;
            case "employee_id":
                // 사원번호가 일치하면 표시
                if (cells[0].innerHTML.trim().toUpperCase() === inputValue) {
                    showRow = true;
                }
                break;
            default:
                showRow = true;
        }
        
        // 행을 표시하거나 숨기기
        if (showRow) {
            row.style.display = "";
        } else {
            row.style.display = "none";
        }
    }
}

</script>
</html>