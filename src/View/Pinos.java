package View;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class Pinos {
	Image []pino = new Image[6];
	
	public Pinos(){
		try {
			pino[0] = ImageIO.read(getClass().getResourceAsStream("/images/pinos/pin0.png"));
			pino[1] = ImageIO.read(getClass().getResourceAsStream("/images/pinos/pin1.png"));
			pino[2] = ImageIO.read(getClass().getResourceAsStream("/images/pinos/pin2.png"));
			pino[3] = ImageIO.read(getClass().getResourceAsStream("/images/pinos/pin3.png"));
			pino[4] = ImageIO.read(getClass().getResourceAsStream("/images/pinos/pin4.png"));
			pino[5] = ImageIO.read(getClass().getResourceAsStream("/images/pinos/pin5.png"));
			

		  } catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
	
	}
	public Image Pino(int valor) {
		return pino[valor];

	}
	
}
