package shapes;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import resources.Som;
import view.Screens;

public class Bola {

    private GLU glu = new GLU();
    GLUT glut = new GLUT();
    private Barra barra = new Barra();
    private float bolaX = -30;
    private float bolaY = 30;
    private static float bolaSpeedX = 0.3f;
    private static float bolaSpeedY = 0.3f;
    private static int pontos;
    private static int pontosVidas = 5;
    private static boolean controleVelocidade = true;
    private Screens tela = new Screens();
    private Som soundFX = new Som();
    private Objeto objeto = new Objeto();

    //coloca a bola em movimento
    public void bolaMovimento(GLAutoDrawable drawable) {
        if (!tela.isPausado()) {
            GL2 gl = drawable.getGL().getGL2();

            bolaX += bolaSpeedX;
            bolaY += bolaSpeedY;

            // Desenha a bola
            gl.glPushMatrix();
            gl.glColor3f(1.0f, 1.0f, 1.0f);
            gl.glLoadIdentity();
            gl.glTranslatef(bolaX, bolaY, 0.0f);
            glut.glutWireSphere(1.5, 50, 5);
            gl.glPopMatrix();
            gl.glFlush();
        }
    }

    public void bola(GLAutoDrawable drawable) {

        bolaMovimento(drawable);

        //movimenta a bola apenas quando a tela nao estiver pausada
        // Verifica colisão com as paredes
        if (bolaX >= 100) { // Colisão nas bordas laterais
            soundFX.barulhoColisao();
            bolaSpeedX = -bolaSpeedX;
            bolaX--;
            bolaY++;

            somarPontos();
        }
        if (bolaX <= -100) {
            soundFX.barulhoColisao();
            bolaSpeedX = -bolaSpeedX;
            bolaX++;
            bolaY--;

            somarPontos();

        }

        //colisão com a parte de cima
        if (bolaY >= 100) {
            soundFX.barulhoColisao();
            bolaSpeedY = -bolaSpeedY;
            bolaY--;
            bolaX++;

            somarPontos();

        }
        if (bolaY <= -100) {
            soundFX.barulhoColisao();
            bolaSpeedY = -bolaSpeedY;
            bolaY++;
            bolaX--;

            somarPontos();
        }

        //calcula o meio da barra para fazer a colisão
        float bolaRaio = 1.5f; // raio da bola
        float barraTop = barra.getBarraY() + barra.getBarraAltura() / 2;
        float barraBot = barra.getBarraY() - barra.getBarraAltura() / 2;
        float barraLeft = barra.getBarraX() - barra.getBarraLargura() / 2;
        float barraRight = barra.getBarraX() + barra.getBarraLargura() / 2;
        //verifica a colisão
        if (bolaX + bolaRaio >= barraLeft
                && bolaX - bolaRaio <= barraRight
                && bolaY + bolaRaio >= barraBot
                && bolaY - bolaRaio <= barraTop
                && bolaX >= barra.getBarraX()
                && bolaX >= barraLeft && bolaX <= barraRight) {
            soundFX.barulhoColisao();
            bolaSpeedY = -bolaSpeedY; // inverte o movimento vertical
            bolaY = barraTop + bolaRaio; // reposiciona a bola em cima da barra

            somarPontos();
        }

        //arrumar bug da velocidade do jogo
        if (controleVelocidade) {
            if (pontos >= 200) {
                bolaSpeedX = (float) (bolaSpeedX + 1);
                bolaSpeedY = (float) (bolaSpeedY + 1);
                System.out.println("Velocidade: " + bolaSpeedX);
                controleVelocidade = false;
            }
        }
        
//        if(pontos >= 20) {
//            //GLAutoDrawable drawables;
//            objeto.teapot(drawable);
//            colisaoBule();
//        }

        if (bolaY <= barraBot && pontosVidas > 0) {
            reduzirVida();
            double random;
            double num = Math.random();
            random = num * 100;
            bolaX = (float) random;
            bolaY = (float) random;
            bolaMovimento(drawable);
        }

        //chama a tela de gameover
        if (pontosVidas == 0) {
            bolaX = 0;
            bolaY = 0;
            tela.gameOver(drawable);
        }

    }

    public void colisaoBule() {
        float bolaCentroX = bolaX;
        float bolaCentroY = bolaY;
        float buleCentroX = -1.5f;
        float buleCentroY = 30.0f;
        float bolaRaio = 1.5f;
        float buleRaio = 25.0f;

        //calcula distancia entre bule e bola
        float distanciaCentros = (float) Math.sqrt(Math.pow(buleCentroX - buleCentroX, 2) + Math.pow(buleCentroY - buleCentroY, 2));

        //cria a colisao entre eles
        if (distanciaCentros < bolaRaio + buleRaio) {
            //Inverte a direção da bola
            bolaSpeedX = -bolaSpeedX;
            bolaSpeedY = -bolaSpeedY;
        }
    }

    public void somarPontos() {
        pontos += 10; // Adiciona 10 pontos ao colidir com a barra
        System.out.println(pontos);

    }

    public void reduzirVida() {
        pontosVidas -= 1;
        soundFX.barulhoPerdeVida();
        System.out.println("Vidas: " + pontosVidas);
    }

    public static int getPontos() {
        return pontos;
    }

    public static void setPontos(int pontos) {
        Bola.pontos = pontos;
    }

    public static int getPontosVidas() {
        return pontosVidas;
    }

    public static void setPontosVidas(int vidas) {
        Bola.pontosVidas = pontosVidas;
    }

}
