package ar.unahur.edu.obj2.patroncommand;

import java.util.ArrayList;
import java.util.List;

import ar.unahur.edu.obj2.patroncommand.operaciones.Add;
import ar.unahur.edu.obj2.patroncommand.operaciones.IfNz;
import ar.unahur.edu.obj2.patroncommand.operaciones.Lod;
import ar.unahur.edu.obj2.patroncommand.operaciones.Lodv;
import ar.unahur.edu.obj2.patroncommand.operaciones.Nop;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;
import ar.unahur.edu.obj2.patroncommand.operaciones.Str;
import ar.unahur.edu.obj2.patroncommand.operaciones.Swap;
import ar.unahur.edu.obj2.patroncommand.operaciones.WhNz;

public class ProgramBuilder {
    private final List<Operable> operaciones;
    
    public ProgramBuilder() {
        this.operaciones = new ArrayList<>();
    }
    
    public ProgramBuilder nop() {
        operaciones.add(new Nop());
        return this;
    }
    
    public ProgramBuilder add() {
        operaciones.add(new Add());
        return this;
    }
    
    public ProgramBuilder swap() {
        operaciones.add(new Swap());
        return this;
    }
    
    public ProgramBuilder lod(Integer address) {
        operaciones.add(new Lod(address));
        return this;
    }
    
    public ProgramBuilder str(Integer address) {
        operaciones.add(new Str(address));
        return this;
    }
    
    public ProgramBuilder lodv(Integer value) {
        operaciones.add(new Lodv(value));
        return this;
    }
    
    public ProgramBuilder ifnz(List<Operable> instrucciones) {
        operaciones.add(new IfNz(instrucciones));
        return this;
    }
    
    public ProgramBuilder whnz(List<Operable> instrucciones) {
        operaciones.add(new WhNz(instrucciones));
        return this;
    }
    
    public List<Operable> build() {
        return new ArrayList<>(operaciones);
    }
}
