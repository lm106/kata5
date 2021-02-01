package kata5.view;

import kata5.model.Histogram;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;


/**
 *
 * @author Luzma
 * @version 25-11-2020
 * @since Práctica de Laboratorio
 */
public class SwingHistogramDisplay extends ApplicationFrame implements HistogramDisplay{
    Histogram<String> histogram;
    public SwingHistogramDisplay(String title, Histogram<String> histogram) {
        super(title);
        this.histogram = histogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart freeChart = ChartFactory.createBarChart("JFreeChart Histogram", "email domains", "Nº emails", dataset, PlotOrientation.VERTICAL,  false, false, rootPaneCheckingEnabled);
        return freeChart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        int other = 0;
        for (String key : histogram.keySet()) {
            if (this.histogram.get(key) == 1){
                other++;
            } else {
                dataSet.addValue(histogram.get(key), "", key);
            }            
        }
        dataSet.addValue(other, "", "Others");
        return dataSet;
    }
    @Override
    public void execute(){
        this.setVisible(true);
    }
    
    
    
}
