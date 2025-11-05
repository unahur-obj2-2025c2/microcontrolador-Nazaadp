package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.micro.Programable;

public abstract class Instruccion implements Operable {

    @Override
    public final void execute(Programable micro) {
        try {
            doExecute(micro);
            micro.incProgramCounter();
        } catch (RuntimeException e) {
            throw e;
        }
    }

    protected abstract void doExecute(Programable micro);
}

