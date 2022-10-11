package View;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.*;
import javax.swing.border.Border;



public class Painel extends JPanel implements ActionListener{
	private static Painel painel = null;
	private JLabel rodada = new JLabel(); 
	private JLabel dinheiro = new JLabel("Dinheiro do jogador: R$");
	private JLabel status = new JLabel("---------   Status -----------------------"); 
	private JLabel proprietario = new JLabel("");
	private JLabel preco = new JLabel("");
	private JButton vender = null;
	private JButton rolar_dados = null; 
	private JButton comprar_terreno = null;
	private ArrayList<JButton> adc_casa = new ArrayList<JButton>();
	private ArrayList<JButton> vender_casa = new ArrayList<JButton>();
	private JButton adc_hotel = null; 
	private JButton encerrar_jogada = null;
	
	private ArrayList<Integer> terrenoPosition = new ArrayList<Integer>();
	private boolean ready = false; 
	private BufferedImage i = null; 
	private JComboBox<String> propList = new JComboBox();
	private JLabel prisao = new JLabel("PRESO!");
	
	private Painel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		rolar_dados = new JButton("Rolar Dado");
		comprar_terreno = new JButton("Comprar Terreno"); 
		
		adc_hotel = new JButton("Adcionar Hotel"); 
		encerrar_jogada = new JButton("Encerrar Jogada"); 
		vender = new JButton("Vender"); 
		JLabel props = new JLabel("Lista de Propriedades:"); 
		JLabel addCasa_lbl = new JLabel ("Adcionar Casa em Cor:");
		
		rolar_dados.setVisible(false);
		encerrar_jogada.setVisible(false);
		comprar_terreno.setVisible(false);
		addCasa_lbl.setVisible(false);
		
		adc_hotel.setVisible(false);
		vender.setVisible(false);
		prisao.setVisible(false);
		
		add(rolar_dados); 
		add(rodada);
		add(dinheiro);
		add(prisao); 
		add(props); 
		add(propList); 
		add(vender); 
		add(addCasa_lbl); 
		
		for(int i=0; i<8; i++) { 
			JButton b = new JButton();
			adc_casa.add(b); 
			adc_casa.get(i).setVisible(false);
			add(adc_casa.get(i));
			adc_casa.get(i).addActionListener(this);

			JButton c = new JButton();
			vender_casa.add(c); 
			vender_casa.get(i).setVisible(false);
			add(vender_casa.get(i));
			vender_casa.get(i).addActionListener(this);
		}

		add(status); 
		add(preco); 
		add(comprar_terreno); 
		add(adc_hotel); 
		add(proprietario); 
		add(Box.createVerticalGlue());
		add(encerrar_jogada);
		
		propList.addActionListener(this);
		rolar_dados.addActionListener(this);
		encerrar_jogada.addActionListener(this);
		comprar_terreno.addActionListener(this);
		vender.addActionListener(this);
		
		rodada.setText("Rodada:");
	}
	public static Painel mudarPainel() {
		if (painel == null)
			painel = new Painel(); 
		return painel;
	}
	public void showAdcCasa(boolean v, int i, String cor) {
		adc_casa.get(i).setVisible(v); 
		adc_casa.get(i).setText(cor);
	}
	
	public void showLiberdade() { 
		JOptionPane.showMessageDialog(null, 
                "LIBERDADE!", 
                "CARTA PASSE LIVRE!", 
                JOptionPane.WARNING_MESSAGE);
	}
	public void showPrisao(boolean v) { 
		prisao.setVisible(v); 
	}
	
	public void showRolarDados(boolean v) { 
		rolar_dados.setVisible(v);
	}
	
	public void showEncerrarJog(boolean v) { 
		encerrar_jogada.setVisible(v);
	}
	public void loadAndShowPropList(ArrayList<String>props) { 
		for(int i =0; i<props.size(); i++) { 
			propList.addItem(props.get(i)); 
		}
	}
	public void zeraPropList() {
		propList.removeAllItems();
	}
	
	public void showAdcHotel(boolean v) {
		adc_hotel.setVisible(v); 
	}
	public void showComprarTerreno(boolean v) { 
		comprar_terreno.setVisible(v); 
	}

	public void showProprietario(boolean v) { 
		proprietario.setVisible(false);
	}

	public void showTerrenoStats(String prop ) { 
		proprietario.setText("Proprietario: " + prop); 
		proprietario.setVisible(true);
	}
	
	public void setCartaImage(BufferedImage carta) { 
		i = carta; 
		ready = true; 
		repaint(); 
	}
	public void setReady(boolean b) {
		ready = b ; 
	}
	public void showPreco(String p, boolean b) {
		preco.setText("Preco:" + p);
		preco.setVisible(b); 
	}
	
	public void showVender(boolean b) {
		vender.setVisible(b);
	}

	public void setSaldo(int saldo) {
		dinheiro.setText("Dinheiro: $ " + Integer.toString(saldo));
		dinheiro.setVisible(true);
	}

	public void showFaliu(String cor) {
		JOptionPane.showMessageDialog(null, 
                "Jogador" + cor + "faliu ", 
                "Fim de Jogo para voce", 
                JOptionPane.WARNING_MESSAGE);	
	}

	public void showFaltaDin() {
		JOptionPane.showMessageDialog(null, 
               "Voce nao possui saldo suficiente", 
                "Faltou!", 
                JOptionPane.WARNING_MESSAGE);
	}

	public void showVencedor() {
		JOptionPane.showMessageDialog(null, 
	               "Temos um vencedor!", 
	                "Fim de Jogo", 
	                JOptionPane.WARNING_MESSAGE);
	}
	
	public void showMaxCasa() {
		JOptionPane.showMessageDialog(null, 
	               "Esta compra não pode ser efetuada."
	               + "Você já possui o número máximo de casas neste terreno.", 
	                "Eita", 
	                JOptionPane.WARNING_MESSAGE);
	}
	
	public void showNaoHaSaldo() {
		JOptionPane.showMessageDialog(null, 
	               "Esta compra não pode ser efetuada."
	               + "Você não possui saldo o suficiente.", 
	                "Faltou!", 
	                JOptionPane.WARNING_MESSAGE);
		
	}
	public void showHotel() {
		JOptionPane.showMessageDialog(null, 
	               "Parabéns, você acaba de adcionar um hotel! Você atingiu o número máximo de casas para este terreno.", 
	                "Hotel!", 
	                JOptionPane.WARNING_MESSAGE);
		
	}
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    	Graphics2D g2d = (Graphics2D) g;
	    	if( ready == true) { 
	    	g2d.drawImage(i, 0 , 450, 130, 200 , null);
	    	}
	}
	//public void adcCasa(String cor) { 
	//	Fachada.getFachada().getPropListCor(cor); 
	//}
	//public void venderCasa(String cor) { 
	//	Fachada.getFachada().getPropListCor(cor); 
	//}
	
	public void actionPerformed(ActionEvent e) {
	    if(e.getSource() == rolar_dados) { 
	    	//Rodada.getRodada().RodadaNormal();
	    }
	}
	

	public void remAdcCasa(String nome) {
		for(int i =0; i<adc_casa.size(); i++) { 
			if(adc_casa.get(i).getText().equals(nome))
				adc_casa.get(i).setVisible(false);
		}
		
	}

}

