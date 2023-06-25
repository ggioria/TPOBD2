package model;
import java.util.UUID;
import redis.clients.jedis.Jedis;
import static database.RedisConnection.*;

public class Usuario {
    private UUID userId;
    private String nombre;
    private String apellido;
    private String direccion;
    private String documento;
    private String categoriaUsuario;
    private static Jedis jedis;
    public Usuario(String nombre, String apellido, String direccion, String documento, String categoriaUsuario) {
    jedis.mset("id", userId.toString(),"nombre",nombre,"apellido",apellido,"direccion",direccion,"documento",documento,"categoriaUsuario",categoriaUsuario);
    }
    public Jedis GetUsuario(String id){
        jedis.mget("id","nombre","apellido","direccion","documento","categoriaUsuario");
        return jedis;
    }
    public Jedis DeleteUsuario(String id){
        jedis.del("id","nombre","apellido","direccion","documento","categoriaUsuario");
        return jedis;
    }
    public String getId() { return userId.toString(); }
    public void setNombre(String nombre) { jedis.set("nombre",this.nombre); }
    public void setApellido(String apellido) { jedis.set("apellido",this.apellido); }
    public void setDireccion(String direccion) { jedis.set("direccion",this.direccion); }
    public void setDocumento(String documento) { jedis.set("documento",this.documento); }
    public void setCategoriaUsuario(String categoriaUsuario) { jedis.set("categoriaUsuario",this.categoriaUsuario); }

    public String getNombre() { return jedis.get("nombre"); }
    public String getApellido() { return jedis.get("apellido"); }
    public String getDireccion() { return jedis.get("direccion"); }
    public String getDocumento() { return jedis.get("documento"); }
    public String getCategoriaUsuario() { return jedis.get("categoriaUsuario"); }

}
