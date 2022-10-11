package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.*;
import View.*;

public class NumPlayer extends JFrame{
	JButton n2 = new JButton("2");
	JButton n3 = new JButton("3");
	JButton n4 = new JButton("4");
	JButton n5 = new JButton("5");
	JButton n6 = new JButton("6");
	JPanel p = new JPanel();
	
	
	public NumPlayer() {
		JLabel texto=new JLabel("Selecione o Número de Jogadores");
		p.setBackground(Color.WHITE);
		p.add(texto);
		p.add(n2);
		p.add(n3);
		p.add(n4);
		p.add(n5);
		p.add(n6);
		p.setLayout(null);
		texto.setBounds(70, 50, 200, 50);
		n2.setBounds(20, 150, 50, 50);
		n2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String jogadores[] = new String[2];
				for(int i = 0; i<2;i++) {
					int j = i + 1;
					jogadores[i] = JOptionPane.showInputDialog("Digite o Nome do Jogador Número " + j);
				}
				if (!jogadores[0].isEmpty() && !jogadores[1].isEmpty()) {
					Regras regras = new Regras(2, jogadores);
					Frame jogo = new Frame(regras);
					jogo.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Nome de Jogador Inválido, Insira Novamente",
					          "Nome Inválido", JOptionPane.ERROR_MESSAGE);
					new NumPlayer();
				}
				dispose();
			}
			});
		n3.setBounds(80, 150, 50, 50);
		n3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String jogadores[] = new String[3];
				for(int i = 0; i<3;i++) {
					int j = i + 1;
					jogadores[i] = JOptionPane.showInputDialog("Digite o Nome do Jogador Número " + j);
				}
				if (!jogadores[0].isEmpty() && !jogadores[1].isEmpty() && !jogadores[2].isEmpty()) {
					Regras regras = new Regras(3, jogadores);
					Frame jogo = new Frame(regras);
					jogo.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Nome de Jogador Inválido, Insira Novamente",
					          "Nome Inválido", JOptionPane.ERROR_MESSAGE);
					new NumPlayer();
				}
				dispose();
			}
			});
		n4.setBounds(140, 150, 50, 50);
		n4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String jogadores[] = new String[4];
				for(int i = 0; i<4;i++) {
					int j = i + 1;
					jogadores[i] = JOptionPane.showInputDialog("Digite o Nome do Jogador Número " + j);
				}
				if (!jogadores[0].isEmpty() && !jogadores[1].isEmpty() && !jogadores[2].isEmpty()
						&& !jogadores[3].isEmpty()) {
					Regras regras = new Regras(4, jogadores);
					Frame jogo = new Frame(regras);
					jogo.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Nome de Jogador Inválido, Insira Novamente",
					          "Nome Inválido", JOptionPane.ERROR_MESSAGE);
					new NumPlayer();
				}
				dispose();
			}
			});
		n5.setBounds(200, 150, 50, 50);
		n5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String jogadores[] = new String[5];
				for(int i = 0; i<5;i++) {
					int j = i + 1;
					jogadores[i] = JOptionPane.showInputDialog("Digite o Nome do Jogador Número " + j);
				}
				if (!jogadores[0].isEmpty() && !jogadores[1].isEmpty() && !jogadores[2].isEmpty()
						&& !jogadores[3].isEmpty()&& !jogadores[4].isEmpty()) {
					Regras regras = new Regras(5, jogadores);
					Frame jogo = new Frame(regras);
					jogo.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Nome de Jogador Inválido, Insira Novamente",
					          "Nome Inválido", JOptionPane.ERROR_MESSAGE);
					new NumPlayer();
				}
				dispose();
			}
			});
		n6.setBounds(260, 150, 50, 50);
		n6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String jogadores[] = new String[6];
				for(int i = 0; i<6;i++) {
					int j = i + 1;
					jogadores[i] = JOptionPane.showInputDialog("Digite o Nome do Jogador Número " + j);
				}
				if (!jogadores[0].isEmpty() && !jogadores[1].isEmpty() && !jogadores[2].isEmpty()
						&& !jogadores[3].isEmpty()&& !jogadores[4].isEmpty()&& !jogadores[5].isEmpty()) {
					Regras regras = new Regras(6, jogadores);
					Frame jogo = new Frame(regras);
					jogo.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Nome de Jogador Inválido, Insira Novamente",
					          "Nome Inválido", JOptionPane.ERROR_MESSAGE);
					new NumPlayer();
				}
				dispose();
			}
			});
		getContentPane().add(p);
		pack();
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-350/2;
		int y=sa/2-300/2;
		
		setBounds(x,y,350,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}
		
}
