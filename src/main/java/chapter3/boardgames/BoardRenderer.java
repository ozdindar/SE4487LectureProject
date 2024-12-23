package chapter3.boardgames;

public interface BoardRenderer<B> {
    static BoardRenderer NoRender = (board)->{};
    void render(B board);
}
