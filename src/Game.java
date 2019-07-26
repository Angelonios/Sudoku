import cell.interfaces.ICell;
import cell.objects.Cell;
import grid.interfaces.IGrid;
import grid.interfaces.IGridManager;
import grid.objects.GridManager;

import java.util.List;
import java.util.Optional;

public class Game implements IGame {

    private IGridManager gridManager = new GridManager();
    private IGrid currentGrid;
    private ICell currentCell;
    private double progress;
    private String time;

    @Override
    public List<Optional<Cell>> selectCell(int index) {
        return null;
    }

    @Override
    public List<Optional<Cell>> enterNumber(int number) {
        return null;
    }

    @Override
    public double showProgress() {
        return 0;
    }

    @Override
    public String showTime() {
        return null;
    }

    @Override
    public void undo() {

    }

    @Override
    public void delete(int index) {

    }

    @Override
    public IGrid newGame() {
        return null;
    }
}
