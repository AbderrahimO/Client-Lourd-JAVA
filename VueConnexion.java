package vue;
import javax.swing.*;

import controleur.Alume;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class VueConnexion extends JFrame implements ActionListener, KeyListener
{
	private JPanel unPanel = new JPanel ();
	private JTextField txtEmail = new JTextField();
	private JPasswordField txtMdp = new JPasswordField();
	private JButton btAnnuler = new JButton(new ImageIcon("src/images/annuler.PNG"));
	private JButton btSeconnecter = new JButton (new ImageIcon("src/images/coo.PNG"));
	
	
	public VueConnexion()
	{
		this.setTitle("Connexion de l'application Alume");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(200, 200, 800, 500);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		
		//construction du Panel
		this.unPanel.setBounds(350, 30, 350, 410);
		this.unPanel.setBackground(new Color(30,127,203));
		this.unPanel.setLayout(new GridLayout(3,3));
		this.unPanel.add(new JLabel("Email: "));
		this.unPanel.add(this.txtEmail);
		this.unPanel.add(new JLabel("MDP :"));
		this.unPanel.add(this.txtMdp);
		this.unPanel.add(this.btAnnuler);
		this.unPanel.add(this.btSeconnecter);
		
		
		this.add(this.unPanel);
		
		//changement de la police 
		Font unePolice = new Font("Arial", Font.ITALIC,18);
		for (int i =0; i<this.unPanel.getComponentCount(); i++)
		{
			this.unPanel.getComponent(i).setFont(unePolice);
		}
		//insertion du Logo 
		ImageIcon uneImage = new ImageIcon("src/images/alu.JPG");
		JLabel monImage = new JLabel(uneImage);
		monImage.setBounds(40,90,260,300);
		this.add(monImage);
		
		//rendre les deux boutons cliquables 
		this.btAnnuler.addActionListener(this);
		this.btSeconnecter.addActionListener(this);
	
		//rendre les Text champs ecoutables
		this.txtEmail.addKeyListener(this);
		this.txtMdp.addKeyListener(this);
	
		
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== this.btSeconnecter)
		{
			String email = this.txtEmail.getText();
			String mdp = new String (this.txtMdp.getPassword());
			//verifier la connexion : 
			
			Alume.verifConnexion (email, mdp);
			this.txtEmail.setText("");
			this.txtMdp.setText("");
		} else if (e.getSource() == this.btAnnuler) {
			this.txtEmail.setText("");
						this.txtMdp.setText("");
						
		}
		
	}

	@Override
    public void keyPressed(KeyEvent e) 
	{
        
        if (e.getKeyCode() == KeyEvent.VK_ENTER) 
        {
            String email = this.txtEmail.getText();
            String mdp = new String (this.txtMdp.getPassword());
            //verifier la connexion : 
            Alume.verifConnexion(email, mdp);
            this.txtEmail.setText("");
			this.txtMdp.setText("");
			
            }
        }
	
		
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
		
	}
}
