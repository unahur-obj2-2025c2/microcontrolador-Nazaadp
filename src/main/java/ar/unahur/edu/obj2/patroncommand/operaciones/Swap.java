package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.micro.Programable;

public class Swap extends Instruccion {

    @Override
    public void doExecute(Programable micro) {
        Integer temp = micro.getAcumuladorA();
        micro.setAcumuladorA(micro.getAcumuladorB());
        micro.setAcumuladorB(temp);
    }
}

