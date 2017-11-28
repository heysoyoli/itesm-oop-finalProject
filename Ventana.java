import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import java.util.concurrent.ThreadLocalRandom;

////FALTA ATACAR CON ARMA, ATACAR CON HABILIDAD, MOSTAR IMAGENES, ATACAR SOLO

public class Ventana extends JFrame{

    private int x;

    //PANELES y SCROLL
    private JPanel panelPrincipal,panelInfo,panelTexto,panelAccion, panelImagenItem, 
    panelItems,panelImagenArma,panelArmas,panelRespuestas, panelStats, panelImagenMochila, panelHistoria;
    private JScrollPane scrollP;

    //LABELS Y BOTONES
    private JLabel historiaTitle, historia, statVida, statPos, statAtaque, statVidaEnemigo, imagenMochila, 
    historiaLabel, backgroundLabel, imagenArmaLabel, imagenItemLabel;
    private JButton cambiarHistoria, atacar, guardarItem, guardarArma, usarItem, atacarRespuesta,  guardarJuego;
    private JRadioButton guardarSlot1, guardarSlot2, guardarSlot3, guardarSlot4, respuestaA, respuestaB, respuestaC;
    private ButtonGroup grupoGuardar, grupoGuardar2, grupoRespuestas;

    //IMAGENES
    private ImageIcon diamante;
    private ImageIcon backgroundBosque, backgroundInfierno;

    //INSTANCIAS NECESARIAS PARA INICIAR
    private Humano humano;
    private Ayudante ayudante;
    private Mapa mapa;
    private Mochila mochila;
    private PoolPreguntas preguntas;

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
        cPrincipal.weightx=40;
        cPrincipal.gridx= 0;
        cPrincipal.gridy=0;

        scrollP= new JScrollPane();
        panelTexto= new PanelTexto(); 
        historiaLabel= new JLabel();

        scrollP.setViewportView(panelTexto);
        scrollP.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollP.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        scrollP.add(panelTexto);
        panelTexto.add(historiaLabel);
        
        panelPrincipal.add(panelTexto, cPrincipal);

        
        //MAIN PANEL - THIS WILL CONTAIN THE HISTORY PANEL AND THE IMAGES PANEL
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




//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //CONSTRAINTS FOR THE WHOLE LOWER PART
        c.fill= new GridBagConstraints().BOTH;
        c.gridx=0;
        c.gridy=1;
        c.weighty=30;
        c.weightx=100;

        //FATHER PANEL
        panelInfo= new PanelInfo();
        panelInfo.setLayout(new GridBagLayout());
        TitledBorder titleInfo = BorderFactory.createTitledBorder("");
        panelInfo.setBorder(titleInfo);

        //RESPUESTAS
        panelRespuestas= new PanelRespuestas();
        TitledBorder titleRespuestas = BorderFactory.createTitledBorder("Respuestas");
        panelRespuestas.setBorder(titleRespuestas);


        //MOCHILA
        panelImagenMochila = new PanelImagenMochila();
        TitledBorder titleMochila = BorderFactory.createTitledBorder("Tu mochila");
        panelImagenMochila.setBorder(titleMochila);
        
  
        //ITEMS
        panelItems= new PanelItems();
        //panelItems.add(new JLabel ("Items"));
        TitledBorder titleItems = BorderFactory.createTitledBorder("Tus items");
        panelItems.setBorder(titleItems);

        panelImagenItem= new PanelImagenItem();
        TitledBorder titleImagenItems = BorderFactory.createTitledBorder("Item seleccionado");
        panelImagenItem.setBorder(titleImagenItems);
        

        //ARMAS
        panelArmas= new PanelArmas();
        //panelArmas.add(new JLabel ("Armas"));
        TitledBorder titleArmas = BorderFactory.createTitledBorder("Tus armas");
        panelArmas.setBorder(titleArmas);
        //
        panelImagenArma= new PanelImagenArma();
        TitledBorder titleImagenArma = BorderFactory.createTitledBorder("Arma seleccionada");
        panelImagenArma.setBorder(titleImagenArma);
        

        //STATS
        panelStats= new PanelStats();
        //panelStats.add(new JLabel ("Stats"));
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
        respuestaC = new JRadioButton("Respuesta c");
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
        imagenItemLabel = new JLabel( new ImageIcon("images/pocima.png"));
        panelImagenItem.add(imagenItemLabel);


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
        imagenArmaLabel = new JLabel(new ImageIcon("images/espada.png"));
        panelImagenArma.add(imagenArmaLabel);

        //DISPLAY DE STATS DEL JUGADOR
        statVida = new JLabel("Vida");
        statPos =new JLabel("Posicion");
        statAtaque = new JLabel("Ataque");
        statVidaEnemigo = new JLabel("Vida del Enemigo");
        panelStats.add(statVida);
        panelStats.add(statPos);
        panelStats.add(statAtaque);
        //panelStats.add(statVidaEnemigo);


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

        preguntas = new PoolPreguntas();
        preguntas.crearPreguntas();

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

            //SETS POSITION WITHIN THE MAP
            humano.setPos(humano.getPos() + 1);

            //DISPLAYS BACKGROUND
            displayBackground(humano.getPos());


            //TELLS STORY FOR THAT CASILLA OR CONTET
			historiaLabel.setText("(" + humano.getPos() + ")" + "---- " + mapa.getCasillas()[humano.getPos()].getHistoria());

			historiaLabel.setText(ayudante.contarHistoria(humano.getPos()));

            ayudante.explicarContenido(mapa.getCasillas()[humano.getPos()]);



            //UPDATES STATS
            statPos.setText("Estas en la casilla: " + humano.getPos() + " de 25" );
            statVida.setText("Tu vida es de: " + humano.getVida());
            statAtaque.setText("Tu fuerza de ataque es de: " + humano.getPuntosAtaque());

            //contarHistoria();

            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //STATES FOR BUTTONS

            cambiarHistoria.setEnabled(true);

            guardarSlot1.setEnabled(false);
            guardarSlot2.setEnabled(false);
            guardarItem.setEnabled(false);
            usarItem.setEnabled(false);

            guardarSlot3.setEnabled(false);
            guardarSlot4.setEnabled(false);
            guardarArma.setEnabled(false);
            atacar.setEnabled(false);

            guardarJuego.setEnabled(true);


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


                    x = ThreadLocalRandom.current().nextInt(0, 9 + 1);

                    System.out.println(preguntas.getPreguntas()[x].getPregunta() + "\n");
                    System.out.println(preguntas.getPreguntas()[x].getA());
                    System.out.println(preguntas.getPreguntas()[x].getB());
                    System.out.println(preguntas.getPreguntas()[x].getC());
                break;

                case 2:

                    guardarArma.setEnabled(true);
                    guardarSlot3.setEnabled(true);
                    guardarSlot4.setEnabled(true);
                    cambiarHistoria.setEnabled(false);

                break;

                default:

                break;

            }
    }
}

  
    //METODOS PARA GUARDAR Y USAR ITEMS
    public class ListenerUsarItem implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(guardarSlot1.isSelected()){
                if(mochila.getItems()[0] != null){
                    System.out.println("Usaste " + mochila.getItems()[0].getNombre() + " de tu mochila");
                    humano.setVida(humano.getVida() + mochila.getItems()[0].getUpPuntosVida());
                    historiaLabel.setText("Tu vida ahora es de" + humano.getVida());
                    statVida.setText("Tu vida es de: " + humano.getVida());
                    mochila.getItems()[0] = null;
                }else{
                    System.out.println("Este slot esta vacio");
                }
            }else if(guardarSlot2.isSelected()){
                if(mochila.getItems()[1] != null){
                    System.out.println("Usaste " + mochila.getItems()[1].getNombre() + " de tu mochila");
                    humano.setVida(humano.getVida() + mochila.getItems()[1].getUpPuntosVida());
                    historiaLabel.setText("Tu vida ahora es de" + humano.getVida());
                    statVida.setText("Tu vida es de: " + humano.getVida());
                    mochila.getItems()[1] = null;
                }else{
                    historiaLabel.setText("Este slot esta vacio");
                }
            }
        }
    }

    public class ListenerGuardarItem implements ActionListener{
        public void actionPerformed(ActionEvent event){

            if(guardarSlot1.isSelected()){
                mochila.guardarItem(mapa.getCasillas()[humano.getPos()].getItem(),0);
                guardarItem.setEnabled(false);
                historiaLabel.setText("Guardaste un " + mapa.getCasillas()[humano.getPos()].getItem().getNombre() + " en tu mochila");
            }else if(guardarSlot2.isSelected()){
                mochila.guardarItem(mapa.getCasillas()[humano.getPos()].getItem(), 1);
                guardarItem.setEnabled(false);
                historiaLabel.setText("Guardaste un " + mapa.getCasillas()[humano.getPos()].getItem().getNombre() + " en tu mochila");
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
                historiaLabel.setText("Guardaste un " + mapa.getCasillas()[humano.getPos()].getArma().getNombre() + " en tu mochila slot 1");
            }else if(guardarSlot4.isSelected()){
                mochila.guardarArma(mapa.getCasillas()[humano.getPos()].getArma(), 1);
                guardarArma.setEnabled(false);
                cambiarHistoria.setEnabled(true);
                historiaLabel.setText("Guardaste un " + mapa.getCasillas()[humano.getPos()].getArma().getNombre() + " en tu mochila slot 2");
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
                    historiaLabel.setText("La vida del enemigo es de: " + vidaEnemigo);
                    statVidaEnemigo.setText("Vida Enemigo: "+ vidaEnemigo);
                }else{
                    System.out.println("Este slot esta vacio, usa otra arama o ataca con habilidad o solo");
                }
            }else if(guardarSlot2.isSelected()){
                if(mochila.getArmas()[1] != null){
                    mapa.getCasillas()[humano.getPos()].getEnemigo().setVida(vidaEnemigo - (ataqueHumano + mochila.getArmas()[1].getGainPuntosAtaque()));
                    vidaEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getVida();
                     historiaLabel.setText("La vida del enemigo es de: " + vidaEnemigo);
                    statVidaEnemigo.setText("Vida Enemigo: "+ vidaEnemigo);
                }else{
                    System.out.println("Este slot esta vacio, usa otra arama o ataca con habilidad o solo");
                }
            }


            if(vidaEnemigo > 0){
                historiaLabel.setText("El enemigo sigue vivo, te atacara ahora");
                humano.setVida(vidaHumano - ataqueEnemigo);
                historiaLabel.setText("Tu vida ahora es de:" + humano.getVida());
                statVida.setText("Tu vida es de " + humano.getVida());
            }else if(vidaEnemigo <= 0){
                historiaLabel.setText("Derrotaste el enemigo! Puedes continuar con tu viaje");
                cambiarHistoria.setEnabled(true);
                atacar.setEnabled(false);
            }

            if(humano.getVida() <= 0 ){
                historiaLabel.setText("GAME OVER");
                //System.exit(0);

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

    public class ListenerAtacarRespuesta implements ActionListener{
        public void actionPerformed(ActionEvent event){

            int vidaEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getVida();

            if(respuestaA.isSelected()){
                if(preguntas.getPreguntas()[x].getA() == preguntas.getPreguntas()[x].getCorrecta()){
                    mapa.getCasillas()[humano.getPos()].getEnemigo().setVida(vidaEnemigo - 10 );
                }
            }
        }
    }


    public void displayBackground(int posicion){
        switch(humano.getPos()){
            case 2:
                backgroundInfierno = new ImageIcon("images/carta.png");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            case 25:
                backgroundInfierno = new ImageIcon("images/final.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            case 26:
                backgroundInfierno = new ImageIcon("images/cielo.png");
                backgroundLabel.setIcon(backgroundInfierno);
            break;

            default:
                backgroundInfierno = new ImageIcon("images/infierno-back-heroe.jpg");
                backgroundLabel.setIcon(backgroundInfierno);
            break;
        }

    }
    


    public void contarHistoria(){
            String historia= "<html>";

            historia=historia + ayudante.contarHistoria(humano.getPos()) + "\n" + ayudante.explicarContenido(mapa.getCasillas()[humano.getPos()]);
            
            historia=historia+"<html>";
            historiaLabel.setText(historia);
    }

        public void contarHistoria2(){
            String historia= "<html>";
            for(int i=0;i<100; i++){
                historia=historia+"Te cuento esta historia por"+i+"vez."+"<br>";
            }
            historia=historia+"<html>";
            historiaLabel.setText(historia);
        }


}
