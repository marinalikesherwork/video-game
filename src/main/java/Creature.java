import java.util.concurrent.ThreadLocalRandom;

public class Creature {

    private int atack; //1-30
    private int defense; //1-30
    private double health; //0 - N
    private double currentHealth = health;

    private int[] damage; //M-N
    private int healingCount = 0;

    public void healYourself(){
        if (healingCount < 4){
            currentHealth = currentHealth + health*0.3;
            System.out.println("Игрок исцелил себя. Теперь его здоровье равно " + currentHealth);
            healingCount +=1;
        }
        else {
            System.out.println("Исцеление недоступно. Вы уже исцеляли себя 4 раза.");
        }
    }

    public static void atack (Creature atacker, Creature defender){

        if (defender.currentHealth <= 0) {
            System.out.println("Игрок уже убит. Вы не можете его далее атаковать.");
        } else {
            int modificator = atacker.atack > defender.defense ? (atacker.atack - defender.defense + 1) : 1;

            System.out.println("Модификатор равен  " + modificator + ". Игрок будет бросать кубик " + modificator + " раз(а)");

            while (modificator > 0){
                int cubeNumbers = ThreadLocalRandom.current().nextInt(1, 7);
                System.out.println("Игрок бросает кубики. Выпадает " + cubeNumbers);

                if(cubeNumbers == 5 || cubeNumbers == 6){
                    int randomDamage = ThreadLocalRandom.current().nextInt(atacker.damage[0], atacker.damage[atacker.damage.length-1]);
                    defender.currentHealth = defender.currentHealth - randomDamage;
                    System.out.println("Успех! Выпала цифра 5 или 6. Второму игроку нанесён урон: " + randomDamage + ". Его здоровье " + defender.currentHealth);

                    if (defender.currentHealth <= 0){
                        System.out.println("Игрок убит.");
                        break;
                    }
                } else {
                    System.out.println("Выпала цифра от 1 до 4. Урон второму игроку нанесён не будет. Его здоровье " + defender.currentHealth);
                }
                modificator -= 1;
            }
        }
    }

    public Creature(int atack, int defense, int health, int[] damage){
        this.atack = atack;
        this.defense = defense;
        this.health = health;
        this.currentHealth = health;
        this.damage = damage;

        if(atack > 30){
            this.atack = 30;
        }
        if (atack <= 0){
            this.atack = 1;
        }

        if(defense > 30){
            this.defense = 30;
        }
        if (defense <= 0){
            this.defense = 1;
        }

        if (health <= 0){
            this.health = 0;
        }
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public double getHealth() {
        return health;
    }

    public int getAtack() {
        return atack;
    }

    public int getDefense() {
        return defense;
    }

    public int[] getDamage() {
        return damage;
    }

    public void setAtack(int atack) {
        this.atack = atack;
    }

    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    public void setDamage(int[] damage) {
        this.damage = damage;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setHealth(double health) {
        this.health = health;
    }
}
