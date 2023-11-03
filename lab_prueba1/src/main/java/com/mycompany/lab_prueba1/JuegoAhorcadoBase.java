package com.mycompany.lab_prueba1;

public abstract class JuegoAhorcadoBase implements JuegoAhorcado{
    protected String palabraSecreta, palabraActual;
    protected int intentos; 
    
    abstract void actualizarPalabraActual(char letra);
    
    abstract boolean verificarLetra(char letra);
    
    abstract boolean hasGanado();
    
}
