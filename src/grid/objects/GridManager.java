package grid.objects;

import grid.interfaces.*;


public class GridManager implements IGridManager {

    private IGrid currentGrid;
    private final IGridBuilder gridBuilder = new GridBuilder();
    private final Search search = new Search();
    private final IChecker checker = new Checker(search);
    private final Solver solver = new Solver(checker, search);
    private final IPuzzleGenerator puzzleGenerator = new PuzzleGenerator();

    @Override
    public IGrid getGrid() {
        return currentGrid;
    }

    @Override
    public void setGrid(IGrid grid) {
        currentGrid = grid;
    }

    @Override
    public void makeSudoku() {
        currentGrid = gridBuilder.buildGrid();
        solver.solve(currentGrid);
        puzzleGenerator.generateSudoku(currentGrid);
        currentGrid.printGrid();
    }
}

