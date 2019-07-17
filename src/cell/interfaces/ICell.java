package cell.interfaces;

import grid.interfaces.IPoint;

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
    IPoint getPoint();

    /**
     *
     * @param point
     */
    void setPoint(IPoint point);

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
