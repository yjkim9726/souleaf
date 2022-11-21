<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>souLeaf - 로그인</title>
<link rel="icon" type="image/png" sizes="16x16"  href="resources/images/favicon-16x16.png">
    <meta name="msapplication-TileColor" content="#ffffff">
	<meta name="theme-color" content="#ffffff">
 <link rel="stylesheet" href="resources/css/login/registermember.css">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<style type="text/css">
body{
/* background: #c9ccd1;  Old browsers */ 
    background: #fff9e67a;
}
.form-style input{
	border:0;
	height:50px;
	border-radius:0;
border-bottom:1px solid #ebebeb;	
}
.form-style input:focus{
border-bottom:1px solid #007bff;	
box-shadow:none;
outline:0;
background-color:#ebebeb;	
}
.sideline {
    display: flex;
    width: 100%;
    justify-content: center;
    align-items: center;
    text-align: center;
	color:#ccc;
}
button{

height:50px;	
}
.sideline:before,
.sideline:after {
    content: '';
    border-top: 1px solid #ebebeb;
    margin: 0 20px 0 0;
    flex: 1 0 20px;
}

.sideline:after {
    margin: 0 0 0 20px;
}
.kakao-btn{
	background: #F7E600;
	border-color: #F7E600;
	color: #3b1e1e;
}
#signbtn{
	border-radius:5px;
}
.checkBtn {
color:red;
}
#emailAuthenticate{
    width: 70px;
    font-size: 13px;
    margin-left: 80%;
    margin-top: -50px;
}
</style>
</head>
<body>
 <div class="container p-5 mt-4" >
<div class="row m-5 no-gutters shadow-lg">
<div class="col-md-6 bg-white p-5">
<div align="center">
		<a class="navbar-brand" href="/home.kh"><img src="resources/images/logo.png"  style="margin-bottom: 10px; width:200px;"></a>
	</div>
<div class="form-style">
<form action="memberRegister.kh" method="post">
  <div class="form-group pb-3">    
    <input type="text" placeholder="이름" class="form-control" name="memberName" id="name" >   
  </div>
  <div class="form-group pb-3">   
    <input type="text" placeholder="아이디" name="memberId" class="form-control classId" id="id">
  </div>
  <div class="form-group">
       <p id="checkId" class="checkBtn">
  </div>
  <div class="form-group pb-3">   
    <input type="text" placeholder="닉네임" name="memberNick" class="form-control classNick" id="nick" maxlength="6">
  </div>
  <div class="form-group">
       <p id="checkNick" class="checkBtn">
  </div>
  <div class="form-group pb-3" id="autoBtn">   
    <input type="text" placeholder="이메일" name="memberMail" class="form-control" id="email">
    <input type="button" placeholder="인증하기" name="memberMailAuthenticate" class="form-control" id="emailAuthenticate" value="인증하기">
  </div>
  <div class="form-group pb-3">   
    <input type="password" placeholder="패스워드" name="memberPw" class="form-control passwordCheck" id="password">
  </div>
  <div class="form-group pb-3">   
    <input type="password" placeholder="패스워드 확인" name="password1" class="form-control passwordCheck" id="password1">
  </div>
  <div class="form-group pb-3">
         <p id="passwordCheck" class="checkBtn">
  </div>
  <div class="d-flex align-items-center justify-content-between">
</div>
<input type="submit" value="가입하기"  class="btn btn-success w-100 font-weight-bold mt-2" id="signbtn">
</form>
</div>
	<input type="hidden" id="isEmailAuthSuccess" style="display: none;">
</div>
<div class="col-md-6 d-none d-md-block">
<img src="https://images.unsplash.com/photo-1566888596782-c7f41cc184c5?ixlib=rb-1.2.1&auto=format&fit=crop&w=2134&q=80" class="img-fluid" style="min-height:100%;" />
</div>
</div>
</div>
 <!-- <script type="text/javascript" language="javascript" src="/sha256min.js"></script> --> 
 <!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script> -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 <script src="resources/js/login/enrollView.js"></script>
 <script src="resources/js/login/main.js"></script>
<!------ Include the above in your HEAD tag ---------->

</body>
</html>