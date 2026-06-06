<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<div class="card">

    <h1>📚 課程分類查詢結果</h1>

    <table>
        <tr>
            <th>課程分類編號</th>
            <th>課程分類名稱</th>
        </tr>

        <tr>
            <td>${courseCategoriesVO.courseCatId}</td>
            <td>${courseCategoriesVO.courseCatName}</td>
        </tr>
    </table>

    <a href="coursecategories.jsp" class="btn">
        返回首頁
    </a>

</div>