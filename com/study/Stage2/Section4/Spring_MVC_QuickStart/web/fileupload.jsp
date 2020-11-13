<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/12
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--
编写满足文件上传三要素的表单
1、提交方式必须为Post
2、表单的enctype属性必须修改成 multipart/form-data
3、表单中必须要有文件上传项
--%>

<form action="${pageContext.request.contextPath}/fileupload" method="post" enctype="multipart/form-data">
    名称: <input type="text" name="username"> <br>
    文件: <input type="file" name="filePic"> <br>
    <input type="submit" value="单文件上传">
</form>



<form action="${pageContext.request.contextPath}/filesupload" method="post" enctype="multipart/form-data">
    名称: <input type="text" name="username"> <br>
    文件1: <input type="file" name="filePic"> <br>
    文件2: <input type="file" name="filePic"> <br>
    文件3: <input type="file" name="filePic"> <br>
    <input type="submit" value="多文件上传">
</form>


</body>
</html>
