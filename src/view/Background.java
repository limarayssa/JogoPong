package view;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;

public class Background {


    public void fundo(GL2 gl) {
        //define a cor da janela (R, G, G, alpha)
        gl.glClearColor(0, 0, 0.1f, 1);
    }
}
