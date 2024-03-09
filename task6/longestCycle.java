class Solution {
    public int longestCycle(int[] edges) {
        // first creat the graph
        HashMap<Integer,List<Integer>> hashMap = new HashMap<>(edges.length);
        for (int i = 0; i < edges.length; i++) {
            hashMap.putIfAbsent(i,new ArrayList<>());
            if (edges[i] == -1)
                continue;

            hashMap.get(i).add(edges[i]);
        }

        int queue = -1;

        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer,Integer> len = new HashMap<>();
        for (var node : hashMap.keySet()){
             
            if (visited.contains(node))
                continue;

            HashSet<Integer> visiting = new HashSet<>();
            Stack<Integer> stack = new Stack<>();

            stack.push(node);
            len.put(node,0);
            boolean updated = false;

            while (!stack.empty()){

                if(updated){
                    break;
                }

                int x = stack.pop();
                visiting.add(x);
                visited.add(x);

                for(var nei : hashMap.get(x)){
                    if (visiting.contains(nei)){
                        if (len.get(x) + 1 - len.get(nei) > queue){
                            queue = len.get(x) + 1 - len.get(nei);
                            updated = true;
                        }
                        continue;
                    }
                    stack.push(nei);
                    len.put(nei,len.get(x) + 1);
                }
            }
        }
       return queue;
    }
}