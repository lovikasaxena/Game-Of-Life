package exercise4lovika.game.serviceTest;

import exercise4lovika.game.service.Cell;
import exercise4lovika.game.service.State;
import exercise4lovika.game.service.Grid;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GridTest {
    Grid grid;
    List<Cell> cells;

    @Before
    public void setup() {
        grid = new Grid();
        cells = new ArrayList();
        cells.add(new Cell(1, 1));
        cells.add(new Cell(1, 2));
    }

    @Test
    public void shouldMakeGivenCellsAsLive() {
        grid.giveStateToAllCells(cells, 1, 2, 1, 1);
        Map<Cell, State> map = grid.getCellsWithState();
        assertEquals(map.size(), 12);
        assertEquals(map.get(new Cell(1, 1)), State.ALIVE);
        assertEquals(map.get(new Cell(1, 2)), State.ALIVE);
    }

    @Test
    public void shouldMakeGivenCellsAsDead() {
        grid.giveStateToAllCells(cells, 1, 2, 1, 1);
        Map<Cell, State> map = grid.getCellsWithState();
        assertEquals(map.size(), 12);
        assertEquals(map.get(new Cell(0, 0)), State.DEAD);
        assertEquals(map.get(new Cell(2, 2)), State.DEAD);
    }
//
//    @Test
//    public void shouldMakeCellDeadAfterTick() {
//        grid.giveStateToAllCells(cells, 1, 2, 1, 1);
//        grid.tick();
//        Map<Cell, State> map = grid.getCellsWithState();
//
//        assertEquals(map.get(new Cell(1, 1)), State.DEAD);
//        assertEquals(map.get(new Cell(1, 2)), State.DEAD);
//        assertEquals(map.get(new Cell(2, 1)), State.DEAD);
//    }
//
//    @Test
//    public void stillLifeAfterTickEx1() {
//        List<Cell> cells = new ArrayList();
//        cells.add(new Cell(1, 1));
//        cells.add(new Cell(1, 2));
//        cells.add(new Cell(2, 1));
//        cells.add(new Cell(2, 2));
//        grid.giveStateToAllCells(cells, 2, 2, 1, 1);
//        grid.tick();
//        Map<Cell, State> map = grid.getCellsWithState();
//
//        assertEquals(map.get(new Cell(1, 1)), State.ALIVE);
//        assertEquals(map.get(new Cell(1, 2)), State.ALIVE);
//        assertEquals(map.get(new Cell(2, 1)), State.ALIVE);
//        assertEquals(map.get(new Cell(2, 2)), State.ALIVE);
//        assertEquals(map.get(new Cell(2, 0)), State.DEAD);
//    }
//
//    @Test
//    public void stillLifeAfterTickEx2() {
//        List<Cell> cells = new ArrayList();
//        cells.add(new Cell(0, 1));
//        cells.add(new Cell(1, 0));
//        cells.add(new Cell(2, 1));
//        cells.add(new Cell(0, 2));
//        cells.add(new Cell(1, 2));
//        grid.giveStateToAllCells(cells, 2, 2, 0, 0);
//        grid.tick();
//        Map<Cell, State> map = grid.getCellsWithState();
//
//        assertEquals(map.get(new Cell(0, 1)), State.ALIVE);
//        assertEquals(map.get(new Cell(1, 0)), State.ALIVE);
//        assertEquals(map.get(new Cell(2, 1)), State.ALIVE);
//        assertEquals(map.get(new Cell(0, 2)), State.ALIVE);
//        assertEquals(map.get(new Cell(1, 2)), State.ALIVE);
//        assertEquals(map.get(new Cell(0, 0)), State.DEAD);
//
//    }
//
//    @Test
//    public void oscillatorAfterTick() {
//        List<Cell> cells = new ArrayList();
//        cells.add(new Cell(1, 1));
//        cells.add(new Cell(1, 0));
//        cells.add(new Cell(1, 2));
//        grid.giveStateToAllCells(cells, 1, 2, 1, 0);
//        grid.tick();
//        Map<Cell, State> map = grid.getCellsWithState();
//
//        assertEquals(map.get(new Cell(1, 1)), State.ALIVE);
//        assertEquals(map.get(new Cell(0, 1)), State.ALIVE);
//        assertEquals(map.get(new Cell(2, 1)), State.ALIVE);
//        assertEquals(map.get(new Cell(1, 0)), State.DEAD);
//        assertEquals(map.get(new Cell(1, 2)), State.DEAD);
//    }
//
//    @Test
//    public void twoPhaseOscillatorAfterTick() {
//        List<Cell> cells = new ArrayList();
//        cells.add(new Cell(1, 1));
//        cells.add(new Cell(1, 2));
//        cells.add(new Cell(1, 3));
//        cells.add(new Cell(2, 2));
//        cells.add(new Cell(2, 3));
//        cells.add(new Cell(2, 4));
//        grid.giveStateToAllCells(cells, 2, 4, 1, 1);
//        grid.tick();
//        Map<Cell, State> map = grid.getCellsWithState();
//
//        assertEquals(map.size(), 24);
//        assertEquals(map.get(new Cell(0, 2)), State.ALIVE);
//        assertEquals(map.get(new Cell(1, 1)), State.ALIVE);
//        assertEquals(map.get(new Cell(1, 4)), State.ALIVE);
//        assertEquals(map.get(new Cell(2, 1)), State.ALIVE);
//        assertEquals(map.get(new Cell(2, 4)), State.ALIVE);
//        assertEquals(map.get(new Cell(3, 3)), State.ALIVE);
//        assertEquals(map.get(new Cell(2, 2)), State.DEAD);
//    }

}
