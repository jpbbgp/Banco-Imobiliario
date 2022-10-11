package Model;

public class Campos {
	String nome;
	int pos, dono, tipo, val_compra, val_construir, num_hotel = 0, num_casas = 0, aluguel, alug_hotel; 
	int alug_casa[] = new int[4];
	
	public Campos(int pos, String nome, int dono, int tipo, int val_compra, int val_construir, int aluguel,  
			int casa1, int casa2, int casa3, int casa4, int alug_hotel) {
		this.pos = pos;
		this.nome = nome;
		this.dono = dono;
		this.tipo = tipo;
		this.val_compra = val_compra;
		this.val_construir = val_construir;
		this.aluguel = aluguel;
		this.alug_hotel = alug_hotel;
		this.alug_casa[0] = casa1;
		this.alug_casa[1] = casa2;
		this.alug_casa[2] = casa3;
		this.alug_casa[3] = casa4;
	}
	
	public String nome() {
		return nome;
	}
	
	public int getdono(){
		return dono;
	}
	public int gettipo(){
		return tipo;
	}
	public int valor_compra(){
		return val_compra;
	}
	public int valor_construir(){
		return val_construir;
	}
	public int getnum_hotel(){
		return num_hotel;
	}
	public int getnum_casas(){
		return num_casas;
	}
	public int getaluguel(){
		return aluguel;
	}
	public int getalug_hotel(){
		return alug_hotel;
	}
	public int[] getalug_casa(){
		return alug_casa;
	}
	public void altera_hotel(int num){
		this.num_hotel = num;
	}
	public void altera_casa(int num){
		this.num_casas = num;
	}
	public void altera_dono(int num){
		this.dono = num;
	}
}