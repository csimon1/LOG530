package mastermind;

import java.util.ArrayList;
import java.util.List;

/**
 * Class Board : Definit un espace de jeux. (un endroit ou poser les pions)
 * copyright Sean McCarthy, license GPL v2 or later 
 */

public class Board {
	private List<Row> __board;
	
	/**
	 * Creation d'une table de jeux
	 * @return 
	 */
	public Board() {
		this.__board = new ArrayList<Row>();
	}
	
	/**
	 * Recuperation d'une ligne du jeux
	 * @param rownum : index de la ligne a recupere
	 * @return __row__::Row
	 */
	public Row getRow(int rownum){
        return __board.get(rownum);
	}

	/**
	 * Ajout d'une ligne au jeux
	 * @param row : ligne a rajoute
	 * @return void
	 */
    public void addRow(Row row){
        __board.add(row);
	}

	/**
	 * Retourne la liste de l'ensemble des lignes constituant le jeux
	 * @return list<__row__::Row *>
	 */
    public List<Row> getRows(){
        return __board;
    }
}
