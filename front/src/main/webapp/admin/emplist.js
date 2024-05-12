var sidebar = document.querySelector('.js-side_bar');
var overlay = document.querySelector('.overlay');

// 사이드바를 열어주는 함수
sidebar.open = function() {
   sidebar.style.right = "0";
   overlay.style.display = "block"; // 오버레이를 화면에 표시
};

  // 사이드바를 닫아주는 함수
sidebar.close = function() {
  sidebar.style.right = "-250px";
  overlay.style.display = "none"; // 오버레이를 숨김
};

// HTML 요소에 이벤트 바인딩
document.querySelector('button[onclick="sidebar.open()"]').addEventListener('click', sidebar.open);
document.querySelector('button[onclick="sidebar.close()"]').addEventListener('click', sidebar.close);

window.addEventListener('DOMContentLoaded', function () {
  /*const rowsPerPage = 10; // 한 페이지에 보여질 행의 수
  const table = document.getElementById('table3'); // 테이블 요소 가져오기
  const tbody = table.querySelector('tbody'); // tbody 요소 가져오기
  const rows = Array.from(tbody.querySelectorAll('tr')); // tbody의 모든 행 가져오기
 	const numOfContent = ${empSize};
  const showButton = 5; 
   const maxPage = Math.ceil(numOfContent / rowsPerPage);
  let pageGroup = Math.ceil(currentPage / pageCount); 
  const showButton = 5;
	const pageGroup = 1;*/
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
