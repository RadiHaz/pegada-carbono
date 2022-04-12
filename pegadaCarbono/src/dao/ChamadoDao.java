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
			
			String sql = "insert into chamado (distancia, id_funcionario, data) values (?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setDouble(1, chamado.getDistancia());
			pstmt.setInt(2, chamado.getFuncionario().getId());
			pstmt.setDate(3, java.sql.Date.valueOf(chamado.getData()));
			
			int generatedKey = 	pstmt.executeUpdate();
			
			if (generatedKey > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
			    generatedKey = rs.getInt(1);
			    chamado.setId(generatedKey);
			    System.out.println("Chamado Key: " + chamado.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Chamado chamado) {
		try {
			
			String sql = "update chamado set distancia = ?, id_funcionario = ?, data = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, chamado.getDistancia());
			pstmt.setInt(2, chamado.getFuncionario().getId());
			pstmt.setDate(3, java.sql.Date.valueOf(chamado.getData()));
			pstmt.setInt(4, chamado.getId());
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
			Chamado c = new Chamado();
			while (rs.next()) {	
				c.setId(rs.getInt("id"));
				c.setDistancia(rs.getDouble("distancia"));
				c.setData(rs.getDate("data").toLocalDate());
				listaChamados.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listaChamados;
	}
}
