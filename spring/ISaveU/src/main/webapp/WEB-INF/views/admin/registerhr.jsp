<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="/css/style2.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" />
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
#lg1{
	padding-top:10px;
}
legend{
	margin-left:20px;
}
label{
	width: 10.66666667% !important;
}
#file_up{
	width:544px !important;
	height:34px !important;
}
#up_text{
	position:relative !important;
	bottom:2px;
}
#subtn{
	position:relative !important;
	left:471px;
}
</style>
<title>HR Registry</title>

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
						<img src="/img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex1">
						<img src="/img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex2">
						<img src="/img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex3">
						<img src="/img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex4">
						<img src="/img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex5">
						<img src="/img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex6">
						<img src="/img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex7">
						<img src="/img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex8">
						<img src="/img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex9">
						<img src="/img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
					<div class="shake-freeze" id="ex10">
						<img src="/img/extinguisher.png" alt="extinguisher"
							class="imgEtg" name="etgs1" />
					</div>
				</div>
			</div>
		</div>
		<div class="header">
			<div class="case" onclick="goReplace('/admin')">
				<img src="/img/logo1.png" alt="logo" class="logo" />
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
			<form class="form-horizontal" action=" " method="post" id="reg_form">
				<fieldset>

					<!-- Form Name -->
					<legend id="lg1"> Personal Information </legend>

					<!-- Text input-->

					<div class="form-group">
						<label class="col-md-2 control-label">I D</label>
						<div class="col-md-4  inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="first_name"
									placeholder="ID" class="form-control" type="text">
							</div>
						</div>
					</div>
					<div class="form-group has-feedback">
						<label for="password" class="col-md-2 control-label">
							Password </label>
						<div class="col-md-4  inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-home"></i></span> <input
									class="form-control" id="userPw" type="password"
									placeholder="password" name="password" data-minLength="5"
									data-error="some error" required /> <span
									class="glyphicon form-control-feedback"></span> <span
									class="help-block with-errors"></span>
							</div>
						</div>
					</div>

					<div class="form-group has-feedback">
						<label for="confirmPassword" class="col-md-2 control-label">
							Confirm Password </label>
						<div class="col-md-4  inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-home"></i></span> <input
									class="form-control {$borderColor}" id="userPw2"
									type="password" placeholder="Confirm password"
									name="confirmPassword" data-match="#confirmPassword"
									data-minLength="5" data-match-error="some error 2" required />
								<span class="glyphicon form-control-feedback"></span> <span
									class="help-block with-errors"></span>
							</div>
						</div>
					</div>

					<!-- Text input-->

					<div class="form-group">
						<label class="col-md-2 control-label">Name</label>
						<div class="col-md-4  inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-user"></i></span> <input name="last_name"
									placeholder="Name" class="form-control" type="text">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">Department</label>
						<div class="col-md-4 selectContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-list"></i></span> <select name="state"
									class="form-control selectpicker">
									<option value=" ">Please select your department</option>
									<option>601 교수대기실</option>
									<option>602 회계팀</option>
									<option>603 인사팀</option>
									<option>604 기획팀</option>
									<option>605 605호</option>
									<option>606 606호</option>
									<option>607 지식경영팀</option>
									<option>608 608호</option>
									<option>609 609호</option>
									<option>610 교육생휴게실</option>
									<option>611 관리사무실</option>
								</select>
							</div>
						</div>
					</div>
					<!-- Text input-->

					<div class="form-group">
						<label class="col-md-2 control-label">Phone #</label>
						<div class="col-md-4  inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-earphone"></i></span> <input name="phone"
									placeholder="(845)555-1212" class="form-control" type="text">
							</div>
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-2 control-label">E-Mail</label>
						<div class="col-md-4  inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-envelope"></i></span> <input name="email"
									placeholder="E-Mail Address" class="form-control" type="text">
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">Sex</label>
						<div class="col-md-4 selectContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-list"></i></span> <select name="sex"
									class="form-control selectpicker">
									<option value=" ">Sex</option>
									<option>male</option>
									<option>female</option>
								</select>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">Date of birth</label>
						<div class="col-md-4  inputGroupContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-earphone"></i></span> <input
									name="birthday" placeholder="20180318" class="form-control"
									type="text">
							</div>
						</div>
					</div>

					<!-- Text input-->

					<div class="form-group">
						<label class="col-md-2 control-label">level</label>
						<div class="col-md-4 selectContainer">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-list"></i></span> <select name="level"
									class="form-control selectpicker">
									<option value=" ">0</option>
									<option>1</option>
									<option>2</option>
								</select>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label">Photo</label> 
						<div class="col-md-4 selectContainer">
							<div class="fileinput fileinput-new" data-provides="fileinput">
								<span class="btn btn-default btn-file" id="file_up">
									<input type="file" id="up_text" />
								</span>
								<span class="fileinput-filename">
								</span>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label class="col-md-2 control-label"></label>
							<button type="submit" class="btn btn-warning" id="subtn">
								Send <span class="glyphicon glyphicon-send"></span>
							</button>
					</div>
				</fieldset>
			</form>
		</div>
		<div class="footer">
			<div style="padding: 7px;">Copyright © 2018 HSB Inc.</div>
		</div>
	</div>
</body>
</html>