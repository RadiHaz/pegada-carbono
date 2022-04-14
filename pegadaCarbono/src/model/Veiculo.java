package model;

public class Veiculo {
	private int id;
	private String placa;
	
	
	public Veiculo(String placa, String modelo) {
		this.placa = placa;
	}
	
	public Veiculo() {
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}
	
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	@Override
	public String toString() {
		return getPlaca();
	}
}