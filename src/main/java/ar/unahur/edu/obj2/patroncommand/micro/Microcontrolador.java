package ar.unahur.edu.obj2.patroncommand.micro;

import java.util.List;

import ar.unahur.edu.obj2.patroncommand.excepciones.ErrorMemoriaFueraDeRangoException;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;

public class Microcontrolador implements Programable {
    
    private static final int MEMORY_SIZE = 1024;
    private static final int MIN_ADDRESS = 0;
    private static final int MAX_ADDRESS = 1023;
    
    private Integer acumuladorA;
    private Integer acumuladorB;
    private Integer programCounter;
    private Integer[] memoria;
    
    public Microcontrolador() {
        this.memoria = new Integer[MEMORY_SIZE];
        reset();
    }
    
    @Override
    public void run(List<Operable> operaciones) {
        for (Operable operacion : operaciones) {
            try {
                operacion.execute(this);
                incProgramCounter();
            } catch (ErrorMemoriaFueraDeRangoException e) {
                throw e;
            }
        }
    }
    
    @Override
    public void incProgramCounter() {
        this.programCounter++;
    }
    
    @Override
    public Integer getProgramCounter() {
        return programCounter;
    }
    
    @Override
    public void setAcumuladorA(Integer value) {
        this.acumuladorA = value;
    }
    
    @Override
    public Integer getAcumuladorA() {
        return acumuladorA;
    }
    
    @Override
    public void setAcumuladorB(Integer value) {
        this.acumuladorB = value;
    }
    
    @Override
    public Integer getAcumuladorB() {
        return acumuladorB;
    }
    
    @Override
    public void setAddr(Integer addr, Integer value) {
        validarDireccion(addr);
        memoria[addr] = value;
    }
    
    @Override
    public Integer getAddr(Integer addr) {
        validarDireccion(addr);
        return memoria[addr] != null ? memoria[addr] : 0;
    }
    
    @Override
    public void reset() {
        this.acumuladorA = 0;
        this.acumuladorB = 0;
        this.programCounter = 0;
        this.memoria = new Integer[MEMORY_SIZE];
    }

    private void validarDireccion(Integer addr) {
        if (addr < MIN_ADDRESS || addr > MAX_ADDRESS) {
            throw new ErrorMemoriaFueraDeRangoException(addr);
        }
    }
}