package Model;

import java.util.Random;


public class Jogo{
    Random random = new Random();
    int dado[] = new int[2], banco = 200000, indice[] = {0,1,2,3,4,5};
    int qtd, ind = 0, qtdElim = 0, ultJogadSR = -1, indUltSR = -1, Jogcomcarta = 0;
    Jogador jog[];
	Tabuleiro tabuleiro;
    char cor[] = {'V','A','L','Y','R','P'}; /*Vermelho, Azul, Laranja, Yellow, Roxo, Preto*/
	int tirouCarta = -1, jogaDeNovo = 0, podeComprar = 0, podeCasa = 0, podeHotel = 0;
	int podeVender = 0, tipo = -1, jogInd = 0, pos_nova = -1;
	String jogadores[]= null;
	
    public Jogo(int qtd, String[] jogadores){
        this.qtd = qtd;
        jog = new Jogador[qtd];
        tabuleiro = new Tabuleiro();
        for(int i = 0; i<qtd; i++) {
        	jog[i] = new Jogador(cor[i], 4000, 0, jogadores[i]);
        }
    }
    
    
    public int[] jogardado(){
        this.dado[0] = random.nextInt(6)+1;
        this.dado[1] = random.nextInt(6)+1;
        return dado;
    }
	
	public int getpeao(int ind_jog){
		return jog[ind_jog].getposicao();
	}
	
	public int rodada() {
		return indice[ind];
	}
	
	public String nomeJog(int ind_jog) {
		return jog[ind_jog].nomeJog();
	}
	public void trocarRodada() {
		this.ind = (ind+1)%qtd;
		System.out.println(ind);
	}
	
	public void comprar_imov(){
		float valor = (float) tabuleiro.preco_compra(pos_nova);
		jog[jogInd].aumentaDinProp(valor);
		jog[jogInd].diminui_dinheiro(valor);
		tabuleiro.novo_dono(pos_nova, jogInd);
		if(tabuleiro.qualtipo(pos_nova) == 1) {
			tabuleiro.alteranum_hotel(pos_nova, 0);
			tabuleiro.alteranum_casas(pos_nova, 0);
		}
	}
	
	public void vender_imov(){
		float valor = 0;
		if(tabuleiro.qualtipo(pos_nova) == 1) {
			valor = (float) tabuleiro.preco_compra(pos_nova) + ((tabuleiro.num_casas(pos_nova) +  tabuleiro.num_hotel(pos_nova)) * tabuleiro.preco_construir(pos_nova));
			tabuleiro.alteranum_hotel(pos_nova, 0);
			tabuleiro.alteranum_casas(pos_nova, 0);
		}
		else if (tabuleiro.qualtipo(pos_nova) == 3) {
			valor = (float) tabuleiro.preco_compra(pos_nova);
		}
		jog[jogInd].diminuiDinProp(valor);
		valor = (float) (valor * 0.9);
		int vendedor = tabuleiro.temdono(pos_nova);
		jog[vendedor].aumenta_dinheiro(valor);
		tabuleiro.novo_dono(pos_nova, -1);
		
	}
	
	void eliminar_jogador(int ind_jog){
		for(int i=0;i<40;i++){
			if(tabuleiro.temdono(i) == ind_jog){
				tabuleiro.novo_dono(i, -1);
				tabuleiro.alteranum_hotel(i, 0);
				tabuleiro.alteranum_casas(i, 0);
			}
		}
		qtdElim += 1;
		jog[ind_jog].eliminar_jog();
	}
	
	void pagamento(int ind_jog, int somadados, int tipo){
		int hotel, casas;
		float valor = 0;
		int dono = tabuleiro.temdono(pos_nova);
		if (tipo == 1){
			hotel = tabuleiro.num_hotel(pos_nova);
			casas = tabuleiro.num_casas(pos_nova);
			valor = tabuleiro.aluguel(pos_nova);
			if (casas != 0){
				valor += tabuleiro.alug_casa(pos_nova, casas);
			}
			if (hotel != 0){
				valor += tabuleiro.alug_hotel(pos_nova);
			}
		}
		else if (tipo == 3){
			valor = somadados * tabuleiro.aluguel(pos_nova);
		}
		float dindin_jog = jog[ind_jog].dinheiro_vivo();
		if(valor <= dindin_jog){
			jog[ind_jog].diminui_dinheiro(valor);
			jog[dono].aumenta_dinheiro(valor);
		}
		else{
			dindin_jog = jog[ind_jog].dinheiro_totalcomdesconto();
			if(valor <= dindin_jog){
				System.out.println("Jogador tem que vender alguma propriedade para continuar no jogo!!!");
				/* Fazer codigo para venda de propriedades para continuar no jogo*/
				jog[dono].aumenta_dinheiro(valor);
			}
			else{
				System.out.println("Jogador não tem dinheiro suficiente, ELIMINADO!!!");
				eliminar_jogador(ind_jog);
				jog[dono].aumenta_dinheiro(dindin_jog);
			}
		}
	}
	
	public void mandar_prisao(int ind_jog){
		jog[ind_jog].prender_soltar(1);
		jog[ind_jog].movimenta(10);
	}
	
	public void liberdade_prisao(int ind_jog, int dado1, int dado2){
		if(jog[ind_jog].prisao_carta() == 1 || jog[ind_jog].prisao_tempo() > 3 || dado1 == dado2){
			if(jog[ind_jog].prisao_tempo() > 3) {
				jog[ind_jog].diminui_dinheiro(50);
			}
			if(jog[ind_jog].prisao_carta() == 1) {
				this.Jogcomcarta = 0;
			}
			jog[ind_jog].prender_soltar(0);
		}
	}
	public void movimentar(int ind_jog, int dado1, int dado2){
		tirouCarta = 0;
		podeComprar = 0;
		podeVender = 0;
	    podeCasa = 0;
	    podeHotel = 0;
	    jogInd = ind_jog;
		liberdade_prisao(ind_jog, dado1, dado2);
		if(jog[ind_jog].preso_ousolto() == 0) {
			int pos_atual = jog[ind_jog].getposicao();
			int somadados;
			somadados = dado1 + dado2;
			if( pos_atual + somadados < 40){
				pos_nova = pos_atual + somadados;
			}
			else{
				pos_nova = pos_atual + somadados - 40;
				jog[ind_jog].aumenta_dinheiro(200); /* Passou do ponto de partida ganhou dindin*/
				this.banco -= 200;
			}
			tipo = tabuleiro.qualtipo(pos_nova);
			if(tipo == 1 || tipo == 3) {
				if(tabuleiro.temdono(pos_nova) != -1 && tabuleiro.temdono(pos_nova) != ind_jog){
					pagamento(ind_jog, somadados, tipo);
				}
				else if(tabuleiro.temdono(pos_nova) == ind_jog && tipo == 3) {
					podeVender = 1;
				}
				else if(tabuleiro.temdono(pos_nova) == ind_jog && tipo == 1){
					System.out.println("Jogador pode comprar casa ou hotel para o local!!!");
					if(tabuleiro.num_casas(pos_nova) > 5) {
						podeCasa = 1;
					}
					podeVender = 1;
					if(tabuleiro.num_casas(pos_nova) > 0) {
						podeHotel = 1;
					}
				}
				else if(tabuleiro.temdono(pos_nova) == -1){
					System.out.println("Não tem que pagar aluguel, mas jogador pode comprar o local!!!");
					/* Fazer codigo para jogador decidir se quer comprar ou não o campo atual*/
					podeComprar = 1;
				}
			}
			else if(tipo == 2){
				System.out.println("Vai receber uma carta de Sorte ou Reves!!!");
				Sorteoupenalidades(ind_jog);
				
			}
			else if(tipo == 5){
				if(pos_nova == 18){ /* Lucros ou dividendos*/
					jog[ind_jog].aumenta_dinheiro(200);
					this.banco -= 200;
				}
				else{
					jog[ind_jog].aumenta_dinheiro(-200); /* Imposto de renda*/
					this.banco += 200;
				}
			}
			else if(tipo == 6){
				mandar_prisao(ind_jog);
				pos_nova = 10;
			}
			jog[ind_jog].movimenta(pos_nova);
			
		}
		else {
			jog[ind_jog].aumenta_tempo();
		}
		if(dado1 == dado2) {
			jog[ind_jog].aumenta_dadoSeq();
			if(jog[ind_jog].qtd_dadoSeq() >= 3) {
				mandar_prisao(ind_jog);
			}
			else {
				jogaDeNovo = 1;
			}
		}
		else {
			jog[ind_jog].zera_dadoSeq();
			jogaDeNovo = 0;
		}
	}
	
	public int JogaDeNovo(){
		return jogaDeNovo;
	}
	
	public int PodeComprar() {
		return podeComprar;
	}
	public float JogDinDin(int ind) {
		return jog[ind].dinheiro_vivo();
	}
	public float JogPatri(int ind) {
		return jog[ind].dinheiro_total();
	}
	
	public int PodeVender() {
		return podeVender;
	}
	public int PodeCasa() {
		return podeCasa;
	}
	
	public int PodeHotel() {
		return podeHotel;
	}
	
	public int RetTipo() {
		return tipo;
	}
    
    public boolean ganhou(){ /*vai verificar se os outros jogadores estao eliminados*/
    	int comp = 0;
        for(int i = 0; i<qtd; i++) {
        	if(jog[i].jog_elim()) {
        		comp++;
        	}
        }
        return comp == (qtd - 1);
    }
	
    public String[] ver_ganhador() { /* caso jogo acabe antecipadamente, quem tem mais dinheiro ganha*/
		float[] valores = new float[qtd];
		float aux1;
		String campeoes[] = new String[qtd];
		int min, j;
		String aux2;
		for(int i=0;i<qtd;i++){
			campeoes[i] = jog[i].nomeJog();
			valores[i] = jog[i].dinheiro_total();
		}
    	for(int i=0;i<(i+qtd);i++){
			min = i;
			for(j=(i+1);j<qtd;j++){
				if(valores[j]<valores[min]){
					min = j;
				}
			}
			if(i!= min){
				aux1 = valores[i];
				aux2 = campeoes[i];
				valores[i] = valores[min];
				campeoes[i] = campeoes[min];
				valores[min] = aux1;
				campeoes[min] = aux2;
			}
		}
    	return campeoes;
    }
    public int teveCarta(){
    	return tirouCarta;
    }
    
    public void Sorteoupenalidades(int ind) {
    	indUltSR = random.nextInt(30)+1;
    	tirouCarta = indUltSR;
    	while(indUltSR == 9 && Jogcomcarta == 1) {
    		indUltSR = random.nextInt(30)+1;
    	}
		ultJogadSR = ind;
		if(indUltSR == 1) {
			jog[ind].aumenta_dinheiro(25);
			this.banco -= 25;
		}
		if(indUltSR == 2) {
			jog[ind].aumenta_dinheiro(150);
			this.banco -= 150;
		}
		if(indUltSR == 3) {
			jog[ind].aumenta_dinheiro(80);
			this.banco -= 80;
		}
		if(indUltSR == 4) {
			jog[ind].aumenta_dinheiro(200);
			this.banco -= 200;
		}
		if(indUltSR == 5) {
			jog[ind].aumenta_dinheiro(50);
			this.banco -= 50;
		}
		if(indUltSR == 6) {
			jog[ind].aumenta_dinheiro(50);
			this.banco -= 50;
		}
		if(indUltSR == 7) {
			jog[ind].aumenta_dinheiro(100);
			this.banco -= 100;
		}
		if(indUltSR == 8) {
			jog[ind].aumenta_dinheiro(100);
			this.banco -= 100;
		}
		if(indUltSR == 9) {
			jog[ind].carta(1);
		}
		if(indUltSR == 10) {
			jog[ind].aumenta_dinheiro(200);
			jog[ind].movimenta(0);
			this.banco -= 100;
		}
		if(indUltSR == 11) {
			jog[ind].aumenta_dinheiro(50*(qtd-1));
			for(int k = 0; k<qtd;k++) {
				if(k != ind) {
					jog[k].diminui_dinheiro(50);
				}
			}
		}
		if(indUltSR == 12) {
			jog[ind].aumenta_dinheiro(45);
			this.banco -= 45;
		}
		if(indUltSR == 13) {
			jog[ind].aumenta_dinheiro(100);
			this.banco -= 100;
		}
		if(indUltSR == 14) {
			jog[ind].aumenta_dinheiro(100);
			this.banco -= 100;
		}
		if(indUltSR == 15) {
			jog[ind].aumenta_dinheiro(20);
			this.banco -= 20;
		}
		if(indUltSR == 16) {
			jog[ind].diminui_dinheiro(15);
			this.banco += 15;
		}
		if(indUltSR == 17) {
			jog[ind].diminui_dinheiro(25);
			this.banco += 25;
		}
		if(indUltSR == 18) {
			jog[ind].diminui_dinheiro(45);
			this.banco += 45;
		}
		if(indUltSR == 19) {
			jog[ind].diminui_dinheiro(30);
			this.banco += 30;
		}
		if(indUltSR == 20) {
			jog[ind].diminui_dinheiro(100);
			this.banco += 100;
		}
		if(indUltSR == 21) {
			jog[ind].diminui_dinheiro(100);
			this.banco += 100;
		}
		if(indUltSR == 22) {
			jog[ind].diminui_dinheiro(40);
			this.banco += 45;
		}
		if(indUltSR == 23) {
			jog[ind].movimenta(10);
			mandar_prisao(ind);
		}
		if(indUltSR == 24) {
			jog[ind].diminui_dinheiro(30);
			this.banco += 30;
		}
		if(indUltSR == 25) {
			jog[ind].diminui_dinheiro(50);
			this.banco += 50;
		}
		if(indUltSR == 26) {
			jog[ind].diminui_dinheiro(25);
			this.banco += 25;
		}
		if(indUltSR == 27) {
			jog[ind].diminui_dinheiro(30);
			this.banco += 30;
		}
		if(indUltSR == 28) {
			jog[ind].diminui_dinheiro(45);
			this.banco += 45;
		}
		if(indUltSR == 29) {
			jog[ind].diminui_dinheiro(50);
			this.banco += 50;
		}
		if(indUltSR == 30) {
			jog[ind].diminui_dinheiro(50);
			this.banco += 50;
		}
	}
}
