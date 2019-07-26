package grid.interfaces;

public interface IGridBuilder {

    /**
     * Creates a grid, meaing it adds cells into a List<Cell> and then it interconnects cells to each other -
     * each cell knows its predecessor and successor.
     * @return new empty grid
     */
    public IGrid buildGrid();

    /**
     * Parses a String of 81 characters resembling numbers in grid.
     * Parsing process: String is converted into Char array and then each element is converted to int and added to each
     * cell in cell list in current grid.
     * @param stringGrid string to be parsed.
     * @return new grid filled with numbers given at input
     */
    public IGrid parseGrid(String stringGrid);
}
