import javax.swing.JOptionPane;

public class Dica extends ElementoBasico {
    private boolean fechada;
    private int nroPista;

    public Dica(String id, int nroPista, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "dica.png", linInicial, colInicial, tabuleiro);
        this.fechada = true;
        this.nroPista = nroPista;
    }

    public int getNroPista() {
        return nroPista;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (fechada) {
            fechada = false;
            getTabuleiro().atualizaVisualizacao();
            setImage(Tabuleiro.createImageIcon("dica.png"));
            JOptionPane.showMessageDialog(getRootPane(), "Tome cuidado, tem mais de uma bomba presente no terreno!");
            
        } else {
            fechada = true;
            setImage(Tabuleiro.createImageIcon("dica.png"));
        }
        setImage(Tabuleiro.createImageIcon("dica.png"));
    }

}
