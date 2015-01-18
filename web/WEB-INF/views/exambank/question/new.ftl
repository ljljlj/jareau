<@default.layout "Question">

<div id="content">
    <fieldset>
        <legend>Add New Question For Exam Bank ${examBank.name}</legend>
        <form name="question" action="/exambank/${examBank.examBankId}/question/add.html" method="post">
            Statement: <input name="statement" type="text"> <br>
            Question Type: <select name="type">
                <#list questionTypes as type>
                    <option value="${type.rawType}">${type.description}</option>
                </#list>
            </select>
            <br>
            <#assign MAX_OPTION_SIZE = 5>
            <#list 1..MAX_OPTION_SIZE as index>
                Is Answer? <input name="optionMap[${index}].isAnswer" type="checkbox">
                Description <input name="optionMap[${index}].description" type="text">
                <br>
            </#list>

            <input value="Save" type="submit">
        </form>
    </fieldset>
</div>

</@default.layout>
