package view;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;
import resources.Som;
import shapes.Barra;
import shapes.Bola;
import shapes.Objeto;
import shapes.PlacarVidas;

public class TelaJogo {

    Barra barra = new Barra();
    Bola bola = new Bola();
    PlacarVidas vida = new PlacarVidas();
    Screens tela = new Screens();
    Som soundFX = new Som();
    GLUT glut = new GLUT();
    

    //inicia o jogo com a barra, bola, e as vidas
    public void iniciar(GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2();

        soundFX.musicaFundo();
        barra.barra(drawable);
        bola.bola(drawable);
        
        vida.vidas(drawable, bola.getPontosVidas());
        tela.pauseScreen(drawable);

        //texto do score
        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);

        gl.glColor3f(1.0f, 1.0f,0);
        gl.glPushMatrix();
        gl.glRasterPos2d(-100, -93);
        glut.glutBitmapString(GLUT.BITMAP_9_BY_15, "Score: " + Bola.getPontos());
        gl.glPopMatrix();
        gl.glFlush();

    }

}
