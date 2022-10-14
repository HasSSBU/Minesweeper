import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MineTest {
    Tile testMine = new Mine();

    @org.junit.Test
    public void testMineValue() {
        Assertions.assertEquals(-2, testMine.getValue(), "NumberSpaces dont generate with value of -2");
    }

    @org.junit.Test
    public void testMineName(){
        Assertions.assertEquals("Mine", testMine.getName(), "NumberSpaces dont generate with initial name 0");
    }

    @org.junit.Test
    public void testMineIsMine(){
        Assertions.assertEquals(true, testMine.getMine(), "mine dont generate properly");
    }

}
