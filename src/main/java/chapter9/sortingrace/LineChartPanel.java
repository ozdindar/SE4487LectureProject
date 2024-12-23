package chapter9.sortingrace;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import utils.Pair;

import java.util.HashMap;
import java.util.Map;

public class LineChartPanel extends ApplicationFrame  {

    final Map<String, XYSeries> seriesMap;
    final XYSeriesCollection dataset;
    long current;
    final JFreeChart chart;
    final ChartPanel chartPanel;

    public LineChartPanel(final String title) {
        super(title);
        seriesMap = new HashMap<>();
        dataset = new XYSeriesCollection();
        chart = createChart(dataset);
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        chartPanel.setMouseZoomable(true, false);
        setContentPane(chartPanel);
        current=0;
    }

    private JFreeChart createChart(final XYDataset dataset) {
        return ChartFactory.createTimeSeriesChart(
                "Sorting Race",
                "Seconds",
                "Value",
                dataset,
                true,
                false,
                false);
    }

    public synchronized void addData(Pair<String,Double> data)
    {
        String key = data.first();
        if (!seriesMap.containsKey(key))
        {
            XYSeries series = new XYSeries(key);
            seriesMap.put(key,series);
            dataset.addSeries(series);
        }
        seriesMap.get(key).add(current++,data.second());
        chartPanel.updateUI();
    }

    public void showPanel()
    {
        pack( );
        RefineryUtilities.positionFrameOnScreen(this,0,0);
        setVisible( true );
    }
}