<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DAHUA
  Date: 2020/3/4
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示</title>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
    <div class="col-md-12 column">
        <div class="page-header">
            <h1>书籍列表---显示所有书籍</h1>
        </div>
    </div>
</div>
</div>
<%--跳转交给controller处理--%>
                <div class="row">
                        <div class="col-md-4 column">
                              <a class="btn btn-primary" href="${pageContext.request.contextPath}/book/toAddBook">新增书籍</a>
                        </div>


<%--查询书籍--%><div class="col-md-4 column">
                           <form action="${pageContext.request.contextPath}/book/queryBook" method="post" style="float: right">
                               <input type="text" name="queryBookName" class="form-control" placeholder="请输入查询书籍名称">
                               <input type="submit" value="查询" class="btn btn-primary">
                           </form>
                </div>
                </div>


    <div class="row clearfix">
        <div class="col-md-10 column">
            <table class="table table-hover table-striped">
                <thead>
                <tr>

                    <th>编号</th>
                    <th>名称</th>
                    <th>数量</th>
                    <th>详情</th>
                </tr>

                </thead>
<%--                书籍在数据库中查询--%>
                <tbody>
                <c:forEach var="book" items="${list}">
                    <tr>

                        <td>${book.bookID}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookCounts}</td>
                        <td>${book.detail}</td>
                        <td>
                            <span style="color: red;font-weight:bold">${error}</span>
                            <a href="${pageContext.request.contextPath}/book/toUpdate/${book.bookID}">修改</a>
                            &nbsp;&nbsp;| &nbsp;
                            <a href="${pageContext.request.contextPath}/book/deleteBook/${book.bookID}">删除</a>
                        </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>



</body>
</html>
