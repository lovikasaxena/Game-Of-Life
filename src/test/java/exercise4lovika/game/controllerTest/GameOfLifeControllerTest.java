package exercise4lovika.game.controllerTest;

import exercise4lovika.game.controller.GameOfLifeController;
import exercise4lovika.game.service.AliveCellRequiredException;
import exercise4lovika.game.service.GameOfLifeService;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

public class GameOfLifeControllerTest {
    GameOfLifeController gameOfLifeController = new GameOfLifeController();

    @Mock
    GameOfLifeService gameOfLifeService;

    @Test
    public void shouldcreateGrid() throws AliveCellRequiredException {
        List<String> cells = Arrays.asList("1,1");
        Map map = gameOfLifeController.createGrid(cells);
        assertTrue(map.size() != 0);
    }

    @Test(expected = AliveCellRequiredException.class)
    public void shouldthrowExcepetionAliveCellRequired() throws AliveCellRequiredException {
        List<String> cells = new ArrayList<>();
        Map map = gameOfLifeController.createGrid(Arrays.asList());
        assertTrue(map.size() != 0);
    }


}
