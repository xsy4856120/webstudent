<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>新增</title>
		<link  rel="stylesheet"  href="${basePath}static/css/styles.css" />
		<link rel="stylesheet"  href="${basePath}static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
		<script  src="${basePath}static/js/jquery.min.js" type="text/javascript"></script>
		<script  src="${basePath}static/js/jquery-validation-1.14.0/jquery.validate.js" type="text/javascript"></script>
		<script  src="${basePath}static/js/jquery-validation-1.14.0/localization/messages_zh.js" type="text/javascript"></script>
		<script type="text/javascript">
			$(function(){
				$("#editForm").validate({
					rules:{
						stuNo:{
							required:true,
							digits:true
						},
						stuName:"required",
						stuPwd:{
							required:true,
							rangelength:[6,15]
						}
					}
					/* messages:{
						stuPwd:{
							rangelength:$.validator.format( "Please enter a value between {0} and {1} characters long.")
						}
					} */
				});
			});
		</script>
	</head>
	<body>
		<div class="add">
			<form id="editForm" action="${basePath}student?method=editsubmit" method="post">
				<input type="hidden" name="stuId" value="${student.stuId}">
				<table class="tableadd" style="width: 50%;">
					<tr>
						<td>学号</td>
						<td><input type="text" name="stuNo" value="${student.stuNo}"></td>
					</tr>
					<tr>
						<td>姓名</td>
						<td style="color: red;"><input type="text" name="stuName" value="${student.stuName}"></td>
					</tr>
					<tr>
						<td colspan="4" align="left">
							<button class="edit" type="button" onclick="window.history.back(-1);">
								<i class="fa fa-arrow-left"></i>
								返回
							</button>
							<button class="remove" type="submit">
								<i class="fa fa-save"></i>
								提交
							</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
