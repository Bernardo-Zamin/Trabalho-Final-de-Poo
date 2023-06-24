import javax.sound.sampled.*;
import javax.swing.JOptionPane;

public class Saida extends ElementoBasico {

    private static final String VITORIA = "VITORIA.wav";
    private static final String DERROTA = "DERROTA.wav";

    public Saida(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (FilhoCanguru.getCont() >= 5) {
            playSound(VITORIA);
            JOptionPane.showMessageDialog(null, "Você Ganhou o Jogo! Parabéns!");
            
            System.exit(0);
        } else {
            playSound(DERROTA);
            JOptionPane.showMessageDialog(null, "Está deixando seus filhos para trás...");
            
        }
    }

    private void playSound(String soundPath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource(soundPath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
