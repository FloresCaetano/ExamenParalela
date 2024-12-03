/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smallbyites.examenpractico;

import java.awt.image.BufferedImage;

/**
 *
 * @author Caetano Flores
 */
public class InvertirImg implements Runnable{
    private final BufferedImage imagen;
    private final int inicioFila;
    private final int finFila;
    
    public InvertirImg(BufferedImage imagen, int inicioFila, int finFila) {
        this.imagen = imagen;
        this.inicioFila = inicioFila;
        this.finFila = finFila;
    }
    
    @Override
    public void run() {
        for(int y = inicioFila; y < finFila; y++){
            for(int x = 0; x<imagen.getWidth() / 2; x++){
                int temp = imagen.getRGB(x, y);
                imagen.setRGB(x, y, imagen.getRGB(imagen.getWidth()-1-x, y));
                imagen.setRGB(imagen.getWidth()-1-x, y, temp);
            } 
        }
    }
}
