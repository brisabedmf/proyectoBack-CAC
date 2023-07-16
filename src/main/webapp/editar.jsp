<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Usuario</title>
</head>
<body>
    <h1>Editar Usuario</h1>
    <form action="EditarController" method="POST">
        <input type="hidden" name="id" value="<%= usuario.getId() %>">
        <label for="username">Usuario:</label>
        <input type="text" id="username" name="username" value="<%= usuario.getUsername() %>" required><br>
        <label for="password">Contraseña:</label>
        <input type="password" id="password" name="password" value="<%= usuario.getPassword() %>" required><br>
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="<%= usuario.getNombre() %>" required><br>
        <label for="apellido">Apellido:</label>
        <input type="text" id="apellido" name="apellido" value="<%= usuario.getApellido() %>" required><br>
        <input type="submit" value="Guardar Cambios">
    </form>
</body>
</html>