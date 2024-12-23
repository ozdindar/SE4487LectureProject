package chapter9.gameOfLife;

import javax.swing.*;

public class Demo {
    public static void main_old(String[] args) {
        boolean[][] bm = new boolean[10][10];
        bm[3][2]=true;
        bm[1][5]=true;
        bm[6][0]=true;

        JFrame main= new JFrame("Game of Life");
        BitMatrixPanel panel = new BitMatrixPanel((x, y)->bm[x][y],10);
        main.add(panel);


        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setResizable(false);
        main.setSize(800,800);

        main.setVisible(true);
    }

    public static void main(String[] args) {

        final int worldSize = 100;
        GOLWorld g = new GOLWorld(worldSize);

        JFrame main= new JFrame("Game of Life");
        BitMatrixPanel panel = new BitMatrixPanel(g,worldSize);

        g.addObserver(panel::repaint);
        main.add(panel);

        for (int r = 0; r < 50; r++) {
            for (int c = 0; c < 10; c++) {
                g.setAlive(20+r,20+c);
            }
        }

        g.startLife();

        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setResizable(false);
        main.setSize(800,800);

        main.setVisible(true);
    }
}
