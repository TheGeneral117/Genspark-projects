public class Goblin {
    private int strength;
    private int health, maxHealth;
    private int[] pos = new int[]{0,0};

    public Goblin(int size){
        pos[0] = (int)(Math.random() * size);
        pos[1] = (int)(Math.random() * size);
        strength = (int)(Math.random() * 3) + 1;
        health = maxHealth = (int)(Math.random() * 7) + 1;
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
        if(health < 0)
            this.health = 0;
        else if(health > maxHealth)
            this.health = maxHealth;
    }

    public void setPos(int moveX, int moveY, int size){
        int x = moveX, y = moveY;

        if(x < 0)
            x=0;
        if(x >= size)
            x = size-1;

        if(y < 0)
            y=0;
        if(y >= size)
            y = size-1;

        pos[0] = y;
        pos[1] = x;
    }

    public void movePos(int moveX, int moveY, int size){
        int y = pos[0], x = pos[1];
        x+=moveX;
        y+=moveY;

        if(x < 0)
            x=0;
        if(x >= size)
            x = size-1;

        if(y < 0)
            y=0;
        if(y >= size)
            y = size-1;
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
