package state;

import input.ValidadorForgiving;
import java.util.ArrayList;

public class GestorSesionUI {
    private ValidadorForgiving validador = new ValidadorForgiving();
    private String equipo = "";
    private String telefono = "";
    private String correo = "";
    private boolean usuarioActivo = false;
    private boolean hayBorrador = false;

    public void setEquipo(String equipo) {
        this.equipo = equipo.trim();
    }

    public void setTelefono(String entrada) {
        this.telefono = validador.normalizarTelefono(entrada);
    }

    public void setCorreo(String correo) {
        this.correo = correo.trim();
    }

    public String getTelefono() {
        return telefono;
    }

    public boolean isUsuarioActivo() {
        return usuarioActivo;
    }

    public boolean isHayBorrador() {
        return hayBorrador;
    }

    private int contarCampos() {
        int total = 0;
        if (!equipo.isEmpty()) {
            total++;
        }
        if (!telefono.isEmpty()) {
            total++;
        }
        if (!correo.isEmpty()) {
            total++;
        }
        return total;
    }

    public int calcularProgreso() {
        int total = contarCampos();
        if (total == 0) {
            return 0;
        }
        if (total == 1) {
            return 33;
        }
        if (total == 2) {
            return 67;
        }
        return 100;
    }

    public void mostrarProgreso() {
        ArrayList<String> faltantes = new ArrayList<>();
        if (equipo.isEmpty()) {
            faltantes.add("Equipo a reservar");
        }
        if (telefono.isEmpty()) {
            faltantes.add("Telefono");
        }
        if (correo.isEmpty()) {
            faltantes.add("Correo de contacto");
        }
        String texto = "[Progreso: " + calcularProgreso() + "%] ";
        if (faltantes.isEmpty()) {
            texto = texto + "Formulario completo";
        } else {
            texto = texto + "Campos listos: " + contarCampos() + " de 3 (Falta: "
                    + String.join(", ", faltantes) + ")";
        }
        System.out.println(texto);
    }

    public void guardarReserva() {
        if (!usuarioActivo) {
            hayBorrador = true;
            System.out.println("[Lazy Registration] Avance guardado en borrador temporal. Por favor cree su cuenta para finalizar.");
        } else {
            hayBorrador = false;
            enviarToast("Reserva guardada exitosamente.");
        }
    }

    public void registrarse() {
        usuarioActivo = true;
        System.out.println("Usuario completa registro rapido. Sesion activa: " + usuarioActivo);
    }

    public void cancelarReserva() {
        equipo = "";
        telefono = "";
        correo = "";
        hayBorrador = false;
        enviarToast("Reserva cancelada.");
    }

    public void cerrarSesion() {
        usuarioActivo = false;
        enviarToast("Sesion cerrada.");
    }

    public void enviarToast(String mensaje) {
        System.out.println("[Toast de Estado] " + mensaje);
    }
}
