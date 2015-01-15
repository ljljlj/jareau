<@default.layout "Home page">
<h2>
  <#if message != '250'>
    Message: ${message}
  <#else>
    Message: You fool
  </#if>
</h2>

<button type="button" class="btn btn-success">Success</button>
<a class="btn btn-default" href="#" role="button">Link</a>

</@default.layout>
