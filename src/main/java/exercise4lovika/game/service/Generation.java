package exercise4lovika.game.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Generation {
    private Map<Cell, State> gridCellsWithState;

    public Generation(Map<Cell, State> gridCellsWithState) {
        this.gridCellsWithState = gridCellsWithState;
    }

    public Map<Cell, State> createGeneration() {
        Map<Cell, State> cellsWithNewState = new HashMap<>();
        for (Cell cell : gridCellsWithState.keySet()) {
            State newState = assignNewStateToCell(cell);
            cellsWithNewState.put(cell, newState);
            if (newState == State.ALIVE) {
                cellsWithNewState = includeNeighboursOfAliveCellsInMap(cellsWithNewState, cell);
            }
        }
        return cellsWithNewState;
    }

    private Map<Cell, State> includeNeighboursOfAliveCellsInMap(Map<Cell, State> cellsWithNewState, Cell cell) {
        List<Cell> adjacentCells = cell.getAdjacentCells();
        System.out.println(cellsWithNewState);
        for (Cell eachCell : adjacentCells) {
            if (cellsWithNewState.containsKey(eachCell)) {
                cellsWithNewState.put(cell, State.DEAD);
            }
        }
        return cellsWithNewState;
    }

    private State assignNewStateToCell(Cell cell) {
        int countLiveNeighbours = countLiveNeighbours(cell);
        if (gridCellsWithState.get(cell).equals(State.ALIVE) && (countLiveNeighbours > 3 || countLiveNeighbours < 2)) {
            return State.DEAD;
        } else if (gridCellsWithState.get(cell).equals(State.DEAD) && countLiveNeighbours == 3) {
            return State.ALIVE;
        }
        return gridCellsWithState.get(cell);
    }

    private int countLiveNeighbours(Cell cell) {
        List<Cell> adjacentCells = cell.getAdjacentCells();
        int countLiveNeighbours = 0;
        for (Cell eachCell : adjacentCells) {
            if (gridCellsWithState.get(eachCell) != null && gridCellsWithState.get(eachCell).equals(State.ALIVE)) {
                countLiveNeighbours++;
            }
        }
        return countLiveNeighbours;
    }
}
