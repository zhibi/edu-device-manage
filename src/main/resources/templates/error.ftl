<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width,initial-scale=1">
  <title>错误页</title>
</head>
<body>

<div id="app" class="exception">
  <div class="content">
    <h1>操作提示</h1>
    <div class="desc">${errorMessage!}${tipMesssage!}</div>
    <div class="action">
      <a type="primary" href="${backUrl!}">返回上页</a>
    </div>
  </div>
</div>
</body>
</html>