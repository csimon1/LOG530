package mastermind.__board__;

import mastermind.__row__.*;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Row;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Board;
public class Board  {
/**
Class board, a collection of rows
*/
	public java.util.LinkedList<Row> __board;

	public Board() {
	}
	public Board(int __ss_init) {
		__init__();
	}
	public final java.util.LinkedList<Row > getRows() {
		return this.__board;
	}
	
	public final Row getRow(int rownum) {
		return (this.__board).get(rownum);
	}
	
	public final Object __init__() {
		this.__board = (new java.util.LinkedList<Row>());
		return null;
	}
	
	public final Object addRow(Row row) {
		this.__board.add(row);
		return null;
	}
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __board__


