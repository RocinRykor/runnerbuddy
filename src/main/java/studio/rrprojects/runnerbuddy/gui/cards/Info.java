package studio.rrprojects.runnerbuddy.gui.cards;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import studio.rrprojects.runnerbuddy.containers.character.CharacterContainer;
import studio.rrprojects.runnerbuddy.controllers.RunnerBuilderController;
import studio.rrprojects.runnerbuddy.utils.JUtils;

import javax.swing.*;
import java.awt.*;

public class Info extends Card {

    private JPanel panelMain;

    public Info(RunnerBuilderController controller, CharacterContainer characterContainer) {
        this.controller = controller;
        this.characterContainer = characterContainer;

        SetColors();
    }

    private void SetColors() {
        JUtils.SetDefaultPanelColors(panelMain);
    }

    @Override
    public String getTitle() {
        return "CardInfo";
    }

    @Override
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
        panelMain.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("THIS IS A TEST!");
        panelMain.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
