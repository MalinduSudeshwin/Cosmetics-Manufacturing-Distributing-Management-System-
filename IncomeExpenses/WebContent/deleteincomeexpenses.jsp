<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <link
      href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900"
      rel="stylesheet"
    />

    <title> Income & Expenses Management</title>
<!--
Reflux Template
https://templatemo.com/tm-531-reflux
-->
    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Additional CSS Files -->
    <link rel="stylesheet" href="assets/css/fontawesome.css" />
    <link rel="stylesheet" href="assets/css/templatemo-style.css" />
    <link rel="stylesheet" href="assets/css/owl.css" />
    <link rel="stylesheet" href="assets/css/lightbox.css" />
    <link rel="stylesheet" href="income/css/slide.css" />
     <link rel="stylesheet" href="income/css/income.css" />
</head>
<body>

 <body>
    <div id="page-wraper">
      <!-- Sidebar Menu -->
      <div class="responsive-nav">
        <i class="fa fa-bars" id="menu-toggle"></i>
        <div id="menu" class="menu">
          <i class="fa fa-times" id="menu-close"></i>
          <div class="container">
            
            <div class="author-content">
              <h4>Royal Cosmetics</h4>
              <span>Income & Expenses Management</span>
            </div>
            <nav class="main-nav" role="navigation">
              <ul class="main-menu">
                <li><a href="#section1">Home</a></li>
                <li><a href="#section2">Delete Income & Expenses</a></li>
                <li><a href="#section3">Search Income & Expenses</a></li>
                <li><a href="#section4">Report</a></li>
              </ul>
            </nav>
            <div class="social-network">
              <ul class="soial-icons">
                <li>
                  <a href="https://fb.com/templatemo"
                    ><i class="fa fa-facebook"></i
                  ></a>
                </li>
                <li>
                  <a href="#"><i class="fa fa-twitter"></i></a>
                </li>
                <li>
                  <a href="#"><i class="fa fa-linkedin"></i></a>
                </li>
                <li>
                  <a href="#"><i class="fa fa-dribbble"></i></a>
                </li>
                <li>
                  <a href="#"><i class="fa fa-rss"></i></a>
                </li>
              </ul>
            </div>
            <div class="copyright-text">
              <p>Copyright 2021 Royal Cosmetics</p>
            </div>
          </div>
        </div>
      </div>

      <section class="section my-work" data-section="section1">
        <div class="container">
          <div class="section-heading">
            <h2>Home</h2>
            <div class="line-dec"></div>
          </div>
          <div class="slideshow-container">
				<center>
				<div class="mySlides fade">
				  <img src="income/1.jpg" style="width:70%" >
				</div>

				<div class="mySlides fade">
				  <img src="income/2.jpg" style="width:70%">
				</div>

				<div class="mySlides fade">
				  <img src="income/3.jpg" style="width:70%">
				</div>
				
				<div class="mySlides fade">
				  <img src="income/4.jpg" style="width:70%">
				</div>
				</center>
		  </div>
		  <br>
				<div style="text-align:center">
				  <span class="dot"></span> 
				  <span class="dot"></span> 
				  <span class="dot"></span> 
				  <span class="dot"></span> 
				</div>
			<div class="section-heading">
			<h3>Service</h3>
			<span>Service companies have the most basic income statement of all the types of companies. 
				  Since service based companies do not sell a product, the income statement will not contain cost of goods sold. 
				  Therefore, the income statement will be a basic breakdown of income and expenses.</span>
			</div>
        </div>
      </section>
      
      
      
      
      <section class="section my-services" data-section="section2">
        <div class="container">
          <div class="section-heading">
            <h2>Delete Income & Expenses</h2>
            <div class="line-dec"></div>
	      </div>
			      
			<%
				String id = request.getParameter("id");
				String billID = request.getParameter("billid");
				String category = request.getParameter("category");
				String date = request.getParameter("date");
				String phone = request.getParameter("phone");
				String amount = request.getParameter("amount");
			%>
			
			<form class="form1" action="delete" method="post">
				
				No<input type="text" name="ineid" value="<%= id%>" readonly><br><br>
				Bill ID<input type="text" name="billid" value="<%= billID%>"readonly><br><br>
				Category<input type="text" name="category" value="<%= category%>"readonly><br><br>
				Date<input type="date" name="date" value="<%= date%>"readonly><br><br>
			    Phone No<input type="text" name="phone" value="<%= phone%>"readonly><br><br>
			    Amount <input type="text" name="amount" value="<%= amount%>"readonly><br><br><br>
			    
			    <input class="sub" type="submit" name="submit" value="Delete">
			</form>	
	    </div>
      </section>



      <section class="section my-services" data-section="section3">
        <div class="container">
          <div class="section-heading">
            <h2>Search Income & Expenses</h2>
            <div class="line-dec"></div>
	      </div> 
		  <form class="form2"action="search" method="post">
			Bill ID<input type="text" name="bid" placeholder = "BillID" ><br><br>	
			<input class="submit" type="submit" name="submit" value="Search"><br><br><br>	  
		  </form>
        </div>
      </section>

                

      <section class="section contact-me" data-section="section4">
        <div class="container">
          <div class="section-heading">
            <h2>Report</h2>
            <div class="line-dec"></div>
          </div>
		  <form class="form2"action="generatePDF" >
			<select name = 'cate'>
				<option value="Income">Income</option>
				<option value="Expenses">Expenses</option>
			</select>
			<br><br>
			<input class = "sub" type = 'submit'name="submit" value="Generate">
	  
		  </form>
        </div>
      </section>
    </div>

    <!-- Scripts -->
    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <script src="assets/js/isotope.min.js"></script>
    <script src="assets/js/owl-carousel.js"></script>
    <script src="assets/js/lightbox.js"></script>
    <script src="assets/js/custom.js"></script>
    <script>
      //according to loftblog tut
      $(".main-menu li:first").addClass("active");

      var showSection = function showSection(section, isAnimate) {
        var direction = section.replace(/#/, ""),
          reqSection = $(".section").filter(
            '[data-section="' + direction + '"]'
          ),
          reqSectionPos = reqSection.offset().top - 0;

        if (isAnimate) {
          $("body, html").animate(
            {
              scrollTop: reqSectionPos
            },
            800
          );
        } else {
          $("body, html").scrollTop(reqSectionPos);
        }
      };

      var checkSection = function checkSection() {
        $(".section").each(function() {
          var $this = $(this),
            topEdge = $this.offset().top - 80,
            bottomEdge = topEdge + $this.height(),
            wScroll = $(window).scrollTop();
          if (topEdge < wScroll && bottomEdge > wScroll) {
            var currentId = $this.data("section"),
              reqLink = $("a").filter("[href*=\\#" + currentId + "]");
            reqLink
              .closest("li")
              .addClass("active")
              .siblings()
              .removeClass("active");
          }
        });
      };

      $(".main-menu").on("click", "a", function(e) {
        e.preventDefault();
        showSection($(this).attr("href"), true);
      });

      $(window).scroll(function() {
        checkSection();
      });
      
      
	  var slideIndex = 0;
		showSlides();

		function showSlides() {
		  var i;
		  var slides = document.getElementsByClassName("mySlides");
		  var dots = document.getElementsByClassName("dot");
		  for (i = 0; i < slides.length; i++) {
			slides[i].style.display = "none";  
		  }
		  slideIndex++;
		  if (slideIndex > slides.length) {slideIndex = 1}    
		  for (i = 0; i < dots.length; i++) {
			dots[i].className = dots[i].className.replace(" active", "");
		  }
		  slides[slideIndex-1].style.display = "block";  
		  dots[slideIndex-1].className += " active";
		  setTimeout(showSlides, 1500); // Change image every 1 seconds
		}
    </script>



</body>
</html>





	
