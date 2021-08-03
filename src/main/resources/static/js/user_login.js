/**
 * 
 */
$(function(){
			
			$("#user_login_input_submit").click(function(){
					if($.trim($(".user_login_input:eq(0)").val()) == ""|| $.trim($(".user_login_input:eq(1)").val()) ==""){
						alert("用户名或密码不能为空!");
						return false;
					}
			});
			
			
			
});	