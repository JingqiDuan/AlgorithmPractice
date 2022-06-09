public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(root, "");        
    }

    public String serializeHelper(TreeNode root, String str){
        if(root == null){
            str += "null,";
        }else{
            str += String.valueOf(root.val) + ",";
            str += serialize(root.left);
            str += serialize(root.right);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "" || data.length() == 0){
            return null;
        }
        String[] nodeVals = data.split(",");
        List<String> dataList = new ArrayList<>(Arrays.asList(nodeVals));
        return deserializeHelper(dataList);
    }

    public TreeNode deserializeHelper(List<String> dataList){
        if(dataList.get(0).equals("null")){
            dataList.remove(0);
            return null;
        }
        int val = Integer.valueOf(dataList.get(0));
        TreeNode root = new TreeNode(val);
        dataList.remove(0);
        root.left = deserializeHelper(dataList);
        root.right = deserializeHelper(dataList);
        return root;
    }
}
