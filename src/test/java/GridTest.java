import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GridTest {

    Grid testGrid = new Grid();


    @org.junit.Test
    public void testPopulateMines(){
        int counter =0;
        for(int i=0; i < testGrid.table.length; i++){
            for(int j=0; j < testGrid.table[0].length; j++){
                if(testGrid.table[i][j].getMine()){
                    counter++;
                }
            }
        }
        Assertions.assertEquals(testGrid.numbOfMines, counter, "mines dont place correctly, Mines likely overlap");
    }

    @org.junit.Test
    public void testSetZeroes(){
        testGrid.table = new Tile[5][5];
        testGrid.table[2][4] = new Mine();
        testGrid.table[4][4] = new Mine();
        testGrid.table[1][1] = new Mine();
        testGrid.setZeroes(testGrid.table);
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length -1; j++) {
                if(!testGrid.table[i][j].getMine()) {
                    Assertions.assertEquals(0, testGrid.table[i][j].getValue(), "Zeroes arent placing correctly");
                }
            }
        }
    }
    @org.junit.Test
    public void testSetValuesAllTiles(){
        testGrid.table = new Tile[5][5];
        testGrid.table[1][1] = new Mine();
        testGrid.table[1][4] = new Mine();
        testGrid.table[4][1] = new Mine();
        testGrid.table[4][4] = new Mine();
        testGrid.setZeroes(testGrid.table);
        testGrid.setValues(testGrid.table);
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length - 1; j++) {
                if (!testGrid.table[i][j].getMine()) {
                    Assertions.assertEquals(true, testGrid.table[i][j].getValue()>0, "Zeroes arent placing correctly");
                }
            }
        }
    }
    @org.junit.Test
    public void testSetValuesSomeTiles(){
        testGrid.table = new Tile[5][5];
        testGrid.table[1][1] = new Mine();
        testGrid.table[1][4] = new Mine();
        testGrid.setZeroes(testGrid.table);
        testGrid.setValues(testGrid.table);
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length - 1; j++) {
                if (!testGrid.table[i][j].getMine()) {
                    Assertions.assertEquals(true, testGrid.table[i][j].getValue()>=0, "Values arent updating correctly");
                }
            }
        }
    }
    @org.junit.Test
    public void testShowTilesAt0NoMines(){
        testGrid.table = new Tile[5][5];
        testGrid.table[1][1] = new Mine();
        testGrid.table[1][4] = new Mine();
        testGrid.setZeroes(testGrid.table);
        testGrid.setValues(testGrid.table);
        testGrid.showTiles(4, 4);
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length - 1; j++) {
                if(testGrid.table[i][j].getMine()){
                    Assertions.assertEquals(true, testGrid.table[i][j].getHidden(), "mines are being shown");
                }
            }
        }
    }
    @org.junit.Test
    public void testShowTilesAt0InacessibleTiles(){
        testGrid.table = new Tile[5][5];
        testGrid.table[1][1] = new Mine();
        testGrid.table[4][4] = new Mine();
        testGrid.setZeroes(testGrid.table);
        testGrid.setValues(testGrid.table);
        testGrid.showTiles(1, 4);
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length - 1; j++) {
                if(i>=0 && i<=2 && j>=3 && j<=5){
                    Assertions.assertEquals(false, testGrid.table[i][j].getHidden(), "accessible tiles hidden");
                }
            }
        }
    }
    @org.junit.Test
    public void testShowTilesAt0AccessibleTiles(){
        testGrid.table = new Tile[5][5];
        testGrid.table[1][1] = new Mine();
        testGrid.table[4][4] = new Mine();
        testGrid.setZeroes(testGrid.table);
        testGrid.setValues(testGrid.table);
        testGrid.showTiles(1, 4);
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length - 1; j++) {
                if(i>3 && j<3 && i<5 && j < 5 ){
                    Assertions.assertEquals(true, testGrid.table[i][j].getHidden(), "inaccessible tiles showing");
                }
            }
        }
    }

    @org.junit.Test
    public void testHiddenUpdate(){
        testGrid.setMines(testGrid.table);
        testGrid.showTiles(1, 4);
        int counter = testGrid.table.length * testGrid.table[0].length;
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length - 1; j++) {
                if(!testGrid.table[i][j].getHidden()){
                    counter -= 1;
                }
            }
        }
        Assertions.assertEquals(counter, testGrid.hiddenTiles, "hidden tile counter not updating");
    }

    @org.junit.Test
    public void testSetAllToFlag(){
        testGrid.table = new Tile[5][5];
        testGrid.setZeroes(testGrid.table);
        testGrid.setValues(testGrid.table);
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length - 1; j++) {
                testGrid.table[i][j].setFlag();
                Assertions.assertEquals(true, testGrid.table[i][j].getFlag(), "Flagged item is un-flagged");
            }
        }
    }
    @org.junit.Test
    public void testSetSomeToFlag(){
        testGrid.table = new Tile[5][5];
        testGrid.setZeroes(testGrid.table);
        testGrid.setValues(testGrid.table);
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length - 1; j++) {
                if(i%2 ==0 && j %3 == 1) {
                    testGrid.table[i][j].setFlag();
                }
            }
        }
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length - 1; j++) {
                if(i%2 ==0 && j %3 == 1) {
                    Assertions.assertEquals(true, testGrid.table[i][j].getFlag(), "Flagged item is un-flagged");
                }else{
                    Assertions.assertEquals(false, testGrid.table[i][j].getFlag(), "unFlagged item is flagged");
                }
            }
        }
    }
    @org.junit.Test
    public void testRemoveFlags(){
        testGrid.table = new Tile[5][5];
        testGrid.setZeroes(testGrid.table);
        testGrid.setValues(testGrid.table);
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length - 1; j++) {
                if (i % 2 == 0 && j % 3 == 1) {
                    testGrid.table[i][j].setFlag();
                }
            }
        }
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length - 1; j++) {
                if (i % 2 == 0 && j % 3 == 1) {
                    testGrid.table[i][j].setFlag();
                }
            }
        }
        for(int i=0; i < testGrid.table.length -1; i++) {
            for (int j = 0; j < testGrid.table[0].length - 1; j++) {
                Assertions.assertEquals(false, testGrid.table[i][j].getFlag());
            }
        }
    }
}
