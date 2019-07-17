package cell.objects;

import cell.interfaces.ICell;
import grid.interfaces.IPoint;
import grid.objects.Point;

public class Cell implements ICell {
    private int number;
    private int rightNumber;
    private IPoint point;

    public Cell(){
        number = 0;
        rightNumber = 0;
    }

    public Cell(int num){
        this.setNumber(num);
        this.setRightNumber(num);
    }

    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public void setNumber(Integer number) {
        this.number = checkInput(number);
    }

    @Override
    public Integer getRightNumber() {
        return rightNumber;
    }

    @Override
    public void setRightNumber(Integer number) {
        rightNumber = checkInput(number);
    }

    @Override
    public IPoint getPoint() {
        return point;
    }

    @Override
    public void setPoint(IPoint point) {
        this.point = point;
    }

    @Override
    public boolean isCorrect() {
        return (number == rightNumber);
    }

    @Override
    public boolean isBlank() {
        return (number == 0);
    }

    private Integer checkInput(Integer number){
        if(number < 0){
            System.out.println("Can't enter that number! must be from 0 to 9!");
            return 0;
        }
        if(number > 9){
            System.out.println("Can't enter that number! must be from 0 to 9!");
            return 0;
        }
        return number;
    }
}
