package org.sid.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Resultat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    private Long id;
    private int g;
    private int a;
    private int p;
    private int l;
    private int x;
    private int c;
    private int v;
    private int d;
    private int w;
    private int n;
    private int r;
    private int z;
    private int b;
    private int s;
    private int o;
    private int i;
    private int t;
    private int k;
    private int e;


    private int f;

    @Transient
    private int datetime;


    public int getDatetime() {
        return datetime;
    }
    public void setDatetime(int datetime) {
        this.datetime = datetime;
    }
    @OneToOne(cascade = CascadeType.REMOVE)

    @JoinColumn(foreignKey = @ForeignKey(name = "fk_reponses"), referencedColumnName = "id")
    private Reponses reponses;




    public Reponses getReponses() {
        return reponses;
    }

    public void setReponses(Reponses reponses) {
        this.reponses = reponses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getL() {
        return l;
    }

    public void setL(int l) {
        this.l = l;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getT() {
        return t;
    }

    public void setT(int t) {
        this.t = t;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }




    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public Resultat() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Resultat(int g, int a, int p, int l, int x, int c, int v, int d, int w, int n, int r, int z, int b, int s,
                    int o, int i, int t, int k, int e, int f) {

        this.g = g;
        this.a = a;
        this.p = p;
        this.l = l;
        this.x = x;
        this.c = c;
        this.v = v;
        this.d = d;
        this.w = w;
        this.n = n;
        this.r = r;
        this.z = z;
        this.b = b;
        this.s = s;
        this.o = o;
        this.i = i;
        this.t = t;
        this.k = k;
        this.e = e;


        this.f = f;
    }

}
