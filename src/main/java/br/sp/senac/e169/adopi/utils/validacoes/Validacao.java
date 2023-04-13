/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.sp.senac.e169.adopi.utils.validacoes;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Validacao {
    public static ArrayList<String> listaMensagensErro = new ArrayList<>();
    
    public static ArrayList<String> getMensagensErro() {
        return listaMensagensErro;
    }
    
    public static void ValidarCamposTexto(String txt) {
        try {
            if (txt.trim().equals("") ){
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            listaMensagensErro.add("Campo " + txt + " vazio");
        }
    }
}
