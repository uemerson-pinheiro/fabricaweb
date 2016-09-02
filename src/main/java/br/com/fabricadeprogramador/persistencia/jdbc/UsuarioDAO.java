package br.com.fabricadeprogramador.persistencia.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fabricadeprogramador.persistencia.entidade.Usuario;

public class UsuarioDAO {

	// Conexão ao banco de dados já criado pela ConexãoFactory
	Connection conn = ConexaoFactory.getConnection();

	public void salvar(Usuario usuario) {

		if (usuario.getId() != null && usuario.getId() > 0) {
			alterar(usuario);
		} else {
			cadastrar(usuario);
		}
	}

	public void cadastrar(Usuario usuario) {

		String sql = "INSERT INTO usuario (nome, login, senha) VALUES (?, ?, MD5(?))";

		try (PreparedStatement preparador = conn.prepareStatement(sql)) {

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());

			preparador.execute();

			System.out.println("Usuário cadastrado com sucesso!");
		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void alterar(Usuario usuario) {

		String sql = "UPDATE usuario set nome=?, login=?, senha = MD5(?) where id=? ";

		try (PreparedStatement preparador = conn.prepareStatement(sql)) {

			preparador.setString(1, usuario.getNome());
			preparador.setString(2, usuario.getLogin());
			preparador.setString(3, usuario.getSenha());
			preparador.setInt(4, usuario.getId());
			preparador.execute();

			System.out.println("Usuário alterado com sucesso.");
		} catch (SQLException e) {
			throw new RuntimeException();
		}

	}

	public void excluir(Usuario usuario) {

		String sql = (" DELETE from usuario where id = ?");

		try (PreparedStatement preparador = conn.prepareStatement(sql)) {
			preparador.setInt(1, usuario.getId());
			preparador.execute();

			System.out.println("Usuário excluido com sucesso");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Usuario buscarPorId(Integer id) {

		Usuario usuRetorno = null;

		String sql = (" SELECT * from usuario where id = ?");

		try (PreparedStatement preparador = conn.prepareStatement(sql)) {

			preparador.setInt(1, id);

			// ResultSet recebe o retorno do banco de dados
			ResultSet resultado = preparador.executeQuery();

			if (resultado.next()) {
				usuRetorno = new Usuario();
				usuRetorno.setId(resultado.getInt(id));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setLogin(resultado.getString("login"));
				usuRetorno.setSenha(resultado.getString("senha"));

				System.out.println("Encontrado com sucesso.");

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return usuRetorno;
	}

	public List<Usuario> buscarTodos() {

		List<Usuario> listaRetorno = new ArrayList<>();
		Usuario usuRetorno = null;

		String sql = (" SELECT * from usuario");

		try (PreparedStatement preparador = conn.prepareStatement(sql)) {

			// ResultSet recebe o retorno do banco de dados
			ResultSet resultado = preparador.executeQuery();

			while (resultado.next()) {
				usuRetorno = new Usuario();
				// usuRetorno.setId(resultado.getInt(id));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setLogin(resultado.getString("login"));
				usuRetorno.setSenha(resultado.getString("senha"));

				listaRetorno.add(usuRetorno);

				System.out.println("Encontrado com sucesso.");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaRetorno;
	}

	public Usuario autenticar(Usuario usuConsulta) {

		Usuario usuRetorno = null;
		String sql = "select * from usuario where login=? and senha=md5(?)";

		try (PreparedStatement preparador = conn.prepareStatement(sql)) {

			preparador.setString(1, usuConsulta.getLogin());
			preparador.setString(2, usuConsulta.getSenha());

			// Retorno da consulta em Resultset
			ResultSet resultado = preparador.executeQuery();

			// Se tem registro
			if (resultado.next()) {
				// instancia o objeto Usuario
				usuRetorno = new Usuario();
				usuRetorno.setId(resultado.getInt("id"));
				usuRetorno.setNome(resultado.getString("nome"));
				usuRetorno.setLogin(resultado.getString("login"));
				usuRetorno.setSenha(resultado.getString("senha"));
				System.out.println("Usuário Autenticado");
			}
		} catch (

		SQLException e) {
			throw new RuntimeException(e);
		}
		return usuRetorno;

	}

}
