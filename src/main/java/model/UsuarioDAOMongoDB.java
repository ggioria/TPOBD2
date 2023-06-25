package model;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class UsuarioDAOMongoDB {

    private MongoCollection<Document> usuariosCollection;

    public UsuarioDAOMongoDB(MongoDatabase db) {
        usuariosCollection = db.getCollection("usuarios");
    }

    public void insertUsuario(Usuario usuario) {
        Document doc = new Document("_id", usuario.getId())
                .append("nombre", usuario.getNombre())
                .append("direccion", usuario.getDireccion())
                .append("documento", usuario.getDocumento());

        usuariosCollection.insertOne(doc);
    }

    // Implementar métodos para buscar, actualizar y eliminar usuarios
}
