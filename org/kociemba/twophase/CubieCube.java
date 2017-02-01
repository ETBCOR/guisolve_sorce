/*
 * Decompiled with CFR 0_118.
 */
package org.kociemba.twophase;

import org.kociemba.twophase.Color;
import org.kociemba.twophase.Corner;
import org.kociemba.twophase.Edge;
import org.kociemba.twophase.FaceCube;
import org.kociemba.twophase.Facelet;

class CubieCube {
    Corner[] cp = new Corner[]{Corner.URF, Corner.UFL, Corner.ULB, Corner.UBR, Corner.DFR, Corner.DLF, Corner.DBL, Corner.DRB};
    byte[] co = new byte[8];
    Edge[] ep = new Edge[]{Edge.UR, Edge.UF, Edge.UL, Edge.UB, Edge.DR, Edge.DF, Edge.DL, Edge.DB, Edge.FR, Edge.FL, Edge.BL, Edge.BR};
    byte[] eo = new byte[12];
    private static Corner[] cpU = new Corner[]{Corner.UBR, Corner.URF, Corner.UFL, Corner.ULB, Corner.DFR, Corner.DLF, Corner.DBL, Corner.DRB};
    private static byte[] coU = new byte[8];
    private static Edge[] epU = new Edge[]{Edge.UB, Edge.UR, Edge.UF, Edge.UL, Edge.DR, Edge.DF, Edge.DL, Edge.DB, Edge.FR, Edge.FL, Edge.BL, Edge.BR};
    private static byte[] eoU = new byte[12];
    private static Corner[] cpR = new Corner[]{Corner.DFR, Corner.UFL, Corner.ULB, Corner.URF, Corner.DRB, Corner.DLF, Corner.DBL, Corner.UBR};
    private static byte[] coR;
    private static Edge[] epR;
    private static byte[] eoR;
    private static Corner[] cpF;
    private static byte[] coF;
    private static Edge[] epF;
    private static byte[] eoF;
    private static Corner[] cpD;
    private static byte[] coD;
    private static Edge[] epD;
    private static byte[] eoD;
    private static Corner[] cpL;
    private static byte[] coL;
    private static Edge[] epL;
    private static byte[] eoL;
    private static Corner[] cpB;
    private static byte[] coB;
    private static Edge[] epB;
    private static byte[] eoB;
    static CubieCube[] moveCube;

    static {
        byte[] arrby = new byte[8];
        arrby[0] = 2;
        arrby[3] = 1;
        arrby[4] = 1;
        arrby[7] = 2;
        coR = arrby;
        epR = new Edge[]{Edge.FR, Edge.UF, Edge.UL, Edge.UB, Edge.BR, Edge.DF, Edge.DL, Edge.DB, Edge.DR, Edge.FL, Edge.BL, Edge.UR};
        eoR = new byte[12];
        cpF = new Corner[]{Corner.UFL, Corner.DLF, Corner.ULB, Corner.UBR, Corner.URF, Corner.DFR, Corner.DBL, Corner.DRB};
        byte[] arrby2 = new byte[8];
        arrby2[0] = 1;
        arrby2[1] = 2;
        arrby2[4] = 2;
        arrby2[5] = 1;
        coF = arrby2;
        epF = new Edge[]{Edge.UR, Edge.FL, Edge.UL, Edge.UB, Edge.DR, Edge.FR, Edge.DL, Edge.DB, Edge.UF, Edge.DF, Edge.BL, Edge.BR};
        byte[] arrby3 = new byte[12];
        arrby3[1] = 1;
        arrby3[5] = 1;
        arrby3[8] = 1;
        arrby3[9] = 1;
        eoF = arrby3;
        cpD = new Corner[]{Corner.URF, Corner.UFL, Corner.ULB, Corner.UBR, Corner.DLF, Corner.DBL, Corner.DRB, Corner.DFR};
        coD = new byte[8];
        epD = new Edge[]{Edge.UR, Edge.UF, Edge.UL, Edge.UB, Edge.DF, Edge.DL, Edge.DB, Edge.DR, Edge.FR, Edge.FL, Edge.BL, Edge.BR};
        eoD = new byte[12];
        cpL = new Corner[]{Corner.URF, Corner.ULB, Corner.DBL, Corner.UBR, Corner.DFR, Corner.UFL, Corner.DLF, Corner.DRB};
        byte[] arrby4 = new byte[8];
        arrby4[1] = 1;
        arrby4[2] = 2;
        arrby4[5] = 2;
        arrby4[6] = 1;
        coL = arrby4;
        epL = new Edge[]{Edge.UR, Edge.UF, Edge.BL, Edge.UB, Edge.DR, Edge.DF, Edge.FL, Edge.DB, Edge.FR, Edge.UL, Edge.DL, Edge.BR};
        eoL = new byte[12];
        cpB = new Corner[]{Corner.URF, Corner.UFL, Corner.UBR, Corner.DRB, Corner.DFR, Corner.DLF, Corner.ULB, Corner.DBL};
        byte[] arrby5 = new byte[8];
        arrby5[2] = 1;
        arrby5[3] = 2;
        arrby5[6] = 2;
        arrby5[7] = 1;
        coB = arrby5;
        epB = new Edge[]{Edge.UR, Edge.UF, Edge.UL, Edge.BR, Edge.DR, Edge.DF, Edge.DL, Edge.BL, Edge.FR, Edge.FL, Edge.UB, Edge.DB};
        byte[] arrby6 = new byte[12];
        arrby6[3] = 1;
        arrby6[7] = 1;
        arrby6[10] = 1;
        arrby6[11] = 1;
        eoB = arrby6;
        moveCube = new CubieCube[6];
        CubieCube.moveCube[0] = new CubieCube();
        CubieCube.moveCube[0].cp = cpU;
        CubieCube.moveCube[0].co = coU;
        CubieCube.moveCube[0].ep = epU;
        CubieCube.moveCube[0].eo = eoU;
        CubieCube.moveCube[1] = new CubieCube();
        CubieCube.moveCube[1].cp = cpR;
        CubieCube.moveCube[1].co = coR;
        CubieCube.moveCube[1].ep = epR;
        CubieCube.moveCube[1].eo = eoR;
        CubieCube.moveCube[2] = new CubieCube();
        CubieCube.moveCube[2].cp = cpF;
        CubieCube.moveCube[2].co = coF;
        CubieCube.moveCube[2].ep = epF;
        CubieCube.moveCube[2].eo = eoF;
        CubieCube.moveCube[3] = new CubieCube();
        CubieCube.moveCube[3].cp = cpD;
        CubieCube.moveCube[3].co = coD;
        CubieCube.moveCube[3].ep = epD;
        CubieCube.moveCube[3].eo = eoD;
        CubieCube.moveCube[4] = new CubieCube();
        CubieCube.moveCube[4].cp = cpL;
        CubieCube.moveCube[4].co = coL;
        CubieCube.moveCube[4].ep = epL;
        CubieCube.moveCube[4].eo = eoL;
        CubieCube.moveCube[5] = new CubieCube();
        CubieCube.moveCube[5].cp = cpB;
        CubieCube.moveCube[5].co = coB;
        CubieCube.moveCube[5].ep = epB;
        CubieCube.moveCube[5].eo = eoB;
    }

    CubieCube() {
    }

    CubieCube(Corner[] cp, byte[] co, Edge[] ep, byte[] eo) {
        this();
        int i = 0;
        while (i < 8) {
            this.cp[i] = cp[i];
            this.co[i] = co[i];
            ++i;
        }
        i = 0;
        while (i < 12) {
            this.ep[i] = ep[i];
            this.eo[i] = eo[i];
            ++i;
        }
    }

    static int Cnk(int n, int k) {
        if (n < k) {
            return 0;
        }
        if (k > n / 2) {
            k = n - k;
        }
        int s = 1;
        int i = n;
        int j = 1;
        while (i != n - k) {
            s *= i;
            s /= j;
            --i;
            ++j;
        }
        return s;
    }

    static void rotateLeft(Corner[] arr, int l, int r) {
        Corner temp = arr[l];
        int i = l;
        while (i < r) {
            arr[i] = arr[i + 1];
            ++i;
        }
        arr[r] = temp;
    }

    static void rotateRight(Corner[] arr, int l, int r) {
        Corner temp = arr[r];
        int i = r;
        while (i > l) {
            arr[i] = arr[i - 1];
            --i;
        }
        arr[l] = temp;
    }

    static void rotateLeft(Edge[] arr, int l, int r) {
        Edge temp = arr[l];
        int i = l;
        while (i < r) {
            arr[i] = arr[i + 1];
            ++i;
        }
        arr[r] = temp;
    }

    static void rotateRight(Edge[] arr, int l, int r) {
        Edge temp = arr[r];
        int i = r;
        while (i > l) {
            arr[i] = arr[i - 1];
            --i;
        }
        arr[l] = temp;
    }

    FaceCube toFaceCube() {
        int n;
        int j;
        byte ori;
        int i;
        FaceCube fcRet = new FaceCube();
        Corner[] arrcorner = Corner.values();
        int n2 = arrcorner.length;
        int n3 = 0;
        while (n3 < n2) {
            Corner c = arrcorner[n3];
            i = c.ordinal();
            j = this.cp[i].ordinal();
            ori = this.co[i];
            n = 0;
            while (n < 3) {
                fcRet.f[FaceCube.cornerFacelet[i][(n + ori) % 3].ordinal()] = FaceCube.cornerColor[j][n];
                ++n;
            }
            ++n3;
        }
        arrcorner = Edge.values();
        n2 = arrcorner.length;
        n3 = 0;
        while (n3 < n2) {
            Corner e = arrcorner[n3];
            i = e.ordinal();
            j = this.ep[i].ordinal();
            ori = this.eo[i];
            n = 0;
            while (n < 2) {
                fcRet.f[FaceCube.edgeFacelet[i][(n + ori) % 2].ordinal()] = FaceCube.edgeColor[j][n];
                ++n;
            }
            ++n3;
        }
        return fcRet;
    }

    void cornerMultiply(CubieCube b) {
        Corner[] cPerm = new Corner[8];
        byte[] cOri = new byte[8];
        Corner[] arrcorner = Corner.values();
        int n = arrcorner.length;
        int n2 = 0;
        while (n2 < n) {
            Corner corn = arrcorner[n2];
            cPerm[corn.ordinal()] = this.cp[b.cp[corn.ordinal()].ordinal()];
            byte oriA = this.co[b.cp[corn.ordinal()].ordinal()];
            byte oriB = b.co[corn.ordinal()];
            byte ori = 0;
            if (oriA < 3 && oriB < 3) {
                ori = (byte)(oriA + oriB);
                if (ori >= 3) {
                    ori = (byte)(ori - 3);
                }
            } else if (oriA < 3 && oriB >= 3) {
                ori = (byte)(oriA + oriB);
                if (ori >= 6) {
                    ori = (byte)(ori - 3);
                }
            } else if (oriA >= 3 && oriB < 3) {
                ori = (byte)(oriA - oriB);
                if (ori < 3) {
                    ori = (byte)(ori + 3);
                }
            } else if (oriA >= 3 && oriB >= 3 && (ori = (byte)(oriA - oriB)) < 0) {
                ori = (byte)(ori + 3);
            }
            cOri[corn.ordinal()] = ori;
            ++n2;
        }
        arrcorner = Corner.values();
        n = arrcorner.length;
        n2 = 0;
        while (n2 < n) {
            Corner c = arrcorner[n2];
            this.cp[c.ordinal()] = cPerm[c.ordinal()];
            this.co[c.ordinal()] = cOri[c.ordinal()];
            ++n2;
        }
    }

    void edgeMultiply(CubieCube b) {
        Edge[] ePerm = new Edge[12];
        byte[] eOri = new byte[12];
        Edge[] arredge = Edge.values();
        int n = arredge.length;
        int n2 = 0;
        while (n2 < n) {
            Edge edge = arredge[n2];
            ePerm[edge.ordinal()] = this.ep[b.ep[edge.ordinal()].ordinal()];
            eOri[edge.ordinal()] = (byte)((b.eo[edge.ordinal()] + this.eo[b.ep[edge.ordinal()].ordinal()]) % 2);
            ++n2;
        }
        arredge = Edge.values();
        n = arredge.length;
        n2 = 0;
        while (n2 < n) {
            Edge e = arredge[n2];
            this.ep[e.ordinal()] = ePerm[e.ordinal()];
            this.eo[e.ordinal()] = eOri[e.ordinal()];
            ++n2;
        }
    }

    void multiply(CubieCube b) {
        this.cornerMultiply(b);
    }

    void invCubieCube(CubieCube c) {
        Edge corn;
        Edge edge;
        Edge[] arredge = Edge.values();
        int n = arredge.length;
        int n2 = 0;
        while (n2 < n) {
            c.ep[this.ep[edge.ordinal()].ordinal()] = edge = arredge[n2];
            ++n2;
        }
        arredge = Edge.values();
        n = arredge.length;
        n2 = 0;
        while (n2 < n) {
            edge = arredge[n2];
            c.eo[edge.ordinal()] = this.eo[c.ep[edge.ordinal()].ordinal()];
            ++n2;
        }
        arredge = Corner.values();
        n = arredge.length;
        n2 = 0;
        while (n2 < n) {
            corn = arredge[n2];
            c.cp[this.cp[corn.ordinal()].ordinal()] = corn;
            ++n2;
        }
        arredge = Corner.values();
        n = arredge.length;
        n2 = 0;
        while (n2 < n) {
            corn = arredge[n2];
            byte ori = this.co[c.cp[corn.ordinal()].ordinal()];
            if (ori >= 3) {
                c.co[corn.ordinal()] = ori;
            } else {
                c.co[corn.ordinal()] = - ori;
                if (c.co[corn.ordinal()] < 0) {
                    byte[] arrby = c.co;
                    int n3 = corn.ordinal();
                    arrby[n3] = (byte)(arrby[n3] + 3);
                }
            }
            ++n2;
        }
    }

    short getTwist() {
        short ret = 0;
        int i = Corner.URF.ordinal();
        while (i < Corner.DRB.ordinal()) {
            ret = (short)(3 * ret + this.co[i]);
            ++i;
        }
        return ret;
    }

    void setTwist(short twist) {
        int twistParity = 0;
        int i = Corner.DRB.ordinal() - 1;
        while (i >= Corner.URF.ordinal()) {
            this.co[i] = (byte)(twist % 3);
            twistParity += this.co[i];
            twist = (short)(twist / 3);
            --i;
        }
        this.co[Corner.DRB.ordinal()] = (byte)((3 - twistParity % 3) % 3);
    }

    short getFlip() {
        short ret = 0;
        int i = Edge.UR.ordinal();
        while (i < Edge.BR.ordinal()) {
            ret = (short)(2 * ret + this.eo[i]);
            ++i;
        }
        return ret;
    }

    void setFlip(short flip) {
        int flipParity = 0;
        int i = Edge.BR.ordinal() - 1;
        while (i >= Edge.UR.ordinal()) {
            this.eo[i] = (byte)(flip % 2);
            flipParity += this.eo[i];
            flip = (short)(flip / 2);
            --i;
        }
        this.eo[Edge.BR.ordinal()] = (byte)((2 - flipParity % 2) % 2);
    }

    short cornerParity() {
        int s = 0;
        int i = Corner.DRB.ordinal();
        while (i >= Corner.URF.ordinal() + 1) {
            int j = i - 1;
            while (j >= Corner.URF.ordinal()) {
                if (this.cp[j].ordinal() > this.cp[i].ordinal()) {
                    ++s;
                }
                --j;
            }
            --i;
        }
        return (short)(s % 2);
    }

    short edgeParity() {
        int s = 0;
        int i = Edge.BR.ordinal();
        while (i >= Edge.UR.ordinal() + 1) {
            int j = i - 1;
            while (j >= Edge.UR.ordinal()) {
                if (this.ep[j].ordinal() > this.ep[i].ordinal()) {
                    ++s;
                }
                --j;
            }
            --i;
        }
        return (short)(s % 2);
    }

    short getFRtoBR() {
        int a = 0;
        int x = 0;
        Edge[] edge4 = new Edge[4];
        int j = Edge.BR.ordinal();
        while (j >= Edge.UR.ordinal()) {
            if (Edge.FR.ordinal() <= this.ep[j].ordinal() && this.ep[j].ordinal() <= Edge.BR.ordinal()) {
                a += CubieCube.Cnk(11 - j, x + 1);
                edge4[3 - x++] = this.ep[j];
            }
            --j;
        }
        int b = 0;
        int j2 = 3;
        while (j2 > 0) {
            int k = 0;
            while (edge4[j2].ordinal() != j2 + 8) {
                CubieCube.rotateLeft(edge4, 0, j2);
                ++k;
            }
            b = (j2 + 1) * b + k;
            --j2;
        }
        return (short)(24 * a + b);
    }

    void setFRtoBR(short idx) {
        Edge[] sliceEdge = new Edge[]{Edge.FR, Edge.FL, Edge.BL, Edge.BR};
        Edge[] otherEdge = new Edge[]{Edge.UR, Edge.UF, Edge.UL, Edge.UB, Edge.DR, Edge.DF, Edge.DL, Edge.DB};
        int b = idx % 24;
        int a = idx / 24;
        Edge[] arredge = Edge.values();
        int n = arredge.length;
        int n2 = 0;
        while (n2 < n) {
            Edge e = arredge[n2];
            this.ep[e.ordinal()] = Edge.DB;
            ++n2;
        }
        int j = 1;
        while (j < 4) {
            int k = b % (j + 1);
            b /= j + 1;
            while (k-- > 0) {
                CubieCube.rotateRight(sliceEdge, 0, j);
            }
            ++j;
        }
        int x = 3;
        j = Edge.UR.ordinal();
        while (j <= Edge.BR.ordinal()) {
            if (a - CubieCube.Cnk(11 - j, x + 1) >= 0) {
                this.ep[j] = sliceEdge[3 - x];
                a -= CubieCube.Cnk(11 - j, x-- + 1);
            }
            ++j;
        }
        x = 0;
        j = Edge.UR.ordinal();
        while (j <= Edge.BR.ordinal()) {
            if (this.ep[j] == Edge.DB) {
                this.ep[j] = otherEdge[x++];
            }
            ++j;
        }
    }

    short getURFtoDLF() {
        int a = 0;
        int x = 0;
        Corner[] corner6 = new Corner[6];
        int j = Corner.URF.ordinal();
        while (j <= Corner.DRB.ordinal()) {
            if (this.cp[j].ordinal() <= Corner.DLF.ordinal()) {
                a += CubieCube.Cnk(j, x + 1);
                corner6[x++] = this.cp[j];
            }
            ++j;
        }
        int b = 0;
        int j2 = 5;
        while (j2 > 0) {
            int k = 0;
            while (corner6[j2].ordinal() != j2) {
                CubieCube.rotateLeft(corner6, 0, j2);
                ++k;
            }
            b = (j2 + 1) * b + k;
            --j2;
        }
        return (short)(720 * a + b);
    }

    void setURFtoDLF(short idx) {
        Corner[] corner6 = new Corner[]{Corner.URF, Corner.UFL, Corner.ULB, Corner.UBR, Corner.DFR, Corner.DLF};
        Corner[] otherCorner = new Corner[]{Corner.DBL, Corner.DRB};
        int b = idx % 720;
        int a = idx / 720;
        Corner[] arrcorner = Corner.values();
        int n = arrcorner.length;
        int n2 = 0;
        while (n2 < n) {
            Corner c = arrcorner[n2];
            this.cp[c.ordinal()] = Corner.DRB;
            ++n2;
        }
        int j = 1;
        while (j < 6) {
            int k = b % (j + 1);
            b /= j + 1;
            while (k-- > 0) {
                CubieCube.rotateRight(corner6, 0, j);
            }
            ++j;
        }
        int x = 5;
        j = Corner.DRB.ordinal();
        while (j >= 0) {
            if (a - CubieCube.Cnk(j, x + 1) >= 0) {
                this.cp[j] = corner6[x];
                a -= CubieCube.Cnk(j, x-- + 1);
            }
            --j;
        }
        x = 0;
        j = Corner.URF.ordinal();
        while (j <= Corner.DRB.ordinal()) {
            if (this.cp[j] == Corner.DRB) {
                this.cp[j] = otherCorner[x++];
            }
            ++j;
        }
    }

    int getURtoDF() {
        int a = 0;
        int x = 0;
        Edge[] edge6 = new Edge[6];
        int j = Edge.UR.ordinal();
        while (j <= Edge.BR.ordinal()) {
            if (this.ep[j].ordinal() <= Edge.DF.ordinal()) {
                a += CubieCube.Cnk(j, x + 1);
                edge6[x++] = this.ep[j];
            }
            ++j;
        }
        int b = 0;
        int j2 = 5;
        while (j2 > 0) {
            int k = 0;
            while (edge6[j2].ordinal() != j2) {
                CubieCube.rotateLeft(edge6, 0, j2);
                ++k;
            }
            b = (j2 + 1) * b + k;
            --j2;
        }
        return 720 * a + b;
    }

    void setURtoDF(int idx) {
        Edge[] edge6 = new Edge[]{Edge.UR, Edge.UF, Edge.UL, Edge.UB, Edge.DR, Edge.DF};
        Edge[] otherEdge = new Edge[]{Edge.DL, Edge.DB, Edge.FR, Edge.FL, Edge.BL, Edge.BR};
        int b = idx % 720;
        int a = idx / 720;
        Edge[] arredge = Edge.values();
        int n = arredge.length;
        int n2 = 0;
        while (n2 < n) {
            Edge e = arredge[n2];
            this.ep[e.ordinal()] = Edge.BR;
            ++n2;
        }
        int j = 1;
        while (j < 6) {
            int k = b % (j + 1);
            b /= j + 1;
            while (k-- > 0) {
                CubieCube.rotateRight(edge6, 0, j);
            }
            ++j;
        }
        int x = 5;
        j = Edge.BR.ordinal();
        while (j >= 0) {
            if (a - CubieCube.Cnk(j, x + 1) >= 0) {
                this.ep[j] = edge6[x];
                a -= CubieCube.Cnk(j, x-- + 1);
            }
            --j;
        }
        x = 0;
        j = Edge.UR.ordinal();
        while (j <= Edge.BR.ordinal()) {
            if (this.ep[j] == Edge.BR) {
                this.ep[j] = otherEdge[x++];
            }
            ++j;
        }
    }

    public static int getURtoDF(short idx1, short idx2) {
        CubieCube a = new CubieCube();
        CubieCube b = new CubieCube();
        a.setURtoUL(idx1);
        b.setUBtoDF(idx2);
        int i = 0;
        while (i < 8) {
            if (a.ep[i] != Edge.BR) {
                if (b.ep[i] != Edge.BR) {
                    return -1;
                }
                b.ep[i] = a.ep[i];
            }
            ++i;
        }
        return b.getURtoDF();
    }

    short getURtoUL() {
        int a = 0;
        int x = 0;
        Edge[] edge3 = new Edge[3];
        int j = Edge.UR.ordinal();
        while (j <= Edge.BR.ordinal()) {
            if (this.ep[j].ordinal() <= Edge.UL.ordinal()) {
                a += CubieCube.Cnk(j, x + 1);
                edge3[x++] = this.ep[j];
            }
            ++j;
        }
        int b = 0;
        int j2 = 2;
        while (j2 > 0) {
            int k = 0;
            while (edge3[j2].ordinal() != j2) {
                CubieCube.rotateLeft(edge3, 0, j2);
                ++k;
            }
            b = (j2 + 1) * b + k;
            --j2;
        }
        return (short)(6 * a + b);
    }

    void setURtoUL(short idx) {
        Edge[] edge3 = new Edge[]{Edge.UR, Edge.UF, Edge.UL};
        int b = idx % 6;
        int a = idx / 6;
        Edge[] arredge = Edge.values();
        int n = arredge.length;
        int n2 = 0;
        while (n2 < n) {
            Edge e = arredge[n2];
            this.ep[e.ordinal()] = Edge.BR;
            ++n2;
        }
        int j = 1;
        while (j < 3) {
            int k = b % (j + 1);
            b /= j + 1;
            while (k-- > 0) {
                CubieCube.rotateRight(edge3, 0, j);
            }
            ++j;
        }
        int x = 2;
        j = Edge.BR.ordinal();
        while (j >= 0) {
            if (a - CubieCube.Cnk(j, x + 1) >= 0) {
                this.ep[j] = edge3[x];
                a -= CubieCube.Cnk(j, x-- + 1);
            }
            --j;
        }
    }

    short getUBtoDF() {
        int a = 0;
        int x = 0;
        Edge[] edge3 = new Edge[3];
        int j = Edge.UR.ordinal();
        while (j <= Edge.BR.ordinal()) {
            if (Edge.UB.ordinal() <= this.ep[j].ordinal() && this.ep[j].ordinal() <= Edge.DF.ordinal()) {
                a += CubieCube.Cnk(j, x + 1);
                edge3[x++] = this.ep[j];
            }
            ++j;
        }
        int b = 0;
        int j2 = 2;
        while (j2 > 0) {
            int k = 0;
            while (edge3[j2].ordinal() != Edge.UB.ordinal() + j2) {
                CubieCube.rotateLeft(edge3, 0, j2);
                ++k;
            }
            b = (j2 + 1) * b + k;
            --j2;
        }
        return (short)(6 * a + b);
    }

    void setUBtoDF(short idx) {
        Edge[] edge3 = new Edge[]{Edge.UB, Edge.DR, Edge.DF};
        int b = idx % 6;
        int a = idx / 6;
        Edge[] arredge = Edge.values();
        int n = arredge.length;
        int n2 = 0;
        while (n2 < n) {
            Edge e = arredge[n2];
            this.ep[e.ordinal()] = Edge.BR;
            ++n2;
        }
        int j = 1;
        while (j < 3) {
            int k = b % (j + 1);
            b /= j + 1;
            while (k-- > 0) {
                CubieCube.rotateRight(edge3, 0, j);
            }
            ++j;
        }
        int x = 2;
        j = Edge.BR.ordinal();
        while (j >= 0) {
            if (a - CubieCube.Cnk(j, x + 1) >= 0) {
                this.ep[j] = edge3[x];
                a -= CubieCube.Cnk(j, x-- + 1);
            }
            --j;
        }
    }

    int getURFtoDLB() {
        Corner[] perm = new Corner[8];
        int b = 0;
        int i = 0;
        while (i < 8) {
            perm[i] = this.cp[i];
            ++i;
        }
        int j = 7;
        while (j > 0) {
            int k = 0;
            while (perm[j].ordinal() != j) {
                CubieCube.rotateLeft(perm, 0, j);
                ++k;
            }
            b = (j + 1) * b + k;
            --j;
        }
        return b;
    }

    void setURFtoDLB(int idx) {
        Corner[] perm = new Corner[]{Corner.URF, Corner.UFL, Corner.ULB, Corner.UBR, Corner.DFR, Corner.DLF, Corner.DBL, Corner.DRB};
        int j = 1;
        while (j < 8) {
            int k = idx % (j + 1);
            idx /= j + 1;
            while (k-- > 0) {
                CubieCube.rotateRight(perm, 0, j);
            }
            ++j;
        }
        int x = 7;
        int j2 = 7;
        while (j2 >= 0) {
            this.cp[j2] = perm[x--];
            --j2;
        }
    }

    int getURtoBR() {
        Edge[] perm = new Edge[12];
        int b = 0;
        int i = 0;
        while (i < 12) {
            perm[i] = this.ep[i];
            ++i;
        }
        int j = 11;
        while (j > 0) {
            int k = 0;
            while (perm[j].ordinal() != j) {
                CubieCube.rotateLeft(perm, 0, j);
                ++k;
            }
            b = (j + 1) * b + k;
            --j;
        }
        return b;
    }

    void setURtoBR(int idx) {
        Edge[] perm = new Edge[]{Edge.UR, Edge.UF, Edge.UL, Edge.UB, Edge.DR, Edge.DF, Edge.DL, Edge.DB, Edge.FR, Edge.FL, Edge.BL, Edge.BR};
        int j = 1;
        while (j < 12) {
            int k = idx % (j + 1);
            idx /= j + 1;
            while (k-- > 0) {
                CubieCube.rotateRight(perm, 0, j);
            }
            ++j;
        }
        int x = 11;
        int j2 = 11;
        while (j2 >= 0) {
            this.ep[j2] = perm[x--];
            --j2;
        }
    }

    int verify() {
        int sum = 0;
        int[] edgeCount = new int[12];
        Edge[] arredge = Edge.values();
        int n = arredge.length;
        int n2 = 0;
        while (n2 < n) {
            Edge e = arredge[n2];
            int[] arrn = edgeCount;
            int n3 = this.ep[e.ordinal()].ordinal();
            arrn[n3] = arrn[n3] + 1;
            ++n2;
        }
        int i = 0;
        while (i < 12) {
            if (edgeCount[i] != 1) {
                return -2;
            }
            ++i;
        }
        i = 0;
        while (i < 12) {
            sum += this.eo[i];
            ++i;
        }
        if (sum % 2 != 0) {
            return -3;
        }
        int[] cornerCount = new int[8];
        Corner[] arrcorner = Corner.values();
        int n4 = arrcorner.length;
        n = 0;
        while (n < n4) {
            Corner c = arrcorner[n];
            int[] arrn = cornerCount;
            int n5 = this.cp[c.ordinal()].ordinal();
            arrn[n5] = arrn[n5] + 1;
            ++n;
        }
        int i2 = 0;
        while (i2 < 8) {
            if (cornerCount[i2] != 1) {
                return -4;
            }
            ++i2;
        }
        sum = 0;
        i2 = 0;
        while (i2 < 8) {
            sum += this.co[i2];
            ++i2;
        }
        if (sum % 3 != 0) {
            return -5;
        }
        if ((this.edgeParity() ^ this.cornerParity()) != 0) {
            return -6;
        }
        return 0;
    }
}

