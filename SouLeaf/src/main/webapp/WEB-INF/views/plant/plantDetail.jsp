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

   <section class="ftco-section ftco-no-pt ftco-no-pb">
    	<div class="container">
    		<div class="row d-flex no-gutters">
    			<div class="col-md-5 d-flex">
    <div id="carouselExampleFade" class="carousel slide carousel-fade img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0" data-ride="carousel">
  <div class="carousel-inner">
    <c:forEach items="${pfList }" var="pf" varStatus="status">
	<c:if test="${status.index eq 0 }">
	    <div class="carousel-item active">
	      <img src="resources/uploadFiles/plant/${pf.plantFileRename}" class="d-block w-100" alt="...">
	    </div>
	</c:if>  
	<c:if test="${status.index ne 0 }">
	    <div class="carousel-item">
	      <img src="resources/uploadFiles/plant/${pf.plantFileRename}" class="d-block w-100" alt="...">
	    </div>	
	</c:if>    
    </c:forEach>
  
  </div>
  <a class="carousel-control-prev" href="#carouselExampleFade" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleFade" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
    			<%-- <c:forEach items="${pfList }" var="pf">
    			
    				<div class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0" style="background-image:url(resources/uploadFiles/plant/${pf.plantFileName});">
    				</div>
    			</c:forEach> --%>
    				<!-- <div class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0" style="background-image:url(resources/images/about-1.jpg);">
    				</div> -->
    			</div>
    			<div class="col-md-7 pl-md-5 py-md-5">
    				<div class="heading-section pt-md-5">
    				<h6 style="color:#00b564">${plant.plantEngname }</h6>
	            <h2 class="mb-4">${plant.plantName }</h2>
	            <p>${plant.plantDetail }</p>
    				</div>
    				<div class="row">
	    				<div class="col-md-6 services-2 w-100 d-flex">
	    					<div class="icon d-flex align-items-center justify-content-center"><i class="fas fa-hand-holding-water pd-icon"></i></div>
	    					<div class="text pl-3">
	    						<h4>물 주기</h4>
	    						<p>${plant.plantWater }일</p>
	    					</div>
	    				</div>
	    				<div class="col-md-6 services-2 w-100 d-flex">
	    					<div class="icon d-flex align-items-center justify-content-center"><i class="fas fa-sun pd-icon"></i></div>
	    					<div class="text pl-3">
	    						<h4>햇빛 조건</h4>
	    						<p>${plant.plantEnvi }</p>
	    					</div>
	    				</div>
	    				<div class="col-md-6 services-2 w-100 d-flex">
	    					<div class="icon d-flex align-items-center justify-content-center"><i class="fas fa-tint pd-icon"></i></div>
	    					<div class="text pl-3">
	    						<h4>습도</h4>
	    						<p>${plant.plantHumidity }</p>
	    					</div>
	    				</div>
	    				<div class="col-md-6 services-2 w-100 d-flex">
	    					<div class="icon d-flex align-items-center justify-content-center"><i class="fas fa-pen-nib pd-icon"></i></div>
	    					<div class="text pl-3">
	    						<h4>학명</h4>
	    						<p>${plant.plantPlantae }</p>
	    					</div>
	    				</div>
	    			</div>
	        </div>
        </div>
    	</div>
    </section>

    <section class="ftco-section bg-light">
    	<div class="container">
    		<div class="row mb-5 pb-5">
          <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
            <div class="d-block services text-center">
            <!--   <div class="icon d-flex align-items-center justify-content-center">
            		<i class="far fa-lightbulb pdi-icon"></i>
              </div> -->
              <img src="/resources/images/plant/16063042309041빛.png" class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0" >
              <div class="media-body p-4">
                <h3 class="heading">빛 : ${pInfo.piLightInfo }</h3>
                <p style="text-align: left">${pInfo.piLightContents }</p>
                
              </div>
            </div>      
          </div>
          <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
            <div class="d-block services text-center">
             <!--  <div class="icon d-flex align-items-center justify-content-center">
            		<i class="fas fa-thermometer-half pdi-icon"></i>
              </div> -->
              <img src="/resources/images/plant/16063042378202온도.png" class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0">
              <div class="media-body p-4">
                <h3 class="heading">온도 : ${pInfo.piTempInfo }</h3>
                <p style="text-align: left">${pInfo.piTempContents }</p>
                
              </div>
            </div>    
          </div>
          <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
            <div class="d-block services text-center">
              <!-- <div class="icon d-flex align-items-center justify-content-center">
            		<i class="fas fa-smog pdi-icon"></i>
              </div> -->
              <img src="/resources/images/plant/16063042424423습도.png" class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0">
              <div class="media-body p-4">
                <h3 class="heading">습도 : ${pInfo.piHumidityInfo }</h3>
                <p style="text-align: left">${pInfo.piHumidityContents }</p>
                
              </div>
            </div>      
          </div>
        </div>
        <div class="row mt-5 pt-4">
        	<div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
            <div class="d-block services text-center">
           <!--    <div class="icon d-flex align-items-center justify-content-center">
            		<i class="fas fa-faucet pdi-icon"></i>
              </div> -->
              <img src="/resources/images/plant/16063042476954.물.png" class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0">
              <div class="media-body p-4">
                <h3 class="heading">물 : ${pInfo.piWaterInfo }</h3>
                <p style="text-align: left">${pInfo.piWaterContents }</p>
               
              </div>
            </div>      
          </div>
          <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
            <div class="d-block services text-center">
              <!-- <div class="icon d-flex align-items-center justify-content-center">
            		<i class="fas fa-leaf pdi-icon"></i>
              </div> -->
              <img src="/resources/images/plant/16063042531905.흙.png" class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0">
              <div class="media-body p-4">
                <h3 class="heading">흙 : ${pInfo.piEarthInfo }</h3>
                <p style="text-align: left">${pInfo.piEarthContents }</p>
                
              </div>
            </div>    
          </div>
          <div class="col-md-4 d-flex align-self-stretch px-4 ftco-animate">
            <div class="d-block services text-center">
              <!-- <div class="icon d-flex align-items-center justify-content-center">
            		<i class="fas fa-glass-whiskey pdi-icon"></i>
              </div> -->
              <img src="/resources/images/plant/16063042585056.분갈이.png" class="img img-video d-flex align-self-stretch align-items-center justify-content-center justify-content-md-center mb-4 mb-sm-0">
              <div class="media-body p-4">
                <h3 class="heading">분갈이 시기 알아보기</h3>
                <c:forTokens items="${pInfo.piBunting }" delims="⦁" var="bunting" varStatus="status">
                	<ul>
                		<li style="font-size: 14px; text-align: left">${bunting}</li>
                	</ul>
                </c:forTokens>
               
              </div>
            </div>      
          </div>
        </div>
    	</div>
        	
    </section>

<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="resources/js/plant/plant-detail.js"></script>
</body>
</html>