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
	private static int generatedKey;
	
	
	public static VeiculoDao getInstance() {
		if (instance == null) {
			instance = new VeiculoDao();
		}
		return instance;
	}
	
	public void cadastrar(Veiculo veiculo){
		try {
			String sql = "insert into veiculo (id_funcionario, placa, ano, modelo, cor) values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setInt(1, veiculo.getFuncionario().getId());
			pstmt.setString(2, veiculo.getPlaca());
			pstmt.setInt(3, veiculo.getAno());
			pstmt.setString(4, veiculo.getModelo());
			pstmt.setString(5, veiculo.getCor());
			pstmt.execute();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			generatedKey = 0;
			if (rs.next()) {
			    generatedKey = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Veiculo veiculo) {
		try {
			String sql = "update veiculo set id_funcionario = ?, placa = ?, ano = ?, modelo = ?, cor = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, veiculo.getFuncionario().getId());
			pstmt.setString(2, veiculo.getPlaca());
			pstmt.setInt(3, veiculo.getAno());
			pstmt.setString(4, veiculo.getModelo());
			pstmt.setString(5, veiculo.getCor());
			pstmt.setInt(6, generatedKey);
			pstmt.executeUpdate();
			System.out.println("Veiculo Key: " + generatedKey);
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
				v.getFuncionario().setId(rs.getInt("id_funcionario"));
				v.setPlaca(rs.getString("placa"));
				v.setAno(rs.getInt("ano"));
				v.setModelo(rs.getString("modelo"));
				v.setCor(rs.getString("cor"));
				listaVeiculos.add(v);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listaVeiculos;
	}
}