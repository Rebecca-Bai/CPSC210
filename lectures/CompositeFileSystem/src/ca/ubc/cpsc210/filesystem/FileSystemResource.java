package ca.ubc.cpsc210.filesystem;


public abstract class FileSystemResource {
	
	protected String name;
	
	public String getName() {
		return name;
	}
	
	public abstract void print();

	protected void indent(int x){
		for(int i=0;i<x;i++){
			System.out.print(' ');
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FileSystemResource that = (FileSystemResource) o;

		return name.equals(that.name);

	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}


	public abstract void print(String prefix);
}
