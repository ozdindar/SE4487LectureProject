package chapter3.boardgames;

import utils.Pauser;

import javax.swing.text.AbstractDocument;
import java.util.ArrayList;
import java.util.List;

public abstract class BoardGame<B extends Board<M, BI, BII> , M, BI, BII > implements Game{
    B board;
    protected List<Player<M,BI>> players;
    int currentPlayer;
    private BoardRenderer<B> renderer = BoardRenderer.NoRender;
    long pause;


    public BoardGame(B board) {
        this.board = board;
        players = new ArrayList<>();
    }

    public void setRenderer(BoardRenderer<B> renderer) {
        this.renderer = renderer;
    }

    public void setPause(long pause) {
        this.pause = pause;
    }

    public void addPlayer(Player<M,BI> player)
    {
        players.add(player);
    }

    @Override
    public void play()
    {
        initGame();

        while(!board.isGameOver())
        {
            Player<M,BI> player = players.get(currentPlayer);
            BI bi = board.boardInfo();
            M move = player.makeMove(bi);
            udpateMove(move);
        }

        endGame();
    }

    private void udpateMove(M move) {
        currentPlayer = board.update(move);
        if (renderer != null)
            renderer.render(board);
        Pauser.pause(pause);

    }

    private void endGame() {
        for (Player<M,BI> player:players)
            player.endGame();

        board.endGame(); // hook
        System.out.println("Game is OVER!!");
    }

    private void initGame() {
        for (Player<M,BI> player:players)
            player.init();

        BII bii = _init();
        currentPlayer = board.init(bii);
    }

    protected abstract BII _init();

}
