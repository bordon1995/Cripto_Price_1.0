package Principal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JOptionPane;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ada_Link {

    public static double precio_actual_ada;
    public static double precio_minimo24_ada;
    public static double precio_actual_link;
    public static double precio_minimo24_link;

    public void mostrar_valores() {
        obtener_precioactual_ada();
        obtener_precioactual_link();
        obtener_preciominimo24hs_ada();
        obtener_preciominimo24hs_link();
        mostrar_porcentaje_ada();
        mostrar_porcentaje_link();
        Principal.ada_precioactual.setText("$ " + String.valueOf(precio_actual_ada));
        Principal.ada_preciominimo.setText("$ " + String.valueOf(precio_minimo24_ada));
        Principal.link_precioactual.setText("$ " + String.valueOf(precio_actual_link));
        Principal.link_preciominimo.setText("$ " + String.valueOf(precio_minimo24_link));
        hilo();
        hilo2();
    }

    public void obtener_precioactual_ada() {
        int bandera = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/cardano").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_ada = precio;
                bandera++;
                if (bandera == 2) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }
        }
        String cad = dato_ada;
        int desde = 1, hasta = 2;
        String cad_modi = cad.substring(desde, hasta);
        desde = 3;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_actual_ada = Double.parseDouble(ultimo);
    }

    public void obtener_precioactual_link() {
        int bandera = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/chainlink").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_link = precio;
                bandera++;
                if (bandera == 2) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }

        }
        String cad = dato_link;
        int desde = 1, hasta = 3;
        String cad_modi = cad.substring(desde, hasta);
        desde = 4;
        hasta = 6;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_actual_link = Double.parseDouble(ultimo);
    }

    public void obtener_preciominimo24hs_ada() {
        int bandera = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/cardano").select("tr");
        for (Element dato : elementos) {
            try {
                String precio = dato.select("td").text();
                dato_minimo24hs_ada = precio;
                bandera++;
                if (bandera == 7) {
                    break;
                }

            } catch (Exception j) {
                JOptionPane.showMessageDialog(null, "Error de conexion , verifica tu conexion a internet");
            }
        }
        String cad = dato_minimo24hs_ada;
        int desde = 1, hasta = 2;
        String cad_modi = cad.substring(desde, hasta);
        desde = 3;
        hasta = 7;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_minimo24_ada = Double.parseDouble(ultimo);
    }

    public void obtener_preciominimo24hs_link() {
        int bandera = 1;
        Elements elementos = Principal.getHTML("https://www.coingecko.com/es/monedas/chainlink").select("tr");
        for (Element dato : elementos) {
            try {
                dato_minimo24hs_link = dato.select("td").text();
                bandera++;
                if (bandera == 7) {
                    break;
                }
            } catch (Exception e) {

            }
        }
        String cad = dato_minimo24hs_link;
        int desde = 1, hasta = 3;
        String cad_modi = cad.substring(desde, hasta);
        desde = 4;
        hasta = 6;
        String cad_modi2 = cad.substring(desde, hasta);
        String ultimo = cad_modi + "." + cad_modi2;
        precio_minimo24_link = Double.parseDouble(ultimo);
    }

    public void mostrar_porcentaje_ada() {
        double resultado = ((precio_actual_ada * 100) / precio_minimo24_ada) - 100;
        if (precio_actual_ada > precio_minimo24_ada) {
            Principal.ada_porcentaje.setForeground(Color.GREEN);
            Principal.ada_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_ada.setVisible(true);
            Principal.flecha_rojo_ada.setVisible(false);
        } else if (precio_actual_ada < precio_minimo24_ada) {
            Principal.ada_porcentaje.setForeground(Color.RED);
            Principal.ada_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_ada.setVisible(false);
            Principal.flecha_rojo_ada.setVisible(true);
        }
    }

    public void mostrar_porcentaje_link() {
        double resultado = ((precio_actual_link * 100) / precio_minimo24_link) - 100;
        if (precio_actual_link > precio_minimo24_link) {
            Principal.link_porcentaje.setForeground(Color.GREEN);
            Principal.link_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_link.setVisible(true);
            Principal.flecha_rojo_link.setVisible(false);
        } else if (precio_actual_link < precio_minimo24_link) {
            Principal.link_porcentaje.setForeground(Color.RED);
            Principal.link_porcentaje.setText(String.format("%.2f", resultado) + "%");
            Principal.flecha_verde_link.setVisible(false);
            Principal.flecha_rojo_link.setVisible(true);
        }
    }

    public void stop_hilo_ada() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.ada_precioactual.setForeground(Color.WHITE);
                Principal.ada_preciominimo.setForeground(Color.WHITE);
                Principal.txt_ada_precioactual.setVisible(false);
                Principal.txt_ada_preciominimo.setVisible(false);
                Principal.txt_ada_porcentaje.setVisible(false);
                mostrar_porcentaje_ada();
            }
        };
        timer.schedule(tk, 10000);
    }

    public void stop_hilo_link() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.link_precioactual.setForeground(Color.WHITE);
                Principal.link_preciominimo.setForeground(Color.WHITE);
                Principal.txt_link_precioactual.setVisible(false);
                Principal.txt_link_preciominimo.setVisible(false);
                Principal.txt_link_porcentaje.setVisible(false);
                mostrar_porcentaje_link();
            }
        };
        timer.schedule(tk, 10000);
    }

    public void start_verde_precioactual_ada() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.ada_precioactual.setForeground(Color.GREEN);
                Principal.txt_ada_precioactual.setBackground(new Color(153, 255, 153));
                Principal.txt_ada_precioactual.setVisible(true);
                Principal.ada_porcentaje.setForeground(Color.GREEN);
                Principal.txt_ada_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_ada_porcentaje.setVisible(true);
                Principal.flecha_verde_ada.setVisible(true);
                Principal.flecha_rojo_ada.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_ada();
    }

    public void start_verde_precioactual_link() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.link_precioactual.setForeground(Color.GREEN);
                Principal.txt_link_precioactual.setBackground(new Color(153, 255, 153));
                Principal.txt_link_precioactual.setVisible(true);
                Principal.link_porcentaje.setForeground(Color.GREEN);
                Principal.txt_link_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_link_porcentaje.setVisible(true);
                Principal.flecha_verde_link.setVisible(true);
                Principal.flecha_rojo_link.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_link();
    }

    public void start_rojo_precioactual_ada() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new java.util.TimerTask() {
            @Override
            public void run() {
                Principal.ada_precioactual.setForeground(Color.red);
                Principal.txt_ada_precioactual.setBackground(new Color(255, 102, 102));
                Principal.txt_ada_precioactual.setVisible(true);
                Principal.ada_porcentaje.setForeground(Color.red);
                Principal.txt_ada_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_ada_porcentaje.setVisible(true);
                Principal.flecha_verde_ada.setVisible(false);
                Principal.flecha_rojo_ada.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_ada();
    }

    public void start_rojo_precioactual_link() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.link_precioactual.setForeground(Color.red);
                Principal.txt_link_precioactual.setBackground(new Color(255, 102, 102));
                Principal.txt_link_precioactual.setVisible(true);
                Principal.link_porcentaje.setForeground(Color.red);
                Principal.txt_link_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_link_porcentaje.setVisible(true);
                Principal.flecha_verde_link.setVisible(false);
                Principal.flecha_rojo_link.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_link();
    }

    public void start_verde_preciominimo24_ada() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.ada_preciominimo.setForeground(Color.GREEN);
                Principal.txt_ada_preciominimo.setBackground(new Color(153, 255, 153));
                Principal.txt_ada_preciominimo.setVisible(true);
                Principal.ada_porcentaje.setForeground(Color.GREEN);
                Principal.txt_ada_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_ada_porcentaje.setVisible(true);
                Principal.flecha_verde_ada.setVisible(true);
                Principal.flecha_rojo_ada.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_ada();
    }

    public void start_verde_preciominimo24_link() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.link_preciominimo.setForeground(Color.GREEN);
                Principal.txt_link_preciominimo.setBackground(new Color(153, 255, 153));
                Principal.txt_link_preciominimo.setVisible(true);
                Principal.link_porcentaje.setForeground(Color.GREEN);
                Principal.txt_link_porcentaje.setBackground(new Color(153, 255, 153));
                Principal.txt_link_porcentaje.setVisible(true);
                Principal.flecha_verde_link.setVisible(true);
                Principal.flecha_rojo_link.setVisible(false);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_link();
    }

    public void start_rojo_preciominimo24_ada() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.ada_preciominimo.setForeground(Color.RED);
                Principal.txt_ada_preciominimo.setBackground(new Color(255, 102, 102));
                Principal.txt_ada_preciominimo.setVisible(true);
                Principal.ada_porcentaje.setForeground(Color.RED);
                Principal.txt_ada_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_ada_porcentaje.setVisible(true);
                Principal.flecha_verde_ada.setVisible(false);
                Principal.flecha_rojo_ada.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_ada();
    }

    public void start_rojo_preciominimo24_link() {
        java.util.Timer timer = new java.util.Timer();
        TimerTask tk = new TimerTask() {
            @Override
            public void run() {
                Principal.link_preciominimo.setForeground(Color.RED);
                Principal.txt_link_preciominimo.setBackground(new Color(255, 102, 102));
                Principal.txt_link_preciominimo.setVisible(true);
                Principal.link_porcentaje.setForeground(Color.RED);
                Principal.txt_link_porcentaje.setBackground(new Color(255, 102, 102));
                Principal.txt_link_porcentaje.setVisible(true);
                Principal.flecha_verde_link.setVisible(false);
                Principal.flecha_rojo_link.setVisible(true);
            }
        };
        timer.schedule(tk, 0);
        stop_hilo_link();
    }

    public void hilo() {
        bandera_ada = precio_actual_ada;
        bandera_link = precio_actual_link;
        javax.swing.Timer hilo = new javax.swing.Timer(60000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Timer timer = new java.util.Timer();
                TimerTask tk = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_precioactual_ada();
                        Principal.ada_precioactual.setText("$ " + String.valueOf(precio_actual_ada));
                        Principal.text += "\n" + "ada : " + String.valueOf(precio_actual_ada);
                        Principal.jTextArea1.setText(Principal.text);
                        if (precio_actual_ada > bandera_ada) {
                            start_verde_precioactual_ada();
                            bandera_ada = precio_actual_ada;
                        } else if (precio_actual_ada < bandera_ada) {
                            start_rojo_precioactual_ada();
                            bandera_ada = precio_actual_ada;
                        } 
                    }
                };
                timer.schedule(tk, 30000);
                java.util.Timer timer2 = new java.util.Timer();
                TimerTask tk2 = new java.util.TimerTask() {
                    @Override
                    public void run() {
                        obtener_precioactual_link();
                        Principal.link_precioactual.setText("$ " + String.valueOf(precio_actual_link));
                        Principal.text += "\n" + "link : " + String.valueOf(precio_actual_link);
                        Principal.jTextArea1.setText(Principal.text);
                        if (precio_actual_link > bandera_link) {
                            start_verde_precioactual_link();
                            bandera_link = precio_actual_link;
                        } else if (precio_actual_link < bandera_link) {
                            start_rojo_precioactual_link();
                            bandera_link = precio_actual_link;
                        }
                    }
                };
                timer2.schedule(tk2, 40000);
            }
        });
        hilo.start();
    }

    public void hilo2() {
        bandera2_ada = precio_minimo24_ada;
        bandera2_link = precio_minimo24_link;
        javax.swing.Timer hilo = new javax.swing.Timer(70000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                java.util.Timer timer = new java.util.Timer();
                TimerTask tk = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_preciominimo24hs_ada();
                        Principal.ada_preciominimo.setText("$ " + String.valueOf(precio_minimo24_ada));
                        if (precio_minimo24_ada > bandera2_ada) {
                            start_verde_preciominimo24_ada();
                            System.out.println(bandera2_ada);
                            bandera2_ada = precio_minimo24_ada;
                        } else if (precio_minimo24_ada < bandera2_ada) {
                            start_rojo_preciominimo24_ada();
                            System.out.println(bandera2_ada);
                            bandera2_ada = precio_minimo24_ada;
                        } 
                    }
                };
                timer.schedule(tk, 0);
                java.util.Timer timer2 = new java.util.Timer();
                TimerTask tk2 = new TimerTask() {
                    @Override
                    public void run() {
                        obtener_preciominimo24hs_link();
                        Principal.link_preciominimo.setText("$ " + String.valueOf(precio_minimo24_link));
                        if (precio_minimo24_link > bandera2_link) {
                            start_verde_preciominimo24_link();
                            System.out.println(bandera2_link);
                            bandera2_link = precio_minimo24_link;
                        } else if (precio_minimo24_link < bandera2_link) {
                            start_rojo_preciominimo24_link();
                            System.out.println(bandera2_link);
                            bandera2_link = precio_minimo24_link;
                        } 
                    }
                };
                timer2.schedule(tk2, 20000);
            }
        });
        hilo.start();

    }

    public String dato_ada;
    public String dato_link;
    public String dato_minimo24hs_ada;
    public String dato_minimo24hs_link;
    double bandera_ada;
    double bandera_link;
    double bandera2_ada;
    double bandera2_link;
}
