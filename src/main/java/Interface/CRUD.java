package Interface;

import Model.Product;

import java.util.List;

public interface CRUD {
    public List listar();
    public Product list(int code);
    public boolean add(Product prod);
    public boolean edit(Product prod);
    public boolean delete(int code);
}
