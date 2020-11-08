/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.awt.Image;

/**
 *
 * @author User
 */
public interface iSymbol{
	public Image getImage();

	public void setValue(int value);

	public int getValue();

	public void setImage(Image images);
}
