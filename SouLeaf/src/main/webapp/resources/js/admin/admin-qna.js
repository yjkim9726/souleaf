$(function(){
	getQnaList(); // 함수 호출
	$("#qna-delete").on("click", function(){
		deleteQna();
	});

	$("#check_all1").on("click", function(){
		var checked = $(this).is(":checked");
		if(checked){
			$(".checkbox_group1").prop("checked",true);
		}else{
			$(".checkbox_group1").prop("checked",false);
		}
	});
		
});
function getQnaList(){ // 함수 선언
	let dataTable1 = $('#dataTable1').DataTable({
		'autoWidth': false,
		destroy: true,
		"bLengthChange": false,
		"bInfo": false,		
		  order: [[3, 'desc']],
		  language: {
			paginate: {
				previous: '<span class="icon md-chevron-left"><</span>',
				next: '<span class="icon md-chevron-left">></span>'
			}
		},
			ajax:{
				url:"adminQnaList.kh",
				type:"get",
				dataType:"json",
				"dataSrc": function ( json ) {							
					$("#qna-count").text(json.data.length);
					return json.data;
				}    
			},
			columns:[
			
				{ orderable: false,
					data: "qnaNo",
					className : "qna-check",
					render: function(data){					
						return '<input type="checkbox" class="checkbox_group1" name="qna-check" value="'+data+'">';
					}
			    },
				{ data: "qnaContent",
				render: function(data, target, row){	
					if(data.length>15){
						data = data.substr(0,15)+"...";
					}					
					return '<a href="qnaListView.kh" class="boast-title">'+data+'</a>';
				}
			 },
				{ data: "memberNick" },
				{ data: "qnaDate" },
				{ data: "ansNo", 
			     "defaultContent":"null",
				 render: function(data, target, row){
					 var str = "";
					 if(data != null){
						 str = '<a href="ansUpdateView.kh?qnaNo='+row.qnaNo+'" class="boast-title text-success" >답변완료</a>';
					 }else{
						 str = '<a href="ansWriteView.kh?qnaNo='+row.qnaNo+'" class="boast-title">답변하기</a>';
					 }
					return str;
				} 
				}
				
			]
			
		});
		$('#custom-filter1').keyup( function() {
			dataTable1.search( this.value ).draw();
		  } );
}

function deleteQna(){
	if($('.checkbox_group1').is(":checked") == false){
		alert('체크된 값이 없습니다.');
	   return false;
   }else{
			if (!confirm("정말 삭제하시겠습니까?")) {
	   // 취소(아니오) 버튼 클릭 시 이벤트
		   return false;
	   } else {
		var checkVal = '';
		$("input:checkbox[name='qna-check']:checked").each(function(index){
			if(index != 0){
				checkVal += ',';
			}
			checkVal += $(this).val();
			
		});
		
		$.ajax({

			url: "adminQnaDelete.kh",
			type:"get",
			data:{"checkNo":checkVal},
			success: function(result){
				console.log(result);
				if(result > 0){
					getQnaList();
				}
			},
			error: function(){
				console.log('fail');
			}
		});

	   }
   }
	
}