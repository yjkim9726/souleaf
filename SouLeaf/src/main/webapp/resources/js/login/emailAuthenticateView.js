$(function(){ // code insert
	$('#emailAuthConfirmbtn').on("click", function(){

		var authKeyData;
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
			alert('인증이 완료되었습니다!\n회원가입을 마저 진행해주세요');
			// 인증 확인 진행! >> 구분 값 추가해주기?
			$("#isEmailAuthSuccess", opener.document).val("success");
			self.close();
		} else if(authKeyData != inputKeyData){
			alert('인증번호가 잘못되었습니다.\n확인 후 다시 입력해주세요.');
		}
	});
});