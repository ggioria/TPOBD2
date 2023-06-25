package controllers;

import redis.clients.jedis.Jedis;

public class RedisController {

    private Jedis jedis;

    public RedisController(Jedis jedis) {
        this.jedis = jedis;
    }

    public void close() {
        jedis.close();
    }

    // Aquí podrías implementar métodos para manejar tus datos específicos...
    // Por ejemplo:
    public void set(String key, String value) {
        jedis.set(key, value);
    }

    public String get(String key) {
        return jedis.get(key);
    }
}
