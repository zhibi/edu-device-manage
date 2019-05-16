<!DOCTYPE html>
<html lang="en">
<#include "../common/head.ftl"/>
<#assign menuAct="order"/>
<#assign navTitle= '我的借用'/>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "../common/foot-menu.ftl"/>
<#include "../common/header.ftl"/>

<div class="mui-content">
  <#list orderList as item>
    <div class="mui-card">
      <div class="mui-card-header mui-card-media">
        <img src="${item.deviceIcon}">
        <div class="mui-media-body">
          ${item.deviceName!}
          <p>借用时间 ${item.createTime?string('yyyy-MM-dd HH:mm:ss')}</p>
        </div>
      </div>
      <div class="mui-card-content">
        <ul class="mui-table-view">
          <li class="mui-table-view-cell">设备拥有人：${item.userName!}</li>
          <li class="mui-table-view-cell">借用状态：${item.status!}</li>
          <#if item.updateTime??>
            <li class="mui-table-view-cell">更新时间：${item.createTime?string("yyyy-MM-dd HH:mm:ss")}</li>
          </#if>
        </ul>
      </div>
      <#if item.status == '借出'>
        <div class="mui-card-footer">
          <a href="/order/remand/${item.id}">归还</a>
        </div>
      </#if>

    </div>
  </#list>

</div>
</body>
<#include "../common/footer.ftl"/>
</html>