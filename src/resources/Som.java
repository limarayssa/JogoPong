package resources;

import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Som {

    private Clip somColisao;
    private Clip somBackground;
    private Clip somPause;
    private Clip somGameOver;
    private Clip somPerdeVida;

    public void carregarAudio() {
        try {
            //som de pause
            AudioInputStream pauseStream = AudioSystem.getAudioInputStream(getClass().getResource("/resources/audio/pause.wav"));
            somPause = AudioSystem.getClip();
            somPause.open(pauseStream);
            
            //musica de fundo
            AudioInputStream backgroundStream = AudioSystem.getAudioInputStream(getClass().getResource("/resources/audio/background.wav"));
            somBackground = AudioSystem.getClip();
            somBackground.open(backgroundStream);

            //som da bolinha
            AudioInputStream colisaoStream = AudioSystem.getAudioInputStream(getClass().getResource("/resources/audio/colisao.wav"));
            somColisao = AudioSystem.getClip();
            somColisao.open(colisaoStream);

            //som gameover
            AudioInputStream gameOverStream = AudioSystem.getAudioInputStream(getClass().getResource("/resources/audio/gameover.wav"));
            somGameOver = AudioSystem.getClip();
            somGameOver.open(gameOverStream);
            
            //som quando perde vida
            AudioInputStream perdevidaStream = AudioSystem.getAudioInputStream(getClass().getResource("/resources/audio/perdevida.wav"));
            somPerdeVida = AudioSystem.getClip();
            somPerdeVida.open(perdevidaStream);
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
        }
    }

    public void musicaFundo() {
        somBackground.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void barulhoGameover() {
        somGameOver.setFramePosition(0); // Reinicia a reprodução do som
        somGameOver.start();
    }

    public void barulhoColisao() {
        somColisao.setFramePosition(0); // Reinicia a reprodução do som
        somColisao.start();
    }

    public void barulhoPause() {
        somPause.setFramePosition(0); // Reinicia a reprodução do som
        somPause.start();
    }
    
    public void barulhoPerdeVida() {
        FloatControl volumeControl = (FloatControl) somPerdeVida.getControl(FloatControl.Type.MASTER_GAIN);
        volumeControl.setValue(-15.0f);
        somPerdeVida.setFramePosition(0); // Reinicia a reprodução do som
        somPerdeVida.start();
    }

    //construtor pra iniciar
    public Som() {
        carregarAudio();
    }

}
