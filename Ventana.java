import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

////FALTA ATACAR CON ARMA, ATACAR CON HABILIDAD, MOSTAR IMAGENES, ATACAR SOLO

public class Ventana extends JFrame{

    private JPanel panelPrincipal,panelInfo,panelTexto,panelAccion, panelImagenItem, 
    panelItems,panelImagenArma,panelArmas,panelRespuestas, panelStats, panelImagenMochila, panelHistoria;
    private JScrollPane scrollP;
    private JLabel historiaLabel;

    private JLabel historiaTitle, historia, statVida, statPos, statAtaque, imagenMochila;
    private JButton cambiarHistoria, atacar, guardarItem, guardarArma, usarItem;
    private JPanel  panelImagen;
    private JRadioButton guardarSlot1, guardarSlot2, guardarSlot3, guardarSlot4;
    private ButtonGroup grupoGuardar, grupoGuardar2;

    private Humano humano;
    private Ayudante ayudante;
    private Mapa mapa;
    private Mochila mochila;


    //private String historia;
    private ImageIcon diamante;


    public Ventana(){

        setLayout(new GridBagLayout());
        setTitle("RPG");
        
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setSize(1000, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //setSize(600,1000);
        /*setTitle("Mi Rpg");
        setLayout(new GridLayout(2,1));
        initComponents();

        setSize(800, 400);

        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);*/
    }

    public void initComponents(){
        //THIS PART WORKS
        /*panelHistoria = new JPanel();
        panelImagen = new JPanel();
        add(panelHistoria);
        add(panelImagen);*/

        ////CONSTRAINTS FOR PERCENTAGES

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
        historiaLabel= new JLabel();
        //cambiarHistoria();
        scrollP= new JScrollPane();
        scrollP.setViewportView(historiaLabel);
        scrollP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollP.add(panelTexto);
        
        panelPrincipal.add(panelTexto,cPrincipal);
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
        //panelRespuestas.add(new JLabel ("panelRespuestas"));
        TitledBorder titleRespuestas = BorderFactory.createTitledBorder("Respuestas");
        panelRespuestas.setBorder(titleRespuestas);
        //
        panelInfo= new PanelInfo();
        panelInfo.setLayout(new GridBagLayout());
        TitledBorder titleInfo = BorderFactory.createTitledBorder("");
        panelInfo.setBorder(titleInfo);
        //
        panelItems= new PanelItems();
        //panelItems.add(new JLabel ("Items"));
        TitledBorder titleItems = BorderFactory.createTitledBorder("Tus items");
        panelItems.setBorder(titleItems);
        //
        panelImagenItem= new PanelImagenItem();
        panelImagenItem.add(new JLabel ("ImagenItem"));
        TitledBorder titleImagenItems = BorderFactory.createTitledBorder("Item seleccionado");
        panelImagenItem.setBorder(titleImagenItems);
        //
        panelArmas= new PanelArmas();
        //panelArmas.add(new JLabel ("Armas"));
        TitledBorder titleArmas = BorderFactory.createTitledBorder("Tus armas");
        panelArmas.setBorder(titleArmas);
        //
        panelImagenArma= new PanelImagenArma();
        panelImagenArma.add(new JLabel ("Imagen Arma"));
        TitledBorder titleImagenArma = BorderFactory.createTitledBorder("Arma seleccionada");
        panelImagenArma.setBorder(titleImagenArma);
        //
        panelStats= new PanelStats();
        //panelStats.add(new JLabel ("Stats"));
        TitledBorder titleStats = BorderFactory.createTitledBorder("Stats");
        panelStats.setBorder(titleStats);
        
        //
        panelImagenMochila = new PanelImagenMochila();
        panelImagenMochila.add(new JLabel("Mochila"));
        TitledBorder titleMochila = BorderFactory.createTitledBorder("Tu mochila");
        panelImagenMochila.setBorder(titleMochila);
        //panelImagenMochila.setSize(40,40);
        
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


        /*historiaTitle = new JLabel("Historia");
        panelHistoria.add(historiaTitle);

        historia = new JLabel();
        panelHistoria.add(historia);*/

        /////
        ////
        ///
        //
        ///
        ////
        ///

        /*mochila = new ImageIcon("diamante.png"); // load the image to a imageIcon
        Image image = mochila.getImage(); // transform it 
        Image newimg = image.getScaledInstance(40, 40,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        mochila = new ImageIcon(newimg);  // transform it back*/
        imagenMochila = new JLabel(new ImageIcon("diamante.png"));
        panelImagenMochila.add(imagenMochila);

        cambiarHistoria = new JButton("Avanzar");
        cambiarHistoria.addActionListener(new ListenerAvanzar());
        panelRespuestas.add(cambiarHistoria);

        atacar = new JButton("Atacar");
        atacar.addActionListener(new ListenerAtacar());
        panelArmas.add(atacar);


        guardarSlot1 = new JRadioButton("Guardar en slot 1", false);
        guardarSlot2 = new JRadioButton("Guardar en slot 2", false);
        grupoGuardar = new ButtonGroup();
        grupoGuardar.add(guardarSlot1);
        grupoGuardar.add(guardarSlot2);
        panelItems.add(guardarSlot1);
        panelItems.add(guardarSlot2);


        guardarSlot3 = new JRadioButton("Guardar en slot 3", false);
        guardarSlot4 = new JRadioButton("Guardar en slot 4", false);
        grupoGuardar2 = new ButtonGroup();
        grupoGuardar2.add(guardarSlot3);
        grupoGuardar2.add(guardarSlot4);
        panelArmas.add(guardarSlot3);
        panelArmas.add(guardarSlot4);


        guardarItem = new JButton("Guardar Item");
        guardarItem.addActionListener( new ListenerGuardarItem());
        panelItems.add(guardarItem);

        usarItem = new JButton("Usar Item");
        usarItem.addActionListener(new ListenerUsarItem());
        panelItems.add(usarItem);

        guardarArma = new JButton("Guardar Arma");
        guardarArma.addActionListener( new ListenerGuardarArma());
        panelArmas.add(guardarArma);

        statVida = new JLabel("Vida");
        statPos =new JLabel("Posicion");
        statAtaque = new JLabel("Ataque");
        panelStats.add(statVida);
        panelStats.add(statPos);
        panelStats.add(statAtaque);

        atacar.setEnabled(false);
        guardarArma.setEnabled(false);
        guardarItem.setEnabled(false);
        guardarSlot1.setEnabled(false);
        guardarSlot2.setEnabled(false);
        guardarSlot3.setEnabled(false);
        guardarSlot4.setEnabled(false);
        usarItem.setEnabled(false);
        cambiarHistoria.setEnabled(true);

        onStart();
    }

    public void onStart(){
    	mapa = new Mapa();
    	mapa.crearCasillasDefault();
    	mapa.crearCasillasA();
    	mapa.crearCasillasB();

        humano = new Humano(0, "oliver", 20, 5);
        mochila = new Mochila();

        ayudante = new Ayudante();
        ayudante.contarHistoria(humano.getPos());


        //System.out.println(ayudante.contarHistoria(humano));
    }


    public class ListenerAvanzar implements ActionListener{
        public void actionPerformed(ActionEvent event){
            humano.setPos(humano.getPos() + 1);
			System.out.println("(" + humano.getPos() + ")" + "---- " + mapa.getCasillas()[humano.getPos()].getHistoria());

			historiaLabel.setText(ayudante.contarHistoria(humano.getPos()));

            ayudante.explicarContenido(mapa.getCasillas()[humano.getPos()]);

            usarItem.setEnabled(true);

            statPos.setText("Estas en la casilla: " + humano.getPos() + " de 25" );
            statVida.setText("Tu vida es de: " + humano.getVida());
            statAtaque.setText("Tu fuerza de ataque es de: " + humano.getPuntosAtaque());



            if(mapa.getCasillas()[humano.getPos()].getTipoContenido() == 1){
                atacar.setEnabled(true);
                guardarItem.setEnabled(false);
                guardarArma.setEnabled(false);
                guardarSlot1.setEnabled(false);
                guardarSlot2.setEnabled(false);
                cambiarHistoria.setEnabled(false);
            }else if(mapa.getCasillas()[humano.getPos()].getTipoContenido() == 0){
                guardarItem.setEnabled(true);
                atacar.setEnabled(false);
                guardarSlot1.setEnabled(true);
                guardarSlot2.setEnabled(true);
                guardarArma.setEnabled(false);
                cambiarHistoria.setEnabled(true);
            }else if(mapa.getCasillas()[humano.getPos()].getTipoContenido() == 2){
                guardarItem.setEnabled(false);
                guardarArma.setEnabled(true);
                guardarSlot3.setEnabled(true);
                guardarSlot4.setEnabled(true);
                atacar.setEnabled(false);
                cambiarHistoria.setEnabled(false);
            }else{
                guardarItem.setEnabled(false);
                guardarArma.setEnabled(false);
                guardarSlot1.setEnabled(false);
                guardarSlot2.setEnabled(false);
                atacar.setEnabled(false);
                cambiarHistoria.setEnabled(true);
            }
            //System.out.println("La posicion del humano es " + humano.getPos());
        }
    }

    public class ListenerAtacar implements ActionListener{
        public void actionPerformed(ActionEvent event){

            int vidaEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getVida();
            int vidaHumano = humano.getVida();
            int ataqueHumano = humano.getPuntosAtaque();
            int ataqueEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getPuntosAtaque();

            //System.out.println(vidaEnemigo);
            //System.out.println(ataqueEnemigo);

            

            if(guardarSlot1.isSelected()){
                if(mochila.getArmas()[0] != null){
                    mapa.getCasillas()[humano.getPos()].getEnemigo().setVida(vidaEnemigo - (ataqueHumano + mochila.getArmas()[0].getGainPuntosAtaque()));
                    vidaEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getVida();
                    System.out.println("La vida del enemigo es de: " + vidaEnemigo);
                }else{
                    System.out.println("Este slot esta vacio, usa otra arama o ataca con habilidad o solo");
                }
            }else if(guardarSlot2.isSelected()){
                if(mochila.getArmas()[1] != null){
                    mapa.getCasillas()[humano.getPos()].getEnemigo().setVida(vidaEnemigo - (ataqueHumano + mochila.getArmas()[1].getGainPuntosAtaque()));
                    vidaEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getVida();
                    System.out.println("La vida del enemigo es de: " + vidaEnemigo);
                }else{
                    System.out.println("Este slot esta vacio, usa otra arama o ataca con habilidad o solo");
                }
            }



                    /*mapa.getCasillas()[humano.getPos()].getEnemigo().setVida(vidaEnemigo - ataqueHumano);
                    vidaEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getVida();
                    System.out.println("La vida del enemigo es de: " + vidaEnemigo);*/



            if(vidaEnemigo > 0){
                System.out.println("El enemigo sigue vivo, te atacara ahora");
                humano.setVida(vidaHumano - ataqueEnemigo);
                System.out.println("Tu vida ahora es de:" + humano.getVida());
            }else if(vidaEnemigo <= 0){
                System.out.println("Derrotaste el enemigo! Puedes continuar con tu viaje");
                cambiarHistoria.setEnabled(true);
                atacar.setEnabled(false);
            }

            if(humano.getVida() <= 0 ){
                System.out.println("GAME OVER");
                System.exit(0);

            }



            //System.out.println("El Humano ataco al enemigo");
        }
    }

    public class ListenerGuardarItem implements ActionListener{
        public void actionPerformed(ActionEvent event){

            if(guardarSlot1.isSelected()){
                mochila.guardarItem(mapa.getCasillas()[humano.getPos()].getItem(),0);
                guardarItem.setEnabled(false);
                System.out.println("Guardaste un " + mapa.getCasillas()[humano.getPos()].getItem().getNombre() + " en tu mochila");
            }else if(guardarSlot2.isSelected()){
                mochila.guardarItem(mapa.getCasillas()[humano.getPos()].getItem(), 1);
                guardarItem.setEnabled(false);
                System.out.println("Guardaste un " + mapa.getCasillas()[humano.getPos()].getItem().getNombre() + " en tu mochila");
            }
        }
    }

    public class ListenerGuardarArma implements ActionListener{
        public void actionPerformed(ActionEvent event){

            if(guardarSlot3.isSelected()){
                mochila.guardarArma(mapa.getCasillas()[humano.getPos()].getArma(), 0);
                guardarArma.setEnabled(false);
                cambiarHistoria.setEnabled(true);
                System.out.println("Guardaste un " + mapa.getCasillas()[humano.getPos()].getArma().getNombre() + " en tu mochila slot 1");
            }else if(guardarSlot4.isSelected()){
                mochila.guardarArma(mapa.getCasillas()[humano.getPos()].getArma(), 1);
                guardarArma.setEnabled(false);
                cambiarHistoria.setEnabled(true);
                System.out.println("Guardaste un " + mapa.getCasillas()[humano.getPos()].getArma().getNombre() + " en tu mochila slot 2");
            }
        }
    }

    public class ListenerUsarItem implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(guardarSlot1.isSelected()){
                if(mochila.getItems()[0] != null){
                    System.out.println("Usaste " + mochila.getItems()[0].getNombre() + " de tu mochila");
                    humano.setVida(humano.getVida() + mochila.getItems()[0].getUpPuntosVida());
                    System.out.println("Tu vida ahora es de" + humano.getVida());
                    mochila.getItems()[0] = null;
                }else{
                    System.out.println("Este slot esta vacio");
                }
            }else if(guardarSlot2.isSelected()){
                if(mochila.getItems()[1] != null){
                    System.out.println("Usaste " + mochila.getItems()[1].getNombre() + " de tu mochila");
                    humano.setVida(humano.getVida() + mochila.getItems()[1].getUpPuntosVida());
                    System.out.println("Tu vida ahora es de" + humano.getVida());
                    mochila.getItems()[1] = null;
                }else{
                    System.out.println("Este slot esta vacio");
                }
            }
        }
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
