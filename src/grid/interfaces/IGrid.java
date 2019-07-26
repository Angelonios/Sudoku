package grid.interfaces;

import cell.interfaces.ICell;

import java.util.List;
import java.util.stream.Stream;

public interface IGrid {

    /**
     * Returns current cell.
     * @return current cell.
     */
    public ICell getCurrentCell();

    /**
     * Sets a new cell as current cell.
     * @param cell to be set as current cell.
     */
    public void setCurrentCell(ICell cell);

    /**
     * This method returns all cells from a grid.
     * @return list of cells.
     */
    public List<ICell> getCells();

    /**
     * This method puts new list of cells in grid.
     * Thus it either adds new cells or replace them.
     * @param cells cells to be added into grid.
     */
    public void setCells(List<ICell> cells);

    /**
     * This method returns stream of cells from currend grid.
     * @return stream of cells
     */
    public Stream<ICell> streamCells();

    /**
     * Takes current grid and exports it as a String of length 81 characters.
     * @return string of exported grid.
     */
    public String exportGrid();

    /**
     * Prints current grid into console as a real sudoku grid.
     * (real sudoku grid = 9 squares with 9 cells in each suqare)
     */
    public void printGrid();

}
