<#import "/bs_utils/bs_form.ftl" as bs_form>

<@default.layout "培训项目">

<h3>培训项目编号: #{program.programId}</h3>
<h3>培训项目名称: ${program.programName}</h3>

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
        <#list selectedCourses as course >
        <tr>
            <td>#{course.courseId}</td>
            <td><a href="course/#{course.courseId}"> ${course.courseName} </a></td>
            <td>${course.category}</td>
            <td>${course.teacher}</td>
            <td>#{course.fee}</td>
            <td>
                <a type="button" class="btn btn-default btn-xs" href="/program/#{program.programId}/#{course.courseId}/remove" role="button">删除</a>
            </td>
        </tr>
        </#list>
    </tbody>
</table>

<form class="form-inline" role="form" action="/program/#{program.programId}/add_course" method="post">
    <label>添加课程</label>
    <@bs_form.bs_select "courseId" availableCourses 0 "courseId" "courseName" />
    <button type="submit" class="btn btn-default">添加</button>
</form>

</@default.layout>
