Kakao.init('2ed12623656a97e30e08860179073369'); 
	// 카카오 로그인
	function kakaoLogin() {
		Kakao.Auth.login({
			success: function (authObj) {
			Kakao.API.request({
				url: '/v2/user/me',
				success: function (response) {
					console.log(JSON.stringify(response)); 
					console.log(JSON.stringify(authObj));

					console.log(response.id);
					console.log(response.properties['nickname']);
					console.log(authObj.access_token);
				
					$.ajax({
					url :"kakaoLogin.kh",
					type : "POST",
					data : {"memberId" :response.id, "memberPw": 1, "memberNick":response.properties['nickname'], "memberName": response.properties['nickname'],"memberMail":'kakao@Mail',"token":authObj.access_token},
					success : function(data){
						if(data == "success"){
							location.href="home.kh";
						}else {
							alert("카카오 로그인 실패!");
						}
					}
					});
				}
			})
			}
		})
	}	
	//카카오로그아웃  
	function kakaoLogout() {
		if (Kakao.Auth.getAccessToken()) { // 토큰이 있으면
			Kakao.API.request({
				// 로그아웃하고
				url: '/v1/user/unlink',
				success: function (response) {
					location.href="logout.kh"
				},
				fail: function (error) {
					console.log(error)
				},
		})
		// 토큰 삭제
		Kakao.Auth.setAccessToken(undefined)
		}
	}  
