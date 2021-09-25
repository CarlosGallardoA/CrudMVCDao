<%@ page import="ModelDAO.ProductDAO" %>
<%@ page import="Model.Product" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Editar</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<%
    ProductDAO dao = new ProductDAO();
    int cod = (int) request.getAttribute("codeprod");
    Product prod = dao.list(cod);
%>
<div class="container">
    <h1>Modificar Producto</h1>
    <form action="Controlador">
        <div class="form-group">
            <label for="code">Código</label>
            <input type="hidden" class="form-control" id="code" name="code" value="<%=prod.getCode()%>">
        </div>
        <div class="form-group">
            <label for="name">Nombre</label>
            <input type="text" class="form-control" id="name" name="name" value="<%=prod.getName()%>">
        </div>
        <div class="form-group">
            <label for="price">Precio</label>
            <input type="number" class="form-control" id="price" name="price" step="0.01" value="<%=prod.getPrice()%>">
        </div>
        <div class="form-group">
            <label for="stock">Stock</label>
            <input type="number" class="form-control" id="stock" name="stock" value="<%=prod.getStock()%>">
        </div>
        <input class="btn btn-success" type="submit" name="accion" value="Actualizar">
    </form>
</div>

</body>
</html>
