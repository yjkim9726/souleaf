<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../common/loginCheck.jsp"></jsp:include>
<jsp:include page="../common/header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/select/1.3.3/css/select.dataTables.min.css">
<link href='resources/css/admin/admin-style.css' rel='stylesheet' />
</head>
<body>

    <section class="ftco-section ftco-degree-bg">
      <div class="container">
        <div class="row">
         <div class="col-lg-3 sidebar pl-lg-5 ftco-animate">
            <div class="sidebar-box">
              <div class="x1 x2"><h3><a href="adminHome.kh">SOULEAF ADMIN</a></h3></div>
            </div>
            <div class="sidebar-box ftco-animate">
              <div class="categories">
                <li><a href="adminPlant.kh" >도감 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="adminMember.kh">회원 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="adminBoard.kh">게시글 관리 <span class="fa fa-chevron-right"></span></a></li>
                <li><a href="adminQna.kh" style=" color: #00bd56;">Q&A 관리 <span class="fa fa-chevron-right"></span></a></li>
              </div>
            </div>

          </div> <!-- .col-md-3 -->
          
          <div class="col-lg-9 ftco-animate">
          
    	    <section class="mt-3" style="position: relative;">
				    	<div class="container">    	  
				    	<div align="right" class="custom-search">
				    	 <span class="fa fa-search"></span>
					    	<input id="custom-filter1" class="plant-search" placeholder="" type="text"/>
				    	</div>
				    		 <table id="dataTable1" class="row-border hover" style="width:100%">
				        <thead>
				            <tr>
				                <th style="text-align: center; width:50px"><input type="checkbox" id="check_all1"></th>
				                <th>내용</th>
				                <th>작성자</th>
				                <th>등록일</th>
				                <th>답변여부</th>
				            </tr>
				        </thead>
				        <tbody>
				        </tbody>
				                
				         
				    </table>
					    <div class="custom-btn-form">
						    <input type="button" id="qna-delete" class="btn btn-danger" value="삭제">
					    </div>
				         <div class="custom-form">Q&A데이터 <span id="qna-count"></span> 건</div>
				         
				    	</div>
				    </section>
       

          </div> <!-- .col-md-9 -->
        

        </div>
      </div>
    </section> <!-- .section -->

<jsp:include page="../common/footer.jsp"></jsp:include>  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/select/1.3.3/js/dataTables.select.min.js"></script>
<script src="resources/js/admin/admin-qna.js"></script>

</body>
</html>