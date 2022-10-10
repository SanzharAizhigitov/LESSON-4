package org.example;

public class Main {
    public static  int bossHP =800;
    public static  int bossDAMAGE =50;
    public static  String bossDefenseType;
    public static  String[] heroesAttackTypes = {"Kinetic","Magical","Physical"};
    public static  int[] heroesHP = {300, 200,250};
    public static  int[] heroesDamage = {30,40,20};
    public static  int round = 0;
    public static void main(String[] args) {
state();
while (!isGameFinish()){playRound();}
    }
    public static void state() {
        System.out.println("round is " + round + "--------------");
        System.out.println("BossHP - " + bossHP);
        System.out.println("BossDamage - " + bossDAMAGE);
        System.out.println("BossDefense - " + (
                bossDefenseType==null ? "No defence" : bossDefenseType));
        for (int i = 0; i < heroesAttackTypes.length; i++) {
            System.out.println(heroesAttackTypes[i] + " Health - "
                    + heroesHP[i] + " Damage - " + heroesDamage[i]);}
    }
    public static boolean isGameFinish(){boolean allHeroDie = true;
        if (bossHP <= 0){ System.out.println("HeroesWon");
        return true;}
        for (int i = 0; i < heroesAttackTypes.length; i++) {
if (heroesHP[i]>0) allHeroDie = false; break;
        }
        if (allHeroDie == true){
            System.out.println("Boss won");
       return true; } else return false;
    }
    public static void bossHit (){
    for (int i = 0; i < heroesAttackTypes.length; i++) {
       if (bossHP>0){heroesHP[i]=heroesHP[i] - bossDAMAGE;
        if (heroesHP[i] <0){heroesHP[i]=0 ;}}
    }
}
    public static void heroesHit () {
        for (int i = 0; i < heroesAttackTypes.length; i++) {
            if (heroesHP[i]>0){
                bossHP = bossHP - heroesDamage[i];
            }
            }
        }
    public static void playRound (){
round++;
        bossHit();
heroesHit();
state();
}

}