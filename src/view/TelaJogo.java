package view;

import com.jogamp.opengl.GLAutoDrawable;
import shapes.Barra;

public class TelaJogo {

    Barra barra = new Barra();
    

    public void teste (GLAutoDrawable drawable) {

        barra.barra(drawable);
        
    }
}
