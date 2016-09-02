package br.com.fabricadeprogramador.fabricaweb;

import br.com.fabricadeprogramador.persistencia.entidade.Cliente;
import br.com.fabricadeprogramador.persistencia.jdbc.ClienteDAO;

public class TesteClienteDAO {

	public static void main(String[] args) {

		///cadastrar();
		deletar();

	}

	private static void deletar() {
		Cliente clienteDelete = new Cliente();	
		clienteDelete.setId(3);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.deletar(clienteDelete);
		
	}

	private static void cadastrar() {

		Cliente cliente = new Cliente("Maria", "88888", "202020","F","Ponta Pora");
//		cliente.setNome("Uemerson");
//		cliente.setCpf("996.168.581-49");
//		cliente.setRg("101010");
//		cliente.setSexo("M");
//		cliente.setCidade("Campo Grande");

		ClienteDAO clienteDAO = new ClienteDAO();

		clienteDAO.cadastrar(cliente);
	}
}
