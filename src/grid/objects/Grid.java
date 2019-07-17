package grid.objects;

import cell.interfaces.ICell;
import grid.interfaces.IGrid;
import grid.interfaces.IPoint;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grid implements IGrid {

    private List<ICell> cells;
    private ICell currentCell;

    public Grid(){
        cells = null;
        currentCell = null;
    }

    public Grid(List<ICell> list){
        cells = list;
        currentCell = null;
    }

    @Override
    public ICell getCurrentCell() {
        return currentCell;
    }

    @Override
    public void setCurrentCell(ICell cell) {
        currentCell = cell;
    }

    @Override
    public IPoint getCurrentCellPoint() {
        return currentCell.getPoint();
    }

    @Override
    public ICell getCellAt(Integer row, Integer col) {
        return cells.get(row*9 + col);
    }

    @Override
    public ICell getCellAt(Integer index) {
        if(index > 80){
            return null;
        }
        return cells.get(index);
    }

    @Override
    public List<ICell> getCells() {
        return cells;
    }

    @Override
    public void setCells(List<ICell> cells) {
        this.cells = cells;
    }

    @Override
    public Stream<ICell> streamCells() {
        return cells.stream();
    }

    @Override
    public String exportGrid() {
        return streamCells().map(cell -> Integer.toString(cell.getNumber()))
                            .collect(Collectors.joining());
    }

    @Override
    public void printGrid() {
        streamCells().forEach(cell -> {
            int index = cell.getPoint().getIndex();
            if (index % 9 != 8 || index == 0) {
                if ((index % 3) == 2) {
                    System.out.print(cell.getNumber() + "   ");
                } else {
                    System.out.print(cell.getNumber() + "  ");
                }
            } else {
                System.out.println(cell.getNumber() + "  ");
            }
            if(index == 26 || index == 53 ){
                System.out.println();
            }
        });
        System.out.println("---------------------------------");
    }
}
