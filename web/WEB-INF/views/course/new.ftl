<#import "/bs_utils/bs_form.ftl" as bs_form>

<@default.layout "新建课程">
<div id="content">
    <fieldset>
        <form class="form-horizontal" role="form" name="course" action="create" method="post">
            <@bs_form.input_row "courseName" "课程名称" />
            <@bs_form.form_row "category" "课程类别">
                <@bs_form.bs_select "category" categories "" "courseCategoryName" "courseCategoryName" />
            </@bs_form.form_row>
            <@bs_form.input_row "teacher" "讲师" />
            <@bs_form.input_row "fee" "费用" />
            <@bs_form.input_row "description" "简介" />
            <@bs_form.form_row "" " ">
                <input role="button" class="btn btn-primary" value="提交" type="submit">
            </@bs_form.form_row>
        </form>
    </fieldset>
</div>

</@default.layout>
