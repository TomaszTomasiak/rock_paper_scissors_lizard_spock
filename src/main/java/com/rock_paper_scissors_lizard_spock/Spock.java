package com.rock_paper_scissors_lizard_spock;

public class Spock implements Move {
    @Override
    public String name() {
        return "spock";
    }

    @Override
    public RoundResult winsWith(Move otherPlayer) {
        if (otherPlayer instanceof Scissors){
            return new RoundResult(true, false);
        } else if (otherPlayer instanceof Paper){
            return new RoundResult(false, false);
        } else if (otherPlayer instanceof Rock){
            return new RoundResult(true, false);
        } else if (otherPlayer instanceof Lizard){
            return new RoundResult(false, false);
        } else {
            return new RoundResult(false, true);
        }
    }
}
