/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smallbyites.examenpractico;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Caetano Flores
 */
public class MirrorImageConcurrent {
    public static void main(String[] args) throws IOException, InterruptedException {
        File inputFile = new File("19.jpg");
        BufferedImage image = ImageIO.read(inputFile);
        int height = image.getHeight();
        long startTime = System.nanoTime();
        int cantidadHilos = 100;
        int heightForThread = height/cantidadHilos;
        int finFila;
        ArrayList<Thread> hilos = new ArrayList<>();
        for (int i = 0; i < cantidadHilos; i++) {
            int inicioFila = i * heightForThread;

            if(i == cantidadHilos - 1){
                finFila = height;
            }else{
                finFila = inicioFila + heightForThread;
            }

            Thread hilo = new Thread(new InvertirImg(image, inicioFila, finFila));
            hilo.start();
            hilos.add(hilo);
        }
        for (Thread hilo : hilos){
            hilo.join();
        }
        long endTime = System.nanoTime();
        
        File outputFile = new File("imagen_espejada_secuencial.jpg");
        ImageIO.write(image, "jpg", outputFile);
        System.out.println("Proceso secuencial completado en " + (endTime - startTime) + "ns");
    }
}
