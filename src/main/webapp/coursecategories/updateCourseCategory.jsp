<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>修改課程分類</title>

<style>

body{
    background:#f4f6f9;
    font-family:"Microsoft JhengHei";
}

.container{
    width:600px;
    margin:50px auto;
}

.card{
    background:white;
    padding:30px;
    border-radius:10px;
    box-shadow:0 2px 10px rgba(0,0,0,.1);
}

h1{
    text-align:center;
    color:#2c3e50;
}

.form-group{
    margin-bottom:20px;
}

label{
    display:block;
    margin-bottom:8px;
    font-weight:bold;
}

input[type=text]{
    width:100%;
    padding:10px;
    border:1px solid #ccc;
    border-radius:5px;
    box-sizing:border-box;
}

.readonly{
    background:#eeeeee;
}

.btn{
    padding:10px 20px;
    border:none;
    border-radius:5px;
    cursor:pointer;
    color:white;
}

.updateBtn{
    background:#3498db;
}

.updateBtn:hover{
    background:#2980b9;
}

.backBtn{
    background:#7f8c8d;
    text-decoration:none;
    padding:10px 20px;
    border-radius:5px;
    color:white;
    margin-left:10px;
}

.backBtn:hover{
    background:#616a6b;
}

</style>

</head>
<body>

<div class="container">

```
<div class="card">

    <h1>✏️ 修改課程分類</h1>

    <form method="post"
          action="<%=request.getContextPath()%>/coursecategories/coursecategories.do">

        <div class="form-group">

            <label>課程分類編號</label>

            <input type="text"
                   name="courseCatId"
                   value="${courseCategoriesVO.courseCatId}"
                   readonly
                   class="readonly">

        </div>

        <div class="form-group">

            <label>課程分類名稱</label>

            <input type="text"
                   name="courseCatName"
                   value="${courseCategoriesVO.courseCatName}">

        </div>

        <input type="hidden"
               name="action"
               value="update">

        <input type="submit"
               value="送出修改"
               class="btn updateBtn">

        <a href="<%=request.getContextPath()%>/coursecategories/coursecategories.do?action=getAll"
           class="backBtn">
           返回列表
        </a>

    </form>

</div>
```

</div>

</body>
</html>
