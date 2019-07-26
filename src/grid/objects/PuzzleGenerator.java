package grid.objects;

import cell.interfaces.ICell;
import grid.interfaces.IGrid;
import grid.interfaces.IPuzzleGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PuzzleGenerator implements IPuzzleGenerator {

    private IGrid currentGrid;

    @Override
    public void generateSudoku(IGrid grid) {
        setUp(grid);
        generateSolvableSudoku();
    }

    private void setUp(IGrid grid) {
        currentGrid = grid;
    }

    private void generateSolvableSudoku(){
        List<ICell> temp = new ArrayList<>(currentGrid.getCells());
        removeNumbers(temp);
    }

    private void removeNumbers(List<ICell> cells) {
        Collections.shuffle(cells);
        List<Point> pointList = cells.subList(0, cells.size()/2).stream().map(ICell::getPoint).collect(Collectors.toList());
        currentGrid.streamCells().forEach(cell -> {
            if(pointList.stream().anyMatch(point -> point.getIndex().equals(cell.getPoint().getIndex()))){
                cell.setNumber(0);
            }
        });
    }
}
