import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class EnterName extends JFrame{
    private static final String NORMAL_CONFIRM_PATH = "normalConfirm2.png";
    private static final String HOVER_CONFIRM_PATH = "hoverConfirm2.png";
    private static final String NORMAL_CANCEL_PATH = "normalCancel.png";
    private static final String HOVER_CANCEL_PATH = "hoverCancel.png";
    private JButton confirmButton;
    private JButton cancelButton;
    private JLabel Text;
    private JLabel background;
    private NameInputListener listener;
    private JTextField nameField; 

    public EnterName() {

        // Frame setup
        this.setTitle("Enter Name");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(480, 300);
        this.setLocationRelativeTo(null);
        
        // Background image
        ImageIcon backgroundImage = new ImageIcon("enterBackground.png");
        Image imgBackground = backgroundImage.getImage().getScaledInstance(480, 320, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(imgBackground);
        background = new JLabel("", scaledBackgroundImage, JLabel.CENTER);
        this.setContentPane(background);

        // Enter Name Text
        ImageIcon ENTextIcon = new ImageIcon("enterNameText.png");
        Image ENImage = ENTextIcon.getImage().getScaledInstance(227, 25, Image.SCALE_SMOOTH);
        ImageIcon ENText = new ImageIcon(ENImage);
        Text = new JLabel("", ENText, JLabel.CENTER);
        Text.setBounds(125, 55, 227, 25); 
        this.add(Text);

        // Create JTextField for name input
        nameField = new JTextField();
        nameField.setBounds(93, 110, 290, 36); // Set bounds (x, y, width, height)
        this.add(nameField);

        // Normal Confirm Button
        ImageIcon normalConfirmIcon = new ImageIcon(new ImageIcon(NORMAL_CONFIRM_PATH).getImage().getScaledInstance(135, 60, Image.SCALE_SMOOTH));
        Image scaledNormalConfirmImage = normalConfirmIcon.getImage().getScaledInstance(135, 60, Image.SCALE_SMOOTH);
        confirmButton = new JButton(new ImageIcon(scaledNormalConfirmImage));
        confirmButton.setBounds(97,170, 135, 60);
        confirmButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(confirmButton);

        // Normal Cancel Button
        ImageIcon normalCancelIcon = new ImageIcon(new ImageIcon(NORMAL_CANCEL_PATH).getImage().getScaledInstance(135, 60, Image.SCALE_SMOOTH));
        Image scaledNormalCancelImage = normalCancelIcon.getImage().getScaledInstance(135, 60, Image.SCALE_SMOOTH);
        cancelButton = new JButton(new ImageIcon(scaledNormalCancelImage));
        cancelButton.setBounds(247,170, 135, 60);
        cancelButton.setBorder(BorderFactory.createEmptyBorder());
        this.add(cancelButton);

        ImageIcon hoverConfirmIcon = new ImageIcon(new ImageIcon(HOVER_CONFIRM_PATH).getImage().getScaledInstance(135, 60, Image.SCALE_SMOOTH));
        ImageIcon hoverCancelIcon = new ImageIcon(new ImageIcon(HOVER_CANCEL_PATH).getImage().getScaledInstance(135, 60, Image.SCALE_SMOOTH));

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

        cancelButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
        
            @Override
            public void mousePressed(MouseEvent e) {}
        
            @Override
            public void mouseReleased(MouseEvent e) {}
        
            @Override
            public void mouseEntered(MouseEvent e) {
                cancelButton.setIcon(hoverCancelIcon);
            }
        
            @Override
            public void mouseExited(MouseEvent e) {
                cancelButton.setIcon(normalCancelIcon); 
            }
            });
        
            confirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText(); // Get the entered name from the JTextField
                    
                    // Check if the name exceeds the maximum limit of 25 characters
                    if (name.length() >= 25) {
                        // If the name is longer than 25 characters, truncate it
                        name = name.substring(0, 25);
                    }
                    
                    if (!name.isEmpty() && listener != null) {
                        listener.onNameEntered(name);
                        dispose(); // Close the EnterName window
                    }
                }
            });
    
            cancelButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose(); // Close the EnterName window when cancel button is clicked
                }
            });              

        this.setVisible(true);
    }

    public void setNameInputListener(NameInputListener listener) {
        this.listener = listener;
    }

    public static void main(String[] args) {
        new EnterName();
        
    }

    private void notifyCharacCreation(String name) {
        if (listener != null) {
            listener.onNameEntered(name);
        }
    }
}
