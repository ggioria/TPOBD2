package model;

import java.time.LocalDateTime;
public class SesionUsuario {
    private String idUsuario;
    private LocalDateTime horaInicioSesion;
    private LocalDateTime horaFinSesion;
    private String actividadRegistrada;

    public String getIdUsuario() { return idUsuario; }
    public void setIdUsuario(String idUsuario) { this.idUsuario = idUsuario; }

    public LocalDateTime getHoraInicioSesion() { return horaInicioSesion; }
    public void setHoraInicioSesion(LocalDateTime horaInicioSesion) { this.horaInicioSesion = horaInicioSesion; }

    public LocalDateTime getHoraFinSesion() { return horaFinSesion; }
    public void setHoraFinSesion(LocalDateTime horaFinSesion) { this.horaFinSesion = horaFinSesion; }

    public String getActividadRegistrada() { return actividadRegistrada; }
    public void setActividadRegistrada(String actividadRegistrada) { this.actividadRegistrada = actividadRegistrada; }
}
