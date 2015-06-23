package __row__.__board__;

import __shedskin__.*;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Row;

//C++ TO JAVA CONVERTER NOTE: Java has no need of forward class declarations:
//class Board;
public class Board extends pyobj {
/**
Class board, a collection of rows
*/
	public java.util.LinkedList<__row__.Row > __board;

	public Board() {
	}
	public Board(int __ss_init) {
		this.__class__ = GlobalMembersBoard.cl_Board;
		__init__();
	}
	public final java.util.LinkedList<__row__.Row > getRows() {

		return this.__board;
	}
	public final __row__.Row getRow(__ss_int rownum) {

		return (this.__board).__getfast__(rownum);
	}
	public final Object __init__() {

		this.__board = (new java.util.LinkedList<__row__.Row *>());
		return null;
	}
	public final Object addRow(__row__.Row row) {

		(this.__board).append(row);
		return null;
	}
}
//C++ TO JAVA CONVERTER TODO TASK: Only the namespaces at the beginning of the file can be converted to the Java 'package' for this file:
//ORIGINAL LINE: namespace __board__


