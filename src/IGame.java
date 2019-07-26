import cell.objects.Cell;
import grid.interfaces.IGrid;

import java.util.List;
import java.util.Optional;

public interface IGame {

    /**
     * Selected cell will be saved at current cell variable.
     * Must return not only selected cell, but also all cells (especially their points), which contain the same number
     * as the selected one. If selected cell has no number, thus number = 0, it doesn't return list of cells with same
     * number.
     * @param index of cell
     */
    public List<Optional<Cell>> selectCell(int index);

    /**
     * Sets given number in the current cell.
     * Must also return all cells (especially their points), which contain the same number
     * as the one being set. If setting number to 0, it doesn't return list of cells with same
     * number.
     * @param number to be set.
     */
    public List<Optional<Cell>> enterNumber(int number);

    /**
     * Retrieves the percentage of solved cells in current grid.
     * M is all cells, N is unsolved cells, thus percentage is (number of solved cells)/N.
     * @return progress in percentage
     */
    public double showProgress();

    /**
     * Retrieves time spent on playing a grid. The timer starts shortly after newGame() method is called.
     * Time returned is a formatted String?
     * @return
     */
    public String showTime();

    /**
     * Undo's last cell to empty.
     */
    public void undo();

    /**
     * Removes number from selected cell.
     * The cell must be editable.
     * @param index of cell
     */
    public void delete(int index);

    /**
     * Creates an unsolved Sudoku grid, it's saved in variable current grid.
     */
    public IGrid newGame();
}
