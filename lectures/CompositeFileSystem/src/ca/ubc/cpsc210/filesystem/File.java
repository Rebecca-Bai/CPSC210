package ca.ubc.cpsc210.filesystem;

public class File extends FileSystemResource{


    public File(String name){
            this.name=name;
    }

    @Override
    public void print() {
        System.out.println(this.getClass().toString()+":"+name);
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix+this.getClass() + ":" + name);
    }


}
