import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Inventory extends JFrame {
    private static final String BACK_BUTTON = "backButton.png";
    private JLabel Text;
    private JLabel background;
    private JButton backButton;
    private GameLobby gameLobby;

    public Inventory() {
        
        // Frame setup
        this.setTitle("Inventory");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(920, 580);
        this.setLocationRelativeTo(null);
 
        // Background image
        ImageIcon backgroundImage = new ImageIcon("optionBackground.png");
        Image imgBackground = backgroundImage.getImage().getScaledInstance(940, 580, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(imgBackground);
        background = new JLabel("", scaledBackgroundImage, JLabel.CENTER);
        this.setContentPane(background);

        // Back Button
        ImageIcon normalStartIcon = new ImageIcon(BACK_BUTTON);
        Image scaledNormalStartImage = normalStartIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        backButton = new JButton(new ImageIcon(scaledNormalStartImage));
        backButton.setBounds(22, 2, 70, 70); // Set button position and size
        backButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(backButton);

        // Inventory Text
        ImageIcon CCIcon = new ImageIcon("InventoryText.png");
        Image CCImage = CCIcon.getImage().getScaledInstance(172, 60, Image.SCALE_SMOOTH);
        ImageIcon CCText = new ImageIcon(CCImage);
        Text = new JLabel("", CCText, JLabel.CENTER);
        Text.setBounds(160, 8, 172, 60); 
        this.add(Text);

        // Owned Equipment Holder Image
        ImageIcon ownedInventoryImage = new ImageIcon("OwnedInventory.png");
        Image ownedInventory = ownedInventoryImage.getImage().getScaledInstance(600, 350, Image.SCALE_SMOOTH);
        ImageIcon scaledOwnedInventoryImage = new ImageIcon(ownedInventory);
        JLabel OILabel = new JLabel(scaledOwnedInventoryImage);
        OILabel.setBounds(158, 65, 600, 350); // Set the position of the title image
        this.add(OILabel);        
        
        // Title image on top
        ImageIcon titleImage = new ImageIcon("header.png");
        Image imgTitle = titleImage.getImage().getScaledInstance(940, 88, Image.SCALE_SMOOTH);
        ImageIcon scaledTitleImage = new ImageIcon(imgTitle);
        JLabel titleLabel = new JLabel(scaledTitleImage);
        titleLabel.setBounds(0, 0, 940, 80); // Set the position of the title image
        this.add(titleLabel);

        // Equipped Equipment Holder Image
        ImageIcon EquippedHolderImage = new ImageIcon("EquippedInventory.png");
        Image equippedholderheader = EquippedHolderImage.getImage().getScaledInstance(508, 120, Image.SCALE_SMOOTH);
        ImageIcon scaledEquippedHolderImage = new ImageIcon(equippedholderheader);
        JLabel EILabel = new JLabel(scaledEquippedHolderImage);
        EILabel.setBounds(205, 405, 508, 120); // Set the position of the title image
        this.add(EILabel);

        // Opacity Background image
        ImageIcon backgroundImage1 = new ImageIcon("CharacBG.png");
        Image imgBackground1 = backgroundImage1.getImage().getScaledInstance(920, 580, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage1 = new ImageIcon(imgBackground1);
        JLabel backLabel = new JLabel(scaledBackgroundImage1);
        backLabel.setBounds(0, 0, 920, 580); // Set the position of the title image
        this.add(backLabel);

        this.setVisible(true);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open TitleScreen window when back button is clicked
                if (gameLobby == null) {
                    gameLobby = new GameLobby("DefaultName", "DefaultCharacter");
                }
                gameLobby.setVisible(true);
            }
        });
    }
    public static void main(String[] args) {
        new Inventory();
        
    }
}
