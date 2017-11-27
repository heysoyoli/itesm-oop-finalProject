import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;

////FALTA ATACAR CON ARMA, ATACAR CON HABILIDAD, MOSTAR IMAGENES, ATACAR SOLO

public class Ventana extends JFrame{

    //PANELES y SCROLL
    private JPanel panelPrincipal,panelInfo,panelTexto,panelAccion, panelImagenItem, 
    panelItems,panelImagenArma,panelArmas,panelRespuestas, panelStats, panelImagenMochila, panelHistoria;
    private JScrollPane scrollP;

    //LABELS Y BOTONES
    private JLabel historiaTitle, historia, statVida, statPos, statAtaque, imagenMochila, historiaLabel, backgroundLabel;
    private JButton cambiarHistoria, atacar, guardarItem, guardarArma, usarItem, guardarJuego;
    private JRadioButton guardarSlot1, guardarSlot2, guardarSlot3, guardarSlot4;
    private ButtonGroup grupoGuardar, grupoGuardar2;

    //IMAGENES
    private ImageIcon diamante;
    private ImageIcon backgroundBosque, backgroundInfierno;

    //INSTANCIAS NECESARIAS PARA INICIAR
    private Humano humano;
    private Ayudante ayudante;
    private Mapa mapa;
    private Mochila mochila;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //INICIALIZAR VENTANA
    public Ventana(){

        setLayout(new GridBagLayout());
        setTitle("RPG");
        
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setSize(1000, 800);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
     }

    public void initComponents(){
        //THIS PART WORKS
        /*panelHistoria = new JPanel();
        panelImagen = new JPanel();
        add(panelHistoria);
        add(panelImagen);*/

        ////CONSTRAINTS FOR PERCENTAGES
        //THIS CREATES THE CONSTRAINTS FOR THE UPPER PART OF THE DISPLAY
        GridBagConstraints c= new GridBagConstraints();
        c.fill= GridBagConstraints.BOTH; 
        c.weighty=70;
        c.weightx=100;
        c.gridx=0;
        c.gridy=0;
        panelPrincipal= new PanelPrincipal();
        panelPrincipal.setLayout(new GridBagLayout());


        //THIS CREATES THE CONSTRAINTS FOR THE 
        GridBagConstraints cPrincipal= new GridBagConstraints();
        cPrincipal.fill= GridBagConstraints.BOTH;
        cPrincipal.weighty=100;
        cPrincipal.weightx=30;
        cPrincipal.gridx= 0;
        cPrincipal.gridy=0;


        //CREATING PANELS
        //PANEL TEXTO - DISPLAYS WHAT THE AYUDANTE SAYS
        panelTexto= new PanelTexto(); 
        historiaLabel= new JLabel();
        scrollP= new JScrollPane();

        scrollP.setViewportView(panelTexto);
        scrollP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        panelTexto.add(historiaLabel);
        scrollP.add(panelTexto);
        
        //MAIN PANEL - THIS WILL CONTAIN THE HISTORY PANEL AND THE IMAGES PANEL
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

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //ELEMENTOS DE ARRIBA
        backgroundLabel = new JLabel();
        panelAccion.add(backgroundLabel);


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //ELEMENTOS DE ABAJO
        //RESPUESTAS - IMAGEN MOCHILA - ITEMS - ARMAS - STATS

        //AVANZAR Y CONTESTAR PREGUNTAS
        cambiarHistoria = new JButton("Avanzar");
        cambiarHistoria.addActionListener(new ListenerAvanzar());
        panelRespuestas.add(cambiarHistoria);

        //IMAGEN DE MOCHILA
        imagenMochila = new JLabel(new ImageIcon("images/diamante.png"));
        panelImagenMochila.add(imagenMochila);

       
        //GRUPO PARA GUARDAR ITEMS
        //BOTONES PARA GUARDAR ITEMS Y USAR ITEMS
        guardarSlot1 = new JRadioButton("Guardar Item Aqui", false);
        guardarSlot2 = new JRadioButton("Guardar Item Aqui", false);
        grupoGuardar = new ButtonGroup();
        grupoGuardar.add(guardarSlot1);
        grupoGuardar.add(guardarSlot2);
        panelItems.add(guardarSlot1);
        panelItems.add(guardarSlot2);

        guardarItem = new JButton("Guardar Item");
        guardarItem.addActionListener( new ListenerGuardarItem());
        panelItems.add(guardarItem);

        usarItem = new JButton("Usar Item");
        usarItem.addActionListener(new ListenerUsarItem());
        panelItems.add(usarItem);


        //IMAGEN DE ITEMS


        //GRUPO PARA GUARDAR ARMAS
        //BOTONES PARA GUARDAR ARMAS Y USAR ARMAS
        guardarSlot3 = new JRadioButton("Guardar Arma Aqui", false);
        guardarSlot4 = new JRadioButton("Guardar Arma Aqui", false);
        grupoGuardar2 = new ButtonGroup();
        grupoGuardar2.add(guardarSlot3);
        grupoGuardar2.add(guardarSlot4);
        panelArmas.add(guardarSlot3);
        panelArmas.add(guardarSlot4);

        atacar = new JButton("Atacar");
        atacar.addActionListener(new ListenerAtacar());
        panelArmas.add(atacar);

        guardarArma = new JButton("Guardar Arma");
        guardarArma.addActionListener( new ListenerGuardarArma());
        panelArmas.add(guardarArma);


        //IMAGEN DE ARMAS


        //DISPLAY DE STATS DEL JUGADOR
        statVida = new JLabel("Vida");
        statPos =new JLabel("Posicion");
        statAtaque = new JLabel("Ataque");
        panelStats.add(statVida);
        panelStats.add(statPos);
        panelStats.add(statAtaque);

        guardarJuego = new JButton("Guardar Juego");
        guardarJuego.addActionListener( new ListenerGuardarJuego());
        panelStats.add(guardarJuego);


        //ESTADOS INICIALES DE LOS BOTONES
        cambiarHistoria.setEnabled(true);


        guardarSlot3.setEnabled(false);
        guardarSlot4.setEnabled(false);
        guardarArma.setEnabled(false);
        atacar.setEnabled(false);
       
        guardarSlot1.setEnabled(false);
        guardarSlot2.setEnabled(false);
        guardarItem.setEnabled(false);
        usarItem.setEnabled(false);

        //INIZIALIZAR EL JUEGO
        onStart();
    }



    //INICIALIZA LAS INSTANCIAS NECESARIAS Y COMIENZA EL JUEGO
    public void onStart(){
    	mapa = new Mapa();
    	mapa.crearCasillasDefault();
    	mapa.crearCasillasA();
    	mapa.crearCasillasB();

        backgroundInfierno = new ImageIcon("images/infierno-back-heroe.jpg");
        backgroundLabel.setIcon(backgroundInfierno);

        humano = new Humano(0, "oliver", 20, 5);
        mochila = new Mochila();
        ayudante = new Ayudante();

        historiaLabel.setText(ayudante.contarHistoria(humano.getPos()));
    }


    //METODO PARA AVANZAR DE CASILLA
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

            //historiaLabel.setText("Esta es la casilla: " + humano.getPos());
            contarHistoria();



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

  
    //METODOS PARA GUARDAR Y USAR ITEMS
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


    //METODOS PARA GUARDAR Y USAR ARMAS
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

    public class ListenerAtacar implements ActionListener{
        public void actionPerformed(ActionEvent event){

            int vidaEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getVida();
            int vidaHumano = humano.getVida();
            int ataqueHumano = humano.getPuntosAtaque();
            int ataqueEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getPuntosAtaque();

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
        }
    }


    //METODO PARA GUARDAR JUEGO
    public class ListenerGuardarJuego implements ActionListener{
        public void actionPerformed (ActionEvent event){
            System.out.println("Guardaste el juego");
            System.exit(1);
        }
    }
    


    public void contarHistoria(){
            String historia= "<html>";

            historia=historia + ayudante.contarHistoria(humano.getPos()) + ayudante.explicarContenido(mapa.getCasillas()[humano.getPos()]);
            
            historia=historia+"<html>";
            historiaLabel.setText(historia);
    }


}
