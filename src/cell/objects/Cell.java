package cell.objects;

import cell.interfaces.ICell;
import grid.objects.Point;

public class Cell implements ICell {
    private int number;
    private int rightNumber;
    private Point point;

    public Cell(){
        number = 0;
        rightNumber = 0;
        point = null;
    }

    public Cell(int num){
        this.setNumber(num);
        this.setRightNumber(num);
        point = null;
    }

    @Override
    public Integer getNumber() {
        return number;
    }

    @Override
    public void setNumber(Integer number) {
        this.number = checkInput(number);
//        point.setConstraint(this);
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
    public Point getPoint() {
        return point;
    }

    @Override
    public void setPoint(Integer index) {
        point = new Point(index);
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
