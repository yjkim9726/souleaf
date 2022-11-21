<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
<title>souLeaf - 내 댓글 관리</title>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css">
<link href='resources/css/mypage/mypageReply.css' rel='stylesheet' />
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
						href="#myPage-reply" role="tab" data-toggle="tab"> 댓글 모아보기 </a></li>				
				</ul>
			</div>

			<div class="col-md-12 tab-pane active" id="myPage-reply">
			<div align="right" class="custom-search">
    	 <span class="fa fa-search"></span>
	    	<input id="custom-filter" class="plant-search" placeholder="" type="text"/>
    	</div>
					 <table id="dataTable" class="row-border hover" style="width:100%">
        <thead>
            <tr>
                <!-- <th style="text-align: center"><input type="checkbox" id="check_all"></th> -->                
                <th>게시판</th>
                <th>댓글내용</th>
                <th>등록일</th>                
            </tr>
        </thead>
        <tbody>
                
          <c:forEach items="${myList }" var="my" varStatus="status">
          
	          <c:if test="${my.replyType eq '식물자랑' }">
    	        <tr style="cursor: pointer;" onclick="location.href='boastDetail.kh?boastNo=${my.boardNo}'">
       	      </c:if>
          	  <c:if test="${my.replyType eq '식물클리닉' }">
                <tr style="cursor: pointer;" onclick="location.href='clinicDetail.kh?clinicNo=${my.boardNo}'">
              </c:if>
              <c:if test="${my.replyType eq '궁금해요' }">
                <tr style="cursor: pointer;" onclick="location.href='curiosityDetail.kh?curiosityNo=${my.boardNo}'">
              </c:if>
                <%-- <td align="center"><input type="checkbox" value="${my.replyNo }" name="plant-check" class="checkbox_group"></td> --%>
                <c:if test="${my.replyType eq '식물자랑' }">
	                <td align="center"><span class="badge badge-primary" style="padding:5%; background-color:#e87390;">${my.replyType}</span></td>
                </c:if>
                <c:if test="${my.replyType eq '식물클리닉' }">
                <td align="center"><span class="badge badge-primary" style="padding:5%; background-color:#ae84ae;">${my.replyType}</span></td>
                </c:if>
                <c:if test="${my.replyType eq '궁금해요' }">
	                <td align="center"><span class="badge badge-primary" style="padding:5%; background-color:#779be7;">${my.replyType}</span></td>
                </c:if>
                <td >${my.replyContent }</td>
                <td >${my.replyDate }</td>
            </tr>
          </c:forEach>
        </tbody>
    </table>
    	<c:if test="${myList eq null }">
    	<div class="custom-form">댓글데이터 0 건</div>
    	</c:if>
    	<c:if test="${myList ne null }">
        <div class="custom-form">댓글데이터 ${myList.size()} 건</div>
        </c:if>
			</div>

			

		</div>
	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>
	<script src="resources/js/mypage/mypageReply.js"></script>

</body>
</html>

