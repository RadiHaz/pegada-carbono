package view;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;

import controller.ChamadoController;
import controller.FuncionarioController;
import model.Chamado;
import model.Funcionario;
import view.tables.ChamadoTableModel;
import view.tables.FuncionarioTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaChamadoUI extends JInternalFrame {
	private JTable jtChamado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaChamadoUI frame = new ConsultaChamadoUI();
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
	public ConsultaChamadoUI() {
		setBounds(100, 100, 560, 260);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado chamado = new ChamadoTableModel(new ChamadoController().listar()).get(jtChamado.getSelectedRow());
				try {
					CadastroChamadoUI cadChamadoUI = new CadastroChamadoUI();
					cadChamadoUI.setChamadoEdicao(chamado);
					cadChamadoUI.setVisible(true);
					getParent().add(cadChamadoUI, 0);
				} catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		
		JButton btnAtualizar = new JButton("Atualizar");
		
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
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAtualizar)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSair)))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEditar)
						.addComponent(btnExcluir)
						.addComponent(btnAtualizar)
						.addComponent(btnSair))
					.addContainerGap(96, Short.MAX_VALUE))
		);
		
		jtChamado = new JTable();
		jtChamado.setModel(new ChamadoTableModel(new ChamadoController().listar()));
		scrollPane.setViewportView(jtChamado);
		getContentPane().setLayout(groupLayout);

	}
}
