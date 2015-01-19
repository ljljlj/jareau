<#import "/bs_utils/bs_form.ftl" as bs_form>

<@default.layout "新建课程">
<div id="content">
    <fieldset>
        <form class="form-horizontal" role="form" name="course" action="update" method="post">
            <input class="hidden" name="courseId" value="#{course.courseId}">
            <@bs_form.input_row "courseName" "课程名称" "${course.courseName}" />
            <@bs_form.input_row "category" "类别" "${course.category}" "例如:高级" />
            <@bs_form.input_row "teacher" "讲师" "${course.teacher}" />
            <@bs_form.input_row "fee" "费用" "#{course.fee}" />
            <@bs_form.input_row "description" "简介" "${course.description}" />
            <div class="form-group">
                <label class="col-sm-2 control-label"> </label>
                <div class="col-sm-4">
                    <input role="button" class="btn btn-primary" value="保存" type="submit">
                </div>
            </div>
        </form>
    </fieldset>
</div>

</@default.layout>
