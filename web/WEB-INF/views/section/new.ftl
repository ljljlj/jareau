<#import "/bs_utils/bs_form.ftl" as bs_form>

<@default.layout "添加新课时">
<div class="col-md-8">
    <fieldset>
        <form class="form-horizontal" role="form" name="section" action="create" method="post">
            <h3>在 《${course.courseName}》中添加新课程</h3>
            <input type="hidden" name="courseId" value="${section.courseId?c}"/>
            <@spring.bind "section.*"/>
            <#list spring.status.errorMessages as error>
                <div class="alert alert-danger" role="alert">${error}</div>
            </#list>
            <@bs_form.form_row "name" "课时名称">
                <@spring.formInput "section.name" 'class="form-control"' />
            </@bs_form.form_row>

            <@bs_form.form_row "description" "简介">
                <@spring.formInput "section.description" 'class="form-control"' />
            </@bs_form.form_row>

            <@bs_form.form_row "videoId" "视频vid">
                <@spring.formInput "section.videoId" 'class="form-control"' />
            </@bs_form.form_row>

            <@bs_form.form_row "sectionOrder" "课时编号">
                <@spring.formInput "section.sectionOrder" 'class="form-control"' />
            </@bs_form.form_row>

            <input role="button" class="btn btn-primary" value="提交" type="submit">
        </form>
    </fieldset>
</div>
</@default.layout>