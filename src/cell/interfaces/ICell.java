package cell.interfaces;

import grid.interfaces.IPoint;

public interface ICell {
    /**
     *
     * @return
     */
    public Integer getNumber();

    /**
     *
     */
    public void setNumber(Integer number);

    /**
     *
     * @return
     */
    public Integer getRightNumber();

    /**
     *
     * @param number
     */
    public void setRightNumber(Integer number);

    /**
     *
     * @return
     */
    public IPoint getPoint();

    /**
     *
     * @param index
     */
    public void setPoint(Integer index);

    /**
     *
     * @return
     */
    public boolean isCorrect();

    /**
     *
     * @return
     */
    public boolean isBlank();

}
