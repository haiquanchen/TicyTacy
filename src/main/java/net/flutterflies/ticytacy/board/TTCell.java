/*
 * Distributed as part of Ticy Tacy. Ticy Tacy is a Tic-Tac-Toe game
 * made by Ashrynn Macke (Flutterflies). Ticy Tacy is released under
 * the MIT license. You should have received a copy of the MIT license
 * with this code, if not please find it here:
 * http://flutterflies.net/license.html
 */
package net.flutterflies.ticytacy.board;

/**
 * A class representing a cell in the {@link TTBoard}
 *
 * @author Ashrynn Macke | Flutterflies
 * @since 0.1.0
 */
public class TTCell {

    public enum Owners {
        PLAYER_1,
        PLAYER_2,
        NO_PLAYER
    }

    /**
     * A number representing an owner of No player.
     */
    public static final int NO_PLAYER = 2;

    /**
     * A number representing the Blue player.
     */
    public static final int BLUE_PLAYER = 1;

    /**
     * A number representing the Purple player.
     */
    public static final int PURPLE_PLAYER = 0;

    //
    //------------------------------------------------//
    //

    /**
     * The owner of this cell
     */
    private Owners owner;

    /**
     * Construct a new instance of the cell setting the owner to
     * No player.
     */
    public TTCell() {
        this(Owners.NO_PLAYER);
    }

    /**
     * Construct a new instance of the cell setting the owner to
     * a given player.
     *
     * @param owner The owner of the cell.
     */
    public TTCell(Owners owner) {
        this.owner = owner;
    }

    /**
     * Change the owner of the cell.
     *
     * @param owner The new cell owner.
     */
    void setOwner(Owners owner) {
        this.owner = owner;
    }

    /**
     * Get the current owner of the cell.
     *
     * @return The cell owner.
     */
    public Owners getOwner() {
        return owner;
    }
}