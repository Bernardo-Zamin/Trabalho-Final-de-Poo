import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Carta extends ElementoBasico {
    public boolean virada;
    public static Carta primeiraCarta;
    public static Carta segundaCarta;
    public static int contadorParesEncontrados = 0;
    public static int vitoria = 0;
    public static Tabuleiro tabuleiro;
    public String conteudo;

    public Carta(String id, String conteudo, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "carta.jpg", linInicial, colInicial, tabuleiro);
        this.conteudo = conteudo;
        this.virada = false;
        this.tabuleiro = tabuleiro;
    }

    public static void desvirarTodosPares() {
        
        for (int i = 0; i < Tabuleiro.getMaxlin(); i++) {
            for (int j = 0; j < Tabuleiro.getMaxcol(); j++) {
                ElementoBasico elemento = tabuleiro.getElementoNaPosicao(i, j);
                if (elemento instanceof Carta) {
                    Carta carta = (Carta) elemento;
                    if (carta.virada) {
                        carta.virada = false;
                        carta.setImage(Tabuleiro.createImageIcon("carta.jpg"));
                        if(i == 2 && j == 4){
                            carta.setImage(Tabuleiro.createImageIcon("porta.png"));
                        }
                    }
                }
            }
        }
        tabuleiro.atualizaVisualizacao();
        
      
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (!virada) {
            virarCarta();
            if (primeiraCarta == null) {
                primeiraCarta = this;
            } else {
                segundaCarta = this;

                if (verificarCartasIguais()) {
                    primeiraCarta = null;
                    segundaCarta = null;
                } else {
                    JOptionPane.showMessageDialog(getRootPane(), "Você errou!");

                    TimerTask task = new TimerTask() {
                        public void run() {
                            desvirarCartas();
                            primeiraCarta = null;
                            segundaCarta = null;
                        }
                    };
                    Timer timer = new Timer("DesvirarCartasTimer");
                    timer.schedule(task, 2000);
                }
            }
        }

    }

    public String getConteudo() {
        return this.conteudo;
    }

    public void virarCarta() {
        virada = true;
        setImage(Tabuleiro.createImageIcon(conteudo));
        getTabuleiro().atualizaVisualizacao();
    }

    public void desvirarCartas() {
        primeiraCarta.virada = false;
        segundaCarta.virada = false;
        primeiraCarta.setImage(Tabuleiro.createImageIcon("carta.jpg"));
        segundaCarta.setImage(Tabuleiro.createImageIcon("carta.jpg"));
        getTabuleiro().atualizaVisualizacao();
    }

    public boolean verificarCartasIguais() {
        boolean saoIguais = primeiraCarta.conteudo.equals(segundaCarta.conteudo);

        if (saoIguais) {
            contadorParesEncontrados++;

            if (contadorParesEncontrados == 6) {
                JOptionPane.showMessageDialog(getRootPane(),
                        "Você ganhou a fase 1! Agora procure uma porta para a próxima fase!");
                vitoria = 1;

            }

            primeiraCarta = null;
            segundaCarta = null;
        } else {
            TimerTask task = new TimerTask() {
                public void run() {
                    desvirarCartas();
                    primeiraCarta = null;
                    segundaCarta = null;
                }
            };
            Timer timer = new Timer("DesvirarCartasTimer");
            timer.schedule(task, 2000);
        }

        return saoIguais;
    }

    public static int getVitoria() {
        return vitoria;
    }

}
