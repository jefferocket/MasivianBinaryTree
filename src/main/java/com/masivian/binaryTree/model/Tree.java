package com.masivian.binaryTree.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;

public class Tree   {
  @JsonProperty("id")
  private int id;

  @JsonProperty("root")
  private Node root = null;

  @JsonProperty("nodes")
  private List<Node> nodes = null;

  public Tree id(int id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "20", value = "")


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  /**
   * Get root
   * @return root
  **/
  @ApiModelProperty(value = "")

  public Node getRoot() {
    return root;
  }

  public void setRoot(Node root) {
    this.root = root;
  }

  public Tree nodes(List<Node> nodes) {
    this.nodes = nodes;
    return this;
  }

  /**
   * Get nodes
   * @return nodes
  **/
  @ApiModelProperty(value = "")

  public List<Node> getNodes() {
    return nodes;
  }

  public void setNodes(List<Node> nodes) {
    this.nodes = nodes;
  }
  
  /**
   * 
   * @param nodesItem The node value
   * @return True if the node was added, false if not was added.
   */
  public boolean addNodesItem(int nodesItem) {
	    if (this.nodes == null) {
	      this.nodes = new ArrayList<Node>();
	    }
	    if (addRecursiveLeaf(this.root, nodesItem)) {
	    	nodes.add(new Node(nodesItem));
	    	return true;
	    }
	    return false;
  }
  
  /**
   * Recursive add
   * @param currentNode The current Node
   * @param nodeToAdd The new node
   * @return True if the node is add, false if the node already exists.
   */
  private boolean addRecursiveLeaf(Node currentNode, int nodeToAdd) {
	  
	  if (currentNode == null) {
		  currentNode = new Node(nodeToAdd);
		  return true;
	  }else if(nodeToAdd < currentNode.getValue()) {
		  return addRecursiveLeaf(currentNode.getLeftNode(), nodeToAdd);
	  }else if (nodeToAdd > currentNode.getValue()) {
		  return addRecursiveLeaf(currentNode.getRightNode(), nodeToAdd);
	  }else {
		  return false;
	  }
	  
  }
}

