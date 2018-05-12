package exercise4lovika.game.serviceTest;

import exercise4lovika.game.service.Cell;
import exercise4lovika.game.service.GameOfLifeService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GameOfLifeServiceTest {
    GameOfLifeService gameOfLifeService;
    List<Cell> cells;

    @Before
    public void setup() {
        gameOfLifeService = new GameOfLifeService();
        cells = new ArrayList();
        cells.add(new Cell(1, 1));
        cells.add(new Cell(3, 4));
    }

    @Test
    public void shouldReturnStringAsCells() {
        List<Cell> expectedCells = cells;
        List<Cell> actualLiveCells = gameOfLifeService.getListOfCellsFromStringList(Arrays.asList("1,1", "3,4"));
        assertEquals(expectedCells, actualLiveCells);
    }

    @Test
    public void shouldReturnMaxXAs3() {
        int x = gameOfLifeService.findMaxOrMinXCoordinate(cells, "MAX");
        assertEquals(3, x);
    }

    @Test
    public void shouldReturnMaxYAs4() {
        int y = gameOfLifeService.findMaxOrMinYCoordinate(cells, "MAX");
        assertEquals(4, y);
    }
    @Test
    public void shouldReturnMinXAs1() {
        int x = gameOfLifeService.findMaxOrMinYCoordinate(cells, "MIN");
        assertEquals(1, x);
    }
    @Test
    public void shouldReturnMinYs1() {
        int y = gameOfLifeService.findMaxOrMinYCoordinate(cells, "MIN");
        assertEquals(1, y);
    }

}