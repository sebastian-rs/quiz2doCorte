/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vo;

/**
 *
 * @author JCBOT
 */
public class Contexto {

    private int IdContexto;
    private String NameContexto;
    private int Desicion;

    public Contexto(int IdContexto, String NameContexto) {
        this.IdContexto = IdContexto;
        this.NameContexto = NameContexto;
       
    }

    public Contexto() {
    }

    public int getIdContexto() {
        return IdContexto;
    }

    public void setIdContexto(int IdContexto) {
        this.IdContexto = IdContexto;
    }

    public String getNameContexto() {
        return NameContexto;
    }

    public void setNameContexto(String NameContexto) {
        this.NameContexto = NameContexto;
    }

    public int getDesicion() {
        return Desicion;
    }

    public void setDesicion(int Desicion) {
        this.Desicion = Desicion;
    }


    
    

    }


