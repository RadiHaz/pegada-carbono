package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Chamado;
import model.Funcionario;
import model.Veiculo;
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
			
			String sql = "insert into chamado (distancia, id_funcionario, nome_funcionario, id_veiculo, placa_veiculo, data) values (?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setDouble(1, chamado.getDistancia());
			pstmt.setInt(2, chamado.getFuncionario().getId());
			pstmt.setString(3, chamado.getFuncionario().getNome());
			pstmt.setInt(4, chamado.getVeiculo().getId());
			pstmt.setString(5, chamado.getVeiculo().getPlaca());
			pstmt.setDate(6, java.sql.Date.valueOf(chamado.getData()));
			
			int generatedKey = 	pstmt.executeUpdate();
			
			if (generatedKey > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
			    generatedKey = rs.getInt(1);
			    chamado.setId(generatedKey);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Chamado chamado) {
		try {
			
			String sql = "update chamado set distancia = ?, id_funcionario = ?, nome_funcionario = ?, id_veiculo = ?, placa_veiculo = ?, data = ? where id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setDouble(1, chamado.getDistancia());
			pstmt.setInt(2, chamado.getFuncionario().getId());
			pstmt.setString(3, chamado.getFuncionario().getNome());
			pstmt.setInt(4, chamado.getVeiculo().getId());
			pstmt.setString(5, chamado.getVeiculo().getPlaca());
			pstmt.setDate(6, java.sql.Date.valueOf(chamado.getData()));
			pstmt.setInt(7, chamado.getId());
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
				c.setDistancia(rs.getDouble("distancia"));
				c.setData(rs.getDate("data").toLocalDate());
				
				Funcionario f = new Funcionario();
				f.setId(rs.getInt("id_funcionario"));
				f.setNome(rs.getString("nome_funcionario"));
				
				Veiculo v = new Veiculo();
				v.setId(rs.getInt("id_veiculo"));
				v.setPlaca(rs.getString("placa_veiculo"));
				
				c.setFuncionario(f);
				c.setVeiculo(v);
				
				listaChamados.add(c);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listaChamados;
	}

}
