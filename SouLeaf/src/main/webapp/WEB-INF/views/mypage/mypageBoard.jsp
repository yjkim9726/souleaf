<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>souLeaf - 내 게시글 관리</title>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<link href='resources/css/mypage/mypageBoard.css' rel='stylesheet' />
</head>

<body>
	<input type="hidden" name="memberNo" id="memberNo" value="${loginUser.memberNo }">
	<div class="myPageBoard-content">
		<div class="tab-content tab-space">
			<div class="nav-tab-content">
				<ul class="nav nav-pills" role="tablist">
					<!--
						color-classes: "nav-pills-primary", "nav-pills-info", "nav-pills-success", "nav-pills-warning","nav-pills-danger"
					-->
					<li class="nav-item"><a class="nav-link active"
						href="#myPage-boast" role="tab" data-toggle="tab"> 식물자랑 </a></li>
					<li class="nav-item"><a class="nav-link "
						href="#myPage-clinic" role="tab" data-toggle="tab"> 식물클리닉 </a></li>
					<li class="nav-item"><a class="nav-link"
						href="#myPage-curiosity" role="tab" data-toggle="tab"> 궁금해요 </a></li>
					<li class="nav-item"><a class="nav-link"
						href="#myPage-qna" role="tab" data-toggle="tab"> Q&A </a></li>
				</ul>
			</div>

			<div class="col-md-12 tab-pane active" id="myPage-boast">
				<div>
					<table class="table table-hover mypageTable">
						<thead>
							<tr>
								<th scope="col"><input type="checkbox" class="chk_all"></th>
								<th scope="col">번호</th>
								<th scope="col" style='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'>제목</th>
								<th scope="col">작성일</th>
								<th scope="col">조회수</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<!-- <tr>
								<td><input type="checkbox" name="del-select" class="chk" value="selectOne"></td>
								<td scope="row">1</td>
								<td><a href="#" class="noColor">오늘의 자랑하기 : 민달래</a></td>
								<td>2021/05-21</td>
								<td>25</td>
								<td><button type="button" class="btn btn-outline-success btnGreen">수정</button>
								<button type="button" class="btn btn-outline-danger">삭제</button></td>
							</tr>

							<tr>
								<td><button type="button" class="btn btn-outline-warning">선택삭제</button></td>
								<td colspan="5"></td>
							</tr> -->
						</tbody>
					</table>

					<div class="row mt-5">
						<div class="col text-center">
							<div class="block-27">
								<input type="hidden" id="pageInfo" value="">
								<ul id="boast-page">
									<!-- <li><a href="#">&lt;</a></li>
									<li class="active"><span>1</span></li>
									<li><a name="page" href="#">2</a></li>
									<li><a name="page" href="#">3</a></li>
									<li><a name="page" href="#">4</a></li>
									<li><a name="page" href="#">5</a></li>
									<li><a href="#">&gt;</a></li> -->
								</ul>
							</div>
						</div>
					</div>
					<div class="row" style="margin: 50px auto; width: 550px;">
						<div id="selectSearch">
							<select name="searchCondition" id="boastSearchCondition" class="form-control-sm">
								<option value="searchAll">전체</option>
								<option value="searchTitle">제목</option>
								<option value="searchContent">내용</option>
							</select>
						</div>

						<div id="custom-search-input">
							<div class="input-group col-md-12">
								<input type="text" name="searchValue" id="boastSearchValue" class="form-control-sm input" placeholder="검색어를 입력해주세요." /> 
								<span class="input-group-btn">
									<button class="btn btn-info btn-lg" type="submit" id="boastSearchBtn">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="tab-pane" id="myPage-clinic">
				<div>
					<table class="table table-hover mypageTable">
						<thead>
							<tr>
								<th scope="col"><input type="checkbox" class="chk_all"></th>
								<th scope="col">번호</th>
								<th scope="col" style='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'>제목</th>
								<th scope="col">작성일</th>
								<th scope="col">조회수</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<!-- <tr>
								<td><input type="checkbox" name="del-select" class="chk" value="selectOne"></td>
								<td scope="row">1</td>
								<td><a href="#" class="noColor">오늘의 자랑하기 : 민달래</a></td>
								<td>2021/05-21</td>
								<td>25</td>
								<td><button type="button" class="btn btn-outline-success btnGreen">수정</button>
								<button type="button" class="btn btn-outline-danger">삭제</button></td>
							</tr>

							<tr>
								<td><button type="button" class="btn btn-outline-warning">선택삭제</button></td>
								<td colspan="5"></td>
							</tr> -->
						</tbody>
					</table>

					<div class="row mt-5">
						<div class="col text-center">
							<div class="block-27">
								<input type="hidden" id="pageInfo" value="">
								<ul id="clinic-page">
									<!-- <li><a href="#">&lt;</a></li>
									<li class="active"><span>1</span></li>
									<li><a name="page" href="#">2</a></li>
									<li><a name="page" href="#">3</a></li>
									<li><a name="page" href="#">4</a></li>
									<li><a name="page" href="#">5</a></li>
									<li><a href="#">&gt;</a></li> -->
								</ul>
							</div>
						</div>
					</div>
					<div class="row" style="margin: 50px auto; width: 550px;">
						<div id="selectSearch">
							<select name="searchCondition" id="clinicSearchCondition" class="form-control-sm">
								<option value="searchAll">전체</option>
								<option value="searchTitle">제목</option>
								<option value="searchContent">내용</option>
							</select>
						</div>

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
					</div>
				</div>
			</div>

			<div class="tab-pane" id="myPage-curiosity">
				<div>
					<table class="table table-hover mypageTable">
						<thead>
							<tr>
								<th scope="col"><input type="checkbox" class="chk_all"></th>
								<th scope="col">번호</th>
								<th scope="col" style='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'>제목</th>
								<th scope="col">작성일</th>
								<th scope="col">조회수</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<!-- <tr>
								<td><input type="checkbox" name="del-select" class="chk" value="selectOne"></td>
								<td scope="row">1</td>
								<td><a href="#" class="noColor">오늘의 자랑하기 : 민달래</a></td>
								<td>2021/05-21</td>
								<td>25</td>
								<td><button type="button" class="btn btn-outline-success btnGreen">수정</button>
								<button type="button" class="btn btn-outline-danger">삭제</button></td>
							</tr>

							<tr>
								<td><button type="button" class="btn btn-outline-warning">선택삭제</button></td>
								<td colspan="5"></td>
							</tr> -->
						</tbody>
					</table>

					<div class="row mt-5">
						<div class="col text-center">
							<div class="block-27">
								<input type="hidden" id="pageInfo" value="">
								<ul id="curiosity-page">
									<!-- <li><a href="#">&lt;</a></li>
									<li class="active"><span>1</span></li>
									<li><a name="page" href="#">2</a></li>
									<li><a name="page" href="#">3</a></li>
									<li><a name="page" href="#">4</a></li>
									<li><a name="page" href="#">5</a></li>
									<li><a href="#">&gt;</a></li> -->
								</ul>
							</div>
						</div>
					</div>
					<div class="row" style="margin: 50px auto; width: 550px;">
						<div id="selectSearch">
							<select name="searchCondition" id="searchCondition" class="form-control-sm">
								<option value="searchAll">전체</option>
								<option value="searchTitle">제목</option>
								<option value="searchContent">내용</option>
							</select>
						</div>

						<div id="custom-search-input">
							<div class="input-group col-md-12">
								<input type="text" name="searchValue" id="searchValue" class="form-control-sm input" placeholder="검색어를 입력해주세요." /> 
								<span class="input-group-btn">
									<button class="btn btn-info btn-lg" type="submit" id="curiositySearchBtn">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div class="tab-pane" id="myPage-qna">
				<div>
					<table class="table table-hover mypageTable">
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col" style='width:524px; overflow: hidden; text-overflow: ellipsis; white-space: nowrap;'>문의 내용</th>
								<th scope="col">작성일</th>
								<th scope="col"></th>
							</tr>
						</thead>
						<tbody>
							<!-- <tr>
								<td><input type="checkbox" name="del-select" class="chk" value="selectOne"></td>
								<td scope="row">1</td>
								<td><a href="#" class="noColor">오늘의 자랑하기 : 민달래</a></td>
								<td>2021/05-21</td>
								<td>25</td>
								<td><button type="button" class="btn btn-outline-success btnGreen">수정</button>
								<button type="button" class="btn btn-outline-danger">삭제</button></td>
							</tr>

							<tr>
								<td><button type="button" class="btn btn-outline-warning">선택삭제</button></td>
								<td colspan="5"></td>
							</tr> -->
						</tbody>
					</table>

					<div class="row mt-5">
						<div class="col text-center">
							<div class="block-27">
								<input type="hidden" id="pageInfo" value="">
								<ul id="qna-page">
									<!-- <li><a href="#">&lt;</a></li>
									<li class="active"><span>1</span></li>
									<li><a name="page" href="#">2</a></li>
									<li><a name="page" href="#">3</a></li>
									<li><a name="page" href="#">4</a></li>
									<li><a name="page" href="#">5</a></li>
									<li><a href="#">&gt;</a></li> -->
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<script src="resources/js/mypage/mypageBoard.js"></script>

</body>
</html>

