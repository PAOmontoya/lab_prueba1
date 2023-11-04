package com.mycompany.lab_prueba1;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class JuegoAhorcadoFijo extends JuegoAhorcadoBase{

    @Override
public void actualizarPalabraActual(char letra) {
    actualizarP(palabraActual.toCharArray(), palabraSecreta.toCharArray(), letra, 0);
}

private void actualizarP(char[] current, char[] palabraSecreta, char letra, int i) {
    if (i<palabraSecreta.length) {
        if (palabraSecreta[i] == letra) {
            current[i] = letra;
        }
        actualizarP(current,palabraSecreta, letra, i+1);
    } else {
        if (new String(current).equals(current)) {
        } else {
            intentos-= 1;
        }
        palabraActual = new String(current);
    }
}

    @Override
    public boolean verificarLetra(char letra){
        for(char leter: palabraSecreta.toCharArray()){
            if(leter==letra){
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
   
    public JuegoAhorcadoFijo(String palabrasecreta){
        this.palabraSecreta=palabraSecreta.toUpperCase();
        inicializarPalabraSecreta();
        intentos=5;
    }
   
}