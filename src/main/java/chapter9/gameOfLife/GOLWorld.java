package chapter9.gameOfLife;

import java.util.ArrayList;
import java.util.List;

public class GOLWorld implements BitMatrix{

    boolean[][] cells;
    int worldSize;

    List<Updateable> observers;

    public GOLWorld(boolean[][] cells, int worldSize) {
        this.cells = cells;
        this.worldSize = worldSize;
        observers = new ArrayList<>();
    }


    public GOLWorld(int worldSize) {
        this.worldSize = worldSize;
        cells = new boolean[worldSize][worldSize];
        observers = new ArrayList<>();
    }

    void addObserver(Updateable updateable)
    {
        observers.add(updateable);
    }

    void setAlive(int r, int c)
    {
        cells[r][c] = true;
        notifyObservers();
    }

    /**
     * Updates the cells according to the game of life rules
     */
    void next()
    {
        boolean[][] newCells = new boolean[worldSize][worldSize];
        for (int r = 0; r < worldSize; r++) {
            for (int c = 0; c < worldSize; c++) {
                newCells[r][c] = next(r,c);
            }
        }
        cells = newCells;
        notifyObservers();

    }

    void startLife()
    {
        new Thread(()->{
            while(true) {
                next();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    private void notifyObservers() {
        for (Updateable observer: observers)
            observer.update();
    }

    private boolean next(int r, int c) {
        int aliveNeighborCount = aliveNeighborCount(r,c);

        return ( (cells[r][c] && aliveNeighborCount ==2)) || (aliveNeighborCount==3) ;
    }

    private int aliveNeighborCount(int r, int c) {
        int[][] negihbors = { {1,0}/*Down*/, {-1,0}/*Up*/,{0,1}/*Right*/,{0,-1}/*Left*/, {1,1}, {1,-1}, {-1,-1}, {-1,1}};
        int aliveCount=0;
        for (int[] n: negihbors )
        {
            int nr = r + n[0];
            int nc = c + n[1];
            if (nr>=0 && nr<worldSize && nc>=0 && nc<worldSize && cells[nr][nc])
                aliveCount++;
        }

        return aliveCount;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int r = 0; r < worldSize; r++) {
            for (int c = 0; c < worldSize; c++)
            {
                s.append(cells[r][c]?'1':'0');
            }
            s.append("\n");
        }
        return s.toString();
    }

    @Override
    public boolean get(int r, int c) {
        return cells[r][c];
    }

    public static void main(String[] args) throws InterruptedException {
        GOLWorld g = new GOLWorld(5);
        g.setAlive(1,1);
        g.setAlive(1,2);
        g.setAlive(1,3);


        while (true)
        {
            System.out.println(g);
            g.next();
            Thread.sleep(1000);
        }

    }
}
