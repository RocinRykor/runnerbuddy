package studio.rrprojects.runnerbuddy.gui.cards.magic;

import studio.rrprojects.runnerbuddy.gui.CardManager;
import studio.rrprojects.runnerbuddy.gui.cards.Card;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MagicCard extends Card {
    private final JButton jButton;
    private JPanel panelMain;
    private JSplitPane splitPane;
    private JPanel panelMenu;
    private JPanel panelCards;
    private LinkedHashMap<String, Card> cardsMap;
    private Card selectedCard;
    private CardLayout cardLayout;
    private ArrayList<ButtonObject> listButtons;

    public MagicCard(String title) {
        super(title);
        setPanel(panelMain);
        jButton = new JButton(title);
    }

    @Override
    public void Initialize() {
        super.Initialize();

        CheckMagical();

        CardManager cardManager = new CardManager(panelMain);

        cardManager.setCharacterContainer(getCharacterContainer());

        cardManager.addCard(new MagicalInfoCard("Magic Info"));
        cardManager.addCard(new SpellsCard("Spells"));

    }

    private void CheckMagical() {
        jButton.setVisible(getCharacterContainer().getMagicController().isMagical());
    }

    private void SetMainPanel() {
        panelMain.setLayout(new BorderLayout(0, 0));

        //Split Panel
        splitPane = new JSplitPane();
        splitPane.setDividerLocation(50);
        splitPane.setDividerSize(0);
        splitPane.setOrientation(0);
        panelMain.add(splitPane, BorderLayout.CENTER);
    }

    private void SetMenuPanel() {
        //Menu Panels
        panelMenu = new JPanel();
        panelMenu.setLayout(new FlowLayout());

        splitPane.setLeftComponent(panelMenu);
    }

    private void SetCardsPanel() {
        //Card Panel
        panelCards = new JPanel();
        panelCards.setLayout(new CardLayout(0, 0));
        panelCards.setPreferredSize(new Dimension(800, 700));
        splitPane.setRightComponent(panelCards);
    }

    private void CreateListOfButtons() {
        listButtons = new ArrayList<>();
        listButtons.add(new ButtonObject("Magic Info"));
        listButtons.add(new ButtonObject("Spells"));
    }

    private void FormatButtons() {
        for (ButtonObject button : listButtons) {
            panelMenu.add(button.getJButton());
        }
    }

    private void CreateListOfCards() {
        cardsMap = new LinkedHashMap<>();
        cardsMap.put("Magic Info", new MagicalInfoCard("Magic Info"));
        cardsMap.put("Spells", new SpellsCard("Spells"));
        //cardsMap.put("Save/Export", new SaveCard(characterContainer));

        for (Map.Entry<String, Card> entry : cardsMap.entrySet()) {
            String title = entry.getKey();
            Card card = entry.getValue();

            card.setTitle(title);
        }

        selectedCard = cardsMap.get("Magic Info"); //Ideal will get whatever one is first but here we have to specify
    }

    private void FormatCards() {
        for (Map.Entry<String, Card> entry : cardsMap.entrySet()) {
            String cardName = entry.getKey();
            Card card = entry.getValue();

            System.out.println(card);

            JPanel panel = card.getPanel();

            //System.out.println("PANEL " + panel);
            //System.out.println("CARD_NAME " + cardName);

            panelCards.add(panel, cardName);
        }

        cardLayout = (CardLayout) panelCards.getLayout();
    }

    private void InitialCardPass() {
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
        panelMain.setLayout(new CardLayout(0, 0));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

    private class ButtonObject {
        JButton jButton;

        public JButton getJButton() {
            return jButton;
        }

        public ButtonObject(String title) {
            jButton = new JButton(title);
            jButton.addActionListener(actionEvent -> {
                SwitchTo(jButton.getActionCommand());
            });
        }
    }

    private void SwitchTo(String cardName) {
        System.out.println("CARD NAME: " + cardName);
        System.out.println("SELECTED CARD TITLE: " + selectedCard.getTitle());

        if (selectedCard.getTitle().equalsIgnoreCase(cardName)) {
            return;
        }

        System.out.println("CharacterCreationWindow: Switching To -> " + cardName);

        //Update the current card before switching
        selectedCard.Update();

        //Change which card is selected
        selectedCard = cardsMap.get(cardName);
        cardLayout.show(panelCards, cardName);

        selectedCard.Update();
    }

    @Override
    public JButton getButton() {
        return jButton;
    }
}
