package Principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Litecoin_Bitcoin_cash {

    public static double precio_actual_ltc;
    public static double precio_minimo24_ltc;
    public static double precio_actual_bch;
    public static double precio_minimo24_bch;

    public void mostrar_valores() {
        obtener_precioactual_ltc();
        obtener_precioactual_bch();
        obtener_preciominimo24hs_ltc();
        obtener_preciominimo24hs_bch();
        mostrar_porcentaje_ltc();
        mostrar_porcentaje_bch();
        Principal.ltc_precioactual.setText("$ " + String.valueOf(precio_actual_ltc));
        Principal.ltc_preciominimo.setText("$ " + String.valueOf(precio_minimo24_ltc));
        Principal.bch_precioactual.setText("$ " + String.valueOf(precio_actual_bch));
        Principal.bch_preciominimo.setText("$ " + String.valueOf(precio_minimo24_bch));
        hilo();
        hilo2();
    }

    public void obtener_precioactual_ltc() {
        int vuelta = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/litecoin").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_precioactual_ltc = precio;
                vuelta++;
                if (vuelta == 2) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }

        }
        String cad = dato_precioactual_ltc;
        int desde = 1, hasta = 4;
        String cad_modi = cad.substring(desde, hasta);
        desde = 5;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_actual_ltc = Double.parseDouble(ultimo);

    }

    public void obtener_precioactual_bch() {
       int vuelta = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/bitcoin-cash").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_precioactual_bch = precio;
                vuelta++;
                if (vuelta == 2) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }

        }
        String cad = dato_precioactual_bch;
        int desde = 1, hasta = 4;
        String cad_modi = cad.substring(desde, hasta);
        desde = 5;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_actual_bch = Double.parseDouble(ultimo);

    }

    public void obtener_preciominimo24hs_ltc() {
        int bandera = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/litecoin").select("tr");
        for (Element dato : elementos) {
            try {
                dato_minimo24hs_ltc = dato.select("td").text();
                bandera++;
                if (bandera == 7) {
                    break;
                }
            } catch (Exception e) {

            }
        }
        String cad = dato_minimo24hs_ltc;
        int desde = 1, hasta = 4;
        String cad_modi = cad.substring(desde, hasta);
        desde = 5;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_minimo24_ltc = Double.parseDouble(ultimo);
    }

    public void obtener_preciominimo24hs_bch() {
        int bandera = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/bitcoin-cash").select("tr");
        for (Element dato : elementos) {
            try {
                dato_minimo24hs_bch = dato.select("td").text();
                bandera++;
                if (bandera == 7) {
                    break;
                }
            } catch (Exception e) {

            }
        }
        String cad = dato_minimo24hs_bch;
        int desde = 1, hasta = 4;
        String cad_modi = cad.substring(desde, hasta);
        desde = 5;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_minimo24_bch = Double.parseDouble(ultimo);
    }

    public void mostrar_porcentaje_ltc() {
        double resultado = ((precio_actual_ltc * 100) / precio_minimo24_ltc) - 100;
        if (precio_actual_ltc > precio_minimo24_ltc) {
            Principal.ltc_porcentaje.setForeground(Color.GREEN);
            Principal.ltc_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_ltc.setVisible(true);
            Principal.flecha_rojo_ltc.setVisible(false);
        } else if (precio_actual_ltc < precio_minimo24_ltc) {
            Principal.ltc_porcentaje.setForeground(Color.RED);
            Principal.ltc_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_ltc.setVisible(false);
            Principal.flecha_rojo_ltc.setVisible(true);
        }
    }

    public void mostrar_porcentaje_bch() {
        double resultado = ((precio_actual_bch * 100) / precio_minimo24_bch) - 100;
        if (precio_actual_bch > precio_minimo24_bch) {
            Principal.bch_porcentaje.setForeground(Color.GREEN);
            Principal.bch_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_bch.setVisible(true);
            Principal.flecha_rojo_bch.setVisible(false);
        } else if (precio_actual_bch < precio_minimo24_bch) {
            Principal.bch_porcentaje.setForeground(Color.RED);
            Principal.bch_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_bch.setVisible(false);
            Principal.flecha_rojo_bch.setVisible(true);
        }
    }

    public void stop_hilo_ltc() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.ltc_precioactual.setForeground(Color.WHITE);
                Principal.ltc_preciominimo.setForeground(Color.WHITE);
                Principal.txt_ltc_precioactual.setVisible(false);
                Principal.txt_ltc_preciominimo.setVisible(false);
                Principal.txt_ltc_porcentaje.setVisible(false);
                mostrar_porcentaje_ltc();
            }
        };
        timer.schedule(tk, 10000);
    }

    public void stop_hilo_bch() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.bch_precioactual.setForeground(Color.WHITE);
                Principal.bch_preciominimo.setForeground(Color.WHITE);
                Principal.txt_bch_precioactual.setVisible(false);
                Principal.txt_bch_preciominimo.setVisible(false);
                Principal.txt_bch_porcentaje.setVisible(false);
                mostrar_porcentaje_bch();
            }
        };
        timer.schedule(tk, 10000);
    }

    public void start_verde_precioactual_ltc() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.ltc_precioactual.setForeground(Color.GREEN);
                Principal.txt_ltc_precioactual.setBackground(new Color(153, 255, 153));
                Principal.txt_ltc_precioactual.setVisible(true);
                Principal.ltc_porcentaje.setForeground(Color.GREEN);
                Principal.txt_ltc_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_ltc_porcentaje.setVisible(true);
                Principal.flecha_verde_ltc.setVisible(true);
                Principal.flecha_rojo_ltc.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_ltc();
    }

    public void start_verde_precioactual_bch() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.bch_precioactual.setForeground(Color.GREEN);
                Principal.txt_bch_precioactual.setBackground(new Color(153, 255, 153));
                Principal.txt_bch_precioactual.setVisible(true);
                Principal.bch_porcentaje.setForeground(Color.GREEN);
                Principal.txt_bch_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_bch_porcentaje.setVisible(true);
                Principal.flecha_verde_bch.setVisible(true);
                Principal.flecha_rojo_bch.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_bch();
    }

    public void start_rojo_precioactual_ltc() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new java.util.TimerTask() {
            @Override
            public void run() {
                Principal.ltc_precioactual.setForeground(Color.red);
                Principal.txt_ltc_precioactual.setBackground(new Color(255, 102, 102));
                Principal.txt_ltc_precioactual.setVisible(true);
                Principal.ltc_porcentaje.setForeground(Color.red);
                Principal.txt_ltc_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_ltc_porcentaje.setVisible(true);
                Principal.flecha_verde_ltc.setVisible(false);
                Principal.flecha_rojo_ltc.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_ltc();
    }

    public void start_rojo_precioactual_bch() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new java.util.TimerTask() {
            @Override
            public void run() {
                Principal.bch_precioactual.setForeground(Color.red);
                Principal.txt_bch_precioactual.setBackground(new Color(255, 102, 102));
                Principal.txt_bch_precioactual.setVisible(true);
                Principal.bch_porcentaje.setForeground(Color.red);
                Principal.txt_bch_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_bch_porcentaje.setVisible(true);
                Principal.flecha_verde_bch.setVisible(false);
                Principal.flecha_rojo_bch.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_bch();
    }

    public void start_verde_preciominimo24_ltc() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.ltc_preciominimo.setForeground(Color.GREEN);
                Principal.txt_ltc_preciominimo.setBackground(new Color(153, 255, 153));
                Principal.txt_ltc_preciominimo.setVisible(true);
                Principal.ltc_porcentaje.setForeground(Color.GREEN);
                Principal.txt_ltc_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_ltc_porcentaje.setVisible(true);
                Principal.flecha_verde_ltc.setVisible(true);
                Principal.flecha_rojo_ltc.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_ltc();
    }

    public void start_verde_preciominimo24_bch() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.bch_preciominimo.setForeground(Color.GREEN);
                Principal.txt_bch_preciominimo.setBackground(new Color(153, 255, 153));
                Principal.txt_bch_preciominimo.setVisible(true);
                Principal.bch_porcentaje.setForeground(Color.GREEN);
                Principal.txt_bch_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_bch_porcentaje.setVisible(true);
                Principal.flecha_verde_bch.setVisible(true);
                Principal.flecha_rojo_bch.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_bch();
    }

    public void start_rojo_preciominimo24_ltc() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.ltc_preciominimo.setForeground(Color.RED);
                Principal.txt_ltc_preciominimo.setBackground(new Color(255, 102, 102));
                Principal.txt_ltc_preciominimo.setVisible(true);
                Principal.ltc_porcentaje.setForeground(Color.RED);
                Principal.txt_ltc_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_ltc_porcentaje.setVisible(true);
                Principal.flecha_verde_ltc.setVisible(false);
                Principal.flecha_rojo_ltc.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_ltc();
    }

    public void start_rojo_preciominimo24_bch() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.bch_preciominimo.setForeground(Color.RED);
                Principal.txt_bch_preciominimo.setBackground(new Color(255, 102, 102));
                Principal.txt_bch_preciominimo.setVisible(true);
                Principal.bch_porcentaje.setForeground(Color.RED);
                Principal.txt_bch_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_bch_porcentaje.setVisible(true);
                Principal.flecha_verde_bch.setVisible(false);
                Principal.flecha_rojo_bch.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_bch();
    }

    public void hilo() {
        bandera_ltc = precio_actual_ltc;
        bandera_bch = precio_actual_bch;
        javax.swing.Timer hilo = new javax.swing.Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Timer timer = new java.util.Timer();
                TimerTask tk = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_precioactual_ltc();
                        Principal.ltc_precioactual.setText("$ " + String.valueOf(precio_actual_ltc));
                        Principal.text += "\n" + "ltc : " + String.valueOf(precio_actual_ltc);
                        Principal.jTextArea1.setText(Principal.text);
                        if (precio_actual_ltc > bandera_ltc) {
                            start_verde_precioactual_ltc();
                            bandera_ltc = precio_actual_ltc;
                        } else if (precio_actual_ltc < bandera_ltc) {
                            start_rojo_precioactual_ltc();
                            bandera_ltc = precio_actual_ltc;
                        }
                    }
                };
                timer.schedule(tk, 0);
                java.util.Timer timer2 = new java.util.Timer();
                TimerTask tk2 = new java.util.TimerTask() {
                    @Override
                    public void run() {
                        obtener_precioactual_bch();
                        Principal.bch_precioactual.setText("$ " + String.valueOf(precio_actual_bch));
                        Principal.text += "\n" + "bch : " + String.valueOf(precio_actual_bch);
                        Principal.jTextArea1.setText(Principal.text);
                        if (precio_actual_bch > bandera_bch) {
                            start_verde_precioactual_bch();
                            bandera_bch = precio_actual_bch;
                        } else if (precio_actual_bch < bandera_bch) {
                            start_rojo_precioactual_bch();
                            bandera_bch = precio_actual_bch;
                        }
                    }
                };
                timer2.schedule(tk2, 20000);
            }
        });
        hilo.start();
    }

    public void hilo2() {
        bandera2_ltc = precio_minimo24_ltc;
        bandera2_bch = precio_minimo24_bch;
        javax.swing.Timer hilo = new javax.swing.Timer(130000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Timer timer = new java.util.Timer();
                TimerTask tk = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_preciominimo24hs_ltc();
                        Principal.ltc_preciominimo.setText("$ " + String.valueOf(precio_minimo24_ltc));
                        if (precio_minimo24_ltc > bandera2_ltc) {
                            start_verde_preciominimo24_ltc();
                            System.out.println(bandera2_ltc);
                            bandera2_ltc = precio_minimo24_ltc;
                        } else if (precio_minimo24_ltc < bandera2_ltc) {
                            start_rojo_preciominimo24_ltc();
                            System.out.println(bandera2_ltc);
                            bandera2_ltc = precio_minimo24_ltc;
                        }
                    }
                };
                timer.schedule(tk, 0);
                java.util.Timer timer2 = new java.util.Timer();
                TimerTask tk2 = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_preciominimo24hs_bch();
                        Principal.bch_preciominimo.setText("$ " + String.valueOf(precio_minimo24_bch));
                        if (precio_minimo24_bch > bandera2_bch) {
                            start_verde_preciominimo24_bch();
                            System.out.println(bandera2_bch);
                            bandera2_bch = precio_minimo24_bch;
                        } else if (precio_minimo24_bch < bandera2_bch) {
                            start_rojo_preciominimo24_bch();
                            System.out.println(bandera2_bch);
                            bandera2_bch = precio_minimo24_bch;
                        }
                    }
                };
                timer2.schedule(tk2, 60000);
            }
        });
        hilo.start();

    }

    public String dato_ltc;
    public String dato_bcg;
    public String dato_precioactual_ltc;
    public String dato_precioactual_bch;
    public String dato_minimo24hs_ltc;
    public String dato_minimo24hs_bch;
    double bandera_ltc;
    double bandera_bch;
    double bandera2_ltc;
    double bandera2_bch;

}
