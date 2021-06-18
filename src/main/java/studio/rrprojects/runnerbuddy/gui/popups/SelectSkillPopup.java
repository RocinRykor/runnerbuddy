package studio.rrprojects.runnerbuddy.gui.popups;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import studio.rrprojects.runnerbuddy.utils.ColorUtils;
import studio.rrprojects.runnerbuddy.utils.FontUtils;
import studio.rrprojects.runnerbuddy.utils.JUtils;

import javax.swing.*;
import java.awt.*;

public class SelectSkillPopup {
    //private final SkillContainer skillContainer;
    //private final Skills skillsCard;
    private final JFrame frame;
    private JPanel panelMain;
    private JTextArea textAreaDescription;
    private JButton buttonSubmit;
    private JButton buttonCancel;
    private JComboBox<String> boxSpecialization;
    private JCheckBox checkboxSpecialization;
    private JCheckBox checkboxBuildRepair;
    private JSlider sliderPointsAllotted;
    private JLabel labelDisplayName;
    private JLabel labelSkillLevel;
    private JTextArea textAreaCalculations;

    public SelectSkillPopup() {
        frame = new JFrame();
        $$$setupUI$$$();
        JUtils.OpenFrameAtMouseLocation(frame);
        frame.setContentPane(panelMain);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();

        frame.repaint();
        panelMain.repaint();
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
        panelMain.setLayout(new GridLayoutManager(6, 3, new Insets(10, 10, 10, 10), -1, -1));
        panelMain.setMinimumSize(new Dimension(800, 600));
        panelMain.setPreferredSize(new Dimension(800, 600));
        textAreaDescription = new JTextArea();
        textAreaDescription.setEditable(false);
        textAreaDescription.setLineWrap(true);
        textAreaDescription.setText("");
        textAreaDescription.setWrapStyleWord(true);
        panelMain.add(textAreaDescription, new GridConstraints(0, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        buttonSubmit = new JButton();
        buttonSubmit.setText("Submit");
        panelMain.add(buttonSubmit, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        buttonCancel = new JButton();
        buttonCancel.setText("Cancel");
        panelMain.add(buttonCancel, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        checkboxSpecialization = new JCheckBox();
        checkboxSpecialization.setText("Specialization");
        panelMain.add(checkboxSpecialization, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        checkboxBuildRepair = new JCheckBox();
        checkboxBuildRepair.setText("Build/Repair");
        panelMain.add(checkboxBuildRepair, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        boxSpecialization = new JComboBox();
        panelMain.add(boxSpecialization, new GridConstraints(4, 1, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final Spacer spacer1 = new Spacer();
        panelMain.add(spacer1, new GridConstraints(5, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        sliderPointsAllotted = new JSlider();
        sliderPointsAllotted.setEnabled(true);
        sliderPointsAllotted.setMajorTickSpacing(1);
        sliderPointsAllotted.setMaximum(6);
        sliderPointsAllotted.setMinimum(1);
        sliderPointsAllotted.setPaintLabels(true);
        sliderPointsAllotted.setPaintTicks(true);
        sliderPointsAllotted.setSnapToTicks(true);
        sliderPointsAllotted.setValue(3);
        sliderPointsAllotted.setValueIsAdjusting(false);
        panelMain.add(sliderPointsAllotted, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labelDisplayName = new JLabel();
        labelDisplayName.setText("Label");
        panelMain.add(labelDisplayName, new GridConstraints(2, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labelSkillLevel = new JLabel();
        labelSkillLevel.setText("Skill Level:");
        panelMain.add(labelSkillLevel, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_EAST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textAreaCalculations = new JTextArea();
        textAreaCalculations.setEditable(false);
        textAreaCalculations.setLineWrap(true);
        textAreaCalculations.setText("");
        textAreaCalculations.setWrapStyleWord(true);
        panelMain.add(textAreaCalculations, new GridConstraints(1, 0, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
