package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controleur.Alume;
import controleur.User;

public class VueGenerale extends JFrame implements ActionListener
{
	private JPanel panelProfil = new JPanel();
	private JButton btQuitter = new JButton("Quitter");
public VueGenerale(User unUser)
{
	this.setTitle("Administrateur de la bdd Fnac");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setBounds(100, 20, 1200, 500);
	this.setLayout(null);
	this.getContentPane().setBackground(Color.gray);
	this.setResizable(false);
	this.btQuitter.setBounds(1000,400,100,30);
	this.add(this.btQuitter);
	
	//construction du panel Profil
	this.panelProfil.setBounds(20, 40, 200, 200);
	this.panelProfil.setBackground(Color.CYAN);
	this.panelProfil.setLayout(new GridLayout(5, 1));
	this.panelProfil.add(new JLabel("Bienvenue à l'espace Administration Fnac"));
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

