package kata5.persistence;

import java.util.ArrayList;
import java.util.List;
import kata5.model.Person;

/**
 *
 * @author Luzma
 * @version 25-11-2020
 * @since Práctica de Laboratorio
 */
public interface PeopleLoader{
    public List<Person> load();     
}
