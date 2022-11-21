<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="resources/js/popper.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.easing.1.3.js"></script>
	<script src="resources/js/jquery.waypoints.min.js"></script>
	<script src="resources/js/jquery.stellar.min.js"></script>
	<script src="resources/js/jquery.animateNumber.min.js"></script>
	<script src="resources/js/bootstrap-datepicker.js"></script>
	<script src="resources/js/jquery.timepicker.min.js"></script>
	<script src="resources/js/bootstrap-datepicker.ko.min.js"></script>
	<script src="resources/js/owl.carousel.min.js"></script>
	<script src="resources/js/jquery.magnific-popup.min.js"></script>
	<script src="resources/js/scrollax.min.js"></script>
	<!-- <script	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script> -->
	<!-- <script src="resources/js/google-map.js"></script> -->
	<script src="resources/js/footer-main.js"></script>	
	<script src="resources/js/main.js"></script>	
	<script src="resources/js/home/openweather.js"></script>
	<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
	<script src="resources/js/kakaoLogin/kakaoLogin.js"></script>
</head>
<body>
	<footer class="footer">
		<div class="container">
			<div class="row">
				
				<div class="col-md-6 col-lg-3 mb-4 mb-md-0">
					<h2 class="footer-heading">SOULEAF</h2>
					<p>SOUL + LEAF 의 합성어로 식물과 정신적 교감을 통해 마음의 안정을 갖는것을 뜻합니다.</p>
					<ul class="ftco-footer-social p-0">
						<li class=""><a href="#" data-toggle="tooltip"
							data-placement="top" title="Twitter"><span
								class="fab fa-twitter"></span></a></li>
						<li class=""><a href="#" data-toggle="tooltip"
							data-placement="top" title="Facebook"><span
								class="fab fa-facebook-f"></span></a></li>
						<li class=""><a href="#" data-toggle="tooltip"
							data-placement="top" title="Instagram"><span
								class="fab fa-instagram"></span></a></li>
					</ul>
				</div>
				
				<div class="col-md-6 col-lg-3 mb-4 mb-md-0">
					<h2 class="footer-heading">공지사항</h2>
					<div class="block-21 mb-4 d-flex">
						<a class="img mr-4 rounded"
							style="background-image: url(resources/images/main_bg_27.jpg);"></a>
						<div class="text">
							<h3 class="heading">
								<a href="#">서비스 점검 안내 <br>(6월 15일 02:00~06:00)</a>
							</h3>
							<div class="meta">
								<div>
									<a href="#"><span class="icon-person"></span> 관리자</a>
								</div>
								<div>
									<a href="#"><span class="icon-calendar"></span> 2021-06-01</a>
								</div>
								<div>
									<a href="#"><span class="icon-chat"></span></a>
								</div>
							</div>
						</div>
					</div>
					<div class="block-21 mb-4 d-flex">
						<a class="img mr-4 rounded"
							style="background-image: url(resources/images/main_bg_28.jpg);"></a>
						<div class="text">
							<h3 class="heading">
								<a href="#">개인정보 처리방침 개정안내</a>
							</h3>
							<div class="meta">
								<div>
									<a href="#"><span class="icon-person"></span> 관리자</a>
								</div>
								<div>
									<a href="#"><span class="icon-calendar"></span> 2021-06-01</a>
								</div>
								<div>
									<a href="#"><span class="icon-chat"></span></a>
								</div>
							</div>
						</div>
					</div>
				</div> 
				<div class="col-md-6 col-lg-3 pl-lg-5 mb-4 mb-md-0">
					<h2 class="footer-heading">바로가기</h2>
					<ul class="list-unstyled">
						<li><a href="home.kh" class="py-2 d-block">홈</a></li>
						<!-- <li><a href="intro.kh" class="py-2 d-block">이야기</a></li> -->
						<li><a href="plantListView.kh" class="py-2 d-block">식물찾기</a></li>
						<li><a href="boastListView.kh" class="py-2 d-block">식물자랑</a></li>
						<li><a href="clinicListView.kh" class="py-2 d-block">식물클리닉</a></li>
						<li><a href="curiosityListView.kh" class="py-2 d-block">궁금해요</a></li>
						<li><a href="qnaListView.kh" class="py-2 d-block">Q&A</a></li>
					</ul>
				</div>
				<div class="col-md-6 col-lg-3 mb-4 mb-md-0">
					<h2 class="footer-heading">정보</h2>
					<div class="block-23 mb-3">
						<ul>
							<li><span class="icon fa fa-map"></span><span class="text">서울특별시 중구 남대문로 120<br>대일빌딩 2F, 3F</span></li>
							<li><a><span class="icon fa fa-phone"></span><span
									class="text">+82 1234 5678</span></a></li>
							<li><a><span class="icon fa fa-paper-plane"></span><span
									class="text">souleaf@info.or.kr</span></a></li>
						</ul>
					</div>
					<a class="navbar-brand" href="/home.kh"><img src="resources/images/main_white.png" width="200"></a>
				</div>
				
			</div>
			<div class="row mt-5">
				<div class="col-md-12 text-center">

					<p class="copyright">
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						Copyright &copy;
						<script>document.write(new Date().getFullYear());</script>
						All rights reserved | This template is made with <i
							class="fa fa-heart" aria-hidden="true"></i> by <a
							href="https://colorlib.com" target="_blank">Colorlib.com</a>
						<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					</p>
				</div>
			</div>
		</div>
	</footer>




	<!-- loader -->
	<!-- <div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div> -->
	

</body>
</html>