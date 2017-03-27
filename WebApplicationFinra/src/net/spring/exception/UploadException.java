package net.spring.exception;

import java.io.IOException;

public class UploadException extends RuntimeException{
 
	private static final long serialVersionUID = 1L;

	public UploadException(IOException e) {
        super(e);
    }
}

