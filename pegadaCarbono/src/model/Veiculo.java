package model;

public class Veiculo {
	private int id;
	private Funcionario funcionario;
	private String placa;
	private int ano;
	private String modelo;
	private String cor;
	
	
	public Veiculo(String placa, String modelo) {
		this.placa = placa;
		this.modelo = modelo;
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

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario (Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	@Override
	public String toString() {
		return "ID Veiculo: " + id
				+ "\nModelo: " + modelo
				+ "\nAno: " + ano
				+ "\nPlaca: " + placa
				+ "\nCor: " + cor;
	}
}