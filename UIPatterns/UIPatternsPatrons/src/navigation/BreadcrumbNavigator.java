package navigation;

import java.util.ArrayList;

public class BreadcrumbNavigator {
    private ArrayList<String> ruta = new ArrayList<>();
    private ArrayList<String> pestanas = new ArrayList<>();

    public BreadcrumbNavigator() {
        ruta.add("Inicio");
        pestanas.add("Catalogo");
        pestanas.add("Reservas");
        pestanas.add("Perfil");
    }

    public void cambiarPestana(String nombre) {
        if (pestanas.contains(nombre)) {
            ruta.clear();
            ruta.add("Inicio");
            ruta.add(nombre);
        }
    }

    public void entrarSubcategoria(String nombre) {
        ruta.add(nombre);
    }

    public void volverAtras() {
        if (ruta.size() > 1) {
            ruta.remove(ruta.size() - 1);
        }
    }

    public String obtenerRuta() {
        return "Ruta actual: " + String.join(" > ", ruta);
    }
}
