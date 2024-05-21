package input;

import graficos.EventListener;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import shapes.Barra;

/**
 *
 * @author Kakugawa
 */
public class KeyBoard implements KeyListener {

    private EventListener start;

    private Barra barra = new Barra();

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
                //195 meu monitor
                if (barra.getBarraX() > - 150) {
                    barra.setBarraX(barra.getBarraX() - barra.barraVelocidade);
                }
                System.out.println(barra.getBarraX());
                break;
            case KeyEvent.VK_RIGHT:
                //175 meu monitor
                if (barra.getBarraX() < 150) {
                    System.out.println("setinha direita");
                    barra.setBarraX(barra.getBarraX() + barra.barraVelocidade);
                    System.out.println(barra.getBarraX());
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
