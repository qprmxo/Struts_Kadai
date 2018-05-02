<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts Kadai Update</title>
<script src="/StrutsKadai/js/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#btnRt").on('click', function(){
			history.back();
		});
		
		$("#btnSubmit").on('click', function(){
			if ($("#name").val() == null || $("#name").val() == "") {
				alert("名前を入力してください。");
				return false;
			}
			if (!$("#name").val().match(/[^A-Za-z0-9]+/) && $("#name").val() != "") {
				alert("名前は全角で入力してください。");
				return false;
			}
			
			if ($("#kana").val() == null || $("#kana").val() == "") {
				alert("カナを入力してください。");
				return false;
			}
			if ($("#kana").val().match(/[^A-Za-z0-9]+/)) {
				alert("カナは半角で入力してください。");
				return false;
			}
			
			if ($("#birth").val() == null || $("#birth").val() == "") {
				alert("生年月日を選択してください。");
				return false;
			}
			
			if ($("#club").val() == null || $("#club").val() == "") {
				alert("委員会を入力してください。");
				return false;
			}
			if (!$("#club").val().match(/[^A-Za-z0-9]+/) && $("#club").val() != "") {
				alert("委員会は全角で入力してください。");
				return false;
			}
			
			$("#cmd").val("updateCheck");
			frm.submit();
		});
	});
</script>
</head>
<body>
<h1>【データ変更入力】</h1>

<form action="update.do" id="frm" method="post">
	<table border="1">
		<tr>
			<th>ユーザID</th><td><input type="text" name="id" id="id" value="${user.id }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>名前</th><td><input type="text" name="name" id="name" value="${user.name }"></td>
		</tr>
		<tr>
			<th>カナ</th><td><input type="text" name="kana" id="kana" value="${user.kana }"></td>
		</tr>
		<tr>
			<th>生年月日</th><td><input type="date" name="birth" id="birth" value="${user.birth }"></td>
		</tr>
		<tr>
			<th>委員会</th><td><input type="text" name="club" id="club" value="${user.club }"></td>
		</tr>
	</table>
	
	<input type="hidden" id="cmd" name="cmd">
	
</form>

<button type="button" id="btnSubmit">確認</button>
<button type="button" id="btnRt">戻る</button>

</body>
</html>