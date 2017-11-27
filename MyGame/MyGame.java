import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;


public class MyGame extends JFrame{
	
	private JPanel panelPrincipal,panelInfo,panelTexto,panelAccion, panelImagenItem, 
	panelItems,panelImagenArma,panelArmas,panelRespuestas, panelStats, panelImagenMochila, panelHistoria;
	private JScrollPane scrollP;
	private JLabel historiaLabel;
	
	public MyGame(){
	
		setLayout(new GridBagLayout());
		setTitle("My game");
		
		initComponents();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	public void initComponents(){
	
		//Inception
		/*panelHistoria= new PanelHistoria();
		TitledBorder titleHistoria = BorderFactory.createTitledBorder("Historia");
		panelHistoria.setBorder(titleHistoria);
		panelHistoria.add(panelTexto);
		
	*/
	
		GridBagConstraints c= new GridBagConstraints();
		c.fill= GridBagConstraints.BOTH; 
		c.weighty=70;
		c.weightx=100;
		c.gridx=0;
		c.gridy=0;
		panelPrincipal= new PanelPrincipal();
		panelPrincipal.setLayout(new GridBagLayout());
		
		GridBagConstraints cPrincipal= new GridBagConstraints();
		cPrincipal.fill= GridBagConstraints.BOTH;
		cPrincipal.weighty=100;
		cPrincipal.weightx=30;
		cPrincipal.gridx= 0;
		cPrincipal.gridy=0;
		
		panelTexto= new PanelTexto(); 
		//TitledBorder titleTexto = BorderFactory.createTitledBorder("Historia");
		historiaLabel= new JLabel();
		contarHistoria();
		scrollP= new JScrollPane();
		scrollP.setViewportView(historiaLabel);
		scrollP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		//panelTexto.add(historiaLabel);
		scrollP.add(panelTexto);
		//panelTexto.setBorder(titleTexto);
		
		panelPrincipal.add(panelHistoria,cPrincipal);
		cPrincipal= new GridBagConstraints();
		cPrincipal.fill= GridBagConstraints.BOTH;
		cPrincipal.weighty=100;
		cPrincipal.weightx=70;
		cPrincipal.gridx= 1;
		cPrincipal.gridy=0;
		panelAccion= new PanelAccion();
		TitledBorder titleAccion = BorderFactory.createTitledBorder("Mapa");
		panelAccion.setBorder(titleAccion);
		panelPrincipal.add(panelAccion, cPrincipal);
		
		add(panelPrincipal,c);
		//PanelInfo
		c.fill= new GridBagConstraints().BOTH;
		c.gridx=0;
		c.gridy=1;
		c.weighty=30;
		c.weightx=100;
		//
		panelRespuestas= new PanelRespuestas();
		panelRespuestas.add(new JLabel ("panelRespuestas"));
		TitledBorder titleRespuestas = BorderFactory.createTitledBorder("Respuestas");
		panelRespuestas.setBorder(titleRespuestas);
		//
		panelInfo= new PanelInfo();
		panelInfo.setLayout(new GridBagLayout());
		TitledBorder titleInfo = BorderFactory.createTitledBorder("");
		panelInfo.setBorder(titleInfo);
		//
		panelItems= new PanelItems();
		panelItems.add(new JLabel ("Items"));
		TitledBorder titleItems = BorderFactory.createTitledBorder("Tus items");
		panelItems.setBorder(titleItems);
		//
		panelImagenItem= new PanelImagenItem();
		panelImagenItem.add(new JLabel ("ImagenItem"));
		TitledBorder titleImagenItems = BorderFactory.createTitledBorder("Item seleccionado");
		panelImagenItem.setBorder(titleImagenItems);
		//
		panelArmas= new PanelArmas();
		panelArmas.add(new JLabel ("Armas"));
		TitledBorder titleArmas = BorderFactory.createTitledBorder("Tus armas");
		panelArmas.setBorder(titleArmas);
		//
		panelImagenArma= new PanelImagenArma();
		panelImagenArma.add(new JLabel ("Imagen Arma"));
		TitledBorder titleImagenArma = BorderFactory.createTitledBorder("Arma seleccionada");
		panelImagenArma.setBorder(titleImagenArma);
		//
		panelStats= new PanelStats();
		panelStats.add(new JLabel ("Stats"));
		TitledBorder titleStats = BorderFactory.createTitledBorder("Stats");
		panelStats.setBorder(titleStats);
		//
		panelImagenMochila = new PanelImagenMochila();
		panelImagenMochila.add(new JLabel("Mochila"));
		TitledBorder titleMochila = BorderFactory.createTitledBorder("Tu mochila");
		panelImagenMochila.setBorder(titleMochila);
		
		//C info
		//0
		GridBagConstraints cInfo= new GridBagConstraints();
		cInfo.fill= GridBagConstraints.BOTH;
		cInfo.weighty=100;
		cInfo.weightx=14.28;
		cInfo.gridx= 0;
		cInfo.gridy=0;
		panelInfo.add(panelRespuestas, cInfo);
		
		
		//1
		cInfo= new GridBagConstraints();
		cInfo.fill= GridBagConstraints.BOTH;
		cInfo.weighty=100;
		cInfo.weightx=14.28;
		cInfo.gridx= 1;
		cInfo.gridy=0;
		panelInfo.add(panelImagenMochila, cInfo);
			
		//2
		cInfo= new GridBagConstraints();
		cInfo.fill= GridBagConstraints.BOTH;
		cInfo.weighty=100;
		cInfo.weightx=14.28;
		cInfo.gridx= 2;
		cInfo.gridy=0;
		panelInfo.add(panelItems, cInfo);
		
		//3
		cInfo= new GridBagConstraints();
		cInfo.fill= GridBagConstraints.BOTH;
		cInfo.weighty=100;
		cInfo.weightx=14.28;
		cInfo.gridx= 3;
		cInfo.gridy=0; 
		panelInfo.add(panelImagenItem, cInfo);
		
		//4
		cInfo= new GridBagConstraints();
		cInfo.fill= GridBagConstraints.BOTH;
		cInfo.weighty=100;
		cInfo.weightx=14.28;
		cInfo.gridx= 4;
		cInfo.gridy=0;
		panelInfo.add(panelArmas, cInfo);
		
		//5
		cInfo= new GridBagConstraints();
		cInfo.fill= GridBagConstraints.BOTH;
		cInfo.weighty=100;
		cInfo.weightx=14.28;
		cInfo.gridx= 5;
		cInfo.gridy=0;
		panelInfo.add(panelImagenArma, cInfo);
		
		//6
		cInfo= new GridBagConstraints();
		cInfo.fill= GridBagConstraints.BOTH;
		cInfo.weighty=100;
		cInfo.weightx=14.28;
		cInfo.gridx= 6;
		cInfo.gridy=0;
		panelInfo.add(panelStats, cInfo);
		
		//C principales
		add(panelInfo,c);
		
		}
		
		public void contarHistoria(){
			String historia= "<html>";
			for(int i=0;i<100; i++){
				historia=historia+"Te cuento esta historia por"+i+"vez."+"<br/>";
			}
			historia=historia+"<html>";
			historiaLabel.setText(historia);
		}
}

					
		
