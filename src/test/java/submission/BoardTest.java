package submission;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BoardTest {

    // input sanitation
    @Test
    void can_only_instantiate_with_array_length_9() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.O    , TileState.O,     TileState.O,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.EMPTY));

        assertThrows(IllegalArgumentException.class, () -> new Board(input));
    }



    // multiple wins error
    @Test
    void error_when_multiple_wins_on_board() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.O,     TileState.O,     TileState.O,
                                                                   TileState.X,     TileState.X,     TileState.X,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY));

        Board testBoard = new Board(input);
        assertThrows(IllegalStateException.class, testBoard::checkGrid);
    }

    @Test
    void dont_error_when_multiple_same_wins_on_board() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.O,     TileState.O,     TileState.O,
                                                                   TileState.O,     TileState.O,     TileState.O,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.O_WIN);
    }



    // O
    @Test
    void o_wins_top_row() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.O    , TileState.O,     TileState.O,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.O_WIN);
    }

    @Test
    void o_wins_middle_row() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.O,     TileState.O,     TileState.O,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.O_WIN);
    }

    @Test
    void o_wins_bottom_row() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.O,     TileState.O,     TileState.O));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.O_WIN);
    }

    @Test
    void o_wins_left_col() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.O, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.O, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.O, TileState.EMPTY, TileState.EMPTY));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.O_WIN);
    }

    @Test
    void o_wins_middle_col() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.EMPTY, TileState.O, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.O, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.O, TileState.EMPTY));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.O_WIN);
    }

    @Test
    void o_wins_right_col() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.EMPTY, TileState.EMPTY, TileState.O,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.O,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.O));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.O_WIN);
    }

    @Test
    void o_wins_forward_diagonal() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.EMPTY, TileState.EMPTY, TileState.O,
                                                                   TileState.EMPTY, TileState.O,     TileState.EMPTY,
                                                                   TileState.O,     TileState.EMPTY, TileState.EMPTY));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.O_WIN);
    }

    @Test
    void o_wins_backward_diagonal() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.O,     TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.O,     TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.O));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.O_WIN);
    }



    // X
    @Test
    void x_wins_top_row() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.X,     TileState.X,     TileState.X,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.X_WIN);
    }

    @Test
    void x_wins_middle_row() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.X,     TileState.X,     TileState.X,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.X_WIN);
    }

    @Test
    void x_wins_bottom_row() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.X,     TileState.X,     TileState.X));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.X_WIN);
    }

    @Test
    void x_wins_left_col() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.X, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.X, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.X, TileState.EMPTY, TileState.EMPTY));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.X_WIN);
    }

    @Test
    void x_wins_middle_col() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.EMPTY, TileState.X, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.X, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.X, TileState.EMPTY));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.X_WIN);
    }

    @Test
    void x_wins_right_col() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.EMPTY, TileState.EMPTY, TileState.X,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.X,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.X));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.X_WIN);
    }

    @Test
    void x_wins_forward_diagonal() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.EMPTY, TileState.EMPTY, TileState.X,
                                                                   TileState.EMPTY, TileState.X,     TileState.EMPTY,
                                                                   TileState.X,     TileState.EMPTY, TileState.EMPTY));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.X_WIN);
    }

    @Test
    void x_wins_backward_diagonal() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.X,     TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.X,     TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.X));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.X_WIN);
    }



    // UNDECIDED
    @Test
    void empty_board_undecided() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY,
                                                                   TileState.EMPTY, TileState.EMPTY, TileState.EMPTY));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.UNDECIDED);
    }



    // DRAW
    @Test
    void draw() {
        ArrayList<TileState> input = new ArrayList<>(Arrays.asList(TileState.X, TileState.O, TileState.X,
                                                                   TileState.O, TileState.X, TileState.X,
                                                                   TileState.O, TileState.X, TileState.O));

        Board testBoard = new Board(input);
        assert (testBoard.checkGrid() == GameState.DRAW);
    }

}