<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../include/header.jsp"%>

<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">MODIFY BOARD</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" method="post">
					<div class = "box-body">
						<div class = "form-group">
							<label for = "exampleInputEamil1">BNO</label>
							<input type ="text" name = "bno" class = "form-control" value="${boardVO.bno}" readonly = "readonly">
						</div>
						<div class = "form-group">
							<label for = "exampleInputEamil1">TITLE</label>
							<input type ="text" name = "title" class = "form-control" value="${boardVO.title}">
						</div>
						<div class = "form-group">
							<label for = "exampleInputPassword1">CONTENT</label>
							<textarea name = "content" class = "form-control" rows="3">${boardVO.content}</textarea>
						</div>
						<div class = "form-group">
							<label for = "exampleInputEamil1">WRITER</label>
							<input type ="text" name = "writer" class = "form-control" value="${boardVO.writer}">
						</div>
					 </div>
					<!-- /.box-body -->
					</form>
					<div class = "box-footer">
						<button type="submit" class="btn btn-primary">SAVE</button>
						<button type="submit" class="btn btn-warning">CANCLE</button>
					</div>
					<script>
					$(document).ready(function(){
						var formObj = $("form[role='form']");
						console.log(formObj);
						
						$(".btn-warning").on("click", function(){
							self.location = "/board/listAll"
						});
						
						$(".btn-primary").on("click", function(){
							formObj.submit();
						});
					});
					
					</script>
				</div>
				</div>
				</div>
				</section>
					
<%@include file="../include/footer.jsp"%>