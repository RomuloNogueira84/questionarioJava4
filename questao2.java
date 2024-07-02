package questionarioaula4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Questão 2 - Caso de Uso 2: Conexão com Banco de Dados
/* Você está desenvolvendo uma aplicação que se conecta a um banco de dados PostgreSQL para
 buscar dados de uma tabela. Se a conexão com o banco de dados falhar, deve ser lançada
 uma exceção personalizada `DatabaseConnectionException`. Se a consulta SQL falhar,
  deve ser lançada uma exceção personalizada `SQLQueryException`.
 */
public class questao2 {
    public static void main(String[] args) {
                String url = "jdbc:postgresql://localhost:5432/pacotao";
                String user = "user_usuario";
                String password = "user_senha";

                Connection conexao = null;
                Statement statement = null;
                ResultSet resultSet = null;

                try {
                    conexao = DriverManager.getConnection(url, user, password);
                    System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

                    statement = conexao.createStatement();
                    String query = "SELECT * FROM tabela";
                    resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String nome = resultSet.getString("nome");
                        String email = resultSet.getString("email");
                        String matricula = resultSet.getString("matricula");
                        System.out.println("ID: " + id + ", Nome: " + nome + ", E-mail: " + email + ", Matrícula: " + matricula);
                    }
                    System.out.println("Consulta executada com sucesso!");
                } catch (SQLException e) {
                    if (e.getSQLState().equals("08001")) {
                        throw new RuntimeException("Erro de conexão com o banco de dados: " + e.getMessage());
                    } else {
                        throw new RuntimeException("Erro na consulta SQL: " + e.getMessage());
                    }
                } finally {
                    try {
                        if (resultSet != null) {
                            resultSet.close();
                        }
                        if (statement != null) {
                            statement.close();
                        }
                        if (conexao != null) {
                            conexao.close();
                        }
                    } catch (SQLException e) {
                        System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
                    }
                }
            }
        }










