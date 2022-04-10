package controller;

import java.util.List;

import model.Chamado;
import dao.ChamadoDao;

public class ChamadoController {
	
	public void cadastrar(Chamado chamado) throws Exception{
		if (chamado.getEndereco() == null) {
			throw new Exception("Endereco inv�lido");
		}
		ChamadoDao.getInstance().cadastrar(chamado);
	}

	public void atualizar(Chamado chamado) throws Exception {
		if (chamado.getId() == 0) {
			throw new Exception("Chamado com ID 0 n�o pode ser atualizado.");
		}
		ChamadoDao.getInstance().atualizar(chamado);
	}
	
	public void deletar(int idChamado) throws Exception{
		if (idChamado == 0) {
			throw new Exception("ID de Chamado inv�lida.");
		}
		try {
		ChamadoDao.getInstance().deletar(idChamado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Chamado> listar() {
		return ChamadoDao.getInstance().listar();
	}
}
