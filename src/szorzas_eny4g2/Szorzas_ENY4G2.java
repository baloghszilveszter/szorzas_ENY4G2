/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package szorzas_eny4g2;

/**
 *
 * @author szili
 */
public class Szorzas_ENY4G2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static int multiplyNaturals(int First, int Second) {
        if (First >= 0 && Second >= 0) {
            return First * Second;
        } else {
            return -1;
        }
    }
}
