package Model;

import java.awt.event.*;
import javax.swing.*;

import View.*;
import Model.*;

public class FinalizarRod implements  ActionListener{
	Regras regras;
	Dados imgdados;
	Frame f;
	JLabel dindin = null, dintot = null;
	
	public FinalizarRod(Regras regras, Frame f, JLabel dindin, JLabel dintot) {
		this.regras = regras;
		this.f = f;
		this.dindin = dindin; this.dintot = dintot;
	}
	public void actionPerformed(ActionEvent e) {
		f.repaint();
		if(regras.JogaDeNovo()==0) {
			regras.trocarRodada();
			dindin.setText("Dinheiro: R$ " + Float.toString(regras.JogDinDin(regras.rodada())));
			dintot.setText("Patrimônio Total: R$ " + Float.toString(regras.JogPatri(regras.rodada())));
		}
		f.estadoBotao(true);
		f.repaint();
	}
}
