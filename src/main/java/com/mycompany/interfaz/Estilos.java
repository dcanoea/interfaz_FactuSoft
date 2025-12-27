/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interfaz;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author poker
 */
public class Estilos {

    // --- 1. PALETA DE COLORES ---
    public static final Color COLOR_FONDO_MENTA = Color.decode("#CBF6E3"); // Fondo principal
    public static final Color COLOR_VERDE_CLARO = Color.decode("#A0EECC"); // Acentos claros
    public static final Color COLOR_VERDE_FUERTE = Color.decode("#75E6B5"); // Acentos fuertes
    public static final Color COLOR_NEGRO_SUAVE = Color.decode("#111111"); // Textos principales
    public static final Color COLOR_GRIS_OSCURO = Color.decode("#2A2A2A"); // Bordes o secundarios
    public static final Color COLOR_NEGRO_PURO = Color.decode("#000000"); // Hover y contrastes
    public static final Color COLOR_BLANCO = Color.decode("#FFFFFF");

    // --- 2. FUENTES ---
    public static final Font FUENTE_TITULO = new Font("Century Gothic", Font.BOLD, 24);
    public static final Font FUENTE_MENU = new Font("Century Gothic", Font.PLAIN, 28);
    public static final Font FUENTE_TEXTO = new Font("Century Gothic", Font.PLAIN, 14);
    public static final Font FUENTE_BOTON = new Font("Century Gothic", Font.BOLD, 14);

    // --- 3. MÉTODO PARA BOTONES DEL MENÚ LATERAL ---
    /**
     * Configura un botón para que parezca una opción de menú: - Alineado a la
     * izquierda. - Sin bordes. - Al pasar el ratón: Fondo Negro, Letra Blanca,
     * Icono Blanco.
     */
    public static void configurarBotonMenu(JButton boton, String texto, String rutaIconoSvg) {
        // Texto y Fuente
        boton.setText(texto);
        boton.setFont(FUENTE_MENU);
        boton.setForeground(COLOR_NEGRO_PURO);

        // Color de Fondo base (Menta)
        boton.setBackground(COLOR_FONDO_MENTA);

        // Comportamiento visual
        boton.setBorderPainted(false); // Sin borde
        boton.setFocusPainted(false);  // Sin recuadro de foco
        boton.setOpaque(true);         // Para que se pinte el fondo
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Manita al pasar ratón

        // Aumentar el espacio entre icono y texto
        boton.setIconTextGap(30);

        // Alineación (Izquierda + Espacio)
        boton.setHorizontalAlignment(SwingConstants.LEFT);
        boton.setIconTextGap(15);

        // --- ICONOS (SVG) ---
        // Tamaño estándar para iconos de menú
        int tamaño = 50;

        // 1. Icono Normal (Tal cual viene en el SVG, asumimos color negro)
        FlatSVGIcon iconoNormal = new FlatSVGIcon(rutaIconoSvg, tamaño, tamaño);

        // 2. Icono Hover (Lo transformamos a BLANCO con un filtro)
        FlatSVGIcon iconoBlanco = new FlatSVGIcon(rutaIconoSvg, tamaño, tamaño);
        iconoBlanco.setColorFilter(new FlatSVGIcon.ColorFilter(color -> COLOR_BLANCO));

        boton.setIcon(iconoNormal);
        boton.setRolloverIcon(iconoBlanco); // Se activa al pasar el ratón

        // --- ESTILO FLATLAF (HOVER) ---
        // Al hacer HOVER (pasar por encima) de un botón se muestra el fondo negro y las fuentes blanco
        boton.putClientProperty(FlatClientProperties.STYLE, ""
                + "hoverBackground: #000000;" // Fondo negro al pasar ratón
                + "hoverForeground: #FFFFFF;" // Texto blanco al pasar ratón
                + "arc: 0;" // Bordes cuadrados (franja)
                + "margin: 20,15,20,15;" // Margen interno (Arriba, Izq, Abajo, Der)
        );
    }

    // --- 4. MÉTODO PARA CAMPOS DE TEXTO (Login y Formularios) ---
    /**
     * Aplica el estilo "Hacker/Moderno": Fondo Negro, Texto Blanco, Selección
     * Menta.
     */
    public static void aplicarEstiloCampo(JTextField campo) {
        // Estilo visual (Bordes y Márgenes)
        campo.putClientProperty(FlatClientProperties.STYLE, ""
                + "arc: 999; " // Redondeado total
                + "focusedBorderColor: #CBF6E3; " // Borde menta al enfocar
                + "borderWidth: 1; "
                + "margin: 0,10,0,0" // Margen izquierdo para el texto
        );

        // Colores estándar Swing
        campo.setBackground(COLOR_NEGRO_PURO);
        campo.setForeground(COLOR_BLANCO);
        campo.setCaretColor(COLOR_BLANCO);        // Cursor blanco
        campo.setSelectionColor(COLOR_FONDO_MENTA); // Selección verde menta
        campo.setSelectedTextColor(COLOR_NEGRO_PURO);
    }
}
