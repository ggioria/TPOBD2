package model;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import database.MongoDBConnection;
import org.bson.Document;
import org.bson.types.ObjectId;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.util.List;

public class Producto {
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;
    private List<String> imagenes;
    private List<String> videos;
    private List<String> comentarios;

    // Constructor
    public Producto(String nombre, String descripcion, double precio, List<String> imagenes, List<String> videos,
                    List<String> comentarios) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenes = imagenes;
        this.videos = videos;
        this.comentarios = comentarios;
    }

    // Getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<String> imagenes) {
        this.imagenes = imagenes;
    }

    public List<String> getVideos() {
        return videos;
    }

    public void setVideos(List<String> videos) {
        this.videos = videos;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }
    public void guardarProducto() {
// Conexión a MongoDB
        MongoDBConnection.connect();
        // Obtiene la colección de productos
        MongoCollection<Document> collection = MongoDBConnection.getDatabase().getCollection("productos");
        // Crea el documento a partir de los atributos del objeto Producto
        Document document = new Document("nombre", nombre)
                .append("descripcion", descripcion)
                .append("precio", precio)
                .append("imagenes", imagenes)
                .append("videos", videos)
                .append("comentarios", comentarios);
        collection.insertOne(document);
        // Obtiene el ObjectId generado por MongoDB y lo asigna al objeto Producto
        this.id=document.getObjectId("_id").toString();
        MongoDBConnection.closeConnection();
    }
    public static Producto obtenerPorId(ObjectId id) {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("productos");

        // Busca el producto por su ObjectId
        Document document = collection.find(Filters.eq("_id", id)).first();

        if (document != null) {
            Producto producto = new Producto(
                    document.getString("nombre"),
                    document.getString("descripcion"),
                    document.getDouble("precio"),
                    (List<String>) document.get("imagenes"),
                    (List<String>) document.get("videos"),
                    (List<String>) document.get("comentarios")
            );

            producto.setId(document.getObjectId("_id").toString());

            mongoClient.close();
            return producto;
        }

        mongoClient.close();
        return null;
    }

    public void actualizar() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("productos");

        // Crea el documento con los nuevos valores a actualizar
        Document document = new Document("nombre", nombre)
                .append("descripcion", descripcion)
                .append("precio", precio)
                .append("imagenes", imagenes)
                .append("videos", videos)
                .append("comentarios", comentarios);

        // Actualiza el documento en la colección de productos
        collection.updateOne(Filters.eq("_id", id), new Document("$set", document));

        mongoClient.close();
    }

    public void eliminar() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydatabase");
        MongoCollection<Document> collection = database.getCollection("productos");

        // Elimina el documento de la colección de productos
        collection.deleteOne(Filters.eq("_id", id));

        mongoClient.close();
    }


}