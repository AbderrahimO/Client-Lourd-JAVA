package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controleur.Article;
import controleur.Alume;

public class PanelAjout extends PanelCentral implements ActionListener 
{
	private JTextField txtcode_art = new JTextField();  // on declare les zone de txt
	private JTextField txtnoma = new JTextField(); 
	private JTextField txtprixa = new JTextField(); 
	private JTextField txtqte = new JTextField(); 
	
	private JButton btAnnuler = new JButton("Annuler");
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	public PanelAjout()
	{
		super();
		this.setLayout(new GridLayout(5,2));
		this.add(new JLabel("Code Art :"));
		this.add(this.txtcode_art);
		this.add(new JLabel("Nom :"));
		this.add(this.txtnoma);
		this.add(new JLabel("Prix :"));
		this.add(this.txtprixa);
		this.add(new JLabel("Quantite :"));
		this.add(this.txtqte);
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
			this.txtnoma.setText("");
			this.txtprixa.setText("");
			this.txtqte.setText("");
		}
		else if (e.getSource()== this.btEnregistrer)
		{
			String noma = this.txtnoma.getText();
			String code = this.txtcode_art.getText();
			float prixa = 0;
			int qte = 0;
			try {
				prixa = Float.parseFloat(this.txtprixa.getText());
				qte = Integer.parseInt(this.txtqte.getText());
			}
			catch (NumberFormatException exp)
			{
				this.txtprixa.setBackground(Color.red);
				this.txtqte.setBackground(Color.red);
			}
			if (noma.equals("") || prixa <=0 || qte <=0)
			{
				JOptionPane.showMessageDialog(this, "Erreur de saisie de données", "Erreur", JOptionPane.ERROR_MESSAGE);
			}else {
				//insertion dans la bdd 
				Article unArticle = new Article(code, noma, prixa+"", qte+"");
				Alume.insertArticle(unArticle);
				JOptionPane.showMessageDialog(this, "Insertion reussie de l'article","Information", JOptionPane.INFORMATION_MESSAGE);
				
				unArticle = Alume.selectWhereArticle (unArticle);
				
				Object ligne[] = {
			unArticle.getCode_art(),unArticle.getNoma(),unArticle.getPrixa(), unArticle.getQte()};
				
				PanelLister.getUnTableau().addRow(ligne);
				}
					this.setVisible(false);
				
			}
		}
		
	}
