package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;

import controller.FuncionarioController;
import model.Funcionario;

public class CadastroFuncionarioUI extends JInternalFrame {
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JTextField txtCpf;
	private JTextField txtNome;
	private Funcionario funcionario;

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
		setBounds(100, 100, 485, 326);
		
		JPanel jpCadFuncionario = new JPanel();
		jpCadFuncionario.setBorder(new TitledBorder(null, "Funcion\u00E1rio", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadFuncionario, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadFuncionario, GroupLayout.DEFAULT_SIZE, 274, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel cadNome = new JLabel("Nome:");
		
		JLabel cadEmail = new JLabel("Email:");
		
		JLabel cadTelefone = new JLabel("Telefone:");
		
		JLabel cadCpf = new JLabel("CPF:");
		
		JLabel lblNewLabel = new JLabel("Habilitado?");
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		
		ButtonGroup btnGroup = new ButtonGroup();
		
		JRadioButton rdNao = new JRadioButton("N\u00E3o");
		JRadioButton rdSim = new JRadioButton("Sim");
		rdSim.setSelected(true);
		btnGroup.add(rdSim);
		btnGroup.add(rdNao);
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				if (funcionario != null && funcionario.getId() > 0) {
					funcionario.setNome(txtNome.getText());
					funcionario.setEmail(txtEmail.getText());
					funcionario.setTelefone(txtTelefone.getText());
					funcionario.setCpf(txtCpf.getText());
					if(rdSim.isSelected()) funcionario.setHabilitado(true);
					else funcionario.setHabilitado(false);
					new FuncionarioController().atualizar(funcionario);
				}
				else {
					
					Funcionario funcionario = new Funcionario();
					if((txtNome.getText().isEmpty() && txtCpf.getText().isEmpty() && txtEmail.getText().isEmpty()) == false) {
					funcionario.setNome(txtNome.getText());
					funcionario.setEmail(txtEmail.getText());
					funcionario.setTelefone(txtTelefone.getText());
					funcionario.setCpf(txtCpf.getText());
					if(rdSim.isSelected()) funcionario.setHabilitado(true);
					else funcionario.setHabilitado(false);
					}
					
					new FuncionarioController().cadastrar(funcionario);
					JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso");
				}
				dispose();
				} catch (Exception e1) {
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
			}
		});

		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(e -> this.dispose());
		
		
		
		GroupLayout gl_jpCadFuncionario = new GroupLayout(jpCadFuncionario);
		gl_jpCadFuncionario.setHorizontalGroup(
			gl_jpCadFuncionario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadFuncionario.createSequentialGroup()
					.addGap(71)
					.addGroup(gl_jpCadFuncionario.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_jpCadFuncionario.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_jpCadFuncionario.createSequentialGroup()
							.addGroup(gl_jpCadFuncionario.createParallelGroup(Alignment.LEADING)
								.addComponent(cadTelefone)
								.addComponent(cadCpf)
								.addComponent(cadEmail)
								.addComponent(cadNome)
								.addComponent(lblNewLabel))
							.addGap(35)
							.addGroup(gl_jpCadFuncionario.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtNome, 187, 187, Short.MAX_VALUE)
								.addComponent(txtEmail, 187, 187, Short.MAX_VALUE)
								.addComponent(txtCpf, 187, 187, Short.MAX_VALUE)
								.addComponent(txtTelefone)
								.addGroup(gl_jpCadFuncionario.createSequentialGroup()
									.addComponent(rdSim, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
									.addGap(40)
									.addComponent(rdNao)
									.addGap(29)))))
					.addContainerGap(82, Short.MAX_VALUE))
		);
		gl_jpCadFuncionario.setVerticalGroup(
			gl_jpCadFuncionario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadFuncionario.createSequentialGroup()
					.addGap(40)
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
						.addComponent(lblNewLabel)
						.addComponent(rdNao)
						.addComponent(rdSim))
					.addPreferredGap(ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
					.addGroup(gl_jpCadFuncionario.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnLimpar)
						.addComponent(btnSair))
					.addContainerGap())
		);
		jpCadFuncionario.setLayout(gl_jpCadFuncionario);
		getContentPane().setLayout(groupLayout);

	}

	public void setFuncionarioEdicao(Funcionario funcionario) {
		// TODO Auto-generated method stub
		this.funcionario = funcionario;		
		preencheFormulario();
	}
	private void preencheFormulario() {
		if (funcionario != null) {
			txtNome.setText(funcionario.getNome());
			txtEmail.setText(funcionario.getEmail());
			txtTelefone.setText(funcionario.getTelefone());
			txtCpf.setText(funcionario.getCpf());
		}
	}
}
