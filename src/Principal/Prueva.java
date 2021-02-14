package Principal;

import java.awt.Font;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Prueva extends javax.swing.JFrame {

    public static String titulo, texto, imagen,ordenfinal;

    public Prueva() {
        initComponents();
        scraping();
        cargarImagen();
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Noticia mas reciente");
        noticia();
    }

    public static void scraping() {
        int bandera = 1;
        Elements articulos = Principal.getHTML("https://es.cointelegraph.com").select("li.posts-listing__item");
        for (Element elementos : articulos) {          
            try {
                String url = elementos.select("a").attr("abs:href");

                Document htmlnoticias = Principal.getHTML(url);

                String h1 = htmlnoticias.select("h1").text();
                titulo = h1;
                ordenfinal = titulo + "\n\n\n";
                String text = htmlnoticias.select("p").text();
                texto = text;
                ordenfinal += texto;
                
                String img = htmlnoticias.select("img").attr("srcset");
                imagen = img;

                bandera++;
                
                if (bandera == 2) {
                    break;
                }
            } catch (Exception e) {

            }
        }
     
    }

    public static void cargarImagen() {
        try {
            Connection.Response res = Jsoup.connect(imagen)
                    .ignoreContentType(true).method(Connection.Method.GET).execute();
            ImageIcon imagen = new ImageIcon(ImageIO.read(new ByteArrayInputStream(res.bodyAsBytes())));
            Icon icon = new ImageIcon(imagen.getImage().getScaledInstance(jLabel1.getWidth(), jLabel1.getHeight(), Image.SCALE_DEFAULT));
            jLabel1.setIcon(icon);
        } catch (Exception e) {

        }
    }
    
    public static void noticia(){
         java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                jTextArea1.setFont(new Font("areal",3,12));
                jTextArea1.setText(ordenfinal);
           }
        };
        timer.schedule(tk, 100);
         
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(null);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 0, 440, 400));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 264, 394));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
