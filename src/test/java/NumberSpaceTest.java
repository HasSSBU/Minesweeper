import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NumberSpaceTest {

    Tile testNumberSpace = new NumberSpace();

    @org.junit.Test
    public void testNumberSpaceValue() {
        Assertions.assertEquals(0, testNumberSpace.getValue(), "NumberSpaces dont generate with value of 0");
    }
    @org.junit.Test
    public void testNumberSpaceName() {
        Assertions.assertEquals("0", testNumberSpace.getName(), "NumberSpaces dont generate with initial name 0");
    }
    @org.junit.Test
    public void testNumberSpaceIsMine() {
        Assertions.assertEquals(false, testNumberSpace.getMine(), "Numberspaces generate as mine");
    }
    @org.junit.Test
    public void testNumberSpaceValueUpdate() {
        Assertions.assertEquals(1, testNumberSpace.getValue()+1, "numberspace values dont update properly");
    }
}
