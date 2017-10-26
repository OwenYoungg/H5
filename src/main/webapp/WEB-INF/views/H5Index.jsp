<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>WOWH5</title>

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../css/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../css/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
    <!-- DatePicker -->
    <link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css">
    
    <!--引入CSS-->
	<link rel="stylesheet" type="text/css" href="../css/webuploader.css">
	
	<link rel="stylesheet" href="../css/bootstrapValidator.min.css"/>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">
        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0;background-color:#000;">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">WOWH5 管理平台</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                <!-- 用户设置下拉菜单 -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> 用户信息</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> 设置</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> 退出登录</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                <button class="btn btn-default" type="button">
                                    <i class="fa fa-search"></i>
                                </button>
                            </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="/H5/h5/H5Index.do"><i class="fa fa-dashboard fa-fw"></i>后台管理系统</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> 内容<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">H5 列表</a>
                                </li>
                                <li>
                                    <a href="morris.html">新建 H5</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-wrench fa-fw"></i> H5 数据分析<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="panels-wells.html">H5 访问统计</a>
                                </li>
                                <li>
                                    <a href="buttons.html">H5 用户量统计</a>
                                </li>
                                <li>
                                    <a href="notifications.html">H5 页面访问情况分析</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">新建 H5</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <form class="form-horizontal" role="form" id="h5Form">
					<div class="form-group">
						<label class="col-sm-2 control-label">H5标题(<font color="red">*</font>)</label>
						<div class="col-sm-5">
							<input id="title" name="title" type="text" class="form-control" placeholder="必填，长度0~20"/>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">H5链接地址(<font color="red">*</font>)</label>
						<div class="col-sm-5">
							<input id="h5Url" name="h5Url" type="text" class="form-control" placeholder="必填">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">出品公司</label>
						<div class="col-sm-5">
							<input id="company" name="company" type="text" class="form-control" placeholder="必填">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">出品产品</label>
						<div class="col-sm-5">
						    <input id="product" name="product" type="text" class="form-control" placeholder="必填">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">出品时间</label>
						<div class="col-sm-5">
						    <input type="text" class="form-control" value="2017-01-01" id="datetimepicker" name="datetimepicker">
						    <span class="add-on"><i class="icon-th"></i></span>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">上传缩略图</label>
						<div class="col-sm-5">
							<input id="url" name="url" type="text" class="form-control" placeholder="必填"><br/>
							<div id="uploader">
							    <!--用来存放item-->
							    <div id="fileList" class="uploader-list"></div>
							    <div id="filePicker">选择图片</div>
							</div>
						</div>
						
					</div>

					<div class="form-group">
						<label class="col-sm-2 control-label">能否嵌入(<font color="red">*</font>)</label>
						<div class="col-sm-5">
							<div class="radio">
								<label>
									<input type="radio" id="embedded" name="embeddedIframe" checked="checked"> 嵌入
								</label>
							</div>
							<div class="radio">
								<label>
									<input type="radio" id="unembedded" name="embeddedIframe"> 不嵌入
								</label>
							</div>
						</div>
					</div>
					<div class="form-group" id="tagDiv1">
						<label class="col-sm-2 control-label">标签</label>
						<div class="col-sm-5">
							<input id="tag" name="tag" type="text" class="form-control" placeholder="选填">
						</div>
						<button type="button" class="btn btn-primary" name="addTag">
				          <span class="glyphicon glyphicon-plus"></span>
				        </button>
						<button type="button" class="btn btn-default" name="delTag">
				          <span class="glyphicon glyphicon-trash"></span>
				        </button>
					</div>
					
					<div class="form-group">
					    <div class="col-sm-offset-2 col-sm-10">
					      <button id="submitBtn" class="btn btn-primary">提交</button>
					      <button id="cancelBtn" class="btn btn-primary">返回</button>
					    </div>
					</div>
				</form>
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
    

    <!-- jQuery -->
    <script src="../js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../js/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="../js/raphael.min.js"></script>
    <script src="../js/morris.min.js"></script>
    <script src="../js/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../js/sb-admin-2.js"></script>
    
    <script src="../js/bootstrap-datetimepicker.min.js"></script>
    <script src="../js/bootstrap-datetimepicker.zh-CN.js"></script>
    <!--引入JS-->
	<script type="text/javascript" src="../js/webuploader.js"></script>
	<script type="text/javascript" src="../js/bootstrapValidator.min.js"></script>
	<script type="text/javascript">
	var tag_count = 1;
	var pic_count = 0;	
	
	$(function(){
		//初始化时间控件
	    $('#datetimepicker').datetimepicker({  
	        format:'yyyy-mm-dd',
	        language:'zh-CN',
	        minView: "month",
	        todayBtn:  1,
	        autoclose: 1,
	    }); 
		
	 	// 初始化Web Uploader
	    var uploader = WebUploader.create({

	        // 选完文件后，是否自动上传。
	        auto: true,

	        // swf文件路径
	        swf: '../css/Uploader.swf',

	        // 文件接收服务端。
	        server: 'http://localhost:8080/H5/h5/fileUpload.json',

	        // 选择文件的按钮。可选。
	        // 内部根据当前运行是创建，可能是input元素，也可能是flash.
	        pick: '#filePicker',

	        // 只允许选择图片文件。
	        accept: {
	            title: 'Images',
	            extensions: 'gif,jpg,jpeg,bmp,png',
	            mimeTypes: 'image/*'
	        }
	    });
	    
	 	// 当有文件添加进来的时候
	    uploader.on( 'fileQueued', function( file ) {
	    	if(pic_count == 1)
	    		return;
	    	
	        var $li = $(
	                '<div id="' + file.id + '" class="file-item thumbnail">' +
	                    '<img>' +
	                    '<div class="info">' + file.name + '</div>' +
	                '</div>'
	                ),
	            $img = $li.find('img');


	        // $list为容器jQuery实例
	        $list = $("#fileList");
	        $list.append( $li );
	        //只添加一个缩略图
	        pic_count++;

	        // 创建缩略图
	        // 如果为非图片文件，可以不用调用此方法。
	        // thumbnailWidth x thumbnailHeight 为 100 x 100
	        uploader.makeThumb( file, function( error, src ) {
	            if ( error ) {
	                $img.replaceWith('<span>不能预览</span>');
	                return;
	            }

	            $img.attr( 'src', src );
	        }, 100, 150 );
	    });
	 	
	 	// 文件上传过程中创建进度条实时显示。
	    uploader.on( 'uploadProgress', function( file, percentage ) {
	        var $li = $( '#'+file.id ),
	            $percent = $li.find('.progress span');

	        // 避免重复创建
	        if ( !$percent.length ) {
	            $percent = $('<p class="progress"><span></span></p>')
	                    .appendTo( $li )
	                    .find('span');
	        }

	        $percent.css( 'width', percentage * 100 + '%' );
	    });

	    // 文件上传成功，给item添加成功class, 用样式标记上传成功。
	    uploader.on( 'uploadSuccess', function( file, response ) {
	        $( '#'+file.id ).addClass('upload-state-done');
	        alert(file.name + "上传完成");
	        console.log(response);
	        $("#url").val(response.URL);
	    });

	    // 文件上传失败，显示上传出错。
	    uploader.on( 'uploadError', function( file ) {
	        var $li = $( '#'+file.id ),
	            $error = $li.find('div.error');

	        // 避免重复创建
	        if ( !$error.length ) {
	            $error = $('<div class="error"></div>').appendTo( $li );
	        }

	        $error.text('上传失败');
	    });

	    // 完成上传完了，成功或者失败，先删除进度条。
	    uploader.on( 'uploadComplete', function( file ) {
	        $( '#'+file.id ).find('.progress').remove();
	    });
	 	
	    //标签动态添加删除
	    $("[name='addTag']").on('click',function(){
	    	var index = tag_count;
	    	tag_count++;
	        var html = $("<div class='form-group' id='tagDiv"+tag_count+"'>"
	        		+"<label class='col-sm-2 control-label'>标签</label>"
	        		+"<div class='col-sm-5'>"
	        		+"<input id='tag' name='tag' type='text' class='form-control' placeholder='选填'/>"
	        		+"</div>");
	    	$("#tagDiv"+index).after(html);
	    });
	    
	    $("[name='delTag']").on('click',function(){
	    	if(tag_count == 1)
	    		return;
	    	else{
	    		$("#tagDiv"+tag_count).remove();
		    	tag_count--;
	    	}
	    });
	    
	    //提交按钮
	    $("#submitBtn").on('click',function(){
	    	var bootstrapValidator = $('#h5Form').data('bootstrapValidator');
	    	bootstrapValidator.validate();
	    	if(!bootstrapValidator.isValid())
	    		return;
	    	var form = new FormData();
			var title = $("#title").val();
			var url = $("#h5Url").val();
			var company = $("#company").val();
			var product = $("#product").val();
			var productionTime = $("#datetimepicker").val();
			var embeddedIframe = $("#embedded").prop("checked");
			var thumb = $("#url").val();
			
			form.append("title", title);
			form.append("url", url);
			form.append("company", company);
			form.append("product", product);
			form.append("productionTime", productionTime);
			form.append("embeddedIframe", embeddedIframe);
			form.append("thumb", thumb);

			alert("title:" + title + "url:" + url + " company:" + company
					+ " product:" + product + " productionTime:" + productionTime
					+ " embeddedIframe:" + embeddedIframe + " thumb:"+thumb);
			  $.ajax({
				 //url:"http://localhost:8080/H5/h5/save.json",//本地
		         url:"http://m.wowh5.cn/h5/save.json",//正式
				 type:"post",
				 data:form,
				 dataType:"json",
				 processData:false,
				 contentType:false,
				 success:function(data){
		                var tagform = new FormData(); 
		                var h5id = data.DATA.id;
		                tagform.append("h5InfoId",h5id);
		                //存储tag
		              //获取标签参数
		    			$("[name='tag']").each(function(){
		    				//alert($(this).val());
		    				tagform.append("name",($(this).val()));
		    			});
		                
		                $.ajax({
		                	//url:"http://localhost:8080/H5/h5tag/batchSave.json", //本地
		                	url:"http://m.wowh5.cn/h5tag/batchSave.json",//正式
		                	type:"post",
		       				 data:tagform,
		       				 dataType:"json",
		       				 processData:false,
		       				 contentType:false,
		       				 success:function(data){
		       					alert(data.MESSAGE);
		       				 }
		                });
				 }
			 }); 
	    })
	    
	    $('#h5Form').bootstrapValidator({
	    	message: 'This value is not valid',
	        feedbackIcons: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	            title: {
	                group: '.col-sm-5',
	                validators: {
	                    notEmpty: {
	                        message: 'h5标题不能为空'
	                    },
	                    stringLength: {
	                        min: 6,
	                        max: 20,
	                        message: 'h5标题长度为6~20'
	                    }
	                }
	            },
	            h5Url: {
	                group: '.col-sm-5',
	                validators: {
	                    notEmpty: {
	                        message: 'h5链接地址不能为空'
	                    }
	                }
	            },
	            company: {
	                group: '.col-sm-5',
	                validators: {
	                    notEmpty: {
	                        message: '出品公司不能为空'
	                    }
	                }
	            },
	            product: {
	                group: '.col-sm-5',
	                validators: {
	                    notEmpty: {
	                        message: '出品产品不能为空'
	                    }
	                }
	            },
	            datetimepicker: {
	                group: '.col-sm-5',
	                validators: {
	                    notEmpty: {
	                        message: '出品时间不能为空'
	                    }
	                }
	            },
	            url: {
	                group: '.col-sm-5',
	                validators: {
	                    notEmpty: {
	                        message: '缩略图链接不能为空'
	                    }
	                }
	            },
	            embeddedIframe: {
	                group: '.col-sm-5',
	                validators: {
	                    notEmpty: {
	                        message: '是否嵌入不能为空'
	                    }
	                }
	            },
	        }
	    });
	    
	})
	</script>
</body>

</html>
