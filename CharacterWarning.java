import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CharacterWarning extends JFrame{
    private static final String NORMAL_OKAY_PATH = "normalOkay.png";
    private static final String HOVER_OKAY_PATH = "hoverOkay.png";
    JButton okayButton;
    private JLabel Text;
    private JLabel background;

    public CharacterWarning() {

        // Frame setup
        this.setTitle("Warning");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(480, 300);
        this.setLocationRelativeTo(null);
        
        // Background image
        ImageIcon backgroundImage = new ImageIcon("WarningBG.png");
        Image imgBackground = backgroundImage.getImage().getScaledInstance(485, 320, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(imgBackground);
        background = new JLabel("", scaledBackgroundImage, JLabel.CENTER);
        this.setContentPane(background);

        // Enter Name Text
        ImageIcon ENTextIcon = new ImageIcon("CharacterTextWarning.png");
        Image ENImage = ENTextIcon.getImage().getScaledInstance(295, 85, Image.SCALE_SMOOTH);
        ImageIcon ENText = new ImageIcon(ENImage);
        Text = new JLabel("", ENText, JLabel.CENTER);
        Text.setBounds(89, 77, 295, 85); 
        this.add(Text);

        // Normal Okay Button
        ImageIcon normalOkayIcon = new ImageIcon(new ImageIcon(NORMAL_OKAY_PATH).getImage().getScaledInstance(135, 60, Image.SCALE_SMOOTH));
        Image scaledNormalOkayImage = normalOkayIcon.getImage().getScaledInstance(135, 60, Image.SCALE_SMOOTH);
        okayButton = new JButton(new ImageIcon(scaledNormalOkayImage));
        okayButton.setBounds(173,170, 135, 60);
        okayButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(okayButton);

        ImageIcon hoverOkayIcon = new ImageIcon(new ImageIcon(HOVER_OKAY_PATH).getImage().getScaledInstance(135, 60, Image.SCALE_SMOOTH));

        okayButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
        
            @Override
            public void mousePressed(MouseEvent e) {}
        
            @Override
            public void mouseReleased(MouseEvent e) {}
        
            @Override
            public void mouseEntered(MouseEvent e) {
                okayButton.setIcon(hoverOkayIcon);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                okayButton.setIcon(normalOkayIcon); 
            }
        });
        
            okayButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose(); // Close the EnterName window when cancel button is clicked
                }
            });        

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new CharacterWarning();
        
    }
}
