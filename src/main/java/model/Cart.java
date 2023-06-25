package model;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import model.Producto;
import java.util.List;
import java.util.UUID;
import java.util.ArrayList;

public class Cart {
    private UUID id;
    private Usuario user;
    private int cantidad;
    private double precioUnitario;
    private double precioTotal;
    private List<Producto> productos = new ArrayList<>();
    public Cart(Usuario userId) {
        this.user = userId;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Usuario getUserId() {
        return user;
    }
    public void setUserId(Usuario userId) {
        this.user = userId;
    }
    public List<Producto> getProductId() {
        return productos;
    }
    public void setProductId(Producto productId) {
        this.productos = List.of(productId);
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        calcularPrecioTotal();
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
        calcularPrecioTotal();
    }
    public double getPrecioTotal() {
        return precioTotal;
    }
    private void calcularPrecioTotal() {
        this.precioTotal = cantidad * precioUnitario;
    }
    public void confirmarCarrito() {
        Pedido pedido = new Pedido(userId);
        List<Producto> productos = listarProductos();
        for (Producto producto : productos) {
            pedido.agregarProducto(producto);
        }
        pedido.guardar();
        System.out.println("Carrito confirmado. Pedido creado con ID: " + pedido.getId());
    }
    public void guardar(Producto producto, int cantidad) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("cart");
        Document document = new Document("userId", user)
                .append("productId", producto.getId())
                .append("cantidad", cantidad)
                .append("precioUnitario", producto.getPrecio())
                .append("precioTotal", producto.getPrecio() * cantidad);
        collection.insertOne(document);
        this.id = UUID.fromString(document.getObjectId("_id").toString());
        mongoClient.close();
    }
    public static Cart obtenerPorId(UUID id) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("cart");
        Document document = collection.find(Filters.eq("_id", id)).first();
        if (document != null) {
            Cart cart = new Cart(
                    (Usuario) document.get("userId")
            );
            cart.setId(UUID.fromString(document.getObjectId("_id").toString()));
            mongoClient.close();
            return cart;
        }
        mongoClient.close();
        return null;
    }
    public void actualizar() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("cart");
        Document document = new Document("userId", user)
                .append("productId", productos)
                .append("cantidad", cantidad)
                .append("precioUnitario", precioUnitario)
                .append("precioTotal", precioTotal);
        collection.updateOne(Filters.eq("_id", id), new Document("$set", document));
        mongoClient.close();
    }
    public void eliminar() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("cart");
        collection.deleteOne(Filters.eq("_id", id));
        mongoClient.close();
    }
    public List<Producto> listarProductos() {
        List<Producto> productos = new ArrayList<>();
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("cart");

        // Busca el carrito por su ObjectId
        Document document = collection.find(Filters.eq("_id", id)).first();

        if (document != null) {
            List<UUID> productIds = (List<UUID>) document.get("productId");

            for (UUID productId : productIds) {
                Producto producto = Producto.obtenerPorId(productId);
                if (producto != null) {
                    productos.add(producto);
                }
            }
        }
        mongoClient.close();
        return productos;
    }

    public void cancelarCarrito() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("cart");
        // Elimina el carrito de la colección
        collection.deleteOne(Filters.eq("_id", id));
        mongoClient.close();
    }
}