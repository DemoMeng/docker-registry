// JavaScript Document

$(function(){
			//设置切换字体的的按钮的事件
			$("#index_top_changeFont_one").toggle(
				function(){
					//$("#index_top_changeFont_detail").css("display","table");
					$("#index_top_changeFont_detail").fadeIn(200);
					//event.stopPropagation();
				},
				function(){
					//$("#index_top_changeFont_detail").css("display","none");
					$("#index_top_changeFont_detail").fadeOut(100);
				}
			);
			$("body").click(function(){
					$("#index_top_changeFont_detail").fadeOut(100);
			});
});	

$(function(){
    var min_height = 100;
    $(window).scroll(function() {
        //获取窗口的滚动条的垂直位置      
        var s = $(window).scrollTop();
        //当窗口的滚动条的垂直位置大于页面的最小高度时 
        if (s > min_height) {
        	//$("#go_to_top").css("display","table");
			$("#go_to_top").slideDown(200);
        }else{
        	//$("#go_to_top").css("display","none");	
			$("#go_to_top").slideUp(200);
        }
        
    });
});

$(function(){
	//设置切换字体的的按钮的事件
	$("#index_top_serach_text").click(
		function(){
			var searchValue = $("#index_top_serach_text").val();
			if(searchValue=="搜索"){
				$("#index_top_serach_text").val("");
			}
		}
	);
	$("#index_top_serach_text").blur(
			function(){
				var searchValue = $("#index_top_serach_text").val();
				if($.trim(searchValue)==""){
					$("#index_top_serach_text").val("搜索");
				}
			}
	);
	
	/* 设置切换字体的样式 */  
	//青葱
	$(".index_top_changeFont_two:eq(0)").click(
		function(){
			$(".index_top_changeFont_two:eq(0)").css("background-color","#6DACF4");
			$(".index_top_changeFont_two:eq(0)").css("color","#FFFFFF");
			
			$(".index_top_changeFont_two:eq(1)").css("background-color","#FFFFFF");
			$(".index_top_changeFont_two:eq(1)").css("color","#000000");
			
			
			$(".allChangeFont,.article_writer_info_nicknanme,.article_content,.article_writer_info_time,.article_title,.article_content,.article_class,.article_read").css("font-family","字体管家青葱");
			$(".allChangeFont,.index_top_logo_font,.index_top_downloadapp_font,.index_top_login_font,.index_top_create_font,.index_body_left_top,.writer_name,.writer_about,#more_writers div,#more_article1,#more_article").css("font-family","字体管家青葱");
			
			$.ajax({  
	            cache: true,  
	            type: "POST",  
	            dataType:"text",
	            url:"changeUserConfig",  
	            data:{
			     'font':'qc',
			     'userName':$("#username_forJS").text()
			    }
    	     });
		}	
	);
	
	//默认黑体
	$(".index_top_changeFont_two:eq(1)").click(
			function(){
				$(".index_top_changeFont_two:eq(1)").css("background-color","#6DACF4");
				$(".index_top_changeFont_two:eq(1)").css("color","#FFFFFF");
				
				$(".index_top_changeFont_two:eq(0)").css("background-color","#FFFFFF");
				$(".index_top_changeFont_two:eq(0)").css("color","#000000");
				
				$(".allChangeFont,.article_writer_info_nicknanme,.article_content,.article_writer_info_time,.article_title,.article_content,.article_class,.article_read").css("font-family","微软雅黑");
				$(".allChangeFont,.index_top_logo_font,.index_top_downloadapp_font,.index_top_login_font,.index_top_create_font,.index_body_left_top,.writer_name,.writer_about,#more_writers div,#more_article1,#more_article").css("font-family","微软雅黑");
			
				$.ajax({  
		            cache: true,  
		            type: "POST",  
		            dataType:"text",
		            url:"changeUserConfig",  
		            data:{
				     'font':'ht',
				     'userName':$("#username_forJS").text()
				    }
		            
	    	     });
				
			}	
	);
	
	/* 设置切换背景颜色的样式 */
	
	//夜间模式
	$(".change_background_switch:eq(0)").click(
			
			function(){
				$(".change_background_switch:eq(0)").css("background-color","#6DACF4");
				$(".change_background_switch:eq(0)").css("color","#FFFFFF");
				
				$(".change_background_switch:eq(1)").css("background-color","#FFFFFF");
				$(".change_background_switch:eq(1)").css("color","#000000");
				
				$("body").css("background-color","#666666");
				$("#index_top").css("opacity","0.89");
				//头像颜色
				$(".article_writer_info_nicknanme").css("color","#c8c8c8");
				//文章标题颜色
				$(".article_title").css("color","#c8c8c8");
				//文章内容颜色
				$(".article_content").css("color","#c8c8c8");
				//去顶部的颜色
				$("#go_to_top").css("color","#ffffff");
				//推荐作者的颜色
				$(".writer_name strong a").css("color","#c8c8c8");
				
				$.ajax({  
		            cache: true,  
		            type: "POST",  
		            dataType:"text",
		            url:"changeUserConfig",  
		            data:{
				     'bgcolor':'night',
				     'userName':$("#username_forJS").text()
				    }
		            
	    	     });
				
			}
	);
	
	//白天模式
	$(".change_background_switch:eq(1)").click(
			function(){
				$(".change_background_switch:eq(1)").css("background-color","#6DACF4");
				$(".change_background_switch:eq(1)").css("color","#FFFFFF");
				
				$(".change_background_switch:eq(0)").css("background-color","#FFFFFF");
				$(".change_background_switch:eq(0)").css("color","#000000");
				
				
				
				
				$("body").css("background-color","");
				$("body").css("background-color","");
				$("#index_top").css("opacity","1");
				
				//头像颜色
				$(".article_writer_info_nicknanme").css("color","#000000");
				//文章标题颜色
				$(".article_title").css("color","#000000");
				//文章内容颜色
				$(".article_content").css("color","#000000");
				//去顶部的颜色
				$("#go_to_top").css("color","#4e7ab9");
				//推荐作者的颜色
				$(".more_article_colors").css("color","black");
				//关注
				$(".more_article_colors2").css("color","#59c055");
				
				//使用切换背景颜色用ajax的技术，向服务器请求数据
				$.ajax({  
		            cache: true,  
		            type: "POST",  
		            dataType:"text",
		            url:"changeUserConfig",  
		            data:{
				     'bgcolor':'day',
				     'userName':$("#username_forJS").text()
				    }
		            
	    	     });
				
				
			}
	);
	$("#font_song").click(function(){
		
	});
	$("#font_black").click(function(){
		
	});

	//点击登录后的用户显示和自己相关的信息
	$(".user_about").toggle(
			function (){  
				$("#my").fadeIn(300);
			},function(){
				$("#my").fadeOut(300);
	});
	
	
	
	
	
});	







