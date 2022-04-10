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

		v.setModelo("M8X00B-FOCUS");
		v.setAno(2020);
		v.setCor("Prata");
		v.setPlaca("XNX-9009");
		
		f.setNome("Melvin");
		f.setEmail("Melziv@gmail.com");
		f.setTelefone("554176435519");
		f.setCpf("005119810-91");
		f.setRg("5550033");
		f.setVeiculo(v);
		v.setFuncionario(f);
		
		LocalDate data = LocalDate.now();
		c.setEndereco("Rua Ramal Florido, 97");
		c.setDistancia(11.2);
		c.setFuncionario(f);
		c.setVeiculo(v);
		c.setData(data);
		
		try {
//			veiculo.deletar(4);
//			veiculo.deletar(5);
//			veiculo.deletar(6);
//			
//			funcionario.deletar(4);
//			funcionario.deletar(5);
//			funcionario.deletar(6);
//			
//			chamado.deletar(8);
			veiculo.cadastrar(v);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}