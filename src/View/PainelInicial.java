package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PainelInicial extends JFrame{  
	/**
	 * 
	 */
	private static final long serialVersionUID = -6198423022429519141L;
	public int LARG_DEFAULTini=800;
	public int ALT_DEFAULTini=600;
	JPanel p = new JPanel(); //*
	
	JButton b1 = new JButton("Carregar Partida");
	JButton b2 = new JButton("Novo Jogo");

	public PainelInicial() {
		super("Banco Imobiliario"); //*
		JLabel texto=new JLabel("Bem vindo ao Jogo Banco Imobiliario");
		texto.setFont(new Font("Arial", Font.BOLD, 33));
		setSize(LARG_DEFAULTini,ALT_DEFAULTini);//*
		p.setLayout(null);
		texto.setBounds(100, 150, 600, 50);
		b1.setBounds(200, ALT_DEFAULTini/2, 150, 50);
		//b1.addActionListener((ActionListener) new LoadGame(this));
		b2.setBounds(400, ALT_DEFAULTini/2, 150, 50);
		b2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new NumPlayer();
				dispose();
			}
			});
		p.add(texto);
		p.add(b1);//*
		p.add(b2);//*
		getContentPane().add(p);
		pack();
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_DEFAULTini/2;
		int y=sa/2-ALT_DEFAULTini/2;
		
		setBounds(x,y,LARG_DEFAULTini,ALT_DEFAULTini);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
