class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board.length == 0){
            return new ArrayList<>();
        }
        if(board[0] == null || board[0].length == 0){
            return new ArrayList<>();
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> wordSet = new HashSet<>();
        Set<String> prefixSet = new HashSet<>();
        for(String word : words){
            for(int i = 0; i < word.length(); i++){
                prefixSet.add(word.substring(0, i + 1));
            }
            wordSet.add(word);
        }
        Set<String> resultSet = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                //mark visited node
                visited[i][j] = true;
                //word start with first letter
                dfs(board, visited, i, j, String.valueOf(board[i][j]), wordSet,
                prefixSet, resultSet);
                //back track, unmark visited node
                visited[i][j] = false;
            }
        }
        List<String> results = new ArrayList<>(resultSet);
        return results;
    }
    private void dfs(char[][] board,
                    boolean[][] visited,
                    int x,
                    int y,
                    String word,
                    Set<String> wordSet,
                    Set<String> prefixSet,
                    Set<String> resultSet){
        if(!prefixSet.contains(word)){
            return;
        }
        if(wordSet.contains(word)){
            resultSet.add(word);
        }
        int[][] adj = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        for(int i = 0; i < 4; i++){
            int adjX = x + adj[i][0];
            int adjY = y + adj[i][1];
            if(!inBound(board, adjX, adjY) || visited[adjX][adjY]){
                continue;
            }
            //mark visited here also
            visited[adjX][adjY] = true;
            dfs(board, visited, adjX, adjY, word + board[adjX][adjY], wordSet,
                prefixSet, resultSet);
            //no need to back track word
            visited[adjX][adjY] = false;
        }

    }

    private boolean inBound(char[][]board, int x, int y){
        int numRow = board.length;
        int numCol = board[0].length;
        return x >= 0 && x < numRow && y >= 0 && y < numCol;
    }
}
