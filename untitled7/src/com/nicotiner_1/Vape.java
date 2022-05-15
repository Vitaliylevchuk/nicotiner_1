package com.nicotiner_1;

import com.nicotiner_1.Liquid.Nicotine;
import com.nicotiner_1.Out.Output;
import com.nicotiner_1.Person.Experience;
import com.nicotiner_1.Person.Health;
import com.nicotiner_1.Puff.PuffTime;
import com.nicotiner_1.Puff.PuffType;

public class Vape extends Health {

    private static Nicotine nicotine;
    private static PuffType puffType;
    private static PuffTime puffTime;
    private static Experience.exp exp;

    public static int puffs = 0;

    public Vape(Nicotine nicotine, PuffType puffType, PuffTime puffTime, Experience.exp exp){
        Vape.nicotine = nicotine;
        Vape.puffType = puffType;
        Vape.puffTime = puffTime;
        Vape.exp = exp;
    }

    @Override
    public double getHealth() {
        return nicInBlood;
    }

    public void setNicotine(Nicotine nicotine){
        this.nicotine = nicotine;
    }
    public void setPuffType(PuffType puffType){
        this.puffType = puffType;
    }
    public void setPuffTime(PuffTime puffTime){
        this.puffTime = puffTime;
    }
    public void setExp(Experience.exp exp){
        this.exp = exp;
    }

    public Nicotine getNicotine(){
        return nicotine;
    }
    public PuffType getPuffType(){
        return puffType;
    }
    public PuffTime getPuffTime(){
        return puffTime;
    }
    public Experience.exp getExp(){
        return exp;
    }

    public static void puff(Vape vape, Health health){
       vape.nicInBlood += health.nicInOnePuff;
       puffs ++;
       Output output = new Output();
       output.printHealth(health, vape);
    }

}
