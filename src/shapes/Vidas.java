/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapes;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 *
 * @author Rayssa
 */
public class Vidas {
    
    public void vidas(GLAutoDrawable drawable) {
     GL2 gl = drawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT);

        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, 0.0f, -6.0f);

        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(1.0f, 0.0f, 0.0f);

        // Draw the upper part of the heart
        gl.glVertex3f(-0.5f, 0.5f, 0.0f);
        gl.glVertex3f(0.5f, 0.5f, 0.0f);
        gl.glVertex3f(0.0f, 1.2f, 0.0f);

        // Draw the left bottom part of the heart
        gl.glVertex3f(-0.5f, 0.5f, 0.0f);
        gl.glVertex3f(0.0f, -0.5f, 0.0f);
        gl.glVertex3f(-1.0f, -1.5f, 0.0f);

        // Draw the right bottom part of the heart
        gl.glVertex3f(0.5f, 0.5f, 0.0f);
        gl.glVertex3f(0.0f, -0.5f, 0.0f);
        gl.glVertex3f(1.0f, -1.5f, 0.0f);

        gl.glEnd();
        gl.glFlush();
    
    }
           
}
