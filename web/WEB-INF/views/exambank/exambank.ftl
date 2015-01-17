<@default.layout "Exam Bank">

<h2>Name: ${examBank.name}</h2>
<h2>Description: ${examBank.description}</h2>
<#list examBank.questionList as question>
<h3> ${question.statement}</h3>
</#list>

</@default.layout>
