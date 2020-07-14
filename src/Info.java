
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap; 

import javax.swing.JMenuItem;

public class Info {
	 public static void inf( JMenuItem newMenuItem) throws IOException { 
	newMenuItem.addActionListener(new ActionListener()
	{  
	public void actionPerformed (ActionEvent e) {
		new Thread(new Runnable(){
			public void run(){
				 int nbr_medi;  char c = 0;
	             PrintWriter ecrire3 = null;
	try {
		ecrire3 = new PrintWriter("info.txt");
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   FileReader l = null;
	   FileInputStream ll=null;
	   try {
		ll=new FileInputStream("C:\\Users\\Prof\\Desktop\\kika\\Extrac_info\\subst.dic");
	} catch (FileNotFoundException e3) {
		// TODO Auto-generated catch block
		e3.printStackTrace();
	}
	try {
		l = new FileReader("C:\\Users\\Prof\\Desktop\\kika\\Extrac_info\\subst.dic");
		
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	
	InputStreamReader input = null;
	try {
		input = new InputStreamReader (ll,"UTF-16");
	} catch (UnsupportedEncodingException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	   BufferedReader b=new BufferedReader (input);
	   String li = null;
	try {
		li = b.readLine();
	} catch (IOException e2) {
		// TODO Auto-generated catch block
		e2.printStackTrace();
	}
	    int s = 1;
	    HashMap <Character,Integer> ht= new HashMap<Character,Integer>();
	    char k='a';
		c=li.charAt(0);
	    nbr_medi=1;
	  
	    try {
		while((li=b.readLine())!=null){
			k=li.charAt(0);
			if(c=='e'&& k=='é'||c=='é'&& k=='e')
				{
				nbr_medi++;
				ht.put('e', nbr_medi);
			   } 
			    else
			    {
			    	if(c!=k)
			    	{
			    		ht.put(c, nbr_medi);
			    		c=li.charAt(0);
			    		nbr_medi=1;
			    	}
			    	else
			    	{
			    		nbr_medi++;
			    		if(c=='é') c='e';
			    		ht.put(c, nbr_medi);
			    	}
			    }
				 s++;
	   }
			//AFFICHAGE CONSOLE 
		for(Character p:ht.keySet())
		{
			System.out.println("nombre de  "+p+"  est   "+ht.get(p) );
		}
		 s--;    
        ecrire3.write("le nombre total des entités médicales est :"+s);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	   try {
		b.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
			}	}).start();
			}});
   }
}
	

