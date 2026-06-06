<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>課程分類管理系統</title>
</head>

<body>

<div style="width: 800px; margin: 30px auto; font-family: Microsoft JhengHei;">

    <h1 style="color:#2c3e50;">
        📚 課程分類管理系統
    </h1>

    <hr>

    <h2>🔍 資料查詢</h2>

    <form method="post" action="coursecategories.do">
        <label>輸入課程分類編號：</label>
        <input type="text" name="courseCatId">

        <input type="hidden"
               name="action"
               value="getOne_For_Display">${errorMsgs[0] }

        <input type="submit" value="查詢">
    </form>

    <br>

    <a href="coursecategories.do?action=getAll">
        📋 顯示全部課程分類
    </a>

    <hr>

    <h2>⚙️ 課程分類管理</h2>

    <a href="addCourseCategory.jsp">
        ➕ 新增課程分類
    </a>

</div>

</body>
</html>