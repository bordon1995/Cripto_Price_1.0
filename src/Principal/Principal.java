
package Principal;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.TimerTask;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.JPanel;

/**
 *
 * @author Daniel
 */
public class Principal extends javax.swing.JFrame {

    public static double precio_actual_btc;
    public static double precio_actual_eth;
    public static double precio_minimo24_btc;
    public static double precio_minimo24_eth;
    public static String text;
    fondo f = new fondo();

    public Principal() {
        setContentPane(f);
        initComponents();
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);

        txt_porcentaje_btc.setVisible(false);
        txt_btc_preciominimo.setVisible(false);
        txt_btc_precioactual.setVisible(false);
        txt_eth_precioactual.setVisible(false);
        txt_eth_porcentaje.setVisible(false);
        txt_eth_preciominimo.setVisible(false);
        txt_dotprecio.setVisible(false);
        txt_porcentajedot.setVisible(false);
        txt_preciominimodot.setVisible(false);
        txt_xrp_precio_actual.setVisible(false);
        txt_xrp_porcentaje.setVisible(false);
        txt_preciominimo_xrp.setVisible(false);
        txt_ada_precioactual.setVisible(false);
        txt_ada_porcentaje.setVisible(false);
        txt_ada_preciominimo.setVisible(false);
        txt_link_precioactual.setVisible(false);
        txt_link_porcentaje.setVisible(false);
        txt_link_preciominimo.setVisible(false);
        txt_ltc_precioactual.setVisible(false);
        txt_ltc_porcentaje.setVisible(false);
        txt_ltc_preciominimo.setVisible(false);
        txt_bch_precioactual.setVisible(false);
        txt_bch_porcentaje.setVisible(false);
        txt_bch_preciominimo.setVisible(false);
        txt_xlm_precioactual.setVisible(false);
        txt_xlm_porcentaje.setVisible(false);
        txt_xlm_preciominimo.setVisible(false);
        txt_bnb_precioactual.setVisible(false);
        txt_bnb_porcentaje.setVisible(false);
        txt_bnb_preciominimo.setVisible(false);

        jScrollPane1.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        });
        jScrollBar1.setVisible(false);

        Image imagen_btc_verde = new ImageIcon(getClass().getResource("/Imagen/triangulo_verde.png")).getImage();
        flecha_verde_btc.setIcon(new ImageIcon(imagen_btc_verde.getScaledInstance(flecha_verde_btc.getWidth(), flecha_verde_btc.getHeight(), Image.SCALE_AREA_AVERAGING)));
        flecha_verde_btc.setVisible(false);
        Image imagen_btc_rojo = new ImageIcon(getClass().getResource("/Imagen/triangulo_rojo.png")).getImage();
        flecha_rojo_btc.setIcon(new ImageIcon(imagen_btc_rojo.getScaledInstance(flecha_rojo_btc.getWidth(), flecha_rojo_btc.getHeight(), Image.SCALE_AREA_AVERAGING)));
        flecha_rojo_btc.setVisible(false);
        Image imagen_eth_verde = new ImageIcon(getClass().getResource("/Imagen/triangulo_verde.png")).getImage();
        flecha_verde_eth.setIcon(new ImageIcon(imagen_eth_verde.getScaledInstance(flecha_verde_eth.getWidth(), flecha_verde_eth.getHeight(), Image.SCALE_AREA_AVERAGING)));
        flecha_verde_eth.setVisible(false);
        Image imagen_eth_rojo = new ImageIcon(getClass().getResource("/Imagen/triangulo_rojo.png")).getImage();
        flecha_rojo_eth.setIcon(new ImageIcon(imagen_eth_rojo.getScaledInstance(flecha_rojo_eth.getWidth(), flecha_rojo_eth.getHeight(), Image.SCALE_DEFAULT)));
        flecha_rojo_eth.setVisible(false);
        Image imagen_dot_verde = new ImageIcon(getClass().getResource("/Imagen/triangulo_verde.png")).getImage();
        flecha_verde_dot.setIcon(new ImageIcon(imagen_dot_verde.getScaledInstance(flecha_verde_dot.getWidth(), flecha_verde_dot.getHeight(), Image.SCALE_AREA_AVERAGING)));
        flecha_verde_dot.setVisible(false);
        Image imagen_dot_rojo = new ImageIcon(getClass().getResource("/Imagen/triangulo_rojo.png")).getImage();
        flecha_rojo_dot.setIcon(new ImageIcon(imagen_dot_rojo.getScaledInstance(flecha_rojo_dot.getWidth(), flecha_rojo_dot.getHeight(), Image.SCALE_DEFAULT)));
        flecha_rojo_dot.setVisible(false);
        Image imagen_xrp_verde = new ImageIcon(getClass().getResource("/Imagen/triangulo_verde.png")).getImage();
        flecha_verde_xrp.setIcon(new ImageIcon(imagen_xrp_verde.getScaledInstance(flecha_verde_xrp.getWidth(), flecha_verde_xrp.getHeight(), Image.SCALE_AREA_AVERAGING)));
        flecha_verde_xrp.setVisible(false);
        Image imagen_xrp_rojo = new ImageIcon(getClass().getResource("/Imagen/triangulo_rojo.png")).getImage();
        flecha_rojo_xrp.setIcon(new ImageIcon(imagen_xrp_rojo.getScaledInstance(flecha_rojo_xrp.getWidth(), flecha_rojo_xrp.getHeight(), Image.SCALE_DEFAULT)));
        flecha_rojo_xrp.setVisible(false);
        Image imagen_ada_verde = new ImageIcon(getClass().getResource("/Imagen/triangulo_verde.png")).getImage();
        flecha_verde_ada.setIcon(new ImageIcon(imagen_ada_verde.getScaledInstance(flecha_verde_ada.getWidth(), flecha_verde_ada.getHeight(), Image.SCALE_AREA_AVERAGING)));
        flecha_verde_ada.setVisible(false);
        Image imagen_ada_rojo = new ImageIcon(getClass().getResource("/Imagen/triangulo_rojo.png")).getImage();
        flecha_rojo_ada.setIcon(new ImageIcon(imagen_ada_rojo.getScaledInstance(flecha_rojo_ada.getWidth(), flecha_rojo_ada.getHeight(), Image.SCALE_DEFAULT)));
        flecha_rojo_ada.setVisible(false);
        Image imagen_link_verde = new ImageIcon(getClass().getResource("/Imagen/triangulo_verde.png")).getImage();
        flecha_verde_link.setIcon(new ImageIcon(imagen_link_verde.getScaledInstance(flecha_verde_link.getWidth(), flecha_verde_link.getHeight(), Image.SCALE_AREA_AVERAGING)));
        flecha_verde_link.setVisible(false);
        Image imagen_link_rojo = new ImageIcon(getClass().getResource("/Imagen/triangulo_rojo.png")).getImage();
        flecha_rojo_link.setIcon(new ImageIcon(imagen_link_rojo.getScaledInstance(flecha_rojo_link.getWidth(), flecha_rojo_link.getHeight(), Image.SCALE_DEFAULT)));
        flecha_rojo_link.setVisible(false);
        Image imagen_ltc_verde = new ImageIcon(getClass().getResource("/Imagen/triangulo_verde.png")).getImage();
        flecha_verde_ltc.setIcon(new ImageIcon(imagen_ltc_verde.getScaledInstance(flecha_verde_ltc.getWidth(), flecha_verde_ltc.getHeight(), Image.SCALE_AREA_AVERAGING)));
        flecha_verde_ltc.setVisible(false);
        Image imagen_ltc_rojo = new ImageIcon(getClass().getResource("/Imagen/triangulo_rojo.png")).getImage();
        flecha_rojo_ltc.setIcon(new ImageIcon(imagen_ltc_rojo.getScaledInstance(flecha_rojo_ltc.getWidth(), flecha_rojo_ltc.getHeight(), Image.SCALE_DEFAULT)));
        flecha_rojo_ltc.setVisible(false);
        Image imagen_bch_verde = new ImageIcon(getClass().getResource("/Imagen/triangulo_verde.png")).getImage();
        flecha_verde_bch.setIcon(new ImageIcon(imagen_bch_verde.getScaledInstance(flecha_verde_bch.getWidth(), flecha_verde_bch.getHeight(), Image.SCALE_AREA_AVERAGING)));
        flecha_verde_bch.setVisible(false);
        Image imagen_bch_rojo = new ImageIcon(getClass().getResource("/Imagen/triangulo_rojo.png")).getImage();
        flecha_rojo_bch.setIcon(new ImageIcon(imagen_bch_rojo.getScaledInstance(flecha_rojo_bch.getWidth(), flecha_rojo_bch.getHeight(), Image.SCALE_DEFAULT)));
        flecha_rojo_bch.setVisible(false);
        Image imagen_xlm_verde = new ImageIcon(getClass().getResource("/Imagen/triangulo_verde.png")).getImage();
        flecha_verde_xlm.setIcon(new ImageIcon(imagen_xlm_verde.getScaledInstance(flecha_verde_xlm.getWidth(), flecha_verde_xlm.getHeight(), Image.SCALE_AREA_AVERAGING)));
        flecha_verde_xlm.setVisible(false);
        Image imagen_xlm_rojo = new ImageIcon(getClass().getResource("/Imagen/triangulo_rojo.png")).getImage();
        flecha_rojo_xlm.setIcon(new ImageIcon(imagen_xlm_rojo.getScaledInstance(flecha_rojo_xlm.getWidth(), flecha_rojo_xlm.getHeight(), Image.SCALE_DEFAULT)));
        flecha_rojo_xlm.setVisible(false);
        Image imagen_bnb_verde = new ImageIcon(getClass().getResource("/Imagen/triangulo_verde.png")).getImage();
        flecha_verde_bnb.setIcon(new ImageIcon(imagen_bnb_verde.getScaledInstance(flecha_verde_bnb.getWidth(), flecha_verde_bnb.getHeight(), Image.SCALE_AREA_AVERAGING)));
        flecha_verde_bnb.setVisible(false);
        Image imagen_bnb_rojo = new ImageIcon(getClass().getResource("/Imagen/triangulo_rojo.png")).getImage();
        flecha_rojo_bnb.setIcon(new ImageIcon(imagen_bnb_rojo.getScaledInstance(flecha_rojo_bnb.getWidth(), flecha_rojo_bnb.getHeight(), Image.SCALE_DEFAULT)));
        flecha_rojo_bnb.setVisible(false);

        Mostrar_valores();
        new Polkadot_Xrp().Mostrar_valores();
        new Litecoin_Bitcoin_cash().mostrar_valores();
        new Ada_Link().mostrar_valores();
        new Stellar_xlm_Binance_bnb().mostrar_valores();

    }

    public void Mostrar_valores() {
        Obtener_dato_precioMinimo_btc24hs();
        obtener_dato_preciominimo_eth24();
        Obtener_precioActual_btc();
        Obtener_precioactual_eth();
        mostrar_porcentaje();
        mostar_porcentaje_eth();
        btc_preciominimo.setText("$ " + String.format("%.2f", precio_minimo24_btc));
        eth_preciominimo.setText("$ " + String.format("%.2f", precio_minimo24_eth));
        btc_precioactual.setText("$ " + String.format("%.2f", precio_actual_btc));
        eth_precioactual.setText("$ " + String.format("%.2f", precio_actual_eth));
        text = "precios : ";
        jTextArea1.setText(text);
        hilo();
        hilo2();
    }

    public static Document getHTML(String url) {
        Document html = null;
        try {
            html = Jsoup.connect(url).get();
        } catch (Exception e) {

        }
        return html;
    }

    public void Obtener_dato_precioMinimo_btc24hs() {
        int bandera = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/bitcoin").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato2_precio_btc24hs = precio;
                bandera++;
                if (bandera == 7) {
                    break;
                }
            } catch (Exception j) {

            }
        }
        String cad = dato2_precio_btc24hs;
        String cad_modi, cad_modi2;
        int desde = 1, hasta = 3;
        cad_modi = cad.substring(desde, hasta);
        desde = 4;
        hasta = 7;
        cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + cad_modi2;
        precio_minimo24_btc = Double.parseDouble(ultimo);
    }

    public void obtener_dato_preciominimo_eth24() {
        int bandera = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/ethereum").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato2_precio_eth24hs = precio;

                bandera++;
                if (bandera == 8) {
                    break;
                }
            } catch (Exception j) {

            }
        }
        String cad = dato2_precio_eth24hs;
        String cad_modi, cad_modi2, cad_modi3;
        int desde = 1, hasta = 2;
        cad_modi = cad.substring(desde, hasta);
        desde = 3;
        hasta = 6;
        cad_modi2 = cad.substring(desde, hasta);
        desde = 7;
        hasta = 10;
        cad_modi3 = cad.substring(desde, hasta);
        String ultimo = cad_modi + cad_modi2 + "." + cad_modi3;
        precio_minimo24_eth = Double.parseDouble(ultimo);
    }

    public void Obtener_precioActual_btc() {
        int vuelta = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/bitcoin").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_precio_btc = precio;
                vuelta++;
                if (vuelta == 2) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }

        }
        String cad = dato_precio_btc;
        int desde = 1, hasta = 3;
        String cad_modi = cad.substring(desde, hasta);
        desde = 4;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + cad_modi2;
        precio_actual_btc = Double.parseDouble(ultimo);
    }

    public void Obtener_precioactual_eth() {
        int vuelta = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/ethereum").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_precio_eth = precio;
                vuelta++;
                if (vuelta == 2) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }

        }
        String cad = dato_precio_eth;
        int desde = 1, hasta = 2;
        String cad_modi = cad.substring(desde, hasta);
        desde = 3;
        hasta = 6;
        String cad_modi2 = cad.substring(desde, hasta);
        desde = 7;
        hasta = 9;
        String cad_modi3 = cad.substring(desde, hasta);
        String ultimo = cad_modi + cad_modi2 + "." + cad_modi3;
        precio_actual_eth = Double.parseDouble(ultimo);
    }

    public void stop_hilo() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                btc_precioactual.setForeground(new Color(255, 255, 255));
                btc_preciominimo.setForeground(new Color(255, 255, 255));
                txt_btc_precioactual.setVisible(false);
                txt_btc_preciominimo.setVisible(false);
                txt_porcentaje_btc.setVisible(false);
                mostrar_porcentaje();
            }
        };
        timer.schedule(tk, 10000);
    }

    public void stop_hilo_eth() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                eth_precioactual.setForeground(new Color(255, 255, 255));
                eth_preciominimo.setForeground(new Color(255, 255, 255));
                txt_eth_precioactual.setVisible(false);
                txt_eth_preciominimo.setVisible(false);
                txt_eth_porcentaje.setVisible(false);
                mostar_porcentaje_eth();
            }
        };
        timer.schedule(tk, 10000);
    }

    public void start_verde_precioactual_btc() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                btc_precioactual.setForeground(Color.GREEN);
                txt_btc_precioactual.setBackground(new Color(153, 255, 153));
                txt_btc_precioactual.setVisible(true);
                porcentaje_btc.setForeground(Color.GREEN);
                txt_porcentaje_btc.setBackground(new Color(153, 255, 153));
                txt_porcentaje_btc.setVisible(true);
                flecha_verde_btc.setVisible(true);
                flecha_rojo_btc.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo();
    }

    public void start_verde_precioactual_eth() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                eth_precioactual.setForeground(new Color(0, 153, 0));
                txt_eth_precioactual.setBackground(new Color(153, 255, 153));
                txt_eth_precioactual.setVisible(true);
                eth_porcentaje.setForeground(Color.GREEN);
                txt_eth_porcentaje.setBackground(new Color(153, 255, 153));
                txt_eth_porcentaje.setVisible(true);
                flecha_verde_eth.setVisible(true);
                flecha_rojo_eth.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_eth();
    }

    public void start_rojo_precioactual_btc() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                btc_precioactual.setForeground(Color.red);
                txt_btc_precioactual.setBackground(new Color(255, 102, 102));
                txt_btc_precioactual.setVisible(true);
                porcentaje_btc.setForeground(Color.red);
                txt_porcentaje_btc.setBackground(new Color(255, 102, 102));
                txt_porcentaje_btc.setVisible(true);
                flecha_rojo_btc.setVisible(true);
                flecha_verde_btc.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo();
    }

    public void start_rojo_precioactual_eth() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                eth_precioactual.setForeground(Color.red);
                txt_eth_precioactual.setBackground(new Color(255, 102, 102));
                txt_eth_precioactual.setVisible(true);
                eth_porcentaje.setForeground(Color.red);
                txt_eth_porcentaje.setBackground(new Color(255, 102, 102));
                txt_eth_porcentaje.setVisible(true);
                flecha_rojo_eth.setVisible(true);
                flecha_verde_eth.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_eth();
    }

    public void start_verde_preciominimo_btc() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                btc_preciominimo.setForeground(Color.GREEN);
                txt_btc_preciominimo.setBackground(new Color(153, 255, 153));
                txt_btc_preciominimo.setVisible(true);
                porcentaje_btc.setForeground(Color.GREEN);
                txt_porcentaje_btc.setBackground(new Color(153, 255, 153));
                txt_porcentaje_btc.setVisible(true);
                flecha_verde_btc.setVisible(true);
                flecha_rojo_btc.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo();
    }

    public void start_verde_preciominimo_eth() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                eth_preciominimo.setForeground(Color.GREEN);
                txt_eth_preciominimo.setBackground(new Color(153, 255, 153));
                txt_eth_preciominimo.setVisible(true);
                eth_porcentaje.setForeground(Color.GREEN);
                txt_eth_porcentaje.setBackground(new Color(153, 255, 153));
                txt_eth_porcentaje.setVisible(true);
                flecha_verde_eth.setVisible(true);
                flecha_rojo_eth.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_eth();
    }

    public void start_rojo_preciominimo_btc() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                btc_preciominimo.setForeground(Color.RED);
                txt_btc_preciominimo.setBackground(new Color(255, 102, 102));
                txt_btc_preciominimo.setVisible(true);
                porcentaje_btc.setForeground(Color.red);
                txt_porcentaje_btc.setBackground(new Color(255, 102, 102));
                txt_porcentaje_btc.setVisible(true);
                flecha_verde_btc.setVisible(false);
                flecha_rojo_btc.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo();
    }

    public void start_rojo_preciominimo_eth() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                flecha_rojo_eth.setForeground(Color.RED);
                txt_eth_preciominimo.setBackground(new Color(255, 102, 102));
                txt_eth_preciominimo.setVisible(true);
                eth_porcentaje.setForeground(Color.red);
                txt_eth_porcentaje.setBackground(new Color(255, 102, 102));
                txt_eth_porcentaje.setVisible(true);
                flecha_verde_eth.setVisible(false);
                flecha_rojo_eth.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_eth();
    }

    public void hilo() {
        bandera_precioactual_btc = precio_actual_btc;
        bandera_precioactual_eth = precio_actual_eth;
        Timer timer = new Timer(30000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Timer timer = new java.util.Timer();
                TimerTask jk = new TimerTask() {
                    @Override
                    public void run() {
                        Obtener_precioActual_btc();
                        btc_precioactual.setText("$ " + String.format("%.2f", precio_actual_btc));
                        text += "\n" + "btc : " + String.format("%.2f", precio_actual_btc);
                        jTextArea1.setText(text);
                        if (precio_actual_btc > bandera_precioactual_btc) {
                            start_verde_precioactual_btc();
                            bandera_precioactual_btc = precio_actual_btc;
                        } else if (precio_actual_btc < bandera_precioactual_btc) {
                            start_rojo_precioactual_btc();
                            bandera_precioactual_btc = precio_actual_btc;
                        }
                    }
                };
                timer.schedule(jk, 0);
                java.util.Timer timer2 = new java.util.Timer();
                TimerTask tk2 = new TimerTask() {
                    @Override
                    public void run() {
                        Obtener_precioactual_eth();
                        eth_precioactual.setText("$ " + String.format("%.2f", precio_actual_eth));
                        text += "\n" + "eth : " + String.valueOf(precio_actual_eth);
                        jTextArea1.setText(text);
                        if (precio_actual_eth > bandera_precioactual_eth) {
                            start_verde_precioactual_eth();
                            bandera_precioactual_eth = precio_actual_eth;
                        } else if (precio_actual_eth < bandera_precioactual_eth) {
                            start_rojo_precioactual_eth();
                            bandera_precioactual_eth = precio_actual_eth;
                        }
                    }
                };
                timer2.schedule(tk2, 20000);
            }
        });
        timer.start();
    }

    public void hilo2() {
        bandera_preciominimo_btc = precio_minimo24_btc;
        bandera_preciominimo_eth = precio_minimo24_eth;
        Timer timer = new Timer(70000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Timer timer = new java.util.Timer();
                TimerTask tk = new TimerTask() {
                    @Override
                    public void run() {
                        Obtener_dato_precioMinimo_btc24hs();
                        btc_preciominimo.setText(String.valueOf(precio_minimo24_btc));
                        if (precio_minimo24_btc > bandera_preciominimo_btc) {
                            start_verde_preciominimo_btc();
                            System.out.println(bandera_preciominimo_btc);
                            bandera_preciominimo_btc = precio_minimo24_btc;
                        } else if (precio_minimo24_btc < bandera_preciominimo_btc) {
                            start_rojo_preciominimo_btc();
                            System.out.println(bandera_preciominimo_btc);
                            bandera_preciominimo_btc = precio_minimo24_btc;
                        }
                    }
                };
                timer.schedule(tk, 0);
                java.util.Timer timer2 = new java.util.Timer();
                TimerTask tk2 = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_dato_preciominimo_eth24();
                        eth_preciominimo.setText(String.valueOf(precio_minimo24_eth));
                        if (precio_minimo24_eth > bandera_preciominimo_eth) {
                            start_verde_preciominimo_eth();
                            System.out.println(bandera_preciominimo_eth);
                            bandera_preciominimo_eth = precio_minimo24_eth;
                        } else if (precio_minimo24_eth < bandera_preciominimo_eth) {
                            start_rojo_preciominimo_eth();
                            System.out.println(bandera_preciominimo_eth);
                            bandera_preciominimo_eth = precio_minimo24_eth;
                        }
                    }
                };
                timer2.schedule(tk2, 20000);
            }
        });
        timer.start();
    }

    public void mostrar_porcentaje() {
        double resultado = ((precio_actual_btc * 100) / precio_minimo24_btc) - 100;
        if (precio_actual_btc > precio_minimo24_btc) {
            porcentaje_btc.setForeground(Color.GREEN);
            porcentaje_btc.setText(String.format("%.2f", resultado) + "%");
            flecha_verde_btc.setVisible(true);
            flecha_rojo_btc.setVisible(false);
        } else if (precio_actual_btc < precio_minimo24_btc) {
            porcentaje_btc.setForeground(Color.red);
            porcentaje_btc.setText(String.format("%.2f", resultado) + "%");
            flecha_rojo_btc.setVisible(true);
            flecha_verde_btc.setVisible(false);
        }
    }

    public void mostar_porcentaje_eth() {
        double resultado = ((precio_actual_eth * 100) / precio_minimo24_eth) - 100;
        if (precio_actual_eth > precio_minimo24_eth) {
            eth_porcentaje.setForeground(Color.GREEN);
            eth_porcentaje.setText(String.format("%.2f", resultado) + "%");
            flecha_verde_eth.setVisible(true);
            flecha_rojo_eth.setVisible(false);
        } else if (precio_actual_eth < precio_minimo24_eth) {
            eth_porcentaje.setForeground(Color.red);
            eth_porcentaje.setText(String.format("%.2f", resultado) + "%");
            flecha_rojo_eth.setVisible(true);
            flecha_verde_eth.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        flecha_rojo_btc = new javax.swing.JLabel();
        flecha_verde_btc = new javax.swing.JLabel();
        porcentaje_btc = new javax.swing.JLabel();
        txt_porcentaje_btc = new javax.swing.JTextField();
        btc_preciominimo = new javax.swing.JLabel();
        txt_btc_preciominimo = new javax.swing.JTextField();
        btc_precioactual = new javax.swing.JLabel();
        txt_btc_precioactual = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        eth_precioactual = new javax.swing.JLabel();
        txt_eth_precioactual = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        flecha_verde_eth = new javax.swing.JLabel();
        flecha_rojo_eth = new javax.swing.JLabel();
        eth_porcentaje = new javax.swing.JLabel();
        txt_eth_porcentaje = new javax.swing.JTextField();
        eth_preciominimo = new javax.swing.JLabel();
        txt_eth_preciominimo = new javax.swing.JTextField();
        dot_precio = new javax.swing.JLabel();
        txt_dotprecio = new javax.swing.JTextField();
        pocentaje_dot = new javax.swing.JLabel();
        txt_porcentajedot = new javax.swing.JTextField();
        etiqueta_dot = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        flecha_verde_dot = new javax.swing.JLabel();
        flecha_rojo_dot = new javax.swing.JLabel();
        xrp_precio_actual = new javax.swing.JLabel();
        txt_xrp_precio_actual = new javax.swing.JTextField();
        xrp_porcentaje = new javax.swing.JLabel();
        txt_xrp_porcentaje = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        precio_minimo_xrp = new javax.swing.JLabel();
        txt_preciominimo_xrp = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        flecha_verde_xrp = new javax.swing.JLabel();
        flecha_rojo_xrp = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();
        ada_precioactual = new javax.swing.JLabel();
        txt_ada_precioactual = new javax.swing.JTextField();
        ada_porcentaje = new javax.swing.JLabel();
        txt_ada_porcentaje = new javax.swing.JTextField();
        flecha_verde_ada = new javax.swing.JLabel();
        flecha_rojo_ada = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ada_preciominimo = new javax.swing.JLabel();
        txt_ada_preciominimo = new javax.swing.JTextField();
        jlabel_ada = new javax.swing.JLabel();
        link_precioactual = new javax.swing.JLabel();
        txt_link_precioactual = new javax.swing.JTextField();
        link_porcentaje = new javax.swing.JLabel();
        txt_link_porcentaje = new javax.swing.JTextField();
        etiqueta_link = new javax.swing.JLabel();
        link_preciominimo = new javax.swing.JLabel();
        txt_link_preciominimo = new javax.swing.JTextField();
        flecha_verde_link = new javax.swing.JLabel();
        flecha_rojo_link = new javax.swing.JLabel();
        jlabel_link = new javax.swing.JLabel();
        ltc_precioactual = new javax.swing.JLabel();
        txt_ltc_precioactual = new javax.swing.JTextField();
        ltc_porcentaje = new javax.swing.JLabel();
        txt_ltc_porcentaje = new javax.swing.JTextField();
        etiqueta_lltc = new javax.swing.JLabel();
        ltc_preciominimo = new javax.swing.JLabel();
        txt_ltc_preciominimo = new javax.swing.JTextField();
        flecha_verde_ltc = new javax.swing.JLabel();
        flecha_rojo_ltc = new javax.swing.JLabel();
        jLabel_ltc = new javax.swing.JLabel();
        bch_precioactual = new javax.swing.JLabel();
        txt_bch_precioactual = new javax.swing.JTextField();
        etiqueta_bch = new javax.swing.JLabel();
        bch_porcentaje = new javax.swing.JLabel();
        txt_bch_porcentaje = new javax.swing.JTextField();
        bch_preciominimo = new javax.swing.JLabel();
        txt_bch_preciominimo = new javax.swing.JTextField();
        flecha_verde_bch = new javax.swing.JLabel();
        flecha_rojo_bch = new javax.swing.JLabel();
        jLabel_bch = new javax.swing.JLabel();
        etiqueta_xlm = new javax.swing.JLabel();
        xlm_precioactual = new javax.swing.JLabel();
        txt_xlm_precioactual = new javax.swing.JTextField();
        xlm_porcentaje = new javax.swing.JLabel();
        txt_xlm_porcentaje = new javax.swing.JTextField();
        xlm_preciominimo = new javax.swing.JLabel();
        txt_xlm_preciominimo = new javax.swing.JTextField();
        flecha_verde_xlm = new javax.swing.JLabel();
        flecha_rojo_xlm = new javax.swing.JLabel();
        jLabel_xlm = new javax.swing.JLabel();
        bnb_porcentaje = new javax.swing.JLabel();
        txt_bnb_porcentaje = new javax.swing.JTextField();
        bnb_precioactual = new javax.swing.JLabel();
        txt_bnb_precioactual = new javax.swing.JTextField();
        etiqueta_bnb = new javax.swing.JLabel();
        bnb_preciominimo = new javax.swing.JLabel();
        txt_bnb_preciominimo = new javax.swing.JTextField();
        flecha_verde_bnb = new javax.swing.JLabel();
        flecha_rojo_bnb = new javax.swing.JLabel();
        jLabel_bnb = new javax.swing.JLabel();
        precio_minimo_dot = new javax.swing.JLabel();
        txt_preciominimodot = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setAutoscrolls(true);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setForeground(new java.awt.Color(153, 153, 153));
        jTextArea1.setTabSize(0);
        jTextArea1.setText("precios :    \n");
        jTextArea1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 153, 153), new java.awt.Color(0, 0, 51), new java.awt.Color(255, 153, 51), new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 80, 140));

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Precio Mínimo en 24 hs :");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 114, 130, 16));
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 35, 35));
        getContentPane().add(flecha_rojo_btc, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 95, 12, 12));
        getContentPane().add(flecha_verde_btc, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 93, 12, 12));

        porcentaje_btc.setForeground(new java.awt.Color(255, 255, 255));
        porcentaje_btc.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        porcentaje_btc.setText("jlabel6");
        getContentPane().add(porcentaje_btc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 45, 16));

        txt_porcentaje_btc.setEditable(false);
        txt_porcentaje_btc.setBackground(new java.awt.Color(0, 0, 0));
        txt_porcentaje_btc.setForeground(new java.awt.Color(255, 255, 255));
        txt_porcentaje_btc.setBorder(null);
        getContentPane().add(txt_porcentaje_btc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 45, 16));

        btc_preciominimo.setForeground(new java.awt.Color(255, 255, 255));
        btc_preciominimo.setText("$ 30000.00");
        getContentPane().add(btc_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 114, 63, 16));

        txt_btc_preciominimo.setBackground(new java.awt.Color(0, 0, 0));
        txt_btc_preciominimo.setForeground(new java.awt.Color(255, 255, 255));
        txt_btc_preciominimo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_btc_preciominimo.setBorder(null);
        getContentPane().add(txt_btc_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 114, 63, 16));

        btc_precioactual.setBackground(new java.awt.Color(255, 255, 255));
        btc_precioactual.setForeground(new java.awt.Color(255, 255, 255));
        btc_precioactual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btc_precioactual.setText("$ 30000.00");
        getContentPane().add(btc_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 62, 16));

        txt_btc_precioactual.setBackground(new java.awt.Color(0, 0, 0));
        txt_btc_precioactual.setForeground(new java.awt.Color(255, 255, 255));
        txt_btc_precioactual.setBorder(null);
        getContentPane().add(txt_btc_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 62, 16));

        jLabel8.setFont(new java.awt.Font("Impact", 2, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Precio de las 10 principales cripto monedas : ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(175, 20, 350, 30));
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 135, 60, 60));

        eth_precioactual.setForeground(new java.awt.Color(255, 255, 255));
        eth_precioactual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eth_precioactual.setText("$ 1000.00");
        getContentPane().add(eth_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 60, 16));

        txt_eth_precioactual.setBackground(new java.awt.Color(0, 0, 0));
        txt_eth_precioactual.setBorder(null);
        getContentPane().add(txt_eth_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 160, 58, 16));

        jLabel11.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Precio Mínimo en 24 hs :");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 184, 130, 16));
        getContentPane().add(flecha_verde_eth, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 163, 12, 12));
        getContentPane().add(flecha_rojo_eth, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 165, 12, 12));

        eth_porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        eth_porcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        eth_porcentaje.setText("jlabel13");
        getContentPane().add(eth_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 45, 16));

        txt_eth_porcentaje.setBackground(new java.awt.Color(0, 0, 0));
        txt_eth_porcentaje.setBorder(null);
        getContentPane().add(txt_eth_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 45, 16));

        eth_preciominimo.setForeground(new java.awt.Color(255, 255, 255));
        eth_preciominimo.setText("$ 1000.00");
        getContentPane().add(eth_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 184, 60, 16));

        txt_eth_preciominimo.setBackground(new java.awt.Color(0, 0, 0));
        txt_eth_preciominimo.setBorder(null);
        getContentPane().add(txt_eth_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 184, 56, 16));

        dot_precio.setForeground(new java.awt.Color(255, 255, 255));
        dot_precio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dot_precio.setText("$ 20.00");
        getContentPane().add(dot_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 60, 16));

        txt_dotprecio.setBackground(new java.awt.Color(0, 0, 0));
        txt_dotprecio.setBorder(null);
        getContentPane().add(txt_dotprecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 230, 43, 16));

        pocentaje_dot.setForeground(new java.awt.Color(255, 255, 255));
        pocentaje_dot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pocentaje_dot.setText("porc.dot");
        getContentPane().add(pocentaje_dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 45, 16));

        txt_porcentajedot.setBackground(new java.awt.Color(0, 0, 0));
        txt_porcentajedot.setBorder(null);
        getContentPane().add(txt_porcentajedot, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 45, 16));

        etiqueta_dot.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        etiqueta_dot.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta_dot.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        etiqueta_dot.setText("Precio Mínimo en 24 hs :");
        etiqueta_dot.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(etiqueta_dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 254, 130, 16));
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 215, 50, 50));
        getContentPane().add(flecha_verde_dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 233, 12, 12));
        getContentPane().add(flecha_rojo_dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 235, 12, 12));

        xrp_precio_actual.setForeground(new java.awt.Color(255, 255, 255));
        xrp_precio_actual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xrp_precio_actual.setText("$ 0.0000");
        getContentPane().add(xrp_precio_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 60, 16));

        txt_xrp_precio_actual.setBackground(new java.awt.Color(0, 0, 0));
        txt_xrp_precio_actual.setBorder(null);
        getContentPane().add(txt_xrp_precio_actual, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 300, 51, 16));

        xrp_porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        xrp_porcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xrp_porcentaje.setText("jLabel18");
        getContentPane().add(xrp_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 45, 16));

        txt_xrp_porcentaje.setBackground(new java.awt.Color(0, 0, 0));
        txt_xrp_porcentaje.setBorder(null);
        getContentPane().add(txt_xrp_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 45, 16));

        jLabel19.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel19.setText("Precio Mínimo en 24 hs :");
        jLabel19.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 324, 130, 16));

        precio_minimo_xrp.setForeground(new java.awt.Color(255, 255, 255));
        precio_minimo_xrp.setText("$ 0.0000");
        getContentPane().add(precio_minimo_xrp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 324, 50, 16));

        txt_preciominimo_xrp.setBackground(new java.awt.Color(0, 0, 0));
        txt_preciominimo_xrp.setBorder(null);
        getContentPane().add(txt_preciominimo_xrp, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 324, 50, 16));
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 50, 50));
        getContentPane().add(flecha_verde_xrp, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 303, 12, 12));
        getContentPane().add(flecha_rojo_xrp, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 305, 12, 12));
        getContentPane().add(jScrollBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 10, -1, 140));
        jScrollBar1.getAccessibleContext().setAccessibleParent(jTextArea1);

        ada_precioactual.setForeground(new java.awt.Color(255, 255, 255));
        ada_precioactual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ada_precioactual.setText("$ 1000.00");
        getContentPane().add(ada_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 60, 16));

        txt_ada_precioactual.setBackground(new java.awt.Color(0, 0, 0));
        txt_ada_precioactual.setBorder(null);
        getContentPane().add(txt_ada_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 58, 16));

        ada_porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        ada_porcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ada_porcentaje.setText("jlabel13");
        getContentPane().add(ada_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 45, 16));

        txt_ada_porcentaje.setBackground(new java.awt.Color(0, 0, 0));
        txt_ada_porcentaje.setBorder(null);
        getContentPane().add(txt_ada_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 45, 16));
        getContentPane().add(flecha_verde_ada, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 163, 12, 12));
        getContentPane().add(flecha_rojo_ada, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 165, 12, 12));

        jLabel12.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Precio Mínimo en 24 hs :");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 184, 130, 16));

        ada_preciominimo.setForeground(new java.awt.Color(255, 255, 255));
        ada_preciominimo.setText("$ 1000.00");
        getContentPane().add(ada_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 184, 60, 16));

        txt_ada_preciominimo.setBackground(new java.awt.Color(0, 0, 0));
        txt_ada_preciominimo.setBorder(null);
        getContentPane().add(txt_ada_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 184, 56, 16));
        getContentPane().add(jlabel_ada, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 145, 50, 50));

        link_precioactual.setForeground(new java.awt.Color(255, 255, 255));
        link_precioactual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        link_precioactual.setText("$ 20.00");
        getContentPane().add(link_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 43, 16));

        txt_link_precioactual.setBackground(new java.awt.Color(0, 0, 0));
        txt_link_precioactual.setBorder(null);
        getContentPane().add(txt_link_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 43, 16));

        link_porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        link_porcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        link_porcentaje.setText("porc.dot");
        getContentPane().add(link_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 45, 16));

        txt_link_porcentaje.setBackground(new java.awt.Color(0, 0, 0));
        txt_link_porcentaje.setBorder(null);
        getContentPane().add(txt_link_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, 45, 16));

        etiqueta_link.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        etiqueta_link.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta_link.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        etiqueta_link.setText("Precio Mínimo en 24 hs :");
        etiqueta_link.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(etiqueta_link, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 254, 130, 16));

        link_preciominimo.setForeground(new java.awt.Color(255, 255, 255));
        link_preciominimo.setText("$ 20.00");
        getContentPane().add(link_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 254, 43, 16));

        txt_link_preciominimo.setBackground(new java.awt.Color(0, 0, 0));
        txt_link_preciominimo.setBorder(null);
        getContentPane().add(txt_link_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 254, 43, 16));
        getContentPane().add(flecha_verde_link, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 233, 12, 12));
        getContentPane().add(flecha_rojo_link, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 235, 12, 12));
        getContentPane().add(jlabel_link, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 220, 40, 40));

        ltc_precioactual.setForeground(new java.awt.Color(255, 255, 255));
        ltc_precioactual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltc_precioactual.setText("$ 100.00");
        getContentPane().add(ltc_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 52, 16));

        txt_ltc_precioactual.setBackground(new java.awt.Color(0, 0, 0));
        txt_ltc_precioactual.setBorder(null);
        getContentPane().add(txt_ltc_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 300, 52, 16));

        ltc_porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        ltc_porcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltc_porcentaje.setText("porc.dot");
        getContentPane().add(ltc_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 45, 16));

        txt_ltc_porcentaje.setBackground(new java.awt.Color(0, 0, 0));
        txt_ltc_porcentaje.setBorder(null);
        getContentPane().add(txt_ltc_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 45, 16));

        etiqueta_lltc.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        etiqueta_lltc.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta_lltc.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        etiqueta_lltc.setText("Precio Mínimo en 24 hs :");
        etiqueta_lltc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(etiqueta_lltc, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 324, 130, 16));

        ltc_preciominimo.setForeground(new java.awt.Color(255, 255, 255));
        ltc_preciominimo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ltc_preciominimo.setText("$ 100.00");
        getContentPane().add(ltc_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 324, 52, 16));

        txt_ltc_preciominimo.setBackground(new java.awt.Color(0, 0, 0));
        txt_ltc_preciominimo.setBorder(null);
        getContentPane().add(txt_ltc_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 324, 52, 16));
        getContentPane().add(flecha_verde_ltc, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 303, 12, 12));
        getContentPane().add(flecha_rojo_ltc, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 305, 12, 12));
        getContentPane().add(jLabel_ltc, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 290, 40, 40));

        bch_precioactual.setForeground(new java.awt.Color(255, 255, 255));
        bch_precioactual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bch_precioactual.setText("$ 100.00");
        getContentPane().add(bch_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 52, 16));

        txt_bch_precioactual.setBackground(new java.awt.Color(0, 0, 0));
        txt_bch_precioactual.setBorder(null);
        getContentPane().add(txt_bch_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 52, 16));

        etiqueta_bch.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        etiqueta_bch.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta_bch.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        etiqueta_bch.setText("Precio Mínimo en 24 hs :");
        etiqueta_bch.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(etiqueta_bch, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 324, 130, 16));

        bch_porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        bch_porcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bch_porcentaje.setText("porc.dot");
        getContentPane().add(bch_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 45, 16));

        txt_bch_porcentaje.setBackground(new java.awt.Color(0, 0, 0));
        txt_bch_porcentaje.setBorder(null);
        getContentPane().add(txt_bch_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 45, 16));

        bch_preciominimo.setForeground(new java.awt.Color(255, 255, 255));
        bch_preciominimo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bch_preciominimo.setText("$ 100.00");
        getContentPane().add(bch_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 324, 52, 16));

        txt_bch_preciominimo.setBackground(new java.awt.Color(0, 0, 0));
        txt_bch_preciominimo.setBorder(null);
        getContentPane().add(txt_bch_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 324, 52, 16));
        getContentPane().add(flecha_verde_bch, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 303, 12, 12));
        getContentPane().add(flecha_rojo_bch, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 305, 12, 12));
        getContentPane().add(jLabel_bch, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 290, 35, 35));

        etiqueta_xlm.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        etiqueta_xlm.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta_xlm.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        etiqueta_xlm.setText("Precio Mínimo en 24 hs :");
        etiqueta_xlm.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(etiqueta_xlm, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 254, 130, 16));

        xlm_precioactual.setForeground(new java.awt.Color(255, 255, 255));
        xlm_precioactual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xlm_precioactual.setText("$ 0.0000");
        getContentPane().add(xlm_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 230, 50, 16));

        txt_xlm_precioactual.setBackground(new java.awt.Color(0, 0, 0));
        txt_xlm_precioactual.setBorder(null);
        getContentPane().add(txt_xlm_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 230, 50, 16));

        xlm_porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        xlm_porcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        xlm_porcentaje.setText("porc.dot");
        getContentPane().add(xlm_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 45, 16));

        txt_xlm_porcentaje.setBackground(new java.awt.Color(0, 0, 0));
        txt_xlm_porcentaje.setBorder(null);
        getContentPane().add(txt_xlm_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 230, 45, 16));

        xlm_preciominimo.setForeground(new java.awt.Color(255, 255, 255));
        xlm_preciominimo.setText("$ 0.0000");
        getContentPane().add(xlm_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 254, 50, 16));

        txt_xlm_preciominimo.setBackground(new java.awt.Color(0, 0, 0));
        txt_xlm_preciominimo.setBorder(null);
        getContentPane().add(txt_xlm_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 254, 50, 16));
        getContentPane().add(flecha_verde_xlm, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 233, 12, 12));
        getContentPane().add(flecha_rojo_xlm, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 235, 12, 12));
        getContentPane().add(jLabel_xlm, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 210, 60, 60));

        bnb_porcentaje.setForeground(new java.awt.Color(255, 255, 255));
        bnb_porcentaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bnb_porcentaje.setText("jlabel13");
        getContentPane().add(bnb_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 45, 16));

        txt_bnb_porcentaje.setBackground(new java.awt.Color(0, 0, 0));
        txt_bnb_porcentaje.setBorder(null);
        getContentPane().add(txt_bnb_porcentaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 45, 16));

        bnb_precioactual.setForeground(new java.awt.Color(255, 255, 255));
        bnb_precioactual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bnb_precioactual.setText("$ 20.00");
        getContentPane().add(bnb_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 160, 50, 16));

        txt_bnb_precioactual.setBackground(new java.awt.Color(0, 0, 0));
        txt_bnb_precioactual.setBorder(null);
        getContentPane().add(txt_bnb_precioactual, new org.netbeans.lib.awtextra.AbsoluteConstraints(536, 160, 50, 16));

        etiqueta_bnb.setFont(new java.awt.Font("Bookman Old Style", 0, 10)); // NOI18N
        etiqueta_bnb.setForeground(new java.awt.Color(255, 255, 255));
        etiqueta_bnb.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        etiqueta_bnb.setText("Precio Mínimo en 24 hs :");
        etiqueta_bnb.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(etiqueta_bnb, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 184, 130, 16));

        bnb_preciominimo.setForeground(new java.awt.Color(255, 255, 255));
        bnb_preciominimo.setText("$ 20.00");
        getContentPane().add(bnb_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 184, 50, 16));

        txt_bnb_preciominimo.setBackground(new java.awt.Color(0, 0, 0));
        txt_bnb_preciominimo.setBorder(null);
        getContentPane().add(txt_bnb_preciominimo, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 184, 50, 16));
        getContentPane().add(flecha_verde_bnb, new org.netbeans.lib.awtextra.AbsoluteConstraints(597, 163, 12, 12));
        getContentPane().add(flecha_rojo_bnb, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 165, 12, 12));
        getContentPane().add(jLabel_bnb, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 155, 35, 35));

        precio_minimo_dot.setForeground(new java.awt.Color(255, 255, 255));
        precio_minimo_dot.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        precio_minimo_dot.setText("jLabel1");
        getContentPane().add(precio_minimo_dot, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 254, 43, 16));

        txt_preciominimodot.setBackground(new java.awt.Color(0, 0, 0));
        txt_preciominimodot.setBorder(null);
        getContentPane().add(txt_preciominimodot, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 254, 43, 16));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 51, 255)));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));

        jMenu2.setText("Noticia mas reciente");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Informacion acerca");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        new Prueva().setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    public static Icon imagen_nueva;
    public static Icon imagen_actual;
    public String dato2_precio_btc24hs;
    public String dato2_precio_eth24hs;
    public String dato_precio_btc;
    public String dato_precio_eth;
    double bandera_precioactual_btc, bandera_precioactual_eth;
    double bandera_preciominimo_btc, bandera_preciominimo_eth;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel ada_porcentaje;
    public static javax.swing.JLabel ada_precioactual;
    public static javax.swing.JLabel ada_preciominimo;
    public static javax.swing.JLabel bch_porcentaje;
    public static javax.swing.JLabel bch_precioactual;
    public static javax.swing.JLabel bch_preciominimo;
    public static javax.swing.JLabel bnb_porcentaje;
    public static javax.swing.JLabel bnb_precioactual;
    public static javax.swing.JLabel bnb_preciominimo;
    private javax.swing.JLabel btc_precioactual;
    private javax.swing.JLabel btc_preciominimo;
    public static javax.swing.JLabel dot_precio;
    private javax.swing.JLabel eth_porcentaje;
    private javax.swing.JLabel eth_precioactual;
    private javax.swing.JLabel eth_preciominimo;
    public static javax.swing.JLabel etiqueta_bch;
    private javax.swing.JLabel etiqueta_bnb;
    public static javax.swing.JLabel etiqueta_dot;
    public static javax.swing.JLabel etiqueta_link;
    public static javax.swing.JLabel etiqueta_lltc;
    public static javax.swing.JLabel etiqueta_xlm;
    public static javax.swing.JLabel flecha_rojo_ada;
    public static javax.swing.JLabel flecha_rojo_bch;
    public static javax.swing.JLabel flecha_rojo_bnb;
    private javax.swing.JLabel flecha_rojo_btc;
    public static javax.swing.JLabel flecha_rojo_dot;
    private javax.swing.JLabel flecha_rojo_eth;
    public static javax.swing.JLabel flecha_rojo_link;
    public static javax.swing.JLabel flecha_rojo_ltc;
    public static javax.swing.JLabel flecha_rojo_xlm;
    public static javax.swing.JLabel flecha_rojo_xrp;
    public static javax.swing.JLabel flecha_verde_ada;
    public static javax.swing.JLabel flecha_verde_bch;
    public static javax.swing.JLabel flecha_verde_bnb;
    private javax.swing.JLabel flecha_verde_btc;
    public static javax.swing.JLabel flecha_verde_dot;
    private javax.swing.JLabel flecha_verde_eth;
    public static javax.swing.JLabel flecha_verde_link;
    public static javax.swing.JLabel flecha_verde_ltc;
    public static javax.swing.JLabel flecha_verde_xlm;
    public static javax.swing.JLabel flecha_verde_xrp;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_bch;
    private javax.swing.JLabel jLabel_bnb;
    private javax.swing.JLabel jLabel_ltc;
    private javax.swing.JLabel jLabel_xlm;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel jlabel_ada;
    private javax.swing.JLabel jlabel_link;
    public static javax.swing.JLabel link_porcentaje;
    public static javax.swing.JLabel link_precioactual;
    public static javax.swing.JLabel link_preciominimo;
    public static javax.swing.JLabel ltc_porcentaje;
    public static javax.swing.JLabel ltc_precioactual;
    public static javax.swing.JLabel ltc_preciominimo;
    public static javax.swing.JLabel pocentaje_dot;
    private javax.swing.JLabel porcentaje_btc;
    public static javax.swing.JLabel precio_minimo_dot;
    public static javax.swing.JLabel precio_minimo_xrp;
    public static javax.swing.JTextField txt_ada_porcentaje;
    public static javax.swing.JTextField txt_ada_precioactual;
    public static javax.swing.JTextField txt_ada_preciominimo;
    public static javax.swing.JTextField txt_bch_porcentaje;
    public static javax.swing.JTextField txt_bch_precioactual;
    public static javax.swing.JTextField txt_bch_preciominimo;
    public static javax.swing.JTextField txt_bnb_porcentaje;
    public static javax.swing.JTextField txt_bnb_precioactual;
    public static javax.swing.JTextField txt_bnb_preciominimo;
    private javax.swing.JTextField txt_btc_precioactual;
    private javax.swing.JTextField txt_btc_preciominimo;
    public static javax.swing.JTextField txt_dotprecio;
    private javax.swing.JTextField txt_eth_porcentaje;
    private javax.swing.JTextField txt_eth_precioactual;
    private javax.swing.JTextField txt_eth_preciominimo;
    public static javax.swing.JTextField txt_link_porcentaje;
    public static javax.swing.JTextField txt_link_precioactual;
    public static javax.swing.JTextField txt_link_preciominimo;
    public static javax.swing.JTextField txt_ltc_porcentaje;
    public static javax.swing.JTextField txt_ltc_precioactual;
    public static javax.swing.JTextField txt_ltc_preciominimo;
    private javax.swing.JTextField txt_porcentaje_btc;
    public static javax.swing.JTextField txt_porcentajedot;
    public static javax.swing.JTextField txt_preciominimo_xrp;
    public static javax.swing.JTextField txt_preciominimodot;
    public static javax.swing.JTextField txt_xlm_porcentaje;
    public static javax.swing.JTextField txt_xlm_precioactual;
    public static javax.swing.JTextField txt_xlm_preciominimo;
    public static javax.swing.JTextField txt_xrp_porcentaje;
    public static javax.swing.JTextField txt_xrp_precio_actual;
    public static javax.swing.JLabel xlm_porcentaje;
    public static javax.swing.JLabel xlm_precioactual;
    public static javax.swing.JLabel xlm_preciominimo;
    public static javax.swing.JLabel xrp_porcentaje;
    public static javax.swing.JLabel xrp_precio_actual;
    // End of variables declaration//GEN-END:variables

    class fondo extends JPanel {

        private Image imagen_principal, imagen_btc, imagen_eth, imagen_dot, imagen_xrp, imagen_ada, imagen_link,
                imagen_ltc, imagen_bch, imagen_xlm, imagen_bnb;

        @Override
        public void paint(Graphics g) {
            imagen_principal = new ImageIcon(getClass().getResource("/Imagen/bitcoin_bexplus.png")).getImage();
            imagen_btc = new ImageIcon(getClass().getResource("/Imagen/btc.png")).getImage();
            imagen_eth = new ImageIcon(getClass().getResource("/Imagen/eth.png")).getImage();
            imagen_dot = new ImageIcon(getClass().getResource("/Imagen/dot2_modi.png")).getImage();
            imagen_xrp = new ImageIcon(getClass().getResource("/Imagen/xrp_modi.png")).getImage();
            imagen_ada = new ImageIcon(getClass().getResource("/Imagen/ada.png")).getImage();
            imagen_link = new ImageIcon(getClass().getResource("/Imagen/link_modi.png")).getImage();
            imagen_ltc = new ImageIcon(getClass().getResource("/Imagen/ltc.png")).getImage();
            imagen_bch = new ImageIcon(getClass().getResource("/Imagen/bch.png")).getImage();
            imagen_xlm = new ImageIcon(getClass().getResource("/Imagen/xlm.png")).getImage();
            imagen_bnb = new ImageIcon(getClass().getResource("/Imagen/bnb.png")).getImage();

            g.drawImage(imagen_principal, 0, 0, jLabel2.getWidth(), jLabel2.getHeight(), null);
            g.drawImage(imagen_btc, 255, 80, jLabel4.getWidth(), jLabel4.getHeight(), null);
            g.drawImage(imagen_eth, 16, 130, jLabel9.getWidth(), jLabel9.getHeight(), null);
            g.drawImage(imagen_dot, 20, 215, jLabel16.getWidth(), jLabel16.getHeight(), null);
            g.drawImage(imagen_xrp, 20, 280, jLabel20.getWidth(), jLabel20.getHeight(), null);
            g.drawImage(imagen_ada, 250, 145, jlabel_ada.getWidth(), jlabel_ada.getHeight(), null);
            g.drawImage(imagen_link, 255, 215, jlabel_link.getWidth(), jlabel_link.getHeight(), null);
            g.drawImage(imagen_ltc, 255, 285, jLabel_ltc.getWidth(), jLabel_ltc.getHeight(), null);
            g.drawImage(imagen_bch, 490, 290, jLabel_bch.getWidth(), jLabel_bch.getHeight(), null);
            g.drawImage(imagen_xlm, 475, 210, jLabel_xlm.getWidth(), jLabel_xlm.getHeight(), null);
            g.drawImage(imagen_bnb, 490, 145, jLabel_bnb.getWidth(), jLabel_bnb.getHeight(), null);

            setOpaque(false);

            super.paint(g);

        }
    }
}
