
package br.senai.sp.cadastroclientes.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;



import br.senai.sp.cadastroclientes.model.Cliente;

public class ClientesDao {

	private Connection conexao;

	public ClientesDao() {
		conexao = ConectionFactory.conectar();
	}

	public void inserir(Cliente cliente) {
		// comando para inserir as coisas no banco de dados
		String sql = "insert into clientes (nome, email, genero, endereco, num_Tel_Cel, id_prodInteresse, nasc) "
				+ "values (?,?,?,?,?,?,?)";

		PreparedStatement stmt;
		// troco os ? pelo o que foi digitado no formulário
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.setString(3, cliente.getGenero());
			stmt.setString(4, cliente.getEndereco());
			stmt.setString(5, cliente.getTelefone());
			stmt.setString(6, cliente.getProdInteresse());
			stmt.setDate(7, new Date(cliente.getDataNasc().getTimeInMillis()));
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Cliente> listar(){
		// comando para seleionar tudo da tabela do banco de dados e ordenar em ordem alfabética
		String sql = "select * from clientes order by nome asc";
		PreparedStatement stmt;
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			// pega os atributos da tabela e coloca em uma variável j, que depois de tudo é adicionado à lista. o método retorna a lista
			while (rs.next()) {
				// instanciando uma variável do tipo cliente
				Cliente c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelefone(rs.getString("num_Tel_Cel"));
				c.setEmail(rs.getString("email"));
				c.setProdInteresse(rs.getString("id_prodInteresse"));
				c.setGenero(rs.getString("genero"));
				// criando um Calendar com a data atual
				Calendar nascimento = Calendar.getInstance();
				// extraindo o java.sql.Date do banco de daos 
				Date nascDb = rs.getDate("nasc");
				// passando o longo do java.sql.date para calendar
				nascimento.setTimeInMillis(nascDb.getTime());
				// setar o nascimento na variável c 
				c.setDataNasc(nascimento);
				// repetindo o processo anterior para apresentar a data de cadastro
				Calendar cadastro = Calendar.getInstance();
				Timestamp cadDb = rs.getTimestamp("data_cadastro");
				cadastro.setTimeInMillis(cadDb.getTime());
				c.setDataCadastro(cadastro);
				lista.add(c);
			}
			rs.close();
			stmt.close();
			conexao.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir (long idCliente) {
		// comando para excluir a linha no banco de dados
		String sql = "delete from clientes where id = ?";
		PreparedStatement stmt;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idCliente);
			stmt.execute();
			stmt.close();
			conexao.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar (Cliente cliente) {
		// comando para inserir as coisas no banco de dados
				String sql = "update clientes set nome = ?, endereco = ?, num_Tel_Cel = ?, email = ?, id_prodInteresse = ?, genero = ?, nasc = ? where id = ?";
				PreparedStatement stmt;
				// troco os ? pelo o que foi digitado no formulário
				try {
					stmt = conexao.prepareStatement(sql);
					stmt.setString(1, cliente.getNome());
					stmt.setString(2, cliente.getEndereco());
					stmt.setString(3, cliente.getTelefone());
					stmt.setString(4, cliente.getEmail());
					stmt.setString(5, cliente.getProdInteresse());
					stmt.setString(6, cliente.getGenero());
					stmt.setDate(7, new Date(cliente.getDataNasc().getTimeInMillis()));
					stmt.setLong(8, cliente.getId());
					stmt.execute();
					stmt.close();
					conexao.close();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
	}
	
	public Cliente buscar(long idCliente) {
		// comando para seleionar tudo da tabela do banco de dados e ordenar em ordem alfabética
				String sql = "select * from clientes where id = ?";
				PreparedStatement stmt;
				Cliente c = null;
				try {
					stmt = conexao.prepareStatement(sql);
					stmt.setLong(1, idCliente);
					ResultSet rs = stmt.executeQuery();
					// pega os atributos da tabela e coloca em uma variável j, que depois de tudo é adicionado à lista. o método retorna a lista
					while (rs.next()) {
						// instanciando uma variável do tipo cliente
						c = new Cliente();
						c.setId(rs.getLong("id"));
						c.setNome(rs.getString("nome"));
						c.setEndereco(rs.getString("endereco"));
						c.setTelefone(rs.getString("num_Tel_Cel"));
						c.setEmail(rs.getString("email"));
						c.setProdInteresse(rs.getString("id_prodInteresse"));
						c.setGenero(rs.getString("genero"));
						// criando um Calendar com a data atual
						Calendar nascimento = Calendar.getInstance();
						// extraindo o java.sql.Date do banco de daos 
						Date nascDb = rs.getDate("nasc");
						// passando o longo do java.sql.date para calendar
						nascimento.setTimeInMillis(nascDb.getTime());
						// setar o nascimento na variável c 
						c.setDataNasc(nascimento);
						// repetindo o processo anterior para apresentar a data de cadastro
						Calendar cadastro = Calendar.getInstance();
						Timestamp cadDb = rs.getTimestamp("data_cadastro");
						cadastro.setTimeInMillis(cadDb.getTime());
						c.setDataCadastro(cadastro);
					}
					rs.close();
					stmt.close();
					conexao.close();
					return c;
				} catch (Exception e) {
					throw new RuntimeException(e);
			}
	}
	
	
}
