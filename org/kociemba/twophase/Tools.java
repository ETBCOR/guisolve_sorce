/*
 * Decompiled with CFR 0_118.
 */
package org.kociemba.twophase;

import java.util.Random;
import org.kociemba.twophase.Color;
import org.kociemba.twophase.CubieCube;
import org.kociemba.twophase.FaceCube;

public class Tools {
    public static int verify(String s) {
        int i;
        int[] count = new int[6];
        try {
            i = 0;
            while (i < 54) {
                int[] arrn = count;
                int n = Color.valueOf(s.substring(i, i + 1)).ordinal();
                arrn[n] = arrn[n] + 1;
                ++i;
            }
        }
        catch (Exception e) {
            return -1;
        }
        i = 0;
        while (i < 6) {
            if (count[i] != 9) {
                return -1;
            }
            ++i;
        }
        FaceCube fc = new FaceCube(s);
        CubieCube cc = fc.toCubieCube();
        return cc.verify();
    }

    public static String randomCube() {
        CubieCube cc = new CubieCube();
        Random gen = new Random();
        cc.setFlip((short)gen.nextInt(2048));
        cc.setTwist((short)gen.nextInt(2187));
        do {
            cc.setURFtoDLB(gen.nextInt(40320));
            cc.setURtoBR(gen.nextInt(479001600));
        } while ((cc.edgeParity() ^ cc.cornerParity()) != 0);
        FaceCube fc = cc.toFaceCube();
        return fc.to_String();
    }
}

