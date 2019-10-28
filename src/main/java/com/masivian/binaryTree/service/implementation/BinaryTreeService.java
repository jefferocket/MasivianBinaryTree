package com.masivian.binaryTree.service.implementation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.masivian.binaryTree.model.Node;
import com.masivian.binaryTree.model.Tree;
import com.masivian.binaryTree.service.api.IBinaryTreeService;

@Service
public class BinaryTreeService implements IBinaryTreeService {

	/** The logger. */
	private static final Logger LOGGER = LogManager.getLogger(BinaryTreeService.class.getName());
	
	/** The Constant SUCCESS_RESULT_FORMAT. */
	private static final String SUCCESS_RESULT_FORMAT = "The Lowest Common Ancestor of node %s and node %s is: %s";

	/** The Constant FAIL_RESULT_FORMAT. */
	private static final String FAIL_RESULT_FORMAT = "The nodes given don't exist in the tree.";

	@Override
	public Tree createBinaryTree(int[] values) {
		// TODO Auto-generated method stub
		Tree theTree = new Tree();
		for (int i = 0; i < values.length; i++) {
			theTree.addNodesItem(values[i]);
		}
		return theTree;
	}

	@Override
	public String getLowestCommonAncestor(Tree theTree, Integer nodeOne, Integer nodeTwo) {

		Node nodeA = new Node(nodeOne.intValue());
		Node nodeB = new Node(nodeTwo.intValue());
		Node nodeToFind = getLowestCommonAncestorNode(theTree.getRoot(), nodeA, nodeB);

		LOGGER.info("Node found with value: "+nodeToFind.getValue());
		String result;
		if (nodeToFind == null)
			result = FAIL_RESULT_FORMAT;
		else
			result = String.format(SUCCESS_RESULT_FORMAT, nodeOne.intValue(), nodeTwo.intValue(), nodeToFind.getValue());	 		
		return result;
	}

	/**
	 * Recursive search to find the lowest common ancestor for two nodes.
	 * @param current The node.
	 * @param nodeOne The first node to find.
	 * @param nodeTwo The second node to find.
	 * @return The lowest common ancestor. Null if doesn't exist.
	 */
	private Node getLowestCommonAncestorNode(Node current, Node nodeOne, Node nodeTwo) {
		if(current == null) {
			return null;
		}
		if(current.equals(nodeOne) || current.equals(nodeTwo)) {
			return current;
		}

		Node left = getLowestCommonAncestorNode(current.getLeftNode(), nodeOne, nodeTwo);
		Node right = getLowestCommonAncestorNode(current.getRightNode(), nodeOne, nodeTwo);

		if (left != null && right != null) {
			return current;
		}
		return (right == null) ? left : right;
	}

}
