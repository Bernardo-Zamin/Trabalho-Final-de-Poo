import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class ElementoBasico extends JButton {
    private Tabuleiro tabuleiro;
    private String id;
    private ImageIcon imagem;
    private int lin;
    private int col;
    private String conteudo;


    public ElementoBasico(String id, String iconPath, int linInicial, int colInicial, Tabuleiro tabuleiro) {
        this.id = id;
        this.imagem = Tabuleiro.createImageIcon(iconPath);
        this.setIcon(this.imagem);
        this.setIcon(resize(imagem, 50, 50));
        this.lin = linInicial;
        this.col = colInicial;
        this.tabuleiro = tabuleiro;
        this.conteudo = iconPath;
        this.addActionListener(e -> System.out.println(this.toString()));
    }

    public String getConteudo(){
        return conteudo;
    }

    private ImageIcon resize(ImageIcon imagem, int largura, int altura) {
        Image img = imagem.getImage();
        Image novaImagem = img.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(novaImagem);
    }

    public ImageIcon getImagem() {
        return this.imagem;
    }

    public void setImage(ImageIcon imagem) {
        this.imagem = imagem;
        this.setIcon(imagem);
    }

    public String getId() {
        return id;
    }

    public int getLin() {
        return lin;
    }

    public void incLin() {
        if (lin < Tabuleiro.getMaxlin() - 1) {
            lin++;
        }
    }

    public void decLin() {
        if (lin > 0) {
            lin--;
        }
    }

    public void incCol() {
        if (col < Tabuleiro.getMaxcol() - 1) {
            col++;
        }
    }

    public void decCol() {
        if (col > 0) {
            col--;
        }
    }

    public int getCol() {
        return col;
    }

    public  Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public abstract void acao(ElementoBasico outro);

}
