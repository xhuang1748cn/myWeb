<%--
  Created by IntelliJ IDEA.
  User: SRn
  Date: 2016/4/26
  Time: 23:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="us">
<head>
  <meta charset="utf-8">
  <title>springmvc上传文件</title>
  <base href="${pageContext.request.contextPath}/"/>
  <link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h2>springmvc上传文件</h2>
<br/>


<br/>
<div class="alert alert-success" id="formSucc"></div>
<br/>

<form role="form" id="uploadForm" name="uploadForm" enctype="multipart/form-data">
  <div class="form-group">
    <label>项目名称</label>
  </div>
  <div class="form-group">
    <label>
      <input class="form-control" maxlength="30" id="projectName" name="projectName">
    </label>
  </div>
  <div class="form-group">
    <label>File input</label>
    <input type="file" name="file">
  </div>

  <button class="btn"  type="button"  id="doSave" onclick="saveFile();">提交</button>

</form>
<div></div>
</body>
</html>


<script type="text/javascript" src="js/jquery/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/jquery/jquery.form.js"></script>
<script>

  $(function() {
    $("#formSucc").hide();
  });

  function saveFile(){
    var requestUrl = "/saveFile";
    var projectName = $("#projectName").val();
    $("#uploadForm").ajaxSubmit({
      type: 'post',
      url: requestUrl,
      //data: {projectName: projectName}, //应该把这个去掉，要不然，值会有重复，因为form提交时已经做了一次提交了。
      //如果projectName的值为"tt",如果这个地方不去掉，那么提交接收的值变成"tt,tt"了。
      contentType: "application/x-www-form-urlencoded; charset=utf-8",
      success: function(data) {
        if(data.success){
          $(".infoTips").remove();
          $("#formSucc").show();
          $("#formSucc").append("<label class='infoTips'>"+data.message+"</label>");
        }
      }
    });
  }



</script>
