<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>souLeaf - 이메일인증</title>
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
<form action="#" method="post">
  <div class="form-group pb-3">   
    <p>이메일로 전송된 인증번호를 입력해주세요.(제한시간 : 3분)</p>
  </div>
 
  <div class="form-group pb-3">   
    <input type="text" placeholder="인증번호 입력" name="emailAuthKey" class="form-control" id="emailAuthKey">
  </div>
  <div class="d-flex align-items-center justify-content-between">
</div>
<input type="button" value="확인" class="btn btn-success w-100 font-weight-bold mt-2" id="emailAuthConfirmbtn"  >
</form>
</div>
	
</div>

</div>
</div>
 <script type="text/javascript" language="javascript" src="/sha256min.js"></script> 
 <!-- <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script> -->
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="resources/js/login/emailAuthenticatePwView.js"></script>
<!------ Include the above in your HEAD tag ---------->

</body>
</html>