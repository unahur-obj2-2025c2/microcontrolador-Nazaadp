package ar.unahur.edu.obj2.patroncommand.memento;

import java.util.HashMap;
import java.util.Map;

public class MicroMemento {

    private final Integer acumuladorA;
    private final Integer acumuladorB;
    private final Integer programCounter;
    private final Map<Integer, Integer> memoria;
    
    public MicroMemento(Integer accA, Integer accB, Integer pc, Map<Integer, Integer> mem) {
        this.acumuladorA = accA;
        this.acumuladorB = accB;
        this.programCounter = pc;
        this.memoria = new HashMap<>(mem);
    }
    
    public Integer getAcumuladorA() {
        return acumuladorA;
    }
    
    public Integer getAcumuladorB() {
        return acumuladorB;
    }
    
    public Integer getProgramCounter() {
        return programCounter;
    }
    
    public Map<Integer, Integer> getMemoria() {
        return new HashMap<>(memoria);
    }
    
}
