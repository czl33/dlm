<%--
  Created by IntelliJ IDEA.
  User: czl
  Date: 2019/12/31
  Time: 23:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript"
          src="${pageContext.request.contextPath}/static/jquery-3.1.1.min.js"></script>
  <title>yyx博客后台登录</title>
  <script type="text/javascript">
    $(document).ready(function() {
      $("#button_submit").click(function() {
        var name = $("#userName").val();
        var user = {
          lostId:1,
          uId:1,
          conMess : name,
          PublicTime:2012-13-1,
        };//拼装成json格式
        $.ajax({
          type : "POST",
          url : "/insterComment.action",
          data : user,
          success : function(data) {
            alert("成功");
          },
          error : function(e) {
            alert("出错：" + e);
          }
        });
      });
    });
  </script>
</head>
<body>
<form>
  <table>
    <tr>
      <td>用户名:</td>
      <td><input type="text" id="userName"></td>
    </tr>
    <tr>
      <td colspan="2"><input type="button" id="button_submit"
                             value="提交"></td>
    </tr>
  </table>
</form>
</body>
</html>
