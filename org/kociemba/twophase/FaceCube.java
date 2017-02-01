/*
 * Decompiled with CFR 0_118.
 */
package org.kociemba.twophase;

import org.kociemba.twophase.Color;
import org.kociemba.twophase.Corner;
import org.kociemba.twophase.CubieCube;
import org.kociemba.twophase.Edge;
import org.kociemba.twophase.Facelet;

class FaceCube {
    public Color[] f = new Color[54];
    static final Facelet[][] cornerFacelet = new Facelet[][]{{Facelet.U9, Facelet.R1, Facelet.F3}, {Facelet.U7, Facelet.F1, Facelet.L3}, {Facelet.U1, Facelet.L1, Facelet.B3}, {Facelet.U3, Facelet.B1, Facelet.R3}, {Facelet.D3, Facelet.F9, Facelet.R7}, {Facelet.D1, Facelet.L9, Facelet.F7}, {Facelet.D7, Facelet.B9, Facelet.L7}, {Facelet.D9, Facelet.R9, Facelet.B7}};
    static final Facelet[][] edgeFacelet = new Facelet[][]{{Facelet.U6, Facelet.R2}, {Facelet.U8, Facelet.F2}, {Facelet.U4, Facelet.L2}, {Facelet.U2, Facelet.B2}, {Facelet.D6, Facelet.R8}, {Facelet.D2, Facelet.F8}, {Facelet.D4, Facelet.L8}, {Facelet.D8, Facelet.B8}, {Facelet.F6, Facelet.R4}, {Facelet.F4, Facelet.L6}, {Facelet.B6, Facelet.L4}, {Facelet.B4, Facelet.R6}};
    static final Color[][] cornerColor = new Color[][]{{Color.U, Color.R, Color.F}, {Color.U, Color.F, Color.L}, {Color.U, Color.L, Color.B}, {Color.U, Color.B, Color.R}, {Color.D, Color.F, Color.R}, {Color.D, Color.L, Color.F}, {Color.D, Color.B, Color.L}, {Color.D, Color.R, Color.B}};
    static final Color[][] edgeColor = new Color[][]{{Color.U, Color.R}, {Color.U, Color.F}, {Color.U, Color.L}, {Color.U, Color.B}, {Color.D, Color.R}, {Color.D, Color.F}, {Color.D, Color.L}, {Color.D, Color.B}, {Color.F, Color.R}, {Color.F, Color.L}, {Color.B, Color.L}, {Color.B, Color.R}};

    FaceCube() {
        String s = "UUUUUUUUURRRRRRRRRFFFFFFFFFDDDDDDDDDLLLLLLLLLBBBBBBBBB";
        int i = 0;
        while (i < 54) {
            this.f[i] = Color.valueOf(s.substring(i, i + 1));
            ++i;
        }
    }

    FaceCube(String cubeString) {
        int i = 0;
        while (i < cubeString.length()) {
            this.f[i] = Color.valueOf(cubeString.substring(i, i + 1));
            ++i;
        }
    }

    String to_String() {
        String s = "";
        int i = 0;
        while (i < 54) {
            s = String.valueOf(s) + this.f[i].toString();
            ++i;
        }
        return s;
    }

    CubieCube toCubieCube() {
        int n;
        Edge j;
        int n2;
        Edge[] arredge;
        Corner i;
        CubieCube ccRet = new CubieCube();
        int i2 = 0;
        while (i2 < 8) {
            ccRet.cp[i2] = Corner.URF;
            ++i2;
        }
        i2 = 0;
        while (i2 < 12) {
            ccRet.ep[i2] = Edge.UR;
            ++i2;
        }
        Corner[] arrcorner = Corner.values();
        int n3 = arrcorner.length;
        int n4 = 0;
        while (n4 < n3) {
            i = arrcorner[n4];
            int ori = 0;
            while (ori < 3) {
                if (this.f[cornerFacelet[i.ordinal()][ori].ordinal()] == Color.U || this.f[cornerFacelet[i.ordinal()][ori].ordinal()] == Color.D) break;
                ori = (byte)(ori + 1);
            }
            Color col1 = this.f[cornerFacelet[i.ordinal()][(ori + 1) % 3].ordinal()];
            Color col2 = this.f[cornerFacelet[i.ordinal()][(ori + 2) % 3].ordinal()];
            arredge = Corner.values();
            n = arredge.length;
            n2 = 0;
            while (n2 < n) {
                j = arredge[n2];
                if (col1 == cornerColor[j.ordinal()][1] && col2 == cornerColor[j.ordinal()][2]) {
                    ccRet.cp[i.ordinal()] = j;
                    ccRet.co[i.ordinal()] = (byte)(ori % 3);
                    break;
                }
                ++n2;
            }
            ++n4;
        }
        arrcorner = Edge.values();
        n3 = arrcorner.length;
        n4 = 0;
        while (n4 < n3) {
            i = arrcorner[n4];
            arredge = Edge.values();
            n = arredge.length;
            n2 = 0;
            while (n2 < n) {
                j = arredge[n2];
                if (this.f[edgeFacelet[i.ordinal()][0].ordinal()] == edgeColor[j.ordinal()][0] && this.f[edgeFacelet[i.ordinal()][1].ordinal()] == edgeColor[j.ordinal()][1]) {
                    ccRet.ep[i.ordinal()] = j;
                    ccRet.eo[i.ordinal()] = 0;
                    break;
                }
                if (this.f[edgeFacelet[i.ordinal()][0].ordinal()] == edgeColor[j.ordinal()][1] && this.f[edgeFacelet[i.ordinal()][1].ordinal()] == edgeColor[j.ordinal()][0]) {
                    ccRet.ep[i.ordinal()] = j;
                    ccRet.eo[i.ordinal()] = 1;
                    break;
                }
                ++n2;
            }
            ++n4;
        }
        return ccRet;
    }
}

