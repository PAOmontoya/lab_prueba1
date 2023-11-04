package com.mycompany.lab_prueba1;

import java.util.ArrayList;

public class AdminPalabrasSecretas {
    static ArrayList<String> palabrasSecretas;
    

    public AdminPalabrasSecretas(){
        palabrasSecretas=new ArrayList<>();
        palabrasSecretas.add("PAYASO");
        palabrasSecretas.add("DINERO");
        palabrasSecretas.add("ALIEN");
    }

    public void agregarPalabra(String palabraSecreta) {
        palabrasSecretas.add(palabraSecreta);
    }
    
    public static ArrayList getpalabrasSecretas(){
        return palabrasSecretas;
    }
}
