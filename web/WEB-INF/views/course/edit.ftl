<#import "/bs_utils/bs_form.ftl" as bs_form>

<@default.layout "修改课程">
<div id="content">
    <fieldset>
        <form class="form-horizontal" role="form" name="course" action="/course/update" method="post">
            <input class="hidden" name="courseId" value="#{course.courseId}">
            <@bs_form.input_row "courseName" "课程名称" "${course.courseName}" />
            <@bs_form.form_row "category" "课程类别">
                <@bs_form.bs_select "category" categories course.category "courseCategoryName" "courseCategoryName" />
            </@bs_form.form_row>
            <@bs_form.input_row "teacher" "讲师" "${course.teacher}" />
            <@bs_form.input_row "fee" "费用" "#{course.fee}" />
            <@bs_form.input_row "description" "简介" "${course.description}" />
            <@bs_form.form_row "" " ">
                <input role="button" class="btn btn-primary" value="保存" type="submit">
            </@bs_form.form_row>
        </form>
    </fieldset>
</div>

<p>${error}</p>

</@default.layout>
