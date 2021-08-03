// JavaScript Document
//下面的设置的是首页图片切换的脚本和右下角的去顶部的脚本   开始
 $(window).load(function() {
            $('#slider').nivoSlider({
                effect:'random',
                slices:15,
                boxCols:8,
                boxRows:8,
                animSpeed:700,
                pauseTime:3500,
                directionNav:false,
                directionNavHide:false,
                controlNav:true,
                captionOpacity:0.9
            });
			
			$("#go_to_top").click(function(){
				//scrollLeft(0);
				//$("body").animate({scrollTop: '0px'}, 800);
			});
});
 //下面的设置的是首页图片切换的脚本和右下角的去顶部的脚本   结束
 