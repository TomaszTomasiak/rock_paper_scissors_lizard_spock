package com.rock_paper_scissors_lizard_spock;

public class RoundResult {
    boolean win = false;
    boolean draw = false;

    public RoundResult(boolean win, boolean draw) {
        this.win = win;
        this.draw = draw;
    }

    public boolean isWin() {
        return win;
    }

    public boolean isDraw() {
        return draw;
    }
}
