import javax.swing.JOptionPane;

public class Bau extends ElementoBasico {
    private int nroPista;
    private static int tentativas = 0;

    public Bau(String id, int nroPista, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "bau.png", linInicial, colInicial, tabuleiro);
        this.nroPista = nroPista;
    }

    public int getNroPista() {
        return nroPista;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (tentativas == 3){
            JOptionPane.showMessageDialog(getRootPane(), "Muitas tentativas, você perdeu!");
            System.exit(0);
        }
        String codigo = JOptionPane.showInputDialog(getRootPane(), "Digite quantas moedas voce achou: ");
        if (codigo.equals("3")) {
            setImage(Tabuleiro.createImageIcon("baucompleto.jpg"));
            getTabuleiro().atualizaVisualizacao();
            JOptionPane.showMessageDialog(getRootPane(), "Parabens você ganhou");
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(getRootPane(), "Código inválido! Continue tentando");
        }
        tentativas++;
    }
}
