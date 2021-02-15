package com.rock_paper_scissors_lizard_spock;

public interface Move {
    String name();
    RoundResult winsWith(Move otherPlayer);
}
