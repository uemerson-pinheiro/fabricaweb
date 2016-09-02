package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Cliente;

public class ClienteDAO {

	 private Connection conn = ConexaoFactory.getConnection();
	 
	public void salvar(Cliente cliente){}
	
	
	public void cadastrar(Cliente cliente){
		
		String sql = "Insert into cliente (nome, cpf, rg, sexo, cidade) values (?,?,?,?,?) ";
		
		try(PreparedStatement preparador = conn.prepareStatement(sql)) {
			
			preparador.setString(1, cliente.getNome());
			preparador.setString(2, cliente.getCpf());
			preparador.setString(3, cliente.getRg());
			preparador.setString(4, cliente.getSexo());
			preparador.setString(5, cliente.getCidade());
			
			preparador.execute();
			
			System.out.println("Cliente cadastrado com sucesso!");			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	
	}
	public void alterar(Cliente cliente){}
	public void excluir(Cliente cliente){}
	public Cliente buscarPorId(Cliente cliente){
		return null;
	}
	public List<Cliente> buscarTodos(){
		
		return null;
	}


	public void deletar(Cliente clienteDelete) {
		// TODO Auto-generated method stub
		
	}
}
