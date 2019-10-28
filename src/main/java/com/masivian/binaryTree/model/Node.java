package com.masivian.binaryTree.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

/**
 * The class Node
 *
 * @author <a href="jefferocket@gmail.com">Jeferson Rincon</a>
 *
 */
@JsonPropertyOrder({
"value",
"left",
"right"
})
public class Node   {
	@JsonProperty("value")
	private int value;
	@JsonProperty("left")
	private Node leftNode;
	@JsonProperty("right")
	private Node rightNode;

	/**
	 * The Node constructor
	 * @param value Value of the node.
	 */
	public Node(int value) {
		this.value = value;
		setLeftNode(null);
		setRightNode(null);
	}

	/**
	 * Get value.
	 * @return value The node value.
	 **/
	@ApiModelProperty(example = "12", value = "")
	public int getValue() {
		return value;
	}

	/**
	 * Set the node value
	 * @param value The node value.
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * The left leaf
	 * @return The left node object.
	 */
	public Node getLeftNode() {
		return leftNode;
	}

	/**
	 * Set the left leaf.
	 * @param leftNode The leaf node.
	 */
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}

	/**
	 * Get the right node
	 * @return The right node.
	 */
	public Node getRightNode() {
		return rightNode;
	}

	/**
	 * Set the right node.
	 * @param rightNode
	 */
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Node node = (Node) o;
		return Objects.equals(this.value, node.value);
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("class Node {\n");
		sb.append("    value: ").append(value).append("\n");
		sb.append("}");
		return sb.toString();
	}

}

