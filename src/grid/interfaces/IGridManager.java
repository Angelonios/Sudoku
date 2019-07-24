package grid.interfaces;

import grid.objects.Grid;

/**
 * This class offers management interface for grid. It used by game class (IGame interface) to create sudoku instances
 * and load them into the graphical user interface, or other (that is why this interface has these methods: export,
 * parse and print grid).
 * @author angel
 * @version 0.1000
 */
public interface IGridManager {

    /**
     * Returns currently managed grid.
     * @return current grid.
     */
    public IGrid getGrid();

    /**
     * Saves a grid, which enables managing of this particular grid.
     * @param grid grid to be saved.
     */
    public void setGrid(IGrid grid);

    /**
     * This method is used by IGame interface to generate a Sudoku grid in which all cells know their right numbers, but
     * some cells don't have a number (which is shown in the grid). Thus this method uses methods from other classes.
     * The classes being used are: GridBuilder, Solver & Checker, Riddler.
     */
    public void makeSudoku();
}
