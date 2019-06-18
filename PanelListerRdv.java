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
import controleur.Rdv;
import controleur.Tableau;
import modele.ModeleRdv;

public class PanelListerRdv extends PanelCentral implements ActionListener 
{

private JTable uneTable ;
private static Tableau unTableau ;


	public  PanelListerRdv() 
	{
		super();
		
		String entetes[] = {"Id Rdv", "Nom", "Prenom" ,"Email","Date","Heure","Motif"};
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
						int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le Rendez-Vous ?", 
								"Suppression Article",JOptionPane.YES_NO_OPTION);
					if (retour ==0)
					{
						unTableau.deleteRow(ligneSelectionnee);
						int idRdv = (int) uneTable.getValueAt(ligneSelectionnee, 0);
						ModeleRdv.deleteRdv(idRdv);
						JOptionPane.showMessageDialog(null, "Suppression Effectuee","Suppression du Rendez-Vous",
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
		ArrayList<Rdv> lesRdv = ModeleRdv.selectAllRdv();
		
		Object[][] matrice = new Object[lesRdv.size()][7];
		int i = 0 ;
		for (Rdv unRdv : lesRdv)
		{
			matrice[i][0] = unRdv.getId_rdv();
			matrice[i][1] = unRdv.getNom_rdv();
			matrice[i][2] = unRdv.getPrenom_rdv();
			matrice[i][3] = unRdv.getEmail_rdv();
			matrice[i][4] = unRdv.getDate_rdv();
			matrice[i][5] = unRdv.getHeure_rdv();
			matrice[i][6] = unRdv.getMotif_rdv();
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
