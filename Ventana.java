import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

////FALTA ATACAR CON ARMA, ATACAR CON HABILIDAD, MOSTAR IMAGENES, ATACAR SOLO

public class Ventana extends JFrame{

    private JLabel historiaTitle, historia, imagenDisplay1, imagenDisplay2;
    private JButton cambiarHistoria, atacar, guardarItem, guardarArma, usarItem;
    private JPanel panelHistoria, panelImagen;
    private JRadioButton guardarSlot1, guardarSlot2;
    private ButtonGroup grupoGuardar;

    private Humano humano;
    private Ayudante ayudante;
    private Mapa mapa;
    private Mochila mochila;
    //private ImageIcon imagen1, imagen2;


    public Ventana(){
        //setSize(600,1000);
        setTitle("Mi Rpg");
        setLayout(new GridLayout(2,1));
        initComponents();

        setSize(800, 400);

        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponents(){

        panelHistoria = new JPanel();
        panelImagen = new JPanel();
        add(panelHistoria);
        add(panelImagen);

        /*imagen1 = new ImageIcon(getClass().getResource("src\\imagen1.jpeg"));
        imagenDisplay1 = new JLabel(imagen1);
        panelImagen.add(imagenDisplay1);

        imagen2 = new ImageIcon(getClass().getResource("src\\imagen2.jpeg"));
        imagenDisplay2 = new JLabel(imagen2);
        panelImagen.add(imagenDisplay2);*/

        historiaTitle = new JLabel("Historia");
        panelHistoria.add(historiaTitle);

        historia = new JLabel();
        panelHistoria.add(historia);

        cambiarHistoria = new JButton("Avanzar");
        cambiarHistoria.addActionListener(new ListenerAvanzar());
        panelHistoria.add(cambiarHistoria);

        atacar = new JButton("Atacar");
        atacar.addActionListener(new ListenerAtacar());
        panelHistoria.add(atacar);


        guardarSlot1 = new JRadioButton("Guardar en slot 1", false);
        guardarSlot2 = new JRadioButton("Guardar en slot 2", false);
        grupoGuardar = new ButtonGroup();
        grupoGuardar.add(guardarSlot1);
        grupoGuardar.add(guardarSlot2);
        panelHistoria.add(guardarSlot1);
        panelHistoria.add(guardarSlot2);


        guardarItem = new JButton("Guardar Item");
        guardarItem.addActionListener( new ListenerGuardarItem());
        panelHistoria.add(guardarItem);

        usarItem = new JButton("Usar Item");
        usarItem.addActionListener(new ListenerUsarItem());
        panelHistoria.add(usarItem);

        guardarArma = new JButton("Guardar Arma");
        guardarArma.addActionListener( new ListenerGuardarArma());
        panelHistoria.add(guardarArma);

        atacar.setEnabled(false);
        guardarArma.setEnabled(false);
        guardarItem.setEnabled(false);
        guardarSlot1.setEnabled(false);
        guardarSlot2.setEnabled(false);
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

			ayudante.contarHistoria(humano.getPos());
            ayudante.explicarContenido(mapa.getCasillas()[humano.getPos()]);

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
                guardarSlot1.setEnabled(true);
                guardarSlot2.setEnabled(true);
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

            if(guardarSlot1.isSelected()){
                mochila.guardarArma(mapa.getCasillas()[humano.getPos()].getArma(), 0);
                guardarArma.setEnabled(false);
                System.out.println("Guardaste un " + mapa.getCasillas()[humano.getPos()].getArma().getNombre() + " en tu mochila slot 1");
            }else if(guardarSlot2.isSelected()){
                mochila.guardarArma(mapa.getCasillas()[humano.getPos()].getArma(), 1);
                guardarArma.setEnabled(false);
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


}
