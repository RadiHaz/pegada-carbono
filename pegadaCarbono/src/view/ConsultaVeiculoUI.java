package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.VeiculoController;
import controller.VeiculoController;
import model.Veiculo;
import model.Veiculo;
import view.tables.VeiculoTableModel;
import view.tables.VeiculoTableModel;

public class ConsultaVeiculoUI extends JInternalFrame {
	private JTable jtVeiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaVeiculoUI frame = new ConsultaVeiculoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaVeiculoUI() {
		setTitle("Consulta de Ve\u00EDculo");
		setClosable(true);
		setBounds(100, 100, 448, 215);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo Veiculo = new VeiculoTableModel(new VeiculoController().listar()).get(jtVeiculo.getSelectedRow());
				try {
					CadastroVeiculoUI cadVeiculoUI = new CadastroVeiculoUI();
					cadVeiculoUI.setVeiculoEdicao(Veiculo);
					cadVeiculoUI.setVisible(true);
					getParent().add(cadVeiculoUI, 0);
				} catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = new VeiculoTableModel(new VeiculoController().listar()).get(jtVeiculo.getSelectedRow());
				try {
					new VeiculoController().deletar(veiculo.getId());
					jtVeiculo.setModel(new VeiculoTableModel(new VeiculoController().listar()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir Veiculo.");
				}
			}
		});
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtVeiculo.setModel(new VeiculoTableModel(new VeiculoController().listar()));
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAtualizar)
							.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnExcluir)
						.addComponent(btnAtualizar)
						.addComponent(btnSair))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		
		jtVeiculo = new JTable();
		jtVeiculo.setModel(new VeiculoTableModel(new VeiculoController().listar()));
		scrollPane.setViewportView(jtVeiculo);
		getContentPane().setLayout(groupLayout);

	}
}
