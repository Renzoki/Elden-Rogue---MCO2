import javax.swing.*;
import java.awt.Image;

public class FTConstants {
    private static final String BACK_BUTTON = "backButton.png";
    private static final String FAST_TRAVEL_TEXT = "FastTravelText.png";
    private JButton backButton;
    private JLabel titleLabel;
    private JLabel opacityBGLabel;
    private JLabel fastTravelText;
    private JLabel eoeLabel;
    private JLabel mapLabel;
    private JLabel background;

    public FTConstants(){
        setbackButton();
        setFTText();
        setEchoesofElden();
        setTitleIMG();
        setMapImage();
        setOpacityBG();
        setFTBackground();
    }

    private void setbackButton(){
        // Back Button
        ImageIcon normalStartIcon = new ImageIcon(BACK_BUTTON);
        Image scaledNormalStartImage = normalStartIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        backButton = new JButton(new ImageIcon(scaledNormalStartImage));
        backButton.setBounds(22, 2, 70, 70); // Set button position and size
        backButton.setBorder(BorderFactory.createEmptyBorder());
    }

    private void setFTText(){
        // Fast Travel Text
        ImageIcon fastTravelIcon = new ImageIcon(FAST_TRAVEL_TEXT);
        Image scaledFastTravelImage = fastTravelIcon.getImage().getScaledInstance(170, 55, Image.SCALE_SMOOTH);
        fastTravelText = new JLabel(new ImageIcon(scaledFastTravelImage));
        fastTravelText.setBounds(150, 8, 170, 55); // Set button position and size
        fastTravelText.setBorder(BorderFactory.createEmptyBorder());
    }

    private void setEchoesofElden(){
        // Echoes of Elden image
        ImageIcon echoesImage = new ImageIcon("EchoesOfElden.png");
        Image scaledEchoesImage = echoesImage.getImage().getScaledInstance(420, 490, Image.SCALE_SMOOTH);
        ImageIcon scaledEOEImage = new ImageIcon(scaledEchoesImage);
        eoeLabel = new JLabel(scaledEOEImage);
        eoeLabel.setBounds(15, 55, 420, 490); // Set the position of the title image
    }

    private void setFTBackground(){
        // Background image
        ImageIcon backgroundImage = new ImageIcon("optionBackground.png");
        Image imgBackground = backgroundImage.getImage().getScaledInstance(920, 580, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(imgBackground);
        background = new JLabel("", scaledBackgroundImage, JLabel.CENTER);
    }
    
    private void setTitleIMG(){
        // Title image on top
        ImageIcon titleImage = new ImageIcon("header.png");
        Image imgTitle = titleImage.getImage().getScaledInstance(940, 88, Image.SCALE_SMOOTH);
        ImageIcon scaledTitleImage = new ImageIcon(imgTitle);
        titleLabel = new JLabel(scaledTitleImage);
        titleLabel.setBounds(0, 0, 930, 80); // Set the position of the title image
    }

    private void setMapImage(){
        // Map image
        ImageIcon mapImage = new ImageIcon("EldenMap.png");
        Image scaledMapImage = mapImage.getImage().getScaledInstance(530, 560, Image.SCALE_SMOOTH);
        ImageIcon scaledMapImageIcon = new ImageIcon(scaledMapImage);
        mapLabel = new JLabel(scaledMapImageIcon);
        mapLabel.setBounds(390, 0, 530, 560); // Set the position of the title image
    }

    private void setOpacityBG(){
        // Opacity Background
        ImageIcon backgroundImage1 = new ImageIcon("CharacBG.png");
        Image imgBackground1 = backgroundImage1.getImage().getScaledInstance(920, 580, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage1 = new ImageIcon(imgBackground1);
        opacityBGLabel = new JLabel(scaledBackgroundImage1);
        opacityBGLabel.setBounds(0, 0, 920, 580); // Set the position of the title image
    }

    public JLabel getOpacityBG(){
        return opacityBGLabel;
    }

    public JLabel getMapImage(){
        return mapLabel;
    }
  
    public JLabel getTitleIMG(){
        return titleLabel;
    }

    public JLabel getFTBackground(){
        return background;
    }

    public JLabel getEchoesofElden(){
        return eoeLabel;
    }

    public JLabel getFTText(){
        return fastTravelText;
    }

    public JButton getbackButton(){
        return backButton;
    }
}
