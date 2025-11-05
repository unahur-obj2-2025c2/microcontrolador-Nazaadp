package ar.unahur.edu.obj2.patroncommand;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.unahur.edu.obj2.patroncommand.excepciones.ErrorMemoriaFueraDeRangoException;
import ar.unahur.edu.obj2.patroncommand.micro.Microcontrolador;
import ar.unahur.edu.obj2.patroncommand.operaciones.Operable;
import ar.unahur.edu.obj2.patroncommand.operaciones.Add;
import ar.unahur.edu.obj2.patroncommand.operaciones.Lod;
import ar.unahur.edu.obj2.patroncommand.operaciones.Lodv;
import ar.unahur.edu.obj2.patroncommand.operaciones.Nop;
import ar.unahur.edu.obj2.patroncommand.operaciones.Str;
import ar.unahur.edu.obj2.patroncommand.operaciones.Swap;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MicrocontroladorTest {

    @BeforeEach
    void setUp() {
        Microcontrolador micro = new Microcontrolador();
    }

 @Test
    void testAvanzarProgramCounter() {
        // Arrange
        List<Operable> programa = new ProgramBuilder()
            .nop()
            .nop()
            .nop()
            .build();
        
        // Act
        micro.run(programa);
        
        // Assert
        assertEquals(3, micro.getProgramCounter(), 
            "El PC debe avanzar de 0 a 3");
    }
    
    @Test
    void testSumar20Mas17() {
        // Arrange
        List<Operable> programa = new ProgramBuilder()
            .lodv(20)     // A = 20
            .swap()       // B = 20, A = 0
            .lodv(17)     // A = 17
            .add()        // A = 20 + 17 = 37, B = 0
            .build();
        
        // Act
        micro.run(programa);
        
        // Assert
        assertEquals(37, micro.getAcumuladorA(), 
            "El acumulador A debe contener 37");
        assertEquals(0, micro.getAcumuladorB(), 
            "El acumulador B debe contener 0");
        assertEquals(4, micro.getProgramCounter(), 
            "El PC debe pasar de 0 a 4");
    }
    
    @Test
    void testSumar2Mas8Mas5() {
        // Arrange
        List<Operable> programa = new ProgramBuilder()
            .lodv(2)      // A = 2
            .str(0)       // MEM[0] = 2
            .lodv(8)      // A = 8
            .swap()       // B = 8, A = 0
            .lodv(5)      // A = 5
            .add()        // A = 8 + 5 = 13, B = 0
            .swap()       // B = 13, A = 0
            .lod(0)       // A = MEM[0] = 2
            .add()        // A = 2 + 13 = 15, B = 0
            .build();
        
        // Act
        micro.run(programa);
        
        // Assert
        assertEquals(15, micro.getAcumuladorA(), 
            "El acumulador A debe contener 15");
        assertEquals(0, micro.getAcumuladorB(), 
            "El acumulador B debe contener 0");
    }
    
    @Test
    void testReset() {
        // Arrange
        List<Operable> programa = new ProgramBuilder()
            .lodv(42)
            .swap()
            .lodv(17)
            .build();
        
        micro.run(programa);
        
        // Act
        micro.reset();
        
        // Assert
        assertEquals(0, micro.getAcumuladorA());
        assertEquals(0, micro.getAcumuladorB());
        assertEquals(0, micro.getProgramCounter());
    }
    
    @Test
    void testMemoriaFueraDeRango() {
        // Arrange
        List<Operable> programa = new ProgramBuilder()
            .lodv(100)
            .str(1024)  // Fuera de rango
            .build();
        
        // Act & Assert
        assertThrows(MemoryOutOfBoundsException.class, 
            () -> micro.run(programa),
            "Debe lanzar excepción al acceder a dirección fuera de rango");
        
        // Verificar que el PC no avanzó desde la instrucción que falló
        assertEquals(1, micro.getProgramCounter(), 
            "El PC debe quedarse en la instrucción que causó el error");
    }
    
    @Test
    void testLODFueraDeRango() {
        List<Operable> programa = new ProgramBuilder()
            .lod(-1)
            .build();
        
        assertThrows(MemoryOutOfBoundsException.class, 
            () -> micro.run(programa));
    }
    
    @Test
    void testSwap() {
        // Arrange
        micro.setAcumuladorA(10);
        micro.setAcumuladorB(20);
        
        List<Operable> programa = new ProgramBuilder()
            .swap()
            .build();
        
        // Act
        micro.run(programa);
        
        // Assert
        assertEquals(20, micro.getAcumuladorA());
        assertEquals(10, micro.getAcumuladorB());
    }
}