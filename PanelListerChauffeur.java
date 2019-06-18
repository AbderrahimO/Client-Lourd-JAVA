package vue;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import controleur.Chauffeur;
import controleur.Tableau;
import modele.ModeleChauffeur;

public class PanelListerChauffeur extends PanelCentral implements ActionListener 
{
private JTable uneTable ;
private static Tableau unTableau ;


	public  PanelListerChauffeur() 
	{
		super();
		
		String entetes[] = {"Id Chauffeur", "Nom", "Prenom" ,"Telephone","Libre"};
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
						int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le Chauffeur ?", 
								"Suppression Chauffeur",JOptionPane.YES_NO_OPTION);
					if (retour ==0)
					{
						unTableau.deleteRow(ligneSelectionnee);
						int idChauffeur = (int) uneTable.getValueAt(ligneSelectionnee, 0);
						ModeleChauffeur.deleteChauffeur(idChauffeur);
						JOptionPane.showMessageDialog(null, "Suppression Effectuee","Suppression Chaufeur",
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
		ArrayList<Chauffeur> lesChauffeurs = ModeleChauffeur.selectAllChauffeurs();
		
		Object[][] matrice = new Object[lesChauffeurs.size()][5];
		int i = 0 ;
		for (Chauffeur unChauffeur : lesChauffeurs)
		{
			matrice[i][0] = unChauffeur.getId_chauf();
			matrice[i][1] = unChauffeur.getNom_chauf();
			matrice[i][2] = unChauffeur.getPrenom_chauf();
			matrice[i][3] = unChauffeur.getTel_chauf();
			matrice[i][4] = unChauffeur.getLibre();
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
