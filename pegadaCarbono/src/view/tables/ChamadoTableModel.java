package view.tables;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Chamado;

public class ChamadoTableModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	private static final int COL_DISTANCIA = 0;
	private static final int COL_ID_FUNCIONARIO = 1;
	private static final int COL_NOME_FUNCIONARIO = 2;
	private static final int COL_ID_VEICULO = 3;
	private static final int COL_PLACA_VEICULO = 4;
	private static final int COL_DATA = 5;

	private List<Chamado> valores;       

	//Esse é um construtor, que recebe a nossa lista de clientes
	public ChamadoTableModel(List<Chamado> valores) {
		this.valores = new ArrayList<Chamado>(valores);
	}

	public int getRowCount() {
		//Quantas linhas tem sua tabela? Uma para cada item da lista.
		return valores.size();
	}

	public int getColumnCount() {
		//Quantas colunas tem a tabela? 
		return 6;
	}

	public String getColumnName(int column) {
		//Qual é o PLACA das nossas colunas?
		if (column == COL_DISTANCIA) return "Distância";
		if (column == COL_ID_FUNCIONARIO) return "ID Funcionário";
		if (column == COL_NOME_FUNCIONARIO) return "Nome Funcionário";
		if (column == COL_ID_VEICULO) return "ID Veículo";
		if (column == COL_PLACA_VEICULO) return "Placa Veículo";
		if (column == COL_DATA) return "Data";
		return ""; //Nunca deve ocorrer
	}

	public Object getValueAt(int row, int column) {
		//Precisamos retornar o valor da coluna column e da linha row.
		Chamado chamado = valores.get(row);
		if (column == COL_DISTANCIA)
			return chamado.getDistancia();
		else
			if (column == COL_ID_FUNCIONARIO)
				return chamado.getFuncionario().getId();
			else
				if (column == COL_NOME_FUNCIONARIO)
					return chamado.getFuncionario().getNome();
				else
					if (column == COL_ID_VEICULO)
						return chamado.getVeiculo().getId();
					else
						if (column == COL_PLACA_VEICULO)
							return chamado.getVeiculo().getPlaca();
						else
							if (column == COL_DATA)
								return chamado.getData();
		return ""; //Nunca deve ocorrer
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Chamado chamado = valores.get(rowIndex);
		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parï¿½metro.
		//Note que vc poderia alterar 2 campos ao invï¿½s de um sï¿½.
		if(columnIndex == COL_DISTANCIA)
			chamado.setDistancia(Double.parseDouble(aValue.toString()));
		else
			if(columnIndex == COL_ID_FUNCIONARIO)
				chamado.getFuncionario().setId(Integer.parseInt(aValue.toString()));
			else
				if(columnIndex == COL_NOME_FUNCIONARIO)
					chamado.getFuncionario().setNome(aValue.toString());
				else
					if(columnIndex == COL_ID_VEICULO)
						chamado.getVeiculo().setId(Integer.parseInt(aValue.toString()));
					else
						if (columnIndex == COL_PLACA_VEICULO)
							chamado.getVeiculo().setPlaca(aValue.toString());
						else
							if(columnIndex == COL_DATA)
								chamado.setData(LocalDate.now());
	}

	public Class<?> getColumnClass(int columnIndex) {
		//Qual a classe das nossas colunas? Como estamos exibindo texto, ï¿½ string.
		return String.class;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		//Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda ï¿½.
		return true;
	}
	//Já que esse tableModel é de clientes, vamos fazer um get que retorne um objeto cliente inteiro.
	//Isso elimina a necessidade de chamar o getValueAt() nas telas. 
	public Chamado get(int row) {
		return valores.get(row);
	}
	
}

