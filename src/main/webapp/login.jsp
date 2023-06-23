<!DOCTYPE html>
<html>
<head>
    <title>Iniciar sesi�n</title>
</head>
<body>
    <h1>Iniciar sesi�n</h1>
    <% if (request.getAttribute("error") != null) { %>
        <p style="color: red;"><%= request.getAttribute("error") %></p>
    <% } %>
    <form action="login" method="post">
        <label for="username">Nombre de usuario:</label>
        <input type="text" id="username" name="username" required><br><br>
        <label for="password">Contrase�a:</label>
        <input type="password" id="password" name="password" required><br><br>
        <input type="submit" value="Iniciar sesi�n">
    </form>
</body>
</html>
