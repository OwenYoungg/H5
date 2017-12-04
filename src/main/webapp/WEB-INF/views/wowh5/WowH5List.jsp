<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%> 
<!DOCTYPE html PUBLIC "-//WAPFORUM//DTD XHTML Mobile 1.0//EN" "http://www.wapforum.org/DTD/xhtml-mobile10.dtd">
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
		<c:forEach items="${list1}" var="item">
			<div class="model">
				<div class="m-img">
					<img src="${item.thumb }"></img>
					<div class="img-mes">
						<div class="start-time"><fmt:formatDate value="${item.productionTime }" type="date" dateStyle="long"/>上线</div>
						<div class="likes">
							<span></span>
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
	
	<div role="tabpanel" class="tab-pane active" id="profile">
		<c:forEach items="${list2}" var="item" varStatus="status">
			<div class="model">
				<div class="m-img">
					<img src="${item.thumb }"></img>
					<div class="img-mes">
						<div class="start-time"><fmt:formatDate value="${item.productionTime }" type="date" dateStyle="long"/>上线</div>
						<div class="likes">
							<span></span>
							${item.h5Count.goodTimes }
						</div>
					</div>
				</div>
				<div class="model-mes">
					<p class="title">
						${item.title}
						<c:if test="${status.index eq 0 }"><img src="../icon/gold_icn.png"/></c:if>
						<c:if test="${status.index eq 1 }"><img src="../icon/silver medal_icn.png"/></c:if>
						<c:if test="${status.index eq 2 }"><img src="../icon/bronze medal_icn.png"/></c:if>
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