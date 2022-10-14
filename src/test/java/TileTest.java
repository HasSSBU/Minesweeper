import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TileTest {

    Tile testTile = new Tile();

    @Test
    public void testTileIsHidden() {
        Assertions.assertEquals(true, testTile.getHidden(), "Tiles generate as visible");
    }
    @Test
    public void testTileIsUnflagged() {
        Assertions.assertEquals(false, testTile.getFlag(), "tiles generate as unflagged");
    }
    @Test
    public void testFlagTile() {
        testTile.setFlag();
        Assertions.assertEquals(true, testTile.getFlag(), "tiles generate as flagged");
        testTile.setFlag();
        Assertions.assertEquals(false, testTile.getFlag(), "tiles generate as flagged");
    }
    @Test
    public void testAddNearbyMine() {
        testTile.addNearbyMine();
        Assertions.assertEquals(1,testTile.getValue());
    }
    @Test
    public void testGetValue() {
        Assertions.assertEquals(0, testTile.getValue(), "tiles generate as flagged");
    }
    @Test
    public void testTileIsNotMine() {
        Assertions.assertEquals(false, testTile.getMine(), "tiles generated as mine");
    }
    @Test
    public void testTileSetHidden() {
        testTile.setHidden(false);
        Assertions.assertEquals(false, testTile.getHidden(), "unflagged tile flagged");
        testTile.setHidden(true);
        Assertions.assertEquals(true, testTile.getHidden(), "flagged tile not unflagged");
    }
    @Test
    public void testTileGetName() {
        Assertions.assertEquals("0", testTile.getName(), "tiles set to be shown");
    }
    @Test
    public void testTileSetName() {
        testTile.setName("A");
        Assertions.assertEquals("A", testTile.getName(), "tiles set to be shown");
    }
}
