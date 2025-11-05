package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.micro.Programable;

import java.util.ArrayList;
import java.util.List;

public class IfNz extends Instruccion {
    
    private final List<Operable> instrucciones;
    
    public IfNz() {
        this.instrucciones = new ArrayList<>();
    }
    
    public IfNz(List<Operable> instrucciones) {
        this.instrucciones = new ArrayList<>(instrucciones);
    }
    
    public void addInstruccion(Operable instruccion) {
        instrucciones.add(instruccion);
    }
    
    @Override
    public void doExecute(Programable micro) {
        if (micro.getAcumuladorA() != 0) {
            for (Operable instruccion : instrucciones) {
                instruccion.execute(micro);
                micro.incProgramCounter();
            }
        }
    }
}

