package input;

import graficos.EventListener;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.opengl.util.gl2.GLUT;
import static graficos.Renderer.init;
import resources.Som;
import shapes.Barra;
import shapes.Bola;
import view.Inicio;
import view.Screens;
import view.TelaJogo;

/**
 *
 * @author Kakugawa
 */
public class KeyBoard implements KeyListener {

    private EventListener start;
    private Screens pause = new Screens();
    private Barra barra = new Barra();
    private Bola bola = new Bola();
    private TelaJogo iniciarJogo = new TelaJogo();
    private Inicio iniciar = new Inicio();
    private Som soundFX = new Som();
    GLUT glut = new GLUT();

    public KeyBoard(EventListener start) {
        this.start = start;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
            case KeyEvent.VK_LEFT:
                if (!pause.isPausado()) {
                    if (barra.getBarraX() > - 150) {
                        barra.setBarraX(barra.getBarraX() - barra.barraVelocidade);
                    }
                }
                System.out.println(barra.getBarraX());
                break;
            case KeyEvent.VK_RIGHT:
                if (!pause.isPausado()) {
                    if (barra.getBarraX() < 100) {
                        System.out.println("setinha direita");
                        barra.setBarraX(barra.getBarraX() + barra.barraVelocidade);
                        System.out.println(barra.getBarraX());
                    }
                }
                break;
            case KeyEvent.VK_P:
                soundFX.barulhoPause();
                pause.setPausado(true);
                break;
            case KeyEvent.VK_S:
                pause.setPausado(false);
                break;
            case KeyEvent.VK_ENTER:
                iniciar.setInicio(true);
                break;
                
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
