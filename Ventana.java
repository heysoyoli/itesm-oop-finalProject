import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ventana extends JFrame{

    private JLabel historiaTitle, historia, imagenDisplay1, imagenDisplay2;
    private JButton cambiarHistoria, atacar, guardarItem, guardarArma;
    private JPanel panelHistoria, panelImagen;

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

        guardarItem = new JButton("Guardar Item");
        guardarItem.addActionListener( new ListenerGuardarItem());
        panelHistoria.add(guardarItem);

        guardarArma = new JButton("Guardar Arma");
        guardarArma.addActionListener( new ListenerGuardarArma());
        panelHistoria.add(guardarArma);

        atacar.setEnabled(false);
        guardarArma.setEnabled(false);
        guardarItem.setEnabled(false);
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
        ayudante.contarHistoria(humano);


        //System.out.println(ayudante.contarHistoria(humano));
    }


    public class ListenerAvanzar implements ActionListener{
        public void actionPerformed(ActionEvent event){
            humano.setPos(humano.getPos() + 1);
			System.out.println("(" + humano.getPos() + ")" + "---- " + mapa.getCasillas()[humano.getPos()].getHistoria());

			ayudante.contarHistoria(humano);
            ayudante.explicarContenido(mapa.getCasillas()[humano.getPos()]);

            if(mapa.getCasillas()[humano.getPos()].getTipoContenido() == 1){
                atacar.setEnabled(true);
                guardarItem.setEnabled(false);
                guardarArma.setEnabled(false);
                cambiarHistoria.setEnabled(false);
            }else if(mapa.getCasillas()[humano.getPos()].getTipoContenido() == 0){
                guardarItem.setEnabled(true);
                atacar.setEnabled(false);
                guardarArma.setEnabled(false);
                cambiarHistoria.setEnabled(true);
            }else if(mapa.getCasillas()[humano.getPos()].getTipoContenido() == 2){
                guardarItem.setEnabled(false);
                guardarArma.setEnabled(true);
                atacar.setEnabled(false);
                cambiarHistoria.setEnabled(true);
            }else{
                guardarItem.setEnabled(false);
                guardarArma.setEnabled(false);
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

            System.out.println(vidaEnemigo);
            System.out.println(ataqueEnemigo);
            mapa.getCasillas()[humano.getPos()].getEnemigo().setVida(vidaEnemigo - ataqueHumano);
            vidaEnemigo = mapa.getCasillas()[humano.getPos()].getEnemigo().getVida();
            System.out.println("La vida del enemigo es de: " + vidaEnemigo);


            if(vidaEnemigo > 0){
                System.out.println("El enemigo sigue vivo, te atacara ahora");
                vidaHumano = vidaHumano - ataqueEnemigo;
                System.out.println("Tu vida ahora es de:" + vidaHumano);
            }else if(vidaEnemigo <= 0){ 
                System.out.println("Derrotaste el enemigo! Puedes continuar con tu viaje");
                cambiarHistoria.setEnabled(true);
                atacar.setEnabled(false);
            }
           
            //System.out.println("El Humano ataco al enemigo");
        }
    }

    public class ListenerGuardarItem implements ActionListener{
        public void actionPerformed(ActionEvent event){

            mochila.guardarItem(mapa.getCasillas()[humano.getPos()].getItem());
            guardarItem.setEnabled(false);
            System.out.println("Guardaste un " + mapa.getCasillas()[humano.getPos()].getItem().getNombre() + " en tu mochila");

        }
    }


     public class ListenerGuardarArma implements ActionListener{
        public void actionPerformed(ActionEvent event){

            mochila.guardarArma(mapa.getCasillas()[humano.getPos()].getArma());
            guardarArma.setEnabled(false);
            System.out.println("Guardaste un " + mapa.getCasillas()[humano.getPos()].getArma().getNombre() + " en tu mochila");

        }
    }




}