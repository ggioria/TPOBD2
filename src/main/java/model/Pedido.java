package model;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.Date;
import java.util.List;
public class Pedido {
    private ObjectId id;
    private ObjectId userId;
    private List<ObjectId> productos;
    private Date fecha;
    private double total;

    public Pedido(ObjectId userId, List<ObjectId> productos) {
        this.userId = userId;
        this.productos = productos;
        this.fecha = new Date();
        this.total = calcularTotal();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public List<ObjectId> getProductos() {
        return productos;
    }

    public void setProductos(List<ObjectId> productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    private double calcularTotal() {
        // Implementa el cálculo del total según los productos
        // Puedes acceder a los productos a través de los identificadores (ObjectIds)
        // y obtener los precios unitarios de la clase Producto para realizar el cálculo
        // Ejemplo de implementación:
        double total = 0.0;
        for (ObjectId productId : productos) {
            Producto producto = Producto.obtenerPorId(productId);
            if (producto != null) {
                total += producto.getPrecio();
            }
        }
        return total;
    }
    public void guardar() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("pedidos");
        Document document = new Document("userId", userId)
                .append("productos", productos)
                .append("fecha", fecha)
                .append("total", total);
        collection.insertOne(document);
        this.id = document.getObjectId("_id");
        mongoClient.close();
    }
    public static Pedido obtenerPorId(ObjectId id) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("pedidos");
        Document document = collection.find(Filters.eq("_id", id)).first();
        if (document != null) {
            Pedido pedido = new Pedido(
                    document.getObjectId("userId"),
                    (List<ObjectId>) document.get("productos")
            );
            pedido.setId(document.getObjectId("_id"));
            pedido.setFecha(document.getDate("fecha"));
            pedido.setTotal(document.getDouble("total"));
            mongoClient.close();
            return pedido;
        }
        mongoClient.close();
        return null;
    }
    public void actualizar() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("pedidos");
        Document document = new Document("userId", userId)
                .append("productos", productos)
                .append("fecha", fecha)
                .append("total", total);
        collection.updateOne(Filters.eq("_id", id), new Document("$set", document));
        mongoClient.close();
    }
    public void eliminar() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("pedidos");
        collection.deleteOne(Filters.eq("_id", id));
        mongoClient.close();
    }
}