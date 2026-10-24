package main;

import content.TarjetaElemento;
import input.ValidadorForgiving;
import navigation.BreadcrumbNavigator;
import state.GestorSesionUI;

public class Main {
    public static void main(String[] args) {

        System.out.println("CASO 1: PATRON DE NAVEGACION (BREADCRUMBS Y TABS)");
        BreadcrumbNavigator navegador = new BreadcrumbNavigator();
        System.out.println(navegador.obtenerRuta());
        navegador.cambiarPestana("Catalogo");
        System.out.println(navegador.obtenerRuta());
        navegador.entrarSubcategoria("Servidor Principal");
        System.out.println(navegador.obtenerRuta());
        navegador.cambiarPestana("Reservas");
        navegador.entrarSubcategoria("Laboratorio de Redes");
        System.out.println(navegador.obtenerRuta());
        System.out.println();

        System.out.println("CASO 2: PATRON DE CONTENIDO (PROGRESSIVE DISCLOSURE)");
        TarjetaElemento tarjeta = new TarjetaElemento("Servidor Principal", "Activo", "192.168.1.10", 8080, "4GB/16GB");
        tarjeta.setVerAvanzado(false);
        System.out.println(tarjeta.mostrar());
        System.out.println("Usuario solicita ver detalles avanzados");
        tarjeta.setVerAvanzado(true);
        System.out.println(tarjeta.mostrar());
        System.out.println();

        System.out.println("CASO 3: PATRON DE ENTRADA (FORGIVING FORMAT)");
        ValidadorForgiving validador = new ValidadorForgiving();
        String entrada = "+57 (310) 999-8877";
        System.out.println("Entrada del usuario: " + entrada);
        System.out.println("Telefono normalizado sin error: " + validador.normalizarTelefono(entrada));
        String fecha = "15 / 03 / 2026";
        System.out.println("Fecha de entrada: " + fecha);
        System.out.println("Fecha normalizada sin error: " + validador.normalizarFecha(fecha));
        System.out.println();

        System.out.println("CASO 4: PATRON DE FEEDBACK (COMPLETENESS METER)");
        GestorSesionUI gestor = new GestorSesionUI();
        gestor.mostrarProgreso();
        gestor.setEquipo("Laboratorio de Redes");
        gestor.mostrarProgreso();
        gestor.setTelefono("+57 (310) 999-8877");
        gestor.mostrarProgreso();
        System.out.println("Usuario ingresa correo: estudiante@udistrital.edu.co");
        gestor.setCorreo("estudiante@udistrital.edu.co");
        gestor.mostrarProgreso();
        System.out.println();

        System.out.println("CASO 5: LAZY REGISTRATION Y TOAST");
        System.out.println("Usuario intenta guardar sin haber iniciado sesion");
        gestor.guardarReserva();
        System.out.println("Hay borrador temporal: " + gestor.isHayBorrador());
        gestor.registrarse();
        System.out.println("Usuario intenta guardar de nuevo");
        gestor.guardarReserva();
        System.out.println("Hay borrador temporal: " + gestor.isHayBorrador());
        System.out.println();

        System.out.println("EXTRA: CERO DARK PATTERNS");
        gestor.cancelarReserva();
        gestor.cerrarSesion();
    }
}
