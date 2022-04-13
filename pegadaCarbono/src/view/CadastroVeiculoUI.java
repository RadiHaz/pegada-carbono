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
import controller.VeiculoController;
import model.Funcionario;
import model.Veiculo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroVeiculoUI extends JInternalFrame {
	private JTextField txtPlaca;
	private Veiculo veiculo;

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVeiculoUI frame = new CadastroVeiculoUI();
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
	public CadastroVeiculoUI() {
		setClosable(true);
		setTitle("Cadastro de Ve\u00EDculo");
		setBounds(100, 100, 360, 142);
		
		JPanel jpCadVeiculo = new JPanel();
		jpCadVeiculo.setBorder(new TitledBorder(null, "Ve\u00EDculo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadVeiculo, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadVeiculo, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		
		JLabel cadPlaca = new JLabel("Placa:");
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (veiculo != null && veiculo.getId() > 0) {
						veiculo.setPlaca(txtPlaca.getText());
						new VeiculoController().atualizar(veiculo);
					}
					else {
						
						Veiculo veiculo = new Veiculo();
						if(txtPlaca.getText().isEmpty() == false) {
						veiculo.setPlaca(txtPlaca.getText());
						}
						
						new VeiculoController().cadastrar(veiculo);
					}
					JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso.");
					dispose();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário");
					}
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPlaca.setText("");
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(e -> this.dispose());
		
		GroupLayout gl_jpCadVeiculo = new GroupLayout(jpCadVeiculo);
		gl_jpCadVeiculo.setHorizontalGroup(
			gl_jpCadVeiculo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadVeiculo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadVeiculo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpCadVeiculo.createSequentialGroup()
							.addComponent(cadPlaca)
							.addGap(19)
							.addComponent(txtPlaca, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
							.addGap(17))
						.addGroup(gl_jpCadVeiculo.createSequentialGroup()
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(3)
							.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_jpCadVeiculo.setVerticalGroup(
			gl_jpCadVeiculo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_jpCadVeiculo.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_jpCadVeiculo.createParallelGroup(Alignment.BASELINE)
						.addComponent(cadPlaca)
						.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpCadVeiculo.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCadastrar)
						.addComponent(btnLimpar)
						.addComponent(btnSair))
					.addGap(93))
		);
		jpCadVeiculo.setLayout(gl_jpCadVeiculo);
		getContentPane().setLayout(groupLayout);

	}
	public void setVeiculoEdicao(Veiculo veiculo) {
		// TODO Auto-generated method stub
		this.veiculo = veiculo;		
		preencheFormulario();
	}
	private void preencheFormulario() {
		if (veiculo != null) {
			txtPlaca.setText(veiculo.getPlaca());
		}
	}

}
