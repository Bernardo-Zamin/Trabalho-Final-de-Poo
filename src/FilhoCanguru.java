import javax.swing.JOptionPane;

public class FilhoCanguru extends ElementoBasico {

    private String conteudo;
    private static int contadorFilhosCapturados = 0;
    private int totalFilhos;
    private boolean todosFilhosCapturados = false;
    private boolean chegada = true;
    private static int cont = 0;

    public FilhoCanguru(String id, String conteudo, int linInicial, int colInicial, Tabuleiro tabuleiro,
            int totalFilhos) {
        super(id, "cangurufilho.jpg", linInicial, colInicial, tabuleiro);
        this.conteudo = conteudo;
        this.totalFilhos = totalFilhos;
    }

    public String getConteudo() {
        return this.conteudo;
    }

    public static int getCont() {
        return cont;
    }

    @Override
    public void acao(ElementoBasico outro) {
        if (chegada) {
            chegada = false;

            cont++;
           
            setImage(Tabuleiro.createImageIcon("grama.jpg"));
            getTabuleiro().atualizaVisualizacao();

            if (contadorFilhosCapturados == totalFilhos) {
                todosFilhosCapturados = true;
            }

        } else {
            chegada = true;
            setImage(Tabuleiro.createImageIcon("grama.jpg"));
        }
    }

    public boolean todosFilhosCapturados() {
        return todosFilhosCapturados;
    }
}
