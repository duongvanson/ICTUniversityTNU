/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appletjava;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author dvson
 */
public class doctor extends Applet{

    @Override
    public void paint(Graphics g) {
        setBackground(Color.black);
        setSize(500, 500);
        g.setColor(Color.orange);
        g.drawArc(203, 203, 15, 15, 0, 360);
        g.draw3DRect(200, 200, 20, 20, false);
        g.drawArc(195, 195, 30, 30, 0, 360);
        g.drawArc(185, 185, 50, 50, 0, 360);
        g.setColor(Color.red);
        g.draw3DRect(180, 180, 60, 60, false);
        g.setColor(Color.orange);
        g.draw3DRect(175, 175, 70, 70, true);
        g.drawArc(173, 173, 75, 75, 0, 360);
        g.drawArc(168, 168, 85, 85, 0, 360);
        g.setColor(Color.red);
        g.drawArc(169, 169, 82, 82, 0, 360);
        g.setColor(Color.orange);
        g.draw3DRect(165, 165, 90, 90, true);
        g.draw3DRect(160, 160, 100, 100, false);
        g.drawArc(150, 150, 120, 120, 0, 360);
        g.drawArc(147, 147, 125, 125, 0, 360);
        g.drawArc(142, 142, 135, 135, 0, 360);
        g.drawArc(141, 141, 137, 137, 0, 360);
    }
}
