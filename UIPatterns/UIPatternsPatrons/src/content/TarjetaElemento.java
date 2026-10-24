package content;

public class TarjetaElemento {
    private String nombre;
    private String estado;
    private String ip;
    private int puerto;
    private String ram;
    private boolean verAvanzado = false;

    public TarjetaElemento(String nombre, String estado, String ip, int puerto, String ram) {
        this.nombre = nombre;
        this.estado = estado;
        this.ip = ip;
        this.puerto = puerto;
        this.ram = ram;
    }

    public void setVerAvanzado(boolean verAvanzado) {
        this.verAvanzado = verAvanzado;
    }

    public String mostrar() {
        if (verAvanzado) {
            return "[Acordeon Desplegado] " + nombre + " | Estado: " + estado
                    + " | IP: " + ip + " | Puerto: " + puerto + " | RAM: " + ram;
        }
        return "[Vista Resumen] " + nombre + " | Estado: " + estado;
    }
}
