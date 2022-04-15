public class Human{

    private int health = 1;
    private final int maxHealth = 1;
    private int strength;
    private int[] pos = new int[]{0,0};

    public Human(int size){
        pos[0] = (int)(Math.random() * size);
        pos[1] = (int)(Math.random() * size);
        strength = (int)(Math.random() * 5) + 1;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if(health < 0)
            this.health = 0;
        else if(health > maxHealth)
            this.health = maxHealth;
    }

    public void Heal(){
        int heal = (int)(Math.random()*4);
        health += heal;
        if(health>maxHealth) {
            health = maxHealth;
            System.out.println("You healed to full health!");
            return;
        }
        System.out.printf("You healed for %d points, you have %d points remaining\n",heal,health);
    }

    public int getStrength(){
        return strength;
    }

    public void setPos(int moveX, int moveY, int size){
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
        pos[0] = y;
        pos[1] = x;
    }

    public int[] getPos(){
        return pos;
    }

    public boolean Alive(){
        if(health <= 0)
            return false;
        return true;
    }

    public String toString(){
        return "◉";
    }
}
