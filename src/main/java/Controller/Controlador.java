package Controller;

import Model.Product;
import ModelDAO.ProductDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Controlador", value = "/Controlador")
public class Controlador extends HttpServlet {
    String listar = "views/listar.jsp";
    String add = "views/add.jsp";
    String edit = "views/edit.jsp";
    Product prod = new Product();
    ProductDAO dao = new ProductDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");
        if (action.equalsIgnoreCase("listar")){
            acceso = listar;
        }else if (action.equalsIgnoreCase("add")){
            acceso = add;
        }else if (action.equalsIgnoreCase("Agregar")){
            int code = Integer.parseInt(request.getParameter("code"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            prod.setCode(code);
            prod.setName(name);
            prod.setPrice(price);
            prod.setStock(stock);
            dao.add(prod);
            acceso = listar;
        }else if (action.equalsIgnoreCase("editar")){
            request.setAttribute("codeprod",Integer.parseInt(request.getParameter("code")));
            acceso = edit;
        }else if (action.equalsIgnoreCase("Actualizar")){
            int code = Integer.parseInt(request.getParameter("code"));
            String name = request.getParameter("name");
            double price = Double.parseDouble(request.getParameter("price"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            prod.setCode(code);
            prod.setName(name);
            prod.setPrice(price);
            prod.setStock(stock);
            dao.edit(prod);
            acceso = listar;
        }else if (action.equalsIgnoreCase("eliminar")){
            int code = Integer.parseInt(request.getParameter("code"));
            prod.setCode(code);
            dao.delete(code);
            acceso = listar;
        }
        RequestDispatcher view = request.getRequestDispatcher(acceso);
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
