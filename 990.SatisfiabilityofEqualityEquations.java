class Solution {
    public boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                //two value have same ancestor
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }
    // a==b -> b is a's parent; value at index 0 is 1
    //assign index2's parent to index1's parent
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    //return the index of root ancestor
    public int find(int[] parent, int index) {
        //if the ancestor is not itself
        while (parent[index] != index) {
            //assign its parent's parent to it
            parent[index] = parent[parent[index]];
            //index of new ancestor
            index = parent[index];
        }
        return index;
    }
}
