package Model;

public class Regras {
	
	public int indice[] = {0,1,2,3,4,5}, qtd, dados[] = {1,1};
	Jogo partida;
	
	public Regras(int qtd, String[] jogadores) {
		this.qtd = qtd;
		partida = new Jogo(qtd, jogadores);
	}

	public int[] jogardado() {/*joga os dados e retorna {dado0,dado1}*/
		dados = partida.jogardado();
		return dados;
	}
	
	public int PodeCasa(){
		return partida.PodeCasa();
	}
	public float JogDinDin(int ind) {
		return partida.JogDinDin(ind);
	}
	public String nomeJog(int ind_jog) {
		return partida.nomeJog(ind_jog);
	}
	public int PodeHotel(){
		return partida.PodeHotel();
	}
	public void comprar_imov() {
		partida.comprar_imov();
	}
	
	public void vender_imov() {
		partida.vender_imov();
	}
	public int RetTipo() {
		return partida.RetTipo();
	}
	public int PodeComprar() {
		return partida.PodeComprar();
	}
	public int PodeVender() {
		return partida.PodeVender();
	}
	
	public void set_dados(int a, int b) {
		this.dados[0] = a;
		this.dados[1] = b;
	}
	public void trocarRodada() {
		partida.trocarRodada();
	}
	public int rodada() {
		return partida.rodada();
	}
	public float JogPatri(int ind) {
		return partida.JogPatri(ind);
	}
	public int teveCarta() {
		return partida.teveCarta();
	}
	
	
	public int JogaDeNovo() {
		return partida.JogaDeNovo();
	}
	public void movimentar(int ind_jog){
		partida.movimentar(ind_jog, dados[0], dados[1]);
	}
	public boolean ganhou(){ /*vai verificar se os outros jogadores estao eliminados, restando somente o campeao*/
		 return partida.ganhou();
	}
	
	public int getpeao(int ind_jog) { /*retorna a posicao do peao do jogador*/
		return partida.getpeao(ind_jog);
	}
	public String[] ver_ganhador() { /* caso jogo acabe antecipadamente, quem tem mais dinheiro ganha e o vetor esta na ordem de dinheiro*/
		return partida.ver_ganhador();
	}
	public void liberdade_prisao(int ind_jog){
		liberdade_prisao(ind_jog);
	}
}
