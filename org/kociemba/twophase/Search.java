/*
 * Decompiled with CFR 0_118.
 */
package org.kociemba.twophase;

import org.kociemba.twophase.Color;
import org.kociemba.twophase.CoordCube;
import org.kociemba.twophase.CubieCube;
import org.kociemba.twophase.FaceCube;

public class Search {
    static int[] ax = new int[31];
    static int[] po = new int[31];
    static int[] flip = new int[31];
    static int[] twist = new int[31];
    static int[] slice = new int[31];
    static int[] parity = new int[31];
    static int[] URFtoDLF = new int[31];
    static int[] FRtoBR = new int[31];
    static int[] URtoUL = new int[31];
    static int[] UBtoDF = new int[31];
    static int[] URtoDF = new int[31];
    static int[] minDistPhase1 = new int[31];
    static int[] minDistPhase2 = new int[31];

    static String solutionToString(int length) {
        String s = "";
        int i = 0;
        while (i < length) {
            switch (ax[i]) {
                case 0: {
                    s = String.valueOf(s) + "U";
                    break;
                }
                case 1: {
                    s = String.valueOf(s) + "R";
                    break;
                }
                case 2: {
                    s = String.valueOf(s) + "F";
                    break;
                }
                case 3: {
                    s = String.valueOf(s) + "D";
                    break;
                }
                case 4: {
                    s = String.valueOf(s) + "L";
                    break;
                }
                case 5: {
                    s = String.valueOf(s) + "B";
                }
            }
            switch (po[i]) {
                case 1: {
                    s = String.valueOf(s) + " ";
                    break;
                }
                case 2: {
                    s = String.valueOf(s) + "2 ";
                    break;
                }
                case 3: {
                    s = String.valueOf(s) + "' ";
                }
            }
            ++i;
        }
        return s;
    }

    static String solutionToString(int length, int depthPhase1) {
        String s = "";
        int i = 0;
        while (i < length) {
            switch (ax[i]) {
                case 0: {
                    s = String.valueOf(s) + "U";
                    break;
                }
                case 1: {
                    s = String.valueOf(s) + "R";
                    break;
                }
                case 2: {
                    s = String.valueOf(s) + "F";
                    break;
                }
                case 3: {
                    s = String.valueOf(s) + "D";
                    break;
                }
                case 4: {
                    s = String.valueOf(s) + "L";
                    break;
                }
                case 5: {
                    s = String.valueOf(s) + "B";
                }
            }
            switch (po[i]) {
                case 1: {
                    s = String.valueOf(s) + " ";
                    break;
                }
                case 2: {
                    s = String.valueOf(s) + "2 ";
                    break;
                }
                case 3: {
                    s = String.valueOf(s) + "' ";
                }
            }
            if (i == depthPhase1 - 1) {
                s = String.valueOf(s) + ". ";
            }
            ++i;
        }
        return s;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public static String solution(String facelets, int maxDepth, long timeOut, boolean useSeparator) {
        count = new int[6];
        try {
            for (i = 0; i < 54; ++i) {
                v0 = count;
                v1 = Color.valueOf(facelets.substring(i, i + 1)).ordinal();
                v0[v1] = v0[v1] + 1;
            }
        }
        catch (Exception e) {
            return "Error 1";
        }
        i = 0;
        while (i < 6) {
            if (count[i] != 9) {
                return "Error 1";
            }
            ++i;
        }
        fc = new FaceCube(facelets);
        cc = fc.toCubieCube();
        s = cc.verify();
        if (s != 0) {
            return "Error " + Math.abs(s);
        }
        c = new CoordCube(cc);
        Search.po[0] = 0;
        Search.ax[0] = 0;
        Search.flip[0] = c.flip;
        Search.twist[0] = c.twist;
        Search.parity[0] = c.parity;
        Search.slice[0] = c.FRtoBR / 24;
        Search.URFtoDLF[0] = c.URFtoDLF;
        Search.FRtoBR[0] = c.FRtoBR;
        Search.URtoUL[0] = c.URtoUL;
        Search.UBtoDF[0] = c.UBtoDF;
        Search.minDistPhase1[1] = 1;
        mv = 0;
        n = 0;
        busy = false;
        depthPhase1 = 1;
        tStart = System.currentTimeMillis();
        do lbl-1000: // 4 sources:
        {
            block17 : {
                if (depthPhase1 - n > Search.minDistPhase1[n + 1] && !busy) {
                    Search.ax[++n] = Search.ax[n] == 0 || Search.ax[n] == 3 ? 1 : 0;
                    Search.po[n] = 1;
                } else {
                    Search.po[n] = Search.po[n] + 1;
                    if (Search.po[n] <= 3) {
                        busy = false;
                    } else {
                        do {
                            if ((Search.ax[n] = Search.ax[n] + 1) > 5) {
                                if (System.currentTimeMillis() - tStart > timeOut << 10) {
                                    return "Error 8";
                                }
                                if (n == 0) {
                                    if (depthPhase1 >= maxDepth) {
                                        return "Error 7";
                                    }
                                    ++depthPhase1;
                                    Search.ax[n] = 0;
                                    Search.po[n] = 1;
                                    busy = false;
                                    break;
                                }
                                --n;
                                busy = true;
                                break;
                            }
                            Search.po[n] = 1;
                            busy = false;
                            if (n == 0) break block17;
                        } while (Search.ax[n - 1] == Search.ax[n] || Search.ax[n - 1] - 3 == Search.ax[n]);
                    }
                }
                if (busy) ** GOTO lbl-1000
            }
            mv = 3 * Search.ax[n] + Search.po[n] - 1;
            Search.flip[n + 1] = CoordCube.flipMove[Search.flip[n]][mv];
            Search.twist[n + 1] = CoordCube.twistMove[Search.twist[n]][mv];
            Search.slice[n + 1] = CoordCube.FRtoBR_Move[Search.slice[n] * 24][mv] / 24;
            Search.minDistPhase1[n + 1] = Math.max(CoordCube.getPruning(CoordCube.Slice_Flip_Prun, 495 * Search.flip[n + 1] + Search.slice[n + 1]), CoordCube.getPruning(CoordCube.Slice_Twist_Prun, 495 * Search.twist[n + 1] + Search.slice[n + 1]));
            if (Search.minDistPhase1[n + 1] != 0 || n < depthPhase1 - 5) ** GOTO lbl-1000
            Search.minDistPhase1[n + 1] = 10;
        } while (n != depthPhase1 - 1 || (s = Search.totalDepth(depthPhase1, maxDepth)) < 0 || s != depthPhase1 && (Search.ax[depthPhase1 - 1] == Search.ax[depthPhase1] || Search.ax[depthPhase1 - 1] == Search.ax[depthPhase1] + 3));
        if (useSeparator) {
            v2 = Search.solutionToString(s, depthPhase1);
            return v2;
        }
        v2 = Search.solutionToString(s);
        return v2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    static int totalDepth(int depthPhase1, int maxDepth) {
        mv = 0;
        d1 = 0;
        d2 = 0;
        maxDepthPhase2 = Math.min(10, maxDepth - depthPhase1);
        i = 0;
        while (i < depthPhase1) {
            mv = 3 * Search.ax[i] + Search.po[i] - 1;
            Search.URFtoDLF[i + 1] = CoordCube.URFtoDLF_Move[Search.URFtoDLF[i]][mv];
            Search.FRtoBR[i + 1] = CoordCube.FRtoBR_Move[Search.FRtoBR[i]][mv];
            Search.parity[i + 1] = CoordCube.parityMove[Search.parity[i]][mv];
            ++i;
        }
        d1 = CoordCube.getPruning(CoordCube.Slice_URFtoDLF_Parity_Prun, (24 * Search.URFtoDLF[depthPhase1] + Search.FRtoBR[depthPhase1]) * 2 + Search.parity[depthPhase1]);
        if (d1 > maxDepthPhase2) {
            return -1;
        }
        i = 0;
        while (i < depthPhase1) {
            mv = 3 * Search.ax[i] + Search.po[i] - 1;
            Search.URtoUL[i + 1] = CoordCube.URtoUL_Move[Search.URtoUL[i]][mv];
            Search.UBtoDF[i + 1] = CoordCube.UBtoDF_Move[Search.UBtoDF[i]][mv];
            ++i;
        }
        Search.URtoDF[depthPhase1] = CoordCube.MergeURtoULandUBtoDF[Search.URtoUL[depthPhase1]][Search.UBtoDF[depthPhase1]];
        d2 = CoordCube.getPruning(CoordCube.Slice_URtoDF_Parity_Prun, (24 * Search.URtoDF[depthPhase1] + Search.FRtoBR[depthPhase1]) * 2 + Search.parity[depthPhase1]);
        if (d2 > maxDepthPhase2) {
            return -1;
        }
        Search.minDistPhase2[depthPhase1] = Math.max(d1, d2);
        if (Search.minDistPhase2[depthPhase1] == 0) {
            return depthPhase1;
        }
        depthPhase2 = 1;
        n = depthPhase1;
        busy = false;
        Search.po[depthPhase1] = 0;
        Search.ax[depthPhase1] = 0;
        Search.minDistPhase2[n + 1] = 1;
        do lbl-1000: // 3 sources:
        {
            block14 : {
                if (depthPhase1 + depthPhase2 - n <= Search.minDistPhase2[n + 1] || busy) ** GOTO lbl45
                if (Search.ax[n] == 0 || Search.ax[n] == 3) {
                    Search.ax[++n] = 1;
                    Search.po[n] = 2;
                } else {
                    Search.ax[++n] = 0;
                    Search.po[n] = 1;
                }
                ** GOTO lbl70
lbl45: // 1 sources:
                if (Search.ax[n] != 0 && Search.ax[n] != 3) ** GOTO lbl49
                Search.po[n] = Search.po[n] + 1;
                if (Search.po[n] <= 3) ** GOTO lbl-1000
                ** GOTO lbl-1000
lbl49: // 1 sources:
                Search.po[n] = Search.po[n] + 2;
                if (Search.po[n] <= 3) lbl-1000: // 2 sources:
                {
                    busy = false;
                } else lbl-1000: // 2 sources:
                {
                    do {
                        if ((Search.ax[n] = Search.ax[n] + 1) > 5) {
                            if (n == depthPhase1) {
                                if (depthPhase2 >= maxDepthPhase2) {
                                    return -1;
                                }
                                ++depthPhase2;
                                Search.ax[n] = 0;
                                Search.po[n] = 1;
                                busy = false;
                                break;
                            }
                            --n;
                            busy = true;
                            break;
                        }
                        Search.po[n] = Search.ax[n] == 0 || Search.ax[n] == 3 ? 1 : 2;
                        busy = false;
                        if (n == depthPhase1) break block14;
                    } while (Search.ax[n - 1] == Search.ax[n] || Search.ax[n - 1] - 3 == Search.ax[n]);
                }
lbl70: // 6 sources:
                if (busy) ** GOTO lbl-1000
            }
            mv = 3 * Search.ax[n] + Search.po[n] - 1;
            Search.URFtoDLF[n + 1] = CoordCube.URFtoDLF_Move[Search.URFtoDLF[n]][mv];
            Search.FRtoBR[n + 1] = CoordCube.FRtoBR_Move[Search.FRtoBR[n]][mv];
            Search.parity[n + 1] = CoordCube.parityMove[Search.parity[n]][mv];
            Search.URtoDF[n + 1] = CoordCube.URtoDF_Move[Search.URtoDF[n]][mv];
            Search.minDistPhase2[n + 1] = Math.max(CoordCube.getPruning(CoordCube.Slice_URtoDF_Parity_Prun, (24 * Search.URtoDF[n + 1] + Search.FRtoBR[n + 1]) * 2 + Search.parity[n + 1]), CoordCube.getPruning(CoordCube.Slice_URFtoDLF_Parity_Prun, (24 * Search.URFtoDLF[n + 1] + Search.FRtoBR[n + 1]) * 2 + Search.parity[n + 1]));
        } while (Search.minDistPhase2[n + 1] != 0);
        return depthPhase1 + depthPhase2;
    }
}

