$(function(){
	
	getBoastList();
	getClinicList();
	getCuriosityList();
	$("#boast-delete").on("click", function(){
		deleteBoast();
	});
	$("#clinic-delete").on("click", function(){
		deleteClinic();
	});
	$("#curiosity-delete").on("click", function(){
		deleteCuriosity();
	});

$("#check_all1").on("click", function(){
	var checked = $(this).is(":checked");
	if(checked){
		$(".checkbox_group1").prop("checked",true);
	}else{
		$(".checkbox_group1").prop("checked",false);
	}
});
$("#check_all2").on("click", function(){
	var checked = $(this).is(":checked");
	if(checked){
		$(".checkbox_group2").prop("checked",true);
	}else{
		$(".checkbox_group2").prop("checked",false);
	}
});
$("#check_all3").on("click", function(){
	var checked = $(this).is(":checked");
	if(checked){
		$(".checkbox_group3").prop("checked",true);
	}else{
		$(".checkbox_group3").prop("checked",false);
	}
});

$("form").on("submit", function() {
	if($('.checkbox_group').is(":checked") == false){
		 alert('체크된 값이 없습니다.');
		return false;
	}else{
			 if (!confirm("정말 삭제하시겠습니까?")) {
		// 취소(아니오) 버튼 클릭 시 이벤트
			return false;
		} else {
			// 확인(예) 버튼 클릭 시 이벤트
		}
	}
});

});

function deleteBoast(){
	if($('.checkbox_group1').is(":checked") == false){
		alert('체크된 값이 없습니다.');
	   return false;
   }else{
			if (!confirm("정말 삭제하시겠습니까?")) {
	   // 취소(아니오) 버튼 클릭 시 이벤트
		   return false;
	   } else {
		var checkVal = '';
		$("input:checkbox[name='boast-check']:checked").each(function(index){
			if(index != 0){
				checkVal += ',';
			}
			checkVal += $(this).val();
			
		});
		
		$.ajax({

			url: "adminBoastDelete.kh",
			type:"get",
			data:{"checkNo":checkVal},
			success: function(result){
				console.log(result);
				if(result > 0){
					getBoastList();
				}
			},
			error: function(){
				console.log('fail');
			}
		});

	   }
   }
	
}

function getBoastList(){
	let dataTable1 = $('#dataTable1').DataTable({
		'autoWidth': false,
		destroy: true,
		"bLengthChange": false,
		"bInfo": false,		
		  order: [[5, 'desc']],
		  language: {
			paginate: {
				previous: '<span class="icon md-chevron-left"><</span>',
				next: '<span class="icon md-chevron-left">></span>'
			}
		},
			ajax:{
				url:"adminBoastList.kh",
				type:"get",
				dataType:"json",
				"dataSrc": function ( json ) {							
					$("#boast-count").text(json.data.length);
					return json.data;
				}    
			},
			columns:[
				{ orderable: false,
					data: "boastNo",
					className : "boast-check",
				render: function(data){					
					return '<input type="checkbox" class="checkbox_group1" name="boast-check" value="'+data+'">';
				}
			 },
				{  orderable: false,
					data: "boastReName" ,
				 "defaultContent": "<i>Not set</i>",
				 className : "boast-img",
				 render: function(data){
					 var img = '';
					 if(data == null){
							img = '<img src="resources/uploadFiles/boast/defaultplant.png">';
					 }else{
						 img = '<img src="resources/uploadFiles/boast/'+data+'" onerror="this.src=\'resources/uploadFiles/curiosity/defaultplant.png\'">';
					 }
					 return img;

				 }
			    },
				{ data: "boastTitle",
				render: function(data, target, row){	
					if(data.length>12){
						data = data.substr(0,12)+"...";
					}					
					return '<a href="boastDetail.kh?boastNo='+row.boastNo+'" class="boast-title">'+data+'</a>';
				}
			 },
				{ data: "memberNick" },
				{ data: "boastCount" },
				{ data: "boastDate" }
			]
			
		});
		$('#custom-filter1').keyup( function() {
			dataTable1.search( this.value ).draw();
		  } );
		
}

function deleteClinic(){
	if($('.checkbox_group2').is(":checked") == false){
		alert('체크된 값이 없습니다.');
	   return false;
   }else{
			if (!confirm("정말 삭제하시겠습니까?")) {
	   // 취소(아니오) 버튼 클릭 시 이벤트
		   return false;
	   } else {
		var checkVal = '';
		$("input:checkbox[name='clinic-check']:checked").each(function(index){
			if(index != 0){
				checkVal += ',';
			}
			checkVal += $(this).val();
			
		});
		
		$.ajax({

			url: "adminClinicDelete.kh",
			type:"get",
			data:{"checkNo":checkVal},
			success: function(result){
				console.log(result);
				if(result > 0){
					getClinicList();
				}
			},
			error: function(){
				console.log('fail');
			}
		});

	   }
   }
	
}

function getClinicList(){
	let dataTable1 = $('#dataTable2').DataTable({
		'autoWidth': false,
		destroy: true,
		"bLengthChange": false,
		"bInfo": false,		
		  order: [[5, 'desc']],
		  language: {
			paginate: {
				previous: '<span class="icon md-chevron-left"><</span>',
				next: '<span class="icon md-chevron-left">></span>'
			}
		},
			ajax:{
				url:"adminClinicList.kh",
				type:"get",
				dataType:"json",
				"dataSrc": function ( json ) {							
					$("#clinic-count").text(json.data.length);
					return json.data;
				}    
			},
			columns:[
				{ orderable: false,
					data: "clinicNo",
					className : "clinic-check",
				render: function(data){					
					return '<input type="checkbox" class="checkbox_group2" name="clinic-check" value="'+data+'">';
				}
			 },
				{  orderable: false,
					data: "clinicFileRename" ,
				 "defaultContent": "<i>Not set</i>",
				 className : "clinic-img",
				 render: function(data){
					 var img = '';
					 if(data == null){
							img = '<img src="resources/uploadFiles/curiosity/defaultplant.png">';
					 }else{
						 img = '<img src="resources/uploadFiles/clinic/'+data+'" onerror="this.src=\'resources/uploadFiles/curiosity/defaultplant.png\'">';
					 }
					 return img;

				 }
			    },
				{ data: "clinicContent",
				render: function(data, target, row){
					if(data.length>12){
						data = data.substr(0,12)+"...";
					}						
					return '<a href="clinicDetail.kh?clinicNo='+row.clinicNo+'" class="boast-title">'+data+'</a>';
				}
			 },
				{ data: "memberNick" },
				{ data: "clinicCount" },
				{ data: "clinicDate" }
			]
			
		});
		$('#custom-filter2').keyup( function() {
			dataTable1.search( this.value ).draw();
		  });
		
}


function deleteCuriosity(){
	if($('.checkbox_group3').is(":checked") == false){
		alert('체크된 값이 없습니다.');
	   return false;
   }else{
			if (!confirm("정말 삭제하시겠습니까?")) {
	   // 취소(아니오) 버튼 클릭 시 이벤트
		   return false;
	   } else {
		var checkVal = '';
		$("input:checkbox[name='curiosity-check']:checked").each(function(index){
			if(index != 0){
				checkVal += ',';
			}
			checkVal += $(this).val();
			
		});
		
		$.ajax({

			url: "adminCuriosityDelete.kh",
			type:"get",
			data:{"checkNo":checkVal},
			success: function(result){
				console.log(result);
				if(result > 0){
					getCuriosityList();
				}
			},
			error: function(){
				console.log('fail');
			}
		});

	   }
   }
	
}

function getCuriosityList(){
	let dataTable3 = $('#dataTable3').DataTable({
		'autoWidth': false,
		destroy: true,
		"bLengthChange": false,
		"bInfo": false,	
		fixedColumns: true,	
		  order: [[5, 'desc']],
		  language: {
			paginate: {
				previous: '<span class="icon md-chevron-left"><</span>',
				next: '<span class="icon md-chevron-left">></span>'
			}
		},
			ajax:{
				url:"adminCuriosityList.kh",
				type:"get",
				dataType:"json",
				"dataSrc": function ( json ) {							
					$("#curiosity-count").text(json.data.length);
					return json.data;
				}    
			},
			columnDefs: [
				{ width: 50, targets: 0 }
			],
			columns:[
				{ orderable: false,
					data: "curiosityNo",
					className : "curiosity-check px50",
				render: function(data){					
					return '<input type="checkbox" class="checkbox_group3" name="curiosity-check" value="'+data+'">';
				}
			 },
				{  orderable: false,
					data: "curiosityFileRename" ,
				 "defaultContent": "<i>Not set</i>",
				 className : "curiosity-img px50",
				 render: function(data){
					 var img = '';
					 if(data == null){
							img = '<img src="resources/uploadFiles/curiosity/defaultplant.png">';
					 }else{
						 img = '<img src="resources/uploadFiles/curiosity/'+data+'" onerror="this.src=\'resources/uploadFiles/curiosity/defaultplant.png\'">';
					 }
					 return img;

				 }
			    },
				{ data: "curiosityContent",
				render: function(data, target, row){
					if(data.length>12){
						data = data.substr(0,12)+"...";
					}					
					return '<a href="curiosityDetail.kh?curiosityNo='+row.curiosityNo+'" class="curiosity-title">'+data+'</a>';
				}
			 },
				{ data: "memberNick" },
				{ data: "curiosityCount" },
				{ data: "curiosityDate" }
			]
			
		});
		$('#custom-filter3').keyup( function() {
			dataTable3.search( this.value ).draw();
		  } );
		
}
