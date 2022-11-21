<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script src="https://use.fontawesome.com/releases/v5.2.0/js/all.js"></script>
<meta charset="UTF-8">
<title>Chating</title>
<style>
body {
	margin: 0;
	overflow: hidden
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

.container {
	max-width: 1170px;
	margin: auto;
}

img {
	padding-left: 8px;
	max-width: 143%;
}

.incoming_msg {
	margin: 13px 0 13px;
}

.incoming_msg_img {
	display: inline-block;
	width: 6%;
}

.received_msg {
	display: inline-block;
	padding: 0 0 0 17px;
	vertical-align: top;
	width: 80%;
}

.received_withd_msg p {
	background: #ebebeb none repeat scroll 0 0;
	border-radius: 3px;
	color: #646464;
	font-size: 14px;
	margin: 0;
	padding: 5px 10px 5px 12px;
	width: 100%;
	margin-left: 8px;
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
	width: 100%;
}

.sent_msg p {
	background: #05728f none repeat scroll 0 0;
	border-radius: 3px;
	font-size: 14px;
	margin: 0;
	color: #fff;
	padding: 5px 10px 5px 12px;
	width: 90%;
}

.outgoing_msg {
	overflow: hidden;
	margin: 13px 0 13px;
}

.sent_msg {
	float: right;
	width: 50%;
	margin-right: 10px;
}

.input_msg_write input {
	background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
	border: medium none;
	color: #4c4c4c;
	font-size: 15px;
	min-height: 48px;
	width: 99%;
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

.messaging {
	padding: 0 0 50px 0;
}

.msg_history {
	height: 490px;
	overflow-y: auto;
}

.msg_history::-webkit-scrollbar {
	width: 10px;
}

.msg_history::-webkit-scrollbar-thumb {
	background-color: #00bd56;
	border-radius: 10px;
	background-clip: padding-box;
	border: 2px solid transparent;
}

.msg_history::-webkit-scrollbar-track {
	background-color: white;
	border-radius: 10px;
	box-shadow: inset 0px 0px 5px white;
}
</style>
</head>
<body>
	<div id="container" class="container">
		<div class="row">
			<div class="magin">
				<h4>${roomName}</h4>
			</div>
			<div class="magin">
				<h5>souleaf!</h5>
			</div>
		</div>
		<input type="hidden" id="sessionId" value="">
		<input type="hidden" id="roomNumber" value="${roomNumber}">
		<input type="hidden" id="roomName" value="${roomName}">
		<input type="hidden" id="memberNo" value="${room.memberNo}">
		<input type="hidden" id="memberNick" value="${room.memberNick}">
		<input type="hidden" id="withMemberNo" value="${room.withMemberNo}">
		<input type="hidden" id="withMemberNick" value="${room.withMemberNick}">

		<div class="mesgs">
			<div class="msg_history">
				<br>
				<div id="chating" class="chating"></div>
			</div>
			<div class="type_msg">
				<div class="input_msg_write">
					<input type="text" class="write_msg" id="chatting" placeholder="보내실 메시지를 입력하세요." />
					<button class="msg_send_btn" onclick="send()" id="sendBtn">
						<i class="far fa-comment-alt" aria-hidden="true"></i>
					</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			wsOpen();
			chatLog();
		});

		var ws;
		function chatLog() {
			var roomNumber = $("#roomNumber").val();
			$.ajax({
				url : "/chatLogDate.kh",
				type : "post",
				data : {"roomNumber" : roomNumber},
				dataType : "json",
				success : function(data) {
					const $chatingTag = $("#chating");
					console.log(data);
					for ( var i in data) {
						var html = "";
						if (data[i].memberNo == $("#memberNo").val()) {
							$("#chating")
							.append("<div class='outgoing_msg'><div class='sent_msg'> <p>" + data[i].msg + "</p> <span class='time_date'>" + moment(data[i].chatDate).format("HH:mm") + "</span></div></div>");
							} else {
								$("#chating")
								.append("<div class='incoming_msg'><div class='incoming_msg_img'><img src='resources/images/basicMemberImg.png' alt='sunil'></div><div class='received_msg'><div class='received_withd_msg'><p>" + data[i].msg + "</p> <span class='time_date'>" + moment(data[i].chatDate).format("HH:mm") + "</span></div></div></div>");
							}
						}
					$('div.msg_history').scrollTop($('div.msg_history').prop('scrollHeight'));
					}
				});
			}

		function wsOpen() {
			//웹소켓 전송시 현재 방의 번호를 넘겨서 보낸다.
			ws = new WebSocket("ws://" + location.host + "/chating/"
					+ $("#roomNumber").val() + ".kh");
			wsEvt();
		}

		function wsEvt() {
			ws.onopen = function(data) {
				//소켓이 열리면 동작
			}

			ws.onmessage = function(data) {
				//메시지를 받으면 동작
				var msg = data.data;
				var date = new Date();

				if (msg != null && msg.trim() != '') {
					var d = JSON.parse(msg);
					if (d.type == "getId") {
						var si = d.sessionId != null ? d.sessionId : "";
						if (si != '') {
							$("#sessionId").val(si);
						}
					} else if (d.type == "message") {
						if (d.sessionId == $("#sessionId").val()) {
							$("#chating").append("<div class='outgoing_msg'><div class='sent_msg'> <p>"+ d.msg+ "</p> <span class='time_date'>"+ moment(new Date()).format("HH:mm")+ "</span></div></div>");
						} else {
							$("#chating").append("<div class='incoming_msg'><div class='incoming_msg_img'><img src='resources/images/basicMemberImg.png' alt='sunil'></div><div class='received_msg'><div class='received_withd_msg'><p>" + d.msg+ "</p> <span class='time_date'>"+ moment(new Date()).format("HH:mm")+ "</span></div></div></div>");
						}
					} else {
						console.warn("unknown type!")
					}
				}
				$('div.msg_history').scrollTop($('div.msg_history').prop('scrollHeight'));
			}

			document.addEventListener("keypress", function(e) {
				if (e.keyCode == 13) { //enter press
					send();
				}
			});
		}

		function send() {
			var option = {
				type : "message",
				roomNumber : $("#roomNumber").val(),
				sessionId : $("#sessionId").val(),
				userName : $("#userName").val(),
				msg : $("#chatting").val()
			}
			var roomNumber = $("#roomNumber").val();
			var roomName = $("#roomName").val();
			var memberNo = $("#memberNo").val();
			var memberNick = $("#memberNick").val();
			var withMemberNo = $("#withMemberNo").val();
			var withMemberNick = $("#withMemberNick").val();
			ws.send(JSON.stringify(option))

			// 1. 저장만 하는곳
			// 에이작스 그 멥핑이 메인컨트롤러에 들어간다고!!
			// 여기는 저장만 하는곳이고
			$.ajax({
				url : "/chatRegister.kh",
				type : "get",
				data : {
					"roomNumber" : roomNumber,
					"roomName" : roomName,
					"memberNo" : memberNo,
					"memberNick" : memberNick,
					"withMemberNo" : withMemberNo,
					"withMemberNick" : withMemberNick,
					"msg" : $("#chatting").val()
				},
				success : function(data) {
// 					opener.location.reload();

				}
			});

			$('#chatting').val("");
		}
	</script>

</body>
</html>