<!DOCTYPE html>
<html lang="en">
<#include "../common/head.ftl"/>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "../common/foot-menu.ftl"/>
<#include "../common/header.ftl"/>
<div class="mui-content">
  <#list deviceList as item>
    <div class="mui-card">
      <div class="mui-card-header">${item.name!}</div>
      <div class="mui-card-content">
        <img src="${item.icon}" width="100%" height="200px">
      </div>
      <div class="mui-card-footer">
        <a class="mui-card-link" href="/device/detail/${item.id}">详情</a>
        <a class="mui-card-link" onclick="if(confirm('确定删除吗？')){location.href='/device/del/${item.id}'}" href="javascript:void(0)">删除</a>
      </div>
    </div>
  </#list>
</div>
<#include "../common/footer.ftl"/>
</body>
</html>