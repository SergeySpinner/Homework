package hm22;

import java.util.*;


public class Solution {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // создание очереди для прохождения по дереву
        boolean zigzagOrder = false; //ключ для придания вида зигзага собранным данным
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(); //сбор узлов построчно в один список
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.offer(node.left); //добавление в очередь левого предка
                if (node.right != null) queue.offer(node.right); //добавление в очередь правого предка
            }
            if (zigzagOrder) {
                zigzagOrder = false;
                Collections.reverse(list); // инверсия готового листа через раз
            } else {
                zigzagOrder = true;
            }
            res.add(list);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        List<List<Integer>> zigzag = zigzagLevelOrder(root);

        System.out.println(zigzag.toString());

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

