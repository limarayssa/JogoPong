package shapes;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import view.Screens;

public class Bola {

    private GLU glu = new GLU();
    GLUT glut = new GLUT();
    private Barra barra = new Barra();
    private float ballX = -30;
    private float ballY = 30;
    private static float ballSpeedX = 0.3f;
    private static float ballSpeedY = 0.3f;
    private static int pontos;
    private static int pontosVidas = 5;
    private static boolean controleVelocidade = true;
    private Screens tela = new Screens();

    //coloca a bola em movimento
    public void bolaMovimento(GLAutoDrawable drawable) {
        GL2 gl = drawable.getGL().getGL2();

        ballX += ballSpeedX;
        ballY += ballSpeedY;

        // Desenha a bola
        gl.glPushMatrix();
        gl.glColor3f(1.0f, 1.0f, 1.0f);
        gl.glLoadIdentity();
        gl.glTranslatef(ballX, ballY, 0.0f);
        glut.glutWireSphere(1.5, 50, 5);
        gl.glPopMatrix();
        gl.glFlush();
    }

    public void bola(GLAutoDrawable drawable) {

        bolaMovimento(drawable);

        //movimenta a bola apenas quando a tela nao estiver pausada
        if (!tela.isPausado()) {
            // Verifica colisão com as paredes
            if (ballX >= 100) { // Colisão nas bordas laterais
                ballSpeedX = -ballSpeedX;
                ballX--;
                ballY++;

                somarPontos();
            }
            if (ballX <= -100) {
                ballSpeedX = -ballSpeedX;
                ballX++;
                ballY--;

                somarPontos();

            }

            //colisão com a parte de cima
            if (ballY >= 100) {
                ballSpeedY = -ballSpeedY;
                ballY--;
                ballX++;

                somarPontos();

            }
            if (ballY <= -100) {
                ballSpeedY = -ballSpeedY;
                ballY++;
                ballX--;

                somarPontos();

            }

            //calcula o meio da barra para fazer a colisão
            float ballRadius = 1.5f; // raio da bola
            float barraTop = barra.getBarraY() + barra.getBarraAltura() / 2;
            float barraBot = barra.getBarraY() - barra.getBarraAltura() / 2;
            float barraLeft = barra.getBarraX() - barra.getBarraLargura() / 2;
            float barraRight = barra.getBarraX() + barra.getBarraLargura() / 2;
            //verifica a colisão
            if (ballX + ballRadius >= barraLeft
                    && ballX - ballRadius <= barraRight
                    && ballY + ballRadius >= barraBot
                    && ballY - ballRadius <= barraTop
                    && ballX >= barra.getBarraX()
                    && ballX >= barraLeft && ballX <= barraRight) {
                ballSpeedY = -ballSpeedY; // inverte o movimento vertical
                ballY = barraTop + ballRadius; // reposiciona a bola em cima da barra

                somarPontos();
            }

            //arrumar bug da velocidade do jogo
            if (controleVelocidade) {
                if (pontos >= 200) {
                    ballSpeedX = (float) (ballSpeedX + 1);
                    ballSpeedY = (float) (ballSpeedY + 1);
                    System.out.println("Velocidade: "+ballSpeedX);
                    controleVelocidade = false;
                }
            }

            if (ballY <= barraBot && pontosVidas > 0) {
                reduzirVida();
                double random;
                double num = Math.random();
                random = num * 100;
                ballX = (float) random;
                ballY = (float) random;
                bolaMovimento(drawable);
            }

            //chama a tela de gameover
            if (pontosVidas == 0) {
                ballX = 0;
                ballY = 0;
                tela.gameOver(drawable);
            }
        }
    }

    public void somarPontos() {
        pontos += 10; // Adiciona 10 pontos ao colidir com a barra
        System.out.println(pontos);

    }

    public void reduzirVida() {
        pontosVidas -= 1;
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
