<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"/>
    <title>souLeaf - 성장일기</title>
    <jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include> 
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
    <link href='resources/css/diary/calendar.css' rel='stylesheet' />
    <link href='resources/css/diary/diaryMain.css' rel='stylesheet' />
</head>
<body>  
    <!-- 다이어리 주인의 memberNo -->
    <input type="hidden" name="memberDiary" id="memberDiary" value="${memberDiary}">
    <!-- 방명록을 작성하는 사람의 memberNo -->
    <input type="hidden" name="memberNo" id="memberNo" value="${loginUser.memberNo}">
		<div class="diary-content">
			<div class="tab-content tab-space">
				<div class="nav-tab-content">
					<ul class="nav nav-pills" role="tablist">
						<!--
							color-classes: "nav-pills-primary", "nav-pills-info", "nav-pills-success", "nav-pills-warning","nav-pills-danger"
						-->
						<li class="nav-item">
							<a class="nav-link active" href="#myDiary-calendar" role="tab" data-toggle="tab">
								성장일기
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link " href="#myDiary-picture" role="tab" data-toggle="tab">
								사진첩
							</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#myDaiary-guest" role="tab" data-toggle="tab">
								방명록
							</a>
						</li>
					</ul>
				</div>

			<div class="col-md-12 tab-pane active" id="myDiary-calendar">
				<!-- 성장일기 메인에서 내 정보보기 -->
				<div class="myInfo">
					<div class="col-md-4">
						<div class="card card-profile">
							<div class="card-avatar">
								<c:choose>
									<c:when test="${empty member.memberPhoto }">
										<img src="resources/images/basicMemberImg.png" />
									</c:when>
									<c:otherwise>
										<img src="resources/uploadFiles/member/${member.memberFileRename} " width="130px" height="130px"/>
									</c:otherwise>
								</c:choose>
							</div>
							<div class="card-body ">
								<h6 class="card-category text-gray" name="memberId">${member.memberId }</h6>
								<h4 class="card-title" name="memberNick">${member.memberNick }</h4>
								<hr>
								<span>소개글 </span>
								<p class="card-description" name="memberIntro">${member.memberIntro }</p>
								<span>반려식물</span>
								<p class="card-description">
									<c:forEach var="name" items="${pList }" varStatus="index">
										<a href="plantDetail.kh?plantNo=${name.plantNo }">#${name.plantName}</a>
									</c:forEach>
								</p>
								<a href="#" class="btn btn-primary">chat</a>
							</div>
						</div>
					</div>
				</div>
				<!-- myInfo -->
				<div class="calendar">
					<div id='calendar'></div>
				</div>
				<!-- calendar -->
			</div>

			<div class="tab-pane" id="myDiary-picture">
			<!-- 비디오 영역  -->
				<div class="video">
					<div class="video-Companion">
						<select class="form-select" name="companionNo" id="selectVideo">

						</select>
					</div>
					<div class="video-play">
						<div class="play">
							<div id="carouselExampleFade" class="carousel slide carousel-fade" data-ride="carousel" data-interval="500">
								<div class="carousel-inner" id="videoCarousel">
									<div class="carousel-item active">
										<img src="resources/images/photosicon.png" class="d-block w-100">
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- 사진 영역  -->
				<div class="picture-section">
					<div id="carouselExampleControls" class="carousel slide"
						data-touch="false" data-interval="false">
						<div class="carousel-inner" id="carouselPicture">
							<!-- <div class="carousel-item active">
					 			<div class="row">
							        <div class="col-lg-3 col-md-4 col-xs-6 thumb">
							            	<a href="resources/uploadFiles/diary/20210522234249.png" class="fancybox" rel="ligthbox">
							                    <img  src="resources/uploadFiles/diary/20210522234249.png" class="zoom img-fluid "  alt="">
							                </a>
							          	</div>
							          	
							            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
							                <a href="https://images.pexels.com/photos/38238/maldives-ile-beach-sun-38238.jpeg?auto=compress&cs=tinysrgb&h=650&w=940"  class="fancybox" rel="ligthbox">
							                    <img  src="https://images.pexels.com/photos/38238/maldives-ile-beach-sun-38238.jpeg?auto=compress&cs=tinysrgb&h=650&w=940" class="zoom img-fluid"  alt="">
							                </a>
							            </div>
							            
							            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
							                <a href="https://images.pexels.com/photos/158827/field-corn-air-frisch-158827.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" class="fancybox" rel="ligthbox">
							                    <img  src="https://images.pexels.com/photos/158827/field-corn-air-frisch-158827.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" class="zoom img-fluid "  alt="">
							                </a>
							            </div>
							            
							            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
							                <a href="https://images.pexels.com/photos/302804/pexels-photo-302804.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" class="fancybox" rel="ligthbox">
							                    <img  src="https://images.pexels.com/photos/302804/pexels-photo-302804.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" class="zoom img-fluid "  alt="">
							                </a>
							            </div>
							            
							             <div class="col-lg-3 col-md-4 col-xs-6 thumb">
							                <a href="https://images.pexels.com/photos/1038914/pexels-photo-1038914.jpeg?auto=compress&cs=tinysrgb&h=650&w=940" class="fancybox" rel="ligthbox">
							                    <img  src="https://images.pexels.com/photos/1038914/pexels-photo-1038914.jpeg?auto=compress&cs=tinysrgb&h=650&w=940" class="zoom img-fluid "  alt="">
							                </a>
							            </div>
							            
							             <div class="col-lg-3 col-md-4 col-xs-6 thumb">
							                <a href="https://images.pexels.com/photos/414645/pexels-photo-414645.jpeg?auto=compress&cs=tinysrgb&h=650&w=940" class="fancybox" rel="ligthbox">
							                    <img  src="https://images.pexels.com/photos/414645/pexels-photo-414645.jpeg?auto=compress&cs=tinysrgb&h=650&w=940" class="zoom img-fluid "  alt="">
							                </a>
							            </div>
							            
							             <div class="col-lg-3 col-md-4 col-xs-6 thumb">
							                <a href="https://images.pexels.com/photos/56005/fiji-beach-sand-palm-trees-56005.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" class="fancybox" rel="ligthbox">
							                    <img  src="https://images.pexels.com/photos/56005/fiji-beach-sand-palm-trees-56005.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" class="zoom img-fluid "  alt="">
							                </a>
							            </div>
							            
							             <div class="col-lg-3 col-md-4 col-xs-6 thumb">
							                <a href="https://images.pexels.com/photos/1038002/pexels-photo-1038002.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" class="fancybox" rel="ligthbox">
							                    <img  src="https://images.pexels.com/photos/1038002/pexels-photo-1038002.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" class="zoom img-fluid "  alt="">
							                </a>
							            </div> 
							      </div> row 
				   			</div> <!-- carousel-item active -->

						</div>
						<!-- carousel-inner -->
						<a class="carousel-control-prev" href="#carouselExampleControls"
							role="button" data-slide="prev"> <span
							class="carousel-control-prev-icon changecolor" aria-hidden="true"></span>
							<span class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carouselExampleControls"
							role="button" data-slide="next"> <span
							class="carousel-control-next-icon changecolor" aria-hidden="true"></span>
							<span class="sr-only">Next</span>
						</a>
					</div>
					<!-- carouselExampleControls -->
				</div>
				<!-- picture -->
			</div>
			<!--  myDiary-picture -->
				
				<div class="tab-pane" id="myDaiary-guest">
						<div class="comment">
							<div class="comment-content">
								<textarea id="comment-content" rows="3"></textarea>
							</div>
							<div class="comment-enroll">
								<span id="wordCount1">(0/최대 200자 작성가능)</span>
								<button type="button" id="btnGuestbook" class="btn btn-default btn-secondary">등록</button>
							</div>
							<div class="comment-list">
	
							</div>
						</div>
				</div>
			</div>
		</div>
    
	
    <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include> 
    <script src="//cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.js"></script>
   	<script src="https://unpkg.com/@popperjs/core@2/dist/umd/popper.js"></script>
	<script src="https://unpkg.com/tippy.js@6"></script>
    <script src="resources/js/diary/diaryMainOther.js"></script>   
    <script src='resources/js/diary/calendar.js'></script>
    <script src='resources/js/diary/ko.js'></script>
    <script src='resources/js/diary/locales-all.js'></script>
</body>
</html>
