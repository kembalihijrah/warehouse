/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;

import java.awt.Color;

/**
 *
 * @author Fajar-PC
 */
public class Colorful {
    private final Color active = new Color(0, 0, 0);
    private final Color inactive = new Color(255, 255, 255);
    private final Color blueCommon = new Color(0, 153, 255);
    private final Color blueCommonBright = new Color(0, 160, 255);
    private final Color activeBackground = new Color(230,230,230); // 70,163,255
    public Colorful() {}
    public Color getActiveColor() { return active; }
    public Color getInactiveColor() { return inactive; }
    public Color getBlueCommon() { return blueCommon; }
    public Color getBlueCommonBright() { return blueCommonBright; }
    public Color getActiveBackgroundColor() { return activeBackground; }
}
