<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="resources/css/qna/qnalist.css">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>souLeaf - 마이페이지</title>
<link rel="icon" type="image/png" sizes="16x16"
	href="resources/images/favicon-16x16.png">
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!--     <script src='resources/js/jquery-3.2.1.min.js'></script> -->
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="theme-color" content="#ffffff">
<style>
.nav-tabs>li {
	float: left;
	margin-bottom: -1px;
}

.nav-tabs>li.active>a, .nav-tabs>li.active>a:focus, .nav-tabs>li.active>a:hover
	{
	color: #555;
	cursor: default;
	background-color: #fff;
	border: 1px solid #ddd;
	border-bottom-color: transparent;
}

.nav-tabs>li>a {
	margin-right: 2px;
	line-height: 1.42857143;
	border: 1px solid transparent;
	border-radius: 4px 4px 0 0;
}

.nav>li>a {
	position: relative;
	display: block;
	padding: 10px 15px;
}

.single_what_we_do {
	width: 750px;
	height: 150px;
	border: 1px solid #E7E7E7;
	background-color: #ffffff;
	text-align: center;
	padding: 0 35px;
	border-radius: 10px;
	position: relative;
	margin-left:45px;
	margin-bottom: 30px;
	-webkit-transition: all 0.3s ease;
	-o-transition: all 0.3s ease;
	transition: all 0.3s ease;
	cursor: pointer;
}

.single_what_we_do:hover {
	-webkit-box-shadow: 0 8px 12px 0 rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0 8px 12px 0 rgba(0, 0, 0, 0.2);
	box-shadow: 0 8px 12px 0 rgba(0, 0, 0, 0.2);
}

.single_what_we_do .top_line {
	position: absolute;
	top: 0;
	left: 4.5%;
	background-color: #00bd56;
	width: 12%;
	height: 3px;
}

.leftFont {
	text-align: left;
}

.single_what_we_do .what_we_do_icon {
	position: absolute;
	bottom: 57px;
	left: 88%;
	color: #fff;
	background-color: #00bd56;
	width: 30px;
	height: 30px;
	text-align: center;
	border-radius: 50%;
	-webkit-transition: all 0.3s ease;
	-o-transition: all 0.3s ease;
	transition: all 0.3s ease;
}

.single_what_we_do .what_we_do_icon i {
	font-size: 24px;
	text-align: center;
	padding: 2px 3px 2px 5px;
}


/* 개인정보 띄워주기 */
.card {
  /* margin-bottom: 30px;
  margin-top: 64px;
  margin-left: 100px; */
  border-radius: 1px !important;
  color: rgba(0,0,0,.87);
  background: #fff;
  width: 100%;
  box-shadow: 0 2px 2px 0 rgba(0,0,0,.14), 0 3px 1px -2px rgba(0,0,0,.2), 0 1px 5px 0 rgba(0,0,0,.12);
}
.card-title{
  font-weight: 700 !important;
  margin-top: 10px;
  color: #3c4858;
}
.text-gray {
  color: #999!important;
}

.card .card-body{
  padding: .9375rem 1.875rem;
  width: 280px;
  text-align: left;
}
.card.card-profile{
  margin-top: 60px;
  text-align: center;
  width: 270px;
}
.card-description{
  color: #999;
}

.card .card-category {
  margin-top: 15px;
  margin-bottom: 10px;
}
.card-profile .card-avatar {
/* background-image: url(resources/uploadFiles/member/${loginUser.memberFileRename} );
 background-repeat : no-repeat;
        background-size : contain; */
  width: 130px;
  height: 130px;
  max-width: 130px;
  max-height: 130px;
  margin: -50px auto 0;
  border-radius: 50%;
  overflow: hidden;
  padding: 0;
  background-color: white;
  box-shadow: 0 16px 38px -12px rgba(0,0,0,.56), 0 4px 25px 0 rgba(0,0,0,.12), 0 8px 10px -5px rgba(0,0,0,.2);
}
.card-profile .card-avatar img{
  width: 100%;
}
.card-profile .card-avatar+.card-body{
  margin-top: 15px;
}
.deleteMemberBtn {
	width : fit-content;
	float : left;
}
.modal-content {
	margin-top : 200px;
}
</style>
</head>
<body>
	<div class="container bootstrap snippet">
		<br> <br>
		<div class="col-md-12" style="margin:70px 0 130px 0;">
			<div class="row">
				<div class="col-md-3">
					<div class="myInfo">
						<div class="card card-profile">
							<div class="card-avatar">
								<c:choose>
									<c:when test="${empty loginUser.memberPhoto }">
										<img src="resources/images/basicMemberImg.png" />
									</c:when>
									<c:otherwise>
										<img
											src="resources/uploadFiles/member/${loginUser.memberFileRename} "  width="130px" height="130px"/> 
									</c:otherwise>
								</c:choose>
							</div>
							<div class="card-body ">
								<h6 class="card-category text-gray" name="memberId">${loginUser.memberId }</h6>
								<h4 class="card-title" name="memberNick">${loginUser.memberNick }</h4>
								<hr>
								<span>소개글 </span>
								<p class="card-description" name="memberIntro">${loginUser.memberIntro }</p>
								<span>반려식물</span>
								<p class="card-description">
									<c:forEach var="name" items="${pList }" varStatus="index">
										<a href="plantDetail.kh?plantNo=${name.plantNo }">#${name.plantName}</a>
									</c:forEach>
								</p>
							</div>
						</div>
					</div>
					<div class="deleteMemberBtn">
						<input type="hidden" id="memberId" value="${loginUser.memberId }">
				 		<button type="button" class="btn btn-light w-100 font-weight-bold mt-5" onclick="deleteModal()">회원탈퇴</button>  
					</div>
				</div>
				<!-- myInfo -->
				<div class="col-md-9">
					<div class="tab-content" id="myTabContent">
						<div class="tab-pane fade show active" id="member" role="tabpanel"
							aria-labelledby="member-tab">
							<div class="container">
								<div class="row">
									<div class="single_what_we_do leftFont" onclick="location.href='memerModifyView.kh'">
										<div class="top_line"></div>
										<br>
										<h4 class="what_we_do_title">기본 정보</h4>
										<div class="what_we_do_content">프로필 사진, 이름, 이메일, 휴대전화 정보를 수정합니다.</div>
										<a class="what_we_do_icon" href="#"> 
										<i class="fa fa-angle-right" aria-hidden="true"></i>
										</a>
									</div>
								</div>
								<div class="row">
									<div class="single_what_we_do leftFont"
										onclick="location.href='companionListView.kh'">
										<div class="top_line"></div>
										<br>
										<h4 class="what_we_do_title">반려 식물 정보</h4>
										<div class="what_we_do_content">반려식물 애칭, 이미지를 수정합니다.</div>
										<a class="what_we_do_icon" href="#"> <i
											class="fa fa-angle-right" aria-hidden="true"></i>
										</a>
									</div>
								</div>
								<div class="row">
									<div class="single_what_we_do leftFont"
										onclick="location.href='mypageBoard.kh'">
										<div class="top_line"></div>
										<br>
										<h4 class="what_we_do_title">내 게시글 관리</h4>
										<div class="what_we_do_content">작성한 게시글을 관리합니다.</div>
										<a class="what_we_do_icon" href="mypageBoard.kh"> <i
											class="fa fa-angle-right" aria-hidden="true"></i>
										</a>
									</div>
								</div>
								<div class="row">
									<div class="single_what_we_do leftFont"
										onclick="location.href='mypageReply.kh'">
										<div class="top_line"></div>
										<br>
										<h4 class="what_we_do_title">내 댓글 관리</h4>
										<div class="what_we_do_content">작성한 댓글을 관리합니다.</div>
										<a class="what_we_do_icon" href="#"> <i
											class="fa fa-angle-right" aria-hidden="true"></i>
										</a>
									</div>
								</div>
								<div class="row">
									<div class="single_what_we_do leftFont"
										onclick="location.href='changPwView.kh'">
										<div class="top_line"></div>
										<br>
										<h4 class="what_we_do_title">비밀번호 변경</h4>
										<div class="what_we_do_content">비밀번호를 변경합니다.</div>
										<a class="what_we_do_icon" href="changPwView.kh"> <i
											class="fa fa-angle-right" aria-hidden="true"></i>
										</a>
									</div>
								</div>
							</div>
						</div>
			
					</div>
				</div> <!--col-md-9-->
			</div> <!-- col-md-12 -->
		</div>
		<!--/tab-content-->
	</div>
	
	<div class="modal fade" tabindex="-1" role="dialog" id="modal-modify">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5>회원 탈퇴</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title"></h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<div class="col-xs-12">
								<span style="text-align : center;"> 회원 탈퇴 시 회원님께서 작성하신 모든 게시글 및 정보가 삭제됩니다. <br> 탈퇴를 원하시면 비밀번호 입력해주세요.</span>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12">
								<input class="form-control form-control-sm" type="text" name="diaryTitle" id="pwdchk" required />
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-12">
								<span id="notPw" style="color : red;"></span>
							</div>
						</div>
					<!-- /.modal-body -->
					<div class="form-group" style="margin-left: 298px;">
						<button type="button" class="btn btn-light" data-dismiss="modal">닫기</button>
						<button type="button" class="btn btn-danger" id="deleteMember">탈퇴하기</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<script src="resources/js/mypage/mypage.js"></script>
	
</body>
</html>