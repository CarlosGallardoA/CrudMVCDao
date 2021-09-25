# Patron MVC and DAO

## Language
>Java
# Packages
##  Config
###### Connecting to the database
```java
public class Conexion {
    Connection conn;
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","user","pass");
        }catch (ClassNotFoundException e1){
            System.out.println("Error en el driver de conexion");
        }catch (SQLException e2){
            System.out.println("Error en la consulta");
        }
    }
    public Connection getConnection(){
        return conn;
    }
}
```
## Controller
###### we define the logic in a Servlet
## Interface
###### I only declare the methods to use
```java
public interface CRUD {
    public List listar();
    public Product list(int code);
    public boolean add(Product prod);
    public boolean edit(Product prod);
    public boolean delete(int code);
}
```
## Model
###### Define the class to use as a model
```java
public class Product {
    private int code;
    private String name;
    private double price;
    private int stock;
```
## ModelDao
###### I overwrite the methods of the implemented interface and add the connection to the database
## Views
###### Use jsp files