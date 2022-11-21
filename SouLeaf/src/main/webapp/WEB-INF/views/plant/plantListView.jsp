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

  <section class="hero-wrap hero-wrap-2" style="background-image: url('resources/images/main_bg_35.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs mb-2"><span class="mr-2"><a href="home.kh">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Blog <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-0 bread">식물도감</h1>
          </div>
        </div>
      </div>
    </section>
    
    
    
   <section class="ftco-section bg-light">
   <c:if test="${kind eq '0' }">
   <input type="hidden" id="kind-status" value="0">
   </c:if>
   <input type="hidden" id="kind-status" value="${kind }">
   <c:if test="${property eq '0' }">
   <input type="hidden" id="property-status" value="0">
   </c:if>
   <input type="hidden" id="property-status" value="${property }">
   <c:if test="${leaf eq '0' }">
   <input type="hidden" id="leaf-status" value="1,2,3,4,5,6,7,8,9,10">
   </c:if>
   <input type="hidden" id="leaf-status" value="${leaf }">
			<div class="container">
			<h2>어떤 종류의 식물을 찾고 있나요?</h2><br> 
<div class="form-group contactForm" id="kind-form">
	<label class="label" for="name">종류</label><br>
	<div class="btn-group btn-group-toggle" data-toggle="buttons" >
	<button class="btn btn-success reset-btn" onclick="resetSelect()" style="border-radius: 25px"><img src="/resources/images/plant/reset-btn.png" width="20"></button>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${kind eq '1' }">active</c:if>" for="plant-kind1" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-kind" id="plant-kind1" value="1"> 잎이 있는 식물
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${kind eq '2' }">active</c:if>" for="plant-kind2" onclick="getPlantSearchList(this)" style="border-radius: 25px" >
			<input type="radio" name="plant-kind" id="plant-kind2" value="2" > 공중식물
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${kind eq '3' }">active</c:if>" for="plant-kind3" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-kind" id="plant-kind3" value="3" > 다육식물
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${kind eq '4' }">active</c:if>" for="plant-kind4" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-kind" id="plant-kind4" value="4" > 덩굴식물
		</label>
	</div>
</div>
<div class="form-group contactForm" id="property-form">
	<label class="label" for="name">특성</label><br>
	<div class="btn-group btn-group-toggle" data-toggle="buttons" >
		<label class="btn btn-outline-success <c:if test="${property eq '1' }">active</c:if>" for="plant-property1" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-property" id="plant-property1"  value="1" > 공기정화
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${property eq '2' }">active</c:if>" for="plant-property2" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-property" id="plant-property2" value="2"> 향기나는
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${property eq '3' }">active</c:if>" for="plant-property3" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-property" id="plant-property3"  value="3" > 반려동물 안전한
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${property eq '4' }">active</c:if>" for="plant-property4" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-property" id="plant-property4"  value="4" > 빛이 적어도 되는
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${property eq '5' }">active</c:if>" for="plant-property5" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-property" id="plant-property5"  value="5" > 열매 맺는
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${property eq '6' }">active</c:if>" for="plant-property6" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-property" id="plant-property6"  value="6" > 꽃이 피는
		</label>&nbsp;&nbsp;		
	</div>
</div>
<div class="form-group contactForm" id="leaf-form">
	<label class="label" for="name">잎</label><br>
	<div class="btn-group btn-group-toggle" data-toggle="buttons" >
		<label class="btn btn-outline-success <c:if test="${leaf eq '1' }">active</c:if>" for="plant-leaf1" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-leaf" id="plant-leaf1" value="1" > 넓은
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${leaf eq '2' }">active</c:if>" for="plant-leaf2" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-leaf" id="plant-leaf2" value="2"> 둥근
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${leaf eq '3' }">active</c:if>" for="plant-leaf3" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-leaf" id="plant-leaf3" value="3" > 뾰족한
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${leaf eq '4' }">active</c:if>" for="plant-leaf4" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-leaf" id="plant-leaf4" value="4" > 길쭉한
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${leaf eq '5' }">active</c:if>" for="plant-leaf5" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-leaf" id="plant-leaf5" value="5" > 갈라진
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${leaf eq '6' }">active</c:if>" for="plant-leaf6" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-leaf" id="plant-leaf6" value="6" > 하트모양
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${leaf eq '7' }">active</c:if>" for="plant-leaf7" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-leaf" id="plant-leaf7" value="7" > 별모양
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${leaf eq '8' }">active</c:if>" for="plant-leaf8" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-leaf" id="plant-leaf8" value="8" > 작은
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${leaf eq '9' }">active</c:if>" for="plant-leaf9" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-leaf" id="plant-leaf9" value="9" > 두꺼운
		</label>&nbsp;&nbsp;
		<label class="btn btn-outline-success <c:if test="${leaf eq '10' }">active</c:if>" for="plant-leaf10" onclick="getPlantSearchList(this)" style="border-radius: 25px">
			<input type="radio" name="plant-leaf" id="plant-leaf10" value="10" > 무늬
		</label>&nbsp;&nbsp;
	</div><br><br>	
	<div class="form-group" ></div>
	
</div><br>
			 <form action="plantSearch.kh" method="get" class="search-form">
                <div class="form-group">
                  <span class="fa fa-search"></span>
                  <input type="text" class="form-control plant-search" name="search" placeholder="식물 이름을 검색해 주세요." autocomplete="OFF">
                </div>
              </form>
               식물데이터 <span id="plant-count">0</span> 건
              <br><br>
             
				<div class="row" id="plant-list">
				<div id="no-list"></div>
					<!-- <div class="col-md-6 col-lg-3 ftco-animate">
						<div class="staff">
							<div class="img-wrap d-flex align-items-stretch">
								<div class="img align-self-stretch" style="background-image: url(images/staff-1.jpg);"></div>
							</div>
							<div class="text pt-3 px-3 pb-4 text-center">
								<h3>Lloyd Wilson</h3>
								<span class="position mb-2">Health Coach</span>
								<div class="faded">
									<p>I am an ambitious workaholic, but apart from that, pretty simple person.</p>									
	             				 </div>
							</div>
						</div>
					</div> -->
				</div>
			</div>
		</section>

<jsp:include page="../common/footer.jsp"></jsp:include>
<script src="resources/js/plant/plant-list.js"></script>
</body>
</html>