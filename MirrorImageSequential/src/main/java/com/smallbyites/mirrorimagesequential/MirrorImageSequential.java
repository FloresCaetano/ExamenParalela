/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.smallbyites.mirrorimagesequential;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Caetano Flores
 */
public class MirrorImageSequential {

    public static void main(String[] args)throws Exception{
        File inputFile = new File("19.jpg");
        BufferedImage image = ImageIO.read(inputFile);
        int width = image.getWidth();
        int height = image.getHeight();
        long startTime = System.nanoTime();
        
        for(int y = 0; y < height; y++){
            for(int x = 0; x<width / 2; x++){
                int temp = image.getRGB(x, y);
                image.setRGB(x, y, image.getRGB(width-1-x, y));
                image.setRGB(width-1-x, y, temp);
            } 
        }
        long endTime = System.nanoTime();
        
        File outputFile = new File("imagen_espejada_secuencial.jpg");
        ImageIO.write(image, "jpg", outputFile);
        System.out.println("Proceso secuencial completado en " + (endTime - startTime) + "ns");
    }
}
