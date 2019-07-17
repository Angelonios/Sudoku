package grid.objects;

import grid.interfaces.IPoint;

public class Point implements IPoint {

    private int row;
    private int column;

    Point(int index){
        row = rowFromIndex(index);
        column = colFromIndex(index);
    }

    @Override
    public Integer getRow() {
        return row;
    }

    @Override
    public void setRow(Integer r) {
        row = r;
    }

    @Override
    public Integer getCol() {
        return column;
    }

    @Override
    public void setCol(Integer c) {
        column = c;
    }

    @Override
    public Integer getIndex() {
        return (row*DIMENSION + column);
    }

    private Integer rowFromIndex(Integer index) {
        return (index/9);
    }

    private Integer colFromIndex(Integer index){
        return (index%9);
    }
}
