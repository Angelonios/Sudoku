package grid.interfaces;

import grid.objects.Point;

public interface IPoint {

    public static final int DIMENSION = 9;

    /**
     * Returns index of row
     * @return index of row
     */
    public Integer getRow();

    /**
     * Sets the index of row
     * @param row index of row
     */
    public void setRow(Integer row);

    /**
     * Returns index of column
     * @return index of column
     */
    public Integer getCol();

    /**
     * Sets the index of column
     * @param column index of column
     */
    public void setCol(Integer column);

    /**
     * Returns calculated value of position of a cell in list.
     * @return index of cell in list
     */
    public Integer getIndex();
}
