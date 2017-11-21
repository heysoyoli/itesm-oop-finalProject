import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ventana extends JFrame{

    private JLabel historiaTitle, historia, imagenDisplay1, imagenDisplay2;
    private JButton cambiarHistoria, atacar;
    private JPanel panelHistoria, panelImagen;

    private Humano humano;
    private Ayudante ayudante;
    private Mapa mapa;
    //private ImageIcon imagen1, imagen2;


    public Ventana(){
        //setSize(600,1000);
        setTitle("Mi Rpg");
        setLayout(new GridLayout(2,1));
        initComponents();
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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

        cambiarHistoria = new JButton("Cambiar Historia");
        cambiarHistoria.addActionListener(new ListenerCambiar());
        panelHistoria.add(cambiarHistoria);

        atacar = new JButton("Atacar");
        atacar.addActionListener(new ListenerAtacar());
        panelHistoria.add(atacar);

        

        atacar.setEnabled(false);
        cambiarHistoria.setEnabled(false);

        onStart();
    }

    public void onStart(){
    	mapa = new Mapa();
    	mapa.crearCasillasDefault();
    	mapa.crearCasillasA();
    	mapa.crearCasillasB();

        humano = new Humano(0, "oliver", 20, 5);

        ayudante = new Ayudante();
        ayudante.contarHistoria(humano);


        //System.out.println(ayudante.contarHistoria(humano));
    }


    public class ListenerCambiar implements ActionListener{
        public void actionPerformed(ActionEvent event){
            humano.setPos(humano.getPos() + 1);
			System.out.println("(" + humano.getPos() + ")" + "---- " + mapa.getCasillas()[humano.getPos()].getHistoria());

			ayudante.contarHistoria(humano);
            ayudante.explicarContenido(mapa.getCasillas()[humano.getPos()]);

            if(mapa.getCasillas()[humano.getPos()].getTipoContenido() == 1){
                atacar.setEnabled(true);
                cambiarHistoria.setEnabled(false);
            }else{
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
            
        }
    }
}