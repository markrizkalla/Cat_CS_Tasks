class Solution {
    public int findShortestCycle(int n, int[][] edges) {
    // first creat graph
        HashMap<Integer,List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.put(i,new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            hashMap.get(edges[i][0]).add(edges[i][1]);
            hashMap.get(edges[i][1]).add(edges[i][0]);
        }


        // to store cycle len
        Queue<Integer> pr = new PriorityQueue<>();

        for (var v : hashMap.keySet()){

            // then bfs
            HashSet<Integer> visiting = new HashSet<>();
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(v);

            HashMap<Integer,Integer> len = new HashMap<>();
            HashMap<Integer,Integer> pastParent = new HashMap<>();
            len.put(v,0);
            while (!queue.isEmpty()){

                int x = queue.poll();

                if (visiting.contains(x)){
                    pr.add(len.get(x) +  1);
                    continue;
                }

                visiting.add(x);

                for (var node : hashMap.get(x)){
                    if (visiting.contains(node)) {
                        continue;
                    }

                    if (pastParent.containsKey(node)){
                        pr.add(len.get(x) + len.get(node) + 1);
                        continue;
                    }

                    pastParent.put(node,x);
                    len.put(node,len.get(x) + 1);
                    queue.add(node);
                }

            }
        }
        if (pr.isEmpty()){
            return -1;
        }else{
            return pr.peek();
        }

    }
}