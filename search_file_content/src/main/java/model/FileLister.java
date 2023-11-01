/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Bravo
 */
public abstract class FileLister {
     protected final File parent;
    protected ArrayList<File> foundchildren;

    public FileLister(File parent) {
        this.parent = parent;
        this.foundchildren = new ArrayList<>();
    }

    public abstract boolean isFoundFile(File file);

    protected void list(File file) {
        if (!file.exists()) {
            return;

        }
        
        if (file.isFile()) {
            if (this.isFoundFile(file)) {
                this.foundchildren.add(file);
            }

            return;
        }

        File[] children = file.listFiles();
        for (File child : children) {
            list(child);
        }
    }

    public ArrayList<File> find() {
        if (!this.foundchildren.isEmpty()) {
            this.foundchildren = new ArrayList<>();
        }

        list(this.parent);

        return this.foundchildren;
    }
}
