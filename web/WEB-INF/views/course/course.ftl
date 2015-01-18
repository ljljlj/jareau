<@default.layout "课程详情页面">

    <h3>课程编号: #{course.courseId}</h3>
    <h3>课程名称: ${course.courseName}</h3>
    <h3>类别: ${course.category}</h3>
    <h3>讲师: ${course.teacher}</h3>
    <h3>费用: ${course.fee}</h3>
    <h3>简介: ${course.description}</h3>

    <a type="button" class="btn btn-default" href="/course" role="button">返回首页</a>
    <a type="button" class="btn btn-default" href="#{course.courseId}/edit" role="button">修改</a>
    <a type="button" class="btn btn-default" href="#{course.courseId}/del" role="button">删除</a>

</@default.layout>
