package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.micro.Programable;

public class Lodv extends Instruccion {
    
    private final Integer value;
    
    public Lodv(Integer value) {
        this.value = value;
    }
    
    @Override
    public void doExecute(Programable micro) {
        micro.setAcumuladorA(value);
    }
}

