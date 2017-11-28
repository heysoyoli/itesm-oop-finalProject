import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.concurrent.ThreadLocalRandom;
import java.io.*;


public class Ventana extends JFrame{

    private int x;

    //PANELES y SCROLL
    private JPanel panelPrincipal,panelInfo,panelTexto,panelAccion, panelImagenItem, 
    panelItems,panelImagenArma,panelArmas,panelRespuestas, panelStats, panelImagenMochila, panelHistoria, panelScroll;
    private JScrollPane scrollP;

    //LABELS Y BOTONES
    private JLabel historiaTitle, historia, statVida, statPos, statAtaque, statVidaEnemigo, imagenMochila, 
    historiaLabel, backgroundLabel, imagenArmaLabel, imagenItemLabel;
    private JButton cambiarHistoria, atacar, guardarItem, guardarArma, usarItem, atacarRespuesta,  guardarJuego, cargarJuego;
    private JRadioButton guardarSlot1, guardarSlot2, guardarSlot3, guardarSlot4, respuestaA, respuestaB, respuestaC;
    private ButtonGroup grupoGuardar, grupoGuardar2, grupoRespuestas;

    //IMAGENES
    //private ImageIcon diamante;
    private ImageIcon backgroundBosque, backgroundInfierno;
    private JFileChooser fc;

    //INSTANCIAS NECESARIAS PARA INICIAR
    private Humano humano;
    private Ayudante ayudante;
    private Mapa mapa;
    private Mochila mochila;
    private PoolPreguntas preguntas;
    private Game game;

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
        fc = new JFileChooser();


        ////CONSTRAINTS FOR PERCENTAGES
        //THIS CREATES THE CONSTRAINTS FOR THE WHOLE UPPER PART OF THE DISPLAY
        GridBagConstraints c= new GridBagConstraints();
        c.fill= GridBagConstraints.BOTH; 
        c.weighty=70;
        c.weightx=100;
        c.gridx=0;
        c.gridy=0;

        panelPrincipal= new PanelPrincipal();
        panelPrincipal.setLayout(new GridBagLayout());


        //THIS CREATES THE CONSTRAINTS FOR THE SUBPANELS IN THE UPPER AREA
 

        //CREATING PANELS
        //PANEL TEXTO - DISPLAYS WHAT THE AYUDANTE SAYS
        GridBagConstraints cPrincipal= new GridBagConstraints();
        cPrincipal.fill= GridBagConstraints.BOTH;
        cPrincipal.weighty=100;
        cPrincipal.weightx=45;
        cPrincipal.gridx= 0;
        cPrincipal.gridy=0;


        panelScroll = new JPanel();
        panelScroll.setLayout(new GridLayout(1,1));
        scrollP= new JScrollPane();
        panelTexto= new PanelTexto();
        panelTexto.setLayout(new GridLayout(1,1));
        historiaLabel= new JLabel();
        historiaLabel.setForeground(Color.white);

        scrollP.setViewportView(panelTexto);
        scrollP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
       
        panelTexto.add(historiaLabel);  
        panelScroll.add(scrollP);
        panelPrincipal.add(panelScroll, cPrincipal);

    
        
        //MAIN PANEL - THIS WILL CONTAIN THE HISTORY PANEL AND THE IMAGES PANEL
        cPrincipal= new GridBagConstraints();
        cPrincipal.fill= GridBagConstraints.BOTH;
        cPrincipal.weighty=100;
        cPrincipal.weightx=55;
        cPrincipal.gridx= 1;
        cPrincipal.gridy=0;
        panelAccion= new PanelAccion();
        //panelAccion.setLayout(new GridLayout(1,1));
        TitledBorder titleAccion = BorderFactory.createTitledBorder("Mapa");
        panelAccion.setBorder(titleAccion);
        panelPrincipal.add(panelAccion, cPrincipal);

        add(panelPrincipal,c);




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //CONSTRAINTS FOR THE WHOLE LOWER PART
        c.fill= new GridBagConstraints().BOTH;
        c.gridx=0;
        c.gridy=1;
        c.weighty=30;
        c.weightx=100;

        //CREATES ALL LOWER PANELS

        //FATHER PANEL
        panelInfo= new PanelInfo();
        panelInfo.setLayout(new GridBagLayout());
        TitledBorder titleInfo = BorderFactory.createTitledBorder("");
        panelInfo.setBorder(titleInfo);

        //RESPUESTAS
        panelRespuestas= new PanelRespuestas();
        panelRespuestas.setLayout(new GridLayout(5, 1));
        TitledBorder titleRespuestas = BorderFactory.createTitledBorder("Respuestas");
        panelRespuestas.setBorder(titleRespuestas);


        //MOCHILA
        panelImagenMochila = new PanelImagenMochila();
        panelImagenMochila.setLayout(new GridLayout(1,1));
        TitledBorder titleMochila = BorderFactory.createTitledBorder("Tu mochila");
        panelImagenMochila.setBorder(titleMochila);
        
  
        //ITEMS
        panelItems= new PanelItems();
        //panelItems.add(new JLabel ("Items"));
        panelItems.setLayout(new GridLayout(4, 1));
        TitledBorder titleItems = BorderFactory.createTitledBorder("Tus items");
        panelItems.setBorder(titleItems);

        panelImagenItem= new PanelImagenItem();
        panelImagenItem.setLayout(new GridLayout(1,1));
        TitledBorder titleImagenItems = BorderFactory.createTitledBorder("Item seleccionado");
        panelImagenItem.setBorder(titleImagenItems);
        

        //ARMAS
        panelArmas= new PanelArmas();
        //panelArmas.add(new JLabel ("Armas"));
        panelArmas.setLayout(new GridLayout(4, 1));
        TitledBorder titleArmas = BorderFactory.createTitledBorder("Tus armas");
        panelArmas.setBorder(titleArmas);
        
        panelImagenArma= new PanelImagenArma();
        panelImagenArma.setLayout(new GridLayout(1,1));
        TitledBorder titleImagenArma = BorderFactory.createTitledBorder("Arma seleccionada");
        panelImagenArma.setBorder(titleImagenArma);
        

        //STATS
        panelStats= new PanelStats();
        //panelStats.add(new JLabel ("Stats"));
        panelStats.setLayout(new GridLayout(6, 1));
        TitledBorder titleStats = BorderFactory.createTitledBorder("Stats");
        panelStats.setBorder(titleStats);
        
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        //ADDS ALL SUBPANLES AND SUBCONSTRAINTS TO PANEL INFO
        //ADD RESPUESTAS
        GridBagConstraints cInfo= new GridBagConstraints();
        cInfo.fill= GridBagConstraints.BOTH;
        cInfo.weighty=100;
        cInfo.weightx=14.28;
        cInfo.gridx= 0;
        cInfo.gridy=0;
        panelInfo.add(panelRespuestas, cInfo);
        
        
        //ADD MOCHILA
        cInfo= new GridBagConstraints();
        cInfo.fill= GridBagConstraints.BOTH;
        cInfo.weighty=100;
        cInfo.weightx=14.28;
        cInfo.gridx= 1;
        cInfo.gridy=0;
        panelInfo.add(panelImagenMochila, cInfo);
            
        //ADD ITEMS
        cInfo= new GridBagConstraints();
        cInfo.fill= GridBagConstraints.BOTH;
        cInfo.weighty=100;
        cInfo.weightx=14.28;
        cInfo.gridx= 2;
        cInfo.gridy=0;
        panelInfo.add(panelItems, cInfo);
        
    
        cInfo= new GridBagConstraints();
        cInfo.fill= GridBagConstraints.BOTH;
        cInfo.weighty=100;
        cInfo.weightx=14.28;
        cInfo.gridx= 3;
        cInfo.gridy=0; 
        panelInfo.add(panelImagenItem, cInfo);
        
        //ADD ARMAS
        cInfo= new GridBagConstraints();
        cInfo.fill= GridBagConstraints.BOTH;
        cInfo.weighty=100;
        cInfo.weightx=14.28;
        cInfo.gridx= 4;
        cInfo.gridy=0;
        panelInfo.add(panelArmas, cInfo);
        
        
        cInfo= new GridBagConstraints();
        cInfo.fill= GridBagConstraints.BOTH;
        cInfo.weighty=100;
        cInfo.weightx=14.28;
        cInfo.gridx= 5;
        cInfo.gridy=0;
        panelInfo.add(panelImagenArma, cInfo);
        
        //STATS
        cInfo= new GridBagConstraints();
        cInfo.fill= GridBagConstraints.BOTH;
        cInfo.weighty=100;
        cInfo.weightx=14.28;
        cInfo.gridx= 6;
        cInfo.gridy=0;
        panelInfo.add(panelStats, cInfo);
        
        //ADDS PANEL INFO TO FRAME
        add(panelInfo,c);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //ELEMENTOS DE ARRIBA
        backgroundLabel = new JLabel();
        panelAccion.add(backgroundLabel);


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //ELEMENTOS DE ABAJO
        //RESPUESTAS - IMAGEN MOCHILA - ITEMS - ARMAS - STATS

        //AVANZAR Y CONTESTAR PREGUNTAS

        respuestaA = new JRadioButton("Respuesta A");
        respuestaB = new JRadioButton("Respuesta B"); 
        respuestaC = new JRadioButton("Respuesta C");
        grupoRespuestas = new ButtonGroup();
        grupoRespuestas.add(respuestaA);
        grupoRespuestas.add(respuestaB);
        grupoRespuestas.add(respuestaC);
        panelRespuestas.add(respuestaA);
        panelRespuestas.add(respuestaB);
        panelRespuestas.add(respuestaC);

        atacarRespuesta = new JButton("Atacar con Respuesta");
        atacarRespuesta.addActionListener(new ListenerAtacarRespuesta());
        panelRespuestas.add(atacarRespuesta);

        cambiarHistoria = new JButton("Avanzar");
        cambiarHistoria.addActionListener(new ListenerAvanzar());
        panelRespuestas.add(cambiarHistoria);

        //IMAGEN DE MOCHILA
        imagenMochila = new JLabel(new ImageIcon("images/objects/mochila.png"));
        panelImagenMochila.add(imagenMochila);

       
        //GRUPO PARA GUARDAR ITEMS
        //BOTONES PARA GUARDAR ITEMS Y USAR ITEMS
        guardarSlot1 = new JRadioButton("Espacio Vacio");
        guardarSlot2 = new JRadioButton("Espacio Vacio");
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
        imagenItemLabel = new JLabel( new ImageIcon("images/objects/pocima.png"));
        panelImagenItem.add(imagenItemLabel);


        //GRUPO PARA GUARDAR ARMAS
        //BOTONES PARA GUARDAR ARMAS Y USAR ARMAS
        guardarSlot3 = new JRadioButton("Espacio Vacio");
        guardarSlot4 = new JRadioButton("Espacio Vacio");
        grupoGuardar2 = new ButtonGroup();
        grupoGuardar2.add(guardarSlot3);
        grupoGuardar2.add(guardarSlot4);
        panelArmas.add(guardarSlot3);
        panelArmas.add(guardarSlot4);

        guardarArma = new JButton("Guardar Arma");
        guardarArma.addActionListener( new ListenerGuardarArma());
        panelArmas.add(guardarArma);

        atacar = new JButton("Atacar");
        atacar.addActionListener(new ListenerAtacar());
        panelArmas.add(atacar);

        


        //IMAGEN DE ARMAS
        imagenArmaLabel = new JLabel(new ImageIcon("images/objects/espada.png"));
        panelImagenArma.add(imagenArmaLabel);

        //DISPLAY DE STATS DEL JUGADOR
        statVida = new JLabel("Vida");
        statPos =new JLabel("Posicion");
        statAtaque = new JLabel("Ataque");
        statVidaEnemigo = new JLabel("Vida del Enemigo");
        panelStats.add(statVida);
        panelStats.add(statPos);
        panelStats.add(statAtaque);
        panelStats.add(statVidaEnemigo);


        guardarJuego = new JButton("Guardar Juego");
        guardarJuego.addActionListener( new ListenerGuardarJuego());
        panelStats.add(guardarJuego);

        cargarJuego = new JButton("Cargar Juego");
        cargarJuego.addActionListener (new ListenerCargarJuego());
        panelStats.add(cargarJuego);


        //ESTADOS INICIALES DE LOS BOTONES
        respuestaA.setEnabled(false);
        respuestaB.setEnabled(false);
        respuestaC.setEnabled(false);
        atacarRespuesta.setEnabled(false);
        cambiarHistoria.setEnabled(true);

        guardarSlot1.setEnabled(false);
        guardarSlot2.setEnabled(false);
        guardarItem.setEnabled(false);
        usarItem.setEnabled(false);

        guardarSlot3.setEnabled(false);
        guardarSlot4.setEnabled(false);
        guardarArma.setEnabled(false);
        atacar.setEnabled(false);

        guardarJuego.setEnabled(false);
       

        //INIZIALIZAR EL JUEGO
        onStart();
    }



    //INICIALIZA LAS INSTANCIAS NECESARIAS Y COMIENZA EL JUEGO
    public void onStart(){

        game = new Game();

    	mapa = new Mapa();
    	mapa.crearCasillasDefault();
    	mapa.crearCasillasA();
    	mapa.crearCasillasB();
        mapa.setHistoria("<html>");

        preguntas = new PoolPreguntas();
        preguntas.crearPreguntas();

        backgroundInfierno = new ImageIcon("images/background/bosque.png");
        backgroundLabel.setIcon(backgroundInfierno);

        humano = new Humano(0, "oliver", 20, 5);
        mochila = new Mochila();
        ayudante = new Ayudante();

        historiaLabel.setText(ayudante.contarHistoria(humano.getPos()));

        game.setHumano(humano);
        game.setMapa(mapa);
    }


    //METODO PARA AVANZAR DE CASILLA
    public class ListenerAvanzar implements ActionListener{
        public void actionPerformed(ActionEvent event){

            //SETS POSITION WITHIN THE MAP
            humano.setPos(humano.getPos() + 1);

            game.setHumano(humano);
            game.setMapa(mapa);

            if(humano.getPos() == 26){
                System.exit(0);
            }

            //DISPLAYS BACKGROUND
            displayBackground(humano.getPos());

            contarHistoria();



            //UPDATES STATS
            statPos.setText("Estas en la casilla: " + humano.getPos() + " de 25" );
            statVida.setText("Tu vida es de: " + humano.getVida());
            statAtaque.setText("Tu fuerza de ataque es de: " + humano.getPuntosAtaque());

            //contarHistoria();

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //STATES FOR BUTTONS

            
            switch(mapa.getCasillas()[humano.getPos()].getTipoContenido()){
                case 0:
                    guardarSlot1.setEnabled(true);
                    guardarSlot2.setEnabled(true);
                    guardarItem.setEnabled(true);
                    usarItem.setEnabled(true);
                break;

                case 1:
                    guardarSlot3.setEnabled(true);
                    guardarSlot4.setEnabled(true);
                    atacar.setEnabled(true);
                    guardarSlot1.setEnabled(true);
                    guardarSlot2.setEnabled(true);
                    usarItem.setEnabled(true);
                    guardarItem.setEnabled(false);

                    respuestaA.setEnabled(true);
                    respuestaB.setEnabled(true);
                    respuestaC.setEnabled(true);
                    atacarRespuesta.setEnabled(true);
                    cambiarHistoria.setEnabled(false);

                    statVidaEnemigo.setText("Vida Enemigo: " + mapa.getCasillas()[humano.getPos()].getEnemigo().getVida());



                    x = ThreadLocalRandom.current().nextInt(0, 11 + 1);

                    String hist = mapa.getHistoria();
                    mapa.setHistoria(hist +  "<br/>" + preguntas.getPreguntas()[x].getPregunta() + "<br/>" + preguntas.getPreguntas()[x].getA() + "<br/>" + preguntas.getPreguntas()[x].getB() + "<br/>" + preguntas.getPreguntas()[x].getC() + "<br/>" );


                    if(humano.getPos() <15){
                    backgroundInfierno = new ImageIcon("images/background/defaultFantasma.jpg");
                    backgroundLabel.setIcon(backgroundInfierno);
                    }else if(humano.getPos() == 24){
                    backgroundInfierno = new ImageIcon("images/background/final.jpg");
                    backgroundLabel.setIcon(backgroundInfierno);
                    }else{
                    backgroundInfierno = new ImageIcon("images/background/castilloFantasma.jpg");
                    backgroundLabel.setIcon(backgroundInfierno);
                    }

                    historiaLabel.setText(mapa.getHistoria());

                break;

                case 2:

                    guardarArma.setEnabled(true);
                    guardarSlot3.setEnabled(true);
                    guardarSlot4.setEnabled(true);
                    cambiarHistoria.setEnabled(false);

                break;

                default:

                    cambiarHistoria.setEnabled(true);
                    respuestaA.setEnabled(false);
                    respuestaB.setEnabled(false);
                    respuestaC.setEnabled(false);
                    atacarRespuesta.setEnabled(false);

                    guardarSlot1.setEnabled(false);
                    guardarSlot2.setEnabled(false);
                    guardarItem.setEnabled(false);
                    usarItem.setEnabled(false);

                    guardarSlot3.setEnabled(false);
                    guardarSlot4.setEnabled(false);
                    guardarArma.setEnabled(false);
                    atacar.setEnabled(false);

                    guardarJuego.setEnabled(true);

                break;

            }
    }
}

  
    //METODOS PARA GUARDAR Y USAR ITEMS
    public class ListenerUsarItem implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(guardarSlot1.isSelected()){
                if(mochila.getItems()[0] != null){
                   
                    humano.setVida(humano.getVida() + mochila.getItems()[0].getUpPuntosVida());

                    String hist = mapa.getHistoria();
                    mapa.setHistoria(hist +  "<br/>" + "Usaste un item para curarte. Tu vida ahora es de" + humano.getVida());
                    historiaLabel.setText(mapa.getHistoria());

                    guardarSlot1.setText("Vacio");

                    statVida.setText("Tu vida es de: " + humano.getVida());
                    mochila.getItems()[0] = null;
                }else{
                    String hist = mapa.getHistoria();
                    mapa.setHistoria(hist +  "<br/>" + "No hay nada aqui." + "<br/>");
                    historiaLabel.setText(mapa.getHistoria());
                }
            }else if(guardarSlot2.isSelected()){
                if(mochila.getItems()[1] != null){
                    

                    humano.setVida(humano.getVida() + mochila.getItems()[1].getUpPuntosVida());

                    String hist = mapa.getHistoria();
                    mapa.setHistoria(hist +  "<br/>" + "Usaste un item para curarte. Tu vida ahora es de" + humano.getVida());
                    historiaLabel.setText(mapa.getHistoria());

                    statVida.setText("Tu vida es de: " + humano.getVida());

                    guardarSlot2.setText("Vacio");

                    mochila.getItems()[1] = null;
                }else{
                    String hist = mapa.getHistoria();
                    mapa.setHistoria(hist +  "<br/>" + "No hay nada aqui." + "<br/>");
                    historiaLabel.setText(mapa.getHistoria());
                }
            }
        }
    }

    public class ListenerGuardarItem implements ActionListener{
        public void actionPerformed(ActionEvent event){

            if(guardarSlot1.isSelected()){


                mochila.guardarItem(mapa.getCasillas()[humano.getPos()].getItem(), 0);

                guardarSlot1.setText(mapa.getCasillas()[humano.getPos()].getItem().getNombre());
                guardarSlot1.setEnabled(false);
                guardarSlot2.setEnabled(false);
                guardarItem.setEnabled(false);
                usarItem.setEnabled(false);
                cambiarHistoria.setEnabled(true);

                String hist = mapa.getHistoria();
                mapa.setHistoria(hist +  "<br/>" + "Guardaste un " + mapa.getCasillas()[humano.getPos()].getItem().getNombre() + " en tu mochila." + "<br/>");
                historiaLabel.setText(mapa.getHistoria());

            }else if(guardarSlot2.isSelected()){
                mochila.guardarItem(mapa.getCasillas()[humano.getPos()].getItem(), 1);

                guardarSlot2.setText(mapa.getCasillas()[humano.getPos()].getItem().getNombre());
                guardarSlot1.setEnabled(false);
                guardarSlot2.setEnabled(false);
                guardarItem.setEnabled(false);
                usarItem.setEnabled(false);
                cambiarHistoria.setEnabled(true);

                String hist = mapa.getHistoria();
                mapa.setHistoria(hist +  "<br/>" + "Guardaste un " + mapa.getCasillas()[humano.getPos()].getItem().getNombre() + " en tu mochila." + "<br/>");
                historiaLabel.setText(mapa.getHistoria());
            }
        }
    }


    //METODOS PARA GUARDAR Y USAR ARMAS
    public class ListenerGuardarArma implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(guardarSlot3.isSelected()){

                mochila.guardarArma(mapa.getCasillas()[humano.getPos()].getArma(), 0);

                guardarSlot3.setText(mapa.getCasillas()[humano.getPos()].getArma().getNombre());
                guardarSlot3.setEnabled(false);
                guardarSlot4.setEnabled(false);
                guardarArma.setEnabled(false);
                cambiarHistoria.setEnabled(true);

                String hist = mapa.getHistoria();
                mapa.setHistoria(hist +  "<br/>" + "Guardaste un " + mapa.getCasillas()[humano.getPos()].getArma().getNombre() + " en tu mochila." + "<br/>");
                historiaLabel.setText(mapa.getHistoria());
               

            }else if(guardarSlot4.isSelected()){
                mochila.guardarArma(mapa.getCasillas()[humano.getPos()].getArma(), 1);

                guardarSlot4.setText(mapa.getCasillas()[humano.getPos()].getArma().getNombre());
                guardarSlot3.setEnabled(false);
                guardarSlot4.setEnabled(false);
                guardarArma.setEnabled(false);
                cambiarHistoria.setEnabled(true);

                String hist = mapa.getHistoria();
                mapa.setHistoria(hist +  "<br/>" + "Guardaste un " + mapa.getCasillas()[humano.getPos()].getArma().getNombre() + " en tu mochila." + "<br/>");
                historiaLabel.setText(mapa.getHistoria());
            }
        }
    }

    public class ListenerAtacar implements ActionListener{
        public void actionPerformed(ActionEvent event){

            int vidaEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getVida();
            int vidaHumano = humano.getVida();
            int ataqueHumano = humano.getPuntosAtaque();
            int ataqueEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getPuntosAtaque();

            

            if(guardarSlot3.isSelected()){

                if(mochila.getArmas()[0] != null){

                    mapa.getCasillas()[humano.getPos()].getEnemigo().setVida(vidaEnemigo - (ataqueHumano + mochila.getArmas()[0].getGainPuntosAtaque()));

                    String hist = mapa.getHistoria();
                    mapa.setHistoria(hist +  "<br/>" + "La vida del enemigo es de: " + mapa.getCasillas()[humano.getPos()].getEnemigo().getVida() + "<br/>");
                    historiaLabel.setText(mapa.getHistoria());

                    statVidaEnemigo.setText("Vida Enemigo: " + mapa.getCasillas()[humano.getPos()].getEnemigo().getVida());
                }
            }else if(guardarSlot4.isSelected()){

                if(mochila.getArmas()[1] != null){

                    mapa.getCasillas()[humano.getPos()].getEnemigo().setVida(vidaEnemigo - (ataqueHumano + mochila.getArmas()[1].getGainPuntosAtaque()));
                    
                    String hist = mapa.getHistoria();
                    mapa.setHistoria(hist +  "<br/>" + "La vida del enemigo es de: " + mapa.getCasillas()[humano.getPos()].getEnemigo().getVida() + "<br/>");
                    historiaLabel.setText(mapa.getHistoria());
                    statVidaEnemigo.setText("Vida Enemigo: " + mapa.getCasillas()[humano.getPos()].getEnemigo().getVida());
                }
            } else{
                    mapa.getCasillas()[humano.getPos()].getEnemigo().setVida(vidaEnemigo - ataqueHumano);

                    String hist = mapa.getHistoria();
                    mapa.setHistoria(hist +  "<br/>" + "La vida del enemigo es de: " + mapa.getCasillas()[humano.getPos()].getEnemigo().getVida() + "<br/>");
                    historiaLabel.setText(mapa.getHistoria());

                    statVidaEnemigo.setText("Vida Enemigo: " + mapa.getCasillas()[humano.getPos()].getEnemigo().getVida());
                }
        

            contraAtacar(mapa.getCasillas()[humano.getPos()].getEnemigo().getVida());


        }
    }


    public void contraAtacar(int vidaEnemigo){


            int vidaHumano = humano.getVida();
            int ataqueEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getPuntosAtaque();

        if(vidaEnemigo > 0){
                String hist = mapa.getHistoria();
                mapa.setHistoria(hist +  "<br/>" + "El enemigo sigue vivo, te atacara ahora" + "<br/>"+ "Tu vida ahora es de: " + (vidaHumano - ataqueEnemigo));
                historiaLabel.setText(mapa.getHistoria());

                humano.setVida(vidaHumano - ataqueEnemigo);
                statVida.setText("Tu vida es de " + humano.getVida());

                cambiarHistoria.setEnabled(false);


            }else if(vidaEnemigo <= 0){

                String hist = mapa.getHistoria();
                mapa.setHistoria(hist +  "<br/>" + "Derrotaste el enemigo! Puedes continuar con tu viaje" + "<br/>");
                historiaLabel.setText(mapa.getHistoria());

                cambiarHistoria.setEnabled(true);
                guardarSlot3.setEnabled(false);
                guardarSlot4.setEnabled(false);
                atacar.setEnabled(false);
                respuestaA.setEnabled(false);
                respuestaB.setEnabled(false);
                respuestaC.setEnabled(false);
                atacarRespuesta.setEnabled(false);

                 statVidaEnemigo.setText("Vida Enemigo");
            }

            if(humano.getVida() <= 0 ){
                historiaLabel.setText("GAME OVER");
            }

    }      


    //METODO PARA GUARDAR JUEGO
    public class ListenerGuardarJuego implements ActionListener{
        public void actionPerformed (ActionEvent event){
            try{

                FileOutputStream fout = new FileOutputStream("partida.rpg");
                ObjectOutputStream oos = new ObjectOutputStream(fout);
                oos.writeObject(game);
                oos.close();

            }catch(FileNotFoundException e){
                System.out.println("No existe el archivo");
            }catch(IOException exception){
                System.out.println("Ocurrio IO exception");
            }
        }
    }

    public class ListenerCargarJuego implements ActionListener{
        public void actionPerformed(ActionEvent event){
            int fileChooserResponse = fc.showOpenDialog(null);
            if(fileChooserResponse == JFileChooser.APPROVE_OPTION){
                try{
                    File file = fc.getSelectedFile();
                    FileInputStream fis = new FileInputStream(file);
                    ObjectInputStream ios = new ObjectInputStream(fis);
                    game = (Game) ios.readObject();
                }catch(IOException e){
                    System.out.println("Ocurrio un IO exception");   
                }catch(ClassNotFoundException e){
                    System.out.println("NO se encontro la clase");
                }
                //SET GAME
            }
        }
    }

    public class ListenerAtacarRespuesta implements ActionListener{
        public void actionPerformed(ActionEvent event){

            int vidaEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getVida();
            //System.out.println(preguntas.getPreguntas()[x].getPregunta());
            //System.out.println(preguntas.getPreguntas()[x].getCorrecta());

            if(respuestaA.isSelected()){
                if("a" == preguntas.getPreguntas()[x].getCorrecta()){
                    mapa.getCasillas()[humano.getPos()].getEnemigo().setVida(vidaEnemigo - 10 );

                    String hist = mapa.getHistoria();
                    mapa.setHistoria(hist +  "<br/>" + "Correcto! Le restaste 10 puntos de vida al Fantasma" + "<br/>");
                    historiaLabel.setText(mapa.getHistoria());
                    statVidaEnemigo.setText("Vida Enemigo: " + mapa.getCasillas()[humano.getPos()].getEnemigo().getVida());
                    atacarRespuesta.setEnabled(false);
                }
            }else if (respuestaB.isSelected()){
                if("b" == preguntas.getPreguntas()[x].getCorrecta()){
                    mapa.getCasillas()[humano.getPos()].getEnemigo().setVida(vidaEnemigo - 10 );

                    String hist = mapa.getHistoria();
                    mapa.setHistoria(hist +  "<br/>" + "Correcto! Le restaste 10 puntos de vida al Fantasma" + "<br/>");
                    historiaLabel.setText(mapa.getHistoria());
                    statVidaEnemigo.setText("Vida Enemigo: " + mapa.getCasillas()[humano.getPos()].getEnemigo().getVida());
                    atacarRespuesta.setEnabled(false);
                }
            }else if(respuestaC.isSelected()){
                if("c"== preguntas.getPreguntas()[x].getCorrecta()){
                    mapa.getCasillas()[humano.getPos()].getEnemigo().setVida(vidaEnemigo - 10 );
                    String hist = mapa.getHistoria();
                    mapa.setHistoria(hist +  "<br/>" + "Correcto! Le restaste 10 puntos de vida al Fantasma" + "<br/>");
                    historiaLabel.setText(mapa.getHistoria());
                    statVidaEnemigo.setText("Vida Enemigo: " + mapa.getCasillas()[humano.getPos()].getEnemigo().getVida());
                    atacarRespuesta.setEnabled(false);
                }
            }else{
                        String hist = mapa.getHistoria();
                        mapa.setHistoria(hist +  "<br/>" + "La opcion no era correcta" + "<br/>");
                        historiaLabel.setText(mapa.getHistoria());
                    }
            }
        }
   


    //HANDLES BACKGROUND IMAGES
    public void displayBackground(int posicion){
        switch(posicion){
            case 0:
                backgroundInfierno = new ImageIcon("images/background/bosque.png");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            case 1:
                backgroundInfierno = new ImageIcon("images/background/carta.png");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            case 15:
                backgroundInfierno = new ImageIcon("images/background/castillo.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

              case 16:
                backgroundInfierno = new ImageIcon("images/background/castillo.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            case 17:
                backgroundInfierno = new ImageIcon("images/background/castillo.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            case 18:
                backgroundInfierno = new ImageIcon("images/background/castillo.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            case 19:
                backgroundInfierno = new ImageIcon("images/background/castillo.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            case 20:
                backgroundInfierno = new ImageIcon("images/background/castillo.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            case 21:
                backgroundInfierno = new ImageIcon("images/background/castillo.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            case 22:
               backgroundInfierno = new ImageIcon("images/background/castillo.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

             case 23:
               backgroundInfierno = new ImageIcon("images/background/castillo.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            case 24:
                backgroundInfierno = new ImageIcon("images/background/final.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            case 25:
                backgroundInfierno = new ImageIcon("images/background/cielo.png");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            default:
                backgroundInfierno = new ImageIcon("images/background/defaultAlone.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;
        }

    }
    


    //HANDLES THE SOTRY FROM AYUDANTE
    public void contarHistoria(){
                
            String hist = mapa.getHistoria();
            mapa.setHistoria(hist +  "<br/>" + ayudante.contarHistoria(humano.getPos()) + "<br/>" + ayudante.explicarContenido(mapa.getCasillas()[humano.getPos()]) + "<br/>");
            
            historiaLabel.setText(mapa.getHistoria());
    }



//GUARDAR, AGREGAR FANTASMAS Y OTRAS IMAGENES


//VOLVER INTENTAR, EXCEPCIONES, RESIZE IMAGEN ACCION, CLASES ABSTRACTAS


// MAS PREGUNTAS




}
