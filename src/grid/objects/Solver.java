package grid.objects;

import cell.interfaces.ICell;
import grid.interfaces.IChecker;
import grid.interfaces.IGrid;
import grid.interfaces.IPoint;
import grid.interfaces.ISolver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solver implements ISolver {

    private IGrid currentGrid;
    private ICell currentCell;
    private IChecker checker;

    Solver(IChecker checker){
        this.checker = checker;
    }

    @Override
    public void solve(IGrid grid) {
        setUp(grid);
        backtrackBruteForce(currentCell.getPoint());
    }

    private void setUp(IGrid grid){
        currentGrid = grid;
        checker.updateGrid(grid);
        currentCell = currentGrid.getCellAt(0, 0);
    }

    private boolean backtrackBruteForce(IPoint point){
        if(currentGrid.getCellAt(point.getIndex()).getNumber() != 0){
            return pickNext();
        }
        for(Integer number : initList()){
            if(checkNumber(point, number)){
                setNumber(point, number);
                if(pickNext()){
                    return true;
                }
                selectCurrentCell(point);
            }
        }
        resetCurrentCell(point);
        return false;
    }

    private boolean pickNext() {
        if(currentCell == null){
            return true;
        }
        currentCell = nextCell();
        if(currentCell == null){
            return true;
        }
        return backtrackBruteForce(currentCell.getPoint());
    }

    private ICell nextCell(){
        return currentGrid.getCellAt(currentCell.getPoint().getIndex() + 1);
    }

    private List<Integer> initList(){
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            result.add(i);
        }
        Collections.shuffle(result);
        return result;
    }

    private void setNumber(IPoint point, int number){
        ICell cell = currentGrid.getCellAt(point.getIndex());
        cell.setNumber(number);
        cell.setRightNumber(number);
    }

    private boolean checkNumber(IPoint point, int number){
        return checker.checkNum(currentGrid, point, number);
    }

    private void selectCurrentCell(IPoint point){
        currentCell = currentGrid.getCellAt(point.getIndex());
    }

    private void resetCurrentCell(IPoint point){
        ICell cell = currentGrid.getCellAt(point.getIndex());
        cell.setNumber(0);
        cell.setRightNumber(0);
    }

}
