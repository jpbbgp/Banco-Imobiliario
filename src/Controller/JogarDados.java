package Controller;


import java.awt.event.*;
import javax.swing.*;

import View.*;
import Model.*;

public class JogarDados implements  ActionListener{
	Regras regras;
	Dados imgdados;
	Frame f;
	JLabel dindin = null, dintot = null;
	
	public JogarDados(Regras regras, Frame f, JLabel dindin, JLabel dintot) {
		this.regras = regras;
		this.f = f;
		this.dindin = dindin; this.dintot = dintot;
	}
	public void actionPerformed(ActionEvent e) {
		
		regras.jogardado();
		regras.movimentar(regras.rodada());
		dindin.setText("Dinheiro: R$ " + Float.toString(regras.JogDinDin(regras.rodada())));
		dintot.setText("Patrimônio Total: R$ " + Float.toString(regras.JogPatri(regras.rodada())));
		f.estadoBotao(false);
		f.repaint();
	}
}

