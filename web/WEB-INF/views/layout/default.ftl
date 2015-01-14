<#macro layout title="Edu Project">
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>${title}</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
    <link rel="stylesheet" href="/static/css/bootstrap-theme.min.css">
</head>
<body>
<div class="container">
    <h1>${title}</h1>
    <#nested/>
</div>
</body>
</html>
</#macro>
