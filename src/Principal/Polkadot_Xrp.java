package Principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Polkadot_Xrp {

    public static double precio_actual_polcadot;
    public static double precio_minimo24_polcadot;
    public static double precio_actual_ripple;
    public static double precio_minimo24_ripple;

    public void Mostrar_valores() {
        obtener_precioactual_polcadot();
        obtener_precioactual_ripple();
        obtener_preciominimo24hs_polcadot();
        obtener_preciominimo24hs_ripple();
        mostrar_porcentaje_polkadot();
        mostrar_porcentaje_ripple();
        Principal.precio_minimo_dot.setText("$ " + String.valueOf(precio_minimo24_polcadot));
        Principal.precio_minimo_xrp.setText("$ " + String.valueOf(precio_minimo24_ripple));
        Principal.dot_precio.setText("$ " + String.valueOf(precio_actual_polcadot));
        Principal.xrp_precio_actual.setText("$ " + String.valueOf(precio_actual_ripple));
        hilo();
        hilo2();
    }

    public void obtener_precioactual_polcadot() {
        int vuelta = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/polkadot").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_polcadot = precio;
                vuelta++;
                if (vuelta == 2) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }

        }
        String cad = dato_polcadot;
        int desde = 1, hasta = 3;
        String cad_modi = cad.substring(desde, hasta);
        desde = 4;
        hasta = 6;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_actual_polcadot = Double.parseDouble(ultimo);
        
    }

    public void obtener_precioactual_ripple() {
        int vuelta = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/xrp").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_ripple = precio;
                vuelta++;
                if (vuelta == 2) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }
        }
        String cad = dato_ripple;
        int desde = 1, hasta = 2;
        String cad_modi = cad.substring(desde, hasta);
        desde = 3;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_actual_ripple = Double.parseDouble(ultimo);
    }

    public void obtener_preciominimo24hs_polcadot() {
        int vuelta = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/polkadot").select("tr");
        for (Element dato : elementos) {
            try {
                dato_minimo24hs_polcadot = dato.select("td").text();
                vuelta++;
                if (vuelta == 7) {
                    break;
                }
            } catch (Exception e) {

            }
        }
        String cad = dato_minimo24hs_polcadot;
        int desde = 1, hasta = 3;
        String cad_modi = cad.substring(desde, hasta);
        desde = 4;
        hasta = 6;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_minimo24_polcadot = Double.parseDouble(ultimo);
    }

    public void obtener_preciominimo24hs_ripple() {
        int vuelta = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/xrp").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_minimo24hs_ripple = precio;
                vuelta++;
                if (vuelta == 7) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }
        }
        String cad = dato_minimo24hs_ripple;
        int desde = 1, hasta = 2;
        String cad_modi = cad.substring(desde, hasta);
        desde = 3;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_minimo24_ripple = Double.parseDouble(ultimo);
    }

    public void mostrar_porcentaje_polkadot() {
        double resultado = ((precio_actual_polcadot * 100) / precio_minimo24_polcadot) - 100;
        if (precio_actual_polcadot > precio_minimo24_polcadot) {
            Principal.pocentaje_dot.setForeground(Color.GREEN);
            Principal.pocentaje_dot.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_dot.setVisible(true);
            Principal.flecha_rojo_dot.setVisible(false);
        } else if (precio_actual_polcadot < precio_minimo24_polcadot) {
            Principal.pocentaje_dot.setForeground(Color.RED);
            Principal.pocentaje_dot.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_dot.setVisible(false);
            Principal.flecha_rojo_dot.setVisible(true);
        }
    }

    public void mostrar_porcentaje_ripple() {
        double resultado = ((precio_actual_ripple * 100) / precio_minimo24_ripple) - 100;
        if (precio_actual_ripple > precio_minimo24_ripple) {
            Principal.xrp_porcentaje.setForeground(Color.GREEN);
            Principal.xrp_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_xrp.setVisible(true);
            Principal.flecha_rojo_xrp.setVisible(false);
        } else if (precio_actual_ripple < precio_minimo24_ripple) {
            Principal.xrp_porcentaje.setForeground(Color.RED);
            Principal.xrp_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_xrp.setVisible(false);
            Principal.flecha_rojo_xrp.setVisible(true);
        }
    }

    public void stop_hilo() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.dot_precio.setForeground(Color.WHITE);
                Principal.precio_minimo_dot.setForeground(Color.WHITE);
                Principal.txt_dotprecio.setVisible(false);
                Principal.txt_preciominimodot.setVisible(false);
                Principal.txt_porcentajedot.setVisible(false);
                mostrar_porcentaje_polkadot();
            }
        };
        timer.schedule(tk, 10000);
    }

    public void stop_hilo_xrp() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.xrp_precio_actual.setForeground(Color.WHITE);
                Principal.precio_minimo_xrp.setForeground(Color.WHITE);
                Principal.txt_xrp_precio_actual.setVisible(false);
                Principal.txt_preciominimo_xrp.setVisible(false);
                Principal.txt_xrp_porcentaje.setVisible(false);
                mostrar_porcentaje_ripple();
            }
        };
        timer.schedule(tk, 10000);
    }

    public void start_verde_precioactual_polcadot() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.dot_precio.setForeground(Color.GREEN);
                Principal.txt_dotprecio.setBackground(new Color(153, 255, 153));
                Principal.txt_dotprecio.setVisible(true);
                Principal.pocentaje_dot.setForeground(Color.GREEN);
                Principal.txt_porcentajedot.setBackground(new Color(153, 255, 153));
                Principal.txt_porcentajedot.setVisible(true);
                Principal.flecha_verde_dot.setVisible(true);
                Principal.flecha_rojo_dot.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo();
    }

    public void start_verde_precioactual_xrp() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.xrp_precio_actual.setForeground(Color.GREEN);
                Principal.txt_xrp_precio_actual.setBackground(new Color(153, 255, 153));
                Principal.txt_xrp_precio_actual.setVisible(true);
                Principal.xrp_porcentaje.setForeground(Color.GREEN);
                Principal.txt_xrp_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_xrp_porcentaje.setVisible(true);
                Principal.flecha_verde_xrp.setVisible(true);
                Principal.flecha_rojo_xrp.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_xrp();
    }

    public void start_rojo_precioactual_polcadot() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.dot_precio.setForeground(Color.red);
                Principal.txt_dotprecio.setBackground(new Color(255, 102, 102));
                Principal.txt_dotprecio.setVisible(true);
                Principal.pocentaje_dot.setForeground(Color.red);
                Principal.txt_porcentajedot.setBackground(new Color(255, 102, 102));
                Principal.txt_porcentajedot.setVisible(true);
                Principal.flecha_verde_dot.setVisible(false);
                Principal.flecha_rojo_dot.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo();
    }

    public void start_rojo_precioactual_xrp() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new java.util.TimerTask() {
            @Override
            public void run() {
                Principal.xrp_precio_actual.setForeground(Color.red);
                Principal.txt_xrp_precio_actual.setBackground(new Color(255, 102, 102));
                Principal.txt_xrp_precio_actual.setVisible(true);
                Principal.xrp_porcentaje.setForeground(Color.red);
                Principal.txt_xrp_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_xrp_porcentaje.setVisible(true);
                Principal.flecha_verde_xrp.setVisible(false);
                Principal.flecha_rojo_xrp.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_xrp();
    }

    public void start_verde_preciominimo24_polcadot() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.precio_minimo_dot.setForeground(Color.GREEN);
                Principal.txt_preciominimodot.setBackground(new Color(153, 255, 153));
                Principal.txt_preciominimodot.setVisible(true);
                Principal.pocentaje_dot.setForeground(Color.GREEN);
                Principal.txt_porcentajedot.setBackground(new Color(153, 255, 153));
                Principal.txt_porcentajedot.setVisible(true);
                Principal.flecha_verde_dot.setVisible(true);
                Principal.flecha_rojo_dot.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo();
    }

    public void start_verde_preciominimo24_xrp() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.precio_minimo_xrp.setForeground(Color.GREEN);
                Principal.txt_preciominimo_xrp.setBackground(new Color(153, 255, 153));
                Principal.txt_preciominimo_xrp.setVisible(true);
                Principal.xrp_porcentaje.setForeground(Color.GREEN);
                Principal.txt_xrp_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_xrp_porcentaje.setVisible(true);
                Principal.flecha_verde_xrp.setVisible(true);
                Principal.flecha_rojo_xrp.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_xrp();
    }

    public void start_rojo_preciominimo24_polcadot() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.precio_minimo_dot.setForeground(Color.RED);
                Principal.txt_preciominimodot.setBackground(new Color(255, 102, 102));
                Principal.txt_preciominimodot.setVisible(true);
                Principal.pocentaje_dot.setForeground(Color.RED);
                Principal.txt_porcentajedot.setBackground(new Color(255, 102, 102));
                Principal.txt_porcentajedot.setVisible(true);
                Principal.flecha_verde_dot.setVisible(false);
                Principal.flecha_rojo_dot.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo();
    }

    public void start_rojo_preciominimo24_xrp() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.precio_minimo_xrp.setForeground(Color.RED);
                Principal.txt_preciominimo_xrp.setBackground(new Color(255, 102, 102));
                Principal.txt_preciominimo_xrp.setVisible(true);
                Principal.xrp_porcentaje.setForeground(Color.RED);
                Principal.txt_xrp_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_xrp_porcentaje.setVisible(true);
                Principal.flecha_verde_xrp.setVisible(false);
                Principal.flecha_rojo_xrp.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_xrp();
    }

    public void hilo() {
        bandera = precio_actual_polcadot;
        bandera_xrp = precio_actual_ripple;
        javax.swing.Timer hilo = new javax.swing.Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Timer timer = new java.util.Timer();
                TimerTask tk = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_precioactual_polcadot();
                        Principal.dot_precio.setText("$ " + String.valueOf(precio_actual_polcadot));
                        Principal.text +="\n" + "dot : " + String.valueOf(precio_actual_polcadot);
                        Principal.jTextArea1.setText(Principal.text);
                        if (precio_actual_polcadot > bandera) {
                            start_verde_precioactual_polcadot();
                            bandera = precio_actual_polcadot;
                        } else if (precio_actual_polcadot < bandera) {
                            start_rojo_precioactual_polcadot();
                            bandera = precio_actual_polcadot;
                        }
                    }
                };
                timer.schedule(tk, 0);
                java.util.Timer timer2 = new java.util.Timer();
                TimerTask tk2 = new java.util.TimerTask() {
                    @Override
                    public void run() {
                        obtener_precioactual_ripple();
                        Principal.xrp_precio_actual.setText("$ " + String.valueOf(precio_actual_ripple));
                        Principal.text +="\n" + "xrp : " + String.valueOf(precio_actual_ripple);
                        Principal.jTextArea1.setText(Principal.text);
                        if (precio_actual_ripple > bandera_xrp) {
                            start_verde_precioactual_xrp();
                            bandera_xrp = precio_actual_ripple;
                        } else if (precio_actual_ripple < bandera_xrp) {
                            start_rojo_precioactual_xrp();
                            bandera_xrp = precio_actual_ripple;
                        } 
                    }
                };
                timer2.schedule(tk2, 20000);
            }            
        });
        hilo.start();
    }

    public void hilo2() {
        bandera2 = precio_minimo24_polcadot;
        bandera2_xrp = precio_minimo24_ripple;
        javax.swing.Timer hilo = new javax.swing.Timer(130000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Timer timer = new java.util.Timer();
                TimerTask tk = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_preciominimo24hs_polcadot();
                        Principal.precio_minimo_dot.setText("$ " + String.valueOf(precio_minimo24_polcadot));
                        if (precio_minimo24_polcadot > bandera2) {
                            start_verde_preciominimo24_polcadot();
                            System.out.println(bandera2);
                            bandera2 = precio_minimo24_polcadot;
                        } else if (precio_minimo24_polcadot < bandera2) {
                            start_rojo_preciominimo24_polcadot();
                            System.out.println(bandera2);
                            bandera2 = precio_minimo24_polcadot;
                        } 
                    }
                };
                timer.schedule(tk, 10000);
                java.util.Timer timer2 = new java.util.Timer();
                TimerTask tk2 = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_preciominimo24hs_ripple();
                        Principal.precio_minimo_xrp.setText("$ " + String.valueOf(precio_minimo24_ripple));
                        if (precio_minimo24_ripple > bandera2_xrp) {
                            start_verde_preciominimo24_xrp();
                            System.out.println(bandera2_xrp);
                            bandera2_xrp = precio_minimo24_ripple;
                        } else if (precio_minimo24_ripple < bandera2_xrp) {
                            start_rojo_preciominimo24_xrp();
                            System.out.println(bandera2_xrp);
                            bandera2_xrp = precio_minimo24_ripple;
                        } 
                    }
                };
                timer2.schedule(tk2, 30000);
            }
        });
        hilo.start();
    }

    public String dato_polcadot;
    public String dato_ripple;
    public String dato_minimo24hs_polcadot;
    public String dato_minimo24hs_ripple;
    double bandera;
    double bandera_xrp;
    double bandera2;
    double bandera2_xrp;
}
