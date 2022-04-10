package model; 
import controller.FuncionarioController;

public class Main2 {

	public static void main(String[] args) {
		
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("MXN9282");
		
		Funcionario f1 = new Funcionario();
		f1.setId(1);
		f1.setNome("Marcos dos Anjos");
		f1.setCpf("000.000.000-11");
		f1.setVeiculo(veiculo);
		
		Veiculo veiculo2 = new Veiculo();
		veiculo2.setPlaca("PHN3729");
		
		Funcionario f2 = new Funcionario();
		f2.setId(2);
		f2.setNome("Andre Margot");
		f2.setCpf("000.000.000-11");
		f2.setVeiculo(veiculo2);
		
		FuncionarioController controller = new FuncionarioController();
		try {
			controller.cadastrar(f1);
			controller.cadastrar(f2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		for(Funcionario f: controller.listar()) {
			System.out.println(f.toString());
		}
	}
}