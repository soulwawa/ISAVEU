<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	String root = request.getContextPath();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="<%=root%>/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>관리자 페이지</title>
</head>
<body>
	<div class="wrapper">
		<div class="alert" id="art">
			화재 발생
			<div id="fireBtn" onclick="closeAlert()">위치확인</div>
		</div>
		<div class="location" id="lct" onclick="closeLocation()">
			<div id="fire">
				<div id="exts1">
					<div class="shake-freeze" id="ex0">
						<img src="../img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex1">
						<img src="../img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex2">
						<img src="../img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex3">
						<img src="../img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex4">
						<img src="../img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex5">
						<img src="../img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex6">
						<img src="../img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex7">
						<img src="../img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex8">
						<img src="../img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex9">
						<img src="../img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex10">
						<img src="../img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
				</div>
			</div>
		</div>
		<div class="header">
			<div class="case" onclick="goReplace('/admin')">
				<img src="<%=root%>/img/logo1.png" alt="logo" class="logo" />
			</div>
		</div>
		<div class="sidebar">
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/sensor')">
					<span class="glyphicon glyphicon-tasks"></span> Sensor Log
				</button>
			</div>
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/event')">
					<span class="glyphicon glyphicon-alert"></span> Envent Log
				</button>
			</div>
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/stream')">
					<span class="glyphicon glyphicon-play-circle"></span> Striming
				</button>
			</div>
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/hr')">
					<span class="glyphicon glyphicon-user"></span> H.R
				</button>
			</div>
			<div class="menuBtn">
				<button type="button" class="btn btn-default btn-lg btn-block"
					onclick="goReplace('/ex')">
					<span class="glyphicon glyphicon-map-marker"></span> Map
				</button>
			</div>
			<input type="button" value="불내기" onclick="showAlert()" />
		</div>
		<div class="contents">
			<!-- Main content -->
			<section class="contents">
				<div class="row">
					<!-- left column -->
					<div class="col-md-12">
						<!-- general form elements -->
						<div class="box box-primary">
							<div class="box-header">
								<h3 class="box-title">BOARD</h3>
							</div>
							<!-- /.box-header -->

							<form role="form" method="post">
								<div class="box-body">
									<div class="form-group">
										<label for="exampleInputEmail1">Title</label> <input
											type="text" name='title' class="form-control"
											placeholder="Enter Title">
									</div>
									<div class="form-group">
										<label for="exampleInputPassword1">Content</label>
										<textarea class="form-control" name="content" rows="3"
											placeholder="Enter ..."></textarea>
									</div>
									<div class="form-group">
										<label for="exampleInputEmail1">ID</label> <input
											type="text" name="id" class="form-control"
											placeholder="Enter ID">
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

		</div>

		<div class="footer">
			<div style="padding: 7px;">Copyright © 2018 HSB Inc.</div>
		</div>
	</div>
</body>
</html>