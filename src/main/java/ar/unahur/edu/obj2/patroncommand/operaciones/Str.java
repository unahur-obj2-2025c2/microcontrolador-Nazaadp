package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.micro.Programable;

public class Str extends Instruccion {

    private final Integer address;
    
    public Str(Integer address) {
        this.address = address;
    }
    
    @Override
    public void doExecute(Programable micro) {
        micro.setAddr(address, micro.getAcumuladorA());
    }

}

