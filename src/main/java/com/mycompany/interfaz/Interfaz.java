package com.mycompany.interfaz;

import com.formdev.flatlaf.FlatLightLaf;

/**
 *
 * @author Usuario
 */
public class Interfaz {

    public static void main(String[] args) {
        // PRIMERO: Configuramos el diseño (ANTES de crear ventanas)
        try {
            FlatLightLaf.setup(); // Esto activa el modo moderno claro
            // UIManager.put( "Button.arc", 999 ); // (Opcional) Botones redondos
        } catch (Exception ex) {
            System.err.println("Falló la carga de FlatLaf");
        }

        // 2. LUEGO: Arrancamos la ventana de Login
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
