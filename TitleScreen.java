import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TitleScreen extends JFrame {
    JButton button;
    
    public TitleScreen() {
        JLabel background;

        // Frame setup
        this.setTitle("Title Screen");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(920, 580);
        
        // Background image
        ImageIcon backgroundImage = new ImageIcon("eldenbackground.png");
        Image imgBackground = backgroundImage.getImage().getScaledInstance(920, 580, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(imgBackground);
        background = new JLabel("", scaledBackgroundImage, JLabel.CENTER);
        this.setContentPane(background);
        
        // Title image on top
        ImageIcon titleImage = new ImageIcon("eldentext.png");
        Image imgTitle = titleImage.getImage().getScaledInstance(700, 420, Image.SCALE_SMOOTH);
        ImageIcon scaledTitleImage = new ImageIcon(imgTitle);
        JLabel titleLabel = new JLabel(scaledTitleImage);
        titleLabel.setBounds(185, 0, 550, 280); // Set the position and size of the title image
        this.add(titleLabel);
        
        this.setVisible(true);
    }
    
    public void paint(Graphics g) {
        //Start Game
        super.paint(g);
        String text = "Start Game";
        Font textFont = new Font("Mantinia", Font.BOLD, 36);
        //Its shadow color
        g.setColor(Color.BLACK);
        g.drawString(text, 400, 800);
        //Its main color
        g.setColor(Color.decode("#C6A764"));
        g.setFont(textFont);
        g.drawString(text, 340, 380); // Adjust the position of the text as needed
    }

    public static void main(String[] args) {
        new TitleScreen();
    }
}
