package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.micro.Programable;

public class Lod extends Instruccion {

    private final Integer address;
    
    public Lod(Integer address) {
        this.address = address;
    }
    
    @Override
    public void doExecute(Programable micro) {
        Integer value = micro.getAddr(address);
        micro.setAcumuladorA(value);
    }

}

