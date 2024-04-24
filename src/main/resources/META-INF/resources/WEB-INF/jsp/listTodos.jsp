<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
    <div>Hello ${name}! Welcome to MyTodosApp!</div>
    <hr>
    <h1>Your Todos</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Target Date</th>
            <th>Is Done?</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${todos}" var="todo">
            <tr>
                <td>${todo.id}</td>
                <td>${todo.name}</td>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.status}</td>
                <td><a href="update-todo?id=${todo.id}" class="btn btn-light">Update</a></td>
                <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-outline-success">Add Todo</a>
</div>
<%@ include file="common/footer.jspf" %>