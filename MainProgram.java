/*
 * Decompiled with CFR 0_118.
 */
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.kociemba.twophase.Search;
import org.kociemba.twophase.Tools;

public class MainProgram
extends JFrame {
    private static final long serialVersionUID = 1;
    private JButton[][] facelet = new JButton[6][9];
    private final JButton[] colorSel = new JButton[6];
    private final int FSIZE = 45;
    private final int[] XOFF;
    private final int[] YOFF;
    private final Color[] COLORS;
    private JCheckBox checkBoxShowStr;
    private JButton buttonRandom;
    private JCheckBox checkBoxUseSep;
    private JButton Solve;
    private JLabel jLabel2;
    private JLabel jLabel1;
    private JSpinner spinnerMaxMoves;
    private JSpinner spinnerTimeout;
    private Color curCol;
    private int maxDepth;
    private int maxTime;
    boolean useSeparator;
    boolean showString;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                MainProgram inst = new MainProgram();
                inst.setLocationRelativeTo(null);
                inst.setVisible(true);
            }
        });
    }

    public MainProgram() {
        int[] arrn = new int[6];
        arrn[0] = 3;
        arrn[1] = 6;
        arrn[2] = 3;
        arrn[3] = 3;
        arrn[5] = 9;
        this.XOFF = arrn;
        int[] arrn2 = new int[6];
        arrn2[1] = 3;
        arrn2[2] = 3;
        arrn2[3] = 6;
        arrn2[4] = 3;
        arrn2[5] = 3;
        this.YOFF = arrn2;
        this.COLORS = new Color[]{Color.white, Color.red, Color.green, Color.yellow, Color.orange, Color.blue};
        this.curCol = this.COLORS[0];
        this.maxDepth = 24;
        this.maxTime = 5;
        this.useSeparator = true;
        this.showString = false;
        this.initGUI();
    }

    private void initGUI() {
        this.getContentPane().setLayout(null);
        this.setDefaultCloseOperation(2);
        this.setTitle("Two-Phase Package GUI-Example");
        this.Solve = new JButton("Solve Cube");
        this.getContentPane().add(this.Solve);
        this.Solve.setBounds(422, 64, 114, 48);
        this.Solve.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                MainProgram.this.solveCube(evt);
            }
        });
        this.jLabel1 = new JLabel();
        this.getContentPane().add(this.jLabel1);
        this.jLabel1.setText("Move Limit");
        this.jLabel1.setBounds(282, 65, 72, 16);
        SpinnerNumberModel model = new SpinnerNumberModel(24, 1, 24, 1);
        this.spinnerMaxMoves = new JSpinner(model);
        this.getContentPane().add(this.spinnerMaxMoves);
        this.spinnerMaxMoves.setBounds(354, 62, 56, 21);
        this.spinnerMaxMoves.getEditor().setPreferredSize(new Dimension(37, 19));
        this.spinnerMaxMoves.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent evt) {
                MainProgram.access$2(MainProgram.this, (Integer)MainProgram.this.spinnerMaxMoves.getValue());
            }
        });
        this.jLabel2 = new JLabel();
        this.getContentPane().add(this.jLabel2);
        this.jLabel2.setText("Time Limit");
        this.jLabel2.setBounds(282, 93, 72, 16);
        model = new SpinnerNumberModel(5, 1, 3600, 1);
        this.spinnerTimeout = new JSpinner(model);
        this.getContentPane().add(this.spinnerTimeout);
        this.spinnerTimeout.setModel(model);
        this.spinnerTimeout.setBounds(354, 90, 56, 21);
        this.spinnerTimeout.getEditor().setPreferredSize(new Dimension(36, 17));
        this.spinnerTimeout.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent evt) {
                MainProgram.access$4(MainProgram.this, (Integer)MainProgram.this.spinnerTimeout.getValue());
            }
        });
        this.checkBoxUseSep = new JCheckBox("Use Separator", true);
        this.getContentPane().add(this.checkBoxUseSep);
        this.checkBoxUseSep.setBounds(12, 320, 121, 20);
        this.checkBoxUseSep.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                MainProgram.this.useSeparator = MainProgram.this.checkBoxUseSep.isSelected();
            }
        });
        this.checkBoxShowStr = new JCheckBox("Show String", false);
        this.getContentPane().add(this.checkBoxShowStr);
        this.checkBoxShowStr.setBounds(12, 343, 121, 20);
        this.checkBoxShowStr.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                MainProgram.this.showString = MainProgram.this.checkBoxShowStr.isSelected();
            }
        });
        this.buttonRandom = new JButton("Random Cube");
        this.getContentPane().add(this.buttonRandom);
        this.buttonRandom.setBounds(422, 17, 114, 22);
        this.buttonRandom.setText("Scramble");
        this.buttonRandom.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                String r = Tools.randomCube();
                int i = 0;
                while (i < 6) {
                    int j = 0;
                    while (j < 9) {
                        switch (r.charAt(9 * i + j)) {
                            case 'U': {
                                MainProgram.this.facelet[i][j].setBackground(MainProgram.this.COLORS[0]);
                                break;
                            }
                            case 'R': {
                                MainProgram.this.facelet[i][j].setBackground(MainProgram.this.COLORS[1]);
                                break;
                            }
                            case 'F': {
                                MainProgram.this.facelet[i][j].setBackground(MainProgram.this.COLORS[2]);
                                break;
                            }
                            case 'D': {
                                MainProgram.this.facelet[i][j].setBackground(MainProgram.this.COLORS[3]);
                                break;
                            }
                            case 'L': {
                                MainProgram.this.facelet[i][j].setBackground(MainProgram.this.COLORS[4]);
                                break;
                            }
                            case 'B': {
                                MainProgram.this.facelet[i][j].setBackground(MainProgram.this.COLORS[5]);
                            }
                        }
                        ++j;
                    }
                    ++i;
                }
            }
        });
        int i = 0;
        while (i < 6) {
            int j = 0;
            while (j < 9) {
                this.facelet[i][j] = new JButton();
                this.getContentPane().add(this.facelet[i][j]);
                this.facelet[i][j].setBackground(Color.gray);
                this.facelet[i][j].setRolloverEnabled(false);
                this.facelet[i][j].setOpaque(true);
                this.facelet[i][j].setBounds(45 * this.XOFF[i] + 45 * (j % 3), 45 * this.YOFF[i] + 45 * (j / 3), 45, 45);
                this.facelet[i][j].addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        ((JButton)evt.getSource()).setBackground(MainProgram.this.curCol);
                    }
                });
                ++j;
            }
            ++i;
        }
        String[] txt = new String[]{"U", "R", "F", "D", "L", "B"};
        int i2 = 0;
        while (i2 < 6) {
            this.facelet[i2][4].setText(txt[i2]);
            ++i2;
        }
        i2 = 0;
        while (i2 < 6) {
            this.colorSel[i2] = new JButton();
            this.getContentPane().add(this.colorSel[i2]);
            this.colorSel[i2].setBackground(this.COLORS[i2]);
            this.colorSel[i2].setOpaque(true);
            this.colorSel[i2].setBounds(45 * (this.XOFF[1] + 1) + 33 * i2, 45 * (this.YOFF[3] + 1), 33, 33);
            this.colorSel[i2].setName("" + i2);
            this.colorSel[i2].addActionListener(new ActionListener(){

                @Override
                public void actionPerformed(ActionEvent evt) {
                    MainProgram.access$10(MainProgram.this, MainProgram.this.COLORS[Integer.parseInt(((JButton)evt.getSource()).getName())]);
                }
            });
            ++i2;
        }
        this.pack();
        this.setSize(556, 441);
    }

    private void solveCube(ActionEvent evt) {
        String result;
        StringBuffer s = new StringBuffer(54);
        int i = 0;
        while (i < 54) {
            s.insert(i, 'B');
            ++i;
        }
        i = 0;
        while (i < 6) {
            int j = 0;
            while (j < 9) {
                if (this.facelet[i][j].getBackground() == this.facelet[0][4].getBackground()) {
                    s.setCharAt(9 * i + j, 'U');
                }
                if (this.facelet[i][j].getBackground() == this.facelet[1][4].getBackground()) {
                    s.setCharAt(9 * i + j, 'R');
                }
                if (this.facelet[i][j].getBackground() == this.facelet[2][4].getBackground()) {
                    s.setCharAt(9 * i + j, 'F');
                }
                if (this.facelet[i][j].getBackground() == this.facelet[3][4].getBackground()) {
                    s.setCharAt(9 * i + j, 'D');
                }
                if (this.facelet[i][j].getBackground() == this.facelet[4][4].getBackground()) {
                    s.setCharAt(9 * i + j, 'L');
                }
                if (this.facelet[i][j].getBackground() == this.facelet[5][4].getBackground()) {
                    s.setCharAt(9 * i + j, 'B');
                }
                ++j;
            }
            ++i;
        }
        String cubeString = s.toString();
        if (this.showString) {
            JOptionPane.showMessageDialog(null, "Cube Definiton String: " + cubeString);
        }
        if ((result = Search.solution(cubeString, this.maxDepth, this.maxTime, this.useSeparator)).contains("Error")) {
            switch (result.charAt(result.length() - 1)) {
                case '1': {
                    result = "There are not exactly nine facelets of each color!";
                    break;
                }
                case '2': {
                    result = "Not all 12 edges exist exactly once!";
                    break;
                }
                case '3': {
                    result = "Flip error: One edge has to be flipped!";
                    break;
                }
                case '4': {
                    result = "Not all 8 corners exist exactly once!";
                    break;
                }
                case '5': {
                    result = "Twist error: One corner has to be twisted!";
                    break;
                }
                case '6': {
                    result = "Parity error: Two corners or two edges have to be exchanged!";
                    break;
                }
                case '7': {
                    result = "No solution exists for the given maximum move number!";
                    break;
                }
                case '8': {
                    result = "Timeout, no solution found within given maximum time!";
                }
            }
        }
        JOptionPane.showMessageDialog(null, result);
    }

    static /* synthetic */ void access$2(MainProgram mainProgram, int n) {
        mainProgram.maxDepth = n;
    }

    static /* synthetic */ void access$4(MainProgram mainProgram, int n) {
        mainProgram.maxTime = n;
    }

    static /* synthetic */ void access$10(MainProgram mainProgram, Color color) {
        mainProgram.curCol = color;
    }

}

