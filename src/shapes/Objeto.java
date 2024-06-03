package shapes;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.gl2.GLUT;

public class Objeto {

    GLUT glut = new GLUT();
    

    public void teapot(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();
        gl.glPushMatrix();
        gl.glTranslatef(-1.5f, 30f, -6.0f);
        glut.glutWireTeapot(25.0);
        gl.glPopMatrix();

    }
}
