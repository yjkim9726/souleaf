$(function(){

$('#step1').css('background','#00bd56');
$('#ptext1').css('color','#00bd56');
$('#ptext1').css('font-weight','bold');
$('#pform2').hide();
$('#pform3').hide();
$("input#ufile").change(function() {
    $("#output ul").empty();
        var ele = document.getElementById($(this).attr('id'));
        var result = ele.files;
        for(var x = 0;x< result.length;x++){
        var fle = result[x];
        $("#output ul").append("<li>" + fle.name + "(TYPE: " + fle.type + ", SIZE: " + fle.size + ")</li>");        
    }

});

                
});

function readURL(input) {
	console.log(input);
  if (input.files && input.files[0]) {
    var reader = new FileReader();

    reader.onload = function(e) {
      //$('.image-upload-wrap').hide();

      $('.file-upload-image').attr('src', e.target.result);
      $('.file-upload-content').show();

      $('.image-title').html(input.files[0].name);
    };

    reader.readAsDataURL(input.files[0]);

  } else {
    removeUpload();
  }
}

function removeUpload() {
  $('.file-upload-input').replaceWith($('.file-upload-input').clone());
  $('.file-upload-content').hide();
  $('.image-upload-wrap').show();
}
$('.image-upload-wrap').bind('dragover', function () {
        $('.image-upload-wrap').addClass('image-dropping');
    });
    $('.image-upload-wrap').bind('dragleave', function () {
        $('.image-upload-wrap').removeClass('image-dropping');
});

function fnMove(seq){
    var offset = $(".divup").offset();
    $('html, body').animate({scrollTop : offset.top}, 400);
    switch(seq){
    	case 1 : $('#step1').css('background','#00bd56');
			$('#ptext1').css('color','#00bd56');
			$('#ptext1').css('font-weight','bold');
	        $('#step2, #step3').css('background','#ddd');
			$('#ptext2, #ptext3').css('color','#b5b5b5');
			$('#ptext2, #ptext3').css('font-weight','500');
        	$('#pform2, #pform3').hide();
        	$('#pform1').show();
    	break;
        case 2 : $('#step1, #step3').css('background','#ddd');
			$('#ptext1, #ptext3').css('color','#b5b5b5');
			$('#ptext1, #ptext3').css('font-weight','500');
	        $('#step2').css('background','#00bd56');
			$('#ptext2').css('color','#00bd56');
			$('#ptext2').css('font-weight','bold');
        	$('#pform1, #pform3').hide();
        	$('#pform2').show();
    	break;
    	case 3 : $('#step2, #step1').css('background','#ddd');
			$('#ptext2, #ptext1').css('color','#b5b5b5');
			$('#ptext2, #ptext1').css('font-weight','500');
	        $('#step3').css('background','#00bd56');
			$('#ptext3').css('color','#00bd56');
			$('#ptext3').css('font-weight','bold');
        	$('#pform2, #pform1').hide();
        	$('#pform3').show();
    	break;
    }
}



function deleteFile(index,plantNo,fileNo,fileName){
    
  $.ajax({
    url:"deleteFile.kh",
    type:"get",
    data:{"plantNo":plantNo,"plantFileNo":fileNo,"plantFileRename":fileName},
    success: function(result){
      console.log(result);
      console.log("#li"+index);
      $("#li"+index).css('display','none');
    },
    error: function(){
      console.log("fail");
    }

  });
}