package exercise4lovika.game.controller;

import exercise4lovika.game.service.AliveCellRequiredException;
import exercise4lovika.game.service.GameOfLifeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class GameOfLifeController {
    GameOfLifeService gameOfLifeService;

    public GameOfLifeController() {
        this.gameOfLifeService = new GameOfLifeService();
    }

    @RequestMapping(path = "/grid", method = RequestMethod.POST)
    public Map createGrid(@RequestBody List<String> stringArray) throws AliveCellRequiredException {
        gameOfLifeService.giveStateToCells(stringArray);
        return gameOfLifeService.getGridMap();
    }

    @PostMapping(path = "/grid/tick")
    public Map tick() {
        return gameOfLifeService.tick();
    }
}
