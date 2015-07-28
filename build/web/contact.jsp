<%-- 
    Document   : index
    Created on : Jul 16, 2015, 8:35:54 AM
    Author     : Lucci
--%>
<!DOCTYPE html>
<html>
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
						<h3> <div class="total">
							<span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items)</div>
							<img src="images/cart-1.png" alt=""/></h3>
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
				<ul class="memenu skyblue"><li class="active"><a href="index.jsp">Home</a></li>
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
	<!--start-breadcrumbs-->
	<div class="breadcrumbs">
		<div class="container">
			<div class="breadcrumbs-main">
				<ol class="breadcrumb">
					<li><a href="index.jsp">Home</a></li>
					<li class="active">Contact</li>
				</ol>
			</div>
		</div>
	</div>
	<!--end-breadcrumbs-->
	<!--start-contact-->
	<div class="contact">
		<div class="container">
			<div class="contact-top heading"> 
				<h3>CONTACT US</h3>
			</div>
			<div class="contact-bottom"> 
				<div class="col-md-6 contact-left"> 
				<form>
					<input type="text" placeholder="Name" required="">
					<input type="text" placeholder="E-mail" required="">
					<input type="text" placeholder="Phone" required="">
				</form>
				</div>
				<div class="col-md-6 contact-left">
				<form>
					<textarea placeholder="Message"></textarea>
					<input type="submit" value="SEND">
				</form>	
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!--end-contact-->
	<!--start-map-->
	<div class="map">
		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3724.0298149461596!2d105.832539!3d21.031492999999998!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135ab9f705bd547%3A0x92fd25394dd9ea17!2zODggTmd1eeG7hW4gVGjDoWkgSOG7jWMsIMSQaeG7h24gQmnDqm4sIMSQ4buRbmcgxJBhLCBIw6AgTuG7mWksIFZp4buHdCBOYW0!5e0!3m2!1svi!2s!4v1437407423019" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
	</div>
	<!--end-map-->
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