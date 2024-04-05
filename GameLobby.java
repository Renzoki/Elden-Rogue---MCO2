import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class GameLobby extends JFrame {
    private static final String NORMAL_FAST_PATH = "normalFast.png";
    private static final String HOVER_FAST_PATH = "hoverFast.png";
    private static final String NORMAL_INVENTORY_PATH = "normalInventory.png";
    private static final String HOVER_INVENTORY_PATH = "hoverInventory.png";
    private static final String NORMAL_LEVELUP_PATH = "normalLevelUp.png";
    private static final String HOVER_LEVELUP_PATH = "hoverLevelUp.png";
    private static final String NORMAL_SHOP_PATH = "normalShop.png";
    private static final String HOVER_SHOP_PATH = "hoverShop.png";
    private static final String NORMAL_GLQUIT_PATH = "normalButQuit.png";
    private static final String HOVER_GLQUIT_PATH = "hoverButQuit.png";
    private JButton fastButton;
    private JButton levelUpButton;
    private JButton inventoryButton;
    private JButton quitButton;
    private JButton shopButton;
    private JLabel background;
    private FastTravel fastTravel;
    private LevelUp levelUp;
    private Inventory inventory;
    private TitleScreen titleScreen;
    private Shop shop;
    private String enteredName; // To store the entered name
    private String selectedCharacter; // To store the selected character
    private JLabel nameLabel;
    private JLabel characterLabel;
    private JLabel levelLabel;
    private JLabel levelnumberLabel;


    public GameLobby(String enteredName, String selectedCharacter) {
        this.enteredName = enteredName;
        this.selectedCharacter = selectedCharacter;

        // Frame setup
        this.setTitle("Game Lobby");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(920, 580);
        this.setLocationRelativeTo(null);
 
        // Background image
        ImageIcon backgroundImage = new ImageIcon("gameLobbyBackground.jpeg");
        Image imgBackground = backgroundImage.getImage().getScaledInstance(920, 580, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(imgBackground);
        background = new JLabel("", scaledBackgroundImage, JLabel.CENTER);
        this.setContentPane(background);

        // Title image on top
        ImageIcon titleImage = new ImageIcon("GameHeader.png");
        Image imgTitle = titleImage.getImage().getScaledInstance(940, 72, Image.SCALE_SMOOTH);
        ImageIcon scaledTitleImage = new ImageIcon(imgTitle);
        JLabel titleLabel = new JLabel(scaledTitleImage);
        titleLabel.setBounds(0, 0, 930, 72); // Set the position of the title image
        this.add(titleLabel);

        // Initialize the JLabel for displaying the entered name
        nameLabel = new JLabel();
        nameLabel.setFont(new Font("Mantinia", Font.BOLD, 40));
        nameLabel.setForeground(Color.decode("#AC9D73")); // Set text color
        nameLabel.setBounds(45, 80, 400, 40); // Set position and size
        this.add(nameLabel);

        // Initialize the JLabel for displaying the entered name
        characterLabel = new JLabel();
        characterLabel.setFont(new Font("Mantinia", Font.BOLD, 40));
        characterLabel.setForeground(Color.decode("#AC9D73")); // Set text color
        characterLabel.setBounds(685, 80, 400, 40); // Set position and size
        this.add(characterLabel);

        levelLabel = new JLabel();
        levelLabel.setFont(new Font("Playfair Display", Font.BOLD, 13));
        levelLabel.setForeground(Color.decode("#AC9D73")); // Set text color
        levelLabel.setBounds(340, 77, 400, 40); // Set position and size
        this.add(levelLabel);

        levelnumberLabel = new JLabel();
        levelnumberLabel.setFont(new Font("Playfair Display", Font.BOLD, 13));
        levelnumberLabel.setForeground(Color.decode("#AC9D73")); // Set text color
        levelnumberLabel.setBounds(418, 77, 400, 40); // Set position and size
        this.add(levelnumberLabel);
        
        nameLabel.setText(enteredName);
        characterLabel.setText(selectedCharacter);
        levelLabel.setText("Level :");
        levelnumberLabel.setText("5");

        // Calculate the x-position based on the number of digits in the level number
        String levelText = levelnumberLabel.getText();
        int level = Integer.parseInt(levelText);
        int numDigits = levelText.length();
        int xPos = 438 - (numDigits - 1) * 10;
        levelnumberLabel.setBounds(xPos, 77, 400, 40);

        // Second Header
        ImageIcon headerImage = new ImageIcon("GameHeader2.png");
        Image imgheader = headerImage.getImage().getScaledInstance(940, 110, Image.SCALE_SMOOTH);
        ImageIcon scaledHeaderImage = new ImageIcon(imgheader);
        JLabel headerLabel = new JLabel(scaledHeaderImage);
        headerLabel.setBounds(0, 28, 930, 110); // Set the position of the title image
        this.add(headerLabel);

        // Normal Fast Travel Button
        ImageIcon normalFastIcon = new ImageIcon(new ImageIcon(NORMAL_FAST_PATH).getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH));
        Image scaledNormalFastImage = normalFastIcon.getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH);
        fastButton = new JButton(new ImageIcon(scaledNormalFastImage));
        fastButton.setBounds(200, 220, 240, 95); // Set button position and size
        fastButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(fastButton);

        // Normal Inventory Button
        ImageIcon normalInventoryIcon = new ImageIcon(new ImageIcon(NORMAL_INVENTORY_PATH).getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH));
        Image scaledNormalInventoryImage = normalInventoryIcon.getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH);
        inventoryButton = new JButton(new ImageIcon(scaledNormalInventoryImage));
        inventoryButton.setBounds(200,305, 240, 95);
        inventoryButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(inventoryButton);

        // Normal Game Lobby Quit Game Button
        ImageIcon normalQuitIcon = new ImageIcon(new ImageIcon(NORMAL_GLQUIT_PATH).getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH));
        Image scaledNormalQuitImage = normalQuitIcon.getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH);
        quitButton = new JButton(new ImageIcon(scaledNormalQuitImage));
        quitButton.setBounds(343, 395, 240, 95);
        quitButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(quitButton);

        // Normal Level Up Button
        ImageIcon normalLevelUpIcon = new ImageIcon(new ImageIcon(NORMAL_LEVELUP_PATH).getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH));
        Image scaledNormalLevelUpImage = normalLevelUpIcon.getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH);
        levelUpButton = new JButton(new ImageIcon(scaledNormalLevelUpImage));
        levelUpButton.setBounds(480,220, 240, 95);
        levelUpButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(levelUpButton);

        // Normal Shop Button
        ImageIcon normalShopIcon = new ImageIcon(new ImageIcon(NORMAL_SHOP_PATH).getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH));
        Image scaledNormalShopImage = normalShopIcon.getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH);
        shopButton = new JButton(new ImageIcon(scaledNormalShopImage));
        shopButton.setBounds(480,305, 240, 95);
        shopButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(shopButton);

        // Preload the hover icons with scaled dimensions
        ImageIcon hoverFastIcon = new ImageIcon(new ImageIcon(HOVER_FAST_PATH).getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH));
        ImageIcon hoverInventoryIcon = new ImageIcon(new ImageIcon(HOVER_INVENTORY_PATH).getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH));
        ImageIcon hoverQuitIcon = new ImageIcon(new ImageIcon(HOVER_GLQUIT_PATH).getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH));
        ImageIcon hoverLevelUpIcon = new ImageIcon(new ImageIcon(HOVER_LEVELUP_PATH).getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH));
        ImageIcon hoverShopIcon = new ImageIcon(new ImageIcon(HOVER_SHOP_PATH).getImage().getScaledInstance(240, 95, Image.SCALE_SMOOTH));

        fastButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
        
            @Override
            public void mousePressed(MouseEvent e) {}
        
            @Override
            public void mouseReleased(MouseEvent e) {}
        
            @Override
            public void mouseEntered(MouseEvent e) {
                fastButton.setIcon(hoverFastIcon);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                fastButton.setIcon(normalFastIcon); 
            }
            });

        inventoryButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
        
            @Override
            public void mousePressed(MouseEvent e) {}
        
            @Override
            public void mouseReleased(MouseEvent e) {}
        
            @Override
            public void mouseEntered(MouseEvent e) {
                inventoryButton.setIcon(hoverInventoryIcon);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                inventoryButton.setIcon(normalInventoryIcon); 
            }
        });

        quitButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
        
            @Override
            public void mousePressed(MouseEvent e) {}
        
            @Override
            public void mouseReleased(MouseEvent e) {}
        
            @Override
            public void mouseEntered(MouseEvent e) {
                quitButton.setIcon(hoverQuitIcon);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                quitButton.setIcon(normalQuitIcon); 
            }
        });

        levelUpButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
        
            @Override
            public void mousePressed(MouseEvent e) {}
        
            @Override
            public void mouseReleased(MouseEvent e) {}
        
            @Override
            public void mouseEntered(MouseEvent e) {
                levelUpButton.setIcon(hoverLevelUpIcon);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                levelUpButton.setIcon(normalLevelUpIcon); 
            }
        });

        shopButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
        
            @Override
            public void mousePressed(MouseEvent e) {}
        
            @Override
            public void mouseReleased(MouseEvent e) {}
        
            @Override
            public void mouseEntered(MouseEvent e) {
                shopButton.setIcon(hoverShopIcon);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                shopButton.setIcon(normalShopIcon); 
            }
        });

        // Option Frame
        ImageIcon OptionFrameImage = new ImageIcon("GameoptionFrame.png");
        Image optionHeader = OptionFrameImage.getImage().getScaledInstance(870, 415, Image.SCALE_SMOOTH);
        ImageIcon scaledOptionImage = new ImageIcon(optionHeader);
        JLabel optionLabel = new JLabel(scaledOptionImage);
        optionLabel.setBounds(28, 80, 870, 515); // Set the position of the title image
        this.add(optionLabel);

        // Opacity Background image
        ImageIcon backgroundImage1 = new ImageIcon("CharacBG.png");
        Image imgBackground1 = backgroundImage1.getImage().getScaledInstance(950, 580, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage1 = new ImageIcon(imgBackground1);
        JLabel backLabel = new JLabel(scaledBackgroundImage1);
        backLabel.setBounds(0, 0, 920, 580); // Set the position of the title image
        this.add(backLabel);

        fastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open fastTravel window when fast button is clicked
                if (fastTravel == null) {
                    fastTravel = new FastTravel();
                }
                fastTravel.setVisible(true);
            }
        });

        levelUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open fastTravel window when fast button is clicked
                if (levelUp == null) {
                    levelUp = new LevelUp();
                }
                levelUp.setVisible(true);
            }
        });

        shopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open fastTravel window when fast button is clicked
                if (shop == null) {
                    shop = new Shop();
                }
                shop.setVisible(true);
            }
        });

        inventoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (inventory == null) {
                    inventory = new Inventory();
                }
                inventory.setVisible(true);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open fastTravel window when fast button is clicked
                if (titleScreen == null) {
                    titleScreen = new TitleScreen();
                }
                titleScreen.setVisible(true);
            }
        });

        this.setVisible(true);
    }
}
