package studio.rrprojects.runnerbuddy.gui.cards;

import studio.rrprojects.runnerbuddy.containers.character.CharacterContainer;
import studio.rrprojects.runnerbuddy.gui.CharacterCreationWindow;
import studio.rrprojects.runnerbuddy.gui.cards.magic.MagicalInfoCard;
import studio.rrprojects.runnerbuddy.gui.cards.magic.SpellsCard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class MagicCard extends Card {
    private final CharacterContainer characterContainer;
    private JPanel panelMain;
    private JSplitPane splitPane;
    private JPanel panelMenu;
    private JPanel panelCards;
    private LinkedHashMap<String, Card> cardsMap;
    private Card selectedCard;
    private CardLayout cardLayout;
    private ArrayList<ButtonObject> listButtons;

    public MagicCard(CharacterContainer characterContainer) {
        this.characterContainer = characterContainer;
        setPanel(panelMain);
        setTitle("Magic");

        SetMainPanel();
        SetMenuPanel();
        SetCardsPanel();

        CreateListOfButtons();
        FormatButtons();

        CreateListOfCards();
        FormatCards();

        InitialCardPass();
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
        listButtons.add(new ButtonObject("Adept Powers"));
        listButtons.add(new ButtonObject("Foci"));
        listButtons.add(new ButtonObject("Spirits"));

    }

    private void FormatButtons() {
        for (ButtonObject button : listButtons) {
            panelMenu.add(button.getJButton());
        }
    }

    private void CreateListOfCards() {
        cardsMap = new LinkedHashMap<>();
        cardsMap.put("Magic Info", new MagicalInfoCard(characterContainer));
        cardsMap.put("Spells", new SpellsCard(characterContainer));
        cardsMap.put("Adept Powers", new SpellsCard(characterContainer));
        cardsMap.put("Foci", new SpellsCard(characterContainer));
        cardsMap.put("Spirits", new SpellsCard(characterContainer));
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

}
