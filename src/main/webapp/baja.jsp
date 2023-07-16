<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Baja de Usuario</title>
</head>
<body>
    <h1>Baja de Usuario</h1>
    <form action="DeleteController" method="GET">
        <label for="id">ID del Usuario:</label>
        <input type="text" id="id" name="id" required><br>
        <input type="submit" value="Dar de Baja">
    </form>
</body>
</html>