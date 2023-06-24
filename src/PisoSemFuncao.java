public class PisoSemFuncao extends ElementoBasico {

    // private boolean fechada;

    private PisoSemFuncao matriz[][];

    public PisoSemFuncao(String id, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "piso2.jpg", linInicial, colInicial, tabuleiro);
        Carta matriz[][] = new Carta[5][5];
    }

    @Override
    public void acao(ElementoBasico outro) {

    }

}