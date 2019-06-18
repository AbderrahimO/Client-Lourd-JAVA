package vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.Client;
import controleur.Tableau;
import modele.ModeleClient;

public class PanelListerClient extends PanelCentral implements ActionListener 
{
private JTable uneTable ;
private static Tableau unTableau ;


	public  PanelListerClient() 
	{
		super();
		
		String entetes[] = {"Id Client", "Nom", "Prenom" ,"Mail","Adresse","Code Postale","Telephone"};
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
						int retour = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer le client ?", "Suppression Client",
								JOptionPane.YES_NO_OPTION);
					if (retour ==0)
					{
						unTableau.deleteRow(ligneSelectionnee);
						int Idclient=(int) uneTable.getValueAt(ligneSelectionnee, 0);
						ModeleClient.deleteClient(Idclient);
						JOptionPane.showMessageDialog(null, "Suppression Effectuee","Suppression Client",JOptionPane.INFORMATION_MESSAGE);
						
					}
					}
					
				}
				
			}
		});
		
		
		JScrollPane uneScroll = new JScrollPane(uneTable);
		uneScroll.setBounds(20,20,750,300);
		this.add(uneScroll);
		
		
	}
	private Object[][] getLesDonnees() 
	{
		ArrayList<Client> lesClients = ModeleClient.selectAllClients();
		
		Object[][] matrice = new Object[lesClients.size()][8];
		int i = 0 ;
		for (Client unClient : lesClients)
		{
			matrice[i][0] = unClient.getIdclient();
			matrice[i][1] = unClient.getMail();
			matrice[i][2] = unClient.getMdp();
			matrice[i][3] = unClient.getNom();
			matrice[i][4] = unClient.getPrenom();
			matrice[i][5] = unClient.getTelcli();
			matrice[i][6] = unClient.getAdresse();
			matrice[i][7] = unClient.getCpcli();
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
