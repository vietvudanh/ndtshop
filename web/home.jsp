<%-- 
    Document   : index
    Created on : Jul 16, 2015, 8:35:54 AM
    Author     : Lucci
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<c:choose>
	<c:when test="${sessionScope.user != null}">
		Logged in as ${sessionScope.customername}
		<a href="${contextPath}/logout">Logout</a>
	</c:when>
	<c:when test="${sessionScope.user == null}"><a href="${contextPath}/login">Login</a></c:when>
</c:choose>
<head>
<title>NDTShop</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.0.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Free Style Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--fonts-->
<link href='http://fonts.googleapis.com/css?family=Alegreya+Sans+SC:100,300,400,500,700,800,900,100italic,300italic,400italic,500italic,700italic,800italic,900italic' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic' rel='stylesheet' type='text/css'>
<!--//fonts-->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
					jQuery(document).ready(function($) {
						$(".scroll").click(function(event){		
							event.preventDefault();
							$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
						});
					});
				</script>
                                
<script type="text/javascript">
     jQuery(document).ready(function() {
         var scop = jQuery(".megasub");
         scop.find("li[IconUrl]").hover(function() {
            var me = jQuery(this);
            scop.find(".catimg").attr("src", me.attr("iconurl"));
            scop.find(".catdes").html( me.attr("Contents"));
         });
     });
 </script>


<!-- start menu -->
<script src="js/simpleCart.min.js"> </script>
<link href="css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>				
</head>
<body> 
	<!--top-header-->
	<div class="top-header">
	<div class="container">
		<div class="top-header-main">
			<div class="col-md-4 top-header-left">
				<div class="search-bar">
					<input type="text" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
					<input type="submit" value="">
				</div>
			</div>
			<div class="col-md-4 top-header-middle">
				<a href="index.jsp"><img src="images/logo-4.png" alt="" /></a>
			</div>
			<div class="col-md-4 top-header-right">
				<div class="cart box_1">
						<a href="checkout.jsp">
						 <h3><div class="total">
							<span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items)</div>
                                                     <img src="images/cart-1.png" alt="" /></h3>
						</a>
						<p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>
						<div class="clearfix"> </div>
					</div>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!--top-header-->
	<!--bottom-header-->
	<div class="header-bottom">
		<div class="container">
			<div class="top-nav">
                          
                            <ul class="memenu skyblue"><li class="active"><a href="index.jsp">${news.newstitle}</a></li>
					<li class="grid"><a href="#">Introduction</a>
						<div class="mepanel">
							<div class="row">
								<div class="col1 me-one">
									
									<ul>
										<li><a href="products.html">General about NDT</a></li>
										<li><a href="products.html">management and apparatus Organisation</a></li>
										
									</ul>	
								</div>
                                                                <div class="col1 me-one">
									
									<ul>
										
										<li><a href="products.html">Staff</a></li>
										<li><a href="products.html">technological transfer acceptation</a></li>
										
									</ul>	
								</div>
                                                                <div class="col1 me-one">
									
									<ul>
										
										<li><a href="products.html">objective mission purview</a></li>
										<li><a href="products.html">Prize</a></li>
									</ul>	
								</div>
							</div>
						</div>
					</li>
					<li class="grid"><a href="index.jsp">News</a>
						<div class="mepanel">
							<div class="row">
								<div class="col1 me-one">
									<h4>Event</h4>
									<ul>
										<li><a href="products.html">Meeting</a></li>
										<li><a href="products.html">Holiday</a></li>
										<li><a href="products.html">Sport</a></li>
                                                                                <li><a href="products.html">Visit</a></li>
									</ul>
								</div>
								<div class="col1 me-one">
									<h4>Internal</h4>
									<ul>
										<li><a href="products.html">Notice</a></li>
										<li><a href="products.html">Documents</a></li>
									</ul>	
								</div>
								<div class="col1 me-one">
									<h4>Pictures</h4>
									<ul>
										<li><a href="products.html">Meeting</a></li>
										<li><a href="products.html">Holiday</a></li>
										<li><a href="products.html">Sport</a></li>
                                                                                <li><a href="products.html">Visit</a></li>
									</ul>	
								</div>
							</div>
						</div>
					</li>
					<li class="grid"><a href="products.jsp">Products</a>
						<div class="mepanel">
							<div class="row">
								<div class="col1 me-one">
									<h4>Shop</h4>
									<ul>
										<li><a href="products.html">New Arrivals</a></li>
										<li><a href="products.html">Men</a></li>
										<li><a href="products.html">Women</a></li>
										<li><a href="products.html">Accessories</a></li>
										<li><a href="products.html">Kids</a></li>
										<li><a href="products.html">login</a></li>
										<li><a href="products.html">Brands</a></li>
										<li><a href="products.html">My Shopping Bag</a></li>
									</ul>
								</div>
								<div class="col1 me-one">
									<h4>Style Zone</h4>
									<ul>
										<li><a href="products.html">Men</a></li>
										<li><a href="products.html">Women</a></li>
										<li><a href="products.html">Brands</a></li>
										<li><a href="products.html">Kids</a></li>
										<li><a href="products.html">Accessories</a></li>
										<li><a href="products.html">Style Videos</a></li>
									</ul>	
								</div>
								<div class="col1 me-one">
									<h4>Popular Brands</h4>
									<ul>
										<li><a href="products.html">Levis</a></li>
										<li><a href="products.html">Persol</a></li>
										<li><a href="products.html">Nike</a></li>
										<li><a href="products.html">Edwin</a></li>
										<li><a href="products.html">New Balance</a></li>
										<li><a href="products.html">Jack & Jones</a></li>
										<li><a href="products.html">Paul Smith</a></li>
										<li><a href="products.html">Ray-Ban</a></li>
										<li><a href="products.html">Wood Wood</a></li>
									</ul>	
								</div>
							</div>
						</div>
					</li>
					<li class="grid"><a href="#">Services</a>
						<div class="mepanel">
							<div class="row">
								<div class="col1 me-one">
									
									<ul>
										<li><a href="products.html">10 rule</a></li>
										
									</ul>
								</div>
								<div class="col1 me-one">
									
									<ul>
										<li><a href="products.html">Policy</a></li>
										
									</ul>	
								</div>
								
							</div>
						</div>
					</li>
					<li class="grid"><a href="contact.jsp">Contact</a>
						
					</li>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
	<!--bottom-header-->
	<!--banner-starts-->
	<div class="bnr" id="home">
		<div  id="top" class="callbacks_container">
			<ul class="rslides" id="slider4">
			    <li>
					<div class="banner-1"></div>
				</li>
				<li>
					<div class="banner-2"></div>
				</li>
				<li>
					<div class="banner-3"></div>
				</li>
			</ul>
		</div>
		<div class="clearfix"> </div>
	</div>
	<!--banner-ends--> 
	<!--Slider-Starts-Here-->
				<script src="js/responsiveslides.min.js"></script>
			 <script>
			    // You can also use "$(window).load(function() {"
			    $(function () {
			      // Slideshow 4
			      $("#slider4").responsiveSlides({
			        auto: true,
			        pager: true,
			        nav: false,
			        speed: 500,
			        namespace: "callbacks",
			        before: function () {
			          $('.events').append("<li>before event fired.</li>");
			        },
			        after: function () {
			          $('.events').append("<li>after event fired.</li>");
			        }
			      });
			
			    });
			  </script>
			<!--End-slider-script-->
	<!--start-banner-bottom--> 
	<div class="banner-bottom">
		<div class="container">
			<div class="banner-bottom-top">
				<div class="col-md-6 banner-bottom-left">
					<div class="bnr-one">
						<div class="bnr-left">
							<h1><a href="detail.jsp">Titan 2000 series</a></h1>
							<p>Nulla tempus facilisis purus at.</p>
							<div class="b-btn"> 
								<a href="detail.jsp">SHOP NOW</a>
							</div>
						</div>
						<div class="bnr-right"> 
							<a href="detail.jsp"><img src="images/b-1.jpg" alt="" /></a>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="col-md-6 banner-bottom-right">
					<div class="bnr-two">
						<div class="bnr-left">
							<h2><a href="detail.jsp">Eva HF 525/750 Plus</a></h2>
							<p>Nulla tempus facilisis purus at.</p>
							<div class="b-btn"> 
								<a href="detail.jsp">SHOP NOW</a>
							</div>
						</div>
						<div class="bnr-right"> 
							<a href="detail.jsp"><img src="images/b-2.jpg" alt="" /></a>
						</div>
						<div class="clearfix"> </div>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--end-banner-bottom--> 
	<!--start-shoes--> 
	<div class="shoes"> 
		<div class="container"> 
			<div class="product-one">
				<div class="col-md-3 product-left"> 
					<div class="p-one simpleCart_shelfItem">							
							<a href="detail.jsp">
								<img src="images/titan11.jpg" alt="" />
								<div class="mask">
									<span>Quick View</span>
								</div>
							</a>
						<h4>Titan 11</h4>
						<p><a class="item_add" href="#"><i></i> <span class=" item_price">$3299</span></a></p>
					
					</div>
				</div>
				<div class="col-md-3 product-left"> 
					<div class="p-one simpleCart_shelfItem">
						
						<a href="detail.jsp">
								<img src="images/dr.jpg" alt="" />
								<div class="mask">
									<span>Quick View</span>
								</div>
							</a>
						<h4>Portable Dr</h4>
						<p><a class="item_add" href="#"><i></i> <span class=" item_price">$4599</span></a></p>
						
					</div>
				</div>
				<div class="col-md-3 product-left"> 
					<div class="p-one simpleCart_shelfItem">
						
						<a href="detail.jsp">
								<img src="images/Titan200dual.png" alt="" />
								<div class="mask">
									<span>Quick View</span>
								</div>
							</a>
						<h4>Titan 2000 dual</h4>
						<p><a class="item_add" href="#"><i></i> <span class=" item_price">$6329</span></a></p>
						
					</div>
				</div>
				<div class="col-md-3 product-left"> 
					<div class="p-one simpleCart_shelfItem">
						
						<a href="detail.jsp">
								<img src="images/kmc650.png" alt="" />
								<div class="mask">
									<span>Quick View</span>
								</div>
							</a>
						<h4>KMC 650</h4>
						<p><a class="item_add" href="#"><i></i> <span class=" item_price">$4329</span></a></p>
						
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
			<div class="product-one">
				<div class="col-md-3 product-left"> 
					<div class="p-one simpleCart_shelfItem">
						
						<a href="detail.jsp">
								<img src="images/asadalm1.png" alt="" />
								<div class="mask">
									<span>Quick View</span>
								</div>
							</a>
						<h4>ASADAL-M1</h4>
						<p><a class="item_add" href="#"><i></i> <span class=" item_price">$2329</span></a></p>
						
					</div>
				</div>
				<div class="col-md-3 product-left"> 
					<div class="p-one simpleCart_shelfItem">
						
						<a href="detail.jsp">
								<img src="images/SDS5000.png" alt="" />
								<div class="mask">
									<span>Quick View</span>
								</div>
							</a>
						<h4>SDS-5000</h4>
						<p><a class="item_add" href="#"><i></i> <span class=" item_price">$8329</span></a></p>
						
					</div>
				</div>
				<div class="col-md-3 product-left"> 
					<div class="p-one simpleCart_shelfItem">
						
						<a href="detail.jsp">
								<img src="images/PviewDR.png" alt="" />
								<div class="mask">
									<span>Quick View</span>
								</div>
							</a>
						<h4>PINKVIEW SERIES</h4>
						<p><a class="item_add" href="#"><i></i> <span class=" item_price">$3729</span></a></p>
						
					</div>
				</div>
				<div class="col-md-3 product-left"> 
					<div class="p-one simpleCart_shelfItem">
						
						<a href="detail.jsp">
								<img src="images/spinel3g.jpg" alt="" />
								<div class="mask">
									<span>Quick View</span>
								</div>
							</a>
						<h4>SPINEL 3G</h4>
						<p><a class="item_add" href="#"><i></i> <span class=" item_price">$9329</span></a></p>
						
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--end-shoes-->
	<!--start-abt-shoe-->
	<div class="abt-shoe">
		<div class="container"> 
			<div class="abt-shoe-main">
				<div class="col-md-4 abt-shoe-left">
					<div class="abt-one">
						<a href="detail.jsp"><img src="images/PACsrad2.png" alt="" /></a>
						<h4><a href="detail.jsp">INFINITT PACS RAD</a></h4>
						<p>Phasellus auctor vulputate egestas. Nulla facilisi. Cras dolor ligula Nulla facilisi Nulla facilisiNulla facilisiNulla facilisi </p>
					</div>
				</div>
				<div class="col-md-4 abt-shoe-left">
					<div class="abt-one">
						<a href="detail.jsp"><img src="images/infinitcard.jpg" alt="" /></a>
						<h4><a href="detail.jsp">INFINITT PACS CARD</a></h4>
						<p>Phasellus auctor vulputate egestas. Nulla facilisi. Cras dolor ligula, pharetra vitae efficitur ac, tempus vitae nisl. Aliquam erat volutpat. </p>
					</div>
				</div>
				<div class="col-md-4 abt-shoe-left">
					<div class="abt-one">
						<a href="detail.jsp"><img src="images/seli.png" alt="" /></a>
						<h4><a href="detail.jsp">XELIS PACS (3D)</a></h4>
						<p>Phasellus auctor vulputate egestas. Nulla facilisi. Cras dolor ligula, pharetra vitae efficitur ac, tempus vitae nisl. Aliquam erat volutpat. </p>
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--end-abt-shoe-->
	<!--start-footer-->
	<div class="footer">
		<div class="container">
			<div class="footer-top">
				<div class="col-md-3 footer-left">
					<h3>ABOUT US</h3>
					<ul>
						<li><a href="#">Who We Are</a></li>
						<li><a href="contact.jsp">Contact Us</a></li>
						<li><a href="#">Our Sites</a></li>
						<li><a href="#">In The News</a></li>
						<li><a href="#">Team</a></li>
						<li><a href="#">Carrers</a></li>					 
					</ul>
				</div>
				<div class="col-md-3 footer-left">
					<h3>YOUR ACCOUNT</h3>
					<ul>
						<li><a href="account.jsp">Your Account</a></li>
						<li><a href="#">Personal Information</a></li>
						<li><a href="contact.jsp">Addresses</a></li>
						<li><a href="#">Discount</a></li>
						<li><a href="#">Track your order</a></li>					 					 
					</ul>
				</div>
				<div class="col-md-3 footer-left">
					<h3>CUSTOMER SERVICES</h3>
					<ul>
						<li><a href="#">FAQ</a></li>
						<li><a href="#">Shipping</a></li>
						<li><a href="#">Cancellation</a></li>
						<li><a href="#">Returns</a></li>
						<li><a href="#">Bulk Orders</a></li>
						<li><a href="#">Buying Guides</a></li>					 
					</ul>
				</div>
				<div class="col-md-3 footer-left">
					<h3>CATEGORIES</h3>
					<ul>
						<li><a href="#">Titan series</a></li>
						<li><a href="#">Spinel series</a></li>
						<li><a href="#">DR series</a></li>
						<li><a href="#">CR series</a></li>
						<li><a href="#">Pacs system</a></li>				 
					</ul>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--end-footer-->
	<!--end-footer-text-->
	<div class="footer-text">
		<div class="container">
			<div class="footer-main">
				<p class="footer-class">© 2015 All Rights Reserved | Design by  <a href="http://lakesidegarden.com.vn/" target="_blank">HoangVD01349</a> </p>
			</div>
		</div>
		<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear' 
								 		};
										*/
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
		<a href="#home" id="toTop" class="scroll" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	</div>
	<!--end-footer-text-->	
</body>
</html>