package shapes;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;

public class PlacarVidas {

    Bola bola = new Bola();

    //chamada das classes de vida, usando o parâmetro do número de vidas para mostrar na tela
    public void vidas(GLAutoDrawable drawable, int vidasRestantes) {
        
        vidasRestantes = bola.getPontosVidas();

        vida1(drawable, vidasRestantes >= 1);
        vida2(drawable, vidasRestantes >= 2);
        vida3(drawable, vidasRestantes >= 3);
        vida4(drawable, vidasRestantes >= 4);
        vida5(drawable, vidasRestantes == 5);

    }

    //booleana que mostra o coração caso o númeor de vidas seja correspondente
    public void vida1(GLAutoDrawable drawable, boolean coracao) {
        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT(); // objeto para desenho 3D

        if (coracao) {

            gl.glColor3f(1.0f, 0.0f, 0.0f); // Vermelho

            //primeiro círculo
            gl.glPushMatrix();
            gl.glTranslatef(34.5f, -90, 0);
            glut.glutSolidSphere(1.5, 20, 20);
            gl.glPopMatrix();

            //segundo círculo
            //3f de diferença entre os corações
            gl.glPushMatrix();
            gl.glTranslatef(37.5f, -90, 0);
            glut.glutSolidSphere(1.5, 20, 20);
            gl.glPopMatrix();

            //triangulo pra juntar o coração
            //-1.5f do primeiro coração, 6f para o segundo vertex e o terceiro vertex é o meio entre eles
            gl.glBegin(GL2.GL_TRIANGLES);
            gl.glVertex3f(33f, -90.5f, 0);
            gl.glVertex3f(39f, -90.5f, 0);
            gl.glVertex3f(36f, -93.5f, 0);
            gl.glEnd();
            gl.glFlush();
        }

    }

    public void vida2(GLAutoDrawable drawable, boolean drawHeart) {
        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();

        if (drawHeart) {

            gl.glColor3f(1.0f, 0.0f, 0.0f); // Vermelho

            //primeiro círculo
            //6f a mais entre o outro coração, 3f de diferença entre os corações
            gl.glPushMatrix();
            gl.glTranslatef(43.5f, -90, 0);
            glut.glutSolidSphere(1.5, 20, 20);
            gl.glPopMatrix();

            //segundo círculo
            gl.glPushMatrix();
            gl.glTranslatef(46.5f, -90, 0);
            glut.glutSolidSphere(1.5, 20, 20);
            gl.glPopMatrix();

            //triangulo pra juntar o coração
            //-1.5f do primeiro coração, 6f para o segundo vertex e o terceiro vertex é o meio entre eles
            gl.glBegin(GL2.GL_TRIANGLES);
            gl.glVertex3f(42f, -90.5f, 0);
            gl.glVertex3f(48f, -90.5f, 0);
            gl.glVertex3f(45f, -93.5f, 0);
            gl.glEnd();
            gl.glFlush();
        }
    }

    public void vida3(GLAutoDrawable drawable, boolean drawHeart) {
        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();

        if (drawHeart) {
            gl.glColor3f(1.0f, 0.0f, 0.0f); // Vermelho

            //primeiro círculo
            //6f a mais entre o outro coração, 3f de diferença entre os corações
            gl.glPushMatrix();
            gl.glTranslatef(52.5f, -90, 0);
            glut.glutSolidSphere(1.5, 20, 20);
            gl.glPopMatrix();

            //segundo círculo
            gl.glPushMatrix();
            gl.glTranslatef(55.5f, -90, 0);
            glut.glutSolidSphere(1.5, 20, 20);
            gl.glPopMatrix();

            //triangulo pra juntar o coração
            //-1.5f do primeiro coração, 6f para o segundo vertex e o terceiro vertex é o meio entre eles
            gl.glBegin(GL2.GL_TRIANGLES);
            gl.glVertex3f(51f, -90.5f, 0);
            gl.glVertex3f(57f, -90.5f, 0);
            gl.glVertex3f(54f, -93.5f, 0);
            gl.glEnd();
            gl.glFlush();
        }
    }

    public void vida4(GLAutoDrawable drawable, boolean drawHeart) {
        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();

        if (drawHeart) {
            gl.glColor3f(1.0f, 0.0f, 0.0f); // Vermelho

            //primeiro círculo
            //6f a mais entre o outro coração, 3f de diferença entre os corações
            gl.glPushMatrix();
            gl.glTranslatef(61.5f, -90, 0);
            glut.glutSolidSphere(1.5, 20, 20);
            gl.glPopMatrix();

            //segundo círculo
            gl.glPushMatrix();
            gl.glTranslatef(64.5f, -90, 0);
            glut.glutSolidSphere(1.5, 20, 20);
            gl.glPopMatrix();

            //triangulo pra juntar o coração
            //-1.5f do primeiro coração, 6f para o segundo vertex e o terceiro vertex é o meio entre eles
            gl.glBegin(GL2.GL_TRIANGLES);
            gl.glVertex3f(60f, -90.5f, 0);
            gl.glVertex3f(66f, -90.5f, 0);
            gl.glVertex3f(63f, -93.5f, 0);
            gl.glEnd();
            gl.glFlush();
        }
    }

    public void vida5(GLAutoDrawable drawable, boolean drawHeart) {
        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT();

        if (drawHeart) {

            gl.glColor3f(1.0f, 0.0f, 0.0f); // Vermelho

            //primeiro círculo
            //6f a mais entre o outro coração, 3f de diferença entre os corações
            gl.glPushMatrix();
            gl.glTranslatef(70.5f, -90, 0);
            glut.glutSolidSphere(1.5, 20, 20);
            gl.glPopMatrix();

            //segundo círculo
            gl.glPushMatrix();
            gl.glTranslatef(73.5f, -90, 0);
            glut.glutSolidSphere(1.5, 20, 20);
            gl.glPopMatrix();

            //triangulo pra juntar o coração
            //-1.5f do primeiro coração, 6f para o segundo vertex e o terceiro vertex é o meio entre eles
            gl.glBegin(GL2.GL_TRIANGLES);
            gl.glVertex3f(69f, -90.5f, 0);
            gl.glVertex3f(75f, -90.5f, 0);
            gl.glVertex3f(72f, -93.5f, 0);
            gl.glEnd();
            gl.glFlush();
        }
    }

}
