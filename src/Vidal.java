
import java.util.Scanner;

import javax.swing.JFrame;
 //http://127.0.0.1:8888/vidal/vidal/vidal-Sommaires-Substances-A.htm
public class Vidal{
   public static void main(String[] args) throws Exception 
   {
     System.out.println("veuillez saisir le nom du frame principale , la largeur et la hauteur\n");
     Scanner e=new Scanner(System.in);
     String s=e.nextLine();
     int l=e.nextInt();
     int h=e.nextInt(); 
     Affiche2 a=new Affiche2(s,l,h);
     final JFrame f=new JFrame(s);
     f.setLocation(250,250);
     a.F(f);
     e.close();
   }
 }
