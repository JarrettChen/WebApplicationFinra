package net.spring.save;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class FileSaver {
	
	public void saveFile(byte[] file, String fileName){
		try (BufferedOutputStream out = 
				new BufferedOutputStream(new FileOutputStream(fileName));
				){
			out.write(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public byte[] getFile(String fileName){
		byte[] file = null;
		try (BufferedInputStream in = 
				new BufferedInputStream(new FileInputStream(fileName));
				){
			file = new byte[in.available()];
			in.read(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return file;
	}
}

