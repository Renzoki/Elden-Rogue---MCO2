import javax.swing.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class CardFeature extends JFrame {
    private static final String[] BIG_IMAGE_PATHS = {
            "bigVagabond.png",
            "bigSamurai.png",
            "bigWarrior.png",
            "bigHero.png",
            "bigAstrologer.png",
            "bigProphet.png"
    };

    private static final String[] HOVER_IMAGE_PATHS = {
            "hoverVagabond.png",
            "hoverSamurai.png",
            "hoverWarrior.png",
            "hoverHero.png",
            "hoverAstrologer.png",
            "hoverProphet.png"
    };

    private List<JButton> buttons;
    private int currentIndex = 0;
    private CharacCreation characCreation;
    private CCConstants constants;
    private CharacterSelectionListener characterSelectionListener;

    public CardFeature(CharacCreation characCreation) {
        // Frame setup
        this.setTitle("Select Character");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setSize(750, 500);
        this.setLocationRelativeTo(null);

        this.characCreation = characCreation;
        this.constants = new CCConstants(); 

        // Initialize buttons list
        buttons = new ArrayList<>();

        // Add buttons to the list
        for (int i = 0; i < BIG_IMAGE_PATHS.length; i++) {
            addButton(BIG_IMAGE_PATHS[i], HOVER_IMAGE_PATHS[i], getCharacterName(i));
        }

        // Previous Button
        JButton previousButton = constants.getPreviousButton();
        previousButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex - 1 + buttons.size()) % buttons.size();
                setButtonIcon(currentIndex);
            }
        });
        this.add(previousButton);

        // Next Button
        JButton nextButton = constants.getNextButton();
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentIndex = (currentIndex + 1) % buttons.size();
                setButtonIcon(currentIndex);
            }
        });
        this.add(nextButton);

        // Set the initial button display
        setButtonIcon(currentIndex);

        this.setLayout(null);
    }

    private void addButton(String imagePath, String hoverImagePath, String characterName) {
        ImageIcon icon = new ImageIcon(imagePath);
        ImageIcon hoverIcon = new ImageIcon(hoverImagePath);

        // Scale the images to fit the button size
        Image scaledIcon = icon.getImage().getScaledInstance(400, 460, Image.SCALE_SMOOTH);
        Image scaledHoverIcon = hoverIcon.getImage().getScaledInstance(400, 460, Image.SCALE_SMOOTH);

        // Create ImageIcon objects with scaled images
        ImageIcon scaledIconImage = new ImageIcon(scaledIcon);
        ImageIcon scaledHoverIconImage = new ImageIcon(scaledHoverIcon);

        JButton button = new JButton(scaledIconImage);
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false); // Ensure the button does not paint the background
        button.setBounds(172, 5, 400, 460);

        // Mouse listener for hover effect
        button.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {}
            public void mousePressed(MouseEvent e) {}
            public void mouseReleased(MouseEvent e) {}
            public void mouseEntered(MouseEvent e) {
                button.setIcon(scaledHoverIconImage);
            }
            public void mouseExited(MouseEvent e) {
                button.setIcon(scaledIconImage);
            }
        });

        // ActionListener for button click event
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the CardFeature window
                dispose();

                // Update the characterLabel in CharacCreation
                characCreation.updateCharacterLabel(characterName);

                // Change the Enter Character button text to "Job Class"
                characCreation.updateEnterCharacButtonText("Job Class");
            }
        });

        buttons.add(button);
        this.add(button);
    }

    private void setButtonIcon(int index) {
        for (int i = 0; i < buttons.size(); i++) {
            JButton button = buttons.get(i);
            button.setVisible(i == index);
        }
    }

    private String getCharacterName(int index) {
        switch (index) {
            case 0:
                return "vagabond";
            case 1:
                return "samurai";
            case 2:
                return "warrior";
            case 3:
                return "hero";
            case 4:
                return "astrologer";
            case 5:
                return "prophet";
            default:
                return "";
        }
    }
    
    public void setCharacterSelectionListener(CharacterSelectionListener listener) {
        this.characterSelectionListener = listener;
    }
}
