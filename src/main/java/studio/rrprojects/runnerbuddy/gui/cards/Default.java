package studio.rrprojects.runnerbuddy.gui.cards;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import studio.rrprojects.runnerbuddy.controllers.RunnerBuilderController;
import studio.rrprojects.runnerbuddy.utils.JUtils;
import studio.rrprojects.runnerbuddy.utils.TextUtils;

import javax.swing.*;
import java.awt.*;

public class Default extends Card {
    private JPanel panelMain;
    private JTextPane textPane;
    private JLabel textLabel;

    public Default(RunnerBuilderController controller) {
        JUtils.SetDefaultPanelColors(panelMain);

        String message = "To get started, please select one of the tabs above.\n\n" +
                "When you are finished, entering information into each tab, return to the Info tab to finalize your character.";

        textPane.setText(message);

        JUtils.SetDefaultTextPaneColors(textPane);
        //textPane.setFont(controller.getShadowrunFont(36));
        JUtils.SetDefaultTextPaneFont(textPane, 36);

        TextUtils.CenterPaneText(textPane);
    }

    @Override
    public String getTitle() {
        return "CardDefault";
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
        panelMain.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        final Spacer spacer1 = new Spacer();
        panelMain.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        textPane = new JTextPane();
        panelMain.add(textPane, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
