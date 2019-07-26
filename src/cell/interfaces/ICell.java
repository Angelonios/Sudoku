package cell.interfaces;

import grid.objects.Point;

public interface ICell {
    /**
     *
     * @return
     */
    Integer getNumber();

    /**
     *
     */
    void setNumber(Integer number);

    /**
     *
     * @return
     */
    Integer getRightNumber();

    /**
     *
     * @param number
     */
    void setRightNumber(Integer number);

    /**
     *
     * @return
     */
    Point getPoint();

    /**
     *
     * @param point
     */
    void setPoint(Point point);

    /**
     *
     * @return
     */
    boolean isCorrect();

    /**
     *
     * @return
     */
    boolean isBlank();

}
