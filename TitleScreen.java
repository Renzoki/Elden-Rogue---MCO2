import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TitleScreen extends JFrame {
    private static final String NORMAL_START_PATH = "normalStart.png";
    private static final String HOVER_START_PATH = "hoverStart.png";
    private static final String NORMAL_QUIT_PATH = "normalQuit.png";
    private static final String HOVER_QUIT_PATH = "hoverQuit.png";
    private static final String CLICK_SOUND_PATH = "The Final Battle (Elden Ring Soundtrack) (feat. Reven).wav"; // Path to your sound file
    private JButton startButton;
    private JButton quitButton;
    private CharacCreation characterCreation;
    private Clip clickSound;

    public TitleScreen() {
        // Frame setup
        this.setTitle("Title Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(920, 580);
        this.setLocationRelativeTo(null);

        loadClickSound();

        // Background image
        ImageIcon backgroundImage = new ImageIcon("eldenbackground.png");
        Image imgBackground = backgroundImage.getImage().getScaledInstance(920, 580, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(imgBackground);
        JLabel background = new JLabel("", scaledBackgroundImage, JLabel.CENTER);
        this.setContentPane(background);

        // Title image on top
        ImageIcon titleImage = new ImageIcon("eldentext.png");
        Image imgTitle = titleImage.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        ImageIcon scaledTitleImage = new ImageIcon(imgTitle);
        JLabel titleLabel = new JLabel(scaledTitleImage);
        titleLabel.setBounds(138, 65, 630, 290); // Set the position of the title image
        this.add(titleLabel);

        // Normal Start Game Button
        ImageIcon normalStartIcon = new ImageIcon(new ImageIcon(NORMAL_START_PATH).getImage().getScaledInstance(240, 70, Image.SCALE_SMOOTH));
        Image scaledNormalStartImage = normalStartIcon.getImage().getScaledInstance(240, 70, Image.SCALE_SMOOTH);
        startButton = new JButton(new ImageIcon(scaledNormalStartImage));
        startButton.setBounds(344, 320, 240, 70); // Set button position and size
        startButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(startButton);

        // Normal Quit Game Button
        ImageIcon normalQuitIcon = new ImageIcon(new ImageIcon(NORMAL_QUIT_PATH).getImage().getScaledInstance(240, 70, Image.SCALE_SMOOTH));
        Image scaledNormalQuitImage = normalQuitIcon.getImage().getScaledInstance(240, 70, Image.SCALE_SMOOTH);
        quitButton = new JButton(new ImageIcon(scaledNormalQuitImage));
        quitButton.setBounds(350, 387, 240, 70);
        quitButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(quitButton);

        // Preload the hover icons with scaled dimensions
        ImageIcon hoverStartIcon = new ImageIcon(new ImageIcon(HOVER_START_PATH).getImage().getScaledInstance(240, 70, Image.SCALE_SMOOTH));
        ImageIcon hoverQuitIcon = new ImageIcon(new ImageIcon(HOVER_QUIT_PATH).getImage().getScaledInstance(240, 70, Image.SCALE_SMOOTH));


    
        startButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
        
            @Override
            public void mousePressed(MouseEvent e) {}
        
            @Override
            public void mouseReleased(MouseEvent e) {}
        
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(hoverStartIcon);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(normalStartIcon); 
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


        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open CharacterCreation window when start button is clicked
                if (characterCreation == null) {
                    characterCreation = new CharacCreation();
                }
                characterCreation.setVisible(true);
            }
        });

        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application when quit button is clicked
                System.exit(0);
            }
        });
        playClickSound(); // Automatically play the click sound

        this.setVisible(true);
    }

    private void loadClickSound() {
        try {
            File soundFile = new File(CLICK_SOUND_PATH);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clickSound = AudioSystem.getClip();
            clickSound.open(audioInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void playClickSound() {
        if (clickSound != null) {
            clickSound.setFramePosition(0); // Rewind the sound
            clickSound.start(); // Play the sound
        }
    }
} 