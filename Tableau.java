package controleur;

import javax.swing.table.AbstractTableModel;

public class Tableau extends AbstractTableModel
{
	private Object donnees [][];
	private String entetes [];
	public Tableau (Object donnees[][], String entetes[])
	{
		this.donnees = donnees;
		this.entetes = entetes ;
	}

	@Override
	public int getColumnCount() {
		
		return this.entetes.length;
	}

	@Override
	public int getRowCount() {
		
		return this.donnees.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return this.donnees[rowIndex][columnIndex];
	}

	@Override
	public String getColumnName(int column) {
		
		return this.entetes[column];
	}

	public void deleteRow(int ligneSelectionnee) 
	{
		Object matrice [][] = new Object [this.donnees.length -1][this.entetes.length -1];
		int j = 0 ;
		for (int i = 0; i<this.donnees.length; i++)
		{ 
			if(i !=ligneSelectionnee)
			{
			matrice [j] = this.donnees[i];
			j++ ;
			}
		}
		this.donnees = matrice ;
		this.fireTableDataChanged();
	} 

	
	public void addRow (Object ligne[])
	{
		Object matrice [][] = new Object [this.donnees.length +1][this.entetes.length +1];
		for (int i = 0; i<this.donnees.length; i++)
		{
			matrice [i] = this.donnees[i];
		} 
		matrice[this.donnees.length] = ligne ;
		this.donnees = matrice ;
		this.fireTableDataChanged();
		
	}
	public void updateRow(Object[] ligne, int ligneSelectionnee)
	{
		this.donnees[ligneSelectionnee] = ligne ;
		this.fireTableDataChanged();
	}
	
}
