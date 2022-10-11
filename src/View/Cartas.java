package View;
import java.awt.*;
import java.io.*;
import javax.imageio.*;

public class Cartas {
	Image []cardsMapa = new Image[40];
	Image []cardsSR = new Image[30];
	
	public Cartas(){
		try {
			cardsMapa[1] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Leblon.png"));
			cardsMapa[3] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Av. Presidente Vargas.png"));
			cardsMapa[4] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Av. Nossa S. de Copacabana.png"));
			cardsMapa[5] = ImageIO.read(getClass().getResourceAsStream("/images/companhias/company1.png"));
			cardsMapa[6] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Av. Brigadero Faria Lima.png"));
			cardsMapa[7] = ImageIO.read(getClass().getResourceAsStream("/images/companhias/company2.png"));
			cardsMapa[8] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Av. Rebouças.png"));
			cardsMapa[9] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Av. 9 de julho.png"));
			cardsMapa[11] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Av. Europa.png"));
			cardsMapa[13] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Rua Augusta.png"));
			cardsMapa[14] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Av. Pacaembú.png"));
			cardsMapa[15] = ImageIO.read(getClass().getResourceAsStream("/images/companhias/company3.png"));
			cardsMapa[17] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Interlagos.png"));
			cardsMapa[19] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Morumbi.png"));
			cardsMapa[21] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Flamengo.png"));
			cardsMapa[23] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Botafogo.png"));
			cardsMapa[25] = ImageIO.read(getClass().getResourceAsStream("/images/companhias/company4.png"));
			cardsMapa[26] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Av. Brasil.png"));
			cardsMapa[28] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Av. Paulista.png"));
			cardsMapa[29] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Jardim Europa.png"));
			cardsMapa[31] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Copacabana.png"));
			cardsMapa[32] = ImageIO.read(getClass().getResourceAsStream("/images/companhias/company5.png"));
			cardsMapa[33] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Av. Vieira Souto.png"));
			cardsMapa[34] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Av. Atlântica.png"));
			cardsMapa[35] = ImageIO.read(getClass().getResourceAsStream("/images/companhias/company6.png"));
			cardsMapa[36] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Ipanema.png"));
			cardsMapa[38] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Jardim Paulista.png"));
			cardsMapa[39] = ImageIO.read(getClass().getResourceAsStream("/images/territorios/Brooklin.png"));
			
			cardsSR[0] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance1.png"));
			cardsSR[1] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance2.png"));
			cardsSR[2] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance3.png"));
			cardsSR[3] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance4.png"));
			cardsSR[4] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance5.png"));
			cardsSR[5] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance6.png"));
			cardsSR[6] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance7.png"));
			cardsSR[7] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance8.png"));
			cardsSR[8] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance9.png"));
			cardsSR[9] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance10.png"));
			cardsSR[10] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance11.png"));
			cardsSR[11] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance12.png"));
			cardsSR[12] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance13.png"));
			cardsSR[13] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance14.png"));
			cardsSR[14] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance15.png"));
			cardsSR[15] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance16.png"));
			cardsSR[16] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance17.png"));
			cardsSR[17] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance18.png"));
			cardsSR[18] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance19.png"));
			cardsSR[19] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance20.png"));
			cardsSR[20] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance21.png"));
			cardsSR[21] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance22.png"));
			cardsSR[22] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance23.png"));
			cardsSR[23] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance24.png"));
			cardsSR[24] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance25.png"));
			cardsSR[25] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance26.png"));
			cardsSR[26] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance27.png"));
			cardsSR[27] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance28.png"));
			cardsSR[28] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance29.png"));
			cardsSR[29] = ImageIO.read(getClass().getResourceAsStream("/images/sorteReves/chance30.png"));

		  } catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
	
	}
	public Image cardMapa(int valor) {
		return cardsMapa[valor];
	}
	
	public Image cardSR(int valor) {
		return cardsSR[valor];
	}
	
}
