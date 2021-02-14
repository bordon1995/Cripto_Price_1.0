package Principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Stellar_xlm_Binance_bnb {

    public static double precio_actual_xlm;
    public static double precio_minimo24_xlm;
    public static double precio_actual_bnb;
    public static double precio_minimo24_bnb;
    
     public void mostrar_valores() {
        obtener_precioactual_xlm();
        obtener_precioactual_bnb();
        obtener_preciominimo24hs_xlm();
        obtener_preciominimo24hs_bnb();
        mostrar_porcentaje_xlm();
        mostrar_porcentaje_bnb();
        Principal.xlm_precioactual.setText("$ " + String.valueOf(precio_actual_xlm));
        Principal.xlm_preciominimo.setText("$ " + String.valueOf(precio_minimo24_xlm));
        Principal.bnb_precioactual.setText("$ " + String.valueOf(precio_actual_bnb));
        Principal.bnb_preciominimo.setText("$ " + String.valueOf(precio_minimo24_bnb));
        hilo();
        hilo2();
    }

    public void obtener_precioactual_xlm() {
        int bandera = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/stellar").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_xlm = precio;
                bandera++;
                if (bandera == 2) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }
        }
        String cad = dato_xlm;
        int desde = 1, hasta = 2;
        String cad_modi = cad.substring(desde, hasta);
        desde = 3;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_actual_xlm = Double.parseDouble(ultimo);
    }

    public void obtener_precioactual_bnb() {
        int bandera = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/binance-coin").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_bnb = precio;
                bandera++;
                if (bandera == 2) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }

        }
        String cad = dato_bnb;
        int desde = 1, hasta = 4;
        String cad_modi = cad.substring(desde, hasta);
        desde = 5;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_actual_bnb = Double.parseDouble(ultimo);
    }

    public void obtener_preciominimo24hs_xlm() {
        int bandera = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/stellar").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_minimo24hs_xlm = precio;
                bandera++;
                if (bandera == 7) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }
        }
        String cad = dato_minimo24hs_xlm;
        int desde = 1, hasta = 2;
        String cad_modi = cad.substring(desde, hasta);
        desde = 3;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_minimo24_xlm = Double.parseDouble(ultimo);
    }

    public void obtener_preciominimo24hs_bnb() {
        int bandera = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/binance-coin").select("tr");
        for (Element dato : elementos) {
            try {
                dato_minimo24hs_bnb = dato.select("td").text();
                bandera++;
                if (bandera == 7) {
                    break;
                }
            } catch (Exception e) {

            }
        }
        String cad = dato_minimo24hs_bnb;
        int desde = 1, hasta = 4;
        String cad_modi = cad.substring(desde, hasta);
        desde = 5;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_minimo24_bnb = Double.parseDouble(ultimo);
    }

    public void mostrar_porcentaje_xlm() {
        double resultado = ((precio_actual_xlm * 100) / precio_minimo24_xlm) - 100;
        if (precio_actual_xlm > precio_minimo24_xlm) {
            Principal.xlm_porcentaje.setForeground(Color.GREEN);
            Principal.xlm_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_xlm.setVisible(true);
            Principal.flecha_rojo_xlm.setVisible(false);
        } else if (precio_actual_xlm < precio_minimo24_xlm) {
            Principal.xlm_porcentaje.setForeground(Color.RED);
            Principal.xlm_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_xlm.setVisible(false);
            Principal.flecha_rojo_xlm.setVisible(true);
        }
    }

    public void mostrar_porcentaje_bnb() {
        double resultado = ((precio_actual_bnb * 100) / precio_minimo24_bnb) - 100;
        if (precio_actual_bnb > precio_minimo24_bnb) {
            Principal.bnb_porcentaje.setForeground(Color.GREEN);
            Principal.bnb_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_bnb.setVisible(true);
            Principal.flecha_rojo_bnb.setVisible(false);
        } else if (precio_actual_bnb < precio_minimo24_bnb) {
            Principal.bnb_porcentaje.setForeground(Color.RED);
            Principal.bnb_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_bnb.setVisible(false);
            Principal.flecha_rojo_bnb.setVisible(true);
        }
    }

    public void stop_hilo_xlm() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.xlm_precioactual.setForeground(Color.WHITE);
                Principal.xlm_preciominimo.setForeground(Color.WHITE);
                Principal.txt_xlm_precioactual.setVisible(false);
                Principal.txt_xlm_preciominimo.setVisible(false);
                Principal.txt_xlm_porcentaje.setVisible(false);
                mostrar_porcentaje_xlm();
            }
        };
        timer.schedule(tk, 10000);
    }

    public void stop_hilo_bnb() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.bnb_precioactual.setForeground(Color.WHITE);
                Principal.bnb_preciominimo.setForeground(Color.WHITE);
                Principal.txt_bnb_precioactual.setVisible(false);
                Principal.txt_bnb_preciominimo.setVisible(false);
                Principal.txt_bnb_porcentaje.setVisible(false);
                mostrar_porcentaje_bnb();
            }
        };
        timer.schedule(tk, 10000);
    }

    public void start_verde_precioactual_xlm() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.xlm_precioactual.setForeground(Color.GREEN);
                Principal.txt_xlm_precioactual.setBackground(new Color(153, 255, 153));
                Principal.txt_xlm_precioactual.setVisible(true);
                Principal.xlm_porcentaje.setForeground(Color.GREEN);
                Principal.txt_xlm_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_xlm_porcentaje.setVisible(true);
                Principal.flecha_verde_xlm.setVisible(true);
                Principal.flecha_rojo_xlm.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_xlm();
    }

    public void start_verde_precioactual_bnb() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.bnb_precioactual.setForeground(Color.GREEN);
                Principal.txt_bnb_precioactual.setBackground(new Color(153, 255, 153));
                Principal.txt_bnb_precioactual.setVisible(true);
                Principal.bnb_porcentaje.setForeground(Color.GREEN);
                Principal.txt_bnb_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_bnb_porcentaje.setVisible(true);
                Principal.flecha_verde_bnb.setVisible(true);
                Principal.flecha_rojo_bnb.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_bnb();
    }

    public void start_rojo_precioactual_xlm() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new java.util.TimerTask() {
            @Override
            public void run() {
                Principal.xlm_precioactual.setForeground(Color.red);
                Principal.txt_xlm_precioactual.setBackground(new Color(255, 102, 102));
                Principal.txt_xlm_precioactual.setVisible(true);
                Principal.xlm_porcentaje.setForeground(Color.red);
                Principal.txt_xlm_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_xlm_porcentaje.setVisible(true);
                Principal.flecha_verde_xlm.setVisible(false);
                Principal.flecha_rojo_xlm.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_xlm();
    }

    public void start_rojo_precioactual_bnb() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new java.util.TimerTask() {
            @Override
            public void run() {
                Principal.bnb_precioactual.setForeground(Color.red);
                Principal.txt_bnb_precioactual.setBackground(new Color(255, 102, 102));
                Principal.txt_bnb_precioactual.setVisible(true);
                Principal.bnb_porcentaje.setForeground(Color.red);
                Principal.txt_bnb_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_bnb_porcentaje.setVisible(true);
                Principal.flecha_verde_bnb.setVisible(false);
                Principal.flecha_rojo_bnb.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_bnb();
    }

    public void start_verde_preciominimo24_xlm() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.xlm_preciominimo.setForeground(Color.GREEN);
                Principal.txt_xlm_preciominimo.setBackground(new Color(153, 255, 153));
                Principal.txt_xlm_preciominimo.setVisible(true);
                Principal.xlm_porcentaje.setForeground(Color.GREEN);
                Principal.txt_xlm_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_xlm_porcentaje.setVisible(true);
                Principal.flecha_verde_xlm.setVisible(true);
                Principal.flecha_rojo_xlm.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_xlm();
    }

    public void start_verde_preciominimo24_bnb() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.bnb_preciominimo.setForeground(Color.GREEN);
                Principal.txt_bnb_preciominimo.setBackground(new Color(153, 255, 153));
                Principal.txt_bnb_preciominimo.setVisible(true);
                Principal.bnb_porcentaje.setForeground(Color.GREEN);
                Principal.txt_bnb_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_bnb_porcentaje.setVisible(true);
                Principal.flecha_verde_bnb.setVisible(true);
                Principal.flecha_rojo_bnb.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_bnb();
    }

    public void start_rojo_preciominimo24_xlm() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.xlm_preciominimo.setForeground(Color.RED);
                Principal.txt_xlm_preciominimo.setBackground(new Color(255, 102, 102));
                Principal.txt_xlm_preciominimo.setVisible(true);
                Principal.xlm_porcentaje.setForeground(Color.RED);
                Principal.txt_xlm_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_xlm_porcentaje.setVisible(true);
                Principal.flecha_verde_xlm.setVisible(false);
                Principal.flecha_rojo_xlm.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_xlm();
    }

    public void start_rojo_preciominimo24_bnb() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.bnb_preciominimo.setForeground(Color.RED);
                Principal.txt_bnb_preciominimo.setBackground(new Color(255, 102, 102));
                Principal.txt_bnb_preciominimo.setVisible(true);
                Principal.bnb_porcentaje.setForeground(Color.RED);
                Principal.txt_bnb_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_bnb_porcentaje.setVisible(true);
                Principal.flecha_verde_bnb.setVisible(false);
                Principal.flecha_rojo_bnb.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_bnb();
    }

    public void hilo() {
        bandera_xlm = precio_actual_xlm;
        bandera_bnb = precio_actual_bnb;
        javax.swing.Timer hilo = new javax.swing.Timer(40000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Timer timer = new java.util.Timer();
                TimerTask tk = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_precioactual_xlm();
                        Principal.xlm_precioactual.setText("$ " + String.valueOf(precio_actual_xlm));
                        Principal.text += "\n" + "xlm : " + String.valueOf(precio_actual_xlm);
                        Principal.jTextArea1.setText(Principal.text);
                        if (precio_actual_xlm > bandera_xlm) {
                            start_verde_precioactual_xlm();
                            bandera_xlm = precio_actual_xlm;
                        } else if (precio_actual_xlm < bandera_xlm) {
                            start_rojo_precioactual_xlm();
                            bandera_xlm = precio_actual_xlm;
                        }
                    }
                };
                timer.schedule(tk, 0);
                java.util.Timer timer2 = new java.util.Timer();
                TimerTask tk2 = new java.util.TimerTask() {
                    @Override
                    public void run() {
                        obtener_precioactual_bnb();
                        Principal.bnb_precioactual.setText("$ " + String.valueOf(precio_actual_bnb));
                        Principal.text += "\n" + "bnb : " + String.valueOf(precio_actual_bnb);
                        Principal.jTextArea1.setText(Principal.text);
                        if (precio_actual_bnb > bandera_bnb) {
                            start_verde_precioactual_bnb();
                            bandera_bnb = precio_actual_bnb;
                        } else if (precio_actual_bnb < bandera_bnb) {
                            start_rojo_precioactual_bnb();
                            bandera_bnb = precio_actual_bnb;
                        }
                    }
                };
                timer2.schedule(tk2, 20000);
            }
        });
        hilo.start();
    }
    
    public void hilo2() {
        bandera2_xlm = precio_minimo24_xlm;
        bandera2_bnb = precio_minimo24_bnb;
        javax.swing.Timer hilo = new javax.swing.Timer(50000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Timer timer = new java.util.Timer();
                TimerTask tk = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_preciominimo24hs_xlm();
                        Principal.bnb_preciominimo.setText("$ " + String.valueOf(precio_minimo24_bnb));
                        if (precio_minimo24_xlm > bandera2_xlm) {
                            start_verde_preciominimo24_xlm();
                            System.out.println(bandera2_xlm);
                            bandera2_xlm = precio_minimo24_xlm;
                        } else if (precio_minimo24_xlm < bandera2_xlm) {
                            start_rojo_preciominimo24_xlm();
                            System.out.println(bandera2_xlm);
                            bandera2_xlm = precio_minimo24_xlm;
                        } 
                    }
                };
                timer.schedule(tk, 0);
                java.util.Timer timer2 = new java.util.Timer();
                TimerTask tk2 = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_preciominimo24hs_bnb();
                        Principal.bnb_preciominimo.setText("$ " + String.valueOf(precio_minimo24_bnb));
                        if (precio_minimo24_bnb > bandera2_bnb) {
                            start_verde_preciominimo24_bnb();
                            System.out.println(bandera2_bnb);
                            bandera2_bnb = precio_minimo24_bnb;
                        } else if (precio_minimo24_bnb < bandera2_bnb) {
                            start_rojo_preciominimo24_bnb();
                            System.out.println(bandera2_bnb);
                            bandera2_bnb = precio_minimo24_bnb;
                        }
                    }
                };
                timer2.schedule(tk2, 30000);
            }
        });
        hilo.start();

    }

    public String dato_xlm;
    public String dato_bnb;
    public String dato_minimo24hs_xlm;
    public String dato_minimo24hs_bnb;
    double bandera_xlm;
    double bandera_bnb;
    double bandera2_xlm;
    double bandera2_bnb;
}
