<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <h1>Enter Todo Details</h1>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-2">
            Name:<form:input type="text" path="name" required="required"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="description">Description:</form:label>
            <form:errors path="description" cssClass="text-warning"/>
            <form:input type="text" path="description" required="required"/>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date:</form:label>
            <form:errors path="targetDate" cssClass="text-warning"/>
            <form:input type="text" path="targetDate" required="required"/>
        </fieldset>
        <form:input type="hidden" path="status" required="required"/>
        <input type="submit" class="btn btn-outline-success"/>
    </form:form>
</div>
<%@ include file="common/footer.jspf" %>
<script type="text/javascript">
    $('#targetDate').datepicker({
        format: 'yyyy-mm-dd'
    });
</script>