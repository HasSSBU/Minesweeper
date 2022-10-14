import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSpaceTest {

    Tile testNumberSpace = new NumberSpace();

    @Test
    public void testTileValue() {
        Assertions.assertEquals(0, testNumberSpace.getValue(), "NumberSpaces dont generate with value of 0");
    }
    @Test
    public void testTileName() {
        Assertions.assertEquals("0", testNumberSpace.getName(), "NumberSpaces dont generate with initial name 0");
    }
    @Test
    public void testTileIsMine() {
        Assertions.assertEquals(false, testNumberSpace.getMine(), "Numberspaces generate as mine");
    }
    @Test
    public void testTileValueUpdate() {
        Assertions.assertEquals(1, testNumberSpace.getValue()+1, "numberspace values dont update properly");
    }
}
