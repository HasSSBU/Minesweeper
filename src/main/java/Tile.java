public class Tile {

    private boolean hidden;
    private boolean flagged;
    protected boolean mine;
    protected String name;
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

    public void setFlag(){
        this.flagged = !this.flagged;
    }
    public boolean getFlag(){
        return flagged;
    }
    public void addMine(){
        this.value = this.value + 1;
    }

    public boolean getMine(){
        return this.mine;
    }
    public int getValue(){
        return this.value;
    }

    public void setName(String n){
        this.name = n;
    }
    public String getName(){
        return name;
    }
    public boolean getHidden(){
        return this.hidden;
    }
    public void setHidden(boolean x){
        this.hidden = x;
    }
}
