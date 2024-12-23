package chapter9.sortingrace;

import chapter9.sortingrace.sorters.*;
import utils.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

class SortingTask implements Runnable {

    int max;
    ArraySorter sorter;
    List<TaskObserver<Pair<String,Double>>> observers;

    SortingTask(ArraySorter sorter, int max) {
        this.sorter= sorter;
        this.max = max;
        observers = new ArrayList<>();
    }

    @SafeVarargs
    SortingTask(ArraySorter sorter, int max, TaskObserver<Pair<String,Double>> ...observers) {
        this(sorter,max);
        this.observers.addAll(List.of(observers));
    }

    @Override
    public void run() {
        int arr[];
        for (int i = 2; i < max; i++) {
            arr = IntStream.range(0,i).toArray();
            Shuffler.shuffle(arr);
            sorter.sort(arr);
            notifyObservers(i);
        }
    }

    private void notifyObservers(int i) {
        for(TaskObserver<Pair<String,Double>> observer:observers)
            observer.taskCompleted(Pair.of(sorter.getName(),(double)i));
    }
}

public class SortingRace {

    List<ArraySorter> sorters;
    LineChartPanel panel;
    int max;

    public SortingRace(LineChartPanel panel,int max)
    {
        this.sorters = new ArrayList<>();
        this.panel = panel;
        this.max=max;
    }

    public void addSorter(ArraySorter sorter)
    {
        sorters.add(sorter);
    }

    public void start()
    {
        panel.showPanel();

        ExecutorService es = Executors.newFixedThreadPool(8);
        for (ArraySorter sorter:sorters)
            es.submit(new SortingTask(sorter,max,panel::addData));

        es.shutdown();
    }

    public static void main(String[] args) {

        LineChartPanel panel = new LineChartPanel("Sorting Race");
        SortingRace race = new SortingRace(panel,1000000);

        race.addSorter(new BubbleSort());
        race.addSorter(new SelectionSort());
        race.addSorter(new MergeSort());
        race.addSorter(new QuickSort());
        race.addSorter(new StreamSort());
        race.addSorter(new ParallelStreamSort());


        race.start();


    }
}
