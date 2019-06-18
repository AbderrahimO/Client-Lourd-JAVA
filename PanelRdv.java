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
import controleur.Rdv;

public class PanelRdv extends PanelCentral implements ActionListener 
{
	private JTextField txtnom_rdv = new JTextField();
	private JTextField txtprenom_rdv = new JTextField();
	private JTextField txtemail_rdv = new JTextField();
	private JTextField txtdate_rdv = new JTextField();
	private JTextField txtheure_rdv = new JTextField();
	private JTextField txtmotif_rdv = new JTextField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	public PanelRdv()
	{
		super();
		this.setLayout(new GridLayout(7,2));
		this.add(new JLabel("Nom :"));
		this.add(this.txtnom_rdv);
		this.add(new JLabel("Prenom :"));
		this.add(this.txtprenom_rdv);
		this.add(new JLabel("Email :"));
		this.add(this.txtemail_rdv);
		this.add(new JLabel("Date :"));
		this.add(this.txtdate_rdv);
		this.add(new JLabel("Heure :"));
		this.add(this.txtheure_rdv);
		this.add(new JLabel("Motif :"));
		this.add(this.txtmotif_rdv);
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
			viderChamps(); 
			
		}
		else if (e.getSource()== this.btEnregistrer)
		{
			String nom_rdv = this.txtnom_rdv.getText();
			String prenom_rdv = this.txtprenom_rdv.getText();
			String email_rdv = this.txtemail_rdv.getText();
			String date_rdv = this.txtdate_rdv.getText();
			String heure_rdv = this.txtheure_rdv.getText();
			String motif_rdv = this.txtmotif_rdv.getText();
			
			
			if (nom_rdv.equals("") || prenom_rdv.equals("") || email_rdv.equals("")|| date_rdv.equals("")|| heure_rdv.equals("")
					|| motif_rdv.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie de données", "Erreur", JOptionPane.ERROR_MESSAGE);
			}else {
				//insertion dans la bdd 
				Rdv unRdv = new Rdv (nom_rdv, prenom_rdv , email_rdv,date_rdv,heure_rdv,motif_rdv);
				Alume.insertRdv(unRdv);
				JOptionPane.showMessageDialog(this, "Insertion reussie du Rendez-Vous","Information", JOptionPane.INFORMATION_MESSAGE);
				
				unRdv = Alume.selectWhereRdv (unRdv);
				
				Object ligne[] = {unRdv.getId_rdv(),unRdv.getNom_rdv(),
						unRdv.getPrenom_rdv(), unRdv.getEmail_rdv(),unRdv.getDate_rdv(),unRdv.getHeure_rdv(),unRdv.getMotif_rdv()
						};
				
				PanelListerRdv.getUnTableau().addRow(ligne);
				viderChamps(); 
				}
					this.setVisible(false);
				
			}
		}

	private void viderChamps() {
		this.txtnom_rdv.setText("");
		this.txtprenom_rdv.setText("");
		this.txtemail_rdv.setText("");
		this.txtdate_rdv.setText("");
		this.txtheure_rdv.setText("");
		this.txtmotif_rdv.setText("");
		
	}
		
	}



