package studio.rrprojects.runnerbuddy.gui.cards.gear;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import studio.rrprojects.runnerbuddy.gui.CardManager;
import studio.rrprojects.runnerbuddy.gui.cards.Card;
import studio.rrprojects.runnerbuddy.utils.TextUtils;

import javax.swing.*;
import java.awt.*;

public class StreetGear extends Card {
    private JPanel panelMain;
    private JPanel panelCard;
    private JPanel panelInformation;
    private JLabel labelResources;
    private JTree tree1;

    public StreetGear(String title) {
        super(title);
        setPanel(panelMain);

        //System.out.println("STREET GEAR: " + getCharacterContainer());
    }

    @Override
    public void Initialize() {
        super.Initialize();

        CardManager cardManager = new CardManager(panelCard);
        cardManager.setCharacterContainer(getCharacterContainer());
        cardManager.addCard(new WeaponGearCard("Weapons"));
        cardManager.addCard(new WeaponGearCard("Armor"));
        cardManager.addCard(new WeaponGearCard("Lifestyle"));
        cardManager.addCard(new WeaponGearCard("Misc."));

        panelCard.setBorder(BorderFactory.createTitledBorder("Purchase New Gear:"));
        panelInformation.setBorder(BorderFactory.createTitledBorder("Current Inventory:"));
    }

    @Override
    public void Update() {
        String moneyString = CalculateRemainingNuyen();

        labelResources.setText("Reamining Nuyen: " + moneyString);
    }

    private String CalculateRemainingNuyen() {
        int money = getCharacterContainer().getResourceController().getStartingNuyen();

        return TextUtils.IntToCash(money);
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
        panelMain.setLayout(new GridLayoutManager(1, 2, new Insets(10, 10, 10, 10), -1, -1));
        panelCard = new JPanel();
        panelCard.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(panelCard, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panelInformation = new JPanel();
        panelInformation.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.add(panelInformation, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        labelResources = new JLabel();
        labelResources.setText("Label");
        panelInformation.add(labelResources, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tree1 = new JTree();
        panelInformation.add(tree1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
