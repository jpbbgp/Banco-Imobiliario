package View;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.awt.geom.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import Model.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class TelaPrincipal extends JPanel {
	BufferedImage tab = null;
	Dados dado = new Dados();
	Pinos pino = new Pinos();
	Cartas cards = new Cartas();
	Tabuleiro dadosTab = new Tabuleiro();
	private JButton vender = null;
	private JButton rolar_dados = null; 
	private JButton comprar_terreno = null;
	
	Regras regras;
	private static TelaPrincipal tela = null;
	//Cartas carta = new Cartas();
	Image circ;
	Paint cor[] = {Color.red,Color.blue,Color.orange, Color.yellow,Color.pink,Color.black};
	public  int[] x = {602,560,505,450,395,340,285,230,175,120,40,40,40,40,40,40,40,40,40,40,40,120,175,230,285,
			340,395,450,505,560,640,640,640,640,640,640,640,640,640,640};
	public int [] y = {620,620,620,620,620,620,620,620,620,620,620,540,485,430,375,320,265,210,155,100,20,20,20,20,20,20,
			20,20,20,20,20,100,155,210,265,320,375,430,485,540};
	
	public TelaPrincipal(Regras regras) {
		this.regras = regras;
	}
	public static TelaPrincipal retornaTela(Regras regras) {
		if (tela == null) {
			tela = new TelaPrincipal(regras);
		}
		return tela;
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int num;
		Graphics2D g2d = (Graphics2D) g;
		try {
			tab = ImageIO.read(getClass().getResourceAsStream("/images/tabuleiro.png"));
		  } catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		setLayout(null);
		g2d.drawImage(tab,0,0,700,700,null);
		Rectangle2D rtE=new Rectangle2D.Double(220,465,100,100);
		g2d.setPaint(cor[regras.rodada()]);
		g2d.fill(rtE);
		//Dado Direita
		Rectangle2D rtD=new Rectangle2D.Double(350,465,100,100);
		g2d.setPaint(cor[regras.rodada()]);
		g2d.fill(rtD);
		num = regras.dados[0] -1;
		g2d.drawImage(dado.Dado(num),230,475,80,80,null);
		num = regras.dados[1] -1;
		g2d.drawImage(dado.Dado(num),360,475,80,80,null);
		int lugares[] = new int[40];
		for(int i = 0; i<regras.qtd;i++) {
			int posPeao = regras.getpeao(i);
			if(posPeao != -1) {
				g2d.drawImage(pino.Pino(i),x[posPeao]+(5*lugares[posPeao]),y[posPeao],25,38,null);
				lugares[posPeao] = lugares[posPeao] + 1;
			}
		}
		int vez = regras.rodada();
		Rectangle2D textBox=new Rectangle2D.Double(710, 5, 200, 80);
		g2d.setPaint(Color.LIGHT_GRAY);
		g2d.fill(textBox);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.setColor(Color.BLACK);
		g2d.drawString("Vez do jogador:", 720, 30);
		g2d.drawImage(pino.Pino(vez),880,0,25,38,null);
		g2d.drawString(regras.nomeJog(vez), 720, 60);
		int posPeao = regras.getpeao(vez);
		int tipoLocal = dadosTab.qualtipo(posPeao);
		if(tipoLocal == 1 || tipoLocal == 3) {
			g2d.drawImage(cards.cardMapa(posPeao),725,500,175,175,null);
		}
		if(regras.teveCarta() > 0) {
			g2d.drawImage(cards.cardSR(regras.teveCarta()-1),725,500,175,175,null);
		}
	}
}
