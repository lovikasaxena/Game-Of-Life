package exercise4lovika.game.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GameOfLifeService {
    private Grid grid;
    //List<Cell> cells;
    private final static String MIN = "MIN";
    private final static String MAX = "MAX";

    public GameOfLifeService() {
        grid = new Grid();
//        FOR TESTING ON BROWSER
//        cells = new ArrayList();
//        cells.add(new Cell(1, 1));
//        cells.add(new Cell(1, 2));
//        cells.add(new Cell(1, 3));
//        cells.add(new Cell(2, 2));
//        cells.add(new Cell(2, 3));
//        cells.add(new Cell(2, 4));
    }

    public void giveStateToCells(List<String> stringArray) throws AliveCellRequiredException {
        if (stringArray.isEmpty()) {
            throw new AliveCellRequiredException();
        }
        List<Cell> cells = getListOfCellsFromStringList(stringArray);
        int maxX = findMaxOrMinXCoordinate(cells, MAX);
        int maxY = findMaxOrMinYCoordinate(cells, MAX);
        int minX = findMaxOrMinYCoordinate(cells, MIN);
        int minY = findMaxOrMinYCoordinate(cells, MIN);
        grid.giveStateToAllCells(cells, maxX, maxY, minX, minY);
    }

    public List<Cell> getListOfCellsFromStringList(List<String> stringArray) {
        List<Cell> cells = new ArrayList<>();
        for (String string : stringArray) {
            string = string.trim();
            String[] array = string.split(",");
            Cell cell = new Cell(Integer.parseInt(array[0]), Integer.parseInt(array[1]));
            cells.add(cell);
        }
        return cells;
    }

    public Integer findMaxOrMinXCoordinate(List<Cell> cells, String type) {
        int number = cells.get(0).getX();
        for (Cell cell : cells) {
            if (type.equals(MAX) && cell.getX() > number) {
                number = cell.getX();
            } else if (cell.getX() < number) {
                number = cell.getX();
            }
        }
        return number;
    }

    public Integer findMaxOrMinYCoordinate(List<Cell> cells, String type) {
        int number = cells.get(0).getY();
        for (Cell cell : cells) {
            if (type.equals(MAX) && cell.getY() > number) {
                number = cell.getY();
            } else if (cell.getY() < number) {
                number = cell.getY();
            }
        }
        return number;
    }

    public Map<Cell, State> tick() {
        grid.tick();
        return grid.getCellsWithState();
    }

    public Map<Cell, State> getGridMap() {
        return grid.getCellsWithState();
    }
}



