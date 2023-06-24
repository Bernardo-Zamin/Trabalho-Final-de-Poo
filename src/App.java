import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

public class App extends JFrame implements ActionListener {
    private Tabuleiro tabuleiro;
    private Personagem personagem;

    public App() {
        super();
        // Define os componentes da tela
        tabuleiro = new Tabuleiro();

        JPanel botoesDirecao = new JPanel(new FlowLayout());
        JButton butDir = new JButton("Direita");
        butDir.addActionListener(this);
        JButton butEsq = new JButton("Esquerda");
        butEsq.addActionListener(this);
        JButton butCima = new JButton("Acima");
        butCima.addActionListener(this);
        JButton butBaixo = new JButton("Abaixo");
        butBaixo.addActionListener(this);
        botoesDirecao.add(butEsq);
        botoesDirecao.add(butDir);
        botoesDirecao.add(butCima);
        botoesDirecao.add(butBaixo);

        JPanel painelGeral = new JPanel();
        painelGeral.setLayout(new BoxLayout(painelGeral, BoxLayout.PAGE_AXIS));
        painelGeral.add(tabuleiro);
        painelGeral.add(botoesDirecao);

        // Insere o personagem no tabuleiro
        personagem = new Personagem("Canguru", "canguru.jpg", 2, 2, tabuleiro);
        ElementoBasico anterior = tabuleiro.insereElemento(personagem);
        personagem.setAnterior(anterior);

        String[] imagensCartas = {
                "mike (1).png", "bob.jpg", "tio.jpg", "patrick.jpg", "porta.png", "porta.png",
                "tio.jpg", "dora.jpg", "bob.jpg", "mike (1).png", "dora.jpg",
                "patrick.jpg"
        };

        Carta[][] matrizCartas = new Carta[5][5];
        PisoSemFuncao[][] pisoSemFuncaoo = new PisoSemFuncao[5][5];
        Grama[][] grama = new Grama[43][43];
        Muro[][] muro = new Muro[17][17];
        FilhoCanguru[][] filhoCanguru = new FilhoCanguru[10][10];
        Bomba armadilha1 = new Bomba("armadilha1", 2, 5, 6, tabuleiro);
        Bomba armadilha2 = new Bomba("Bomba2", 22, 7, 6, tabuleiro);
        Saida saida = new Saida("saida", "saida.jpg", 7, 0, tabuleiro);

        tabuleiro.insereElemento(armadilha1);
        tabuleiro.insereElemento(armadilha2);
        tabuleiro.insereElemento(saida);

        int[] posicoesXFilhoCanguru = { 5, 5, 5, 8, 9 };
        int[] posicoesYFilhoCanguru = { 0, 1, 4, 2, 0 };

        for (int i = 0; i < posicoesXFilhoCanguru.length; i++) {
            int x = posicoesXFilhoCanguru[i];
            int y = posicoesYFilhoCanguru[i];
            filhoCanguru[x][y] = new FilhoCanguru("filhocanguru", "cangurufilho.jpg", x, y, tabuleiro, 5);
            tabuleiro.insereElemento(filhoCanguru[x][y]);
        }

        if (personagem.getPosX() == 5 && personagem.getPosY() == 6) {
            Bomba armadilhaAUx = new Bomba("armadilha1", 2, 5, 6, tabuleiro);
            armadilhaAUx.acao(personagem);
        }

        if (personagem.getPosX() == 7 && personagem.getPosY() == 6) {
            Bomba armadilhaAUx = new Bomba("Bomba2", 22, 7, 6, tabuleiro);

            armadilhaAUx.acao(personagem);

        }

        int[] posicoesX = { 0, 0, 0, 1, 2, 3, 4, 4, 4, 3, 2, 1 };
        int[] posicoesY = { 1, 2, 3, 4, 4, 4, 3, 2, 1, 0, 0, 0 };

        // Random rand = new Random();

        for (int i = 0; i < posicoesX.length; i++) {
            int x = posicoesX[i];
            int y = posicoesY[i];
            String imagemFrente = imagensCartas[i];
            matrizCartas[x][y] = new Carta("Carta", imagemFrente, x, y, tabuleiro);
            tabuleiro.insereElemento(matrizCartas[x][y]);
            matrizCartas[4][2] = new Carta("Porta1", "portaTroll.png", x, y, tabuleiro);
            matrizCartas[4][3] = new Carta("Porta", "porta.png", x, y, tabuleiro);
        }


        
        int[] posicoesXpisosemf = { 0, 0, 4, 4 };
        int[] posicoesYpisosemf = { 0, 4, 0, 4 };

        for (int i = 0; i < posicoesXpisosemf.length; i++) {
            int x = posicoesXpisosemf[i];
            int y = posicoesYpisosemf[i];
            pisoSemFuncaoo[x][y] = new PisoSemFuncao("pisosemfuncao", x, y, tabuleiro);
            tabuleiro.insereElemento(pisoSemFuncaoo[x][y]);
        }

        // FECHAR A PORTA DA FASE 1 USANDO UM CONTADOR COM A FASE 2

        int[] posicoesXgrama = { 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 2, 2, 3, 4, 3, 4, 5, 6, 7, 9, 9, 9, 5,
                5, 6, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 1, 1, 1, 2, 2, 3, 3, 3 };
        int[] posicoesYgrama = { 5, 6, 7, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 5, 5, 6, 7, 6, 6, 7, 7, 7, 7, 7, 8, 7, 6, 2,
                3, 0, 1, 2, 3, 4, 1, 2, 3, 4, 0, 1, 3, 4, 1, 2, 3, 4, 1, 2, 3, 1, 3, 1, 2, 3 };

        for (int i = 0; i < posicoesXgrama.length; i++) {
            int x = posicoesXgrama[i];
            int y = posicoesYgrama[i];
            grama[x][y] = new Grama("grama", "grama.jpg", x, y, tabuleiro);
            tabuleiro.insereElemento(grama[x][y]);

        }

        int[] posicoesXmuro = { 3, 4, 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 8, 8, 8, 6, 6 };
        int[] posicoesYmuro = { 5, 5, 6, 7, 8, 8, 8, 8, 8, 8, 8, 8, 7, 6, 5, 5, 6 };

        for (int i = 0; i < posicoesXmuro.length; i++) {
            int x = posicoesXmuro[i];
            int y = posicoesYmuro[i];
            muro[x][y] = new Muro("muro", "muro.jpg", x, y, tabuleiro);
            tabuleiro.insereElemento(muro[x][y]);
        }

        Chegada chegada = new Chegada("Chegada", "chegada.png", 9, 5, tabuleiro);
        ChegadaFake1 chegadafake1 = new ChegadaFake1("chegadafake", "chegadaFake.png", 7, 5, tabuleiro);
        ChegadaFake1 chegadafake2 = new ChegadaFake1("chegadafak2", "chegadaFake.png", 5, 5, tabuleiro);
        tabuleiro.insereElemento(chegadafake1);
        tabuleiro.insereElemento(chegadafake2);
        tabuleiro.insereElemento(chegada);

        // ------------------------------------------

        this.add(painelGeral);

        this.setSize(1100, 1100);
        this.setTitle("Jogo Demo");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        tabuleiro.atualizaVisualizacao();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        boolean resetouJogo = false;
        JButton but = (JButton) arg0.getSource();
        if (but.getText().equals("Direita")) {
            personagem.moveDireita();
        }
        if (but.getText().equals("Esquerda")) {
            personagem.moveEsquerda();
        }
        if (but.getText().equals("Acima")) {
            personagem.moveCima();
        }
        if (but.getText().equals("Abaixo")) {
            personagem.moveBaixo();
        }

        // Verificar se o personagem chegou na posição desejada
        if (personagem.getPosX() == 3 && personagem.getPosY() == 4) {
            JOptionPane.showMessageDialog(this,
                    "( ͡° ͜ʖ ͡°) Porta errada, você foi trolado! Repita toda a memória(ou não, descubra...)( ͡° ͜ʖ ͡°)");
            Carta.desvirarTodosPares();
            Porta porta = new Porta("PortaNova", "portaTroll.png", 4, 2, tabuleiro);
            tabuleiro.atualizaVisualizacao();
            resetouJogo = true;
        }
        if (personagem.getPosX() == 5 && personagem.getPosY() == 6) {
            Bomba armadilhaAUx = new Bomba("armadilha1", 2, 5, 6, tabuleiro);
            tabuleiro.insereElemento(armadilhaAUx);
            armadilhaAUx.acao(personagem);
            personagem.setLin(2);
            personagem.setCol(5);
            ElementoBasico anterior = tabuleiro.insereElemento(personagem);
            personagem.setAnterior(anterior);
            tabuleiro.atualizaVisualizacao();

            boolean caiuNaTrap = true;
        }
        if (personagem.getPosX() == 7 && personagem.getPosY() == 6) {
            Bomba armadilhaAUx = new Bomba("Bomba2", 22, 7, 6, tabuleiro);
            tabuleiro.insereElemento(armadilhaAUx);
            armadilhaAUx.acao(personagem);
            ElementoBasico anterior = tabuleiro.insereElemento(personagem);
            personagem.setAnterior(anterior);
            tabuleiro.atualizaVisualizacao();

            boolean caiuNaTrap1 = true;
        }

        // if (personagem.getPosX() == 7 && personagem.getPosY() == 6) {
        // JOptionPane.showMessageDialog(this, "( ͡° ͜ʖ ͡°) Saída errada, você foi
        // trolado! Procure outra saída! ( ͡° ͜ʖ ͡°)");
        // }
        if (personagem.getPosX() == 9 && personagem.getPosY() == 5) {
            JOptionPane.showMessageDialog(this,
                    "Parabéns! Você passou da segunda fase! Agora, finalize a ultima fase para vencer o jogo!");
            JOptionPane.showMessageDialog(this,
                    "Seus filhos estão logo ali! Resgate-os, um a um, colocando-os em sua bolsa de canguru. Quando acabar de coletar seus filhos, fuja da floresta!");
        }

        tabuleiro.atualizaVisualizacao();

    }

    public void actionSelectClick(ActionEvent arg0) {
        JButton but = (JButton) arg0.getSource();

    }

    public boolean resetaJogo() {
        if (personagem.getPosX() == 3 && personagem.getPosY() == 4) {
            JOptionPane.showMessageDialog(this, "Você errou a porta, repita a memoria novamente!");
            Carta.desvirarTodosPares();
            tabuleiro.atualizaVisualizacao();
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}