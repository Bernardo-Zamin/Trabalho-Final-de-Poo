import javax.swing.JOptionPane;

public class Moeda extends ElementoBasico{
    private boolean fechada;
    private int nroPista;

    public Moeda(String id, int nroPista, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "fundoPista.jpg", linInicial, colInicial, tabuleiro);
        this.fechada = true;
        this.nroPista = nroPista;
    }

    public int getNroPista(){
        return nroPista;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (fechada){
            fechada = false;
            getTabuleiro().atualizaVisualizacao();
            setImage(Tabuleiro.createImageIcon("moeda.jpg"));
            JOptionPane.showMessageDialog(getRootPane(), "Parabens Voce Encontrou uma Moeda");
        }else{
            fechada = true;
            setImage(Tabuleiro.createImageIcon("fundoPista.jpg"));
        }
        setImage(Tabuleiro.createImageIcon("fundoPista.jpg"));
    }    
}
