<@default.layout section.name>
<h2>${section.course.courseName} -- ${section.sectionOrder}: ${section.name}</h2>
<div class="col-md-8">
    <div id="youkuplayer" style="width:600px;height:500px"></div>
    <script type="text/javascript" src="http://player.youku.com/jsapi">
        player = new YKU.Player('youkuplayer',{
            styleid: '0',
            client_id: '663eca908b15e61d',
            vid: '${section.videoId}',
            autoplay: true
        });
    </script>
    <p>description: ${section.description}</p>
</div>
<div class="col-md-4">
    <ul class="list-group">
        <h3>Classes</h3>
        <#list section.course.sections as s>
            <li class="list-group-item"><a href="/section/${s.id}" title="${s.name}">${s.sectionOrder}</a></li>
        </#list>
    </ul>
    <a class="btn btn-default" href="/section/${section.id}/finish">Finish</a>
</div>
</@default.layout>
