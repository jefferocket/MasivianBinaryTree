package com.masivian.binaryTree.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@JsonPropertyOrder({
"root"
})
public class Tree   {
  @JsonIgnore
  private Integer id = null;

  @JsonProperty("root")
  private Node root = null;

  public Tree id(int id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "1", value = "")


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

  
  /**
   * 
   * @param nodesItem The node value
   */
  public void addNodesItem(int nodesItem) {
	    this.root = addRecursiveLeaf(root, nodesItem);
  }
  
  /**
   * Recursive add
   * @param currentNode The current Node
   * @param nodeToAdd The new node
   * @return True if the node is add, false if the node already exists.
   */
  private Node addRecursiveLeaf(Node currentNode, int nodeToAdd) {
	  
	  if (currentNode == null) {
		  return new Node(nodeToAdd);
	  }else if(nodeToAdd < currentNode.getValue()) {
		  currentNode.setLeftNode(addRecursiveLeaf(currentNode.getLeftNode(), nodeToAdd));
	  }else if (nodeToAdd > currentNode.getValue()) {
		  currentNode.setRightNode(addRecursiveLeaf(currentNode.getRightNode(), nodeToAdd));
	  }else {
		  return null;
	  }
	  
	  return currentNode;
  }
}

