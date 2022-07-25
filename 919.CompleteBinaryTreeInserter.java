class CBTInserter {
    ArrayList<TreeNode> list;
    TreeNode root;
    int index;
    public CBTInserter(TreeNode root) {
        this.list = new ArrayList<>();
        this.root = root;
        this.index = 0;
        int cur = 0;
        list.add(root);
        while(cur < list.size()){
            TreeNode node = list.get(cur);
            if(node.left != null){
                list.add(node.left);
            }
            if(node.right != null){
                list.add(node.right);
            }
            cur++;
        }
    }
    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        while(list.get(index).left != null && list.get(index).right != null){
            index++;
        }
        TreeNode parentNode = list.get(index);
        if(parentNode.left == null){
            list.add(node);
            parentNode.left = node;
        }else if(parentNode.right == null){
            list.add(node);
            parentNode.right = node;
        }
        return list.get(index).val;
    }
    public TreeNode get_root() {
        return list.get(0);
    }
}
