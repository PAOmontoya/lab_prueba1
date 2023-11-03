package com.mycompany.lab_prueba1;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JuegoAhorcadoFijo extends JuegoAhorcadoBase{

    public JuegoAhorcadoFijo(String palabra){
        this.palabraSecreta=palabraSecreta.toUpperCase();
        inicializarPalabraSecreta();
        intentos=5;
    }
    
    @Override
    void actualizarPalabraActual(char letra) {
        char[] palabraNew = palabraActual.toCharArray();
        if(verificarLetra(letra)==true){
            for(int i=0; i<palabraSecreta.toCharArray().length;i++){
                if(palabraSecreta.toCharArray()[i]==letra){
                    palabraNew[i]=letra;
                }
            }
            palabraActual = new String(palabraNew);
        } else{
            intentos-=1;
        }
    }

    @Override
    boolean verificarLetra(char letra) {
        for(char letraCheck: palabraSecreta.toCharArray()){
            if(letraCheck==letra){
                return true;
            }
        }
        return false;
    }

    @Override
    boolean hasGanado() {
        if(palabraActual.equals(palabraSecreta)){
            return true;
        }
        return false;
    }

    @Override
    public void inicializarPalabraSecreta() {
        palabraActual="";
        for(int i=0; i<palabraSecreta.length();i++){
            palabraActual+="_";
        }
    }

    public void jugar(JTextField textF, JButton button, JLabel label) {
        while(intentos>0){
            String palabradeshebrada="";
            for(int i=0; i<palabraActual.charAt(i); i++){
                palabradeshebrada+=palabraActual.charAt(i)+" ";
            }
            
            String prueba= textF.getText();
            if(!prueba.isEmpty()){
                prueba=prueba.toUpperCase();
                char letra = prueba.charAt(0);
                actualizarPalabraActual(letra);
                
                palabradeshebrada="";
                int intentosRestantes=intentos;
                
                label.setText(palabradeshebrada);
                
                if(hasGanado() && intentos>0){
                    JOptionPane.showMessageDialog(null,"Ganaste");
                    intentos=0;
                }else if(intentos==0){
                    JOptionPane.showMessageDialog(null,"Perdiste");
                }
            }
            textF.setText("");
            if(intentos==0||hasGanado()){
                button.setEnabled(false);
            }
        }
    }
    
}
