public class Grid {

    Tile[][] table;
    int numbOfMines;

    public Grid(){
        table = new Tile[6][6];
        numbOfMines = 6;
        setMines(table);
    }

    public void setMines(Tile[][] table){
        for(int i=0; i <= numbOfMines; i++) {
            table[(int) (Math.random() * 5)][(int) (Math.random() * 5)] = new Mine();
        }

        setZeroes(table);
        setValues(table);
        setRest(table);

    }

    public void setZeroes(Tile[][] table){
        for(int i = 0; i <= table.length; i++){
            for(int j = 0; j <= table.length; j++) {
                if (table[i][j] == null) {
                    table[i][j] = new NumberSpace(0);
                }
            }
        }
    }
    public void setValues(Tile[][] table){
        for(int i = 0; i <= table.length; i++){
            for(int j = 0; j <= table.length; j++) {
                if(table[i][j].getMine()){
                    table[i-1][j-1].setValue(table[i][j].getValue() + 1);
                    table[i-1][j].setValue(table[i][j].getValue() + 1);
                    table[i-1][j+1].setValue(table[i][j].getValue() + 1);

                    table[i][j-1].setValue(table[i][j].getValue() + 1);
                    table[i][j+1].setValue(table[i][j].getValue() + 1);

                    table[i+1][j-1].setValue(table[i][j].getValue() + 1);
                    table[i+1][j].setValue(table[i][j].getValue() + 1);
                    table[i+1][j+1].setValue(table[i][j].getValue() + 1);
                }
            }
        }
    }

    public void setRest(Tile[][] table){
        for(int i = 0; i <= table.length; i++) {
            for (int j = 0; j <= table.length; j++) {
                if(table[i][j].getValue() == 0){
                    table[i][j] = new Tile();
                }
            }
        }
    }

    public Tile[][] getTable() {
        return table;
    }

    public void setTable(Tile[][] table) {
        this.table = table;
    }
}
