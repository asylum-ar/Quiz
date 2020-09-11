/*     */ package org.sid.entities;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.time.LocalDateTime;
import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.persistence.*;
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */
/*     */

/*     */
/*     */ @Entity
/*     */ public class Personnel
/*     */   implements Serializable
/*     */ {
/*     */   @Id
/*     */   @GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")

/*     */   private Long id;
    @Column(name = "nom")

/*     */   private String nom;
    @Column(name = "prenom")

/*     */   private String prenom;
    @Column(name = "niveau")

/*     */   private String niveau;
    @Column(name = "specialite")

/*     */   private String specialite;
    @Column(name = "date", columnDefinition = "DATE")

/*     */  // @Temporal(TemporalType.DATE)
/*     */   private LocalDateTime date;
    @Column(name = "experiance")

/*     */   private String experiance;
    @Column(name = "poste")

/*     */   private String poste;
/*     */
/*     */@OneToMany( orphanRemoval = true)
@JoinColumn(name = "commentaire_id")

  private Collection<Commentaire> commentaire = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */
/*  47 */   public Collection<Commentaire> getCommentaire() { return this.commentaire; }
/*     */
/*     */
/*  50 */   public void setCommentaire(Collection<Commentaire> commentaire) { this.commentaire = commentaire; } @OneToMany
/*     */   @JoinColumn(name = "per_id")
/*  52 */   private List<Resultat> resultat = new ArrayList();
/*     */ 
/*     */ 	private String duree;

    /*     */

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    /*     */
/*  57 */   public List<Resultat> getResultat() { return this.resultat; }
/*     */ 
/*     */   
/*  60 */   public void setResultat(List<Resultat> resultat) { this.resultat = resultat; }
/*     */ 
/*     */ 
/*     */   
/*  64 */   public LocalDateTime getDate() { return this.date; }
/*     */ 
/*     */   
/*  67 */   public void setDate(LocalDateTime date) { this.date = date; }
/*     */ 
/*     */   
/*  70 */   public Long getId() { return this.id; }
/*     */ 
/*     */   
/*  73 */   public void setId(Long id) { this.id = id; }
/*     */ 
/*     */   
/*  76 */   public String getNom() { return this.nom; }
/*     */ 
/*     */   
/*  79 */   public void setNom(String nom) { this.nom = nom; }
/*     */ 
/*     */   
/*  82 */   public String getPrenom() { return this.prenom; }
/*     */ 
/*     */   
/*  85 */   public void setPrenom(String prenom) { this.prenom = prenom; }
/*     */ 
/*     */   
/*  88 */   public String getNiveau() { return this.niveau; }
/*     */ 
/*     */   
/*  91 */   public void setNiveau(String niveau) { this.niveau = niveau; }
/*     */ 
/*     */   
/*  94 */   public String getSpecialite() { return this.specialite; }
/*     */ 
/*     */   
/*  97 */   public void setSpecialite(String specialite) { this.specialite = specialite; }
/*     */ 
/*     */   
/* 100 */   public String getExperiance() { return this.experiance; }
/*     */ 
/*     */   
/* 103 */   public void setExperiance(String experiance) { this.experiance = experiance; }
/*     */ 
/*     */   
/* 106 */   public String getPoste() { return this.poste; }
/*     */ 
/*     */   
/* 109 */   public void setPoste(String poste) { this.poste = poste; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Personnel() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Personnel(String nom, String prenom, String niveau, String specialite, String experiance, String poste) {
/* 120 */     this.nom = nom;
/* 121 */     this.prenom = prenom;
/* 122 */     this.niveau = niveau;
/* 123 */     this.specialite = specialite;
/* 124 */     this.experiance = experiance;
/* 125 */     this.poste = poste;
/*     */   }
/*     */ }


/* Location:              C:\Users\hp\Desktop\quiz.war!\WEB-INF\classes\org\sid\entities\Personnel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.0.7
 */