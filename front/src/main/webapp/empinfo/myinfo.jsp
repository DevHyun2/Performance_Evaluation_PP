<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="myinfo.css">
<body>
	<div class="div_head">
    <h1>
      <img id="shinhan"src="../log/신한마크-removebg-preview.png" alt="신한마크 이미지" width="50" height="50">
      사원관리 프로그램<span class="smalltitle">(인사관리)</span>
    </h1>
  </div>
<div id="container">
<table border="1" id="table3">
    <thead>
      <tr id="tr1">
        <th>평가내용</th>
        <th>평가년도</th>
        <th>점수</th>
      </tr>
    </thead>
    <tbody>
    		<c:forEach items="${search }" var="s">
    		<tr id="tr2">
          <td>${s.description}</td>
          <td>${s.review_year}</td>
          <td>${s.score}</td>
        </tr>
				</c:forEach>
    </tbody>
  </table>
  <div id="aver">
	     평균: <p id="averP">${score.get(0).getAverage_score()}</p>
  </div>
</div>
</body>
</html>