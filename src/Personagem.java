import javax.swing.JOptionPane;

public class Personagem extends ElementoBasico {
    private ElementoBasico anterior;
    private int linInicial, colInicial;

    public Personagem(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        super(id, iconPath, linInicial, colInicial, tabuleiro);
    }

    public void setAnterior(ElementoBasico anterior) {
        this.anterior = anterior;
    }

    public void setLin(int linInicial) {
        this.linInicial = linInicial;

    }

    public void setCol(int colInicial) {
        this.colInicial = colInicial;

    }

    public void moveDireita() {
        // Remove o Personagem da posição atual e avança
        getTabuleiro().insereElemento(anterior);
        this.incCol();
        // Verifica se tem algum elemento de interesse na nova posição
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (elemento instanceof Fundo || elemento.getConteudo().equals("grama.jpg")
                || elemento.getConteudo().equals("porta2.png")
                || (elemento instanceof Chegada || elemento.getConteudo().equals("chegada.png"))) {
            this.anterior = getTabuleiro().insereElemento(this);
        } else {
            if (Carta.getVitoria() == 1 && elemento instanceof Carta
                    && ((Carta) elemento).getConteudo().equals("porta.png")) {
                this.anterior = getTabuleiro().insereElemento(this);
                if (((Carta) elemento).getConteudo().equals("portaTroll.png")) {
                    this.anterior = getTabuleiro().insereElemento(this);
                }
                if (Chegada.getContador() != 0 && elemento instanceof Chegada
                        && elemento.getConteudo().equals("chegada.png")) {
                    this.anterior = getTabuleiro().insereElemento(this);

                }
            } else {
                elemento.acao(this);
                this.decCol();
                this.anterior = getTabuleiro().insereElemento(this);
            }
        }

    }

    public void moveEsquerda() {
        // Remove o Personagem da posição atual e avança
        getTabuleiro().insereElemento(anterior);
        this.decCol();
        // Verifica se tem algum elemento de interesse na nova posição
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (elemento instanceof Fundo || elemento.getConteudo().equals("grama.jpg")
                || elemento.getConteudo().equals("porta2.png")
                || (elemento instanceof Chegada || elemento.getConteudo().equals("chegada.png"))) {
            this.anterior = getTabuleiro().insereElemento(this);
        } else {
            if (Carta.getVitoria() == 1 && elemento instanceof Carta
                    && ((Carta) elemento).getConteudo().equals("porta.png")) {
                this.anterior = getTabuleiro().insereElemento(this);
                if (((Carta) elemento).getConteudo().equals("portaTroll.png")) {
                    this.anterior = getTabuleiro().insereElemento(this);
                }
                if (Chegada.getContador() != 0 && elemento instanceof Chegada
                        && elemento.getConteudo().equals("chegada.png")) {

                    this.anterior = getTabuleiro().insereElemento(this);

                }
            } else {
                elemento.acao(this);
                this.incCol();
                this.anterior = getTabuleiro().insereElemento(this);
            }
        }

    }

    public void moveCima() {
        // Remove o Personagem da posição atual e avança
        getTabuleiro().insereElemento(anterior);
        this.decLin();
        // Verifica se tem algum elemento de interesse na nova posição
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (elemento instanceof Fundo || elemento.getConteudo().equals("grama.jpg")
                || elemento.getConteudo().equals("porta2.png")
                || (elemento instanceof Chegada || elemento.getConteudo().equals("chegada.png"))) {
            this.anterior = getTabuleiro().insereElemento(this);
        } else {
            if (Carta.getVitoria() == 1 && elemento instanceof Carta
                    && ((Carta) elemento).getConteudo().equals("porta.png")) {
                this.anterior = getTabuleiro().insereElemento(this);
                if (((Carta) elemento).getConteudo().equals("portaTroll.png")) {
                    this.anterior = getTabuleiro().insereElemento(this);
                }
                if (Chegada.getContador() != 0 && elemento instanceof Chegada
                        && elemento.getConteudo().equals("chegada.png")) {

                    this.anterior = getTabuleiro().insereElemento(this);

                }
            } else {
                elemento.acao(this);
                this.incLin();
                this.anterior = getTabuleiro().insereElemento(this);
            }
        }

    }

    public void moveBaixo() {
        // Remove o Personagem da posição atual e avança
        getTabuleiro().insereElemento(anterior);
        this.incLin();
        // Verifica se tem algum elemento de interesse na nova posição
        // e interage de acordo
        ElementoBasico elemento = getTabuleiro().getElementoNaPosicao(this.getLin(), this.getCol());
        if (elemento instanceof Fundo || elemento.getConteudo().equals("grama.jpg")
                || elemento.getConteudo().equals("porta2.png")
                || (elemento instanceof Chegada || elemento.getConteudo().equals("chegada.png"))) {
            this.anterior = getTabuleiro().insereElemento(this);
        } else {
            if (Carta.getVitoria() == 1 && elemento instanceof Carta
                    && ((Carta) elemento).getConteudo().equals("porta.png")) {
                this.anterior = getTabuleiro().insereElemento(this);
                if (((Carta) elemento).getConteudo().equals("portaTroll.png")) {
                    this.anterior = getTabuleiro().insereElemento(this);
                }
                if (Chegada.getContador() != 0 && elemento instanceof Chegada
                        && elemento.getConteudo().equals("chegada.png")) {

                    this.anterior = getTabuleiro().insereElemento(this);

                }
            } else {
                elemento.acao(this);
                this.decLin();
                this.anterior = getTabuleiro().insereElemento(this);
            }
        }

    }

    public int getPosX() {
        int posx = getLin();
        return posx;

    }

    public int getPosY() {
        int posy = getCol();
        return posy;

    }

    public void setPosX(int posX) {
        setLin(posX);
    }

    public void setPosY(int posY) {
        setCol(posY);
    }

    @Override
    public void acao(ElementoBasico outro) {

    }
}
