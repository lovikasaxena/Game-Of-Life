package exercise4lovika.game.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Cell {
    final private Integer x;
    final private Integer y;

    public Cell(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return Objects.equals(x, cell.x) &&
                Objects.equals(y, cell.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public List<Cell> getAdjacentCells() {
        List<Cell> cells = new ArrayList<>();
        cells.addAll(getHorizontallyAdjacentCells());
        cells.addAll(getVerticallyAdjacentCells());
        cells.addAll(getDiagonallyAdjacentCells());
        return cells;
    }

    private Collection<Cell> getDiagonallyAdjacentCells() {
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(x+1,y-1));
        cells.add(new Cell(x-1,y+1));
        cells.add(new Cell(x+1,y+1));
        cells.add(new Cell(x-1,y-1));
        return cells;
    }

    private Collection<Cell> getVerticallyAdjacentCells() {
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(x,y-1));
        cells.add(new Cell(x,y+1));
        return cells;
    }

    private Collection<Cell> getHorizontallyAdjacentCells() {
        List<Cell> cells = new ArrayList<>();
        cells.add(new Cell(x-1,y));
        cells.add(new Cell(x+1,y));
        return cells;
    }
}
