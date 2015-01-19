<#import "/bs_utils/bs_form.ftl" as bs_form>

<@default.layout "添加新课时">
<div class="col-md-8">
    <fieldset>
        <form class="form-horizontal" role="form" name="section" action="create" method="post">
            <h3>在 《${course.courseName}》中添加新课程</h3>
            <input type="hidden" name="courseId" value="${section.courseId?c}"/>
            <@bs_form.input_row "name" "课时名称" />
            <@bs_form.input_row "description" "简介" />
            <@bs_form.input_row "videoId" "视频vid" />
            <@bs_form.input_row "sectionOrder" "课时编号" />
            <input role="button" class="btn btn-primary" value="提交" type="submit">
        </form>
    </fieldset>
</div>
</@default.layout>