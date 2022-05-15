package com.nicotiner_1;

import com.nicotiner_1.Liquid.Nicotine;
import com.nicotiner_1.Out.GUIController;
import com.nicotiner_1.Person.Experience;
import com.nicotiner_1.Person.Health;
import com.nicotiner_1.Puff.PuffTime;
import com.nicotiner_1.Puff.PuffType;

public class Main{

    public static void main(String[] args){
        Vape vape = new Vape(Nicotine.twentyMgSuper, PuffType.ToughMTL, PuffTime.veryLongP, Experience.exp.nullExp_);
        Health health = new Health(vape) {
            @Override
            public double getHealth() {
                return nicInBlood;
            }
        };

        GUIController guiController = new GUIController(vape, health);

    }

}
