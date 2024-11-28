import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InterfazGrafica {

    public static void main(String[] args) {
        // Crear el marco principal
        JFrame frame = new JFrame("Alquila Car");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Crear el panel del menú superior
        JPanel topMenuPanel = new JPanel();
        topMenuPanel.setBackground(new Color(90, 90, 90));
        topMenuPanel.setLayout(new GridLayout(1, 3));

        JPanel contentPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);
  
        // MENSAJE DE "SELECCIONE UN VEHICULO PARA ALQUILAR"
        JLabel seleccionMensaje = new JLabel("Seleccione un vehículo para alquilar");
        seleccionMensaje.setFont(new Font("Arial", Font.PLAIN, 14));
        seleccionMensaje.setHorizontalAlignment(SwingConstants.CENTER);
        seleccionMensaje.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

        // Crear los diferentes paneles
        JPanel inicioPanel = new JPanel();
        inicioPanel.setBackground(new Color(30, 30, 30));
        inicioPanel.setLayout(new BorderLayout());

        JLabel bienvenidaLabel = new JLabel("BIENVENIDO A ALQUILA CAR'S");
        bienvenidaLabel.setFont(new Font("Arial", Font.BOLD, 35));
        bienvenidaLabel.setForeground(Color.WHITE);
        bienvenidaLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JButton alquilarAutoButton = new JButton("Alquilar Auto");
        alquilarAutoButton.setFont(new Font("Arial", Font.PLAIN, 16));
        alquilarAutoButton.setBackground(new Color(20, 90, 120));
        alquilarAutoButton.setForeground(Color.WHITE);
        alquilarAutoButton.setFocusPainted(false);
        alquilarAutoButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        // Cambiar al panel "AUTOS DISPONIBLES"
        alquilarAutoButton.addActionListener(e -> cardLayout.show(contentPanel, "AUTOS DISPONIBLES"));
        

        inicioPanel.add(bienvenidaLabel, BorderLayout.CENTER);
        inicioPanel.add(alquilarAutoButton, BorderLayout.SOUTH);

        //boton seleccione un vehiculo
        JPanel autosDisponiblesPanel = new JPanel();
        autosDisponiblesPanel.setBackground(new Color(200, 230, 255));
        autosDisponiblesPanel.setLayout(new BorderLayout());

        JPanel historialAlquilerPanel = new JPanel();
        historialAlquilerPanel.setLayout(new BorderLayout());

        // Añadir los paneles al contentPanel con identificadores
        contentPanel.add(inicioPanel, "INICIO");
        contentPanel.add(autosDisponiblesPanel, "AUTOS DISPONIBLES");
        contentPanel.add(historialAlquilerPanel, "HISTORIAL ALQUILER");

        // JLABEL de seleccione un vehiculo para alquilar
        autosDisponiblesPanel.add(seleccionMensaje, BorderLayout.SOUTH);

        // Agregar los paneles al marco principal
        frame.add(topMenuPanel, BorderLayout.NORTH);
        frame.add(contentPanel, BorderLayout.CENTER);

        // Botones del menú
        String[] menuOptions = { "INICIO", "AUTOS DISPONIBLES", "HISTORIAL ALQUILER" };
        for (String option : menuOptions) {
            JButton button = new JButton(option);
            button.setForeground(Color.WHITE);
            button.setBackground(new Color(20, 90, 120));
            button.setFocusPainted(false);
            button.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
            button.setFont(new Font("Arial", Font.BOLD, 14));

            

            // Cambiar de panel
            button.addActionListener(e -> cardLayout.show(contentPanel, option));

            topMenuPanel.add(button);
        }

         
        // Crear modelo de tabla no editable
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Agregar columnas al modelo
        modelo.addColumn("ID Vehículo");
        modelo.addColumn("ID Tipo Vehículo");
        modelo.addColumn("Marca");
        modelo.addColumn("Modelo");
        modelo.addColumn("Año Fabricación");
        modelo.addColumn("Patente");
        modelo.addColumn("Color");
        modelo.addColumn("Transmisión");
        modelo.addColumn("Plazas");
        modelo.addColumn("Capacidad Baúl");
        modelo.addColumn("PMA");

        

        JTable tabla = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabla);

        iCotizador_VehiculoDAO cotizadorDAO = new CotizadorDAO();
        cotizadorDAO.cargarDatosTabla(modelo);
        autosDisponiblesPanel.add(scrollPane, BorderLayout.CENTER);

        DefaultTableModel modelo2 = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo2.addColumn("ID Cotizacion");
        modelo2.addColumn("ID Vehículo");
        modelo2.addColumn("Cantidad Dias");
        modelo2.addColumn("precio_Cotizacion");
        modelo2.addColumn("Fecha Creacion");

        JTable tabla2 = new JTable(modelo2);
        JScrollPane scrollPane2 = new JScrollPane(tabla2);

        iCotizador_VehiculoDAO cotizadorDAO2 = new CotizadorDAO();
        cotizadorDAO2.cargarDatosTablaCotizacion(modelo2);
        historialAlquilerPanel.add(scrollPane2, BorderLayout.CENTER);

        // Creamos la instancia para manejar las cotizaciones
        iCotizador_CotizacionDao cotizacionDAO = new CotizacionDAO();

        // Detecta el doble click sobre la tabla para tomarlo como el auto a alquilar
        tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2 && tabla.getSelectedRow() != -1) {
                    int selectedRow = tabla.getSelectedRow();

                    System.out.println("Fila seleccionada: " + selectedRow);
                    System.out.println("ID Vehículo: " + modelo.getValueAt(selectedRow, 0).toString());

                    int idVehiculo;
                    int idtipo_Vehiculo = Integer.parseInt(modelo.getValueAt(selectedRow, 1).toString());
                    int cantidadPlazas;
                    float pma;

                    try {
                        cantidadPlazas = (int) Double.parseDouble(modelo.getValueAt(selectedRow, 8).toString());
                        pma = Float.parseFloat(modelo.getValueAt(selectedRow, 10).toString());
                        idVehiculo = Integer.parseInt(modelo.getValueAt(selectedRow, 0).toString());

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frame,
                                "Error al leer los datos del vehículo. Verifique la tabla.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (idVehiculo == 0) {
                        JOptionPane.showMessageDialog(frame, "El vehículo seleccionado no es válido.", "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Alquiler alquiler = new Alquiler();
                    alquiler.setCantidad_Dias(1); //dias por defecto

                    JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
                    JLabel diasLabel = new JLabel("Cantidad de días");
                    JTextField diasField = new JTextField(String.valueOf(alquiler.getCantidad_Dias()));

                    panel.add(diasLabel);
                    panel.add(diasField);

                    int result = JOptionPane.showConfirmDialog(
                            frame,
                            panel,
                            "Alquilar vehículo (ID tipo: " + idtipo_Vehiculo + ")",
                            JOptionPane.OK_CANCEL_OPTION,
                            JOptionPane.PLAIN_MESSAGE);

                    if (result == JOptionPane.OK_OPTION) {
                        try {
                            int dias = Integer.parseInt(diasField.getText());
                            if (dias <= 0) {
                                JOptionPane.showMessageDialog(frame, "Ingrese un valor mayor a 0.", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {
                                alquiler.setCantidad_Dias(dias);

                                Vehiculo vehiculo = new Vehiculo();
                                vehiculo.setidVehiculo(idVehiculo);
                                vehiculo.setCantidad_Plazas(cantidadPlazas);
                                vehiculo.setPMA(pma);

                                cotizacionDAO.Calcular_Precio_Alquiler(idtipo_Vehiculo, alquiler, vehiculo);
                                double precioCotizacion = alquiler.getPrecioAlquiler();

                                JOptionPane.showMessageDialog(
                                        frame,
                                        "Vehículo alquilado por " + alquiler.getCantidad_Dias() + " días.\n" +
                                                "Total a pagar: $" + precioCotizacion,
                                        "Confirmación de Alquiler",
                                        JOptionPane.INFORMATION_MESSAGE);

                                cotizadorDAO.Insertar_Cotizacion(idVehiculo, idtipo_Vehiculo, alquiler, vehiculo);
                                modelo2.setRowCount(0);
                                cotizadorDAO2.cargarDatosTablaCotizacion(modelo2);
                                tabla2.setModel(modelo2);
                            }

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(frame, "Ingrese un valor numérico válido.", "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            }
        });

        frame.setVisible(true);
    }
}
