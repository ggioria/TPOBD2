package controllers;

import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

public class MongoDBController {

    private MongoDatabase database;

    public MongoDBController(MongoDatabase database) {
        this.database = database;
    }

    public void insertDocument(String collectionName, Document document) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        collection.insertOne(document);
    }

    public FindIterable<Document> getDocuments(String collectionName) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.find();
    }

    public UpdateResult updateDocument(String collectionName, Document oldDocument, Document newDocument) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.replaceOne(oldDocument, newDocument);
    }

    public DeleteResult deleteDocument(String collectionName, Document document) {
        MongoCollection<Document> collection = database.getCollection(collectionName);
        return collection.deleteOne(document);
    }
}
