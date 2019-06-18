package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modele.ModeleClient;
import controleur.Alume;
import controleur.Article;
import controleur.Client;


public class PanelClients extends PanelCentral implements ActionListener 
{
	private JTextField txtmail = new JTextField();
	private JTextField txtmdp = new JTextField();
	private JTextField txtnom = new JTextField();
	private JTextField txtprenom = new JTextField();
	private JTextField txttel = new JTextField();
	private JTextField txtadresse = new JTextField();
	private JTextField txtcpt = new JTextField();
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	public PanelClients()
	{
		super();
		this.setLayout(new GridLayout(8,3));
		this.add(new JLabel("Mail :"));
		this.add(this.txtmail);
		this.add(new JLabel("Mot de Passe :"));
		this.add(this.txtmdp);
		this.add(new JLabel("Nom :"));
		this.add(this.txtnom);
		this.add(new JLabel("Prenom :"));
		this.add(this.txtprenom);
		this.add(new JLabel("Telephone :"));
		this.add(this.txttel);
		this.add(new JLabel("Adresse :"));
		this.add(this.txtadresse);
		this.add(new JLabel("Code Postale :"));
		this.add(this.txtcpt);
		

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
			this.txtmail.setText("");
			this.txtmdp.setText("");
			this.txtnom.setText("");
			this.txtprenom.setText("");
			this.txttel.setText("");
			this.txtadresse.setText("");
			this.txtcpt.setText("");
			
		}
		else if (e.getSource()== this.btEnregistrer)
		{
			String mail  = this.txtmail.getText();
			String mdp = this.txtmdp.getText();
			String nom = this.txtnom.getText();
			String prenom = this.txtprenom.getText();
			String tel = this.txttel.getText();
			String adresse = this.txtadresse.getText();
			String cpt = this.txtcpt.getText();
			
			if (mail.equals("")||mdp.equals("")||nom.equals("")
					|| prenom.equals("")|| tel.equals("") || adresse.equals("") || cpt.equals("") )
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie de données", "Erreur", JOptionPane.ERROR_MESSAGE);
			}else {
				//insertion dans la bdd 
				Client unClient = new Client(mail, mdp, nom, prenom, tel, adresse, cpt);
				Alume.insertClients(unClient);
				JOptionPane.showMessageDialog(this, "Insertion reussie du Client réussie","Information", JOptionPane.INFORMATION_MESSAGE);
				
				unClient = Alume.selectWhereClients(unClient);
				
				Object ligne[] = {unClient.getIdclient(),
						 unClient.getNom(), unClient.getPrenom(), unClient.getMail(),unClient.getAdresse(), 
						 unClient.getCpcli(),  unClient.getTelcli()};
				
				PanelListerClient.getUnTableau().addRow(ligne);
				}
					this.setVisible(false);
				
			}
		}
		
	}

