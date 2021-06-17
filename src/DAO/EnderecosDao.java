package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entidade.Enderecos;
import JDBC.ConnectionFactory;

public class EnderecosDao {
	private Connection conexao;
	
	public EnderecosDao() {
		new ConnectionFactory();
		this.conexao = ConnectionFactory.getConnection();	
	}
	
	public void cadastraEnderecos(Enderecos endereco) {
		String sql = "INSERT INTO ENDERECOS(id, RUA, NUMERO, COMPLEMENTO, RUA, BAIRRO, CIDADE, ESTADO, PAIS, CEP) VALUES"
        		+ " ((SELECT MAX(id) FROM ENDERECOS) + 1, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt=conexao.prepareStatement(sql);
			stmt.setString(1, endereco.getRua());
			stmt.setString(2, endereco.getNumero());
			stmt.setString(3, endereco.getComplemento());
			stmt.setString(4, endereco.getRua());
			stmt.setString(5, endereco.getBairro());
			stmt.setString(6, endereco.getCidade());
			stmt.setString(7, endereco.getEstado());
			stmt.setString(8, endereco.getPais());
			stmt.setString(9, endereco.getCep());
			
			stmt.execute();
            conexao.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void alterarEndereco(Enderecos endereco) {
		String sql = "UPDATE penderecos SET rua = ?, numero = ?, complemento = ?, rua = ?, bairro = ?, cidade = ?,"
				+ "estado = ?, pais = ?, cep = ?, WHERE id = ?";
		try {
            PreparedStatement stmt=conexao.prepareStatement(sql);
            stmt.setString(1, endereco.getRua());
			stmt.setString(2, endereco.getNumero());
			stmt.setString(3, endereco.getComplemento());
			stmt.setString(4, endereco.getRua());
			stmt.setString(5, endereco.getBairro());
			stmt.setString(6, endereco.getCidade());
			stmt.setString(7, endereco.getEstado());
			stmt.setString(8, endereco.getPais());
			stmt.setString(9, endereco.getCep());
            
            stmt.execute();
            stmt.close();
            conexao.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(EnderecosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	 public void deletaEndereco(Enderecos endereco){
	        String sql ="DELETE FROM enderecos WHERE id = ?";       
	        try {
	            PreparedStatement stmt=conexao.prepareStatement(sql);
	            stmt.setInt(1, endereco.getId());
	            
	            stmt.execute();
	            stmt.close();
	            conexao.close();
	        } catch (SQLException ex) {
	            Logger.getLogger(EnderecosDao.class.getName()).log(Level.SEVERE, null, ex);
	        }
	    }
	 
	 public List<Enderecos> getList(){
	        List<Enderecos> endereco = new ArrayList();
	        String sql = "SELECT ID, RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, ESTADO, PAIS, CEP FROM ENDERECOS";
	        try {
	            PreparedStatement stmt = conexao.prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                Enderecos end = new Enderecos();
	                end.setId(rs.getInt("ID"));
	                end.setRua(rs.getString("RUA"));
	                end.setNumero(rs.getString("NUMERO"));
	                end.setComplemento(rs.getString("COMPLEMENTO"));
	                end.setBairro(rs.getString("BAIRRO"));
	                end.setCidade(rs.getString("CIDADE"));
	                end.setEstado(rs.getString("ESTADO"));
	                end.setPais(rs.getString("PAIS"));
	                end.setCep(rs.getString("CEP"));
	                
	                endereco.add(end);
	            }   
	            stmt.close();
	            rs.close();
	            conexao.close();
	        } catch (SQLException e) {
	            throw new RuntimeException();
	        }
	        return endereco;
	    }
	}

