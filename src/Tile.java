public class Tile {

    private boolean hidden;
    private boolean flagged;
    protected boolean mine;

    protected int value;

    public Tile(){
        this.hidden = true;
        this.flagged = false;
        this.mine = false;
        this.value = 0;

    }

    public void tileClick(Tile tile){
        tile.hidden = false;
    }

    public void setFlag(Tile tile){
        tile.flagged = !tile.flagged;
    }

    public void setValue(int i){
        this.value = i;
    }

    public boolean getMine(){
        return this.mine;
    }
    public int getValue(){
        return this.value;
    }

}
