package grid.objects;

import cell.interfaces.ICell;
import grid.interfaces.IChecker;
import grid.interfaces.IGrid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solver {

    private IGrid currentGrid;
    private ICell currentCell;
    private IChecker checker;
    private Search search;

    Solver(IChecker checker, Search search){
        this.checker = checker;
        this.search = search;
    }

    public void solve(IGrid grid) {
        setUp(grid);
        backtrackBruteForce(currentCell);
    }

    private void setUp(IGrid grid){
        currentGrid = grid;
        search.getReference(grid);
        currentCell = Search.getCellAt(0);
    }

    private boolean backtrackBruteForce(ICell cell){
        if(cell.getNumber() != 0){
            return pickNext();
        }
        for(Integer number : initList()){
            if(checkNumber(cell, number)){
                setNumber(cell, number);
                if(pickNext()){
                    return true;
                }
                currentCell = cell;
            }
        }
        resetCurrentCell(cell);
        return false;
    }

    private boolean pickNext() {
        if(currentCell == null){
            return true;
        }
        currentCell = Search.nextCell(currentCell);
        if(currentCell == null){
            return true;
        }
        return backtrackBruteForce(currentCell);
    }

    private List<Integer> initList(){
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            result.add(i);
        }
        Collections.shuffle(result);
        return result;
    }

    private void setNumber(ICell cell, int number){
        cell.setNumber(number);
        cell.setRightNumber(number);
    }

    private boolean checkNumber(ICell cell, int number){
        return checker.checkNum(currentGrid, cell.getPoint(), number);
    }

    private void resetCurrentCell(ICell cell){
        cell.setNumber(0);
        cell.setRightNumber(0);
    }

}
