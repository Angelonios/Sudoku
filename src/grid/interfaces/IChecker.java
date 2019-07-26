package grid.interfaces;

import grid.objects.Point;

public interface IChecker {

    /**
     * This method picks each number from grid and tests it using checkNum method.
     * It's a complete validation process for whole grid.
     * @param grid
     * @return
     */
    public boolean validate(IGrid grid);

    /**
     * This method checks the possibility of inserting a number in specific
     * place in sudoku and not violating the RULE OF ONE.
     * It uses rowCheck(), colCheck() and sqrCheck() all at once.
     * @param point
     * @param num number to be added.
     * @return true/false ~ OK/not good.
     */
    public boolean checkNum(IGrid grid, Point point, int num);
}
