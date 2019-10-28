package com.masivian.binaryTree.service.api;

import com.masivian.binaryTree.model.Tree;

public interface IBinaryTreeService {
	
	/**
	 * Creates the binary tree
	 * 
	 * @param values the binary tree values
	 * @return the binary tree
	 */
	public Tree createBinaryTree(int[] values);

	/**
	 * Gets the lowest common ancestor.
	 * 
	 * @param values  the binary tree values
	 * @param nodeOne node one to find in tree
	 * @param nodeTwo node two to find in tree
	 * @return the lowest common ancestor (LCA)
	 */
	public String getLowestCommonAncestor(Tree theTree, Integer nodeOne, Integer nodeTwo);
}
