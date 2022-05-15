package com.nicotiner_1.Out;

import com.nicotiner_1.Person.Health;
import com.nicotiner_1.Vape;

public class Output {
    public static boolean saturated = true;

    public void printHealth(Health health, Vape vape){

        System.out.println("Ваше здоровье:\n" +
                         "Никотина в крови: " + health.getHealth() + "\n" +
                         "Никотина в одной затяжке: " + health.nicInOnePuff + "\n" +
                         "Сделано затяжек: " + vape.puffs +
                         "\n" +
                         checkSaturation(health));
        System.out.println();
    }

    private String checkSaturation(Health health) {
        if (health.getNicToSat() - health.getHealth() > 0){
            return "До насыщения никотином осталось: " + (health.getNicToSat() - health.getHealth());
        }
        if (health.getNicToSat() - health.getHealth() <= 0 && saturated){
            saturated = false;
            return "Вы полностью насытились никотином!";
        }
        else if (Health.Nic.maxNicInBlood > health.getHealth() && health.getHealth() > health.getNicToSat()){
            String a;
            a = "ВЫ ПЕРЕНАСЫТИЛИСЬ НИКОТИНОМ, ВОЗМОЖЕН БЫСТРЫЙ ПЕРЕДОЗ!!!";
            if (health.getNicToSat() >= health.getHealth()*2){
                a = "Y ваС круЖыться галAва Тi чуствуеш рвоTHые позывы and жаR пA всему tелу$!";
            }
            return a;
        }
        if (Health.Nic.maxNicInBlood <= health.getHealth()){
            return "ВАМ КОНЕЦ!!!";
        }
        else {
            return null;
        }
    }
}
