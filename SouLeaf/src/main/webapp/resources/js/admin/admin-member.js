$(function(){
	
	let dataTable = $('#dataTable').DataTable({
		"bLengthChange": false,
		"bInfo": false,
		columns: [
			{ orderable: false },
			{ orderable: false },
			null,
			null,
			null,
			null,
			null
			
		  ],
		  order: [[6, 'desc']],
		  language: {
			paginate: {
				previous: '<span class="icon md-chevron-left"><</span>',
				next: '<span class="icon md-chevron-left">></span>'
			},
		}
	});
	$('#custom-filter').keyup( function() {
		dataTable.search( this.value ).draw();
	  } );
	
$("#check_all_y").on("click", function(){
	var checked = $(this).is(":checked");
	if(checked){
		$(".checkbox_y").prop("checked",true);
	}else{
		$(".checkbox_y").prop("checked",false);
	}
    checkStatus();
});
$("#check_all_n").on("click", function(){
	var checked = $(this).is(":checked");
	if(checked){
		$(".checkbox_n").prop("checked",true);
	}else{
		$(".checkbox_n").prop("checked",false);
	}
	checkStatus();
});

$(".checkbox_group").on("click", function(){
	if($('.checkbox_y').is(":checked")){
		$(".checkbox_n").attr('disabled',true);
	}else if($('.checkbox_y').is(":checked") == false){
		$(".checkbox_n").attr('disabled',false);
	}
	if($('.checkbox_n').is(":checked")){
		$(".checkbox_y").attr('disabled',true);
	}else if($('.checkbox_n').is(":checked") == false){
		$(".checkbox_y").attr('disabled',false);
	}
});

$("form").on("submit", function() {
	if($('.checkbox_group').is(":checked") == false && $('.checkbox_reset').is(":checked") == false){
		 alert('체크된 값이 없습니다.');
		return false;
	}else{
		var status = "";
		if($('.checkbox_y').is(":checked")){
			 status = "비활성화";
		}else{
			status = "활성화"; 
		}
			 if (!confirm("정말 "+status+" 하시겠습니까?")) {
		// 취소(아니오) 버튼 클릭 시 이벤트
			return false;
		} else {
			// 확인(예) 버튼 클릭 시 이벤트
		}
	}
});

});

function checkStatus(){
	if($('.checkbox_y').is(":checked")){
		$(".checkbox_n").attr('disabled',true);
	}else if($('.checkbox_y').is(":checked") == false){
		$(".checkbox_n").attr('disabled',false);
	}
	if($('.checkbox_n').is(":checked")){
		$(".checkbox_y").attr('disabled',true);
	}else if($('.checkbox_n').is(":checked") == false){
		$(".checkbox_y").attr('disabled',false);
	}
}