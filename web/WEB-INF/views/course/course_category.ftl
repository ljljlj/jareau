<@default.layout "课程类别管理">

<table class="table" style="width:200px">
    <tbody>
        <#list courseCategories as cate>
        <tr>
            <td>${cate.courseCategoryName}</td>
            <td class="col-sm-1"><a role="button" class="btn btn-default btn-xs" href="/course/category/${cate.courseCategoryId}/del">X</a></td>
        </tr>
        </#list>
    </tbody>
</table>

<form class="form-inline" role="form" action="category/create" method="post">
    <input name="courseCategoryName" class="form-control" placeholder="请输入课程类别">
    <button type="submit" class="btn btn-default">添加</button>
</form>

</@default.layout>
