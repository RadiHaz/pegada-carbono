package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

public class MainUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtResultado;
	private JTextField txtCG;

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
		
		JMenuItem mnCadChamado = new JMenuItem("Chamado");
		mnCadChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroChamadoUI cadastroChamadoUI = new CadastroChamadoUI();
				cadastroChamadoUI.setVisible(true);
				contentPane.add(cadastroChamadoUI, 0);
			}
		});
		mnCadastros.add(mnCadChamado);
		
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
		
		JMenuItem mnConChamado = new JMenuItem("Chamado");
		mnConsulta.add(mnConChamado);
		
		JMenu mnTemp = new JMenu("Sobre");
		menuBarMain.add(mnTemp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Calculadora de Emiss\u00E3o de G\u00E1s Carb\u00F4nico (CO2)", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(236)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(265, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(114)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(139, Short.MAX_VALUE))
		);
		
		JLabel lblConsumoGasolina = new JLabel("Consumo de gasolina:");
		lblConsumoGasolina.setToolTipText("A f\u00F3rmula CG x 0,82 x 0,75 x 3,7, onde CG corresponde a este campo, calcula o total de emiss\u00E3o de CO2 de um chamado, em KG");
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DecimalFormat df = new DecimalFormat("0.00");
					Double cg = Double.parseDouble(txtCG.getText());
					Double formula = cg * 0.82 * 0.75 * 3.7;
					txtResultado.setText((df.format(formula)) + " KG");
				}
				catch (NumberFormatException eN) {
					JOptionPane.showMessageDialog(null, "Valor não é numérico. Tente novamente.");
				}
			}
		});
		btnNewButton.setToolTipText("Calcular");
		
		txtResultado = new JTextField();
		txtResultado.setText("resultado");
		txtResultado.setColumns(10);
		
		JButton btnLimparCG = new JButton("Limpar");
		btnLimparCG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCG.setText("");
			}
		});
		
		JButton btnLimparResult = new JButton("Limpar");
		btnLimparResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResultado.setText("");
			}
		});
		
		txtCG = new JTextField();
		txtCG.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(e -> System.exit(0));
		
		JLabel lblNewLabel = new JLabel("Chamado:");
		
		JComboBox comboBox = new JComboBox();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
							.addGap(96))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblConsumoGasolina)
									.addGap(11))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED))
								.addComponent(lblNewLabel))
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtCG, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(1)
											.addComponent(txtResultado, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
											.addGap(1)))
									.addGap(9)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnLimparCG, Alignment.TRAILING)
										.addComponent(btnLimparResult, Alignment.TRAILING))
									.addGap(34))
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(1)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(13)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLimparCG)
								.addComponent(lblConsumoGasolina))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLimparResult)
								.addComponent(btnNewButton)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtCG, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(txtResultado, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(btnSair)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
