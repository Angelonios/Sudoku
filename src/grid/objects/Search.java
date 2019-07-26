package grid.objects;

import cell.interfaces.ICell;
import grid.interfaces.IGrid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Search {

    private static IGrid grid;

    public void getReference(IGrid grid){
        this.grid = grid;
    }

    public static ICell getCellAt(int index) {
        return grid.getCells().get(index);
    }

    public static ICell getCellAt(int row, int col) {
        return grid.getCells().get(Point.getIndex(row, col));
    }

    public static ICell getCellAt(Point point) {
        return grid.getCells().get(point.getIndex());
    }

    public static Point getPoint(int index) {
        return grid.getCells().get(index).getPoint();
    }

    public static List<Point> getPoints(List<ICell> cells){
        return cells.stream().map(cell -> cell.getPoint()).collect(Collectors.toList());
    }

    public static List<ICell> getCellsFromRow(int index){
        return grid.streamCells()
                   .filter(c -> c.getPoint().getRow() == Point.rowFromIndex(index))
                   .collect(Collectors.toList());
    }

    public static List<ICell> getCellsFromRow(Point point){
        return grid.streamCells()
                .filter(c -> c.getPoint().getRow() == point.getRow())
                .collect(Collectors.toList());
    }

    public static List<ICell> getCellsFromRow(ICell cell){
        return grid.streamCells()
                .filter(c -> c.getPoint().getRow() == cell.getPoint().getRow())
                .collect(Collectors.toList());
    }

    public static List<ICell> getCellsFromCol(int index) {
        return grid.streamCells()
                   .filter(c -> c.getPoint().getCol() == Point.colFromIndex(index))
                   .collect(Collectors.toList());
    }

    public static List<ICell> getCellsFromCol(Point point) {
        return grid.streamCells()
                .filter(c -> c.getPoint().getCol() == point.getCol())
                .collect(Collectors.toList());
    }

    public static List<ICell> getCellsFromCol(ICell cell) {
        return grid.streamCells()
                .filter(c -> c.getPoint().getCol() == cell.getPoint().getCol())
                .collect(Collectors.toList());
    }

    public static List<ICell> getCellsFromSqr(int index) {
        int corner = getCorner(index);
        List<ICell> result = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            result.addAll(getSublist(corner, i));
        }
        return result;
    }

    public static List<ICell> getCellsFromSqr(Point point) {
        int corner = getCorner(point.getIndex());
        List<ICell> result = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            result.addAll(getSublist(corner, i));
        }
        return result;
    }

    public static List<ICell> getCellsFromSqr(ICell cell) {
        int corner = getCorner(cell.getPoint().getIndex());
        List<ICell> result = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            result.addAll(getSublist(corner, i));
        }
        return result;
    }


    public static List<ICell> getCellsWithNumber(int number) {
        return grid.streamCells()
                .filter(cell -> cell.getNumber() == number)
                .collect(Collectors.toList());
    }

    public static ICell nextCell(int index) {
        return getCellAt(index + 1);
    }

    public static ICell nextCell(Point point) {
        return getCellAt(point.getIndex() + 1);
    }

    public static ICell nextCell(ICell cell) {
        if(cell.getPoint().getIndex() + 1 > 80){
            return null;
        }
        return getCellAt(cell.getPoint().getIndex() + 1);
    }

    private static List<ICell> getSublist(int index, int i) {
        int from = index + i*9;
        int to   = from + 3;
        return grid.getCells().subList(from, to);
    }

    private static int getCorner(int index) {
        int row = Point.rowFromIndex(index);
        int column = Point.colFromIndex(index);
        return Point.getIndex(row - row%3, column - column%3);
    }

//    public ICell getCornerCell(int index) {
//        return getCellAt( ((index/27)*27 + ((index%9)%3)*3) );
//    }
}
