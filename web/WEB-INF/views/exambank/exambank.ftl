<@default.layout "Exam Bank">

<h3>Name: ${examBank.name}</h3>
<h3>Description: ${examBank.description}</h3>

<table class="table" xmlns="http://www.w3.org/1999/html">
    <thead>
    <tr>
        <th>ID</th>
        <th>Statement</th>
        <th/>
    </tr>
    </thead>
    <tbody>
        <#list examBank.questionList as question>
        <tr>
            <td>#{question.questionId}</td>
            <td><a href="/question/#{question.questionId}"> ${question.statement} </a></td>
            <td>
                <a type="button" class="btn btn-default btn-xs" href="/question/#{question.questionId}/edit" role="button">Edit</a>
                <a type="button" class="btn btn-default btn-xs" href="#{examBank.examBankId}/question/#{question.questionId}/remove" role="button">Remove</a>
            </td>
        </tr>
        </#list>
    </tbody>
</table>

<a role="button" class="btn btn-primary" href="${examBank.examBankId}/question/new">New Question</a>

</@default.layout>
