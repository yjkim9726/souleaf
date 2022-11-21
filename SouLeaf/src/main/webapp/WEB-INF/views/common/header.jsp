<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>souLeaf - 솔리프</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="icon" type="image/png" sizes="16x16"  href="resources/images/favicon-16x16.png">
    <meta name="msapplication-TileColor" content="#ffffff">
	<meta name="theme-color" content="#ffffff">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:200,300,400,500,600,700,800&display=swap" rel="stylesheet">

    <!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet"> <!--CDN 링크 -->
    <link rel="stylesheet" href="resources/css/animate.css">
    
  	<link rel="stylesheet" href="resources/css/owl.carousel.min.css">
    <link rel="stylesheet" href="resources/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="resources/css/magnific-popup.css">


    <link rel="stylesheet" href="resources/css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="resources/css/jquery.timepicker.css">

    <link rel="stylesheet" href="resources/css/flaticon.css">
    <link rel="stylesheet" href="resources/css/style.css">
 </head>
  <body>

    <div class="wrap" id="wrap">
			<div class="container">
				<div class="row" style="justify-content: space-between;">
					<div class="d-flex align-items-center">
						<!-- <p class="mb-0 phone pl-md-2">
							<a href="#" class="mr-2"><span class="fas fa-map-marker-alt mr-1"></span> 서울시 종로구</a>
							<a href="#" class="mr-2"><span class="fa fa-cloud-sun mr-1"></span> 맑음</a>
							<a href="#"><span class="fas fa-temperature-low mr-1"></span> 30°C</a>
						</p> -->
						<div class="row weather" style="color:#fff"> 
						&nbsp;&nbsp;&nbsp;<span class="fas fa-map-marker-alt mr-1 dp-flex"></span><div class="City"></div>
						&nbsp;&nbsp;&nbsp;<div class="CurrIcon"></div>
						&nbsp;<div class="CurrText"></div>
						&nbsp;&nbsp;&nbsp;<i class="fas fa-thermometer-half dp-flex"></i>&nbsp;<div class="CurrTemp"></div>
						 </div>
					</div>
					<div class="d-flex justify-content-md-end">
						<div class="login-media">
							<input type="hidden" id="loginUserId" value="${loginUser.memberId }">
				    		<p class="mb-0 d-flex">
				    			<c:if test="${loginUser eq null }">
					    			<a href="loginView.kh" class="d-flex align-items-center justify-content-center"><small><span class="fas fa-sign-in-alt"> 로그인</span></small></a>
				    			</c:if>
				    			<c:if test="${loginUser ne null }">
					    			<a href="#" onclick="window.open('room.kh', '_blank', 'width=400 height=600')" class="d-flex align-items-center justify-content-center"><small><span class="fas fa-comments" id="head-chat"> 채팅</span></small></a>
					    			<a href="diaryMainView.kh?memberNo=${loginUser.memberNo }" class="d-flex align-items-center justify-content-center <c:if test="${nav eq 'diary' }">head-active</c:if>"><small><span class="fas fa-leaf" id="head-leaf"> 성장일기</span></small></a>
					    			
					    			<c:if test="${loginUser.memberId ne 'admin' }">
						    			<a href="mypage.kh" class="d-flex align-items-center justify-content-center <c:if test="${nav eq 'my' }">head-active</c:if>"><small><span class="fas fa-user" id="head-mypage"> 마이페이지</span></small></a>
					    			</c:if>
					    			<c:if test="${loginUser.memberId eq 'admin' }">
						    			<a href="adminHome.kh" class="d-flex align-items-center justify-content-center <c:if test="${nav eq 'admin' }">head-active</c:if>"><small><span class="fas fa-user" id="head-mypage"> 관리페이지</span></small></a>
					    			</c:if>
					    			<c:if test="${token eq null }">
					    				<a href="logout.kh" class="d-flex align-items-center justify-content-center"><small><span class="fas fa-sign-out-alt" id="head-logout"> 로그아웃</span></small></a>
					    			</c:if>
					    			<c:if test="${token ne null }">
					    				<a href="javascript:void(0)" onclick="kakaoLogout();" class="d-flex align-items-center justify-content-center"><small><span class="fas fa-sign-out-alt" id="head-logout"> 카카오 로그아웃</span></small></a>
				    				</c:if>
				    			</c:if>
				    		</p>
		       			</div>
					</div>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	    <c:if test="${nav eq 'home' }">
	    	<a class="navbar-brand" href="/home.kh"><img src="resources/images/main_white.png" width="200" id="ftco-logo"></a>
	    </c:if>	    
	    <c:if test="${nav ne 'home' }">
	    	<a class="navbar-brand" href="/home.kh"><img src="resources/images/logo.png" width="200" id="ftco-logo"></a>
	    </c:if>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="fa fa-bars"></span> Menu
	      </button>
	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	        	<li class="nav-item <c:if test="${nav eq 'home' }">active</c:if>"><a href="home.kh" class="nav-link">홈</a></li>
				<%-- <li class="nav-item <c:if test="${nav eq 'intro' }">active</c:if>"><a href="intro.kh" class="nav-link">이야기</a></li> --%>
				<li class="nav-item <c:if test="${nav eq 'plant' }">active</c:if>"><a href="plantListView.kh" class="nav-link">식물찾기</a></li>
				<li class="nav-item <c:if test="${nav eq 'boast' }">active</c:if>"><a href="boastListView.kh" class="nav-link">식물자랑</a></li>
				<li class="nav-item <c:if test="${nav eq 'clinic' }">active</c:if>"><a href="clinicListView.kh" class="nav-link">식물클리닉</a></li>
				<li class="nav-item <c:if test="${nav eq 'curiosity' }">active</c:if>"><a href="curiosityListView.kh" class="nav-link">궁금해요</a></li>
				<li class="nav-item <c:if test="${nav eq 'qna' }">active</c:if>"><a href="qnaListView.kh" class="nav-link">Q&A</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->

</body>
</html>