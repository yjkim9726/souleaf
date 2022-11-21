<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Room</title>
<style>
html, body {
	margin: 0;
	height: 100%;
	overflow: hidden
}

.container {
	max-width: 1170px;
	margin: auto;
}

img {
	max-width: 110%;
}

.inbox_people {
	background: #f8f8f8 none repeat scroll 0 0;
	float: left;
	overflow: hidden;
	width: 105%;
	border-right: 1px solid #c4c4c4;
}

.inbox_msg {
	border: 1px solid #c4c4c4;
	clear: both;
	overflow: hidden;
}

.top_spac {
	margin: 20px 0 0;
}

.recent_heading {
	float: left;
	width: 40%;
}

.srch_bar {
	display: inline-block;
	text-align: right;
	width: 60%;
}

.recent_heading h4 {
	color: #05728f;
	font-size: 21px;
	margin: auto;
}

.srch_bar input {
	border: 1px solid #cdcdcd;
	border-width: 0 0 1px 0;
	width: 80%;
	padding: 2px 0 4px 6px;
	background: none;
}

.srch_bar .input-group-addon button {
	background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
	border: medium none;
	padding: 0;
	color: #707070;
	font-size: 18px;
}

.srch_bar .input-group-addon {
	margin: 0 0 0 -27px;
}

.chat_ib h5 {
	font-size: 15px;
	color: #464646;
	margin: 0 0 8px 0;
}

.chat_ib h5 span {
	font-size: 13px;
	float: right;
}

.chat_ib p {
	font-size: 14px;
	color: #989898;
	margin: auto
}

.chat_img {
	float: left;
	width: 11%;
}

.chat_ib {
	float: left;
	padding: 0 0 0 15px;
	width: 82%;
}

.chat_people {
	overflow: hidden;
	clear: both;
}

.chat_list {
	border-bottom: 1px solid #c4c4c4;
	margin: 0;
	padding: 20px 16px 14px;
}

.inbox_chat {
	height: 549px;
	overflow-y: scroll;
}

.active_chat:hover {
	background: #ebebeb;
}

.incoming_msg_img {
	display: inline-block;
	width: 6%;
}

.received_msg {
	display: inline-block;
	padding: 0 0 0 10px;
	vertical-align: top;
	width: 92%;
}

.received_withd_msg p {
	background: #ebebeb none repeat scroll 0 0;
	border-radius: 3px;
	color: #646464;
	font-size: 14px;
	margin: 0;
	padding: 5px 10px 5px 12px;
	width: 100%;
}

.time_date {
	color: #747474;
	display: block;
	font-size: 12px;
	margin: 8px 0 0;
}

.received_withd_msg {
	width: 57%;
}

.mesgs {
	float: left;
	padding: 30px 15px 0 25px;
	width: 60%;
}

.sent_msg p {
	background: #05728f none repeat scroll 0 0;
	border-radius: 3px;
	font-size: 14px;
	margin: 0;
	color: #fff;
	padding: 5px 10px 5px 12px;
	width: 100%;
}

.outgoing_msg {
	overflow: hidden;
	margin: 26px 0 26px;
}

.sent_msg {
	float: right;
	width: 46%;
}

.input_msg_write input {
	background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
	border: medium none;
	color: #4c4c4c;
	font-size: 15px;
	min-height: 48px;
	width: 100%;
}

.type_msg {
	border-top: 1px solid #c4c4c4;
	position: relative;
}

.msg_send_btn {
	background: #05728f none repeat scroll 0 0;
	border: medium none;
	border-radius: 50%;
	color: #fff;
	cursor: pointer;
	font-size: 17px;
	height: 33px;
	position: absolute;
	right: 0;
	top: 11px;
	width: 33px;
}

.msg_history {
	height: 516px;
	overflow-y: auto;
}

.magin h4 {
	margin-top: 0px;
	margin-bottom: 0px;
	padding-top: 8px;
	text-align: center;
	font-size: 14px;
	color: #fff;
	background-color: #03c75a;
}

.magin h5 {
	margin-top: 0px;
	margin-bottom: 0px;
	padding-bottom: 8px;
	text-align: center;
	font-size: 11px;
	color: rgba(255, 255, 255, 0.8);
	background-color: #03c75a;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="magin">
				<h4>채팅</h4>
			</div>
			<div class="magin">
				<h5>souleaf!</h5>
			</div>
		</div>
	</div>
	<div class="container-fluid h-100">
		<div class="messaging">
			<div class="inbox_msg">
				<div class="inbox_people">
					<div id="roomList" class="inbox_chat roomList"></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		var ws;
		window.onload = function() {
			getRoom();
			createRoom();
		}

		function getRoom() {
			commonAjax('/getRoom.kh', "", 'post', function(result) {
				createChatingRoom(result);
			});
		}

		function createRoom() {
			// 방만들기 버튼 클릭 이벤트
			$("#createRoom").click(function() {
				// msg에 방 이름 저장
				var msg = {
					roomName : $('#roomName').val()
				};

				// 
				commonAjax('/createRoom.kh', msg, 'post', function(result) {
					createChatingRoom(result);
				});

				$("#roomName").val("");
			});
		}
		function goRoom(number, name) {
			window.open("/moveChating.kh?roomName=" + name + "&"
					+ "roomNumber=" + number, "new", "width=400,height=600");
			//  		location.href="/moveChating.kh?roomName="+name+"&"+"roomNumber="+number;
		}

		// 방을 만들고 채팅룸을 만들거야
		// res에 {roomNumber: ?, roomName : "createRoom 에서 입력한 채팅방 이름"}
		function createChatingRoom(res) {
			// res가 비어 있지 않으면
			if (res != null) {
				// 테이블 th태그 적용
				var tag = "";
				// d : {roomNumber: ?, roomName : "createRoom 에서 입력한 채팅방 이름"}
				// idx : 인덱스
				res.forEach(function(d, idx) {
							// 방 이름
							var rn = d.roomName.trim();
							// 방 번호
							var roomNumber = d.roomNumber;
							var roomName = d.roomName;
							var lastChatMessage = d.lastChatMessage;
							var lastChatDate = d.lastChatDate;
							var withMemberPick = d.withMemberPick;
							if (withMemberPick == null) {
								withMemberPick = "resources/images/basicMemberImg.png";
							} else {
								withMemberPick = "resources/uploadFiles/member/" + withMemberPick;
							}
							tag += "<div class='chat_list active_chat' onclick='goRoom(\"" + roomNumber + "\", \"" + rn+ "\")'>"
									+ "<div class='chat_people'>"
									+ "<div class='chat_img'>"
									+ "<img src='" + withMemberPick+ "' alt='sunil' style='border-radius: 70%'>"
									+ "</div>" + "<div class='chat_ib'>"
									+ "<h5> " + roomName
									+ " <span class='chat_date'>"
									+ lastChatDate + "</span></h5>" + "<p>"
									+ lastChatMessage + "</p>" + "</div>"
									+ "</div>" + "</div>";
						});
				$("#roomList").empty().append(tag);
			}
		}

		function commonAjax(url, parameter, type, calbak, contentType) {
			$.ajax({
				url : url,
				data : parameter,
				type : type,
				contentType : contentType != null ? contentType
						: 'application/x-www-form-urlencoded; charset=UTF-8',
				success : function(res) {
					calbak(res);
				},
				error : function(err) {
					console.log('error');
					calbak(err);
				}
			});
		}
	</script>
</body>
</html>