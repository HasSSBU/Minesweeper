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
        Assertions.assertEquals(false, testTile.getFlag(), "tiles generate as flagged");
    }
    @Test
    public void testTileIsNotMine() {
        Assertions.assertEquals(false, testTile.getMine(), "tiles generated as mine");
    }
    @Test
    public void testTileSetHidden() {
        testTile.setHidden(false);
        Assertions.assertEquals(false, testTile.getHidden(), "tiles set to be shown");
        testTile.setHidden(true);
    }
    @Test
    public void testTileSetFlag() {
        testTile.setFlag();
        Assertions.assertEquals(true, testTile.getHidden(), "tiles set to be shown");
        testTile.setFlag();
    }
    @Test
    public void testTileSetName() {
        testTile.setName("A");
        Assertions.assertEquals("A", testTile.getName(), "tiles set to be shown");
    }
}
