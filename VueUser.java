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

import controleur.Alume;
import controleur.User;

public class VueUser extends JFrame implements ActionListener
{
	private JPanel panelProfil = new JPanel();
	private JButton btQuitter = new JButton (new ImageIcon("src/images/exit.PNG")) ;
public VueUser(User unUser)
{
	this.setTitle("Administration de la bdd Fnac");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setBounds(100, 20, 1200, 500);
	this.setLayout(null);
	this.getContentPane().setBackground(Color.red);
	this.setResizable(false);
	this.btQuitter.setBounds(1000,300,128,128);
	this.add(this.btQuitter);
	
	ImageIcon uneImage = new ImageIcon("src/images/users.PNG");
	JLabel monImage = new JLabel(uneImage);
	monImage.setBounds(300,40,260,200);
	this.add(monImage);
	
	//construction du panel Profil
	this.panelProfil.setBounds(20, 40, 200, 200);
	this.panelProfil.setBackground(Color.white);
	this.panelProfil.setLayout(new GridLayout(5, 1));
	this.panelProfil.add(new JLabel("Bienvenue à l'espace Utilisateur Fnac"));
	this.panelProfil.add(new JLabel("Votre nom est :"+unUser.getNom()));
	this.panelProfil.add(new JLabel("Votre prenom est :" +unUser.getPrenom() ));
	this.panelProfil.add(new JLabel("Votre Email est :" +unUser.getEmail() ));
	this.panelProfil.add(new JLabel("Vous avez les droits :" + unUser.getDroits() ));
	this.add (this.panelProfil);

	this.btQuitter.addActionListener(this);

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

