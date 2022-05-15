package com.nicotiner_1.Person;


import com.nicotiner_1.Liquid.Nicotine;
import com.nicotiner_1.Puff.PuffTime;
import com.nicotiner_1.Puff.PuffType;
import com.nicotiner_1.Vape;

public abstract class Health {

    protected Health() {}

    public Health(Vape vape){
        calcNic(vape);
        calcCloudRation(vape);
        calcPuffTime(vape);
        calcExperience(vape);
        calcNicInOnePuff();
        Health.vape = vape;
        Experience experience = new Experience();
    }

    public Health(Nicotine nicotine, PuffType puffType, PuffTime puffTime, Experience.exp exp){
        calcNic(vape);
        calcCloudRation(vape);
        calcPuffTime(vape);
        calcExperience(vape);
        calcNicInOnePuff();
        Health.vape = new Vape(nicotine, puffType, puffTime, exp);
    }

    public static Vape vape = null;

    public enum Nic{;
        public static final double maxNicInBlood = 500;
    }

    public static double nicInOnePuff = 0;
    public static double nicInBlood = 0;
    public static double nicToSat = 0;

    public static double nic = 0;
    public static double cloudRatio = 0;
    public static double puffSec = 0;
    public static int valueMl = 30;

    public void calcNic(Vape vape){
        if (vape.getNicotine() != null){
            switch (vape.getNicotine()){
                case twoMg -> nic = 2;
                case sixMg -> nic = 6;
                case twelveMg -> nic = 12;
                case eighteenMg -> nic = 18;
                case twentyMg -> nic = 20;
                case twentyMgUltra -> nic = 40;
                case twentyMgStrong -> nic = 50;
                case twentyMgMega -> nic = 60;
                case twentyMgSuper -> nic = 70;
        }

        }
    }

    public void calcCloudRation(Vape vape){
        if (vape.getPuffType() != null) {
            switch (vape.getPuffType()) {
                case ToughMTL -> cloudRatio = 65;
                case MTL -> cloudRatio = 50;
                case Medium -> cloudRatio = 30;
                case RDL -> cloudRatio = 10;
            }
        }
    }

    public void calcPuffTime(Vape vape){
        if (vape.getPuffTime() != null) {
            switch (vape.getPuffTime()) {
                case shortP -> puffSec = 0.5;
                case cigaretteP -> puffSec = 0.8;
                case normalP -> puffSec = 1.5;
                case longP -> puffSec = 3.5;
                case veryLongP -> puffSec = 7;
            }
        }
    }

    public void calcExperience(Vape vape){
        if (vape.getExp() != null) {
            switch (vape.getExp()) {
                case nullExp_ -> {
                    nicInBlood = 0.000000098;
                    nicToSat = 1.5;
                }
                case mediumExp_ -> {
                    nicInBlood = 0.0000001;
                    nicToSat = 3.5;
                }
                case hardExp_ -> {
                    nicInBlood = 0.0000015;
                    nicToSat = 7;
                }
                case veryHardExp_ -> {
                    nicInBlood = 0.000004;
                    nicToSat = 12;
                }
            }
        }
    }

    public void calcNicInOnePuff(){
        nicInOnePuff = ((((nic/valueMl)/puffSec)/100)*cloudRatio);
    }

    public double getNic(){
        return nic;
    }
    public double getNicToSat(){return nicToSat;}
    public double getCloudRatio(){return cloudRatio;}
    public double getPuffSec(){return puffSec;}
    public double getNicInOnePuff(){return nicInOnePuff;}

    public boolean isLived(Vape vape){
        if (vape.getHealth() < Nic.maxNicInBlood) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isOverdoseSoon(Vape vape){
        if (vape.getHealth() > nicToSat && vape.getHealth() < vape.getNicToSat()*2){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isOverdose(Vape vape){
        if (vape.getHealth() > nicToSat * 2){
            return true;
        }
        else {
            return false;
        }
    }

    public abstract double getHealth();
}
