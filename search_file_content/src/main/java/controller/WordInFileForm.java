/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.IOException;
import model.WordFoundLister;

/**
 *
 * @author Bravo
 */
public class WordInFileForm extends Form {
     @Override
    public void setup() {
    
    }

    @Override
    public EXIT_OPTION update() {
        System.out.println("------------------ Count Word ---------------------");
        String path = null;
        while (true) {
            try {
                path = Input.inputString("Enter path: ");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        File file = new File(path);
        
        String word = null;
        while (true) {
            try {
                word = Input.inputString("Enter word: ");
                break;
            } catch (IOException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }
        
        WordFoundLister lister = new WordFoundLister(word, file);
        
        System.out.println("--------------- File Name ----------------");
        
        for (File found : lister.find()) {
            System.out.println(found.getAbsolutePath());
        }
        
        return EXIT_OPTION.LOOP_EXIT;
    }
    
}
