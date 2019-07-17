package grid.objects;

import cell.interfaces.ICell;
import cell.objects.Cell;
import grid.interfaces.IGrid;
import grid.interfaces.IPoint;
import grid.interfaces.IPuzzleGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class PuzzleGenerator implements IPuzzleGenerator {

    private IGrid currentGrid;
    private Random rand = new Random();

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
        List<IPoint> pointList = cells.subList(0, cells.size()/2).stream().map(cell -> cell.getPoint()).collect(Collectors.toList());
        currentGrid.streamCells().forEach(cell -> {
            if(pointList.stream().anyMatch(point -> point.getIndex() == cell.getPoint().getIndex())){
                cell.setNumber(0);
            }
        });
    }

    private void removeNumber(){
        int row = rand.nextInt(8);
        int col = rand.nextInt(8);
        if(currentGrid.getCellAt(row, col).isBlank()){
            removeNumber();
        } else{
            currentGrid.getCellAt(row, col).setNumber(0);
        }
    }
}
