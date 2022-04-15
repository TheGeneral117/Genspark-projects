public class Goblin {
    private int strength;
    private int health;
    private int[] pos = new int[]{0,0};

    public Goblin(int size){
        pos[0] = (int)(Math.random() * size);
        pos[1] = (int)(Math.random() * size);
        strength = (int)(Math.random() * 3) + 1;
        health = (int)(Math.random() * 7) + 1;
    }

    public int getHealth() {
        return health;
    }

    public boolean Alive(){
        if(health <= 0)
            return false;
        return true;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setPos(int moveX, int moveY, int size){
        int x = pos[0], y = pos[1];
        x+=moveX;
        y+=moveY;

        if(x < 0)
            x=0;
        if(x > size)
            x = size;

        if(y < 0)
            y=0;
        if(y > size)
            y = size;
    }

    public int[] getPos(){
        return pos;
    }

    public int getStrength() {
        return strength;
    }

    public int combatChoice(){
        return (int)(Math.random() * 3) + 1;
    }

    public String toString(){
        return "▲";
    }
}
