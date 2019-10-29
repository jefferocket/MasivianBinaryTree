package com.masivian.binaryTree;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.masivian.binaryTree.service.exceptions.NodeNotFoundException;
import com.masivian.binaryTree.service.implementation.BinaryTreeService;

/**
 * The Binary tree aplication test suite.
 * 
 * <a href="jefferocket@gmail.com">Jeferson Rincon</a>
 *
 */
@SpringBootTest
class BinaryTreeApplicationTests {

	/** Tree for test */
	private static final int binaryTreeTest[] = { 67, 39, 76, 28, 44, 29, 74, 85, 83, 87 };

	/** The Constant NODE_ONE. */
	private static final int NODE_ONE = 83;

	/** The Constant NODE_TWO. */
	private static final int NODE_TWO = 87;

	/** The Constant NODE_NOT_PRESENT. */
	private static final int NODE_NOT_INCLUDED = 2;

	/** The Constant EXPECTED_RESULT. */
	private static final String EXPECTED_RESULT = "The Lowest Common Ancestor of node 83 and node 87 is: 85";

	/**
	 * Gets the lowest common ancestor success and create tree.
	 */
	
	  @Test public void getLowestCommonAncestorSuccess(){
	  
	  final BinaryTreeService lowestCommonAncestorService = new BinaryTreeService();
	  final String result =
			  lowestCommonAncestorService.getLowestCommonAncestor(lowestCommonAncestorService.createBinaryTree(binaryTreeTest), NODE_ONE, NODE_TWO);
	  assertEquals(result, EXPECTED_RESULT);
	  
	  }
	  
	 /**
	  * A Node not found exception is expected
	  */
	  @Test
	  public void exceptionWhenNodeIsNotPresentInTree() {
		  
		  Assertions.assertThrows(NodeNotFoundException.class, ()->{
			  final BinaryTreeService lowestCommonAncestorService = new BinaryTreeService();
			  lowestCommonAncestorService.getLowestCommonAncestor(lowestCommonAncestorService.createBinaryTree(binaryTreeTest),
				  NODE_ONE, NODE_NOT_INCLUDED);
		  });
	  }
			 

}
