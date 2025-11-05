package ar.unahur.edu.obj2.patroncommand.excepciones;

public class ErrorMemoriaFueraDeRangoException extends RuntimeException {
    public ErrorMemoriaFueraDeRangoException(Integer direccion) {
        super("Dirección de memoria fuera de rango: " + direccion + 
              ". Rango válido: 0-1023");
    }
}