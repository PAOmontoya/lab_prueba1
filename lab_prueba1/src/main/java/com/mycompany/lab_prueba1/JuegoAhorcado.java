package com.mycompany.lab_prueba1;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public interface JuegoAhorcado {
  
    void inicializarPalabraSecreta();
    void jugar(JTextField textF, JButton button, JLabel label);
}
