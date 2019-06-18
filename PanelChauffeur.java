package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controleur.Chauffeur;
import controleur.Alume;

public class PanelChauffeur extends PanelCentral implements ActionListener 
{
	private JTextField txtnomchauf = new JTextField();
	private JTextField txtprenomchauf = new JTextField();
	private JTextField txttelchauf = new JTextField();
	private JTextField txtlibre = new JTextField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	public PanelChauffeur()
	{
		super();
		this.setLayout(new GridLayout(5,2));
		this.add(new JLabel("Nom :"));
		this.add(this.txtnomchauf);
		this.add(new JLabel("Prenom :"));
		this.add(this.txtprenomchauf);
		this.add(new JLabel("Telephone :"));
		this.add(this.txttelchauf);
		this.add(new JLabel("Libre :"));
		this.add(this.txtlibre);
		this.add(this.btAnnuler);
		this.add(this.btEnregistrer);
		
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()== this.btAnnuler)
		{
			this.txtnomchauf.setText("");
			this.txtprenomchauf.setText("");
			this.txttelchauf.setText("");
			this.txtlibre.setText("");
		}
		else if (e.getSource()== this.btEnregistrer)
		{
			String nomchauf = this.txtnomchauf.getText();
			String prenomchauf = this.txtprenomchauf.getText();
			String telchauf = this.txttelchauf.getText();
			String libre = this.txtlibre.getText();
			
			
			if (nomchauf.equals("") || prenomchauf.equals("") || telchauf.equals("")|| libre.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie de données", "Erreur", JOptionPane.ERROR_MESSAGE);
			}else {
				//insertion dans la bdd 
				Chauffeur unChauffeur = new Chauffeur (nomchauf, prenomchauf , telchauf,libre);
				Alume.insertChauffeur(unChauffeur);
				JOptionPane.showMessageDialog(this, "Insertion reussie du Chauffeur","Information", JOptionPane.INFORMATION_MESSAGE);
				
				unChauffeur = Alume.selectWhereChauffeur (unChauffeur);
				
				Object ligne[] = {unChauffeur.getId_chauf(),unChauffeur.getNom_chauf(),
						unChauffeur.getPrenom_chauf(), unChauffeur.getTel_chauf(),unChauffeur.getLibre()
						};
				
				PanelListerChauffeur.getUnTableau().addRow(ligne);
				}
					this.setVisible(false);
				
			}
		}
		
	}

