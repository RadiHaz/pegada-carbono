package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class MainUI extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 590, 410);
		
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
		mnCadastros.add(mnCadChamado);
		
		JMenu mnConsulta = new JMenu("Consulta");
		menuBarMain.add(mnConsulta);
		
		JMenuItem mnConFuncionario = new JMenuItem("Funcionario");
		mnConsulta.add(mnConFuncionario);
		
		JMenuItem mnConVeiculo = new JMenuItem("Veiculo");
		mnConsulta.add(mnConVeiculo);
		
		JMenuItem mnConChamado = new JMenuItem("Chamado");
		mnConsulta.add(mnConChamado);
		
		JMenu mnTemp = new JMenu("Sobre");
		menuBarMain.add(mnTemp);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(e -> System.exit(0));
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(414, Short.MAX_VALUE)
					.addComponent(btnSair)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(233, Short.MAX_VALUE)
					.addComponent(btnSair)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

}
