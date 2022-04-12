package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Funcionario;
import util.ConnectionUtil;

public class FuncionarioDao {
	
	private static FuncionarioDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static FuncionarioDao getInstance() {
		// Singleton //
		if (instance == null) {
			instance = new FuncionarioDao();
		} 
		return instance;
	}
	
	public void cadastrar(Funcionario funcionario){
		try {
			String sql = "insert into funcionario (nome, email, telefone, cpf, id_veiculo) values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, funcionario.getNome());
			pstmt.setString(2, funcionario.getEmail());
			pstmt.setString(3, funcionario.getTelefone());
			pstmt.setString(4, funcionario.getCpf());
			pstmt.setInt(5, funcionario.getVeiculo().getId());
			
			int generatedKey = 	pstmt.executeUpdate();
			
			if (generatedKey > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
			    generatedKey = rs.getInt(1);
			    funcionario.setId(generatedKey);
			    System.out.println("Funcionario: " + funcionario.getId());
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Funcionario funcionario) {
		try {
			String sql = "update funcionario set nome = ?, email = ?, telefone = ?, cpf = ?, id_veiculo = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, funcionario.getNome());
			pstmt.setString(2, funcionario.getEmail());
			pstmt.setString(3, funcionario.getTelefone());
			pstmt.setString(4, funcionario.getCpf());
			pstmt.setInt(5, funcionario.getVeiculo().getId());
			pstmt.setInt(6, funcionario.getId());
			pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(int idFuncionario) {
		try {
			String sql = "delete from funcionario where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idFuncionario);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Funcionario> listar() {
		List<Funcionario> listaFuncionarios = new ArrayList<>(); 
		try {
			String sql = "select * from funcionario";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Funcionario f = new Funcionario();
				f.setId(rs.getInt("id"));
				f.setNome(rs.getString("nome"));
				f.setEmail(rs.getString("email"));
				f.setTelefone(rs.getString("telefone"));
				f.setCpf(rs.getString("cpf"));
				listaFuncionarios.add(f);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listaFuncionarios;
	}
}
