class Solution {
	private long result = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int[] road : roads){
			map.computeIfAbsent(road[0], t -> new ArrayList<>()).add(road[1]);
			map.computeIfAbsent(road[1], t -> new ArrayList<>()).add(road[0]);
		}
		for(int cur : map.getOrDefault(0, List.of())){
			helper(cur, 0, map, seats);
		}
		return result;
    }
	public int helper(int cur, int parent, Map<Integer, List<Integer>> map, int seats){
		int carNum = 1;
		//dfs for sum of a trace
		for(int node : map.get(cur)){
			carNum += node == parent ? 0 : helper(node, cur, map, seats);
		}
		//round up: (dividend + divisor - 1) / divisor
		result += (carNum + seats - 1) / seats;
		return carNum;
	}
}
