package exercise4lovika.game.serviceTest;

import exercise4lovika.game.service.Cell;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CellTest {
    @Test
    public void shouldGiveTrueIfCorrectAdjacentCellsReturnedEx1() {
        Cell cell = new Cell(1, 1);
        List<Cell> actualCells = cell.getAdjacentCells();
        List<Cell> expectedCells = Arrays.asList(new Cell(0, 0), new Cell(1, 0), new Cell(2, 0),
                new Cell(2, 1), new Cell(2, 2), new Cell(1, 2), new Cell(0, 2), new Cell(0, 1));
        actualCells.forEach(actualCell -> assertTrue(expectedCells.contains(actualCell)));
        assertEquals(actualCells.size(), expectedCells.size());
    }

    @Test
    public void shouldGiveTrueIfCorrectAdjacentCellsReturnedEx2() {
        Cell cell = new Cell(0, 0);
        List<Cell> actualCells = cell.getAdjacentCells();
        List<Cell> expectedCells = Arrays.asList(new Cell(-1, 1), new Cell(0, 1), new Cell(1, 1),
                new Cell(-1, 0), new Cell(-1, -1), new Cell(0, -1), new Cell(1, -1), new Cell(1, 0));
        actualCells.forEach(actualCell -> assertTrue(expectedCells.contains(actualCell)));
        assertEquals(actualCells.size(), expectedCells.size());
    }

}