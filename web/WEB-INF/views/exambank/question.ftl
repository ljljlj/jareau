<@default.layout "Question">

<h2>Statement: ${question.statement}</h2>
<h2>Options:</h2>
<#list question.options as option>
<h3><#if option.answer>*</#if> ${option.description}</h3>
</#list>

</@default.layout>
