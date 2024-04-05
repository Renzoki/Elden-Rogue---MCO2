import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FastTravel extends JFrame {
    private static final String NORMAL_STORMVEIL_PATH = "StormNormal.png";
    private static final String NOTCLEARED_STORMVEIL_PATH = "NCStorm.png";
    private static final String HOVER_STORMVEIL_PATH = "StormHover.png";
    private static final String NOTCLEARED_RAYA_PATH = "RayaNotCleared.png";
    private static final String NORMAL_RAYA_PATH = "RayaNormal.png";
    private static final String HOVER_RAYA_PATH = "RayaHover.png";
    private static final String LOCKED_ELDENTHRONE_PATH = "lockedEldenThrone.png";
    // private static final String NOTCLEARED_ELDENTHRONE_PATH = "notclearedEldenThrone.png";
    // private static final String NORMAL_ELDENTHRONE_PATH = "normalEldenThrone.png";
    // private static final String HOVER_ELDENTHRONE_PATH = "hoverEldenThrone.png";
    private JButton NormalStormButton;
    private JButton NormalRayaButton;
    private JButton NCRayaButton;
    private JButton NCStormButton;
    private JButton lockedThroneButton;
    private JButton backButton;
    private JLabel fastTravelText;
    private GameLobby gameLobby;
    private MouseListener normalStormMouseListener;
    private MouseListener normalRayaMouseListener;
    private boolean isNormal = false;
    private FTConstants ftconstants;
    private JLabel background;
    private JLabel eoeLabel;
    private JLabel mapLabel;
    private JLabel opacityBGLabel;
    private JLabel titleLabel;

    public FastTravel() {
        this.ftconstants = new FTConstants();
        
        // Frame setup
        this.setTitle("Fast Travel");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(920, 580);
        this.setLocationRelativeTo(null);

        // Background image
        this.background = ftconstants.getFTBackground();
        this.setContentPane(background);

        // Back Button
        this.backButton = ftconstants.getbackButton();
        this.add(backButton);

        // Fast Travel Text
        this.fastTravelText = ftconstants.getFTText();
        this.add(fastTravelText);

        // Locked Button
        ImageIcon throneImage = new ImageIcon(new ImageIcon(LOCKED_ELDENTHRONE_PATH).getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH));
        lockedThroneButton = new JButton(throneImage);
        lockedThroneButton.setBounds(692, 45, 180, 160); // Set button position and size
        lockedThroneButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(lockedThroneButton);

        // Echoes of Elden image
        this.eoeLabel = ftconstants.getEchoesofElden();
        this.add(eoeLabel);

        // Not Cleared Raya Lucaria Button
        ImageIcon UnclearedRayaIcon = new ImageIcon(new ImageIcon(NOTCLEARED_RAYA_PATH).getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH));
        NCRayaButton = new JButton(UnclearedRayaIcon);
        NCRayaButton.setBounds(447, 94, 180, 160); // Set button position and size
        NCRayaButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(NCRayaButton);

        // Normal Raya Lucaria Button initially hidden
        ImageIcon normalRayaIcon = new ImageIcon(new ImageIcon(NORMAL_RAYA_PATH).getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH));
        NormalRayaButton = new JButton(normalRayaIcon);
        NormalRayaButton.setBounds(447, 94, 180, 160); // Set button position and size
        NormalRayaButton.setBorder(BorderFactory.createEmptyBorder());
        NormalRayaButton.setVisible(false); // Initially hidden
        this.add(NormalRayaButton);

        // Not Cleared Stormveil Button
        ImageIcon unclearedStormIcon = new ImageIcon(new ImageIcon(NOTCLEARED_STORMVEIL_PATH).getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH));
        NCStormButton = new JButton(unclearedStormIcon);
        NCStormButton.setBounds(620, 320, 180, 160); // Set button position and size
        NCStormButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(NCStormButton);

        // Normal Stormveil Button initially hidden
        ImageIcon normalStormIcon = new ImageIcon(new ImageIcon(NORMAL_STORMVEIL_PATH).getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH));
        NormalStormButton = new JButton(normalStormIcon);
        NormalStormButton.setBounds(620, 320, 180, 160); // Set button position and size
        NormalStormButton.setBorder(BorderFactory.createEmptyBorder());
        NormalStormButton.setVisible(false); // Initially hidden
        this.add(NormalStormButton);

        // Map image
        this.mapLabel = ftconstants.getMapImage();
        this.add(mapLabel);

        // Opacity Background image
        this.opacityBGLabel = ftconstants.getOpacityBG();
        this.add(opacityBGLabel);

        // Title image on top
        this.titleLabel = ftconstants.getTitleIMG();
        this.add(titleLabel);

        ImageIcon hoverUnclearedStormIcon = new ImageIcon(new ImageIcon(HOVER_STORMVEIL_PATH).getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH));
        ImageIcon hoverNormalStormIcon = new ImageIcon(new ImageIcon(HOVER_STORMVEIL_PATH).getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH));
        ImageIcon hoverUnclearedRayaIcon = new ImageIcon(new ImageIcon(HOVER_RAYA_PATH).getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH));
        ImageIcon hoverNormalRayaIcon = new ImageIcon(new ImageIcon(HOVER_RAYA_PATH).getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH));

        NCStormButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle between uncleared and normal storm button
                if (!isNormal) {
                    NCStormButton.setVisible(false);
                    NormalStormButton.setVisible(true);
                    isNormal = true;
                    NCStormButton.removeMouseListener(this); // Remove the listener after it's clicked once
                    NormalStormButton.addMouseListener(normalStormMouseListener); // Add the listener to the normal button
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                NCStormButton.setIcon(hoverUnclearedStormIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                NCStormButton.setIcon(unclearedStormIcon); // Reset to normal icon when mouse exits
            }
        });

        normalStormMouseListener = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                NormalStormButton.setIcon(hoverNormalStormIcon);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                NormalStormButton.setIcon(normalStormIcon); // Reset to normal icon when mouse exits
            }
        };
        

        // Add the listener to the normal button initially
        NormalStormButton.addMouseListener(normalStormMouseListener);

        NCRayaButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Toggle between uncleared and normal storm button
                if (!isNormal) {
                    NCRayaButton.setVisible(false);
                    NormalRayaButton.setVisible(true);
                    isNormal = true;
                    NCRayaButton.removeMouseListener(this); // Remove the listener after it's clicked once
                    NormalRayaButton.addMouseListener(normalRayaMouseListener); // Add the listener to the normal button
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                NCRayaButton.setIcon(hoverUnclearedRayaIcon);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                NCRayaButton.setIcon(unclearedStormIcon); // Reset to normal icon when mouse exits
            }
        });

        normalRayaMouseListener = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                NormalRayaButton.setIcon(hoverNormalRayaIcon);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                NormalRayaButton.setIcon(normalRayaIcon); // Reset to normal icon when mouse exits
            }
        };
        

        // Add the listener to the normal button initially
        NormalRayaButton.addMouseListener(normalRayaMouseListener);

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
        new FastTravel();
    }
}
