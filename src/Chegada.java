import javax.swing.JOptionPane;

public class Chegada extends ElementoBasico {

    private Tabuleiro tabuleiro;
    private String conteudo;
    private boolean chegada;
    private static int cont = 0;

    public Chegada(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);

        this.conteudo = "chegada.png";
        chegada = true;
        this.tabuleiro = tabuleiro;
        cont = 0;

    }

    public String getConteudo() {
        return this.conteudo;
    }

    public boolean getChegada() {
        return this.chegada;
    }

    public static int getContador() {
        return cont;
    }

    @Override
    public void acao(ElementoBasico outro) {

        if (cont == 0) {
            chegada = false;
            setImage(Tabuleiro.createImageIcon("chegada.png"));
            getTabuleiro().atualizaVisualizacao();
            cont++;
            JOptionPane.showMessageDialog(getRootPane(), "Voce chegou fim, fase 2!");

        } else {
            chegada = true;
            setImage(Tabuleiro.createImageIcon("chegada.png"));
        }

    }
}
