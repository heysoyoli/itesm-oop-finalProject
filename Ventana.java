import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Ventana extends JFrame{

    private JLabel historiaTitle, historia, imagenDisplay1, imagenDisplay2;
    private JButton changeHistoria;
    private JPanel panelHistoria, panelImagen;

    private Humano humano;
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

        changeHistoria = new JButton("Cambiar Historia");
        changeHistoria.addActionListener(new ListenerCambiar());
        panelHistoria.add(changeHistoria);

        onStart();
    }

    public void onStart(){
        humano = new Humano(0, "oliver", 20, 20);
        System.out.println("La posicion del humano es " + humano.getPos());
    }


    public class ListenerCambiar implements ActionListener{
        public void actionPerformed(ActionEvent event){
            humano.setPos(humano.getPos() + 1);
            System.out.println("La posicion del humano es" + humano.getPos() );
        }
    }
}