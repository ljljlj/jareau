<!-- BootStrap from utils -->

<#macro input_row name="name" label="label" value="" placeholder="">
<div class="form-group">
    <label for="${name}" class="col-sm-2 control-label">${label}</label>
    <div class="col-sm-4">
        <input name="${name}" class="form-control" id="${name}" value="${value}" placeholder="${placeholder}">
    </div>
</div>
</#macro>