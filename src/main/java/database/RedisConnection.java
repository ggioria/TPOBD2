package database;

import redis.clients.jedis.Jedis;
//Vamos a usar Redis para guardar los datos de los usuarios.
//Redis es una base de datos en memoria, por lo que es muy rápida.
//En este caso, vamos a usarla como una base de datos clave-valor.
//Cada usuario tendrá una clave, que será su nombre de usuario, y un valor, que será su contraseña.
public class RedisConnection {

    private static Jedis jedis;

    public static void connect() {
        jedis = new Jedis("localhost", 6379);
    }

    public static Jedis getConnection() {
        if (jedis == null) {
            connect();
        }
        return jedis;
    }

    public static void closeConnection() {
        if (jedis != null) {
            jedis.close();
            jedis = null;
        }
    }
}
