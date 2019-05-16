<!DOCTYPE html>
<html lang="en">
<#include "../common/head.ftl"/>
<#assign menuAct="home"/>
<style>

  h5 {
    padding-top: 8px;
    padding-bottom: 8px;
    text-indent: 12px;
  }

  .mui-table-view.mui-grid-view .mui-table-view-cell .mui-media-body {
    font-size: 15px;
    margin-top: 8px;
    color: #333;
  }

</style>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "../common/foot-menu.ftl"/>
<#include "../common/header.ftl"/>

<div class="mui-content">
  <img id="img1" src="${device.icon!}" width="100%" height="200px">
  <ul class="mui-table-view">
    <li class="mui-table-view-cell">
      ${device.name!}
    </li>
    <li class="mui-table-view-cell">
      <span class="mui-icon-extra mui-icon-extra-order"></span> 价钱：${device.price!}</li>
    <li class="mui-table-view-cell">
      <span class="mui-icon-extra mui-icon-extra-regist"></span> 购买时间：${device.payTime!}</li>
    </li>
    <li class="mui-table-view-cell">
      <span class="mui-icon-extra mui-icon-extra-xiaoshuo"></span> 描述：${device.description!}</li>
    </li>
    <li class="mui-table-view-cell">
      <span class="mui-icon-extra mui-icon-extra-filter"></span> 状态：${device.status!}
    </li>
    <li class="mui-table-view-cell">
      <span class="mui-icon-extra mui-icon-extra-outline"></span> 添加时间：${device.createTime?string("yyyy-MM-dd HH:mm:ss")}
    </li>
  </ul>
  <#if device.status == '未借'>
    <div class="mui-card-footer">
      <button type="button" class="mui-btn mui-btn-primary" onclick="location.href='/device/lend/${device.id!}'">借用</button>
    </div>
  </#if>
</div>
</body>

</html>