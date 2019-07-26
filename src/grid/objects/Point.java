package grid.objects;

import cell.interfaces.ICell;

import java.util.List;
import java.util.stream.Collectors;

public class Point{

    private int row;
    private int column;

    Point(int index){
        row = rowFromIndex(index);
        column = colFromIndex(index);
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return column;
    }

    public Integer getIndex() {
        return getIndex(row, column);
    }

    public static Integer getIndex(int row, int column){
        return (row*9 + column);
    }

    public static Integer rowFromIndex(int index){
        return index/9;
    }

    public static Integer colFromIndex(int index){
        return index%9;
    }

    public static List<Point> getPoints(List<ICell> cells){
        return cells.stream().map(cell -> cell.getPoint()).collect(Collectors.toList());
    }
}
