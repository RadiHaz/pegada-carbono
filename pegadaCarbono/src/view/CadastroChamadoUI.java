package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import controller.ChamadoController;
import controller.FuncionarioController;
import controller.VeiculoController;
import model.Chamado;
import model.Funcionario;
import model.Veiculo;
import view.tables.ChamadoTableModel;

public class CadastroChamadoUI extends JInternalFrame {
	private JTextField txtDistancia;
	private Chamado chamado;
	
	JComboBox<Funcionario> comboFuncionario = new JComboBox();
	JComboBox<Veiculo> comboVeiculo = new JComboBox();

	List<Chamado> listaChamado = new ArrayList<Chamado>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroChamadoUI frame = new CadastroChamadoUI();
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
	public CadastroChamadoUI() {
		setClosable(true);
		setTitle("Cadastro de Chamado");
		setBounds(100, 100, 738, 228);
		
		DefaultComboBoxModel<Funcionario> modelFuncionario = new DefaultComboBoxModel();
		for(Funcionario funcionario : new FuncionarioController().listar()) {
			if(funcionario.getHabilitado() == true) {
				modelFuncionario.addElement(funcionario);
			}
		}
		comboFuncionario.setModel(modelFuncionario);
		
		DefaultComboBoxModel<Veiculo> modelVeiculo = new DefaultComboBoxModel();
		for(Veiculo veiculo : new VeiculoController().listar()) {
			modelVeiculo.addElement(veiculo);
		}
		comboVeiculo.setModel(modelVeiculo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Chamado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		
		JLabel chamadoFuncionario = new JLabel("Funcion\u00E1rio:");
		
		JLabel chamadoDistancia = new JLabel("Dist\u00E2ncia:");
		
		txtDistancia = new JTextField();
		txtDistancia.setColumns(10);
		
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = (Funcionario) comboFuncionario.getSelectedItem();
				Veiculo veiculo = (Veiculo) comboVeiculo.getSelectedItem();
				try {
					if (chamado != null && chamado.getId() > 0) {
						chamado.setDistancia(Double.parseDouble(txtDistancia.getText()));
						chamado.setFuncionario((Funcionario) comboFuncionario.getSelectedItem());
						chamado.setVeiculo((Veiculo) comboVeiculo.getSelectedItem());
						chamado.setData(LocalDate.now());
						new ChamadoController().atualizar(chamado);
					}
					else {
					Chamado chamado = new Chamado();
					chamado.setDistancia(Double.parseDouble(txtDistancia.getText()));
					chamado.setFuncionario(funcionario);
					chamado.setVeiculo(veiculo);
					chamado.setData(LocalDate.now());
					listaChamado.add(chamado);
					new ChamadoController().cadastrar(chamado);
					}
					JOptionPane.showMessageDialog(null, "Chamado cadastrado com sucesso");
					
				} catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar chamado");
				}
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtDistancia.setText("");
			}
		});
		
		JLabel chamadoVeiculo = new JLabel("Ve\u00EDculo:");
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(chamadoDistancia, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chamadoVeiculo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chamadoFuncionario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtDistancia, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
								.addComponent(comboVeiculo, Alignment.LEADING, 0, 601, Short.MAX_VALUE)
								.addComponent(comboFuncionario, Alignment.LEADING, 0, 601, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chamadoFuncionario)
						.addComponent(comboFuncionario, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chamadoVeiculo)
						.addComponent(comboVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(chamadoDistancia)
						.addComponent(txtDistancia, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnSair)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(245))
		);
		if(chamado != null) {
		chamado.setFuncionario((Funcionario) new FuncionarioController().listar());
		}

		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}

	public void setChamadoEdicao(Chamado chamado) {
		// TODO Auto-generated method stub
		this.chamado = chamado;		
		preencheFormulario();
	}
	private void preencheFormulario() {
		if (chamado != null) {
			comboFuncionario.setSelectedItem(chamado.getFuncionario());
			comboVeiculo.setSelectedItem(chamado.getVeiculo());
			txtDistancia.setText(chamado.getDistancia().toString());
		}
	}
}
