<nav class="mui-bar mui-bar-tab">
  <a class="mui-tab-item <#if (menuAct!'home') == 'home'>mui-active</#if>" onclick="location.href='/'"
     href="javascript:void(0)">
    <span class="mui-icon mui-icon-home"></span>
    <span class="mui-tab-label">首页</span>
  </a>
  <a class="mui-tab-item <#if (menuAct!'') == 'order'>mui-active</#if>" onclick="location.href='/order/myOrder'"
     href="javascript:void(0)">
    <span class="mui-icon-extra mui-icon-extra-cart"></span>
    <span class="mui-tab-label">借还</span>
  </a>
  <a class="mui-tab-item <#if (menuAct!'') == 'user'>mui-active</#if>" onclick="location.href='/user/index'"
     href="javascript:void(0)">
    <span class="mui-icon mui-icon-contact"></span>
    <span class="mui-tab-label">个人中心</span>
  </a>
</nav>