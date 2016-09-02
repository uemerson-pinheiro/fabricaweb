package br.com.fabricadeprogramador.fabricaweb;



import br.com.fabricadeprogramador.persistencia.entidade.Usuario;
import br.com.fabricadeprogramador.persistencia.jdbc.UsuarioDAO;

public class TesteUsuarioDAO2 {

	public static void main(String[] args) {
	//	testeCadastrar();
	//	testeAlterar();
	//	testeExcluir();
//		testeSalvar();
		testeBuscaPorId();
		
	}

	private static void testeBuscaPorId() {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuarioEncontrado = usuarioDAO.buscarPorId(4);
		if(usuarioEncontrado != null){
			
			System.out.println(usuarioEncontrado);
		}
			
			
		
	}

	private static void testeSalvar() {
		Usuario usuario = new Usuario();
		
		usuario.setId(2);
		usuario.setNome("jão");
		usuario.setLogin("jão");
		usuario.setSenha("123");
		
		UsuarioDAO usuarioDao = new UsuarioDAO();
		
		usuarioDao.salvar(usuario);
		
	}

//	private static void testeExcluir() {
//		
//		Usuario usuarioExcluir = new Usuario();
//		usuarioExcluir.setId(3);
//		
//		UsuarioDAO usuarioDAO = new UsuarioDAO();
//		usuarioDAO.excluir(usuarioExcluir);
//	}

//	private static void testeAlterar() {
//		
//		Usuario usuarioAlt = new Usuario();
//		
//		usuarioAlt.setId(2);
//		usuarioAlt.setNome("Maria das neves");
//		usuarioAlt.setLogin("mariaNeve");
//		usuarioAlt.setSenha("123");
//		
//		UsuarioDAO usuarioDao = new UsuarioDAO();
//		
//		usuarioDao.alterar(usuarioAlt);
//		
//	}

//	private static void testeCadastrar() {
//		
//		Usuario usuario = new Usuario();
//		
//		usuario.setNome("Maria");
//		usuario.setLogin("maria");
//		usuario.setSenha("123");
//		
//		UsuarioDAO usuarioDao = new UsuarioDAO();
//		
//		usuarioDao.cadastrar(usuario);
//	}
	
	
	
	
	
	
}
