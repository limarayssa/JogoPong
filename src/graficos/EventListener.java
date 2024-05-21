package graficos;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT; //ADICIONADO (primitivas 3D)
import java.awt.Color;
import shapes.Barra;
import view.Background;
import view.Inicio;
import view.TelaJogo;

/**
 *
 * @author Kakugawa
 */
public class EventListener implements GLEventListener {

    private float xMin, xMax, yMin, yMax, zMin, zMax;
    GLU glu;
    float angulo; //ADICIONADO
    Inicio inicio = new Inicio();
    Barra barra = new Barra();
    TelaJogo telaInicial = new TelaJogo();
    Background fundoTela = new Background();
    

    @Override
    public void init(GLAutoDrawable drawable) {
        //dados iniciais da cena
        glu = new GLU();
        GL2 gl = drawable.getGL().getGL2(); //ADICIONADO
        //Estabelece as coordenadas do SRU (Sistema de Referencia do Universo)
        xMin = yMin = zMin = -100; //MODIFICADO
        xMax = yMax = zMax = 100; //MODIFICADO

        //ADICIONADO (Habilita o buffer de profundidade)
        gl.glEnable(GL2.GL_DEPTH_TEST);
        gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
        gl.glDepthFunc(GL2.GL_LEQUAL);

        angulo = 0;
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        //obtem o contexto Opengl
        GL2 gl = drawable.getGL().getGL2();
        GLUT glut = new GLUT(); //ADICIONADO (objeto para desenho 3D)

        /* //iniciar nas instruções
        inicio.telaInicial(gl); */
        
        telaInicial.teste(drawable);

        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        //obtem o contexto grafico Opengl
        GL2 gl = drawable.getGL().getGL2();

        //evita a divisão por zero
        if (height == 0) {
            height = 1;
        }
        //calcula a proporção da janela (aspect ratio) da nova janela
        float aspect = (float) width / height;

        //seta o viewport para abranger a janela inteira
        gl.glViewport(0, 0, width, height);

        //ativa a matriz de projeção
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity(); //lê a matriz identidade

        //Projeção ortogonal
        //true:   aspect >= 1 configura a altura de -1 para 1 : com largura maior
        //false:  aspect < 1 configura a largura de -1 para 1 : com altura maior
        if (width >= height) {
            gl.glOrtho(xMin * aspect, xMax * aspect, yMin, yMax, zMin, zMax);
        } else {
            gl.glOrtho(xMin, xMax, yMin / aspect, yMax / aspect, zMin, zMax);
        }
        
        

        //ativa a matriz de modelagem
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity(); //lê a matriz identidade
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
    }
}
