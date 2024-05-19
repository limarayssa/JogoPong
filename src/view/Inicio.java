/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.awt.TextRenderer;
import java.awt.Color;
import java.awt.Font;
import graficos.Renderer;

public class Inicio {

    GLU glu;
    private TextRenderer textRenderer;
    String texto1, texto2, texto3, texto4, texto5, texto6;

    public void telaInicial(GL2 gl) {
        texto1 = "Temos aqui um jogo de pong em que o objetivo é o mesmo de ";
        texto2 = "jogar peteca: não deixar a bola cair";
        texto3 =  "";
        texto4 =  "";
        texto5 =  "";
        texto6 =  "";
        
        Color cor = Color.WHITE;
        textRenderer = new TextRenderer(new Font("SansSerif", Font.PLAIN, 20));
        textRenderer.beginRendering(Renderer.screenWidth, Renderer.screenHeight);
        textRenderer.setColor(cor);
        textRenderer.draw(texto1, 100, 550);
        textRenderer.draw(texto2, 80, 530);
        
        
        textRenderer.endRendering();
    }
}
