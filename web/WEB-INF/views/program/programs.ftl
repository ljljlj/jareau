<@default.layout "培训项目管理">

<table class="table" style="width:200px">
    <tbody>
        <#list programs as program>
        <tr>
            <td><a href="/program/${program.programId}">${program.programName}</a></td>
            <td class="col-sm-1"><a role="button" class="btn btn-default btn-xs" href="/program/${program.programId}/del">X</a></td>
        </tr>
        </#list>
    </tbody>
</table>

<form class="form-inline" role="form" action="/program/create" method="post">
    <input name="programName" class="form-control" placeholder="请输入培训项目名称">
    <button type="submit" class="btn btn-default">添加</button>
</form>

</@default.layout>
