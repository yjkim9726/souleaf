<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>souLeaf - 식물도감</title>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" href="resources/css/plant/plant-style.css">

</head>
<body>

<!--   <section class="hero-wrap hero-wrap-2" style="background-image: url('resources/images/main_bg_1.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs mb-2"><span class="mr-2"><a href="home.kh">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Blog <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-0 bread">식물도감</h1>
          </div>
        </div>
      </div>
    </section> -->
      <section class="ftco-section bg-light divup">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-5">
						<h2 class="heading-section">식물도감 수정</h2>
					</div>
				</div>
				
				<div class="row justify-content-center">
					<div class="col-md-12">
						<div class="wrapper">
							<div class="row mb-5">
								<div class="col-md-4">
									<div class="dbox w-100 text-center">
				        		<div class="picon d-flex align-items-center justify-content-center" id="step1">
				        			<span class="fas fa-seedling"></span>
				        		</div>
				        		<div class="text">
					            <p><span id="ptext1">기본정보 입력</span></p>
					          </div>
				          </div>
								</div>
								<div class="col-md-4">
									<div class="dbox w-100 text-center">
				        		<div class="picon d-flex align-items-center justify-content-center" id="step2">
				        			<span class="fab fa-pagelines"></span>
				        		</div>
				        		<div class="text">
					            <p><span id="ptext2">상세정보 입력</span></p>
					          </div>
				          </div>
								</div>
								<div class="col-md-4">
									<div class="dbox w-100 text-center">
				        		<div class="picon d-flex align-items-center justify-content-center" id="step3">
				        			<span class="far fa-images"></span>
				        		</div>
				        		<div class="text">
					            <p><span id="ptext3">이미지 등록</span></p>
					          </div>
				          </div>
								</div>
							
							</div>
							<form action="plantUpdate.kh" method="post" enctype="multipart/form-data">
							
							
							<div class="row no-gutters" id="pform1">
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<h3 class="mb-4">기본정보</h3>
										<div class="contactForm">
											<div class="row">
												<div class="col-md-4">
													<div class="form-group">
														<label class="label" for="name">종류</label>
														<select class="form-control" name="plantKind" id="plantKind">
															<option value="1" <c:if test="${plant.plantKind =='1' }">selected</c:if>>잎이 있는 식물</option>
															<option value="2" <c:if test="${plant.plantKind =='2' }">selected</c:if>>공중식물</option>
															<option value="3" <c:if test="${plant.plantKind =='3' }">selected</c:if>>다육식물</option>
															<option value="4" <c:if test="${plant.plantKind =='4' }">selected</c:if>>덩굴식물</option>
														</select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label class="label" for="name">특성</label>
														<select class="form-control" name="plantProperty" id="plantProperty">
															<option value="1" <c:if test="${plant.plantProperty =='1' }">selected</c:if>>공기정화</option>
															<option value="2" <c:if test="${plant.plantProperty =='2' }">selected</c:if>>향기나는</option>
															<option value="3" <c:if test="${plant.plantProperty =='3' }">selected</c:if>>반려동물 안전한</option>
															<option value="4" <c:if test="${plant.plantProperty =='4' }">selected</c:if>>빛이 적어도 되는</option>
															<option value="5" <c:if test="${plant.plantProperty =='5' }">selected</c:if>>열매 맺는</option>
															<option value="6" <c:if test="${plant.plantProperty =='6' }">selected</c:if>>꽃이 피는</option>
														</select>
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<label class="label" for="name">잎모양</label>
														<select class="form-control" name="plantLeaf" id="plantLeaf">
															<option value="1" <c:if test="${plant.plantLeaf =='1' }">selected</c:if>>넑은</option>
															<option value="2" <c:if test="${plant.plantLeaf =='2' }">selected</c:if>>둥근</option>
															<option value="3" <c:if test="${plant.plantLeaf =='3' }">selected</c:if>>뾰족한</option>
															<option value="4" <c:if test="${plant.plantLeaf =='4' }">selected</c:if>>길쭉한</option>
															<option value="5" <c:if test="${plant.plantLeaf =='5' }">selected</c:if>>갈라진</option>
															<option value="6" <c:if test="${plant.plantLeaf =='6' }">selected</c:if>>하트모양</option>
															<option value="7" <c:if test="${plant.plantLeaf =='7' }">selected</c:if>>별모양</option>
															<option value="8" <c:if test="${plant.plantLeaf =='8' }">selected</c:if>>작은</option>
															<option value="9" <c:if test="${plant.plantLeaf =='9' }">selected</c:if>>두꺼운</option>
															<option value="10" <c:if test="${plant.plantLeaf =='10' }">selected</c:if>>무늬</option>
														</select>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="name">식물 이름(한글)</label>
														<input type="text" class="form-control" name="plantName" id="plantName" value="${plant.plantName }">
													</div>
												</div>
												<div class="col-md-6"> 
													<div class="form-group">
														<label class="label" for="email">식물 이름(영어)</label>
														<input type="text" class="form-control" name="plantEngname" id="plantEngname" value="${plant.plantEngname }">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">학명</label>
														<input type="text" class="form-control" name="plantPlantae" id="plantPlantae" value="${plant.plantPlantae }">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">물 주기</label>
														<input type="number" class="form-control" name="plantWater" id="plantWater" value="${plant.plantWater }">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">빛 정보</label>
														<input type="text" class="form-control" name="plantEnvi" id="plantEnvi" value="${plant.plantEnvi }">
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">습도 정보</label>
														<input type="text" class="form-control" name="plantHumidity" id="plantHumidity" value="${plant.plantHumidity }">
													</div>
												</div>
												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="#">식물 설명</label>
														<textarea name="plantDetail" class="form-control" id="plantDetail" cols="30" rows="4" placeholder="상세설명">${plant.plantDetail }</textarea>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<input type="button" value="다음 단계" class="btn btn-primary" onclick="fnMove(2)">
														<div class="submitting"></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 1 -->
							
							<div class="row no-gutters" id="pform2">
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<h3 class="mb-4">상세정보</h3>
										<div class="contactForm">
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="name">빛 종류</label><br>
														<div class="btn-group btn-group-toggle" data-toggle="buttons">
															<label class="btn btn-outline-success <c:if test="${pInfo.piLightInfo =='부드러운 햇빛' }">active</c:if>">
																<input type="radio" name="piLightInfo" id="piLightInfo-1" value="부드러운 햇빛" <c:if test="${pInfo.piLightInfo =='부드러운 햇빛' }">checked</c:if> > 부드러운 햇빛
															</label>
															<label class="btn btn-outline-success <c:if test="${pInfo.piLightInfo =='풍부한 햇빛' }">active</c:if>">
																<input type="radio" name="piLightInfo" id="piLightInfo-2" value="풍부한 햇빛" <c:if test="${pInfo.piLightInfo =='풍부한 햇빛' }">checked</c:if>> 풍부한 햇빛
															</label>
															<label class="btn btn-outline-success <c:if test="${pInfo.piLightInfo =='강렬한 햇빛' }">active</c:if>">
																<input type="radio" name="piLightInfo" id="piLightInfo-3" value="강렬한 햇빛" <c:if test="${pInfo.piLightInfo =='강렬한 햇빛' }">checked</c:if>> 강렬한 햇빛
															</label>
														</div>
													</div>
												</div>												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="name">빛 내용</label>
														<textarea class="form-control" name="piLightContents"  id="piLightContents" cols="30" rows="2" >${pInfo.piLightContents }</textarea>
													</div>
												</div>
												<div class="col-md-12">　</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">온도 종류</label><br>
														<div class="btn-group btn-group-toggle" data-toggle="buttons">
															<label class="btn btn-outline-success <c:if test="${pInfo.piTempInfo =='따뜻한 온도' }">active</c:if>">
																<input type="radio" name="piTempInfo" id="piTempInfo-1" value="따뜻한 온도" <c:if test="${pInfo.piTempInfo =='따뜻한 온도' }">checked</c:if>> 따뜻한 온도
															</label>
															<label class="btn btn-outline-success <c:if test="${pInfo.piTempInfo =='서늘한 온도' }">active</c:if>">
																<input type="radio" name="piTempInfo" id="piTempInfo-2" value="서늘한 온도" <c:if test="${pInfo.piTempInfo =='서늘한 온도' }">checked</c:if>> 서늘한 온도
															</label>
															<label class="btn btn-outline-success <c:if test="${pInfo.piTempInfo =='시원한 온도' }">active</c:if>">
																<input type="radio" name="piTempInfo" id="piTempInfo-3" value="시원한 온도" <c:if test="${pInfo.piTempInfo =='시원한 온도' }">checked</c:if>> 시원한 온도
															</label>
														</div>
													</div>
												</div>	
																							
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">온도 내용</label>
														<textarea class="form-control" name="piTempContents"  id="piTempContents" cols="30" rows="2" >${pInfo.piTempContents }</textarea>
													</div>
												</div>
												<div class="col-md-12">　</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">습도 종류</label><br>
														<div class="btn-group btn-group-toggle" data-toggle="buttons">
															<label class="btn btn-outline-success <c:if test="${pInfo.piHumidityInfo =='쾌적한 습도' }">active</c:if>">
																<input type="radio" name="piHumidityInfo" id="piHumidityInfo-1" value="쾌적한 습도" <c:if test="${pInfo.piHumidityInfo =='쾌적한 습도' }">checked</c:if>> 쾌적한 습도
															</label>
															<label class="btn btn-outline-success <c:if test="${pInfo.piHumidityInfo =='건조한 습도' }">active</c:if>">
																<input type="radio" name="piHumidityInfo" id="piHumidityInfo-2" value="건조한 습도" <c:if test="${pInfo.piHumidityInfo =='건조한 습도' }">checked</c:if>> 건조한 습도
															</label>
															<label class="btn btn-outline-success <c:if test="${pInfo.piHumidityInfo =='높은 습도' }">active</c:if>">
																<input type="radio" name="piHumidityInfo" id="piHumidityInfo-3" value="높은 습도" <c:if test="${pInfo.piHumidityInfo =='높은 습도' }">checked</c:if>> 높은 습도
															</label>
															<label class="btn btn-outline-success <c:if test="${pInfo.piHumidityInfo =='다소 높은 습도' }">active</c:if>">
																<input type="radio" name="piHumidityInfo" id="piHumidityInfo-4" value="다소 높은 습도" <c:if test="${pInfo.piHumidityInfo =='다소 높은 습도' }">checked</c:if>> 다소 높은 습도
															</label>
														</div>
													</div>
												</div>												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">습도 내용</label>
														<textarea class="form-control" name="piHumidityContents"  id="piHumidityContents" cols="30" rows="2" >${pInfo.piHumidityContents }</textarea>
													</div>
												</div>
												<div class="col-md-12">　</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">물 종류</label>
														<div class="btn-group btn-group-toggle" data-toggle="buttons">
															<label class="btn btn-outline-success <c:if test="${pInfo.piWaterInfo =='약간 목마르게' }">active</c:if>">
																<input type="radio" name="piWaterInfo" id="piWaterInfo-1" value="약간 목마르게" <c:if test="${pInfo.piWaterInfo =='약간 목마르게' }">checked</c:if>> 약간 목마르게
															</label>
															<label class="btn btn-outline-success <c:if test="${pInfo.piWaterInfo =='흙이 바싹 마르지 않게' }">active</c:if>">
																<input type="radio" name="piWaterInfo" id="piWaterInfo-2" value="흙이 바싹 마르지 않게" <c:if test="${pInfo.piWaterInfo =='흙이 바싹 마르지 않게' }">checked</c:if>> 흙이 바싹 마르지 않게
															</label>
															<label class="btn btn-outline-success <c:if test="${pInfo.piWaterInfo =='흙이 촉촉하게 젖도록' }">active</c:if>">
																<input type="radio" name="piWaterInfo" id="piWaterInfo-3" value="흙이 촉촉하게 젖도록" <c:if test="${pInfo.piWaterInfo =='흙이 촉촉하게 젖도록' }">checked</c:if>> 흙이 촉촉하게 젖도록
															</label>
															<label class="btn btn-outline-success <c:if test="${pInfo.piWaterInfo =='흙이 말랐을 때 듬뿍' }">active</c:if>">
																<input type="radio" name="piWaterInfo" id="piWaterInfo-4" value="흙이 말랐을 때 듬뿍" <c:if test="${pInfo.piWaterInfo =='흙이 말랐을 때 듬뿍' }">checked</c:if>> 흙이 말랐을 때 듬뿍
															</label>
														</div>
													</div>
												</div>												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">물 내용</label>
														<textarea class="form-control" name="piWaterContents"  id="piWaterContents" cols="30" rows="2" >${pInfo.piWaterContents }</textarea>
													</div>
												</div>
												<div class="col-md-12">　</div>
												<div class="col-md-6">
													<div class="form-group">
														<label class="label" for="subject">흙 종류</label><br>
															<div class="btn-group btn-group-toggle" data-toggle="buttons">
															<label class="btn btn-outline-success <c:if test="${pInfo.piEarthInfo =='배수가 잘되는 흙' }">active</c:if>">
																<input type="radio" name="piEarthInfo" id="piEarthInfo-1" value="배수가 잘되는 흙" <c:if test="${pInfo.piEarthInfo =='배수가 잘되는 흙' }">checked</c:if>> 배수가 잘되는 흙
															</label>
															<label class="btn btn-outline-success <c:if test="${pInfo.piEarthInfo =='배수가 안되는 흙' }">active</c:if>">
																<input type="radio" name="piEarthInfo" id="piEarthInfo-2" value="배수가 안되는 흙" <c:if test="${pInfo.piEarthInfo =='배수가 안되는 흙' }">checked</c:if>> 배수가 안되는 흙
															</label>															
														</div>
													</div>
												</div>												
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="subject">흙 내용</label>
														<textarea class="form-control" name="piEarthContents"  id="piEarthContents" cols="30" rows="2" >${pInfo.piEarthContents }</textarea>
													</div>
												</div>			
												<div class="col-md-12">　</div>									
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="#">분갈이 시기</label>
														<textarea name="piBunting" class="form-control" id="piBunting" cols="30" rows="4" >${pInfo.piBunting }</textarea>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
													<input type="button" value="이전 단계" class="btn btn-primary" onclick="fnMove(1)">
														<input type="button" value="다음 단계" class="btn btn-primary" onclick="fnMove(3)">
														<div class="submitting"></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 2 -->
							
									<div class="row no-gutters" id="pform3">
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<h3 class="mb-4">이미지 등록</h3>
										기존파일 리스트 
										<ul>
										<c:forEach items="${pfList }" var="pf" varStatus="status">
										<li id="li${status.index }">${pf.plantFileName}<input type="button" class="btn btn-outline-danger btn-xs" onclick="deleteFile(${status.index },${plant.plantNo },${pf.plantFileNo},'${pf.plantFileRename }')" value="삭제"></li>
										</c:forEach>
										</ul>
										<div class="contactForm">
											<div class="row">
												<div class="col-md-12">
													<div class="form-group">
	
<!-- <div id="fileUpload" class="dragAndDropDiv">Drag & Drop Files Here or Browse Files</div>
        <input type="file" name="fileUpload" id="fileUpload" style="display:none;" multiple/> -->
<center>
<span class="btn btn-light fileinput-button">
    <i class="glyphicon glyphicon-plus"></i>
    <span>Drag and Drop files...</span>
    <input type="file" name="ufile" id="ufile" multiple>
</span>
</center>    
        
<div id="output"><ul></ul></div>

													</div>
												</div>
												
													<div class="col-md-12">
													<div class="form-group">
													<input type="hidden" name="plantNo" id="plantNo" value="${plant.plantNo }"/>
													<input type="hidden" name="plantinfoNo" id="plantinfoNo" value="${pInfo.plantinfoNo }"/>
													<input type="button" value="이전 단계" class="btn btn-primary" onclick="fnMove(2)">
														<input type="submit" value="등록" class="btn btn-primary">
														<div class="submitting"></div>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- 3 -->
							</form>
						</div>
					</div>
				</div>
			</div>
		</section>
    
   

<jsp:include page="../common/footer.jsp"></jsp:include>
  <script src="resources/js/plant/plant-main.js"></script>
</body>
</html>