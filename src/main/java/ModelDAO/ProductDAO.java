package ModelDAO;

import Config.Conexion;
import Interface.CRUD;
import Model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements CRUD {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Product pd = new Product();
    @Override
    public List listar() {
        ArrayList<Product>list = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Product prod = new Product();
                //Nombres que estan en la base de datos
                prod.setCode(rs.getInt("codigo"));
                prod.setName(rs.getString("nombre"));
                prod.setPrice(rs.getDouble("precio"));
                prod.setStock(rs.getInt("stock"));
                list.add(prod);
            }
        }catch (SQLException e3){
            System.out.println("Error en la consulta");
        }
        return list;
    }

    @Override
    public Product list(int code) {
        String sql = "SELECT * FROM producto WHERE codigo =" + code;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                //Nombres que estan en la base de datos
                pd.setCode(rs.getInt("codigo"));
                pd.setName(rs.getString("nombre"));
                pd.setPrice(rs.getDouble("precio"));
                pd.setStock(rs.getInt("stock"));
            }
        }catch (SQLException e3){
            System.out.println("Error en la consulta");
        }
        return pd;
    }

    @Override
    public boolean add(Product prod) {
        String sql = "INSERT INTO producto(codigo,nombre,precio,stock) VALUES('"+prod.getCode()+"','"+prod.getName()+"','"+prod.getPrice()+"','"+prod.getStock()+"')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (SQLException e3){
            System.out.println("Error al ejecutar consulta");
        }
        return false;
    }

    @Override
    public boolean edit(Product prod) {
        String sql = "UPDATE producto SET nombre='"+prod.getName()+"',precio='"+prod.getPrice()+"',stock='"+prod.getStock()+"'WHERE codigo="+prod.getCode();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (SQLException e3){
            System.out.println("Error en la consulta sql");
        }
        return false;
    }

    @Override
    public boolean delete(int code) {
        String sql = "DELETE FROM producto WHERE codigo="+code;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        }catch (SQLException e3){
            System.out.println("Error en la consulta sql");
        }
        return false;
    }
}
