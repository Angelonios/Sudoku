package grid.objects;

import cell.interfaces.ICell;
import grid.interfaces.IChecker;
import grid.interfaces.IGrid;

import java.util.Collections;

public class Checker implements IChecker {

    private IGrid currentGrid;
    private Search search;

    public Checker(Search search){
        this.search = search;
    }

    @Override
    public boolean validate(IGrid grid) {
        updateGrid(grid);
        return currentGrid.getCells().stream().allMatch(this::validateCell);
    }

    private boolean validateCell(ICell cell){
        return (Collections.frequency(Search.getCellsFromRow(cell), cell) == 1) &&
               (Collections.frequency(Search.getCellsFromCol(cell), cell) == 1) &&
               (Collections.frequency(Search.getCellsFromSqr(cell), cell) == 1);
    }

    @Override
    public boolean checkNum(IGrid grid, Point point, int num) {
        updateGrid(grid);
        return (rowCheck(point, num) &&
                colCheck(point, num) &&
                sqrCheck(point, num));
    }

    private void updateGrid(IGrid grid) {
        search.getReference(grid);
        currentGrid = grid;
    }

    /**
     * This method checks if number in parameter isn't already present in row.
     * Returns true, if there is no such number in row.
     * @param point
     * @param num number to be added.
     * @return true/false ~ OK/not good.
     */
    private boolean rowCheck(Point point, int num) {
        return Search.getCellsFromRow(point).stream().allMatch(cell -> cell.getNumber() != num);
    }

    /**
     * This method checks if number in parameter isn't already present in col.
     * Returns true, if there is no such number in col.
     * @param point of cell to be checked/validated
     * @param num number to be added.
     * @return true/false ~ OK/not good.
     */
    private boolean colCheck(Point point, int num) {
        return Search.getCellsFromCol(point).stream().allMatch(cell -> cell.getNumber() != num);
    }

    /**
     * This method checks if number in parameter isn't already present in
     * square. Returns true, if there is no such number in square.
     * @param point
     * @param num number to be added.
     * @return true/false ~ OK/not good.
     */
    private boolean sqrCheck(Point point, int num) {
        return Search.getCellsFromSqr(point).stream().allMatch(cell -> cell.getNumber() != num);
    }
}

