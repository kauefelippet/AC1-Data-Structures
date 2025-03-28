/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author bruno
 */
public class NoSimples {
    Chamado valor;
    NoSimples prox;
    public NoSimples(Chamado ValorNo){
        valor = ValorNo;
        prox = null;
    }

    public Chamado getValor(){
        return valor;
    }
 }

