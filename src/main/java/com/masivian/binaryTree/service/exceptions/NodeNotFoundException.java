package com.masivian.binaryTree.service.exceptions;

/**
 * 
 * 
 * @author <a href="jefferocket@gmail.com">Jeferson Rincon</a>
 *
 */
public class NodeNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeNotFoundException(String message) {
		super(message);
	}
}
