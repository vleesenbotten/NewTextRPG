package novi.basics;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	//Two system objects scanner and randomizer

        Scanner in = new Scanner(System.in);
        Random rand = new Random();

        //Game Variables such as enemy, health and attack damage and text
        String[] enemies = {"Skeleton", "Goblin", "Orc", "Cave Troll"};
        String[] enemyHurt = {"Ouch!", "That hurts!", "Why are you so mean..."};
        int maxEnemyHealth = 75;
        int enemyAttackDamage = 25;
        //int enemyGoldDrop = 10; VRAAG: hoe kan ik hier een randomizer van maken?
        int enemyGoldDropChance = 30;

        //Player variables
        int playerHealth = 100;
        int playerAttackDamage = 50;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 25;
        int healthPotionDropChance = 60;
        int amountOfGold = 10;

        boolean isRunning = true;

        System.out.println("Welcome to the dungeon, we got fun and DEATH!");

        GAME:
        while (isRunning) {
            System.out.println("--------------------------------------------------------------------------");

            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");

            //A while loop for combat
            while(enemyHealth > 0) {
                System.out.println("\tYour HP: " + playerHealth);
                System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t(1) Attack");
                System.out.println("\t(2) Drink a health potion");
                System.out.println("\t(3) Check out your gold");
                System.out.println("\t(4) Bravely run away, sir Robin!");

                String input = in.nextLine();
                if(input.equals("1")){
                    int damageDealt = rand.nextInt(playerAttackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    //-= haalt eerst het getal eraf en geeft dan het resultaat
                    enemyHealth -= damageDealt;
                    playerHealth -= damageTaken;
                    String cry = enemyHurt[rand.nextInt(enemyHurt.length)];

                    System.out.println("\t>You strike the " + enemy + " for " + damageDealt + " damage!");
                    System.out.println("\t\t\t" + enemy + " cries out: " + cry);
                    System.out.println("\t>You took " + damageTaken + " damage.");
                    System.out.println("\t>Your HP is now " + playerHealth + "...");

                    if(playerHealth < 1) {
                        System.out.println("\tBut did you die?");
                        break;
                    }
                }
                else if(input.equals("2")){
                    if(numHealthPotions > 0){
                        playerHealth += healthPotionHealAmount;
                        numHealthPotions--;
                        System.out.println("\t>You drink a health potion, healing yourself for " + healthPotionHealAmount + "."
                        + "\n\t> Your HP is now " + playerHealth
                        + "\n\t> You have " + numHealthPotions + " health potions left.");
                    } else {
                        System.out.println("\t>You have no health potions left.");
                    }

                }
                else if(input.equals("3")){
                    System.out.println("\t###################################################");
                    System.out.println("\tYou have " + amountOfGold + "g.");
                    System.out.println("\tYou can do absolutely nothing with it! So luxe!");
                    System.out.println("\t###################################################");
                }
                else if(input.equals("4")){
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("When danger reared it's ugly head,\n" +
                            "He bravely turned his tail and fled.\n" +
                            "Yes, brave Sir Robin turned about,\n" +
                            "And gallantly he chickened out.\n");
                    continue GAME;
                }
                else {
                    System.out.println("\tType in something valid, you numbnut.");
                }
            }
            //if player is dead
            if (playerHealth < 1){
                System.out.println("I guess you did. You know this isn't Dark Souls, right?");
                break;
            }

            if (enemyHealth < 1){
                System.out.println("--------------------------------------------------------------------------");
                System.out.println(" # " + enemy + " has been defeated! #");
                System.out.println(" # You survived with " + playerHealth + " HP! #");
                if(rand.nextInt(100) < healthPotionDropChance) {
                    numHealthPotions++;
                    System.out.println(" # The " + enemy + " dropped a health potion #");
                    System.out.println(" # You now have " + numHealthPotions + " health potions # ");
                }
                if(rand.nextInt(50) < enemyGoldDropChance){
                    amountOfGold++;
                    System.out.println(" # The " + enemy + " dropped some gold!");
                    System.out.println("# You now have " + amountOfGold + "g.");
                }

                System.out.println("--------------------------------------------------------------------------");
                System.out.println("What would you like to do?");
                System.out.println("(1) Continue fighting");
                System.out.println("(2) Exit the dungeon");

                String input = in.nextLine();

                while(!input.equals("1") && !input.equals("2")){
                    System.out.println("Still not getting this whole numbers input, huh? Try again...");
                    input = in.nextLine();
                }

                if(input.equals("1")){
                    System.out.println("You continue on your adventure!");
                    continue GAME;
                }

                else if(input.equals("2")){
                    System.out.println("You exit the dungeon, succesful in your adventure!");}
                    break;
            }
        }
        System.out.println("##########################");
        System.out.println("# THANK YOU FOR PLAYING! #");
        System.out.println("##########################");
    }
}
