package grid.objects;

import cell.interfaces.ICell;
import cell.objects.Cell;
import grid.interfaces.IGrid;
import grid.interfaces.IGridBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GridBuilder implements IGridBuilder {

    List<ICell> cellsList;

    @Override
    public IGrid buildGrid() {
        init();
        generateCells();
        return terminate();
    }

    @Override
    public IGrid parseGrid(String stringGrid) {
        init();
        checkInput(stringGrid);
        parseCells(stringGrid);
        return terminate();
    }

    private void init(){
        cellsList = new ArrayList<>();
    }

    private void generateCells(){
        for(int i = 0; i < 81; i++){
            addCell();
        }
    }

    private void addCell() {
        cellsList.add(new Cell());
        setCellPoint();
    }

    private void addCell(Integer digit){
        cellsList.add(new Cell(digit));
        setCellPoint();
    }

    private IGrid terminate(){
        IGrid result = new Grid(new ArrayList<>(cellsList));
        cellsList = null;
        return result;
    }

    private void checkInput(String input){
        if(input.length() != 81){
            System.out.println("Error while parsing exported grid - lenght of String is not equal to 81");
            return;
        }
    }

    private void parseCells(String input){
        Arrays.stream(input.split("(?!^)")).forEach(digit -> parseCell(digit));
    }


    private void setCellPoint(){
        ICell cell = getLastCell();
        cell.setPoint(cellsList.indexOf(cell));
    }

    private ICell getLastCell(){
        return cellsList.get(cellsList.size() - 1);
    }

    private void parseCell(String digit){
        addCell(Integer.parseInt(digit));
    }
}
