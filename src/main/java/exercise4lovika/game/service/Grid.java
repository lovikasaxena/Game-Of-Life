package exercise4lovika.game.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Grid {
    private Map<Cell, State> cellsWithState;
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private Generation generation;
    public Grid() {
        cellsWithState = new HashMap<>();
    }

    public void giveStateToAllCells(List<Cell> cells, int maxX, int maxY, int minX, int minY) {
        this.maxX = maxX;
        this.maxY = maxY;
        this.minX = minX;
        this.minY = minY;
        giveLiveStateToGivenCells(cells);
        giveDeadStateToOtherCells(cells);
    }

    private void giveLiveStateToGivenCells(List<Cell> cellList) {
        for (Cell cell : cellList) {
            cellsWithState.put(cell, State.ALIVE);
        }
    }

    private void giveDeadStateToOtherCells(List<Cell> cells) {
        for (int row = minX - 1; row <= maxX + 1; row++) {
            for (int column = minY - 1; column <= maxY + 1; column++) {
                Cell cell = new Cell(row, column);
                if (cellsWithState.get(cell) == null) {
                    cellsWithState.put(cell, State.DEAD);
                }
            }
        }
    }

    public Map<Cell, State> getCellsWithState() {
        return cellsWithState;
    }

    public void tick() {
//        Map<Cell, State> cellsWithNewState = new HashMap<>();
//        for (Cell cell : cellsWithState.keySet()) {
//            cellsWithNewState.put(cell, assignNewStateToCell(cell));
//        }
//        cellsWithState = cellsWithNewState;
        generation = new Generation(cellsWithState);
        cellsWithState =generation.createGeneration();
    }

//    private State assignNewStateToCell(Cell cell) {
//        int countLiveNeighbours = countLiveNeighbours(cell);
//        if (cellsWithState.get(cell).equals(State.ALIVE) && (countLiveNeighbours > 3 || countLiveNeighbours < 2)) {
//            return State.DEAD;
//        } else if (cellsWithState.get(cell).equals(State.DEAD) && countLiveNeighbours == 3) {
//            return State.ALIVE;
//        }
//        return cellsWithState.get(cell);
//    }
//
//    private int countLiveNeighbours(Cell cell) {
//        List<Cell> adjacentCells = cell.getAdjacentCells();
//        int countLiveNeighbours = 0;
//        for (Cell eachCell : adjacentCells) {
//            if (cellsWithState.get(eachCell) != null && cellsWithState.get(eachCell).equals(State.ALIVE)) {
//                countLiveNeighbours++;
//            }
//        }
//        return countLiveNeighbours;
//    }
}

