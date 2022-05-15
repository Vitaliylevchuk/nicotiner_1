package com.nicotiner_1.Person;

public class Experience {

    public enum exp{
        nullExp_,
        mediumExp_,
        hardExp_,
        veryHardExp_
        ;

    }

    public enum nullExp{
        nicNormal (0.000000098),
        nicToSaturation (0.00030612244)
        ;

        nullExp(double mg) {
        }
    }
    public enum mediumExp{
        nicNormal (0.0000001),
        nicToSaturation (0.00071428571)
        ;

        mediumExp(double mg) {
        }
    }
    public enum hardExp{
        nicNormal (0.0000015),
        nicToSaturation (0.00142857142)
        ;

        hardExp(double mg) {
        }
    }
    public enum veryHardExp{
        nicNormal (0.000004),
        nicToSaturation (0.00244897959)
        ;

        veryHardExp(double mg) {
        }
    }

}
