package grid.objects;

import cell.interfaces.ICell;
import grid.interfaces.IChecker;
import grid.interfaces.IGrid;
import grid.interfaces.IPoint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Checker implements IChecker {

    private IGrid currentGrid;

    @Override
    public boolean validate(IGrid grid) {
        updateGrid(grid);
        return currentGrid.getCells().stream().allMatch(cell -> validateCell(cell));
    }

    private boolean validateCell(ICell cell){
        return (Collections.frequency(getCellsFromRow(cell.getPoint()), cell) == 1) &&
               (Collections.frequency(getCellsFromCol(cell.getPoint()), cell) == 1) &&
               (Collections.frequency(getCellsFromSqr(getCornerPoint(cell.getPoint())), cell) == 1);
    }

    @Override
    public boolean checkNum(IGrid grid, IPoint point, int num) {
        updateGrid(grid);
        return (rowCheck(point, num) &&
                colCheck(point, num) &&
                sqrCheck(point, num));
    }

    @Override
    public void updateGrid(IGrid grid) {
        currentGrid = grid;
    }

    /**
     * This method checks if number in parameter isn't already present in row.
     * Returns true, if there is no such number in row.
     * @param point
     * @param num number to be added.
     * @return true/false ~ OK/not good.
     */
    private boolean rowCheck(IPoint point, int num) {
        return getCellsFromRow(point).stream().allMatch(cell -> cell.getNumber() != num);
    }

    /**
     * This method extracts all cells from grid list of cells, which are in one row.
     * It uses the row value given from the parameter point, to filter all cells, which have the same row number.
     * @param point of cell to be checked/validated
     * @return list of cells, which are from one row
     */
    private List<ICell> getCellsFromRow(IPoint point){
        return currentGrid.getCells().stream()
                                     .filter(cell -> cell.getPoint().getRow() == point.getRow())
                                     .collect(Collectors.toList());
    }

    /**
     * This method checks if number in parameter isn't already present in col.
     * Returns true, if there is no such number in col.
     * @param point of cell to be checked/validated
     * @param num number to be added.
     * @return true/false ~ OK/not good.
     */
    private boolean colCheck(IPoint point, int num) {
        return getCellsFromCol(point).stream().allMatch(cell -> cell.getNumber() != num);
    }

    /**
     * his method extracts all cells from grid list of cells, which are in one col.
     * It uses the col value given from the parameter point, to filter all cells, which have the same col number.
     * @param point of cell to be checked/validated
     * @return list of cells, which are from one column
     */
    private List<ICell> getCellsFromCol(IPoint point){
        return currentGrid.getCells().stream()
                                     .filter(cell -> cell.getPoint().getCol() == point.getCol())
                                     .collect(Collectors.toList());
    }

    /**
     * This method checks if number in parameter isn't already present in
     * square. Returns true, if there is no such number in square.
     * @param point
     * @param num number to be added.
     * @return true/false ~ OK/not good.
     */
    private boolean sqrCheck(IPoint point, int num) {
        return getCellsFromSqr(getCornerPoint(point)).stream().allMatch(cell -> cell.getNumber() != num);
    }

    private List<ICell> getCellsFromSqr(IPoint point){
        List<ICell> result = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            result.addAll(getSublist(point, i));
        }
        return result;
    }

    private List<ICell> getSublist(IPoint point, int i){
        int index = point.getIndex();
        int from = index + i*9;
        int to   = from + 3;
        return currentGrid.getCells().subList(from, to);
    }

    /**
     *
     * @param point
     * @return
     */
    private IPoint getCornerPoint(IPoint point){
        return currentGrid.getCellAt(point.getRow() - point.getRow()%3,
                                     point.getCol() - point.getCol()%3)
                .getPoint();
    }

//    /**
//     * this method returns the most left and upper point of a square region.
//     * the point coordinates are calculated from index number of cell form list.
//     */
//    private Point findSqrCorner(Point point){
//        return new Point((point.getIndex()/27)*27 + ((point.getIndex()%9)%3)*3 );
//    }

}

