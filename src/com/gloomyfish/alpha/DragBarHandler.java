/*
 *  Copyright 2010 De Gregorio Daniele.
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package com.gloomyfish.alpha;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class represent a custom panel like the title bar of every windows. It is
 * a void component that must be inserted in a JFrame contentPane directly
 * (no nested components) . So it can be used like a door handle to drag&drop the JFrame.
 * Use it only on UNDERCORATED JFRAMEs, would not make sense otherwise;
 * @author De Gregorio Daniele
 */
public class DragBarHandler extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2285562505531914157L;
	private JFrame target = null;
    private Point draggingAnchor = null;

    public DragBarHandler(final JFrame target) {
        super();
        this.target = target;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                draggingAnchor = new Point(e.getX() + getX(), e.getY() + getY());
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                target.setLocation(e.getLocationOnScreen().x - draggingAnchor.x, e.getLocationOnScreen().y - draggingAnchor.y);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
