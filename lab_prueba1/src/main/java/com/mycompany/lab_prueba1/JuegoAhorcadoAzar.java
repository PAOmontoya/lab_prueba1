package com.mycompany.lab_prueba1;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class JuegoAhorcadoAzar extends JuegoAhorcadoBase{

    ArrayList<String> palabras= new ArrayList();
    
    public JuegoAhorcadoAzar(ArrayList words){
        words=palabras;
        
    }
    
    @Override
    void actualizarPalabraActual(char letra) {
        char[] palabrareemplazar = palabraActual.toCharArray();
        if(verificarLetra(letra)==true){
            for(int i=0; i<palabraSecreta.toCharArray().length;i++){
                if(palabraSecreta.toCharArray()[i]==letra){
                    palabrareemplazar[i]=letra;
                }
            }
            palabraActual = new String(palabrareemplazar);
        } else{
            intentos-=1;
        }
    }

    @Override
    boolean verificarLetra(char letra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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

    @Override
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
