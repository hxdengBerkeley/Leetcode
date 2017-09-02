/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public Map<Integer,UndirectedGraphNode> map;
    public Set<UndirectedGraphNode> setBFS;
    public Queue<UndirectedGraphNode> queueBFS;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node==null) return null;
        map = new HashMap<>();
        //BFS Start
        setBFS = new HashSet<>();
        queueBFS = new ArrayDeque<>();
        queueBFS.add(node);
        while(!queueBFS.isEmpty()){
            UndirectedGraphNode now = queueBFS.poll();
            if (setBFS.contains(now)) continue;
            else setBFS.add(now);
            if (!map.containsKey(now.label)){
                map.put(now.label,new UndirectedGraphNode(now.label));
            }
            for (UndirectedGraphNode neighbor:now.neighbors) {
                if (!setBFS.contains(neighbor)){
                    queueBFS.add(neighbor);
                }
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                }
                map.get(now.label).neighbors.add(map.get(neighbor.label));
            }
        }
        //BFS End

        return map.get(node.label);
    }
}