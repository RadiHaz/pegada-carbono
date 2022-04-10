package model;
import java.time.LocalDate;

public class Chamado {
	private int id;
	private String endereco;
	private Double distancia;
	private Funcionario funcionario;
	private Veiculo veiculo;
	private LocalDate data;
	private Double pegadaDeCarbono;
		
	public Chamado(Funcionario funcionario, Veiculo veiculo, Double distancia) {
		this.funcionario = funcionario;
		this.veiculo = veiculo;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	
	public Double getPegadaDeCarbono() {
		return pegadaDeCarbono;
	}
	
	public void setPegadaDeCarbono(Double pegadaDeCarbono) {
		this.pegadaDeCarbono = pegadaDeCarbono;
	}

}
