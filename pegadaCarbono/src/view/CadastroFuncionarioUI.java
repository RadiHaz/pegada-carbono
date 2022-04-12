package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import controller.FuncionarioController;
import model.Funcionario;

public class CadastroFuncionarioUI extends JInternalFrame {
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtCpf;
	private JTextField txtRg;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroFuncionarioUI frame = new CadastroFuncionarioUI();
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
	public CadastroFuncionarioUI() {
		setClosable(true);
		setTitle("Cadastro de Funcion\u00E1rio");
		setBounds(100, 100, 342, 242);
		
		JPanel jpCadFuncionario = new JPanel();
		jpCadFuncionario.setBorder(new TitledBorder(null, "Funcion\u00E1rio", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadFuncionario, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(jpCadFuncionario, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		JLabel cadNome = new JLabel("Nome:");
		
		JLabel cadEmail = new JLabel("Email:");
		
		JLabel cadTelefone = new JLabel("Telefone:");
		
		JLabel cadCpf = new JLabel("CPF:");
		
		JLabel cadRg = new JLabel("RG:");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		
		txtRg = new JTextField();
		txtRg.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(txtNome.getText());
				funcionario.setEmail(txtEmail.getText());
				funcionario.setTelefone(txtTelefone.getText());
				funcionario.setCpf(txtCpf.getText());
					
				try {
					new FuncionarioController().cadastrar(funcionario);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário");
				}
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtEmail.setText("");
				txtTelefone.setText("");
				txtCpf.setText("");
				txtRg.setText("");
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(e -> this.dispose());
		
		GroupLayout gl_jpCadFuncionario = new GroupLayout(jpCadFuncionario);
		gl_jpCadFuncionario.setHorizontalGroup(
			gl_jpCadFuncionario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadFuncionario.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadFuncionario.createParallelGroup(Alignment.LEADING)
						.addComponent(cadTelefone)
						.addComponent(cadCpf)
						.addComponent(cadRg)
						.addComponent(cadEmail)
						.addComponent(cadNome)
						.addComponent(btnCadastrar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpCadFuncionario.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNome, 187, 187, 187)
						.addComponent(txtEmail, 187, 187, 187)
						.addComponent(txtCpf, 187, 187, 187)
						.addComponent(txtTelefone, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
						.addGroup(gl_jpCadFuncionario.createSequentialGroup()
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
						.addComponent(txtRg, 187, 187, 187))
					.addContainerGap())
		);
		gl_jpCadFuncionario.setVerticalGroup(
			gl_jpCadFuncionario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadFuncionario.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadFuncionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(cadNome)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpCadFuncionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(cadEmail)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpCadFuncionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(cadTelefone)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpCadFuncionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(cadCpf)
						.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpCadFuncionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(cadRg)
						.addComponent(txtRg, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadFuncionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnLimpar)
						.addComponent(btnSair))
					.addContainerGap(14, Short.MAX_VALUE))
		);
		jpCadFuncionario.setLayout(gl_jpCadFuncionario);
		getContentPane().setLayout(groupLayout);

	}
}
