<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물클리닉</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/clinic/clinic-style.css">
</head>
<body>

	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('resources/images/main_bg_34.jpg');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text align-items-end">
				<div class="col-md-9 ftco-animate pb-5">
					<p class="breadcrumbs mb-2">
						<span class="mr-2"><a href="home.kh">Home <i
								class="ion-ios-arrow-forward"></i></a></span> <span>Blog <i
							class="ion-ios-arrow-forward"></i></span>
					</p>
					<h1 class="mb-0 bread">식물클리닉</h1>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section ftco-degree-bg">
		<div class="container">
			<h2 class="heading-section" align="center" style="margin-bottom: 50px">식물에 문제가 있어요</h2>
			<div id="clinic-list" style="min-height: 450px;"></div>
			<input type="hidden" id="currentPage" value="${page }">
			<input type="hidden" id="currentCount" value="${count }">

				<button class="btn btn-primary" style="float: right;" onclick="location.href='clinicWrite.kh'">글쓰기</button>
					<div class="row" style="justify-content: center;">
						<!-- <div id="selectSearch">
							<select name="searchCondition" id="clinicSearchCondition" class="form-control-sm">
								<option value="searchAll">전체</option>
								<option value="searchTitle">제목</option>
								<option value="searchContent">내용</option>
							</select>
						</div> -->
						<form action="clinicMainSearch.kh" method="get">
						<div id="custom-search-input">
							<div class="input-group col-md-12">
								<input type="text" name="searchValue" id="clinicSearchValue" class="form-control-sm input" placeholder="검색어를 입력해주세요." />
									<span class="input-group-btn">
									<button class="btn btn-info btn-lg" type="submit" id="clinicSearchBtn">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div>
						</div>
						</form>
					</div>
			<div class="row mt-5">
				<div class="col text-center">
					<div class="block-27">
						<ul id="clinic-page">
							<li><a href="#">&lt;</a></li>
							<li class="active"><span>1</span></li>
							<li><a href="#">2</a></li>
							<li><a href="#">3</a></li>
							<li><a href="#">4</a></li>
							<li><a href="#">5</a></li>
							<li><a href="#">&gt;</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</section>


	<jsp:include page="../common/footer.jsp"></jsp:include>
	<script src="resources/js/clinic/clinic-list.js"></script>
</body>
</html>