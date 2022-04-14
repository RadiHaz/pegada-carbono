package model;
import java.time.LocalDate;

public class Chamado {
	private int id;
	private Double distancia;
	private Funcionario funcionario;
	private Veiculo veiculo;
	private LocalDate data;
		
	public Chamado(Funcionario funcionario, Double distancia) {
		this.funcionario = funcionario;
		this.distancia = distancia;
	}

	public Chamado() {
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDate getData() {
		return this.data;
	}
	
	public void setData(LocalDate data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "ID Chamado: "
				+ id
				+ "\nData: "
				+ data;
	}
}