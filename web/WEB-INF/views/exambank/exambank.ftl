<@default.layout "Exam Bank">

<h2>Name: ${examBank.name}</h2>
<h2>Description: ${examBank.description}</h2>
<#list examBank.questionList as question>
<h3><a href="/question/#{question.questionId}"> ${question.statement} </a></h3>
</#list>

<input type="button" value="Create Question" onclick="location.href='${examBank.examBankId}/question/new.html'"

</@default.layout>
