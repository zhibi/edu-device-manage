<!DOCTYPE html>
<html lang="en">
<#include "../common/head.ftl"/>
<#assign menuAct="user"/>
<#assign navTitle= '个人信息'/>
<body class="mui-android mui-android-6 mui-android-6-0">
<#include "../common/foot-menu.ftl"/>
<#include "../common/header.ftl"/>

<div class="mui-content">
  <ul class="mui-table-view">
    <li class="mui-table-view-cell">
      <a class="mui-navigate-right" href="/user/info">个人信息</a>
    </li>
    <li class="mui-table-view-cell">
      <a class="mui-navigate-right" href="/user/modifyPwd">修改密码</a>
    </li>
  </ul>
  <br/>
  <ul class="mui-table-view">
    <li class="mui-table-view-cell">
      <a class="mui-navigate-right" href="/device/add">添加设备</a>
    </li>
    <li class="mui-table-view-cell">
      <a class="mui-navigate-right" href="/device/list">我的设备</a>
    </li>
  </ul>
  <br/>
  <ul class="mui-table-view">
    <li class="mui-table-view-cell">
      <a class="mui-navigate-right" href="javascript: mui.alert('清除成功', '提示');">清除缓存</a>
    </li>
    <li class="mui-table-view-cell">
      <a class="mui-navigate-right" href="javascript: mui.alert('已经是最新版本', '提示');">检查更新</a>
    </li>
  </ul>
  <a href="/logout" style="padding:8px;margin-top: 16px" type="button" class="mui-btn mui-btn-block mui-btn-primary">退出登录</a>

</div>
</body>
</html>