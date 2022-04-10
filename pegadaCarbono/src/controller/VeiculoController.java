package controller;

import java.util.List;

import model.Veiculo;
import dao.VeiculoDao;

public class VeiculoController {
	
	public void cadastrar(Veiculo veiculo) throws Exception{
		if (veiculo.getPlaca() == null) {
			throw new Exception("Placa inv�lida.");
		}
		VeiculoDao.getInstance().cadastrar(veiculo);
	}
	
	public void atualizar(Veiculo veiculo) throws Exception{
		if (veiculo.getPlaca() == null) {
			throw new Exception("Placa inv�lida.");
		}
		VeiculoDao.getInstance().atualizar(veiculo);
	}
	
	public void deletar(int idVeiculo) throws Exception{
		if(idVeiculo == 0) {
			throw new Exception("Id de Veiculo inv�lido.");
		}
		VeiculoDao.getInstance().deletar(idVeiculo);
	}
	
	public List<Veiculo> listar() {
		return VeiculoDao.getInstance().listar();
	}
	
}
