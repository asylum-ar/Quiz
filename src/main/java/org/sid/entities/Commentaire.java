/*    */ package org.sid.entities;
/*    */
/*    */ import java.io.Serializable;
import java.util.Date;
/*    */ import javax.persistence.*;
import javax.validation.constraints.NotNull;
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ import org.sid.entities.Commentaire;
/*    */
/*    */ @Entity

/*    */ public class Commentaire implements Serializable {
    /*    */   @Id
    /*    */   @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    /*    */   private Long id;
    /*    */   @Column( name = "nom")
    /*    */   private String nom;

    @Column(name = "date")

    /*    */   private Date date;

    @Column(name = "time")

    /*    */   private String time;
    /*    */
    /* 25 */   public Long getId() { return this.id; }
    /*    */
    /*    */
    /*    */ @Column(name = "utilis")
    private String user;
    /*    */

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    /*    */
    /* 31 */   public String getTime() { return this.time; }
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /* 37 */   public void setTime(String time) { this.time = time; }
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /* 43 */   public Date getDate() { return this.date; }
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /* 49 */   public void setDate(Date date) { this.date = date; }
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */
    /*    */   public Commentaire() {}
    /*    */
    /*    */
    /*    */
    /*    */
    /* 60 */   public Commentaire(String nom) { this.nom = nom; }
    /*    */
    /*    */
    /*    */
    /* 64 */   public String getNom() { return this.nom; }
    /*    */
    /*    */
    /*    */
    /* 68 */   public void setNom(String nom) { this.nom = nom; }
    /*    */ }


/* Location:              C:\Users\hp\Desktop\quiz.war!\WEB-INF\classes\org\sid\entities\Commentaire.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */