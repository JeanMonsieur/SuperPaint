/**
 * 
 */
package ca.csf.dfc.TP;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * @author Sam
 * Classe repr�sentant l'interface de travail de l'utilisateur
 */
public class EspaceDeTravail extends JFrame{

	private Button btnCouleur = new Button("Couleur");
	private Button btnEpaisseurDuTrait = new Button("Trait");
	private Button btnCouleurRemplissage = new Button("Remplissage");
	private JButton btnLigne = new JButton();
	private JButton btnRectangle = new JButton();
	private JButton btnEllipse = new JButton();
	
	private JLabel lblEspaceDeDessin = new JLabel();
	
	private JMenuItem itmNouveau = new JMenuItem("Nouveau");
	private JMenuItem itmCharger = new JMenuItem("Charger");
	private JMenuItem itmEnregistrer = new JMenuItem("Enregistrer");
	private JMenuItem itmExporterSVG = new JMenuItem("Exporter au format SVG");
	private JMenuItem itmQuitter = new JMenuItem("Quitter");
	private JMenuItem itmRedimensionner = new JMenuItem("Redimensionner");
	private JMenuItem itmAPropos = new JMenuItem("� propos");
	
		
	public EspaceDeTravail() {
		super("SuperPaint");
		this.setLayout(new BorderLayout());
		
		PersonnaliserPlancheADessins();
		AjouterBarreProprietes();
		JPanel panneauHaut = AjouterMenuPrincipal();
		AjouterIconesAuxBouttons();
		AjouterBarreDOutilsFormes(panneauHaut);
		
		
		this.setSize(600, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void AjouterBarreProprietes() {
		
		JPanel panneauGauche = new JPanel();
		JToolBar barreProprietes = new JToolBar(null, JToolBar.VERTICAL);
		barreProprietes.add(this.btnCouleur);
		barreProprietes.add(this.btnEpaisseurDuTrait);
		barreProprietes.add(this.btnCouleurRemplissage);
		
		panneauGauche.setLayout(new GridLayout(3,1));
		panneauGauche.add(barreProprietes);
		this.add(panneauGauche,BorderLayout.WEST);	
	}
	private JPanel AjouterMenuPrincipal() {
		
		JPanel panneauHaut = new JPanel();
		panneauHaut.setLayout(new GridLayout(2,1));
		JMenuBar menuPrincipal = new JMenuBar();
		menuPrincipal.setBackground(Color.WHITE);
		JMenu menuFichiers = new JMenu("Fichier");
		JMenu menuAffichage = new JMenu("Affichage");
		JMenu menuAide = new JMenu("Aide");
		
		menuFichiers.add(this.itmNouveau);
		menuFichiers.add(this.itmCharger);
		menuFichiers.add(this.itmEnregistrer);
		menuFichiers.add(this.itmExporterSVG);
		menuFichiers.addSeparator();
		menuFichiers.add(this.itmQuitter);
		menuAffichage.add(this.itmRedimensionner);
		menuAide.add(this.itmAPropos);
			
		menuPrincipal.add(menuFichiers);
		menuPrincipal.add(menuAffichage);
		menuPrincipal.add(menuAide);
		
		panneauHaut.add(menuPrincipal);
		
		return panneauHaut;
	}
	
	private void AjouterIconesAuxBouttons() {
		
		Image imageLigne = new ImageIcon("src/img/ligne.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon iconLigne = new ImageIcon(imageLigne);
		this.btnLigne.setIcon(iconLigne);
		this.btnLigne.setToolTipText("Dessiner une ligne");
		this.btnLigne.setBackground(Color.cyan);
		
		Image imageRectangle = new ImageIcon("src/img/rectangle.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon iconRectangle = new ImageIcon(imageRectangle);
		this.btnRectangle.setIcon(iconRectangle);
		this.btnRectangle.setToolTipText("Dessiner un rectangle");
		this.btnRectangle.setBackground(Color.MAGENTA);
		
		Image imageEllipse = new ImageIcon("src/img/ellipse.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		ImageIcon iconEllipse = new ImageIcon(imageEllipse);
		this.btnEllipse.setIcon(iconEllipse);
		this.btnEllipse.setToolTipText("Dessiner une ellipse");
		this.btnEllipse.setBackground(Color.YELLOW);
	}
	private void AjouterBarreDOutilsFormes(JPanel p_JPanel) {
		
		JToolBar barreOutilsFormes = new JToolBar();
		barreOutilsFormes.setFloatable(false);
		barreOutilsFormes.addSeparator();
		barreOutilsFormes.add(this.btnLigne);
		barreOutilsFormes.addSeparator();
		barreOutilsFormes.add(this.btnRectangle);
		barreOutilsFormes.addSeparator();
		barreOutilsFormes.add(this.btnEllipse);
		barreOutilsFormes.addSeparator();
		
		p_JPanel.add(barreOutilsFormes);
		this.add(p_JPanel,BorderLayout.NORTH);
		
	}
	private void PersonnaliserPlancheADessins() {
		this.lblEspaceDeDessin.setBackground(Color.white);
		this.lblEspaceDeDessin.setOpaque(true);
		this.add(this.lblEspaceDeDessin,BorderLayout.CENTER);
	}
	
}
