<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />	
	<title>WowH5丨网罗精品</title>
	<link rel="Stylesheet" type="text/css" href="../css/bootstrap.css"/>
	<link rel="Stylesheet" type="text/css" href="../css/index.css"/>
	<script type="text/javascript" src="../js/jquery.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
	<ul class="head">
		<li class="nav-left active"><a href="#home" data-toggle="tab">新秀</a></li>
		<li class="nav-right"><a href="#profile" data-toggle="tab">名人堂</a></li>
	</ul>
	<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="home">
		<c:forEach items="${list}" var="item">
			<div class="model">
				<div class="m-img">
					<img src="${item.thumb }"></img>
					<div class="img-mes">
						<div class="start-time">${item.productionTime }</div>
						<div class="likes">
							<span>${item.productionTime }</span>
							${item.h5Count.goodTimes }
						</div>
					</div>
				</div>
				<div class="model-mes">
					<p class="title">
						${item.title}
					</p>
					<div class="from">
						出品公司：<span>${item.company }</span><span>${item.product }</span>
					</div>
				</div>
			</div>
		</c:forEach>		
	</div>

  </div>
	
	<div id="back-to-top">
		<div class="back-top-icon"><span></span></div>
		<div class="normal">无更多内容了</div>
	</div>
	
</div>
<script type="text/javascript">
  $(document).ready(function() {	  
    $("#back-to-top").hide();
  });
  
  $(function() {
      $(window).scroll(function() {
        if ($(window).scrollTop() > 100) {
          $("#back-to-top").fadeIn(1500);
        } else {
          $("#back-to-top").fadeOut(1500);
        }
      });
      $("#back-to-top").click(function() {
        $('body,html').animate({
          scrollTop: 0
        },
        1000);
        return false;
      });
      
  });

</script>
</body>