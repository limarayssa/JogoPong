package shapes;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;

public class Barra {

    public static float barraX = -5;
    public float barraAltura = 5f;
    public int barraLargura = 20;
    public float barraY = -50 / 2 - barraAltura / 2;

    public static float barraVelocidade = 10f;

    public void barra(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

        gl.glColor3f(0, 0, 1);
        gl.glPushMatrix();
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex2f(barraX, barraY);
        gl.glVertex2f(barraX, barraY + barraAltura);
        gl.glVertex2f(barraX + barraLargura, barraY + barraAltura);
        gl.glVertex2f(barraX + barraLargura, barraY);
        gl.glPopMatrix();
        
        gl.glEnd();
    }

    public float getBarraX() {
        return barraX;
    }

    public float getBarraY() {
        return barraY;
    }

    public void setBarraX(float barraX) {
        this.barraX = barraX;
    }

    public float getBarraVelocidade() {
        return barraVelocidade;
    }

    public void setbarraVelocidade(float barraVelocidade) {
        this.barraVelocidade = barraVelocidade;
    }

    public void setBarraAltura(float barraAltura) {
        this.barraAltura = barraAltura;
    }

    public void setBarraLargura(int barraLargura) {
        this.barraLargura = barraLargura;
    }

    public void setBarraY(float barraY) {
        this.barraY = barraY;
    }

    public void setBarraVelocidade(float barraVelocidade) {
        this.barraVelocidade = barraVelocidade;
    }

    public int getBarraLargura() {
        return barraLargura;
    }

    public float getBarraAltura() {
        return barraAltura;
    }

}
