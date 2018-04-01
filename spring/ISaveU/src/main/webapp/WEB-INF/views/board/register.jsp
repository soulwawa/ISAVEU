<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String root = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>REGISTER BOARD</title>
<link href="<%=root%>/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css" />
</head>
<div class="wrapper">
	<div class="header">
		<div class="case">
			<img src="<%=root%>/img/logo1.png" alt="logo" class="logo" />
		</div>
	</div>
	<div class="sidebar">
		<div class="menuBtn" onclick="sensorlog.go">sensor log</div>
		<div class="menuBtn" onclick="eventlog.go">event log</div>
		<div class="menuBtn" onclick="streaming.go">streaming</div>
		<div class="menuBtn" onclick="hrtable.go">HR table</div>
		<div class="menuBtn" onclick="location.go">location info</div>
	</div>
	<!-- Main content -->
	<section class="contents">
		<div class="row">
			<!-- left column -->
			<div class="col-md-12">
				<!-- general form elements -->
				<div class="box box-primary">
					<div class="box-header">
						<h3 class="box-title">REGISTER BOARD</h3>
					</div>
					<!-- /.box-header -->

					<form role="form" method="post">
						<div class="box-body">
							<div class="form-group">
								<label for="exampleInputEmail1">Title</label> <input type="text"
									name='title' class="form-control" placeholder="Enter Title">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Content</label>
								<textarea class="form-control" name="content" rows="3"
									placeholder="Enter ..."></textarea>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Writer</label> <input
									type="text" name="writer" class="form-control"
									placeholder="Enter Writer">
							</div>
						</div>
						<!-- /.box-body -->

						<div class="box-footer">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</form>
				</div>
				<!-- /.box -->
			</div>
			<!--/.col (left) -->

		</div>
		<!-- /.row -->
	</section>
	<!-- /.content -->
	<div class="footer">
		<div style="padding: 7px;">Copyright © 2018 HSB Inc.</div>
		<div>
			<div id="result1"></div>
			<div id="result2"></div>
			<div id="result3"></div>
			<div id="result4"></div>
		</div>
	</div>
</div>
</body>
</html>



