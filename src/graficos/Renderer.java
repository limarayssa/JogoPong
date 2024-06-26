package graficos;

import input.KeyBoard;
import com.jogamp.newt.event.WindowAdapter;
import com.jogamp.newt.event.WindowEvent;
import com.jogamp.newt.opengl.GLWindow;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.util.FPSAnimator;

/**
 *
 * @author Kakugawa
 */
public class Renderer {

    private static GLWindow window = null;

    //public static int screenWidth = 600;  //MODIFICADO
    public static int screenWidth = 600;
    public static int screenHeight = 600;
    
    //public static int screenHeight = 600; //MODIFICADO 

    //Cria a janela de rendeziração do JOGL
    public static void init() {

        GLProfile.initSingleton();
        GLProfile profile = GLProfile.get(GLProfile.GL2);
        GLCapabilities caps = new GLCapabilities(profile);
        window = GLWindow.create(caps);
        window.setFullscreen(true);
        //window.setSize(screenWidth, screenWidth);
        window.setResizable(true);

        EventListener start = new EventListener();

        window.addGLEventListener(start); //adiciona os listeners na janela  
        //Habilita o teclado
        window.addKeyListener(new KeyBoard(start));
        window.setTitle("Jogo de pong");

        //window.requestFocus();
        FPSAnimator animator = new FPSAnimator(window, 60);
        animator.start(); //inicia o loop de animação

        //encerrar a aplicacao adequadamente
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowDestroyNotify(WindowEvent e) {
                animator.stop();
                System.exit(0);
            }
        });

        window.setVisible(true);
    }

    public static void main(String[] args) {
        init();
    }
}
