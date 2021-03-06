<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
<%
	String basePath = request.getScheme() + "://" + 
		request.getServerName() + ":" + request.getServerPort() + 
		request.getContextPath() + "/" ;
%>
<base href="<%=basePath%>"/>
<title>商品管理</title>
<meta name="viewport" content="width=device-width,initial-scale=1">
<script type="text/javascript" src="jquery/jquery.min.js"></script>
<script type="text/javascript" src="js/back/admin/goods/goods_add.js"></script>
<script type="text/javascript" src="js/common/mldn_util.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="bootstrap/css/bootstrap.min.css">
</head>
<%!
	public static final String GOODS_URL_URL = "pages/back/admin/goods/goods_list.jsp" ;
%>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<form action="" method="post" class="form-horizontal" id="goodsForm">
					<fieldset>
						<legend>
							<label>增加商品</label>
						</legend>
						<div class="form-group" id="nameDiv">
							<label class="col-md-2 control-label" for="name">商品名称：</label>
							<div class="col-md-5">
								<input type="text" id="name" name="name" class="form-control" placeholder="请填写商品名称">
							</div>
							<span class="col-md-5" id="nameSpan">*</span>
						</div>
						<div class="form-group" id="priceDiv">
							<label class="col-md-2 control-label" for="price">商品价格：</label>
							<div class="col-md-5">
								<input type="text" id="price" name="price" class="form-control" placeholder="请填写商品单价">
							</div>
							<span class="col-md-5" id="priceSpan">*</span>
						</div>
						<div class="form-group" id="itemDiv">
							<label class="col-md-2 control-label" for="item">商品分类：</label>
							<div class="col-md-5">
								<select id="item" class="form-control"> 
									<option value="">========= 请选择商品所属分类 =========</option>	
									<option value="1">食品</option>	
									<option value="2">电脑</option>
									<option value="3">手机</option>	
								</select>
							</div>
							<span class="col-md-5" id="itemSpan">*</span>
						</div>
						<div class="form-group" id="tagDiv">
							<label class="col-md-2 control-label" for="tag">商品标签：</label>
							<div class="col-md-5">
								<div class="col-md-3">
									<div class="checkbox">
										<label><input type="checkbox" id="tag" name="tag" value="">性价比高</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="checkbox">
										<label><input type="checkbox" id="tag" name="tag" value="">全民爆款</label>
									</div> 
								</div>
								<div class="col-md-3">
									<div class="checkbox">
										<label><input type="checkbox" id="tag" name="tag" value="">非主流</label>
									</div>
								</div>
								<div class="col-md-3">
									<div class="checkbox">
										<label><input type="checkbox" id="tag" name="tag" value="">经典之作</label>
									</div>
								</div>
							</div>
							<span class="col-md-5" id="tagSpan">*</span>
						</div>
						<div class="form-group" id="photoDiv">
							<label class="col-md-2 control-label" for="photo">商品图片：</label>
							<div class="col-md-5">
								<input type="file" id="photo" name="photo" class="form-control" placeholder="请选择商品宣传图">
							</div>
							<span class="col-md-5" id="photoSpan">*</span>
						</div>
						<div class="form-group">
							<div class="col-md-3 col-md-offset-3">
								<input type="submit" value="提交" class="btn btn-primary">
								<input type="reset" value="重置" class="btn btn-warning">
								<a href="<%=GOODS_URL_URL%>" class="btn btn-link">商品列表</a> 
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>