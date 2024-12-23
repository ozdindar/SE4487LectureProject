package chapter9.gameOfLife;

import javax.swing.*;
import java.awt.*;

public class BitMatrixPanel extends JPanel  {
    private final Color BackgroundColor= Color.WHITE;
    private final Color CellColor = Color.BLACK;

    BitMatrix world;
    int worldSize;


    public BitMatrixPanel(BitMatrix world, int worldSize) {
        super();
        this.world = world;
        this.worldSize = worldSize;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawBackground(g);

        drawCells(g);
    }

    private void drawCells(Graphics g) {
        for (int r = 0; r < worldSize; r++) {
            for (int c = 0; c < worldSize; c++) {
                if (world.get(r,c))
                    drawCell(g,r,c);
            }
        }

    }

    private void drawCell(Graphics g, int r, int c) {
        int worldLength = Math.min(getWidth(),getHeight());
        g.setColor(CellColor);

        int cellSize = worldLength/worldSize;

        g.fillRect(cellSize*c,cellSize*r,cellSize,cellSize);

    }

    private void drawBackground(Graphics g) {
        g.setColor(BackgroundColor);
        g.fillRect(0,0,getWidth(),getHeight());
    }








}
