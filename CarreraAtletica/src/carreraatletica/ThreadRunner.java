/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carreraatletica;

import javax.swing.JTextArea;

/**
 *
 * @author joann
 */

public class ThreadRunner implements Runnable {

    private Runner participant;
    private JTextArea txtAreaResult;

    // Constructor 
    public ThreadRunner(Runner participant, JTextArea txtAreaResult) {
        this.participant = participant;
        this.txtAreaResult = txtAreaResult;
    }
    
    @Override
    public void run() {
        int time = participant.getSpeed() * 1000;
        try{
            Thread.sleep(time);
            txtAreaResult.append(participant.getName() + " - Tiempo: " + participant.getSpeed() + "\n");
        } catch (Exception e){
            System.out.println(e);
        }
    }


}

    

