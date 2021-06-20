package studio.rrprojects.runnerbuddy.gui.cards.components;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import studio.rrprojects.runnerbuddy.containers.character.CharacterContainer;
import studio.rrprojects.runnerbuddy.gui.cards.Attributes;

import javax.swing.*;
import java.awt.*;

public class AttributeModule extends JComponent {
    private CharacterContainer characterContainer;

    private JPanel panelMain;
    private JButton buttonPlus;
    private JButton buttonMinus;

    private int buttonSize = 24;
    private int labelSize = 18;


    private String attributeName;
    private Integer modValue;

    private final int allottedMinimum = 1;
    private final int allottedMax = 6;
    private int allottedPoints;
    private int totalPoints;
    private JPanel panelButtons;
    private JLabel labelName;
    private JLabel labelAllotted;
    private JLabel labelRacial;
    private JLabel labelTotal;
    private JSeparator seperator4;
    private JSeparator seperator3;
    private JSeparator seperator2;
    private JSeparator seperator1;

    private boolean isEditable;
    private Attributes attributes;


    public AttributeModule() {
        /*
        JUtils.SetDefaultPanelColors(panelMain);

        JUtils.SetDefaultButtonColorsAndFont(buttonPlus, buttonSize);
        JUtils.SetButtonColorsAndFont(buttonMinus, Color.RED, buttonSize);

        JUtils.SetDefaultLabelColorsAndFont(labelAttribute, labelSize);
        JUtils.SetDefaultLabelColorsAndFont(labelAllottedPoints, labelSize);
        JUtils.SetDefaultLabelColorsAndFont(labelRacialMod, labelSize);
        JUtils.SetDefaultLabelColorsAndFont(labelTotalPoints, labelSize);

         */
        modValue = 0;
        allottedPoints = 0;

        panelButtons.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        AddFunctionToButtons();
        //UpdateValues();
    }

    private void AddFunctionToButtons() {
        buttonMinus.addActionListener(actionEvent -> ChangeAllottedPoints(-1));
        buttonPlus.addActionListener(actionEvent -> ChangeAllottedPoints(1));
    }

    private void ChangeAllottedPoints(int valueChange) {
        allottedPoints += valueChange;

        CalculateMax();

        attributes.UpdateAll();
    }

    private void CalculateMax() {
        if (allottedPoints >= allottedMax) {
            allottedPoints = allottedMax;
            buttonPlus.setEnabled(false);
        } else {
            buttonPlus.setEnabled(true);
        }
    }

    public void LinkAttribute(CharacterContainer characterContainer, String attributeName, Attributes attributes) {
        this.characterContainer = characterContainer;
        this.attributeName = attributeName;
        this.attributes = attributes;

        allottedPoints = allottedMinimum;

        labelName.setText(attributeName);
    }

    public void UpdateValues() {
        //Racial Modifier
        //modValue = characterContainer.getRaceController().getSelectedRace().getModAttributeMap().get(attributeName);

        labelRacial.setText(modValue.toString());

        //Allotted Points
        int realMinimum = allottedMinimum - modValue; //If a race has a negative mod Value (Trolls Intelligence), this calculates the minimum you can have

        if (realMinimum >= allottedMinimum && allottedPoints < realMinimum) {
            allottedPoints = realMinimum;
        }

        labelAllotted.setText(String.valueOf(allottedPoints));
        buttonMinus.setEnabled(allottedPoints != allottedMinimum && allottedPoints != realMinimum);

        //Total Points
        totalPoints = allottedPoints + modValue;
        setTotalText(String.valueOf(totalPoints));

        if (attributes != null) {
            attributes.UpdateProgressBar();
        }

    }

    public JPanel getPanel() {
        return panelMain;
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new GridLayoutManager(1, 9, new Insets(10, 0, 10, 0), -1, -1));
        labelName = new JLabel();
        labelName.setText("AttributeName");
        panelMain.add(labelName, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labelAllotted = new JLabel();
        labelAllotted.setText("AllottedPoints");
        panelMain.add(labelAllotted, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labelRacial = new JLabel();
        labelRacial.setText("RacialMod");
        panelMain.add(labelRacial, new GridConstraints(0, 4, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labelTotal = new JLabel();
        labelTotal.setText("TotalPoints");
        panelMain.add(labelTotal, new GridConstraints(0, 6, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(panelButtons, new GridConstraints(0, 8, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        buttonMinus = new JButton();
        buttonMinus.setText("-");
        panelButtons.add(buttonMinus, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonPlus = new JButton();
        buttonPlus.setText("+");
        panelButtons.add(buttonPlus, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        seperator1 = new JSeparator();
        panelMain.add(seperator1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        seperator2 = new JSeparator();
        panelMain.add(seperator2, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        seperator3 = new JSeparator();
        panelMain.add(seperator3, new GridConstraints(0, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        seperator4 = new JSeparator();
        panelMain.add(seperator4, new GridConstraints(0, 7, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

    public void setEditable(boolean b) {
        isEditable = b;
        UpdateEditable();
    }

    private void UpdateEditable() {
        labelRacial.setVisible(isEditable);
        labelAllotted.setVisible(isEditable);

        seperator2.setVisible(isEditable);
        seperator3.setVisible(isEditable);
        seperator4.setVisible(isEditable);

        panelButtons.setVisible(isEditable);
    }

    public void setRacialMod(int i) {
        modValue = i;
        UpdateValues();
    }

    public int getAllottedPoints() {
        return allottedPoints;
    }

    public void DisablePlusButtons() {
        buttonPlus.setEnabled(false);
    }

    public void RestorePlusButtons() {
        CalculateMax();
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public void setTotalText(String s) {
        labelTotal.setText("( " + s + " )");
    }

    public void setAllottedPoints(int allottedPoints) {
        this.allottedPoints = allottedPoints;
    }

    public CharacterContainer getCharacterContainer() {
        return characterContainer;
    }

    protected double getTotalPointsAsDouble() {
        return 0;
    }
}
