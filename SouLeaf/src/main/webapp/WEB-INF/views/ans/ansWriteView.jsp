<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>Q&A</title>
 	<jsp:include page="../common/header.jsp"></jsp:include> 
    <link rel="stylesheet" href="resources/css/member/member-style.css">
    <link rel="stylesheet" href="resources/css/summernote/summernote-lite.css">
  </head>
  <body>
 

 <section class="ftco-section bg-light">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-md-6 text-center mb-5">
						<h2 class="heading-section">Q&A</h2>
					</div>
				</div>
				<div class="row justify-content-center">
					<div class="col-md-12">
						<div class="wrapper">
						
							<div class="row no-gutters">
							
								<div class="col-md-12">
									<div class="contact-wrap w-100 p-md-5 p-4">
										<!-- <h3 class="mb-4">Contact Us</h3> -->
										<form action="ansRegister.kh" method="post" enctype="multipart/form-data">
											<div class="row">
										
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="#">Q:</label>
														${qna.qnaContent }
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
														<label class="label" for="#">답변내용</label>
														<textarea name="ansContent" class="form-control" id="" cols="30" rows="4" placeholder="답변을 적어주세요." required></textarea>
													</div>
												</div>
												<div class="col-md-12">
													<div class="form-group">
													<input type="hidden" name="qnaNo" value="${qnaNo }">
														<input type="submit" class="btn btn-outline-success" value="등록" >
         												<input type="button"  class="btn btn-outline-success" onclick="location.href='adminQna.kh'" value="취소">
														<div class="submitting"></div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
 
 


 
 



    <jsp:include page="../common/footer.jsp"></jsp:include> 
    <script src="resources/js/member/main.js"></script>
    <script src="resources/js/summernote/summernote-lite.js"></script>
    
<script>
	
$('#summernote').summernote({
    placeholder: '여기에 내용 입력하세요~ ',
    tabsize: 2,
    height: 500, // 에디터 높이
    defaultFontName: '바탕체',
    toolbar: [
['style', ['style']],
['fontname', ['fontname']],
['fontsize', ['fontsize']],
['font style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
['color', ['forecolor','color']],
['para', ['ul', 'ol', 'paragraph']],
['table', ['table']],

['view', ['codeview', 'help']],
],
defaultFontName:'바탕',
fontNames: ['Arial', 'Comic Sans MS','맑은 고딕','궁서','굴림','돋음체','바탕'],
fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
maximumImageFileSize:2097152,

popover: {
              image: [
                ['image', ['resizeFull', 'resizeHalf', 'resizeQuarter', 'resizeNone']],
                ['float', ['floatLeft', 'floatRight', 'floatNone']],
                ['remove', ['removeMedia']]
              ],
              link: [
                ['link', ['linkDialogShow', 'unlink']]
              ],
              table: [
                ['add', ['addRowDown', 'addRowUp', 'addColLeft', 'addColRight']],
                ['delete', ['deleteRow', 'deleteCol', 'deleteTable']],
              ],
              air: [
                ['color', ['color']],
                ['font', ['bold', 'underline', 'clear']],
                ['para', ['ul', 'paragraph']],
                ['table', ['table']],
               
              ]
            }
  });
$('.dropdown-toggle').dropdown()
</script>
  </body>
</html>