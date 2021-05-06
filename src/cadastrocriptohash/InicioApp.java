/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastrocriptohash;

import cadastrocriptohash.view.Login;
import cadastrocriptohash.view.Navegacao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author victor
 */
public class InicioApp {

    /**
     * @param args the command line arguments
     */
        static  EntityManagerFactory  emf
                 = Persistence.createEntityManagerFactory("CadastroCriptoPU");
        static  EntityManager em = emf.createEntityManager();
    public static void main(String[] args) {
        new Login().setVisible(true);
        
    }    
    
}
