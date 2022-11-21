<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
 <jsp:include page="../common/header.jsp"></jsp:include> 
 

  <section class="ftco-section bg-light ftco-faqs">
    	<div class="container">
    		<div class="row">
    			
			
    			<div class="col-lg-12">
    				<div class="heading-section mb-5 mt-5 mt-lg-0">
	            <h2 class="mb-3">Frequently Asks Questions</h2>
	            <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
    				</div>
    				<div id="accordion" class="myaccordion w-100" aria-multiselectable="true">
    				
    				<c:forEach items="${qList }" var="qna" varStatus="status">
			
			
			
						  <div class="card">
						    <div class="card-header p-0" id="heading${status.index }" role="tab">
						      <h2 class="mb-0">
						        <button href="#collapse${status.index }" class="d-flex py-3 px-4 align-items-center justify-content-between btn btn-link" data-parent="#accordion" data-toggle="collapse" aria-expanded="false" aria-controls="collapse${status.index }">
						        	<p class="mb-0">${qna.qnaTitle }</p>
						          <i class="fa" aria-hidden="true"></i>
						        </button>
						      </h2>
						    </div>
						    <div class="collapse" id="collapse${status.index }" role="tabpanel" aria-labelledby="heading${status.index }">
						      <div class="card-body py-3 px-0">
						      	<ol>
						      		<li>Far far away, behind the word mountains</li>
						      		<li>Consonantia, there live the blind texts</li>
						      		<li>When she reached the first hills of the Italic Mountains</li>
						      		<li>Bookmarksgrove, the headline of Alphabet Village</li>
						      		<li>Separated they live in Bookmarksgrove right</li>
						      	</ol>
						      </div>
						    </div>
						  </div>
                 </c:forEach>
				</div>
	        </div>
        </div>
    	</div>
    </section>

 <jsp:include page="../common/footer.jsp"></jsp:include> 
</body>
</html>