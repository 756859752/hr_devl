<%@page import="pojo.Goods"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%  
	List<Goods> list =(List<Goods>)request.getAttribute("shoppinglist");
	System.out.print(list);
%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC"-//W3C//DTD HTML 4.01Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ybc-gouwudai.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<meta charset="utf-8" />
		<title></title>
		<meta name="viewport" content="witdh=device-witdh,initial-scale=1"/>
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/daohang.css"/>
	</head>
	<style type="text/css">
		#last{
				background: #1B1B1B;
			}
			#last p{
				color: #666;
				margin: 30px 0px;
			}
			#last a{
				display: block;
				color: #e5dfd9;
				margin: 10px 0px;
				font-size: 11px;
			}
			.hid{}
	</style>
	
	<body>
	<input type="hidden" value="${msg}" id="loginmsg"/>
		<div class="ybc_nav">
			<div class="container " id="ybc_mynav">
				<div class="row" >
					<div class="col-lg-4 col-lg-offset-4 text-center">
						<h1 id="logo" style="margin-bottom: 0px;">G U C C I</h1>
					</div>
					<div class="col-lg-4  text-right " id="ybc_shoping">
						<c:if test="${userlogininfo!=null}">
							<a href="user.do" class="login" id="login"><span class="glyphicon glyphicon-user  id="welcome"></span><span>${userlogininfo.username }</span></a>
							<a href="javascript:;" id="outline"><span class="glyphicon glyphicon-log-out "></span>退出</a>
						</c:if>
						<c:if test="${userlogininfo==null}">
							<a href="wkr-zhuce.jsp" class="login" id="login"><span>登陆 </span></a>
						</c:if>
						<a href="gouwudai.do" class="shop_cart" id="shop_cart"><span >购物袋 </span></a>
						<span class="glyphicon glyphicon-shopping-cart"></span>
					</div>
				</div>
				<div class="row " >
					<div class="col-md-3"  id="serchfather">
						<a id="serch" href="javascript:;">
							<span class="glyphicon glyphicon-search" id=""   >
							</span>
						</a>
					</div>
					<div class="col-md-3 "  id="serchinput">
						<div class="input-group" >
				      		<span class="input-group-btn">
				       		 	<button class="btn btn-default" type="button">
				       		 		<span class="glyphicon glyphicon-search" id="toserch"  >
									</span>
				       		 	</button>
				      		</span>
			      			<input type="text" class="form-control" placeholder="Search for...">
   			 			</div><!-- /input-group -->
					</div>
					<div class="col-md-6   navbar" id="ybc_main_nav">
							<ul class="nav  nav-justified" id="nav_a" >
								<li><a href="">全新资讯<p class="clearblock"><span  class="caret"></span></p></a></li>
								<li><a href="">女士<p class="clearblock"><span  class="caret"></span></p></a></li>
								<li><a href="">童装<p class="clearblock"><span  class="caret"></span></p></a></li>
								<li><a href="">珠宝和腕<p class="clearblock"><span  class="caret"></span></p></a></li>
								<li><a href="">家饰<p class="clearblock"><span  class="caret"></span></p></a></li>
								<li><a href="">礼品<p class="clearblock"><span  class="caret"></span></p></a></li>
								<li><a href="">古驰故事<p class="clearblock"><span  class="caret"></span></p></a></li>
							</ul>
					</div>
							<div class="container fuji">
								<div class="xialakuag">
									<div class="xialakuangbanxin">
										<ul >
											<li><h4>新品浏览</h4></li>
											<li><a href="">按秀场款式选购</a></li>
											<li><a href="">Gucci 1955马衔扣手袋</a></li>
											<li><a href="">Grip系列腕表</a></li>
											<li><a href="">古驰宣言系列</a></li>
										</ul>
										<ul>
											<li><h4>观看视频</h4></li>
											<li><a href="">2020春夏</a></li>
											<li><a href="">2020早春</a></li>
											<li><a href="">2019秋冬</a></li>
											<li><a href="">2019春夏</a></li>
										</ul>
										<ul>
											<li><h4>编辑精选</h4></li>
											<li><a href="">演出者(The Performers)</a></li>
											<li><a href="">Harry Styles Tailoring</a></li>
											<li><a href="">#Guccigi</a></li>
										</ul>
									</div>
								</div>
							</div>
				</div>
			</div>
			<div class="container ybc_nav_center">
						<div class="row">
							<div class="col-lg-4 text-center col-lg-offset-4 visible-lg">
								<h4>G U C C I</h4>
							</div>
						</div>
						<div class="row ">
							<div class="col-lg-4 text-center col-lg-offset-4  visible-lg">
								<h1>购物袋</h1>
							</div>
						</div>
			</div>
		</div>
		<section class="ybc_main">
			<div class="container">
				<div class="row">
				<div class="col-md-8" id="usershoppinglist">
					
					<c:if test="${empty  userlogininfo}">
						<p>您还没有登录哦，您可以返回<a href="main_frame.jsp">首页</a>或立即<a href="wkr-zhuce.jsp">登录 </a></p>
					</c:if>
						<p><input id="quanxuan" type="checkbox" checked="checked"/>全选</p>
					<hr />
					<!--循环页面  -->
					<c:forEach items="${shoppinglist}" var="goods" varStatus="i">
					<div class="shangping">
						<input class="check" type="checkbox"  checked="checked"/>
						<input  class="hid" type="hidden" value="${goods.goodsid}">
						<a><img src="${goods.goodsimg}"/></a>
						<div class="shangping_desc">
							<div class="shangping_rightline">
								<a id="shangping_name">${goods.goodsname}</a>
								<p id="shangping_type"><span>款号#</span><span>5764320OLRX9698</span><p>
								<p id="shangping_type"><span>款式#</span><span>  ${goods.goodstype}</span><p>
							</div>
							<p class="full">
								<p class="fsize-sm">有货</p>
								<span class="gray">预计发货后2-4个工作日送达</span>
							</p>
							<a class="con" href="">编辑</a>
							<span class="fenge">|</span>
							<a class="con" href="">加入心愿订单</a>
							<span class="fenge">|</span>
							<a class="con delete"  href="javascript:;">删除</a>
						</div>
						<div class="shangping_price">
							<div class="shangping_count">
								<select name="conut_choice" >
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
								</select>
							</div>
							<div class="fsize-md">
								<span>￥</span><span class="price">${goods.goodsprice}</span>
							</div>
						</div>
					</div>
					</c:forEach>
				</div>
				<div class="col-md-4">
					<div class="spice">
						<div class="summery_title">
							<span class="gray">订单小计</span>
							<span class="rightf fsize-sm">已选 <span id="spcount">2</span> 件商品</span>
						</div>
						<div class="summery_content fsize-sm">
							<div class="allmonney"><span >商品总计</span><span class="rightf fsize-md">￥<span class="allpay">2600.00</span></span></div>
							<div class="movepay"><span>运费</span><span class="gray rightf">免费</span></div>
							<div class="monney"><span>总计</span><span class="rightf fsize-xs">￥<span class="allpay">2600.00</span></div>
						</div>
						<div class="summery_desc gray">
							<p>说明</p>
							<span>
							订单提交之后1小时内未付款，订单将被系统自动取消，请您尽快完成支付以确保商品能及时送达，有货商品和门店配货商品是分开寄出。
							</span>
						</div>
						
						<div class="button " >
							<a href="javascript:;" class="gopay" >立即结算</a>
							<a href="" class="gobay">继续购买</a>
						</div>
					</div>
				</div>
				</div>
			</div>
		</section>
		<section class="aboutus">
			<div class="container text-center">
				<h3>GUCCI 在线精品店全新购物体验</h3>
				<ul>
					<li><a href="">Gucci正品认证</a></li>|
					<li><a href="">免费礼品包装 </a></li>|
					 <li><a href="">退换货政策</a><li>
				</ul>
				<p>Gucci重视个人信息保护，以确保一个安全无忧的购物环境。</p>
				<a href="">阅读隐私政策。</a>
			</div>
		</section>
		<section class="nearsee">
			<div class="nearsee4 text-center">
				<div class="texts">
					<h3>最近浏览</h3>
					<span class="glyphicon glyphicon-eye-open">
					</span>
					<p>您浏览过的精品</p>
				</div>
			</div>
			<div class="nearsee1">
				<img src="img/baobao1.jpg"/>
			</div>
			<div class="nearsee2">
				<img src="img/baobao2.jpg"/>
			</div>
			<div class="nearsee3">
				<img src="img/baobao3.jpg"/>
			</div>
		</section>
		<section id="last">
	   	<div class="container">
	   		<div class="row">
	   			<div class="col-md-2">
	   				<p>专属服务</p>
	   				<a href="">免费标准配送</a>
	   				<a href=""> 免费礼品包装</a>
	   				<p>需要帮助？</p>
	   				<a href="">联系我们</a>
	   				<a href="">常见问题</a>
	   			</div>
	   			<div class="col-md-2">
	   				<p>购物相关</p>
	   				<a href="">支付相关</a>
	   				<a href="">配送</a>
	   				
	   				<a href="">退货</a>
	   				<a href="">发票</a>
	   				<a href="">保养与维修</a>
	   			</div>
	   			<div class="col-md-2">
	   				<p>关于公司</p>
	   				<a href="">关于GUCCI</a>
	   				<a href="">GUCCI EQUILIBRLUM</a>
	   				
	   				<a href="">道德规范</a>
	   				<a href="">职业发展</a>
	   				<a href="">细节及条款</a>	
	   				<a href="">隐私与COOKIE</a>	
	   				<a href="">企业信息</a>	
	   			</div>
	   			<div class="col-md-2">
	   				<p>关注GUCCI</p>
	   				<a href="">微信</a>
	   				<a href="">微博</a>
	   				
	   				<a href="">优酷</a>
	   				<a href="">在线顾问</a>
	   				<a href="">400.8210.582</a>
	   			
	   			</div>
	   			<div class="col-md-4">
	   				<p>订阅GUCCI电子资讯</p>
	   				<p>通过订阅，即代表您接受GUCCI的隐私政策条款</p>
	   				<input type="text" name="" id="" value="" placeholder="请输入电子邮箱" />
	   				<p>直营店查询</p>
	   				省份
	   				<select name="请选择省">
	   					<option value="">湖南省</option>
	   				</select>
	   				市区<select name="请选择市">
	   					<option value="">长沙市</option>
	   				</select>
	   				<p>查找其他地区直营店</p>
	   				<img src="img/QQjietu20191025211758.png"/>
	   				
	   			</div>
	   		</div>
	   		<div class="row">
	   		    <div class="col-md-3">
	   		    	<p style="font-size: 11px;">©2019 古驰（中国）贸易有限公司 保留所有权利</p>
	   		    </div>
	   		    
	  
	   		</div>
	   	</div>
	   </section>
	</body>
</html>
<script src="js/jquery.singlePageNav.min.js">
</script>
<script src="js/bootstrap.min.js">
	
</script>
<script src="js/jquery.min.js">
	
</script>
 <script src="js/DF_JS.js" type="text/javascript"></script>
<script type="text/javascript">
loadnav();
	//头部JS
	var flag=0;
	$(document).scroll(function(){
		if($(document).scrollTop()>60){
			$('#logo').slideUp(500);
			$('#ybc_mynav').css('background','#1b1b1b');
		}else{
			$('#logo').slideDown(500);
			$('#ybc_mynav').css('background','none');
		}
	})
	$('#ybc_mynav').mouseenter(function(){
		$('#ybc_mynav').css('background','#1b1b1b')
	})
	$('#ybc_mynav').mouseleave(function(){
		if($(document).scrollTop()>60){
			return;
		}
		$('#ybc_mynav').css('background','none');
	})
	$('#nav_a li').each(function(x){
		$(this).mouseenter(function(){
			flag=1;
		$('#nav_a li a p').eq(x).show();
		$('.xialakuag').fadeIn(500);
		$('.xialakuag').addClass('gomove');
		
	})
		$(this).mouseleave(function(){
//			$('.xialakuag').slideUp();
		$('#nav_a li a p').eq(x).hide();
		setTimeout(function(){
//				$('.xialakuag').hide();
		},100)
		flag=0;
	})
	})
	$('.xialakuag').mouseleave(function(){
		var that=this;
		setTimeout(function(){
			if(flag==0){
				$(that).hide();
			}
//		$('.xialakuag').css('top',45);
		},100)
	})
	//中部
	//商品选择改变价格逻辑
	var allpay=0;
	var spcount=0;
	var flagm=1;
	$('input').each(function(x){
		$(this).click(function(){
			changepay();
		});
	})
	changepay();
	$('select').each(function(x){
		$(this).change(function(){
			changepay();
		});
	})
	$('#quanxuan').click(function(){
			if(flagm==0){
				$('.check').each(function(x){
						$(this).prop('checked',true);
				})
				flagm=1;
			}else{
				$('.check').each(function(x){
				$(this).prop('checked',false);
				})
				flagm=0;
			}
			changepay();
	})
	$('.delete').each(function(){
	//删除操作去Ajax去数据库
		
		var that=$(this);
		$(this).click(function(){
		var goodsid=that.parent().siblings('.hid').val();
			$.ajax({
				type:"POST",
				url:"deletegouwudai.do",
				dataType:"text",
				data:{goods_id:goodsid},
				success:function(result){
					if("true"==result){
						alert("删除成功");
					}
				}
			})
			$(this).parent().parent().remove();
			changepay();
		})
	})
	function changepay(){
		$('.check').each(function(x){
			if($(this).prop('checked')){
				var price= $('.price').eq(x).html()
				price=price.replace(',','');
				allpay+=$('select').eq(x).val()*parseFloat(price);
				spcount+=parseFloat($('select').eq(x).val());
			}
		})
		$('.allpay').html(allpay+'.00');
		$('#spcount').html(spcount);
		allpay=0;
		spcount=0;
	}
	//========================支付
	$('.gopay').click( function(){
		var arr=[];
		$('.check').each(function(x){
			if($(this).prop('checked')){
			var parm=$('.hid').eq(x).val()+"-"+$('select').eq(x).val();
			arr.push(parm);
			}
		})
		if(arr.length!=0){
		var allparm="";
		for (var int = 0; int < arr.length; int++) {
				allparm=allparm+arr[int];
			if(int!=arr.length-1){
				allparm+=",";
			}
		}
			allparm=allparm.replace(/\s+/g, "");
			location.href="dingdan.do?order_mes="+allparm;
			return;
		}
			alert("亲，您还未选择任何商品哦");
	})
	
	
	//================================丁锋
	read();
	//读缓存 
	function read(){
		var name=localStorage.getItem("username");var token=localStorage.getItem("token");
		if(token!=null)
		{  $("#login").hide();
		   $("#shop_cat").hide();
		   $("#welcome").show();
		   $("#exit").show();
		   $("#welcome").html("欢迎.."+name);
			
		}
		else{
			 $("#login").show();
		   $("#shop_cat").show();
		   $("#welcome").hide();
		   $("#exit").hide();
		}	
	}
	$("#exit").click(function(){
		localStorage.removeItem("username");
		localStorage.removeItem("token");
		$("#login").show();
		$("#shop_cat").show();
		$("#welcome").hide();
		$("#exit").hide();
		read();
	})
	//================搜索
	$('#serchinput').hide();
	$('#serch').click(function(){
		$('#serchfather').hide();
		$('#serchinput').show();
	})
	$('#serchinput').mouseleave(function(){
		$('#serchfather').show();
		$('#serchinput').hide();
	})
	$('#toserch').click(function(){
		var desc=$('#serchinput input').val();
		location.href="selectdesc.do?desc="+desc;
	})
	//=========退出登录
		$('#outline').click(function(){
		if(confirm("您现在退出将无法继续进行个人账户的操作，确定吗？")){
			$.ajax({
				type:"GET",
				dataType:"text",
				url:"outline.do",
				success:function(result){
						alert("退出登录成功！");
					$('#ybc_shoping').empty();
					$('#ybc_shoping').html("<a href='wkr-zhuce.jsp' class='login' id='login'><span>登陆 </span></a><a href='gouwudai.do' class='shop_cart' id='shop_cart'><span >购物袋 </span></a><span class='glyphicon glyphicon-shopping-cart'></span>");
					$('#usershoppinglist').html("<p>您还没有登录哦，您可以返回<a href='main_frame.jsp'>首页</a>或立即<a href='wkr-zhuce.jsp'>登录 </a></p>")
				},
			})
				
		}
	})
	//================单态登录的提示
	var msg=$('#loginmsg').val();
	console.log("当前的msg:"+msg);
	if(msg!=''){
		if(confirm(msg+",是否立即去登录?"))
		{
			$.ajax({
				type:"GET",
				dataType:"text",
				url:"cleanmsg.do",
				success:function(result){
					location.href="wkr-zhuce.jsp";
				}
			})
		}else{
			$.ajax({
				type:"GET",
				dataType:"text",
				url:"cleanmsg.do",
				success:function(result){
				}
			})
		}
	}
</script>
