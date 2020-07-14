
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
public class Affiche2 extends Affiche1 {
	public Affiche2(String nom, int l, int h) {
		super(nom, l, h);
	}
	public void F(JFrame f) 
	{   
		JMenu menu = new JMenu("Dictionnaire");
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		JMenuItem newMenuItem = new JMenuItem ("Aspiration");
		JMenuItem newMenuItem2 = new JMenuItem ("Info");
		JMenuItem newMenuItem3 = new JMenuItem ("Quitter");
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_MASK));
		newMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK));
		menu.add(newMenuItem);
		menu.add(newMenuItem2);
		menu.add(newMenuItem3);
		newMenuItem3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event){
				System.exit(0);
			}
		});
		f.setJMenuBar(menuBar);
		super.F(f);
			
				try {
					Asp4Vidal.Asp(newMenuItem);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				try {
					Info.inf(newMenuItem2);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
}





