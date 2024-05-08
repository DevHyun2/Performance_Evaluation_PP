<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Performance Login</title>
  <link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
  <script src="https://kit.fontawesome.com/a81368914c.js"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<link rel="stylesheet" href="login.css">
<img class="wave" src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/wave.png">
<div class="container">
  <div class="img">
    <img src="https://raw.githubusercontent.com/sefyudem/Responsive-Login-Form/master/img/bg.svg">
  </div>
  <div class="login-content">
    <form>
      <img src="신한마크-removebg-preview.png" >
      <h2 class="title">인사평가</h2>
      <div class="mb-3">
        <div class="form_toggle row-vh d-flex flex-row justify-content-between" >
          <div class="form_radio_btn" style="display: inline-block">
            <input id="radio-1" type="radio" name="logoption" value="admin" checked>
            <label for="radio-1">관리자</label>
          </div>   
          <div class="form_radio_btn" style="display: inline-block">
            <input id="radio-2" type="radio" name="logoption" value="employee">
            <label for="radio-2">사원</label>
          </div>
        </div>
      </div>
        <div class="input-div one">
            <div class="i">
              <i class="fas fa-user"></i>
            </div>
            <div class="div">
              <h5>UserId</h5>
              <input type="text" class="input" id="userId" name="userId">
            </div>
        </div>
        <div class="input-div pass">
            <div class="i"> 
              <i class="fas fa-lock"></i>
            </div>
            <div class="div">
              <h5>UserPw</h5>
              <input type="password" class="input" id="userPw" name="userPw">
            </div>
        </div>
      <input type="submit" class="btn" value="Login">
    </form>
  </div>
</div>

</body>
  <script>
  const inputs = document.querySelectorAll(".input");

  function addcl(){
    let parent = this.parentNode.parentNode;
    parent.classList.add("focus");
  }

  function remcl(){
    let parent = this.parentNode.parentNode;
    if(this.value == ""){
      parent.classList.remove("focus");
    }
  }

  inputs.forEach(input => {
    input.addEventListener("focus", addcl);
    input.addEventListener("blur", remcl);
  });
</script>
</html>