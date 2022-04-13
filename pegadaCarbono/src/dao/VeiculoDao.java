package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Veiculo;
import util.ConnectionUtil;

public class VeiculoDao {
	private static VeiculoDao instance;
	private Connection con = ConnectionUtil.getConnection();
	
	public static VeiculoDao getInstance() {
		if (instance == null) {
			instance = new VeiculoDao();
		}
		return instance;
	}
	
	public void cadastrar(Veiculo veiculo){
		try {
			String sql = "insert into veiculo (placa) values (?)";
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, veiculo.getPlaca());

			int generatedKey = 	pstmt.executeUpdate();
			
			if (generatedKey > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
			    generatedKey = rs.getInt(1);
			    veiculo.setId(generatedKey);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Veiculo veiculo) {
		try {
			String sql = "update veiculo set placa = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, veiculo.getPlaca());
			pstmt.setInt(2, veiculo.getId());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(int idVeiculo) {
		try {
			String sql = "delete from veiculo where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idVeiculo);
			pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Veiculo> listar() {
		List<Veiculo> listaVeiculos = new ArrayList<>(); 
		try {
			String sql = "select * from veiculo";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Veiculo v = new Veiculo();
				v.setId(rs.getInt("id"));
				v.setPlaca(rs.getString("placa"));
				listaVeiculos.add(v);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listaVeiculos;
	}
}
