package model; 


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.ChamadoController;
import controller.FuncionarioController;
import controller.VeiculoController;


public class Main {

	public static void main(String[] args) throws Exception {
		
		ChamadoController chamado = new ChamadoController();
		FuncionarioController funcionario = new FuncionarioController();
		VeiculoController veiculo = new VeiculoController();
		
		Chamado c = new Chamado();
		Funcionario f = new Funcionario();
		Veiculo v = new Veiculo();
		
		try {
			v.setModelo("M8X0d-FOCUS");
			v.setAno(2020);
			v.setCor("Prata");
			v.setPlaca("ZVX-1001");
			veiculo.cadastrar(v);
			
			f.setNome("Jackers");
			f.setEmail("Jamiejackes@gmail.com");
			f.setTelefone("telefone4");
			f.setCpf("cpf4");
			f.setRg("rg4");
			f.setVeiculo(v);
			funcionario.cadastrar(f);
			v.setFuncionario(f);
			veiculo.atualizar(v);
			
			LocalDate data = LocalDate.now();
			c.setEndereco("Rua Ramal Florido, 97");
			c.setDistancia(11.2);
			c.setFuncionario(f);
			c.setVeiculo(v);
			c.setData(data);
			chamado.cadastrar(c);
			
			List<Chamado> chamadoLista = new ArrayList<>();
			List<Funcionario> funcionarioLista = new ArrayList<>();
			List<Veiculo> veiculoLista = new ArrayList<>();

			for (Chamado x: chamado.listar()) {
				chamadoLista.add(x);
			}
			for (Funcionario x: funcionario.listar()) {
				funcionarioLista.add(x);
			}
			for (Veiculo x: veiculo.listar()) {
				veiculoLista.add(x);
			}
			for (Funcionario x: funcionarioLista) {
				System.out.println(x);;
			}
			for (Veiculo x: veiculoLista) {
				System.out.println(x);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}