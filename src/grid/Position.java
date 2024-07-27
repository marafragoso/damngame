package com.codeforall.online.damngame.grid;

public class Position {
    private Grid grid;
    private int col;
    private int row;

    public Position(Grid grid, int col, int row){
        this.grid =  grid;
        this.col = grid.columnToX(col);
        this.row = grid.rowToY(row);
    }

    public int getCol() {
        return this.col;
    }

    public int getRow() {
        return this.row;
    }

    public void updatePosition(int newCol, int newRow){
        this.col += newCol;
        this.row += newRow;
    }
}
