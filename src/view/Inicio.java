package view;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.Color;
import java.awt.Font;
import graficos.Renderer;

public class Inicio {

    GLUT glut = new GLUT();
    private TextRenderer textRenderer;
    private TextRenderer instrucao;
    private static boolean inicio = false;
    TelaJogo inicioJogo = new TelaJogo();

    public void telaInicial(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        textRenderer = new TextRenderer(new Font("Century Gothic", Font.BOLD, 40));
        textRenderer.beginRendering(Renderer.screenWidth, Renderer.screenHeight);
        textRenderer.setColor(Color.MAGENTA);

        textRenderer.draw("╔═.═════════.═╗", 150, 498);
        textRenderer.draw("║ JOGO PONG ║", 150, 448);
        textRenderer.draw("╚═.═════════.═╝", 150, 398);
        textRenderer.endRendering();

        instrucao = new TextRenderer(new Font("Rockwell", Font.PLAIN, 15));
        instrucao.beginRendering(Renderer.screenWidth, Renderer.screenHeight);
        instrucao.setColor(Color.white);

        instrucao.draw("1 - Use as setas para se movimentar", 150, 350);
        instrucao.draw("2 - Aperte S para pausar", 150, 330);
        instrucao.draw("3 - Aperte esc para sair", 150, 310);
        instrucao.draw("4 - Quando a bola sair fora, perde uma vida", 150, 290);
        instrucao.draw("5 - Quando as vidas se acabam, o jogo se encerra!", 150, 270);
        instrucao.draw("6 - Divirta-se!", 150, 250);
        instrucao.draw("Aperte enter para iniciar!", 150, 220);

        instrucao.endRendering();
        
        if(inicio) {
            inicioJogo.iniciar(drawable);
        }

    }

    public static boolean isInicio() {
        return inicio;
    }

    public static void setInicio(boolean inicio) {
        Inicio.inicio = inicio;
    }

}
