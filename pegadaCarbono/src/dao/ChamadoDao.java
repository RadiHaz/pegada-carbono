package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Chamado;
import util.ConnectionUtil;

public class ChamadoDao {
	
	private static ChamadoDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static ChamadoDao getInstance() {
		if (instance == null) {
			instance = new ChamadoDao();
		}
		return instance;
	}
	
	public void cadastrar(Chamado chamado){
		try {
			String sql = "insert into chamado (endereco, distancia, id_funcionario, id_veiculo, data) values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, chamado.getEndereco());
			pstmt.setDouble(2, chamado.getDistancia());
			pstmt.setInt(3, chamado.getFuncionario().getId());
			pstmt.setInt(4, chamado.getVeiculo().getId());
			pstmt.setDate(5, java.sql.Date.valueOf(chamado.getData()));
			
			int generatedKey = 	pstmt.executeUpdate();
			
			if (generatedKey > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
			    generatedKey = rs.getInt(1);
			    chamado.setId(generatedKey);
			    System.out.println(chamado.getId());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Chamado chamado) {
		try {
			
			String sql = "update chamado set endereco = ?, distancia = ?, id_funcionario = ?, id_veiculo = ?, data = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, chamado.getEndereco());
			pstmt.setDouble(2, chamado.getDistancia());
			pstmt.setInt(3, chamado.getFuncionario().getId());
			pstmt.setInt(4, chamado.getVeiculo().getId());
			pstmt.setDate(5, java.sql.Date.valueOf(chamado.getData()));
			pstmt.setInt(6, chamado.getId());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(int idChamado) {
		try {
			String sql = "delete from chamado where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idChamado);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Chamado> listar() {
		List<Chamado> listaChamados = new ArrayList<>();
		try {
			String sql = "select * from chamado";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Chamado c = new Chamado();
				c.setId(rs.getInt("id"));
				c.setEndereco(rs.getString("endereco"));
				c.setDistancia(rs.getDouble("distancia"));
				c.getFuncionario().setId(rs.getInt("id_funcionario"));
				c.getVeiculo().setId(rs.getInt("id_veiculo"));
				c.setData(rs.getDate("data").toLocalDate());
				listaChamados.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listaChamados;
	}
}
