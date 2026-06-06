<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>新增課程分類</title>

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

input[type=text]{
    width:100%;
    padding:10px;
    margin-top:10px;
}

input[type=submit]{
    margin-top:20px;
    padding:10px 20px;
}
</style>

</head>
<body>

<div class="container">

```
<div class="card">

    <h2>➕ 新增課程分類</h2>

    <form method="post"
          action="<%=request.getContextPath()%>/coursecategories/coursecategories.do">

        課程分類名稱：

        <input type="text"
               name="courseCatName">

        <input type="hidden"
               name="action"
               value="insert">

        <input type="submit"
               value="新增">

    </form>

</div>
```

</div>

</body>
</html>
