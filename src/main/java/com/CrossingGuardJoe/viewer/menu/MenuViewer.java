package com.CrossingGuardJoe.viewer.menu;

import com.CrossingGuardJoe.gui.GUI;
import com.CrossingGuardJoe.model.menu.Menu;
import com.CrossingGuardJoe.viewer.Viewer;

public class MenuViewer extends Viewer<Menu> {
    public MenuViewer(Menu menu) { super(menu); }

    private String[] menuImage;

    @Override
    protected void drawElements(GUI gui) {
        //gui.drawImage(new Position(100, 100), menuImage);
        /*gui.drawText(new Position(100, 100), "Menu", "#FF5451");
        for (int i = 0; i < getModel().getNumberOptions(); i++)
            gui.drawText(
                    new Position(50, 70 + i),
                    getModel().getOption(i),
                    getModel().selectedOption(i) ? "#FFFFFF" : "#FF5451");*/
    }
}