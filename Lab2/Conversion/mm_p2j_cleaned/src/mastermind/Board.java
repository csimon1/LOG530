package mastermind;

import java.util.ArrayList;
import java.util.List;

public class Board {
	private List<Row> __board;
	
	public Board() {
		this.__board = new ArrayList<Row>();
	}
	
	public Row getRow(int rownum){
        return __board.get(rownum);
	}

    public void addRow(Row row){
        __board.add(row);
	}

    public List<Row> getRows(){
        return __board;
    }
}
