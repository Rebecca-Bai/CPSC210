package ca.ubc.cpsc210.filesystem;

import java.util.ArrayList;
import java.util.List;

public class Folder extends FileSystemResource{

        private List<FileSystemResource> children;

        public Folder(String name){
            this.name=name;
            children=new ArrayList<FileSystemResource>();
        }

    public void print(){
        print("");
    }

    public void print(String prefix) {
        System.out.println(prefix+this.getClass() + ":" + name);
        for (FileSystemResource child:children){
            child.print(prefix+"  ");
        }
    }

    public void addChild(FileSystemResource f){
        if (!children.contains(f)) {
            children.add(f);
        }
    }
}
