import javax.swing.*;
import java.awt.Image;

public class CCConstants {
    private static final String BACK_BUTTON = "backButton.png";
    private static final String PREVIOUS_BUTTON = "prevButton.png";
    private static final String NEXT_BUTTON = "nextButton.png";
    private JButton backButton;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel Text;
    private JLabel headerLabel;
    private JLabel titleLabel;
    private JLabel opacityBGLabel;

    public CCConstants(){
        setbackButton();
        setCCText();
        setHeaderIMG();
        setTitleIMG();
        setPreviousButton();
        setNextButton();
        setOpacityBG();
    }

    private void setbackButton(){
        // Back Button
        ImageIcon normalStartIcon = new ImageIcon(BACK_BUTTON);
        Image scaledNormalStartImage = normalStartIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        backButton = new JButton(new ImageIcon(scaledNormalStartImage));
        backButton.setBounds(22, 2, 70, 70); // Set button position and size
        backButton.setBorder(BorderFactory.createEmptyBorder());
    }

    private void setCCText(){
        // Character Creation Text
        ImageIcon CCIcon = new ImageIcon("CharacCreationText.png");
        Image CCImage = CCIcon.getImage().getScaledInstance(360, 60, Image.SCALE_SMOOTH);
        ImageIcon CCText = new ImageIcon(CCImage);
        Text = new JLabel("", CCText, JLabel.CENTER);
        Text.setBounds(150, 8, 360, 60);
    }

    private void setHeaderIMG(){
        // Header IMG 2
        ImageIcon headerImage = new ImageIcon("characHeader2.png");
        Image headerTitle = headerImage.getImage().getScaledInstance(928, 105, Image.SCALE_SMOOTH);
        ImageIcon scaledheaderImage = new ImageIcon(headerTitle);
        headerLabel = new JLabel(scaledheaderImage); // Assign to the class-level variable
        headerLabel.setBounds(0, 65, 925, 102); // Set the position of the title image
    }
    
    private void setTitleIMG(){
        // Title image on top
        ImageIcon titleImage = new ImageIcon("header.png");
        Image imgTitle = titleImage.getImage().getScaledInstance(940, 88, Image.SCALE_SMOOTH);
        ImageIcon scaledTitleImage = new ImageIcon(imgTitle);
        titleLabel = new JLabel(scaledTitleImage);
        titleLabel.setBounds(0, 0, 930, 80); // Set the position of the title image
    }

    private void setPreviousButton(){
        // Previous Button
        ImageIcon previousIcon = new ImageIcon(PREVIOUS_BUTTON);
        Image scaledPreviousImage = previousIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        previousButton = new JButton(new ImageIcon(scaledPreviousImage));
        previousButton.setBounds(70,180, 70, 70); // Set button position and size
        previousButton.setBorder(BorderFactory.createEmptyBorder());
    }

    private void setNextButton(){
        ImageIcon nextIcon = new ImageIcon(NEXT_BUTTON);
        Image scaledNextImage = nextIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        nextButton = new JButton(new ImageIcon(scaledNextImage));
        nextButton.setBounds(610, 180, 70, 70); // Set button position and size
        nextButton.setBorder(BorderFactory.createEmptyBorder());
    }

    private void setOpacityBG(){
        ImageIcon opacityBG = new ImageIcon("CharacBG.png");
        Image imgOpacity = opacityBG.getImage().getScaledInstance(922, 580, Image.SCALE_SMOOTH);
        ImageIcon scaledOpacity = new ImageIcon(imgOpacity);
        opacityBGLabel = new JLabel(scaledOpacity);
        opacityBGLabel.setBounds(0, 0, 922, 580); // Set the position of the title image
    }

    public JLabel getOpacityBG(){
        return opacityBGLabel;
    }

    public JButton getNextButton(){
        return nextButton;
    }

    public JButton getPreviousButton(){
        return previousButton;
    }
  
    public JLabel getTitleIMG(){
        return titleLabel;
    }

    public JLabel getHeaderIMG(){
        return headerLabel;
    }

    public JLabel getCCText(){
        return Text;
    }

    public JButton getbackButton(){
        return backButton;
    }
}
