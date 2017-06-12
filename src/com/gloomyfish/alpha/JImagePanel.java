package com.gloomyfish.alpha;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class JImagePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	private JButton okButton;
	private JButton cancelButton;
	private JComboBox shapeBox;
	
	public JImagePanel() {
		super();
		setLayout(null);
		okButton = new JButton("OK");
		cancelButton = new JButton("Cancel");
		shapeBox = new JComboBox(new String[]{"Rectangel", "Circle", "Area"});	
	}
	
	public void addActionListener(ActionListener l) {
		okButton.addActionListener(l);
		cancelButton.addActionListener(l);
	}
	
	public void removeActionListener(ActionListener l) {
		okButton.removeActionListener(l);
		cancelButton.removeActionListener(l);
	}
	
	
	public void setImage(Image image) {
		this.image = image;
		okButton.setBounds(((BufferedImage)image).getWidth()/2 - 80, ((BufferedImage)image).getHeight() - 60, 60, 30);
        cancelButton.setBounds(((BufferedImage)image).getWidth()/2, ((BufferedImage)image).getHeight() - 60, 80, 30);
        shapeBox.setBounds(((BufferedImage)image).getWidth()/2 - 60, ((BufferedImage)image).getHeight()/2 - 40, 120, 30);
        shapeBox.setOpaque(false);
        okButton.setOpaque(false);
        cancelButton.setOpaque(false);
        this.add(okButton);
        this.add(cancelButton);
        this.add(shapeBox);
        repaint();
	}
	
	public int getSelectedIndex() {
		return shapeBox.getSelectedIndex();
	}
	
	protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.clearRect(0, 0, getWidth(), getHeight());
        if (image != null) {
            g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        } else {
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, getWidth(), getHeight());
        }
    }


}
