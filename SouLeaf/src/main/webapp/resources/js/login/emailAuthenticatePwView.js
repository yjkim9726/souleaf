$(function(){ // code insert
	$('#emailAuthConfirmbtn').on("click", function(){
var getParameters = function (paramName) { 
// 리턴값을 위한 변수 선언 
var returnValue; 
// 현재 URL 가져오기 
var url = location.href; 
// get 파라미터 값을 가져올 수 있는 ? 를 기점으로 slice 한 후 split 으로 나눔
 var parameters = (url.slice(url.indexOf('?') + 1, url.length)).split('&');
 // 나누어진 값의 비교를 통해 paramName 으로 요청된 데이터의 값만 return
 for (var i = 0; i < parameters.length; i++) { var varName = parameters[i].split('=')[0]; if (varName.toUpperCase() == paramName.toUpperCase()) { returnValue = parameters[i].split('=')[1]; return decodeURIComponent(returnValue); } } };

		var authKeyData;
		var memberId = getParameters('memberId');
	
		if(document.cookie){
	        var array=document.cookie.split('authKeyValue=');
	        if(array.length >= 2){
	            var arraySub=array[1].split(';');
	            authKeyData=arraySub[0];
	        }
    	}
		
		var inputKeyData = $('#emailAuthKey').val();
		if(authKeyData == null || authKeyData == '' || authKeyData == undefined){
			alert('인증 시간이 만료되었습니다. 다시 진행해주세요.');
			self.close();
		} else if(authKeyData == inputKeyData){
			
			alert(memberId+'인증이 완료되었습니다!\n');
			// 인증 확인 진행! >> 구분 값 추가해주기?
			$("#isEmailAuthSuccess", opener.document).val("success");
			opener.parent.location='newPwView.kh?memberId='+memberId;
			self.close();
		} else if(authKeyData != inputKeyData){
			alert('인증번호가 잘못되었습니다.\n확인 후 다시 입력해주세요.');
		}
	});
});