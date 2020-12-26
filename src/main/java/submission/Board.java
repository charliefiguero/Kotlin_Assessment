package submission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class Board {
    private static final int[] rowIndexs = {0,1,2};
    private static final int[] colIndexs = {0,3,6};
    private static final int[] fdiagIndexs = {6,4,2};
    private static final int[] bdiagIndexs = {0,4,8};

    // 1D array for random access efficiency
    // indexed:
    //      0, 1, 2
    //      3, 4, 5
    //      6, 7, 8
    private ArrayList<TileState> grid;

    public Board(ArrayList<TileState> grid) throws IllegalArgumentException {
        if (grid.size() != 9) {
            throw new IllegalArgumentException("Initialised Board with grid size != 9");
        }
        this.grid = grid;
    }

    private Optional<GameState> checkWin(ArrayList<TileState> arr) {
        if (Collections.frequency(arr, TileState.O) == 3) {
            return Optional.of(GameState.O_WIN);
        }
        else if (Collections.frequency(arr, TileState.X) == 3) {
            return Optional.of(GameState.X_WIN);
        }
        else {
            return Optional.empty();
        }
    }

    // checks the board for a win, draw or undecided game
    public GameState checkGrid() throws IllegalStateException {
        ArrayList<GameState> winsOnBoard = new ArrayList<>();

        // check rows
        for (int i = 0; i < 3; i++) {
            ArrayList<TileState> row = new ArrayList<>();
            for (int index : rowIndexs) {
                row.add(grid.get(index + (3*i)));
            }
            checkWin(row).ifPresent(winsOnBoard::add);
        }

        // check cols
        for (int i = 0; i < 3; i++) {
            ArrayList<TileState> col = new ArrayList<>();
            for (int index : colIndexs) {
                col.add(grid.get(index + i));
            }
            checkWin(col).ifPresent(winsOnBoard::add);
        }

        // check forward diagonal
        ArrayList<TileState> fdiag = new ArrayList<>();
        for (int index : fdiagIndexs) {
            fdiag.add(grid.get(index));
        }
        checkWin(fdiag).ifPresent(winsOnBoard::add);

        // check backward diagonal
        ArrayList<TileState> bdiag = new ArrayList<>();
        for (int index : bdiagIndexs) {
            bdiag.add(grid.get(index));
        }
        checkWin(bdiag).ifPresent(winsOnBoard::add);

        // check for multiple win types
        if (winsOnBoard.contains(GameState.O_WIN) &&
            winsOnBoard.contains(GameState.X_WIN)) {
            throw new IllegalStateException("Board contains a win for both O and X.");
        }
        else if (winsOnBoard.size() >= 1) {
            // all wins on board are the same so pick one
            return winsOnBoard.get(0);
        }

        // check for draw
        if (!grid.contains(TileState.EMPTY)) {
            return GameState.DRAW;
        }

        return GameState.UNDECIDED;
    }
}
