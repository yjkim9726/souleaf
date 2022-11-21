$(function(){
    $("#deleteMember").on("click",function(){
        var memberId = $("#memberId").val();
        location.href = "memberDelete.kh?memberId="+memberId; 
    });
    $("#pwdchk").on("keyup",function(){
        var memberId = $("#memberId").val();
        var memberPw = $("#pwdchk").val();
        $.ajax({
            url : 'checkMemberPw.kh',
            type : 'post',
            data : {"memberId" : memberId, "memberPw" : memberPw},
            success : function(data){
                if(data == "wrongPw"){
                    $("#notPw").html("비밀번호가 일치하지 않습니다.");
                }else {
                    $("#notPw").html("");
                }
            }
        });
    
    });
});

function deleteModal(){
    $("#modal-modify").modal({});
    
}