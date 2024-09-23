/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MOB1023_ASM;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author THANHDAT
 */
public class clockThread implements Runnable{
    JLabel clockLabel;

    public clockThread(JLabel clockLabel) {
        this.clockLabel = clockLabel;
    }
    
    @Override
    public void run() {
        while(true)
        {
            try {
                Date now = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss aa");
                clockLabel.setText(dateFormat.format(now));
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        }
    }
    
}
