package com.masivian.binaryTree.controller;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.masivian.binaryTree.model.Tree;
import com.masivian.binaryTree.service.api.IBinaryTreeService;
import com.masivian.binaryTree.service.exceptions.ApiResponseMessage;
import com.masivian.binaryTree.service.exceptions.NodeNotFoundException;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/binaryTree")
public class BinaryTreeController {

	@Autowired
	private IBinaryTreeService treeService;
	
    private static final Logger LOG = LoggerFactory.getLogger(BinaryTreeController.class);

    @ApiOperation(value = "Add a new tree", nickname = "addTree", notes = "Add a binary tree to the server.", tags={ "tree", })
    @RequestMapping(value = "/tree",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    @ResponseBody
    public Tree addTree(@ApiParam(value = "The tree to be added" ,required=true ) @RequestParam int[] values){
    	LOG.info("Adding a tree");
        return treeService.createBinaryTree(values);
    }

    @ApiOperation(value = "Get a tree", nickname = "findATree", notes = "get the tree", response = Tree.class, tags={ "tree", })
    @RequestMapping(value = "/tree/{treeId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<Tree> findATree(@ApiParam(value = "",required=true) @PathVariable("treeId") int treeId){
    	return new ResponseEntity<Tree>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Finds the lowest common Ancestor", nickname = "findTheLowestCommonAncestor", notes = "Find the common ancestor given two nodes", tags={ "tree", })
    @RequestMapping(value = "/tree/{treeId}/lowestCommonAncestor", 
    	produces = { "*/*" },
        method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> findTheLowestCommonAncestor(@ApiParam(value = "The tree ID",required=true) @PathVariable("treeId") int[] treeId,
    		@NotNull @ApiParam(value = "The first Node", required = true) @RequestParam(value = "node1", required = true) Integer node1,
    		@NotNull @ApiParam(value = "The second Node", required = true) @RequestParam(value = "node2", required = true) Integer node2){
    	
    	LOG.info("Finding the lowest common ancestor...");
    	ApiResponseMessage response;
    	try {
    		response = new ApiResponseMessage(treeService.getLowestCommonAncestor(treeService.createBinaryTree(treeId), node1, node2));
    		LOG.info("Node found");
			return response.generateResponse(HttpStatus.OK);
		} catch (NodeNotFoundException e) {
			response = new ApiResponseMessage("Node not found");
			LOG.error(e.getMessage());
			return response.generateResponse(HttpStatus.NOT_FOUND);
		}
    }
}
