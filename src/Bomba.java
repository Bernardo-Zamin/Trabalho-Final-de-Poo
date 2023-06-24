import javax.swing.JOptionPane;

public class Bomba extends ElementoBasico {

    private Tabuleiro tabuleiro;
    private boolean fechada;
    private int nroPista;

    public Bomba(String id, int nroPista, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "grama.jpg", linInicial, colInicial, tabuleiro);
        this.fechada = true;
        this.nroPista = nroPista;
        this.tabuleiro = tabuleiro;
    }

    public int getNroPista() {
        return nroPista;
    }


    @Override
    public void acao(ElementoBasico outro) {
        if (fechada) {
            fechada = false;
            setImage(Tabuleiro.createImageIcon("armadilha.jpg"));
            getTabuleiro().atualizaVisualizacao();
            JOptionPane.showMessageDialog(getRootPane(),
                    "( ͡° ͜ʖ ͡°) Você caiu em uma armadilha! Tente novamente! ( ͡° ͜ʖ ͡°)");
            

        } else {
            fechada = true;
            setImage(Tabuleiro.createImageIcon("grama.jpg"));
            getTabuleiro().atualizaVisualizacao();
        }
        setImage(Tabuleiro.createImageIcon("gramaAux.jpg"));
        getTabuleiro().atualizaVisualizacao();
    }

}
