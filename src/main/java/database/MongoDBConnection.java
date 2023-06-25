package database;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static void connect() {
        mongoClient = MongoClients.create();
        database = mongoClient.getDatabase("myDatabase");
    }
    public static void createTableProductos() {
        database.createCollection("productos");
    }
    public static void createTablePedidos() {
        database.createCollection("pedidos");
    }
    public static void createTablePagos() {
        database.createCollection("pagos");
    }
    public static void createTableFacturas() {
        database.createCollection("facturas");
    }
    public static void createCatalogo() {
        database.createCollection("catalogo");
    }

    public static MongoDatabase getDatabase() {
        if (database == null) {
            connect();
        }
        return database;
    }

    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            database = null;
        }
    }
}
