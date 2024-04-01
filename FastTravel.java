import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class FastTravel extends JFrame {
    private static final String NORMAL_STORMVEIL_PATH = "StormNormal.png";
    private static final String HOVER_STORMVEIL_PATH = "StormHover.png";
    private static final String NOTCLEARED_RAYA_PATH = "RayaNotCleared.png";
    // private static final String HOVER_STORMVEIL_PATH = "StormHover.png";
    private static final String BACK_BUTTON = "backButton.png";
    private static final String FAST_TRAVEL_TEXT = "FastTravelText.png";
    private JButton NormalStormButton;
    private JButton NCRayaButton;
    private JButton backButton;
    private JButton fastTravelTextButton;
       
    public FastTravel() {
        JLabel background;

        // Frame setup
        this.setTitle("Fast Travel");
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
        ImageIcon backIcon = new ImageIcon(BACK_BUTTON);
        Image scaledBackImage = backIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        backButton = new JButton(new ImageIcon(scaledBackImage));
        backButton.setBounds(22, 2, 70, 70); // Set button position and size
        backButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(backButton);

        // Fast Travel Text Button
        ImageIcon fastTravelIcon = new ImageIcon(FAST_TRAVEL_TEXT);
        Image scaledFastTravelImage = fastTravelIcon.getImage().getScaledInstance(170, 55, Image.SCALE_SMOOTH);
        fastTravelTextButton = new JButton(new ImageIcon(scaledFastTravelImage));
        fastTravelTextButton.setBounds(150, 8, 170, 55); // Set button position and size
        fastTravelTextButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(fastTravelTextButton);

        // Elden Throne image
        ImageIcon throneImage = new ImageIcon("EldenThrone.png");
        Image scaledThroneImage = throneImage.getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH);
        ImageIcon scaledETImage = new ImageIcon(scaledThroneImage);
        JLabel ETLabel = new JLabel(scaledETImage);
        ETLabel.setBounds(692, 42, 180, 160); // Set the position of the title image
        this.add(ETLabel);

        // Echoes of Elden image
        ImageIcon echoesImage = new ImageIcon("EchoesOfElden.png");
        Image scaledEchoesImage = echoesImage.getImage().getScaledInstance(420, 490, Image.SCALE_SMOOTH);
        ImageIcon scaledEOEImage = new ImageIcon(scaledEchoesImage);
        JLabel eoeLabel = new JLabel(scaledEOEImage);
        eoeLabel.setBounds(15, 55, 420, 490); // Set the position of the title image
        this.add(eoeLabel);

        // Not Cleared Raya Lucaria Button
        ImageIcon UnclearedRayaIcon = new ImageIcon(new ImageIcon(NOTCLEARED_RAYA_PATH).getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH));
        NCRayaButton = new JButton(UnclearedRayaIcon);
        NCRayaButton.setBounds(447, 94, 180, 160); // Set button position and size
        NCRayaButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(NCRayaButton);
        
        // Normal Stormveil Button
        ImageIcon normalStormIcon = new ImageIcon(new ImageIcon(NORMAL_STORMVEIL_PATH).getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH));
        NormalStormButton = new JButton(normalStormIcon);
        NormalStormButton.setBounds(620, 320, 180, 160); // Set button position and size
        NormalStormButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(NormalStormButton);

        // Map image
        ImageIcon mapImage = new ImageIcon("EldenMap.png");
        Image scaledMapImage = mapImage.getImage().getScaledInstance(530, 560, Image.SCALE_SMOOTH);
        ImageIcon scaledMapImageIcon = new ImageIcon(scaledMapImage);
        JLabel mapLabel = new JLabel(scaledMapImageIcon);
        mapLabel.setBounds(390, 0, 530, 560); // Set the position of the title image
        this.add(mapLabel);

        // Opacity Background image
        ImageIcon backgroundImage1 = new ImageIcon("CharacBG.png");
        Image imgBackground1 = backgroundImage1.getImage().getScaledInstance(920, 580, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage1 = new ImageIcon(imgBackground1);
        JLabel backLabel = new JLabel(scaledBackgroundImage1);
        backLabel.setBounds(0, 0, 920, 580); // Set the position of the title image
        this.add(backLabel);
        
        // Title image on top
        ImageIcon titleImage = new ImageIcon("header.png");
        Image imgTitle = titleImage.getImage().getScaledInstance(940, 92, Image.SCALE_SMOOTH);
        ImageIcon scaledTitleImage = new ImageIcon(imgTitle);
        JLabel titleLabel = new JLabel(scaledTitleImage);
        titleLabel.setBounds(0, 0, 930, 80); // Set the position of the title image
        this.add(titleLabel);

        

        // Preload the hover icons with scaled dimensions
        ImageIcon hoverStormIcon = new ImageIcon(new ImageIcon(HOVER_STORMVEIL_PATH).getImage().getScaledInstance(180, 160, Image.SCALE_SMOOTH));

        NormalStormButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
        
            @Override
            public void mousePressed(MouseEvent e) {}
        
            @Override
            public void mouseReleased(MouseEvent e) {}
        
            @Override
            public void mouseEntered(MouseEvent e) {
                NormalStormButton.setIcon(hoverStormIcon);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                NormalStormButton.setIcon(normalStormIcon); // Reset to normal icon when mouse exits
            }
            });


        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FastTravel();    
    }
}
