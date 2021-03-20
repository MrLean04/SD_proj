package repository;

import java.util.Random;

/**
 *
 * @author Leandro e João
 */
public class Ticket {

    private final int  Numticket;

	/**
	 * Piece's constructor that initializes a new piece from a random EnumPiece.
	 */
	public Ticket(int Numticket) {
        this.Numticket = Numticket;
    }

	/**
	 * Retrieves the id of piece.
	 * @return id of piece
	 */
	public int getNumticket() {
        return this.Numticket;
    }

}