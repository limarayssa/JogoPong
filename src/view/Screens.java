package view;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;

public class Screens {

    GLUT glut = new GLUT();
    private static boolean pausado = false;

    //tela de pause
    public void pauseScreen(GLAutoDrawable drawable) {
        if (pausado) {
            GL2 gl = drawable.getGL().getGL2();
            gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

            gl.glColor3f(1.0f, 1.0f, 1.0f);
            gl.glRasterPos2d(-17, 5);
            glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Pausado I I");
            gl.glRasterPos2d(-25, -5);
            glut.glutBitmapString(GLUT.BITMAP_HELVETICA_12, "Aperte S para retornar");
            gl.glFlush();
        }
    }
    
    //tela de gameover
    public void gameOver(GLAutoDrawable drawable) {
         GL2 gl = drawable.getGL().getGL2();
            gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

            gl.glColor3f(1.0f, 0, 0);
            gl.glRasterPos2d(-17, 5);
            glut.glutBitmapString(GLUT.BITMAP_HELVETICA_18, "Game over :(");
            gl.glRasterPos2d(-25, -5);
            glut.glutBitmapString(GLUT.BITMAP_HELVETICA_12, "Aperte esc para sair");
            gl.glFlush();
    }

    public static boolean isPausado() {
        return pausado;
    }

    public static void setPausado(boolean pausado) {
        Screens.pausado = pausado;
    }
}
