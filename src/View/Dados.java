package View;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class Dados {
	Image []dado = new Image[6];
	
	public Dados(){
		try {
			dado[0] = ImageIO.read(getClass().getResourceAsStream("/images/dados/die_face_1.png"));
			dado[1] = ImageIO.read(getClass().getResourceAsStream("/images/dados/die_face_2.png"));
			dado[2] = ImageIO.read(getClass().getResourceAsStream("/images/dados/die_face_3.png"));
			dado[3] = ImageIO.read(getClass().getResourceAsStream("/images/dados/die_face_4.png"));
			dado[4] = ImageIO.read(getClass().getResourceAsStream("/images/dados/die_face_5.png"));
			dado[5] = ImageIO.read(getClass().getResourceAsStream("/images/dados/die_face_6.png"));
			

		  } catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
	
	}
	public Image Dado(int valor) {
		return dado[valor];

	}
	
}
