package Controller;
import java.awt.event.*;
import View.*;

public class ReiniciarJogo implements ActionListener {
	Frame f;
	public ReiniciarJogo(Frame f){
		this.f = f;
	}

	public void actionPerformed(ActionEvent e) {
		PainelInicial novo = new PainelInicial();
		novo.setVisible(true);
		f.dispose();
	}

}
