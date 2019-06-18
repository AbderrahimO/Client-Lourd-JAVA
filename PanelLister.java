package vue;
import modele.Modele;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.Article;
import controleur.Tableau;
import modele.Modele;

public class PanelLister extends PanelCentral implements ActionListener 
{
protected static final Article Article = null;
private JTable uneTable ;
private static Tableau unTableau ;


	public  PanelLister() 
	{
		super();
		
		String entetes[] = {"Code de l'article", "Nom de l'article", "Prix de l'article" ,"Quantite"};
		unTableau = new Tableau(this.getLesDonnees(), entetes);
		uneTable = new JTable(unTableau);
		
		uneTable.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				{
					if (e.getClickCount()== 2)
					{
						int ligneSelectionnee = uneTable.rowAtPoint(e.getPoint()); 
						int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le produit ?", 
								"Suppression Article",JOptionPane.YES_NO_OPTION);
					if (retour ==0)
					{
						unTableau.deleteRow(ligneSelectionnee);
					Object unArticle =  uneTable.getValueAt(ligneSelectionnee, 0);
						Modele.deleteArticle(Article);
						JOptionPane.showMessageDialog(null, "Suppression Effectuee","Suppression Article",
								JOptionPane.INFORMATION_MESSAGE);
						
					}
					}
					
				}
				
			}
		});
		
		
		JScrollPane uneScroll = new JScrollPane(uneTable);
		uneScroll.setBounds(20,20,750,200);
		this.add(uneScroll);
		
		
	}
	private Object[][] getLesDonnees() 
	{
		ArrayList<Article> lesArticles = Modele.selectAllArticle();
		
		Object[][] matrice = new Object[lesArticles.size()][4];
		int i = 0 ;
		for (Article unArticle : lesArticles)
		{
			matrice[i][0] = unArticle.getCode_art();
			matrice[i][1] = unArticle.getNoma();
			matrice[i][2] = unArticle.getPrixa();
			matrice[i][3] = unArticle.getQte();
			i++;
		}
		return matrice;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	public static Tableau getUnTableau() {
		return unTableau;
	}
	
}
