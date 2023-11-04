package com.mycompany.lab_prueba1;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class JuegoAhorcadoAzar extends JuegoAhorcadoBase{
    
    ArrayList<String> palabras =new ArrayList();
    
    public JuegoAhorcadoAzar(ArrayList palabrasSecretas){
        palabras = palabrasSecretas;
        getPalabra();
        inicializarPalabraSecreta();
        intentos=5;
    }

    @Override
    public void actualizarPalabraActual(char letra) {
    actualizarP(palabraActual.toCharArray(), palabraSecreta.toCharArray(), letra, 0);
}

private void actualizarP(char[] palabraA, char[] palabraS, char letra, int i) {
    if (i<palabraS.length) {
        if (palabraS[i] == letra) {
            palabraA[i] = letra;
        }
        actualizarP(palabraA,palabraS, letra, i+1);
    } else {
        if (new String(palabraActual).equals(palabraActual)) {
        } else {
            intentos-= 1;
        }
        palabraActual = new String(palabraActual);
    }
}

    @Override
    public boolean verificarLetra(char letra){
        for(char letraverificar: palabraSecreta.toCharArray()){
            if(letraverificar==letra){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean hasGanado(){
        if(palabraActual.equals(palabraSecreta)){
            return true;
        }
        return false;
    }

    @Override
    public void inicializarPalabraSecreta(){
        palabraActual="";
        for(int i=0; i<palabraSecreta.length();i++){
            palabraActual+="_";
        }
    }

    @Override
    public void jugar() {
    while (intentos >0) {
        String hidden = getSeparada();
        String prueba;
        do {
            prueba = JOptionPane.showInputDialog(null, "Ingrese una letra: \n" + hidden + "\nIntentos restantes: " + intentos, "Ahorcado Fijo", JOptionPane.INFORMATION_MESSAGE);
        } while (prueba == null);

        prueba = prueba.toUpperCase();

        if (!prueba.isEmpty()) {
            char letra = prueba.charAt(0);
            actualizarPalabraActual(letra);

            if (hasGanado()&& intentos > 0) {
                JOptionPane.showMessageDialog(null, "Ganaste!");
                intentos = 0;
            } else if (intentos == 0) {
                JOptionPane.showMessageDialog(null, "Perdiste...");
            }
        }
    }
}

private String getSeparada() {
    String palabraSeparada = "";
    for (int i = 0; i < palabraActual.length(); i++) {
        palabraSeparada += palabraActual.charAt(i);
        if (i < palabraActual.length() - 1) {
            palabraSeparada += " ";
        }
    }
    return palabraSeparada;
}
    
    private void getPalabra() {
        Random random =new Random();
        int i =random.nextInt(palabras.size());
        palabraSecreta = palabras.get(i).toUpperCase();
    }
    
   
    }
