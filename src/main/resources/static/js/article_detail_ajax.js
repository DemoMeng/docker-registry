/**
 *  ajax提交用户进行评论排序的分类，待做 
 */


/*设置窗体加载事件*/
$(function(){
	$("#article_comment_textarea").focus(function(){
		$("#article_comment_textarea").empty();
	});

	$("#article_comment_input_submit").click(function(){
		if($.trim($("#article_comment_textarea").val())==""){
			alert("评论内容不能为空!");
			return false;
		}
	});
	
	
});




