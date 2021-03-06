package model; 


import java.sql.SQLException;
import java.time.LocalDate;

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
			v.setPlaca("ZBX-1201");
			veiculo.cadastrar(v);
			
			f.setNome("Jackedrs");
			f.setEmail("Jamiejacdskes@gmail.com");
			f.setTelefone("telefoned4");
			f.setCpf("cpfa4");
			
			funcionario.cadastrar(f);
			veiculo.atualizar(v);
			
			LocalDate data = LocalDate.now();
			c.setDistancia(11.2);
			c.setFuncionario(f);
			c.setData(data);
			chamado.cadastrar(c);
			
			System.out.println(chamado.listar());
			System.out.println(veiculo.listar());
			System.out.println(funcionario.listar());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}