package com.scx.javabase.tree;

import java.util.List;

/**
* Title: TreeParentTest
* Description:

* @author shencx
* @date 2019年2月26日
*/
public class TreeParentTest {

	public static void main(String[] args) {
		TreeParent<String> treeParent = new TreeParent<String>("根节点");
		System.out.println(treeParent.getNode(0));
		TreeParent.Node<String> root = treeParent.getNode(0);
		treeParent.addNode("节点1", root);
		treeParent.addNode("节点2", root);
		System.out.println("此树的深度：" + treeParent.getTreeDeep());


		List<TreeParent.Node<String>> nodes = treeParent.getChildNodeList(root);
		for (TreeParent.Node<String> node : nodes) {
			System.out.println(node);
		}

		treeParent.addNode("节点三", nodes.get(0));
		System.out.println("此树的深度：" + treeParent.getTreeDeep());
	}
}
