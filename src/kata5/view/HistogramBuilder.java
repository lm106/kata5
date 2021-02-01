package kata5.view;

import kata5.model.Histogram;
import kata5.model.Person;
import kata5.persistence.PeopleLoader;

/**
 *
 * @author Luzma
 * @version 25-11-2020
 * @since Práctica de Laboratorio
 */
public class HistogramBuilder{
    public Histogram<String> builder(PeopleLoader peopleLoader){
        Histogram<String> histogram = new Histogram();
        for (Person e : peopleLoader.load()) {
            histogram.increment(e.getDomain());
            
        }
        return histogram;
    }
}
