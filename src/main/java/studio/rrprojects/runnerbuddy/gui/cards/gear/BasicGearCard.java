package studio.rrprojects.runnerbuddy.gui.cards.gear;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import studio.rrprojects.runnerbuddy.containers.items.Buyable;
import studio.rrprojects.runnerbuddy.containers.items.GearGroups.GearGroup;
import studio.rrprojects.runnerbuddy.gui.cards.Card;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasicGearCard extends Card {
    private JPanel panelMain;
    private JTree treeMain;

    public BasicGearCard(String title) {
        super(title);
        setPanel(panelMain);
    }

    @Override
    public void Initialize() {
        super.Initialize();
        treeMain.setModel(new DefaultTreeModel(new DefaultMutableTreeNode(getTitle())));

        GearGroup gearGroup = getCharacterContainer().getResourceController().getMasterMap().get(getTitle());

        if (gearGroup == null) {
            return;
        }

        DefaultMutableTreeNode treeNode = gearGroup.toNode();

        treeMain.setModel(new DefaultTreeModel(treeNode));

        treeMain.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TreePath selPath = treeMain.getPathForLocation(e.getX(), e.getY());
                if (e.getClickCount() == 2) {
                    assert selPath != null;
                    DoubleClickEvent(selPath);
                }
            }
        });
    }

    private void DoubleClickEvent(TreePath selPath) {
        DefaultMutableTreeNode finalNode = (DefaultMutableTreeNode) selPath.getLastPathComponent();
        Object selectedObject = finalNode.getUserObject();

        if (selectedObject instanceof Buyable) {
            Buyable buyable = (Buyable) selectedObject;
            buyable.PurchaseDialog();
        }
    }

    @Override
    public void Update() {
        super.Update();
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
        final JScrollPane scrollPane1 = new JScrollPane();
        panelMain.add(scrollPane1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        treeMain = new JTree();
        scrollPane1.setViewportView(treeMain);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
