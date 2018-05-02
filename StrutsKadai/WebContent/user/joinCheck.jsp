<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Struts Kadai JoinCheck</title>
<link rel="stylesheet" href="/StrutsKadai/css/jquery-ui.css">
<script src="/StrutsKadai/js/jquery-3.3.1.js"></script>
<script src="/StrutsKadai/js/jquery-ui.js"></script>
<script type="text/javascript">
	$(function(){
		
		$("#dialog").dialog({
			autoOpen : false
		});
		
		$("#btnRt").on('click',function(){
			history.back();
		});
		
		$("#btnSubmit").on('click', function(){
			$("#dialog").dialog("open");
		});
		
		$("#btnY").on('click', function(){
			$("#frm").submit();
		});
		
		$("#btnN").on('click', function(){
			$("#dialog").dialog("close");
		});
	});
</script>
</head>
<body>
	<div id="dialog" title="Basic dialog">
		<p>今の情報で登録してもよろしいでしょうか?</p>
		<button id="btnY">はい</button>
		<button id="btnN">いいえ</button>
	</div>

	<h1>【入力確認します】</h1>

	<br>

	<form action="/StrutsKadai/join.do" id="frm" method="post">
	
		<table border="1">
			<tr>
				<th>項目</th>
				<th>入力内容</th>
			</tr>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" value="${requestScope.id }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>パスワード</th>
				<td><input type="text" name="pass" value="${pass }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>名前</th>
				<td><input type="text" name="name" value="${name }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>カナ</th>
				<td><input type="text" name="kana" value="${kana }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>生年月日</th>
				<td><input type="text" name="birth" value="${birth }" readonly="readonly"></td>
			</tr>
			<tr>
				<th>委員会</th>
				<td><input type="text" name="club" value="${club }" readonly="readonly"></td>
			</tr>
		</table>

	</form>
	
	<button id="btnSubmit">登録します</button>
	<button id="btnRt">戻る</button>

</body>
</html>