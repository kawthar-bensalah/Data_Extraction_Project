


import javax.swing.JFrame;
public class Affiche1 {
	String nom;
	int l;
	int h;
	public Affiche1(String nom,int l,int h)
    {
 	   this.nom=nom;
 	   this.l=l;
 	   this.h=h;
    }
	public void F(JFrame f) 
	{   
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(this.l,this.h);
		f.setVisible(true);   
	}
}
