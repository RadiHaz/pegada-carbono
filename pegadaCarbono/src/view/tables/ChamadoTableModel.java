//package view.tables;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.swing.table.AbstractTableModel;
//
//import model.Chamado;
//
//public class ChamadoTableModel extends AbstractTableModel{
//
//	private static final long serialVersionUID = 1L;
//	private static final int COL_PLACA = 0;
//
//	private List<Chamado> valores;       
//
//	//Esse é um construtor, que recebe a nossa lista de clientes
//	public ChamadoTableModel(List<Chamado> valores) {
//		this.valores = new ArrayList<Chamado>(valores);
//	}
//
//	public int getRowCount() {
//		//Quantas linhas tem sua tabela? Uma para cada item da lista.
//		return valores.size();
//	}
//
//	public int getColumnCount() {
//		//Quantas colunas tem a tabela? Nesse exemplo, sï¿½ 2.
//		return 1;
//	}
//
//	public String getColumnName(int column) {
//		//Qual é o PLACA das nossas colunas?
//		if (column == COL_PLACA) return "PLACA";
//		return ""; //Nunca deve ocorrer
//	}
//
//	public Object getValueAt(int row, int column) {
//		//Precisamos retornar o valor da coluna column e da linha row.
//		Chamado Chamado = valores.get(row);
//		if (column == COL_PLACA)
//			return Chamado.getPlaca();
//		return ""; //Nunca deve ocorrer
//	}
//
//	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//		Chamado Chamado = valores.get(rowIndex);
//		//Vamos alterar o valor da coluna columnIndex na linha rowIndex com o valor aValue passado no parï¿½metro.
//		//Note que vc poderia alterar 2 campos ao invï¿½s de um sï¿½.
//		if (columnIndex == COL_PLACA)
//			Chamado.setPlaca(aValue.toString());
//	}
//
//	public Class<?> getColumnClass(int columnIndex) {
//		//Qual a classe das nossas colunas? Como estamos exibindo texto, ï¿½ string.
//		return String.class;
//	}
//
//	public boolean isCellEditable(int rowIndex, int columnIndex) {
//		//Indicamos se a célula da rowIndex e da columnIndex é editável. Nossa tabela toda ï¿½.
//		return true;
//	}
//	//Já que esse tableModel é de clientes, vamos fazer um get que retorne um objeto cliente inteiro.
//	//Isso elimina a necessidade de chamar o getValueAt() nas telas. 
//	public Chamado get(int row) {
//		return valores.get(row);
//	}
//	
//}
//
