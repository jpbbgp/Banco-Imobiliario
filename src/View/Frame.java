package View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
import Model.*;
import View.Frame;
import Controller.*;

public class Frame extends JFrame {
	public final int LARG_DEFAULT=1200;
	public final int ALT_DEFAULT=700;
	static Frame frame = null;
	Tabuleiro tab = null;
	TelaPrincipal p;  
	JPanel bot;
	JPanel hist;
	Regras regras;
	JButton dados = new JButton("Jogar Dados"), vez = new JButton("Encerrar Vez");
	JButton casa = new JButton("Comprar Casa"), hotel = new JButton("Comprar Hotel");
	JButton territorio = new JButton("Comprar Território"), comp = new JButton("Comprar Companhia");
	JButton Vendcomp = new JButton("Vender Companhia"), VendTerri = new JButton("Vender Território");
	JButton Finalizar = new JButton("Finalizar Jogo");
	JLabel dindin = new JLabel(""), dintot = new JLabel(""), nTerri = new JLabel("");
	JLabel nComp = new JLabel("");
	TelaPrincipal t = null;
	
	public Frame(Regras regras) {
		setTitle("Banco Imobiliario");
		this.regras = regras;
		JMenuBar menubar = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem novo =  new JMenuItem("Novo jogo"), salvar = new JMenuItem("Salvar");
		dindin.setBounds(950,0,200,50); dintot.setBounds(950,30,200,50);
		dados.setBounds(710,100,200,50); vez.setBounds(710,100,200,50);
		territorio.setBounds(710,440,200,50); VendTerri.setBounds(710,440,200,50);
		Vendcomp.setBounds(710,440,200,50); comp.setBounds(710,440,200,50);
		casa.setBounds(710,100,200,50); hotel.setBounds(710,150,200,50);
		Finalizar.setBounds(920,440,200,50);
		
		dados.addActionListener(new JogarDados(regras,this, dindin, dintot));
		vez.addActionListener(new FinalizarRod(regras,this, dindin, dintot));
		
		territorio.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	regras.comprar_imov();
		    	territorio.setVisible(false);
		    	dindin.setText("Dinheiro: R$ " + Float.toString(regras.JogDinDin(regras.rodada())));
		    	dintot.setText("Patrimônio Total: R$ " + Float.toString(regras.JogPatri(regras.rodada())));
		    	JOptionPane.showMessageDialog(null,"Parabéns, você comprou um território","Comprou Território",JOptionPane.WARNING_MESSAGE);
		    	repaint();
		    }
		});
		comp.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	regras.comprar_imov();
		    	comp.setVisible(false);
		    	dindin.setText("Dinheiro: R$ " + Float.toString(regras.JogDinDin(regras.rodada())));
		    	dintot.setText("Patrimônio Total: R$ " + Float.toString(regras.JogPatri(regras.rodada())));
		    	JOptionPane.showMessageDialog(null,"Parabéns, você comprou uma companhia","Comprou Território",JOptionPane.WARNING_MESSAGE);
		    	repaint();
		    }
		});
		VendTerri.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	regras.vender_imov();
		    	VendTerri.setVisible(false); casa.setVisible(false); hotel.setVisible(false);
		    	dindin.setText("Dinheiro: R$ " + Float.toString(regras.JogDinDin(regras.rodada())));
		    	dintot.setText("Patrimônio Total: R$ " + Float.toString(regras.JogPatri(regras.rodada())));
		    	JOptionPane.showMessageDialog(null,"Você vendeu um território","Vendeu Território",JOptionPane.WARNING_MESSAGE);
		    	repaint();
		    }
		});
		Vendcomp.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	regras.vender_imov();
		    	Vendcomp.setVisible(false);
		    	dindin.setText("Dinheiro: R$ " + Float.toString(regras.JogDinDin(regras.rodada())));
		    	dintot.setText("Patrimônio Total: R$ " + Float.toString(regras.JogPatri(regras.rodada())));
		    	JOptionPane.showMessageDialog(null,"Você vendeu uma companhia","Vendeu Território",JOptionPane.WARNING_MESSAGE);
		    	repaint();
		    }
		});
		Finalizar.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	String campeoes[] = new String[regras.qtd];
		    	campeoes = regras.ver_ganhador();
		    	String mensagem = "";
		    	for(int i = 0; i < regras.qtd; i++) {
		    		int j = i + 1;
		    		mensagem = mensagem + j + " Colocado: " + campeoes[i] + "\n";
		    	}
		    	JOptionPane.showMessageDialog (null, mensagem);
		    	dispose();
		    }
		});
		
		
		
		
		
		add(dados); add(vez); add(casa); add(territorio); add(comp); add(hotel);
		add(VendTerri); add(Vendcomp); add(dindin); add(dintot); add(Finalizar);
		
		Vendcomp.setVisible(false); VendTerri.setVisible(false); comp.setVisible(false);
		vez.setVisible(false); casa.setVisible(false); territorio.setVisible(false);
		hotel.setVisible(false); dindin.setVisible(true); dintot.setVisible(true);
		Finalizar.setVisible(true);
		
		dindin.setText("Dinheiro: R$ " + Float.toString(regras.JogDinDin(regras.rodada())));
		dintot.setText("Patrimônio Total: R$ " + Float.toString(regras.JogPatri(regras.rodada())));
		
		menu.add(novo);
		menu.add(salvar);
		menubar.add(menu);
		novo.addActionListener(new ReiniciarJogo(this));			
		//salvar.addActionListener(new Salvar(this, regras));
		setJMenuBar(menubar);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULT/2;
		int y=sa/2-ALT_DEFAULT/2;
		/*Painel do jogo*/
		p = new TelaPrincipal(regras);
		//p.addMouseListener(new Rodada(regras,this));
		getContentPane().add(p);
		setBounds(x,y,LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void estadoBotao(boolean j) {
		dados.setVisible(j);
		vez.setVisible(!j);
		if(regras.PodeCasa()==1) {
			casa.setVisible(!j);
		}
		if(regras.PodeHotel()==1) {
			hotel.setVisible(!j);
		}
		if(regras.PodeComprar()==1) {
			int tipo = regras.RetTipo();
			if(tipo == 1) {
				territorio.setVisible(!j);
			}
			else if(tipo == 3) {
				comp.setVisible(!j);
			}
		}
		if(regras.PodeVender()==1) {
			int tipo = regras.RetTipo();
			if(tipo == 1) {
				VendTerri.setVisible(!j);
			}
			else if(tipo == 3) {
				Vendcomp.setVisible(!j);
			}
		}
	}
	
}