package input;

public class ValidadorForgiving {

    public String normalizarTelefono(String entrada) {
        if (entrada == null) {
            return "";
        }
        String digitos = entrada.replaceAll("\\D", "");
        if (digitos.length() == 12 && digitos.startsWith("57")) {
            digitos = digitos.substring(2);
        }
        return digitos;
    }

    public String normalizarFecha(String entrada) {
        if (entrada == null) {
            return "";
        }
        return entrada.replaceAll("\\D", "");
    }
}
