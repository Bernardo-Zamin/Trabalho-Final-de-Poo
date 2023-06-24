public class Grama extends ElementoBasico {

    private String conteudo;

    public Grama(String id, String conteudo, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, "grama.jpg", linInicial, colInicial, tabuleiro);
        this.conteudo = conteudo;
       
    }

    public String getConteudo(){
        return this.conteudo;
    }

    @Override
    public void acao(ElementoBasico outro) {
        
    }
    
}
