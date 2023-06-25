package controllers;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;

public class CassandraController {

    private CqlSession session;

    public CassandraController(CqlSession session) {
        this.session = session;
    }

    public void close() {
        session.close();
    }

    public void createTable(String query) {
        session.execute(query);
    }

    public ResultSet executeQuery(String query) {
        return session.execute(query);
    }
}
