import model.*;
import controllers.*;
import database.*;
import java.time.LocalDateTime;
import java.util.*;
import com.datastax.oss.driver.api.core.CqlSession;
import redis.clients.jedis.Jedis;
import com.mongodb.client.MongoDatabase;

public class Main {
    public static void main(String[] args) {
//        // Crear las conexiones a las bases de datos
//        CassandraConnection.connect();
//        CqlSession cassandraSession = CassandraConnection.getSession();
//        MongoDBConnection.connect();
//        MongoDatabase mongoDatabase = MongoDBConnection.getDatabase();
//        RedisConnection.connect();
//        Jedis jedisConnection = RedisConnection.getConnection();
//
//        // Crear los controladores, pasándoles las conexiones
//        CassandraController cassandraController = new CassandraController(cassandraSession);
//        MongoDBController mongoDBController = new MongoDBController(mongoDatabase);
//        RedisController redisController = new RedisController(jedisConnection);
//
//        // Crear un usuario
//        Usuario usuario = new Usuario();
//        usuario.setId("123");
//        usuario.setNombre("Juan");
//        usuario.setDireccion("Calle Falsa 123");
//        usuario.setDocumento("45678912");
//        System.out.println("model.Usuario creado: " + usuario.getNombre());
//
//        // Crear un producto
//        Producto producto = new Producto();
//        producto.setId("1");
//        producto.setNombre("model.Producto A");
//        producto.setPrecio(15.0);
//        System.out.println("model.Producto creado: " + producto.getNombre());
//
//        // Crear un catálogo y agregarle productos
//        Catalogo catalogo = new Catalogo();
//        catalogo.setProductos(new ArrayList<>(Collections.singletonList(producto)));
//        System.out.println("model.Producto añadido al catálogo: " + producto.getNombre());
//
//        // Crear un carrito y agregarle productos
//        Carrito carrito = new Carrito();
//        carrito.setIdUsuario(usuario.getId());
//        carrito.setProductos(new HashMap<>(Map.of(producto.getId(), 2))); // Agregamos 2 unidades del producto
//        System.out.println("model.Producto añadido al carrito: " + producto.getNombre());
//
//        // Crear un pedido a partir del carrito
//        Pedido pedido = new Pedido();
//        pedido.setId("1");
//        pedido.setIdUsuario(usuario.getId());
//        pedido.setProductos(carrito.getProductos());
//        pedido.setTotal(producto.getPrecio() * carrito.getProductos().get(producto.getId())); // asumiendo que todos los productos tienen el mismo precio
//        pedido.setEstado("pedido realizado");
//        System.out.println("model.Pedido creado para el usuario: " + usuario.getNombre());
//
//        // Facturar el pedido
//        Factura factura = new Factura();
//        factura.setId("1");
//        factura.setIdUsuario(usuario.getId());
//        factura.setDetalle(pedido.getProductos());
//        factura.setTotal(pedido.getTotal());
//        factura.setMetodoPago("efectivo");
//        System.out.println("model.Factura creada para el usuario: " + usuario.getNombre());
//
//        // Realizar un pago
//        Pago pago = new Pago();
//        pago.setId("1");
//        pago.setIdUsuario(usuario.getId());
//        pago.setFechaHora(LocalDateTime.now());
//        pago.setMonto(factura.getTotal());
//        pago.setMetodoPago("efectivo");
//        System.out.println("model.Pago realizado por el usuario: " + usuario.getNombre());
//
//        // Registro de actividad en el catálogo
//        RegistroActividadCatalogo registro = new RegistroActividadCatalogo();
//        registro.setIdProducto(producto.getId());
//        registro.setFechaHoraCambio(LocalDateTime.now());
//        registro.setDetalleCambio("Precio modificado");
//        registro.setValorAnterior(String.valueOf(producto.getPrecio()));
//        registro.setNuevoValor("20.0"); // Supongamos que el nuevo precio es 20.0
//        registro.setIdOperador("1"); // ID del operador que realizó el cambio
//        System.out.println("Registro de actividad en el catálogo realizado para el producto: " + producto.getNombre());
//
//        // Actualizar el precio del producto en el catálogo
//        producto.setPrecio(Double.parseDouble(registro.getNuevoValor()));
//        System.out.println("Precio actualizado del producto: " + producto.getNombre() + " a $" + producto.getPrecio());
//    }
    }
}
