package com.javacomp.util;

import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;

/**
 * Shared UI helper methods used across all Swing frames.
 *
 * <p>Extracts common patterns (logo loading, Look-and-Feel setup)
 * that were previously copy-pasted into every single JFrame class.</p>
 *
 * @author Andrea Pascual Aguilera
 * @author Sergio Alonso Zarcero
 */
public final class UIHelper {

    private static final Logger LOGGER = Logger.getLogger(UIHelper.class.getName());

    private UIHelper() {
        // Prevent instantiation — utility class
    }

    /**
     * Loads an image from the given path and scales it to fit the target label.
     *
     * <p>The image is scaled using {@link Image#SCALE_SMOOTH} for better
     * visual quality compared to the default scaling hint.</p>
     *
     * @param imagePath relative or absolute path to the image file
     * @param target    the JLabel whose dimensions determine the scaled size
     */
    public static void loadScaledIcon(String imagePath, JLabel target) {
        ImageIcon originalIcon = new ImageIcon(imagePath);
        ImageIcon scaledIcon = new ImageIcon(
                originalIcon.getImage().getScaledInstance(
                        target.getWidth(), target.getHeight(), Image.SCALE_SMOOTH));
        target.setIcon(scaledIcon);
    }

    /**
     * Attempts to set the Nimbus Look and Feel for a modern appearance.
     *
     * <p>Falls back silently to the default platform L&amp;F if Nimbus
     * is not available on the current JDK installation.</p>
     */
    public static void setNimbusLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    return;
                }
            }
        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            LOGGER.log(Level.WARNING, "Could not set Nimbus Look and Feel", ex);
        }
    }
}
