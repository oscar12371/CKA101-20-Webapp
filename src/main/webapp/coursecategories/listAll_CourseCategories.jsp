<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有課程分類</title>

<style>

body{
	background:#f4f6f9;
	font-family:"Microsoft JhengHei";
}

.container{
	width:900px;
	margin:40px auto;
}

.card{
	background:white;
	padding:30px;
	border-radius:10px;
	box-shadow:0 2px 10px rgba(0,0,0,.1);
}

h1{
	color:#2c3e50;
	text-align:center;
}

table{
	width:100%;
	border-collapse:collapse;
	margin-top:20px;
}

th{
	background:#3498db;
	color:white;
	padding:12px;
}

td{
	text-align:center;
	padding:12px;
	border-bottom:1px solid #ddd;
}

.btn{
	display:inline-block;
	margin-top:20px;
	padding:10px 20px;
	background:#3498db;
	color:white;
	text-decoration:none;
	border-radius:5px;
}

.btn:hover{
	background:#2980b9;
}

.deleteBtn{
	background:#e74c3c;
	color:white;
	border:none;
	padding:8px 15px;
	border-radius:5px;
	cursor:pointer;
}

.deleteBtn:hover{
	background:#c0392b;
}

</style>

</head>
<body>

<div class="container">

	<div class="card">

		<h1>📚 所有課程分類</h1>

		<table>

			<tr>
				<th>課程分類編號</th>
				<th>課程分類名稱</th>
				<th>刪除</th>
			</tr>

			<c:forEach var="courseCategoriesVO" items="${list}">

				<tr>

					<td>${courseCategoriesVO.courseCatId}</td>

					<td>${courseCategoriesVO.courseCatName}</td>

					<td>

						<form method="post"
							action="<%=request.getContextPath()%>/coursecategories/coursecategories.do">

							<input type="hidden"
								   name="courseCatId"
								   value="${courseCategoriesVO.courseCatId}">

							<input type="hidden"
								   name="action"
								   value="delete">

							<input type="submit"
								   value="刪除"
								   class="deleteBtn">

						</form>

					</td>

				</tr>

			</c:forEach>

		</table>

		<a href="coursecategories.jsp" class="btn">
			返回首頁
		</a>

	</div>

</div>

</body>
</html>