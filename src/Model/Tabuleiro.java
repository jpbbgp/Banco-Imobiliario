package Model;

public class Tabuleiro {
	Campos cards[];
	
	public Tabuleiro() {
		cards = new Campos[40];
		criar_campos();
		
	}
	void criar_campos() {
		cards[0] = new Campos(0,"Ponto de Partida", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		cards[1] = new Campos(1,"Leblon", -1, 1, 100, 50, 6, 30, 90, 270, 400, 500);
		cards[2] = new Campos(2,"Sorte ou Revés", -1, 2, 0, 0, 0, 0, 0, 0, 0, 0);
		cards[3] = new Campos(3,"Av. Presidente Vargas", -1, 1, 60, 50, 2, 10, 30, 90, 160, 250);
		cards[4] = new Campos(4,"Av. Nossa Senhora de Copacabana", -1, 1, 60, 50, 4, 20, 60, 180, 320, 450);
		cards[5] = new Campos(5,"Companhia Ferroviária", -1, 3, 200, 0, 50, 0, 0, 0, 0, 0);
		cards[6] = new Campos(6,"Av. Brigadeiro Faria Lima", -1, 1, 240, 150, 20, 100, 300, 750, 925, 1100);
		cards[7] = new Campos(7,"Companhia de Viação", -1, 3, 200, 0, 50, 0, 0, 0, 0, 0);
		cards[8] = new Campos(8,"Av. Rebouças", -1, 1, 220, 150, 18, 90, 250, 700, 875, 1050);
		cards[9] = new Campos(9,"Av. 9 de julho", -1, 1, 220, 150, 18, 90, 250, 700, 875, 1050);
		cards[10] = new Campos(10,"Prisão", -1, 4, 0, 0, 0, 0, 0, 0, 0, 0);
		cards[11] = new Campos(11,"Av. Europa", -1, 1, 200, 100, 16, 80, 220, 600, 800, 1000);
		cards[12] = new Campos(12,"Sorte ou Revés", -1, 2, 0, 0, 0, 0, 0, 0, 0, 0);
		cards[13] = new Campos(13,"Rua Augusta", -1, 1, 180, 100, 14, 70, 200, 550, 750, 950);
		cards[14] = new Campos(14,"Av. Pacaembú", -1, 1, 180, 100, 14, 70, 200, 550, 750, 950);
		cards[15] = new Campos(15,"Companhia de Taxi", -1, 3, 150, 0, 40, 0, 0, 0, 0, 0);
		cards[16] = new Campos(16,"Sorte ou Revés", -1, 2, 0, 0, 0, 0, 0, 0, 0, 0);
		cards[17] = new Campos(17,"Interlagos", -1, 1, 350, 200, 35, 175, 500, 1100, 1300, 1500);
		cards[18] = new Campos(18,"Lucros ou Dividendos", -1, 5, 200, 0, 0, 0, 0, 0, 0, 0);
		cards[19] = new Campos(19,"Morumbi", -1, 1, 400, 200, 50, 200, 600, 1400, 1700, 2000);
		cards[20] = new Campos(20,"Parada Livre", -1, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		cards[21] = new Campos(21,"Flamengo", -1, 1, 120, 50, 8, 40, 100, 300, 450, 600);
		cards[22] = new Campos(22,"Sorte ou Revés", -1, 2, 0, 0, 0, 0, 0, 0, 0, 0);
		cards[23] = new Campos(23,"Botafogo", -1, 1, 100, 50, 6, 30, 90, 270, 400, 500);
		cards[24] = new Campos(24,"Imposto de Renda", -1, 5, -200, 0, 0, 0, 0, 0, 0, 0);
		cards[25] = new Campos(25, "Companhia de Navegação", -1, 3, 150, 0, 40, 0, 0, 0, 0, 0);
		cards[26] = new Campos(26, "Av. Brasil", -1, 1, 160, 100, 12, 60, 180, 500, 700, 900);
		cards[27] = new Campos(27,"Sorte ou Revés", -1, 2, 0, 0, 0, 0, 0, 0, 0, 0);
		cards[28] = new Campos(28, "Av. Paulista", -1, 1, 140, 100, 10, 50, 150, 450, 625, 750);
		cards[29] = new Campos(29, "Jardim Europa", -1, 1, 140, 100, 10, 50, 150, 450, 625, 750);
		cards[30] = new Campos(30, "Vá para a Prisão", -1, 6, 0, 0, 0, 0, 0, 0, 0, 0);
		cards[31] = new Campos(31, "Copacabana", -1, 1, 260, 150, 22, 110, 330, 800, 975, 1150);
		cards[32] = new Campos(32, "Companhia de Aviação", -1, 3, 200, 0, 50, 0, 0, 0, 0, 0);
		cards[33] = new Campos(33, "Av. Vieira Souto", -1, 1, 320, 200, 28, 150, 450, 1000, 1200, 1400);
		cards[34] = new Campos(34, "Av. Atlântica", -1, 1, 300, 200, 26, 130, 390, 900, 1100, 1275);
		cards[35] = new Campos(35, "Companhia de Táxi Aéreo", -1, 3, 200, 0, 50, 0, 0, 0, 0, 0);
		cards[36] = new Campos(36, "Ipanema", -1, 1, 300, 200, 26, 130, 390, 900, 1100, 1275);
		cards[37] = new Campos(37, "Sorte ou Revés", -1, 2, 0, 0, 0, 0, 0, 0, 0, 0);
		cards[38] = new Campos(38, "Jardim Paulista", -1, 1, 280, 150, 24, 120, 360, 850, 1025, 1200);
		cards[39] = new Campos(39, "Brooklin", -1, 1, 260, 150, 22, 110, 330, 800, 975, 1150);
	}
	
	public int temdono(int ind){
		return cards[ind].getdono();
	}
	public String nomeLocal(int ind){
		return cards[ind].nome();
	}
	
	public int qualtipo(int ind){
		return cards[ind].gettipo();
	}
	public int preco_compra(int ind){
		return cards[ind].valor_compra();
	}
	public int preco_construir(int ind){
		return cards[ind].valor_construir();
	}
	public int num_hotel(int ind){
		return cards[ind].getnum_hotel();
	}
	public int num_casas(int ind){
		return cards[ind].getnum_casas();
	}
	public int aluguel(int ind){
		return cards[ind].getaluguel();
	}
	public int alug_hotel(int ind){
		return cards[ind].getalug_hotel();
	}
	public int alug_casa(int ind, int qtd){
		return cards[ind].getalug_casa()[qtd];
	}
	public void alteranum_hotel(int ind, int num){
		cards[ind].altera_hotel(num);
	}
	public void alteranum_casas(int ind, int num){
		cards[ind].altera_casa(num);
	}
	public void novo_dono(int ind, int num){
		cards[ind].altera_dono(num);
	}
	
	
}
