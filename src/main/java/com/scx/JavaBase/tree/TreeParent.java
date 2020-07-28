package com.scx.javabase.tree;

import java.util.ArrayList;
import java.util.List;

/**
* Title: TreeTest
* Description:

* @author shencx
* @date 2019年2月26日
*/
public class TreeParent<E> {

	//节点
	public static class Node<T>{

		T data;

		int parent; //父节点位置

		public Node() {
		}

		public Node(int parent) {
			this.parent = parent;
		}

		public Node(T data, int parent) {
			this.data = data;
			this.parent = parent;
		}

		@Override
		public String toString() {
			return "TreeParent$Node[data=" + data + ", parent=" + parent + "]";
		}
	}

	private final int DEFAULT_TREE_SIZE = 100; //默认树大小
	private int treeSize = 0; //树大小

	private Node<E>[] nodes; //树里所有的节点

	private int nodeNums; //树的节点数


	/**
	 * 指定根节点创建树
	 */
	public TreeParent(E data) {
		treeSize = DEFAULT_TREE_SIZE;
		nodes = new Node[treeSize];

		nodes[0] = new Node<E>(data, -1);
		nodeNums++;
	}

	/**
	 * 指定根节点 和 树大小创建树
	 */
	public TreeParent(E data, int treeSize) {
		this.treeSize = treeSize;
		nodes = new Node[treeSize];

		nodes[0] = new Node<E>(data, -1);
		nodeNums++;
	}

	/**
	 * 为指定节点添加子节点
	 */
	public void addNode(E data, Node parent) {
		for(int i=0; i< treeSize; i++) {
			if(nodes[i] == null) {
				nodes[i] = new Node<>(data, getNodeLocal(parent));
				nodeNums++;
				return ;
			}
		}
		throw new RuntimeException("该树已满，无法添加新节点");
	}


	/**
	 * 返回当前节点在树中的位置
	 * @param node
	 * @return
	 */
	private Integer getNodeLocal(Node<E> node) {
		for(int i=0; i< treeSize; i++ ) {
			if(nodes[i] == node) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 判断树是否为null
	 * @return
	 */
	public Boolean empty() {
		return nodes[0] == null;
	}

	/**
	 * 返回树指定位置的节点
	 * @param local
	 * @return
	 */
	public Node<E> getNode(int local){
		return nodes[local];
	}

	/**
	 * 返回指定节点的父节点（非根节点）
	 * @param node
	 * @return
	 */
	public Node<E> getNodeParent(Node<E> node){
		return getNode(node.parent);
	}

	/**
	 * 返回指定节点（非叶子节点）的所有子节点
	 * @param node
	 * @return
	 */
	public List<Node<E>> getChildNodeList(Node<E> node){
		List<Node<E>> list = new ArrayList<Node<E>>();
		for (int i = 0; i < treeSize; i++) {
			// 如果当前节点的父节点的位置等于parent节点的位置
			if (nodes[i] != null && nodes[i].parent == getNodeLocal(node)) {
				list.add(nodes[i]);
			}
		}
		return list;
	}

	/**
	 * 返回树的深度
	 * @return
	 */
	public Integer getTreeDeep() {
		// 用于记录节点的最大深度
		int max = 0;
		for (int i = 0; i < treeSize && nodes[i] != null; i++) {
			// 初始化本节点的深度
			int def = 1;
			// m 记录当前节点的父节点的位置
			int m = nodes[i].parent;
			// 如果其父节点存在
			while (m != -1 && nodes[m] != null) {
				// 向上继续搜索父节点
				m = nodes[m].parent;
				def++;
			}
			if (max < def) {
				max = def;
			}
		}
		return max;
	}

	public void methodTry(String s) {
		System.out.println(s);
	}
}
