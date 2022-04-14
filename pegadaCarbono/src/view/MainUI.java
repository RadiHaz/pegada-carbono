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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controller.ChamadoController;
import controller.FuncionarioController;
import controller.VeiculoController;
import model.Chamado;
import model.Funcionario;
import model.Veiculo;
import view.tables.ChamadoTableModel;
import view.tables.FuncionarioTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;

public class MainUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtDistancia;
	private JTable jtChamado;
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
					MainUI frame = new MainUI();
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
	public MainUI() {
		setTitle("Pegada de Carbono");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 550);
		
		DefaultComboBoxModel<Funcionario> modelFuncionario = new DefaultComboBoxModel();
		for(Funcionario funcionario : new FuncionarioController().listar()) {
			if (funcionario.getHabilitado()) {
				modelFuncionario.addElement(funcionario);
			}
		}
		comboFuncionario.setModel(modelFuncionario);
		
		
		DefaultComboBoxModel<Veiculo> modelVeiculo = new DefaultComboBoxModel();
		for(Veiculo veiculo : new VeiculoController().listar()) {
			modelVeiculo.addElement(veiculo);
		}
		
		comboVeiculo.setModel(modelVeiculo);
		
		JMenuBar menuBarMain = new JMenuBar();
		setJMenuBar(menuBarMain);
		
		JMenu mnCadastros = new JMenu("Cadastro");
		menuBarMain.add(mnCadastros);
		
		JMenuItem mnCadFuncionario = new JMenuItem("Funcionario");
		mnCadFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroFuncionarioUI cadFuncionario = new CadastroFuncionarioUI();
				cadFuncionario.setVisible(true);
				contentPane.add(cadFuncionario, 0);
			}
		});
		mnCadastros.add(mnCadFuncionario);
		
		JMenuItem mnCadVeiculo = new JMenuItem("Veiculo");
		mnCadVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroVeiculoUI cadVeiculo = new CadastroVeiculoUI();
				cadVeiculo.setVisible(true);
				contentPane.add(cadVeiculo, 0);
			}
		});
		mnCadastros.add(mnCadVeiculo);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBarMain.add(mnConsulta);
		
		JMenuItem mnConFuncionario = new JMenuItem("Funcionario");
		mnConFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaFuncionarioUI consultaFuncionarioUI = new ConsultaFuncionarioUI();
				consultaFuncionarioUI.setVisible(true);
				contentPane.add(consultaFuncionarioUI, 0);
			}
		});
		mnConsulta.add(mnConFuncionario);
		
		JMenuItem mnConVeiculo = new JMenuItem("Veiculo");
		mnConVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultaVeiculoUI consultaVeiculoUI = new ConsultaVeiculoUI();
				consultaVeiculoUI.setVisible(true);
				contentPane.add(consultaVeiculoUI, 0);
			}
		});
		mnConsulta.add(mnConVeiculo);
		
		JMenu mnTemp = new JMenu("Sobre");
		menuBarMain.add(mnTemp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Chamado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
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
					jtChamado.setModel(new ChamadoTableModel(new ChamadoController().listar()));
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
		
		JLabel chamadoDistancia = new JLabel("Dist\u00E2ncia:");
		
		JLabel chamadoVeiculo = new JLabel("Ve\u00EDculo:");
		
		JLabel chamadoFuncionario = new JLabel("Funcion\u00E1rio:");
		
		txtDistancia = new JTextField();
		txtDistancia.setColumns(10);

		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado chamado = new ChamadoTableModel(new ChamadoController().listar()).get(jtChamado.getSelectedRow());
				try {
					CadastroChamadoUI cadChamadoUI = new CadastroChamadoUI();
					cadChamadoUI.setChamadoEdicao(chamado);
					cadChamadoUI.setVisible(true);
					contentPane.add(cadChamadoUI, 0);
				} catch(Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
		JButton btnCalcular = new JButton("Calcular Emiss\u00E3o CO2");
		btnCalcular.setVisible(false);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCalcular.setVisible(false);
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
				jtChamado.setModel(new ChamadoTableModel(new ChamadoController().listar()));
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado chamado = new ChamadoTableModel(new ChamadoController().listar()).get(jtChamado.getSelectedRow());
				try {
					new ChamadoController().deletar(chamado.getId());
					jtChamado.setModel(new ChamadoTableModel(new ChamadoController().listar()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir funcionário.");
				}
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		jtChamado = new JTable();
		
		jtChamado.setModel(new ChamadoTableModel(new ChamadoController().listar()));
		

		jtChamado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnCalcular.setVisible(true);
			}
		});
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Chamado chamado = new ChamadoTableModel(new ChamadoController().listar()).get(jtChamado.getSelectedRow());
				final DecimalFormat df = new DecimalFormat("0.00");
				Double emissao = calcularEmissao(chamado);
				JOptionPane.showMessageDialog(null, "Emissão total do Chamado número " + chamado.getId() + " do Funcionário " + chamado.getFuncionario().getNome() + " de distância " + chamado.getDistancia() + " Km foi de " + df.format(emissao) + " KG");
			}
		});
		
		JLabel lblNewLabel = new JLabel("Ao alterar qualquer dado, n\u00E3o esque\u00E7a de atualizar a tabela com o bot\u00E3o \"Atualizar\".");
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNewLabel.setForeground(Color.BLACK);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnLimpar, GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(chamadoDistancia, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chamadoVeiculo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(chamadoFuncionario, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtDistancia, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
								.addComponent(comboVeiculo, Alignment.LEADING, 0, 601, Short.MAX_VALUE)
								.addComponent(comboFuncionario, Alignment.LEADING, 0, 601, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addComponent(btnEditar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAtualizar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCalcular)
							.addPreferredGap(ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
							.addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(chamadoFuncionario)
						.addComponent(comboFuncionario, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(chamadoVeiculo)
						.addComponent(comboVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(chamadoDistancia)
						.addComponent(txtDistancia, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSair)
						.addComponent(btnEditar)
						.addComponent(btnAtualizar)
						.addComponent(btnExcluir)
						.addComponent(btnCalcular))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addGap(27))
		);

		scrollPane.setViewportView(jtChamado);
		panel_1.setLayout(gl_panel_1);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(76)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 702, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 402, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	public Double calcularEmissao(Chamado chamado) {
		Double KM_POR_LITRO = 12.0;
		Double consumoGasolina = chamado.getDistancia()/KM_POR_LITRO;
		Double resultado = consumoGasolina * 0.82 * 0.75 * 3.7;
		return resultado;
	}
}
