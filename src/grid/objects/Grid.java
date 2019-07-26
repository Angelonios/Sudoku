package grid.objects;

import cell.interfaces.ICell;
import grid.interfaces.IGrid;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Grid implements IGrid {

    private List<ICell> cells;

    Grid(List<ICell> list){
        cells = list;
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
