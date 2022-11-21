<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="ko">
  <jsp:include page="common/header.jsp"></jsp:include>
  <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.css" rel="stylesheet">
  <link rel="stylesheet" href="resources/css/home/home-style.css">
  <!-- <script defer src="https://use.fontawesome.com/releases/v5.15.2/js/all.js" integrity="sha384-vuFJ2JiSdUpXLKGK+tDteQZBqNlMwAjhZ3TvPaDfN9QmbPb7Q8qUpbSNapQev3YF" crossorigin="anonymous"></script> -->

    <div class="hero-wrap js-fullheight" style="background-image: url('resources/images/main_bg_5.jpg');" data-stellar-background-ratio="0.5">
     <video class="video-intro" id="myVideo" poster="/resources/images/main_bg_25.jpg" playsinline autoplay muted loop>
      <source src="/resources/video/video-pc.mp4" type="video/mp4">
    </video>
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-center justify-content-center" data-scrollax-parent="true">
          <div class="col-md-11 ftco-animate text-center">
          

          	<h1 class="mb-4" style="  font-size: 4.58571vw;">누구나 식물을<br> 쉽게, 즐겁게, 함께</h1>
            <!-- <p><a href="#" class="btn btn-primary mr-md-4 py-3 px-4" id="more">Learn more <span class="ion-ios-arrow-forward"></span></a></p> -->
          </div>
        </div>
      </div>
    </div>

    <section class="ftco-section bg-light ftco-no-pt ftco-intro">
    	<div class="container">
    		<div class="row">
    		<!-- 반려 식물 리스트 -->
			<c:forEach items="${pRank }" var="pRank" varStatus="status">
			
				<div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
					<div class="d-block services active text-center">
						<div class="icon d-flex align-items-center justify-content-center">
							<!-- <i class="ri-medal-fill" style="font-size:40px; color:#FFD700;"></i> -->
							<c:if test="${status.index == 0}">
								<i class="fas fa-crown" style="font-size: 40px; color: #FFD700;"></i>
							</c:if>
							<c:if test="${status.index == 1}">
								<i class="fas fa-crown" style="font-size: 40px; color: #C0C0C0;"></i>
							</c:if>
								<c:if test="${status.index == 2}">
							<i class="fas fa-crown" style="font-size: 40px; color: #865d5a;"></i>
							</c:if>
						</div>
						<div class="media-body">
							<h3 class="heading" style="text-align: left">BEST ${status.index + 1}</h3>
							<div class="rank-form">
								<img src="resources/uploadFiles/plant/${pRank.plantFileRename }" style = "height: 272px"
									class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0">
								<div class="text pt-3 px-3 pb-4 text-center">
									<span class="position mb-2">${pRank.plantEngname }</span>
									<h3>${pRank.plantName }</h3>
								</div>
							</div>
						</div>
					</div>
				</div>
				
			</c:forEach>
<!--           <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate"> -->
<!--             <div class="d-block services active text-center"> -->
<!--               <div class="icon d-flex align-items-center justify-content-center"> -->
<!--             		<i class="ri-medal-fill" style="font-size:40px; color:#FFD700;"></i> -->
<!--             		<i class="fas fa-crown" style="font-size:40px; color:#FFD700;"></i> -->
<!--               </div> -->
<!--                <div class="media-body"> -->
<!--                 <h3 class="heading" style="text-align: left">BEST 1</h3> -->
<!--                 <div class="rank-form"> -->
<!--                   <img src="resources/uploadFiles/plant/120210531162553.jpg" class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0"> -->
<!--                   <div class="text pt-3 px-3 pb-4 text-center"> -->
<!-- 					<span class="position mb-2">Red box Gum</span> -->
<!-- 					<h3>유칼립투스 폴리안</h3> -->
<!-- 				</div> -->
<!-- 				</div> -->
<!--               </div> -->
<!--             </div>       -->
<!--           </div> -->
          
<!--           <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate"> -->
<!--             <div class="d-block services text-center"> -->
<!--               <div class="icon d-flex align-items-center justify-content-center"> -->
<!--             		<i class="ri-medal-fill" style="font-size:40px; color:#C0C0C0;"></i> -->
<!--             		<i class="fas fa-crown" style="font-size:40px; color:#C0C0C0;"></i> -->
<!--               </div> -->
<!--                <div class="media-body"> -->
<!--                 <h3 class="heading" style="text-align: left">BEST 2</h3> -->
<!--                 <div class="rank-form"> -->
<!--                   <img src="/resources/uploadFiles/plant/120210531142943.jpg" class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0"> -->
<!--                   <div class="text pt-3 px-3 pb-4 text-center"> -->
<!-- 					<span class="position mb-2">Red box Gum</span> -->
<!-- 					<h3>유칼립투스 폴리안</h3> -->
<!-- 				</div> -->
<!-- 				</div> -->
<!--               </div> -->
<!--             </div>     -->
<!--           </div> -->
          
<!--           <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate"> -->
<!--             <div class="d-block services text-center"> -->
<!--               <div class="icon d-flex align-items-center justify-content-center"> -->
<!--             		<i class="ri-medal-fill" style="font-size:40px; color:#865d5a;"></i> -->
<!--             		<i class="fas fa-crown" style="font-size:40px; color:#865d5a;"></i> -->
<!--               </div> -->
<!--               <div class="media-body"> -->
<!--                 <h3 class="heading" style="text-align: left">BEST 3</h3> -->
<!--                 <div class="rank-form"> -->
<!--                   <img src="/resources/uploadFiles/plant/120210531162046.jpg" class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0"> -->
<!--                   <div class="text pt-3 px-3 pb-4 text-center"> -->
<!-- 					<span class="position mb-2">Red box Gum</span> -->
<!-- 					<h3>유칼립투스 폴리안</h3> -->
<!-- 				</div> -->
<!-- 				</div> -->
<!--               </div> -->
<!--             </div>       -->
<!--           </div> -->
          
        </div>
    	</div>
    </section>
<div class="typing-txt"> 
  <ul>
    <li>라벤더</li>
    <li>로즈마리</li>
    <li>스투키</li>
</ul>

</div> 

  
    <section class="ftco-section ftco-no-pt ftco-no-pb " style="background: #fff">
    
    	<div class="container ftco-animate">
    		<div class="row d-flex no-gutters">

			<div class="col-md-12 pl-md-5 py-md-5">
				<div class="heading-section ftco-animate pt-md-5">
					<h3 class="mb-4" style="color: #00b564; font-weight: 800; font-size: 2vw">Plant
						Search</h3>
				</div>
				<div class="row ftco-animate" align="center">
					<div class="col-md-12 services-2 w-100 d-flex">
						<div class="text pl-3">
							<form action="plantSearch.kh" method="get" class="search-form">
								<div class="form-group ">
									<h1
										style="display: -webkit-inline-box; font-weight: 800; font-size: 4.78571vw;">
										나는&nbsp;<p class="typing"></p><input type="text" class="form-control plant-search"
											name="search" id="plantSearch" autocomplete="OFF"
											maxlength="11">를
									</h1>
								</div>
							</form>
							<h1 style="font-weight: 800; font-size: 4.78571vw;">잘 키우는 방법이</h1>
							<h1 style="font-weight: 800; font-size: 4.78571vw;">궁금하다.</h1>
						</div>
					</div>
				</div>
			</div>
		</div>
    	</div>
    </section>


    <section class="ftco-section ftco-faqs " style="background: #fff;">
    	<div class="container ftco-animate">
    		<div class="row">
    			<div class="col-lg-12" align="center">
    				<div class="heading-section mb-5 mt-5 mt-lg-0">
	            <h1 class="mb-3" style="font-size:     font-size: 3.21429vw"><strong><span id="plant-text">어떤 식물</span>을 찾고있나요?</strong></h1>
    				</div>
    				
    				
					<div class="form-group contactForm" id="kind-form">
						<div class="btn-group btn-group-toggle" data-toggle="buttons">
							<label class="btn btn-outline-success" for="plant-kind1" style="border-radius: 50px" onclick="kindSelect(1)"> 
							 	<input type="radio" name="plant-kind" id="plant-kind1" value="1"> 잎이 있는 식물
							 </label>&nbsp;&nbsp;
						    <label class="btn btn-outline-success" for="plant-kind2" style="border-radius: 50px" onclick="kindSelect(2)">
						     	<input type="radio" name="plant-kind" id="plant-kind2" value="2">공중식물
							</label>&nbsp;&nbsp; 
							<label class="btn btn-outline-success"	for="plant-kind3" style="border-radius: 50px" onclick="kindSelect(3)"> 
								<input type="radio" name="plant-kind" id="plant-kind3" value="3">다육식물
							</label>&nbsp;&nbsp; 
							<label class="btn btn-outline-success" for="plant-kind4" style="border-radius: 50px" onclick="kindSelect(4)">
							 	<input type="radio" name="plant-kind" id="plant-kind4" value="4">덩굴식물
							</label>
						</div>
					</div>
					
					<div class="form-group contactForm" id="property-form" style="display: none">
						<button class="btn btn-outline-success custom-btn"  onclick="resetSelect()">뒤로</button>&nbsp;&nbsp;						
						<div class="btn-group btn-group-toggle" data-toggle="buttons" >
							<label class="btn btn-outline-success" for="plant-property1" onclick="propertySelect(1)" style="border-radius: 50px">
								<input type="radio" name="plant-property" id="plant-property1"  value="1" > 공기정화
							</label>&nbsp;&nbsp;
							<label class="btn btn-outline-success" for="plant-property2" onclick="propertySelect(2)" style="border-radius: 50px">
								<input type="radio" name="plant-property" id="plant-property2" value="2"> 향기나는
							</label>&nbsp;&nbsp;
							<label class="btn btn-outline-success" for="plant-property3" onclick="propertySelect(3)" style="border-radius: 50px">
								<input type="radio" name="plant-property" id="plant-property3"  value="3" > 반려동물 안전한
							</label>&nbsp;&nbsp;
							<label class="btn btn-outline-success" for="plant-property4" onclick="propertySelect(4)" style="border-radius: 50px">
								<input type="radio" name="plant-property" id="plant-property4"  value="4" > 빛이 적어도 되는
							</label>&nbsp;&nbsp;
							<label class="btn btn-outline-success" for="plant-property5" onclick="propertySelect(5)" style="border-radius: 50px">
								<input type="radio" name="plant-property" id="plant-property5"  value="5" > 열매 맺는
							</label>&nbsp;&nbsp;
							<label class="btn btn-outline-success" for="plant-property6" onclick="propertySelect(6)" style="border-radius: 50px">
								<input type="radio" name="plant-property" id="plant-property6"  value="6" > 꽃이 피는
							</label>&nbsp;&nbsp;	
						</div>
							<button class="btn btn-outline-success custom-btn" id="select-btn" style="display: none" onclick="plantSelect()">검색</button>
					</div>
	        </div>
        </div>
    	</div>
    </section>
    
    <section class="ftco-section bg-light" style="padding: 0em 0 4em ;">
    <div class="container ftco-animate">
    		<div class="row d-flex no-gutters">
			<div class="col-md-12 pl-md-5 py-md-5">
				<div class="heading-section ftco-animate pt-md-5">
					<h3 class="mb-4" style="color: #00b564; font-weight: 800; font-size: 2vw">Plant
						Boast</h3>
				</div>			
			</div>
		</div>
    	</div>
      <div class="container ftco-animate">
        <div class="row justify-content-center pb-5 mb-3">
          <div class="col-md-7 heading-section text-center ftco-animate">
            <h2 style="font-size:3.21429vw">명예의 전당</h2>
          </div>
        </div>
        <div class="row d-flex">
        
        <c:forEach items="${bRank }" var="bRank" varStatus="status">
          <div class="col-md-4 d-flex ftco-animate">
            <div class="blog-entry align-self-stretch">
              <a href="boastDetail.kh?boastNo=${bRank.boastNo }" class="block-20 rounded" style="background-image: url('resources/uploadFiles/boast/${bRank.boastFileRename }');">
              </a>
              <div class="text p-4">
              <c:if test="${status.index == 0}">
               <i class="ri-medal-fill" style="font-size:40px; color:#FFD700; position: absolute; top: -5%;  right: 1%;"></i> 
              </c:if>
              <c:if test="${status.index == 1}">
               <i class="ri-medal-fill" style="font-size:40px; color:#C0C0C0; position: absolute; top: -5%;  right: 1%;"></i> 
              </c:if>
              <c:if test="${status.index == 2}">
               <i class="ri-medal-fill" style="font-size:40px; color:#865d5a; position: absolute; top: -5%;  right: 1%;"></i> 
              </c:if>
              	<div class="meta mb-2">
                  <div><a>${bRank.memberNick }</a></div>
                  <div><a>${bRank.boastDate }</a></div>
                  <br>
                  <div class="meta-chat"><span class="far fa-eye"></span>${bRank.boastCount }</div>
	                  <div class="meta-chat"><span class="fa fa-comment"></span>${bRank.boastLike }</div>
	                  <div class="meta-chat"><span class="fas fa-heart"></span>${bRank.boastReplyCount }</div><br>
                </div>
                <h3 class="heading boast-title"><a href="boastDetail.kh?boastNo=${bRank.boastNo }">${bRank.boastTitle }</a></h3>
                <br>
                <h6 class="text-success" style="font-size: 12px"><a href="plantDetailName.kh?plantName=${bRank.plantName}">#${bRank.plantName }</a></h6>
              </div>
            </div>
          </div>
         </c:forEach>
          
<!--           <div class="col-md-4 d-flex ftco-animate"> -->
<!--             <div class="blog-entry align-self-stretch"> -->
<!--               <a href="#" class="block-20 rounded" style="background-image: url('resources/images/main_bg_16.jpg');"> -->
<!--               </a> -->
<!--               <div class="text p-4"> -->
<!--                <i class="ri-medal-fill" style="font-size:40px; color:#FFD700; position: absolute; top: -5%;  right: 1%;"></i>  -->
<!--               	<div class="meta mb-2"> -->
<!--                   <div class="meta-chat"><span class="far fa-eye"></span> 1234</div> -->
<!-- 	                  <div class="meta-chat"><span class="fa fa-comment"></span> 1234</div> -->
<!-- 	                  <div class="meta-chat"><span class="fas fa-heart"></span> 1234</div><br> -->
<!--                   <div><a>작성자</a></div> -->
<!--                   <div><a>2021-06-01</a></div> -->
<!--                 </div> -->
<!--                 <h3 class="heading boast-title"><a href="#">Even the all-powerful Pointing has no control l about the blind l about the blind about the blind texts</a></h3> -->
<!--               </div> -->
<!--             </div> -->
<!--           </div> -->
          
<!--            <div class="col-md-4 d-flex ftco-animate"> -->
<!--             <div class="blog-entry align-self-stretch"> -->
<!--               <a href="#" class="block-20 rounded" style="background-image: url('resources/images/main_bg_16.jpg');"> -->
<!--               </a> -->
<!--               <div class="text p-4"> -->
<!--                <i class="ri-medal-fill" style="font-size:40px; color:#C0C0C0; position: absolute; top: -5%;  right: 1%;"></i>  -->
<!--               	<div class="meta mb-2"> -->
<!--                   <div class="meta-chat"><span class="far fa-eye"></span> 1234</div> -->
<!-- 	                  <div class="meta-chat"><span class="fa fa-comment"></span> 1234</div> -->
<!-- 	                  <div class="meta-chat"><span class="fas fa-heart"></span> 1234</div><br> -->
<!--                   <div><a>작성자</a></div> -->
<!--                   <div><a>2021-06-01</a></div> -->
<!--                 </div> -->
<!--                 <h3 class="heading boast-title"><a href="#">Even th no control l about the blind l about the blind about the blind texts</a></h3> -->
<!--               </div> -->
<!--             </div> -->
<!--           </div> -->
          
<!--           <div class="col-md-4 d-flex ftco-animate"> -->
<!--             <div class="blog-entry align-self-stretch"> -->
<!--               <a href="#" class="block-20 rounded" style="background-image: url('resources/images/main_bg_16.jpg');"> -->
<!--               </a> -->
<!--               <div class="text p-4"> -->
<!--                <i class="ri-medal-fill" style="font-size:40px; color:#865d5a; position: absolute; top: -5%;  right: 1%;"></i>  -->
<!--               	<div class="meta mb-2"> -->
<!--                   <div class="meta-chat"><span class="far fa-eye"></span> 1234</div> -->
<!-- 	                  <div class="meta-chat"><span class="fa fa-comment"></span> 1234</div> -->
<!-- 	                  <div class="meta-chat"><span class="fas fa-heart"></span> 1234</div><br> -->
<!--                   <div><a>작성자</a></div> -->
<!--                   <div><a>2021-06-01</a></div> -->
<!--                 </div> -->
<!--                 <h3 class="heading boast-title"><a href="#"> about the blind about the blind texts</a></h3> -->
<!--               </div> -->
<!--             </div> -->
<!--           </div> -->
          
        </div>
      </div>
    </section>

      <section class="ftco-appointment ftco-section ftco-no-pt ftco-no-pb img" style="background-image: url(resources/images/main_bg_29.jpg);" >
      <div class="clinic-overlay"></div>
    	<div class="container ftco-animate">
    		<div class="row d-flex no-gutters">

			<div class="col-md-12 pl-md-5 py-md-5">
				<div class="heading-section pt-md-5">
					<h3 class="mb-4" style="color: #00b564; font-weight: 800; font-size: 2vw">Plant
						Clinic</h3>
				</div>
				<div class="row ftco-animate" align="center">
					<div class="col-md-12 services-2 w-100 d-flex">
						<div class="text pl-3">
							<form action="clinicMainSearch.kh" method="get">
								<div class="form-group ">
									<h1
										style="display: -webkit-inline-box; font-weight: 800; font-size: 4.78571vw; color:#fff;">
										잘 키우고 싶은데<br>
										반려 식물이 아파요<br>
										
									</h1>
								</div>
							  <div class="form-group">
				                  <input type="text" class="clinic-search" name="searchValue" autocomplete="OFF">
				                  <span class="fa fa-search" style="font-size:2.78571vw; color:#eee;"></span>
				                </div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
    	</div>
    </section>
    
    
    
  <jsp:include page="common/footer.jsp"></jsp:include> 
  <script src="resources/js/home/home.js"></script>
   
  </body>
</html>