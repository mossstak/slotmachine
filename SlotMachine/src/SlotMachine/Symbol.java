/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.awt.Image;

public class Symbol implements iSymbol {

    private Image image;
    private int value;

    @Override
    public void setImage(Image images) {
        this.image = images;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setValue(int value) {
        this.value = value;

    }

    @Override
    public int getValue() {
        return value;
    }

    public int compare(int reelh1, int reelh2, int reelh3, int count) {
        if (reelh1 == reelh2 && reelh1 == reelh3 && reelh2 == reelh3) {
            return 3;
        }
        if (reelh1 == reelh2 && count == 0) {
            return 2;
        }
        if (reelh1 == reelh3 && count == 0) {
            return 2;
        }
        if (reelh2 == reelh3 && count == 0) {
            return 2;
        }
        return 0;
    }
}
