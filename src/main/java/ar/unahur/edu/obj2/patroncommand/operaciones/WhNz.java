package ar.unahur.edu.obj2.patroncommand.operaciones;

import ar.unahur.edu.obj2.patroncommand.micro.Programable;

import java.util.ArrayList;
import java.util.List;

public class WhNz extends Instruccion {

    private List<Operable> instrucciones = null;
    private static final int MAX_ITERATIONS = 10000;
    
    public WhNz() {
        this.instrucciones = new ArrayList<>();
    }
    
    public WhNz(List<Operable> instrucciones) {
        this.instrucciones = new ArrayList<>(instrucciones);
    }
    
    public void addInstruccion(Operable instruccion) {
        instrucciones.add(instruccion);
    }
    
    @Override
    public void doExecute(Programable micro) {
        int iterations = 0;
        while (micro.getAcumuladorA() != 0 && iterations < MAX_ITERATIONS) {
            for (Operable instruccion : instrucciones) {
                instruccion.execute(micro);
                micro.incProgramCounter();
            }
            iterations++;
        }
        
        if (iterations >= MAX_ITERATIONS) {
            throw new RuntimeException("Máximo de iteraciones alcanzado en WHNZ");
        }
    }
}

