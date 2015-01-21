<!-- BootStrap from utils -->

<#macro form_row name="name" label="label">
    <div class="form-group">
        <label for="${name}" class="col-sm-2 control-label">${label}</label>
        <div class="col-sm-4">
            <#nested/>
        </div>
    </div>
</#macro>

<#macro input_row name="name" label="label" value="" placeholder="">
    <@form_row name label>
    <input name="${name}" class="form-control" id="${name}" value="${value}" placeholder="${placeholder}">
    </@form_row>
</#macro>

<#macro bs_select id data value="" valueAttrName="" textAttrName="">
    <select class="form-control" name="${id}" id="${id}" value="${value}">
        <#list data as option>
            <#if option[valueAttrName] == value>
                <option value="${option[valueAttrName]}" selected>${option[textAttrName]}</option>
            <#else>
                <option value="${option[valueAttrName]}">${option[textAttrName]}</option>
            </#if>
        </#list>
    </select>
</#macro>
