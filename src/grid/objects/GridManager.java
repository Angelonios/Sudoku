package grid.objects;

import grid.interfaces.*;

import java.util.stream.Collectors;

public class GridManager implements IGridManager {

    private IGrid currentGrid;
    private final IGridBuilder gridBuilder = new GridBuilder();
    private final IChecker checker = new Checker();
    private final ISolver solver = new Solver(checker);
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
    public void createSudoku() {
//        String exportedSudoku = "152489376739256841468371295387124659591763428246895713914637582625948137873512964";
        currentGrid = gridBuilder.buildGrid();
        currentGrid.printGrid();
        solver.solve(currentGrid);
        currentGrid.printGrid();
        puzzleGenerator.generateSudoku(currentGrid);
        currentGrid.printGrid();
    }


}

