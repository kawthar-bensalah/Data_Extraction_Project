

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

public class Asp4Vidal {
	
	static void Asp (JMenuItem newMenuItem)throws Exception {
		newMenuItem.addActionListener(new ActionListener()
		{  
		public void actionPerformed (ActionEvent e) {
			new Thread(new Runnable(){
				public void run(){
			JOptionPane.showMessageDialog(null, "Bonjour !");
				String nom=JOptionPane.showInputDialog(null,"veuillez saisir l'URL", "URL de départ",JOptionPane.QUESTION_MESSAGE);	
			       PrintWriter ecrire1 = null;
					try {
						ecrire1 = new PrintWriter("Fichier_sortie.txt","UTF-16LE");
						ecrire1.write("\uFEFF");
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			       PrintWriter ecrire2 = null; //subst.dic
						try {
							ecrire2 = new PrintWriter("subst.dic","UTF-16LE");
							ecrire2.write("\uFEFF");
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						char c1 = 0;
					    char c2 = 0;
			 Object[] lettre = {'A', 'B', 'C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			       c1 = (char) JOptionPane.showInputDialog(null, 
			      "Veuillez indiquer la borne inferieure :",
			      "BORNE INFERIEURE DE L'INTERVALLE",
			      JOptionPane.QUESTION_MESSAGE,
			      null,
			      lettre,
			      lettre[0]);
			       c2 = (char) JOptionPane.showInputDialog(null, 
						      "Veuillez indiquer la borne superieure :",
						      "BORNE SUPERIEURE DE L'INTERVALLE",
						      JOptionPane.QUESTION_MESSAGE,
						      null,
						      lettre,
						      lettre[0]); 
					 /*   String text1=JOptionPane.showInputDialog("veuillez saisir la borne inférieure");
					    
			if(!text1.isEmpty())
			c1=text1.charAt(0);
			String text2=JOptionPane.showInputDialog("veuillez saisir la borne supérieure");
			if(!text2.isEmpty())
			c2=text2.charAt(0);  */
			
	    		if(c2<c1 || (c1<'A' ||  c2>'Z'))
			{  JOptionPane.showMessageDialog(null, "Veuillez réessayer s'il vous plait ", "Intervalle erroné", JOptionPane.INFORMATION_MESSAGE);
			  
				do{
					
					c1 = (char) JOptionPane.showInputDialog(null, 
					      "Veuillez indiquer la borne inferieure :",
					      "BORNE INFERIEURE DE L'INTERVALLE",
					      JOptionPane.QUESTION_MESSAGE,
					      null,
					      lettre,
					      lettre[1]);
					       c2 = (char) JOptionPane.showInputDialog(null, 
								      "Veuillez indiquer la borne superieure :",
								      "BORNE SUPERIEURE DE L'INTERVALLE",
								      JOptionPane.QUESTION_MESSAGE,
								      null,
								      lettre,
								      lettre[1]); 
				}while(c2<c1 || (c1<'A' ||  c2>'Z'));
			}  
	    	JFrame frame = new JFrame("Aspiration...");
			JProgressBar barre = new JProgressBar();
			JProgressBar barre2 = new JProgressBar();
			JLabel UrlLabel= new JLabel();
			barre.setStringPainted(true);
			barre2.setStringPainted(true);
			FlowLayout disposition = new FlowLayout();
			frame.setLayout(disposition);
			frame.setLocation(300, 300);
			frame.add(UrlLabel);
			frame.add(barre);
			frame.add(barre2);
			frame.setSize(350, 100);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);	
			int j=0;
			int k = c2-c1;
			barre2.setMaximum(k+1);
			while(c1<=c2 && j<k+1 )
			{   
				String line = null;
				String nom2 = nom.replaceAll("-..htm","-"+c1+".htm");
				URL url = null;
				try {
					url = new URL(nom2);
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
				String regexp="\\s+<a href=\"Substance.+>(.+)</a>";
				BufferedReader lire = null;
				try {
					lire = new BufferedReader(new InputStreamReader(url.openStream(),"UTF-8"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				for(int i=0;i<=100;i++) {										
				  UrlLabel.setText("URL ["+c1+"]"); 
					try {
						java.lang.Thread.sleep(20);
					} catch (InterruptedException e2) {
						e2.printStackTrace();
					}
				   barre.setValue(i); 
				   try {
					while((line=lire.readLine())!=null)
					{       
						       System.out.println(line);
									Pattern p = Pattern.compile(regexp);
									Matcher m = p.matcher(line);
									if(m.matches())
									ecrire2.write(m.group(1)+",.N\n");
							    
							ecrire1.write(line);
							ecrire1.write(System.getProperty("line.separator"));
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   }
			    j++;
			    barre2.setValue(j);
			c1++;
			    }
			ecrire1.close();
			ecrire2.close();
			frame.setVisible(false);
			}
			}).start();
		}});
	}
	



}