package net.flutterflies.ticytacy.board;

/**
 * Created by ashrynn on 8/4/16.
 */
public class TTCell {

    public static final int NO_PLAYER = 2;
    public static final int BLUE_PLAYER = 1;
    public static final int PURPLE_PLAYER = 0;

    private int owner;

    public TTCell() {
        this(NO_PLAYER);
    }

    public TTCell(int owner) {
        this.owner = owner;
    }

    void setOwner(int owner) {
        this.owner = owner;
    }

    public int getOwner() {
        return owner;
    }
}
