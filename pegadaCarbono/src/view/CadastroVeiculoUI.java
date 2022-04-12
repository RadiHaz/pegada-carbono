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

import controller.VeiculoController;
import model.Veiculo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CadastroVeiculoUI extends JInternalFrame {
	private JTextField txtPlaca;
	private JTextField txtAno;
	private JTextField txtModelo;
	private JTextField txtCor;

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
		setBounds(100, 100, 360, 220);
		
		JPanel jpCadVeiculo = new JPanel();
		jpCadVeiculo.setBorder(new TitledBorder(null, "Ve\u00EDculo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadVeiculo, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jpCadVeiculo, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		JLabel cadPlaca = new JLabel("Placa:");
		
		JLabel cadAno = new JLabel("Ano:");
		cadAno.setToolTipText("Permitido apenas o cadastro de ve\u00EDculos com menos de 8 anos de fabrica\u00E7\u00E3o");
		
		JLabel cadModelo = new JLabel("Modelo:");
		
		JLabel cadCor = new JLabel("Cor:");
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = new Veiculo();
				veiculo.setPlaca(txtPlaca.getText());
				veiculo.setAno(Integer.parseInt(txtAno.getText()));
				veiculo.setModelo(txtModelo.getText());
				veiculo.setCor(txtCor.getText());
				try {
					new VeiculoController().cadastrar(veiculo);
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar veículo!");
				}
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtPlaca.setText("");
				txtAno.setText("");
				txtModelo.setText("");
				txtCor.setText("");
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
							.addComponent(btnCadastrar)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLimpar, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnSair, GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_jpCadVeiculo.createSequentialGroup()
							.addGroup(gl_jpCadVeiculo.createParallelGroup(Alignment.LEADING)
								.addComponent(cadModelo)
								.addComponent(cadCor)
								.addComponent(cadPlaca)
								.addComponent(cadAno))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_jpCadVeiculo.createParallelGroup(Alignment.LEADING)
								.addComponent(txtAno, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
								.addComponent(txtCor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
								.addComponent(txtModelo, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
								.addComponent(txtPlaca, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE))))
					.addGap(17))
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
						.addComponent(cadAno)
						.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpCadVeiculo.createParallelGroup(Alignment.BASELINE)
						.addComponent(cadModelo)
						.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_jpCadVeiculo.createParallelGroup(Alignment.BASELINE)
						.addComponent(cadCor)
						.addComponent(txtCor, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_jpCadVeiculo.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_jpCadVeiculo.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnLimpar)
							.addComponent(btnSair))
						.addComponent(btnCadastrar))
					.addContainerGap())
		);
		jpCadVeiculo.setLayout(gl_jpCadVeiculo);
		getContentPane().setLayout(groupLayout);

	}

}
