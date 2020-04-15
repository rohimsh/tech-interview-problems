package tech.interview.problems.java;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WaysToCreateNewObject implements Cloneable, Serializable {

	private static final long serialVersionUID = -5016673887060463500L;
	public static final String CLASS_NAME = "tech.interview.problems.multithreading.WaysToCreateNewObject";

	private long id;
	private String name;
	
	public WaysToCreateNewObject() {
		this.id = System.nanoTime();
		this.name = id + CLASS_NAME;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public void reset() {
		id = System.nanoTime();
		name = id + CLASS_NAME;
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, CloneNotSupportedException, IOException {
		//Using new
		WaysToCreateNewObject newObject1 = new WaysToCreateNewObject();
		
		//Using newInstance Method
		Class waysToCreateNewObjectClass = Class.forName(CLASS_NAME);
		WaysToCreateNewObject newObject2 = (WaysToCreateNewObject) waysToCreateNewObjectClass.newInstance();
		
		//Using Constructor's newInstance methods
		Constructor<WaysToCreateNewObject> waysToCreateNewObjectConstructors = WaysToCreateNewObject.class.getDeclaredConstructor();
		WaysToCreateNewObject newObject3 = (WaysToCreateNewObject) waysToCreateNewObjectConstructors.newInstance();
		
		//Using Cloneable
		WaysToCreateNewObject newObject4 = (WaysToCreateNewObject) newObject3.clone();
		newObject4.reset();
		
		//Using Deserialization
		File objectFile = new File(CLASS_NAME);
		FileOutputStream fos = new FileOutputStream(objectFile);
		FileInputStream fis = new FileInputStream(objectFile);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        ObjectInputStream ois = new ObjectInputStream(fis);

		
        oos.writeObject(newObject4);
        oos.flush();
        oos.close();

        
        WaysToCreateNewObject newObject5 = (WaysToCreateNewObject) ois.readObject();
        newObject5.reset();
        
		System.out.println(newObject1);
		System.out.println(newObject2);
		System.out.println(newObject3);
		System.out.println(newObject4);
		System.out.println(newObject5);
		
	}
}
