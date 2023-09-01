package DAO;

import models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO extends DAO{
	
	public ClienteDAO() {
		super();
		conectar();
	}
	
	public void finaliza() {
		close();
	}
	
	public boolean insert(Cliente cliente) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO Clientes (idade, nome, genero, cpf) "
				       + "VALUES ("+cliente.getIdade()+ ", '" + cliente.getNome() + "', '"  
				       + cliente.getGenero() + "', '" + cliente.getCpf() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public List<Cliente> getAll() {
		List<Cliente> clientes = new ArrayList<>();
	    
	    try {
	        Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        String sql = "SELECT * FROM Clientes";
	        System.out.println(sql);
	        ResultSet rs = st.executeQuery(sql);
	        
	        while (rs.next()) {
	            Cliente cliente = new Cliente(rs.getInt("idade"), rs.getString("nome"), rs.getString("genero"), rs.getInt("cpf"));
	            clientes.add(cliente);
	        }
	        
	        st.close();
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    }
	    
	    return clientes;
	}
	
	public Cliente getByIdade(int idade) {
		Cliente cliente = null;
	    
	    try {
	        Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	        String sql = "SELECT * FROM Clientes where idade = " + idade;
	        System.out.println(sql);
	        ResultSet rs = st.executeQuery(sql);
	        
	        if (rs.next()) {
	            cliente = new Cliente(rs.getInt("idade"), rs.getString("nome"), rs.getString("genero"), rs.getInt("cpf"));
	        }
	        
	        st.close();
	    } catch (Exception e) {
	        System.err.println(e.getMessage());
	    }
	    
	    return cliente;
	}
	
	public boolean update(Cliente cliente) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE Clientes SET idade = '" + cliente.getIdade() + "', nome = '"  
				       + cliente.getNome() + "', genero = '" + cliente.getGenero() + "'"
					   + " WHERE idade = " + cliente.getIdade();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int idade) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM Clientes WHERE idade= " + idade;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
}