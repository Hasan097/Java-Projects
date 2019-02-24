/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
public class Lab8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab8PU");
        EntityManager em = emf.createEntityManager();
        Customer cus = em.find(Customer.class, 1);
        System.out.println(cus.getName() + " " + cus.getCustomerId());
        
        Query qu = em.createNamedQuery("PurchaseOrder.findByCustomerID");
        List<PurchaseOrder> po = (List<PurchaseOrder>)qu.setParameter("cust", cus).getResultList();
        for(PurchaseOrder p:po)
            System.out.println(p.getProductId().getDescription() + " " + p.getQuantity());
        
        EntityTransaction tr = em.getTransaction();
        tr.begin();
        DiscountCode dc = new DiscountCode();
        dc.setDiscountCode("T");
        dc.setRate(BigDecimal.TEN);
        cus.setDiscountCode(dc);
        em.persist(dc);
        em.flush();
        System.out.println("Saved: " + cus.getDiscountCode() + " ||| New Discount code->" + dc.getDiscountCode());
        em.close();
        emf.close();
    }
    
}
