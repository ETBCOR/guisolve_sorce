/*
 * Decompiled with CFR 0_118.
 */
package org.kociemba.twophase;

import org.kociemba.twophase.CubieCube;

class CoordCube {
    static final short N_TWIST = 2187;
    static final short N_FLIP = 2048;
    static final short N_SLICE1 = 495;
    static final short N_SLICE2 = 24;
    static final short N_PARITY = 2;
    static final short N_URFtoDLF = 20160;
    static final short N_FRtoBR = 11880;
    static final short N_URtoUL = 1320;
    static final short N_UBtoDF = 1320;
    static final short N_URtoDF = 20160;
    static final int N_URFtoDLB = 40320;
    static final int N_URtoBR = 479001600;
    static final short N_MOVE = 18;
    short twist;
    short flip;
    short parity;
    short FRtoBR;
    short URFtoDLF;
    short URtoUL;
    short UBtoDF;
    int URtoDF;
    static short[][] twistMove;
    static short[][] flipMove;
    static short[][] parityMove;
    static short[][] FRtoBR_Move;
    static short[][] URFtoDLF_Move;
    static short[][] URtoDF_Move;
    static short[][] URtoUL_Move;
    static short[][] UBtoDF_Move;
    static short[][] MergeURtoULandUBtoDF;
    static byte[] Slice_URFtoDLF_Parity_Prun;
    static byte[] Slice_URtoDF_Parity_Prun;
    static byte[] Slice_Twist_Prun;
    static byte[] Slice_Flip_Prun;

    static {
        int k;
        int j;
        int newSlice;
        int slice;
        int i;
        short newParity;
        int parity;
        int j2;
        int slice2;
        int j3;
        short newSlice2;
        twistMove = new short[2187][18];
        CubieCube a = new CubieCube();
        short i2 = 0;
        while (i2 < 2187) {
            a.setTwist(i2);
            j3 = 0;
            while (j3 < 6) {
                k = 0;
                while (k < 3) {
                    a.cornerMultiply(CubieCube.moveCube[j3]);
                    CoordCube.twistMove[i2][3 * j3 + k] = a.getTwist();
                    ++k;
                }
                a.cornerMultiply(CubieCube.moveCube[j3]);
                ++j3;
            }
            i2 = (short)(i2 + 1);
        }
        flipMove = new short[2048][18];
        a = new CubieCube();
        i2 = 0;
        while (i2 < 2048) {
            a.setFlip(i2);
            j3 = 0;
            while (j3 < 6) {
                k = 0;
                while (k < 3) {
                    a.edgeMultiply(CubieCube.moveCube[j3]);
                    CoordCube.flipMove[i2][3 * j3 + k] = a.getFlip();
                    ++k;
                }
                a.edgeMultiply(CubieCube.moveCube[j3]);
                ++j3;
            }
            i2 = (short)(i2 + 1);
        }
        short[][] arrarrs = new short[2][];
        short[] arrs = new short[18];
        arrs[0] = 1;
        arrs[2] = 1;
        arrs[3] = 1;
        arrs[5] = 1;
        arrs[6] = 1;
        arrs[8] = 1;
        arrs[9] = 1;
        arrs[11] = 1;
        arrs[12] = 1;
        arrs[14] = 1;
        arrs[15] = 1;
        arrs[17] = 1;
        arrarrs[0] = arrs;
        short[] arrs2 = new short[18];
        arrs2[1] = 1;
        arrs2[4] = 1;
        arrs2[7] = 1;
        arrs2[10] = 1;
        arrs2[13] = 1;
        arrs2[16] = 1;
        arrarrs[1] = arrs2;
        parityMove = arrarrs;
        FRtoBR_Move = new short[11880][18];
        a = new CubieCube();
        i2 = 0;
        while (i2 < 11880) {
            a.setFRtoBR(i2);
            j3 = 0;
            while (j3 < 6) {
                k = 0;
                while (k < 3) {
                    a.edgeMultiply(CubieCube.moveCube[j3]);
                    CoordCube.FRtoBR_Move[i2][3 * j3 + k] = a.getFRtoBR();
                    ++k;
                }
                a.edgeMultiply(CubieCube.moveCube[j3]);
                ++j3;
            }
            i2 = (short)(i2 + 1);
        }
        URFtoDLF_Move = new short[20160][18];
        a = new CubieCube();
        i2 = 0;
        while (i2 < 20160) {
            a.setURFtoDLF(i2);
            j3 = 0;
            while (j3 < 6) {
                k = 0;
                while (k < 3) {
                    a.cornerMultiply(CubieCube.moveCube[j3]);
                    CoordCube.URFtoDLF_Move[i2][3 * j3 + k] = a.getURFtoDLF();
                    ++k;
                }
                a.cornerMultiply(CubieCube.moveCube[j3]);
                ++j3;
            }
            i2 = (short)(i2 + 1);
        }
        URtoDF_Move = new short[20160][18];
        a = new CubieCube();
        i2 = 0;
        while (i2 < 20160) {
            a.setURtoDF(i2);
            j3 = 0;
            while (j3 < 6) {
                k = 0;
                while (k < 3) {
                    a.edgeMultiply(CubieCube.moveCube[j3]);
                    CoordCube.URtoDF_Move[i2][3 * j3 + k] = (short)a.getURtoDF();
                    ++k;
                }
                a.edgeMultiply(CubieCube.moveCube[j3]);
                ++j3;
            }
            i2 = (short)(i2 + 1);
        }
        URtoUL_Move = new short[1320][18];
        a = new CubieCube();
        i2 = 0;
        while (i2 < 1320) {
            a.setURtoUL(i2);
            j3 = 0;
            while (j3 < 6) {
                k = 0;
                while (k < 3) {
                    a.edgeMultiply(CubieCube.moveCube[j3]);
                    CoordCube.URtoUL_Move[i2][3 * j3 + k] = a.getURtoUL();
                    ++k;
                }
                a.edgeMultiply(CubieCube.moveCube[j3]);
                ++j3;
            }
            i2 = (short)(i2 + 1);
        }
        UBtoDF_Move = new short[1320][18];
        a = new CubieCube();
        i2 = 0;
        while (i2 < 1320) {
            a.setUBtoDF(i2);
            j3 = 0;
            while (j3 < 6) {
                k = 0;
                while (k < 3) {
                    a.edgeMultiply(CubieCube.moveCube[j3]);
                    CoordCube.UBtoDF_Move[i2][3 * j3 + k] = a.getUBtoDF();
                    ++k;
                }
                a.edgeMultiply(CubieCube.moveCube[j3]);
                ++j3;
            }
            i2 = (short)(i2 + 1);
        }
        MergeURtoULandUBtoDF = new short[336][336];
        short uRtoUL = 0;
        while (uRtoUL < 336) {
            short uBtoDF = 0;
            while (uBtoDF < 336) {
                CoordCube.MergeURtoULandUBtoDF[uRtoUL][uBtoDF] = (short)CubieCube.getURtoDF(uRtoUL, uBtoDF);
                uBtoDF = (short)(uBtoDF + 1);
            }
            uRtoUL = (short)(uRtoUL + 1);
        }
        Slice_URFtoDLF_Parity_Prun = new byte[483840];
        int i3 = 0;
        while (i3 < 483840) {
            CoordCube.Slice_URFtoDLF_Parity_Prun[i3] = -1;
            ++i3;
        }
        int depth = 0;
        CoordCube.setPruning(Slice_URFtoDLF_Parity_Prun, 0, 0);
        int done = 1;
        while (done != 967680) {
            i = 0;
            while (i < 967680) {
                parity = i % 2;
                int URFtoDLF = i / 2 / 24;
                slice = i / 2 % 24;
                if (CoordCube.getPruning(Slice_URFtoDLF_Parity_Prun, i) == depth) {
                    j = 0;
                    while (j < 18) {
                        switch (j) {
                            case 3: 
                            case 5: 
                            case 6: 
                            case 8: 
                            case 12: 
                            case 14: 
                            case 15: 
                            case 17: {
                                break;
                            }
                            default: {
                                newSlice2 = FRtoBR_Move[slice][j];
                                short newURFtoDLF = URFtoDLF_Move[URFtoDLF][j];
                                newParity = parityMove[parity][j];
                                if (CoordCube.getPruning(Slice_URFtoDLF_Parity_Prun, (24 * newURFtoDLF + newSlice2) * 2 + newParity) != 15) break;
                                CoordCube.setPruning(Slice_URFtoDLF_Parity_Prun, (24 * newURFtoDLF + newSlice2) * 2 + newParity, (byte)(depth + 1));
                                ++done;
                            }
                        }
                        ++j;
                    }
                }
                ++i;
            }
            ++depth;
        }
        Slice_URtoDF_Parity_Prun = new byte[483840];
        i3 = 0;
        while (i3 < 483840) {
            CoordCube.Slice_URtoDF_Parity_Prun[i3] = -1;
            ++i3;
        }
        depth = 0;
        CoordCube.setPruning(Slice_URtoDF_Parity_Prun, 0, 0);
        done = 1;
        while (done != 967680) {
            i = 0;
            while (i < 967680) {
                parity = i % 2;
                int URtoDF = i / 2 / 24;
                slice = i / 2 % 24;
                if (CoordCube.getPruning(Slice_URtoDF_Parity_Prun, i) == depth) {
                    j = 0;
                    while (j < 18) {
                        switch (j) {
                            case 3: 
                            case 5: 
                            case 6: 
                            case 8: 
                            case 12: 
                            case 14: 
                            case 15: 
                            case 17: {
                                break;
                            }
                            default: {
                                newSlice2 = FRtoBR_Move[slice][j];
                                short newURtoDF = URtoDF_Move[URtoDF][j];
                                newParity = parityMove[parity][j];
                                if (CoordCube.getPruning(Slice_URtoDF_Parity_Prun, (24 * newURtoDF + newSlice2) * 2 + newParity) != 15) break;
                                CoordCube.setPruning(Slice_URtoDF_Parity_Prun, (24 * newURtoDF + newSlice2) * 2 + newParity, (byte)(depth + 1));
                                ++done;
                            }
                        }
                        ++j;
                    }
                }
                ++i;
            }
            ++depth;
        }
        Slice_Twist_Prun = new byte[541283];
        i3 = 0;
        while (i3 < 541283) {
            CoordCube.Slice_Twist_Prun[i3] = -1;
            ++i3;
        }
        depth = 0;
        CoordCube.setPruning(Slice_Twist_Prun, 0, 0);
        done = 1;
        while (done != 1082565) {
            i = 0;
            while (i < 1082565) {
                int twist = i / 495;
                slice2 = i % 495;
                if (CoordCube.getPruning(Slice_Twist_Prun, i) == depth) {
                    j2 = 0;
                    while (j2 < 18) {
                        short newTwist = twistMove[twist][j2];
                        newSlice = FRtoBR_Move[slice2 * 24][j2] / 24;
                        if (CoordCube.getPruning(Slice_Twist_Prun, 495 * newTwist + newSlice) == 15) {
                            CoordCube.setPruning(Slice_Twist_Prun, 495 * newTwist + newSlice, (byte)(depth + 1));
                            ++done;
                        }
                        ++j2;
                    }
                }
                ++i;
            }
            ++depth;
        }
        Slice_Flip_Prun = new byte[506880];
        i3 = 0;
        while (i3 < 506880) {
            CoordCube.Slice_Flip_Prun[i3] = -1;
            ++i3;
        }
        depth = 0;
        CoordCube.setPruning(Slice_Flip_Prun, 0, 0);
        done = 1;
        while (done != 1013760) {
            i = 0;
            while (i < 1013760) {
                int flip = i / 495;
                slice2 = i % 495;
                if (CoordCube.getPruning(Slice_Flip_Prun, i) == depth) {
                    j2 = 0;
                    while (j2 < 18) {
                        short newFlip = flipMove[flip][j2];
                        newSlice = FRtoBR_Move[slice2 * 24][j2] / 24;
                        if (CoordCube.getPruning(Slice_Flip_Prun, 495 * newFlip + newSlice) == 15) {
                            CoordCube.setPruning(Slice_Flip_Prun, 495 * newFlip + newSlice, (byte)(depth + 1));
                            ++done;
                        }
                        ++j2;
                    }
                }
                ++i;
            }
            ++depth;
        }
    }

    CoordCube(CubieCube c) {
        this.twist = c.getTwist();
        this.flip = c.getFlip();
        this.parity = c.cornerParity();
        this.FRtoBR = c.getFRtoBR();
        this.URFtoDLF = c.getURFtoDLF();
        this.URtoUL = c.getURtoUL();
        this.UBtoDF = c.getUBtoDF();
        this.URtoDF = c.getURtoDF();
    }

    void move(int m) {
        this.twist = twistMove[this.twist][m];
        this.flip = flipMove[this.flip][m];
        this.parity = parityMove[this.parity][m];
        this.FRtoBR = FRtoBR_Move[this.FRtoBR][m];
        this.URFtoDLF = URFtoDLF_Move[this.URFtoDLF][m];
        this.URtoUL = URtoUL_Move[this.URtoUL][m];
        this.UBtoDF = UBtoDF_Move[this.UBtoDF][m];
        if (this.URtoUL < 336 && this.UBtoDF < 336) {
            this.URtoDF = MergeURtoULandUBtoDF[this.URtoUL][this.UBtoDF];
        }
    }

    static void setPruning(byte[] table, int index, byte value) {
        if ((index & 1) == 0) {
            byte[] arrby = table;
            int n = index / 2;
            arrby[n] = (byte)(arrby[n] & (240 | value));
        } else {
            byte[] arrby = table;
            int n = index / 2;
            arrby[n] = (byte)(arrby[n] & (15 | value << 4));
        }
    }

    static byte getPruning(byte[] table, int index) {
        if ((index & 1) == 0) {
            return (byte)(table[index / 2] & 15);
        }
        return (byte)((table[index / 2] & 240) >>> 4);
    }
}

