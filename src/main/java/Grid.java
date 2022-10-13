import java.security.SecureRandom;

public class Grid {

    Tile[][] table;
    int numbOfMines;
    boolean active = true;
    int hiddenTiles;

    public Grid(){
        table = new Tile[6][9];
        numbOfMines = 10;
        setMines(table);
        hiddenTiles = table.length * table[0].length;
    }

    public void setMines(Tile[][] table){
        for(int i=0; i <= numbOfMines -1; i++) {
            SecureRandom random = new SecureRandom();
            int across = random.nextInt(table.length);
            int down = random.nextInt(table[0].length);
            table[across][down] = new Mine();

        }

        setZeroes(table);
        setValues(table);
        setNames(table);
    }

    public void setZeroes(Tile[][] table){
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[0].length; j++) {
                if (table[i][j] == null) {
                    table[i][j] = new NumberSpace();
                }
            }
        }
    }
    public void setValues(Tile[][] table){
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[0].length; j++) {
                if(table[i][j].getMine()){
                    if(i == 0 && j == 0){
                        table[i + 1][j].addNearbyMine();
                        table[i + 1][j + 1].addNearbyMine();
                    }else if (i == table.length-1 && j == table[0].length-1) {
                        table[i - 1][j - 1].addNearbyMine();
                        table[i - 1][j].addNearbyMine();
                        table[i][j - 1].addNearbyMine();
                    }else if (i == table.length-1 && j == 0) {
                        table[i - 1][j + 1].addNearbyMine();
                        table[i - 1][j].addNearbyMine();
                        table[i][j +1].addNearbyMine();
                    }else if (i == 0 && j == table[0].length-1) {
                        table[i + 1][j - 1].addNearbyMine();
                        table[i + 1][j].addNearbyMine();
                        table[i][j - 1].addNearbyMine();
                    }else if(i == 0) {
                        table[i][j - 1].addNearbyMine();
                        table[i][j + 1].addNearbyMine();
                        table[i + 1][j - 1].addNearbyMine();
                        table[i + 1][j].addNearbyMine();
                        table[i + 1][j + 1].addNearbyMine();
                    }else if(i == table.length-1){
                        table[i - 1][j - 1].addNearbyMine();
                        table[i - 1][j].addNearbyMine();
                        table[i - 1][j + 1].addNearbyMine();
                        table[i][j - 1].addNearbyMine();
                        table[i][j + 1].addNearbyMine();
                    }else if(j == 0){
                        table[i - 1][j].addNearbyMine();
                        table[i - 1][j + 1].addNearbyMine();
                        table[i][j + 1].addNearbyMine();
                        table[i + 1][j].addNearbyMine();
                        table[i + 1][j + 1].addNearbyMine();
                    }else if(j == table[0].length-1){
                        table[i - 1][j - 1].addNearbyMine();
                        table[i - 1][j].addNearbyMine();
                        table[i][j - 1].addNearbyMine();
                        table[i + 1][j - 1].addNearbyMine();
                        table[i + 1][j].addNearbyMine();
                    }else{
                        table[i - 1][j - 1].addNearbyMine();
                        table[i - 1][j].addNearbyMine();
                        table[i - 1][j + 1].addNearbyMine();

                        table[i][j - 1].addNearbyMine();
                        table[i][j + 1].addNearbyMine();

                        table[i + 1][j - 1].addNearbyMine();
                        table[i + 1][j].addNearbyMine();
                        table[i + 1][j + 1].addNearbyMine();
                    }
                }
            }
        }
    }

    public void showTiles(int across, int down) {
        if (table[across][down].getHidden()) {
            this.hiddenTiles -= 1;
        }
        if(hiddenTiles == numbOfMines){
            this.active = false;
        }
        if(table[across][down].getMine()){
            this.active = false;
        }
        if(table[across][down].getFlag()){
            this.setFlag(across, down);
        }
        this.table[across][down].setHidden(false);


        if (this.table[across][down].getValue() == 0) {
            int[] acrossX = {across - 1, across, across + 1};
            int[] downY = {down - 1, down, down + 1};
            for (int i : acrossX) {
                if (acrossBounds(i)) {
                    for (int j : downY) {
                        if (downBounds(j) && this.table[i][j].getHidden()) {
                            this.table[i][j].setHidden(false);
                            this.hiddenTiles -= 1;
                            if(hiddenTiles == numbOfMines){
                                this.active = false;
                            }
                            System.out.println(getTable());
                            showTiles(i, j);
                        }
                    }
                }
            }
        }
    }

    public boolean downBounds(int j) {
        return j >= 0 && j < this.table[0].length;
    }

    public boolean acrossBounds(int i){
        return i >= 0 && i < this.table.length;
    }

    public void setFlag(int across, int down){
        if(this.table[across][down].getHidden()) {
            this.table[across][down].setFlag();
            this.table[across][down].setHidden(false);
        }else if(this.table[across][down].getFlag()){
            this.table[across][down].setFlag();
            this.table[across][down].setHidden(true);
        }else{
            System.out.println("Can not place Flag, try again");
        }
    }
    public void setNames(Tile[][] table){
        for (Tile[] tiles : table) {
            for (int j = 0; j < table[0].length; j++) {
                if(tiles[j].getHidden()){
                    tiles[j].setName("[]");
                }else if(tiles[j].getFlag()){
                    tiles[j].setName(" #");
                } else if (tiles[j].getMine()) {
                    tiles[j].setName(" M");
                } else {
                    tiles[j].setName(" " + tiles[j].value);
                }
            }
        }
    }

    public String getTable() {
        StringBuilder out = new StringBuilder();
        for (int i= 0; i< table.length; i++) {
            out.append("    ").append(i+1).append("  ");
        }
        out.append("""


                """);
        for (int i= 0; i< table[0].length; i++) {
            out.append(i+1).append("| ");
            for (Tile[] tiles : table) {
                out.append(tiles[i].getName()).append("     ");
            }
            out.append("\n");
        }
        out.append("Bombs on board: ").append(numbOfMines).append("\n");
        out.append("Tiles left to clear: ").append(hiddenTiles).append("\n");
        return out.toString();
    }

}
