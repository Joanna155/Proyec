/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package carreraatletica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**

 * 
 * @author joann
 */
public class CarreraAtletica extends JFrame {
    
    // Components
    JLabel lblRegister = new JLabel("Registra Corredor:");
    JTextField txtFieldName = new JTextField("");
    JButton btnRegister = new JButton("Registro");
    JLabel lblRacers = new JLabel("Corredores Registrados:");
    JTextArea txtAreaRacers = new JTextArea();
    JLabel lblResult = new JLabel("Resultados:");
    JTextArea txtAreaResult = new JTextArea();
    JButton btnStart = new JButton("Iniciar");
    JButton btnRestart = new JButton("Reiniciar");
    JButton btnFinish = new JButton("Terminar");

    // Corredores
    Runner[] participants = new Runner[5];
    int runnersCount = 0;


    public CarreraAtletica () {
        setTitle("Carrera Atlética");
        setSize(550, 600);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        getContentPane().add(lblRegister);
        getContentPane().add(txtFieldName);
        getContentPane().add(btnRegister);
        getContentPane().add(lblRacers);
        getContentPane().add(txtAreaRacers);
        getContentPane().add(lblResult);
        getContentPane().add(txtAreaResult);
        getContentPane().add(btnStart);
        getContentPane().add(btnRestart);
        getContentPane().add(btnFinish);


        lblRegister.setBounds(10, 10, 380, 30);
        txtFieldName.setBounds(7, 40, 300, 40);
        btnRegister.setBounds(330, 40, 200, 40);
        lblRacers.setBounds(10, 90, 380, 30);
        txtAreaRacers.setBounds(10, 130, 530, 180);
        lblResult.setBounds(10, 330, 420, 30);
        txtAreaResult.setBounds(10, 370, 330, 180);
        btnStart.setBounds(350, 368, 190, 60);
        btnRestart.setBounds(350, 428, 190, 60);
        btnFinish.setBounds(350, 488, 190, 60);

     
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                  
                    participants[runnersCount] = new Runner(txtFieldName.getText());
                    participants[runnersCount].setSpeed();
                    txtFieldName.setText("");

     
                    if(runnersCount < 4){
                        txtAreaRacers.append(runnersCount+1 + " - " + participants[runnersCount].getName() + "\n");
                    } else {
                        txtAreaRacers.append(runnersCount+1 + " - " + participants[runnersCount].getName());
                    }
               
                    runnersCount++;
                } catch (Exception err){
                    JOptionPane.showMessageDialog(null,"No se registran mas Participantes");
                }
            }
        });

        btnRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    for (int i = 0; i < participants.length; i++) {
                        participants[i].setName(null);
                    }
                    txtAreaRacers.setText("");
                    txtAreaResult.setText("");
                    runnersCount = 0;
                    JOptionPane.showMessageDialog(null,"Se ha limpiado los registros");
                } catch (Exception err){
                    System.out.println(err);
                }
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread[] = new Thread[participants.length];
                // Instantiate ThreadRunner class
                ThreadRunner runner[] = new ThreadRunner[participants.length];

                try{
                    if(runnersCount == participants.length){

                        for (int i = 0; i < participants.length; i++) {
                            runner[i] = new ThreadRunner(participants[i], txtAreaResult);
                            thread[i] = new Thread(runner[i]);
                            thread[i].start();
                        }
                    }
                } catch (Exception err) {
                    System.out.println(err);
                }
            }
        });

        btnFinish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args) {
        new CarreraAtletica();
    }
    
}

    
        