<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 비밀번호 변경</title>
<jsp:include page="../common/header.jsp"></jsp:include>
</head>
<style>
.top_line {
	position: relative;
	top: -18px;
	background-color: #00bd56;
	width: 21%;
	height: 3px;
}

.wrapper {
	margin-top : 150px;
	margin-bottom : 150px;
}
.btnarea {
	width : inherit;
	height : inherit;
	margin : 40px auto;
}
.btn {
	width : 150px;
}

#changePwbtn {
	margin-right : 15px;
}

 .captcha{
   overflow: hidden;
 }
 .captcha_child{
   float: left;
 }
 .captcha_child_two{
    float: right;
 }
 .refreshBtn:hover{
    background-color: #a8a8a8;
    color: white;
    border : 1px solid #a6a6a6;
 }
 .refreshBtn{
    color: black;
    border : 1px solid #888;
    width: 110px;
    border-radius: 5px;
    height: 25px;
    display: block;
    padding : 2px 10px;
    margin: 5px 0px;
 }
 .btnarea {
 	text-align : center;
 }
</style>
<body>
<div class="container bootstrap snippet wrapper">
	<div class="row">
		<div class="col-sm-12">
			<h4>
				비밀번호 변경<span class="badge badge-secondary"
					style="background-color: #00bd56;"></span>
			</h4>
			<hr>
			<div class="top_line"></div>
			<br> <br>
			<br> <br>
			<div class="container">
				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<form action="changePw.kh" method="POST">
							<div class="form-floating">
								<div class="form-group pb-3">
									<input type="text" placeholder="기존 비밀번호" name="memberPw" id="memberPw"
										class="form-control " id="originalPw">
								</div>
								<div class="form-group pb-3">
									<input type="password" placeholder="새 비밀번호" name="newMemberPw" id="newMemberPw"
										class="form-control" id="newPw">
									<div class="container"></div>
								</div>
								<div class="form-group pb-3">
									<input type="password" placeholder="비밀번호 확인" name="newMemberPwChk" id="newMemberPwChk"
										class="form-control " id="newPwChk">
								</div>
								<div class="form-group pb-3">
									<p id="passwordCheck">
								</div>
									<div class="btnarea">
									<input type="hidden" name="memberId" value ="${loginUser.memberId }">
									<button type="submit" id="changePwbtn" class="btn btn-success">변경</button>
									<button type="reset" id="cancelbtn" onclick="location.href='myPage.kh'" class="btn btn-secondary">취소</button>
								</div>
							</div>
						</form>
					</div>
				</div>
				</div>
			</div>
			<br> <br> <br>
			<hr>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<script type="text/javascript">
	$("#changePwbtn").on("click",function(){
		var passwordVal = $("#newMemberPw").val();
		var regExp = /^[a-z|A-Z|0-9]{4,10}$/;
			if(!regExp.test(passwordVal)){
			$("#passwordCheck").html("비밀번호는 영소문자,숫자 4~10자리입니다.").css("color" ,"red");
			return false;
		} 
		if($("#newMemberPw").val() != $("#newMemberPwChk").val() && $("#newMemberPw").val()!= ""){
			$("#passwordCheck").html("패스워드가 일치하지 않습니다").css("color" ,"red");
		}else{
			$("#passwordCheck").html("");
		}		
		
	});
		$("#newMemberPw").on("keyup",function(){
			var passwordVal = $("#newMemberPw").val();
			var regExp = /^[a-z|A-Z|0-9]{4,10}$/;
			if(!regExp.test(passwordVal)){
				$("#passwordCheck").html("비밀번호는 영소문자,숫자 4~10자리입니다.").css("color" ,"red");
				return false;
			}else {
				$("#passwordCheck").html("");
			}
		});
		$("#newMemberPwChk").on("keyup",function(){
			if($("#newMemberPw").val() != $("#newMemberPwChk").val() && $("#newMemberPw").val()!= ""){
				$("#passwordCheck").html("패스워드가 일치하지 않습니다").css("color" ,"red");
			}else{
				$("#passwordCheck").html("");
			}		
		});
	</script>
	
</body>
</html>