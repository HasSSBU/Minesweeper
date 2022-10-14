import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GridTest {

    Grid testGrid = new Grid();

    @Test
    public void testNumbOfMines(){
        Assertions.assertEquals(10, testGrid.numbOfMines, "incorrect numb of Mines");
    }
    @Test
    public void testActive(){
        Assertions.assertEquals(true, testGrid.active, "active set to false");
    }
    @Test
    public void testHiddenTiles(){
        Assertions.assertEquals(9 * 9, testGrid.table.length * testGrid.table[0].length, "table set to wrong dimension");
    }
}

