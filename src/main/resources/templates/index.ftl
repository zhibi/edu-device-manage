<!DOCTYPE html>
<html lang="en">
<#include "common/head.ftl"/>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "common/foot-menu.ftl"/>
<#include "common/header.ftl"/>
<div class="mui-content">
  <div class="mui-input-row mui-search">
    <form>
      <input type="search" class="mui-input-clear" placeholder="" name="keywords">
    </form>

  </div>

  <#list businessList as item>
    <div class="mui-card">
      <div class="mui-card-header">${item.name}</div>
      <div class="mui-card-content">
        <img src="${item.icon}" width="100%">
      </div>
      <div class="mui-card-footer">
        <a class="mui-card-link" href="/order/send/${item.id!}">预定 ${item.orderNum} </a>
        <a class="mui-card-link" href="/comment/${item.id!}">评论 ${item.commendNum} </a>
        <a class="mui-card-link" href="/business/detail/${item.id}">详情</a>
      </div>
    </div>
  </#list>

</div>
</body>
</html>