import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CharacCreation extends JFrame implements NameInputListener {
    private static final String NORMAL_ENTERNAME_PATH = "normalEnterName.png";
    private static final String NORMAL_CONFIRM_PATH = "normalConfirm.png";
    private static final String HOVER_CONFIRM_PATH = "hoverConfirm.png";
    private static final String HOVER_ENTERNAME_PATH = "hoverEnterName.png";
    private static final String NORMAL_BLANKNAME_PATH = "BlankButton.png";
    private static final String NORMAL_JOBCLASS_PATH = "normalJobClass.png";
    private static final String NORMAL_ENTERCHARAC_PATH = "normalBlankCharac.png";
    private static final String HOVER_BLANKCHARAC_PATH = "hoverBlankCharac.png";
    private JButton blankNameButton;
    private JButton confirmButton;
    private JButton enterNameButton;
    private JButton backButton;
    private JButton jobClassButton;
    private JButton enterCharacButton;
    private TitleScreen titleScreen;
    private GameLobby gameLobby;
    private EnterName enterName;
    private CCConstants constants;
    private JLabel Text;
    private JLabel background;
    private String enteredName = "";
    private JLabel nameLabel;
    private JLabel headerLabel;
    private JLabel titleLabel;
    private JLabel opacityBGLabel;
    private CardFeature cardFeature;
    private JLabel characterLabel;
    private NameWarning nameWarning;
    private CharacterWarning characterWarning;
    

    public CharacCreation() {
        constants = new CCConstants();
        cardFeature = new CardFeature(this);

        // Frame setup
        this.setTitle("Character Creation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(920, 580);
        this.setLocationRelativeTo(null);

        // Background image
        ImageIcon backgroundImage = new ImageIcon("CharacCreationBackground.jpeg");
        Image imgBackground = backgroundImage.getImage().getScaledInstance(920, 580, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(imgBackground);
        background = new JLabel("", scaledBackgroundImage, JLabel.CENTER);
        this.setContentPane(background);

        // Back Button
        this.backButton = constants.getbackButton();
        this.add(backButton);

        // Character Creation Text
        this.Text = constants.getCCText();
        this.add(Text);

        // Initialize the JLabel for displaying the entered name
        nameLabel = new JLabel();
        nameLabel.setFont(new Font("Mantinia", Font.BOLD, 40));
        nameLabel.setForeground(Color.decode("#AC9D73")); // Set text color
        nameLabel.setBounds(45, 110, 400, 40); // Set position and size
        this.add(nameLabel);

        // Initialize the JLabel for displaying the entered name
        characterLabel = new JLabel();
        characterLabel.setFont(new Font("Mantinia", Font.BOLD, 40));
        characterLabel.setForeground(Color.decode("#AC9D73")); // Set text color
        characterLabel.setBounds(665, 110, 400, 40); // Set position and size
        this.add(characterLabel);

        // Normal Enter Name Button
        ImageIcon normalEnterNameIcon = new ImageIcon(new ImageIcon(NORMAL_ENTERNAME_PATH).getImage().getScaledInstance(285, 81, Image.SCALE_SMOOTH));
        Image scaledNormalEnterNameImage = normalEnterNameIcon.getImage().getScaledInstance(285, 81, Image.SCALE_SMOOTH);
        enterNameButton = new JButton(new ImageIcon(scaledNormalEnterNameImage));
        enterNameButton.setBounds(31, 76, 285, 81);
        enterNameButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(enterNameButton);

        // Normal Blank Name Button
        ImageIcon blankNameIcon = new ImageIcon(new ImageIcon(NORMAL_BLANKNAME_PATH).getImage().getScaledInstance(285, 81, Image.SCALE_SMOOTH));
        Image scaledBlankNameImage = blankNameIcon.getImage().getScaledInstance(285, 81, Image.SCALE_SMOOTH);
        blankNameButton = new JButton(new ImageIcon(scaledBlankNameImage));
        blankNameButton.setBounds(31, 76, 285, 81);
        blankNameButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(blankNameButton);
        blankNameButton.setVisible(false); // Initially hide the blank name button

        // Normal Job Class Button = Blank Charac
        ImageIcon normalJobClassIcon = new ImageIcon(new ImageIcon(NORMAL_JOBCLASS_PATH).getImage().getScaledInstance(285, 81, Image.SCALE_SMOOTH));
        Image scaledJobClassImage = normalJobClassIcon.getImage().getScaledInstance(263, 81, Image.SCALE_SMOOTH);
        jobClassButton = new JButton(new ImageIcon(scaledJobClassImage));
        jobClassButton.setBounds(625, 76, 263, 81);
        jobClassButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(jobClassButton);
        jobClassButton.setVisible(false); // Initially hide the blank name button

        // Normal Enter Character Button
        ImageIcon normalEnterCharacIcon = new ImageIcon(new ImageIcon(NORMAL_ENTERCHARAC_PATH).getImage().getScaledInstance(285, 81, Image.SCALE_SMOOTH));
        Image scaledEnterCharacImage = normalEnterCharacIcon.getImage().getScaledInstance(285, 81, Image.SCALE_SMOOTH);
        enterCharacButton = new JButton(new ImageIcon(scaledEnterCharacImage));
        enterCharacButton.setBounds(610, 76, 285, 81);
        enterCharacButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(enterCharacButton);

        // Header IMG 2
        this.headerLabel = constants.getHeaderIMG();
        this.add(headerLabel);

        // Title image on top
        this.titleLabel = constants.getTitleIMG();
        this.add(titleLabel);

        // Normal Confirm Button
        ImageIcon normalConfirmIcon = new ImageIcon(new ImageIcon(NORMAL_CONFIRM_PATH).getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH));
        Image scaledNormalConfirmImage = normalConfirmIcon.getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH);
        confirmButton = new JButton(new ImageIcon(scaledNormalConfirmImage));
        confirmButton.setBounds(735, 470, 160, 80);
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(confirmButton);

        // Preload the hover icons with scaled dimensions
        ImageIcon hoverConfirmIcon = new ImageIcon(new ImageIcon(HOVER_CONFIRM_PATH).getImage().getScaledInstance(150, 80, Image.SCALE_SMOOTH));
        ImageIcon hoverEnterNameIcon = new ImageIcon(new ImageIcon(HOVER_ENTERNAME_PATH).getImage().getScaledInstance(285, 81, Image.SCALE_SMOOTH));
        ImageIcon hoverBlankCharacIcon = new ImageIcon(new ImageIcon(HOVER_BLANKCHARAC_PATH).getImage().getScaledInstance(285, 81, Image.SCALE_SMOOTH));

        // Opacity Background image
        this.opacityBGLabel = constants.getOpacityBG();
        this.add(opacityBGLabel);

        this.setVisible(true);

        confirmButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                confirmButton.setIcon(hoverConfirmIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                confirmButton.setIcon(normalConfirmIcon);
            }
        });

        enterNameButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                enterNameButton.setIcon(hoverEnterNameIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                enterNameButton.setIcon(normalEnterNameIcon);
            }
        });

        enterCharacButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {}

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                enterCharacButton.setIcon(hoverBlankCharacIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                enterCharacButton.setIcon(normalEnterCharacIcon);
            }
        });

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Check if name is entered
                if (enteredName.isEmpty()) {
                    // If name is not entered, show NameWarning window
                    if (nameWarning == null) {
                        nameWarning = new NameWarning();
                    }
                    nameWarning.setVisible(true);
                    return; // Stop further execution
                }
                
                // Check if character is selected
                if (characterLabel.getText().isEmpty()) {
                    // If character is not selected, show CharacterWarning window
                    if (characterWarning == null) {
                        characterWarning = new CharacterWarning();
                    }
                    characterWarning.setVisible(true);
                    return; // Stop further execution
                }
        
                // Proceed with other actions if both name and character are entered
                if (gameLobby == null) {
                    gameLobby = new GameLobby(enteredName, characterLabel.getText());
                }
                gameLobby.setVisible(true);
            }
        });        

        enterNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (enteredName.isEmpty()) {
                    if (enterName == null) {
                        enterName = new EnterName();
                        enterName.setNameInputListener(CharacCreation.this); // Pass the listener instance
                    }
                    enterName.setVisible(true);
                } else {
                    // Handle the case where name is already entered
                    // For example, you can perform some action or display a message
                    // updateEnterCharacButton();
                }
            }
        });

        enterCharacButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!characterLabel.getText().isEmpty()) {
                    // If a character name is already displayed
                    // Hide the enterCharacButton
                    enterCharacButton.setVisible(false);
                    // Show the jobClassButton
                    jobClassButton.setVisible(true);
                } else {
                    // If no character name is displayed, show the card feature
                    if (cardFeature == null) {
                        cardFeature = new CardFeature(CharacCreation.this);
                        cardFeature.setCharacterSelectionListener(new CharacterSelectionListener() {
                            @Override
                            public void onCharacterSelected(String characterName) {
                                // Update the character label
                                updateCharacterLabel(characterName);
                                // Hide the enterCharacButton
                                enterCharacButton.setVisible(false);
                                // Show the jobClassButton
                                jobClassButton.setVisible(true);
                            }
                        });
                    }
                    cardFeature.setVisible(true);
                }
            }
        });           
        
        blankNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the EnterName window when the Blank Name button is clicked
                if (enterName == null) {
                    enterName = new EnterName();
                    enterName.setNameInputListener(CharacCreation.this); // Pass the listener instance
                }
                enterName.setVisible(true);
            }
        });

        jobClassButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the EnterName window when the Blank Name button is clicked
                if (cardFeature == null) {
                    cardFeature = new CardFeature(CharacCreation.this);
                }
                cardFeature.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open TitleScreen window when back button is clicked
                if (titleScreen == null) {
                    titleScreen = new TitleScreen();
                }
                titleScreen.setVisible(true);
            }
        });
    }

    public void onNameEntered(String name) {
        enteredName = name;
        updateEnterNameButton(); // Update the Enter Name button when name is entered
        updateNameLabel(); // Update the name label
    }

    private void updateNameLabel() {
        nameLabel.setText(enteredName);

        int fontSize;
        int xPos;

        if (enteredName.length() <= 15) {
            fontSize = 35;
            xPos = 45;
        } else if (enteredName.length() <= 19) {
            fontSize = 25;
            xPos = 40;
        } else {
            fontSize = 20;
            xPos = 35;
        }

        // Update the font size and x position of the name label
        Font font = new Font("Mantinia", Font.BOLD, fontSize);
        nameLabel.setFont(font);
        nameLabel.setBounds(xPos, 105, 400, 40); // Adjusted position based on the length of the entered name
    }

    private void updateEnterNameButton() {
        if (enteredName.isEmpty()) {
            // If no name is entered, set the Enter Name button visible and hide the Blank Name button
            enterNameButton.setVisible(true);
            blankNameButton.setVisible(false);
        } else {
            // If name is entered, hide the Enter Name button and set the text of the Blank Name button
            enterNameButton.setVisible(false);
            blankNameButton.setText(enteredName);
            blankNameButton.setVisible(true);
        }
    }

    public void updateEnterCharacButtonText(String text) {
        enterCharacButton.setText(text);
    }

    public void updateCharacterLabel(String characterName) {
        characterLabel.setText(characterName);
    }
    
    
    public static void main(String[] args) {
        new CharacCreation();
    }
    
}
