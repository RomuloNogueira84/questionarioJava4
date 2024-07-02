package questionarioaula4;
//Questãi 1 - Caso de Uso 1: Leitura de Arquivo e Processamento de Dados
/*
//Você precisa ler um arquivo de texto que contém uma lista de números,
 um em cada linha, e calcular a soma desses números. Se o arquivo não existir,
 deve ser criada uma exceção personalizada `FileNotFoundException`.
 Se uma linha não puder ser convertida para um número, deve ser lançada
 uma exceção personalizada `InvalidNumberFormatException`
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class questao1 {
    public static void main(String[] args) {
                Connection connection = null;
                Statement statement = null;

                try {
                    String url = "jbdc:postgresql://localhost:5432/pacotao";
                    String user = "seu_usuario";
                    String password = "sua_senha";

                    //Estabelecendo conexão com o banco de dados
                    connection = DriverManager.getConnection(url, user, password);
                    System.out.println("Conexão estabelecida com sucesso!");

                    //Criando uma declaração com statement
                    statement = connection.createStatement();
                    String sql = "SELECT * FROM sua_tabela";
                    statement.executeQuery(sql);
                    System.out.println("Consulta executada com sucesso!");
                } catch (SQLException e) {
                    //Tratamento de exceção
                    System.out.println("Erro ao conectar ou executar a consulta!"  + e.getMessage());
                }finally {
                    //Fechando a declarção e a conexão
                    try {
                        if (statement != null){
                            statement.close();
                            System.out.println("Statement fechada com sucesso!");
                        };
                        if (connection != null){
                            connection.close();
                            System.out.println("Connection fechada com sucesso!");

                        }
                    } catch (SQLException e) {
                        System.out.println("Erro ao fechar os recursos: " + e.getMessage());
                    }
                }
            }
        }


