import javax.swing.JOptionPane;

public class ChegadaFake1 extends ElementoBasico {

    private String conteudo;
    private boolean chegada;
    private Tabuleiro tabuleiro;
    private int cont;

    public ChegadaFake1(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
        
        this.conteudo = "chegadaFake.png";
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

    public  int getContador() {
        return cont;
    }

    @Override
    public void acao(ElementoBasico outro) {

        if (cont == 0) {
            chegada = false;
            setImage(Tabuleiro.createImageIcon("chegadaFake.png"));
            getTabuleiro().atualizaVisualizacao();
            cont++;
      

        } else {
            chegada = true;
            setImage(Tabuleiro.createImageIcon("chegadaFake.png"));
        }

    }
    
}
