package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import controleur.Alume;
import controleur.User;

public class VueClient extends JFrame implements ActionListener
{
	private JPanel panelProfil = new JPanel();
	private JButton btQuitter = new JButton (new ImageIcon("src/images/exit.PNG"));
	private JTabbedPane tabbedPane = new JTabbedPane();
	
	JPanel panel2 = new PanelLister();
	JPanel panel3 = new PanelListerChauffeur();
	JPanel panel4 = new PanelListerClient();
	JPanel panel5 = new PanelRdv();
	JPanel panel6 = new PanelListerRdv();
	
	
	
	public VueClient(User unUser)
{
	this.setTitle("Gestion des Clients ");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setBounds(100, 20, 1200, 500);
	this.setLayout(null);
	this.getContentPane().setBackground(Color.gray);
	this.setResizable(false);
	this.btQuitter.setBounds(1300,650,128,128);
	this.add(this.btQuitter);
	
	ImageIcon uneImage = new ImageIcon("src/images/clients.png");
	JLabel monImage = new JLabel(uneImage);
	monImage.setBounds(1170,60,320,200);
	this.add(monImage);
	
	
	
	//insertion du panel Ajout
		
	
	//construction du panel Profil
	this.panelProfil.setBounds(20, 40, 200, 200);
	this.panelProfil.setBackground(Color.white);
	this.panelProfil.setLayout(new GridLayout(5, 1));
	this.panelProfil.add(new JLabel("Bienvenue à l'espace Client Alume"));
	this.panelProfil.add(new JLabel("Votre nom est :"+unUser.getNom()));
	this.panelProfil.add(new JLabel("Votre prenom est :" +unUser.getPrenom() ));
	this.panelProfil.add(new JLabel("Votre Email est :" +unUser.getEmail() ));
	this.panelProfil.add(new JLabel("Vous avez les droits :" + unUser.getDroits() ));
	this.add (this.panelProfil);

	this.btQuitter.addActionListener(this);
	
	// insertion des onglets 
				this.setBounds(100, 10, 1500, 850);
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				this.setVisible(true);
				
				this.getContentPane().setLayout(null);
				
				this.getContentPane().add(tabbedPane);
				tabbedPane.setBounds(350,30,780,600);
			
				
				tabbedPane.addTab("Lister les Produits",new PanelLister());
				
				tabbedPane.addTab("Lister les Clients",new PanelListerClient());
				
				tabbedPane.addTab("Lister les Chauffeurs",new PanelListerChauffeur());
				
				tabbedPane.addTab("Ajouter les Rendez-Vous",new PanelRdv());
				
				tabbedPane.addTab("Lister les Rendez-Vous",new PanelListerRdv());
				
				
				
				
				
	
	

	this.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) 
{
	if (e.getSource()== this.btQuitter)
	{
		if (JOptionPane.showConfirmDialog(this, "Voulez-vous quitter l'application")==0)
		{
			this.dispose();
			Alume.setVisible(true);
		}
	}
	
}

}









