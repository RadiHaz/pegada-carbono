package model;

public class Funcionario {
	private int id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	private Boolean habilitado;
	
	public Funcionario(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	public Funcionario() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getTelefone() {
		return this.telefone;
	}
	
	public void setTelefone(String contato) {
		this.telefone = contato;
	}
	
	@Override
	public String toString() {
		return getNome() + " - " + getTelefone();
	}
}