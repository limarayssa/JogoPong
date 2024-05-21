package view;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
//import static com.jogamp.opengl.GLProfile.GL2;
import shapes.Barra;
import shapes.Bola;

public class TelaJogo {


    Barra barra = new Barra();   
    Bola bola = new Bola();

    public void teste (GLAutoDrawable drawable) {

        GL2 gl = drawable.getGL().getGL2();
        barra.barra(drawable);
        bola.bola(drawable);
        
        
    }
}
