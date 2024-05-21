package shapes;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import java.util.Random;

public class Bola {

    private GLU glu = new GLU();
    GLUT glut = new GLUT();

    Random random = new Random();

    private Barra barra = new Barra();

    private float ballX = 0.0f;
    private float ballY = 0.0f;
    private static float ballSpeedX = 0.3f;
    private static float ballSpeedY = 0.3f;
    //private static float ballRadius = 1f;

    public void bola(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        //gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Verifica colisão com as paredes
        if (ballX >= 100) { // Colisão nas bordas laterais
            ballSpeedX = -ballSpeedX;
            ballX--;
            ballY++;
        }
        if (ballX <= -100) {
            ballSpeedX = -ballSpeedX;
            ballX++;
            ballY--;
        }
        if (ballY >= 100) {
            ballSpeedY = -ballSpeedY;
            ballY--;
            ballX++;
        }
        if (ballY <= -100) {
            ballSpeedY = -ballSpeedY;
            ballY++;
            ballX--;
        }

        float ballRadius = 1.5f; // raio da bola
        float barraTop = barra.getBarraY() + barra.getBarraAltura() / 2;
        float barraBottom = barra.getBarraY() - barra.getBarraAltura() / 2;
        float barraLeft = barra.getBarraX() - barra.getBarraLargura() / 2;
        float barraRight = barra.getBarraX() + barra.getBarraLargura() / 2;

        if (ballX + ballRadius >= barraLeft
                && ballX - ballRadius <= barraRight
                && ballY + ballRadius >= barraBottom
                && ballY - ballRadius <= barraTop) {
            ballSpeedY = -ballSpeedY; // inverte o movimento vertical
            ballY = barraTop + ballRadius; // reposiciona a bola acima da barra
        }

        // Verifica colisão com as paredes
//        if (ballX >= 100 || ballX <= -100) { // Colisão nas bordas laterais
//            ballSpeedX = -ballSpeedX;
//        }
//        if (ballY >= 100 || ballY <= -100) { // Colisão nas bordas superior e inferior
//            ballSpeedY = -ballSpeedY;
//        }
//        else if (ballY < 200) {
//            ballX++;
//            ballY--;
//        }
        // Desenha a bola
        gl.glPushMatrix();
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glLoadIdentity();
        gl.glTranslatef(ballX, ballY, 0.0f);
        glut.glutSolidSphere(1.5, 50, 50);
        gl.glPopMatrix();

        // Desenha a bola
        //gl.glColor3f(1.0f, 1.0f, 1.0f);
        //glut.glutSolidSphere(1, 50, 50); // Utilize glutSolidSphere para desenhar a bola
    }

}
