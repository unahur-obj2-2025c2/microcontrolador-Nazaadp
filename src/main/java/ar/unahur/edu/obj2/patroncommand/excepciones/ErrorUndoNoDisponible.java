package ar.unahur.edu.obj2.patroncommand.excepciones;

public class ErrorUndoNoDisponible extends RuntimeException {
    public ErrorUndoNoDisponible() {
        super("No hay operaciones para deshacer");
    }
}