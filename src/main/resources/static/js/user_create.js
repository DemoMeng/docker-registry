/**
 * 
 */
$(function(){
			
			$("#user_create_input_submit").click(function(){
					if($.trim($(".user_create_input:eq(0)").val()) == ""){
						alert("请输入昵称!");
						return false;
					}
					if($.trim($(".user_create_input:eq(1)").val()) ==""){
						alert("请输入密码!");
						return false;
					}
					if($.trim($(".user_create_input:eq(2)").val()) ==""){
						alert("请输入手机号!");
						return false;
					}
			});
			
			
			
});	