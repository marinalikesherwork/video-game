public class Main {
    public static void main(String[] args) {
        Player marina = new Player(10, 5, 10, new int[]{1, 2, 3});
        Monster monster1 = new Monster(10, 5, 10, new int []{1,2,3,4,5});
        Monster monster2 = new Monster(10, 15, 10, new int []{5, 6});

        Creature.atack(marina,monster1);
        Creature.atack(monster1,monster2);

        monster1.healYourself();
        monster1.healYourself();
        monster1.healYourself();
        monster1.healYourself();
        monster1.healYourself();

        Monster monster3 = new Monster(31, 31, -1, new int[]{2,3,4});
        System.out.println("атака " + monster3.getAtack() + " защита " + monster3.getDefense() + " здоровье " + monster3.getHealth());

    }
}
