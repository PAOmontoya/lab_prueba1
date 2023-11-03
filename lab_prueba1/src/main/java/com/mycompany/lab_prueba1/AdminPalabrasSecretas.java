package com.mycompany.lab_prueba1;

import java.util.ArrayList;

public class AdminPalabrasSecretas {
 
    public static ArrayList<String> palabrasSecretas;
    
    public AdminPalabrasSecretas(){
    palabrasSecretas= new ArrayList<>();    
    palabrasSecretas.add("PAYASITOS");
    palabrasSecretas.add("ELECTROENCEFALOGRAFISTA");
    palabrasSecretas.add("DINERO");
    }
    
    public void addPalabra(String palabra){
        palabrasSecretas.add(palabra);
    }
    
    public static ArrayList getPaabras(){
        return palabrasSecretas;
    }
    
}
