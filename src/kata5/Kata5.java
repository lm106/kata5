package kata5;

import kata5.model.Person;
import kata5.persistence.SqlitePeopleLoader;
import kata5.persistence.PeopleLoader;
import kata5.view.HistogramDisplay;
import kata5.view.SwingHistogramDisplay;
import kata5.model.Histogram;
import java.sql.*;
import kata5.view.HistogramBuilder;

/**
 *
 * @author Luzma
 * @version 25-11-2020
 * @since Práctica de Laboratorio
 */
public class Kata5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        
        PeopleLoader peopleLoader = new SqlitePeopleLoader();
        HistogramBuilder histogram = new HistogramBuilder();
        HistogramDisplay histogramDisplay = new SwingHistogramDisplay("Histogram Emails Domains", histogram.builder(peopleLoader));
        histogramDisplay.execute();
    }
    
}
