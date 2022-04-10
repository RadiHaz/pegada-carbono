package controller;
import java.util.List;

import model.Funcionario;
import dao.FuncionarioDao;

public class FuncionarioController {
	
	public void cadastrar(Funcionario funcionario) throws Exception{
		if (funcionario.getNome() == null) {
			throw new Exception();
		}
		FuncionarioDao.getInstance().cadastrar(funcionario);
	}

	public void atualizar(Funcionario funcionario) throws Exception{
		if (funcionario.getNome() == null) {
			throw new Exception();
		}
		FuncionarioDao.getInstance().atualizar(funcionario);
	}
	
	public void deletar(int idFuncionario) throws Exception{
		if (idFuncionario == 0) {
			throw new Exception();
		}
		FuncionarioDao.getInstance().deletar(idFuncionario);
	}
	
	public List<Funcionario> listar() {
		return FuncionarioDao.getInstance().listar();
	}
}
