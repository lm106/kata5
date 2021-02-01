package kata5.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import kata5.persistence.PeopleLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kata5.model.Person;


/**
 *
 * @author Luzma
 * @version 25-11-2020
 * @since Práctica de Laboratorio
 */
public class SqlitePeopleLoader implements PeopleLoader {

    public SqlitePeopleLoader() {
    }

    @Override
    public List<Person> load() {
        List<Person> list_people = new ArrayList<Person>();
        try{
            Class.forName("org.sqlite.JDBC"); //Cargar el driver de sqlite
            Connection connection = DriverManager.getConnection("jdbc:sqlite:data/people.db"); //Establece la conexión con el driver de sqlite ya cargado
            
            //Creamos una orden a la base de datos
            Statement statement = connection.createStatement();
                ResultSet set = statement.executeQuery("SELECT * FROM people");
                while(set.next()){
                    String email = set.getString("email");
                    String name = set.getString("first_name");
                    String address = set.getString("address");
                    list_people.add(new Person(name, address, email));
                    
                }
            statement.close();
        }   catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlitePeopleLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SqlitePeopleLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list_people;
    }
    
}
