import java.sql.ResultSet;


public class Controle {
	public static void main(String[] args) {
		//Conexao("BANCO","LOCAL/IP","PORTA","MEU DB","USUARIO","SENHA");
		ConexaoDB c = new ConexaoDB("PostgreSql","localhost","5432","postgres","postgres","logina1"); 
		c.conect(); 
		//... 
		//String q = "CREATE TABLE" + '"' + "tabela3" + '"' +'(' + '"' + "coluna1" + '"' + "varchar(40), " + '"' + "coluna2" + '"' +"varchar(40));" ;
		String comandoSql = "INSERT INTO" + '"' + "tabela3" + '"' + "(" + '"' + "coluna1" + '"'+ "," + '"'+"coluna2" + '"' + ")  VALUES( " + "'" + "testefinal" + "'" + "," +  "'" +  "testefinal" +  "'" + ");"; 
		System.out.println(comandoSql);
		
		//c.query(q);
		c.atualiza(comandoSql);
		c.disconect();

		
	}
}
