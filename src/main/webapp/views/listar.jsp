<%@ page import="ModelDAO.ProductDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="Model.Product" %>
<%@ page import="java.util.Iterator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Productos</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1>Listado de productos</h1>
    <a href="Controlador?accion=add">Agregar otro producto</a>
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Codigo</th>
            <th scope="col">Nombre</th>
            <th scope="col">Precio</th>
            <th scope="col">Stock</th>
            <th scope="col">Acciones</th>
        </tr>
        </thead>
        <%
            ProductDAO dao = new ProductDAO();
            List<Product>list = dao.listar();
            Iterator<Product>iter = list.iterator();
            Product prod = null;
            while (iter.hasNext()){
                prod = iter.next();

        %>
        <tbody>
        <tr>
            <td><%= prod.getCode()%></td>
            <td><%= prod.getName()%></td>
            <td><%= prod.getPrice()%></td>
            <td><%= prod.getStock()%></td>
            <td>
                <a href="Controlador?accion=editar&code=<%= prod.getCode()%>" class="btn btn-info">Editar</a>
                <a href="Controlador?accion=eliminar&code=<%= prod.getCode()%>" class="btn btn-danger">Eliminar</a>
            </td>
        </tr>
        <% }%>
        </tbody>
    </table>
</diav>
</body>
</html>
