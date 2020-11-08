package SlotMachine;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.ImageIcon;

public class Reel {

    Symbol Cherry = new Symbol();
    Symbol Lemon = new Symbol();
    Symbol Bell = new Symbol();
    Symbol Plum = new Symbol();
    Symbol waterMelon = new Symbol();
    Symbol redSeven = new Symbol();
    CopyOnWriteArrayList<Symbol> imageSymbol = new CopyOnWriteArrayList<Symbol>();

    public Reel() {

        Cherry.setImage(new ImageIcon("src\\SlotMachine\\Images\\cherry.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        Cherry.setValue(2);
        Lemon.setImage(new ImageIcon("src\\SlotMachine\\Images\\lemon.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        Lemon.setValue(3);
        Bell.setImage(new ImageIcon("src\\SlotMachine\\Images\\bell.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        Bell.setValue(6);
        Plum.setImage(new ImageIcon("src\\SlotMachine\\Images\\plum.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        Plum.setValue(4);
        waterMelon.setImage(new ImageIcon("src\\SlotMachine\\Images\\watermelon.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        waterMelon.setValue(5);
        redSeven.setImage(new ImageIcon("src\\SlotMachine\\Images\\redseven.png").getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH));
        redSeven.setValue(7);
    }

    public Image spin(int i) {
        imageSymbol.add(Cherry);
        imageSymbol.add(Lemon);
        imageSymbol.add(Bell);
        imageSymbol.add(Plum);
        imageSymbol.add(waterMelon);
        imageSymbol.add(redSeven);

        return imageSymbol.get(i).getImage();

    }

    public int reelImageValue(int i) {
        imageSymbol.add(Cherry);
        imageSymbol.add(Lemon);
        imageSymbol.add(Bell);
        imageSymbol.add(Plum);
        imageSymbol.add(waterMelon);
        imageSymbol.add(redSeven);

        return imageSymbol.get(i).getValue();

    }

}
