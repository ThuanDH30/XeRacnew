/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;

/**
 *
 * @author Bravo
 */
public class WordFoundLister extends FileLister{
    private String word;

    public WordFoundLister(String word, File parent) {
        super(parent);
        this.word = word;
    }
        
    @Override
    public boolean isFoundFile(File file) {
        FileFinder finder = new FileFinder(file);
        
        return finder.contain(this.word);
    }
}
