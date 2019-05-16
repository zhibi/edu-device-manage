<!DOCTYPE html>
<html lang="en">
<#include "common/head.ftl"/>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "common/foot-menu.ftl"/>
<#include "common/header.ftl"/>
<div class="mui-content">
  <div class="mui-input-row mui-search">
    <form>
      <input type="search" class="mui-input-clear" placeholder="" name="name">
    </form>

  </div>

  <#list deviceList as item>
    <div class="mui-card">
      <div class="mui-card-header">${item.name}</div>
      <div class="mui-card-content">
        <img src="${item.icon}" width="100%" height="200px">
      </div>
      <div class="mui-card-footer">
        <span class="mui-card-link" href="#">${item.userName!}</span>
        <a class="mui-card-link" href="/business/detail/${item.id}">详情</a>
      </div>
    </div>
  </#list>

</div>
</body>
</html>