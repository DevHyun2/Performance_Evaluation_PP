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
	<link rel="stylesheet" href="checkemp.css">
</head>
<body>
	<div class="div_head">
    <h1>
      <img id="shinhan"src="../log/신한마크-removebg-preview.png" alt="신한마크 이미지" width="50" height="50">
      사원관리 프로그램<span class="smalltitle">(인사관리)</span>
    </h1>
  </div>
  <div id="container">
  <div id="p">
	  <p id="pemp">사원번호: ${emplist.employee_id}</p> 
	  <p id="pname">성명: ${emplist.name}</p> 
	  <p id="pdef">부서명: ${emplist.department}</p>
	  <p id="prank">직급: ${emplist.rank}</p>
  </div>
  <form action="../admin/emplist.do" method="post">
  <table border="1" id="table3">
  		<caption>
  			인사 평가 항목
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
    		<c:forEach items="${checkemp }" var="check" varStatus="status">
        <tr id="tr2">
          <td>	${check.check_id }</td>
          <td>${check.department }</td>
          <td>${check.rank }</td>
          <td>${check.check_name }</td>
          <td>${check.description }</td>
          <%-- <td>${status.index }</td> --%>
          <td id="lasttd">
          			1<input type="radio" name="${status.index }" value="1">
          			2<input type="radio" name="${status.index }" value="2">
          			3<input type="radio" name="${status.index }" value="3">
          			4<input type="radio" name="${status.index }" value="4">
          			5<input type="radio" name="${status.index }" value="5">
          </td>
        </tr>
    		</c:forEach>
    </tbody>
  </table>
  <input type="text" id="year" placeholder="평가 년도를 입력해주세요" required="required">
  <button type="submit" id="complete" value="complete">완료</button>  
  </form>
  </div>
</body>
</html>