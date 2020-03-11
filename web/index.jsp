<%--
  Created by IntelliJ IDEA.
  User: DAHUA
  Date: 2020/3/4
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
    <style>
      a{
        text-decoration: none;
        color: black;
        font-size: 18px;
      }
      h3{
        width:180px;
        height: 30px;
        margin: 100px auto;
        text-align: center;
        line-height: 18px;
        background-color: red;
        border-radius: 5px;
      }

    </style>
  </head>
  <body>
  <h1>展示书籍</h1>
  <h2>
    <a href="${pageContext.request.contextPath}/book/allbook">展示</a>
  </h2>
  <h2>
    <a href="${pageContext.request.contextPath}/book/toAddBook">增加</a>
  </h2>


  </body>
</html>
