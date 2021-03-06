package quidditch;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Gestion des touches de claviers utilise pour bouger les joueurs 
 * Attention pour set pour clavier querty
 * @author cyrena
 *
 */
public class KeyInput extends KeyAdapter{
	private UseGameO handler;
	
	
	public  KeyInput(UseGameO handler) {
		this.handler = handler;
	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.objects.size(); i++) {
			GameObject tmpObj = handler.objects.get(i);
			
			if(tmpObj.getId() == 0) {
				if(key ==  KeyEvent.VK_W )tmpObj.setVelY(-3);
				if(key ==  KeyEvent.VK_S)tmpObj.setVelY(3);	
				if(key ==  KeyEvent.VK_D )tmpObj.setVelX(3);
				if(key ==  KeyEvent.VK_A )tmpObj.setVelX(-3);
			}
			if(tmpObj.getId() == 1){
				if(key ==  KeyEvent.VK_UP )tmpObj.setVelY(-3);
				if(key ==  KeyEvent.VK_DOWN )tmpObj.setVelY(3);
				if(key ==  KeyEvent.VK_RIGHT )tmpObj.setVelX(3);
				if(key ==  KeyEvent.VK_LEFT)tmpObj.setVelX(-3);		
			}
			if(tmpObj.getId() == 2) {//a sup
				if(key ==  KeyEvent.VK_T )tmpObj.setVelY(-3);//a sup
				if(key ==  KeyEvent.VK_G)tmpObj.setVelY(3);	//a sup
				if(key ==  KeyEvent.VK_H )tmpObj.setVelX(3);//a sup
				if(key ==  KeyEvent.VK_F )tmpObj.setVelX(-3);	//a sup		
			}
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.objects.size(); i++) {
			GameObject tmpObj = handler.objects.get(i);
			
			if(tmpObj.getId() == 0) {
				if(key !=  KeyEvent.VK_A )tmpObj.setVelX(0);
				if(key !=  KeyEvent.VK_W )tmpObj.setVelY(0);
				if(key !=  KeyEvent.VK_D )tmpObj.setVelX(0);
				if(key !=  KeyEvent.VK_S)tmpObj.setVelY(0);				
			}else if(tmpObj.getId() == 1){
				if(key !=  KeyEvent.VK_UP )tmpObj.setVelY(0);
				if(key !=  KeyEvent.VK_DOWN )tmpObj.setVelY(0);
				if(key !=  KeyEvent.VK_RIGHT )tmpObj.setVelX(0);
				if(key !=  KeyEvent.VK_LEFT)tmpObj.setVelX(0);		
			}
		}
	}
}
