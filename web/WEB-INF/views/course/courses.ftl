<@default.layout "All Courses">

<a role="button" class="btn btn-primary" href="/course/new">新建课程</a>
<a role="button" class="btn btn-primary" href="/course/category">课程分类管理</a>

<table class="table" xmlns="http://www.w3.org/1999/html">
    <thead>
        <tr>
            <th>编号</th>
            <th>课程名称</th>
            <th>类别</th>
            <th>讲师</th>
            <th>费用</th>
            <th>删除课程</th>
        </tr>
    </thead>
    <tbody>
        <#list courses as course>
        <tr>
            <td>#{course.courseId}</td>
            <td><a href="course/#{course.courseId}"> ${course.courseName} </a></td>
            <td>${course.category}</td>
            <td>${course.teacher}</td>
            <td>#{course.fee}</td>
            <td>
                <a type="button" class="btn btn-default btn-xs" href="/course/#{course.courseId}/edit" role="button">修改</a>
                <a type="button" class="btn btn-default btn-xs" href="/course/#{course.courseId}/del" role="button">删除</a>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
</@default.layout>
