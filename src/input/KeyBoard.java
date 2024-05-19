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
                System.out.println("setinha esquerda");
                barra.setBarraX(barra.getBarraX() - barra.barraVelocidade);
                System.out.println(barra.getBarraX());
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println("setinha direita");
                barra.setBarraX(barra.getBarraX() + barra.barraVelocidade);

                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
