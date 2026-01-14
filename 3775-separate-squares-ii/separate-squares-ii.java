class Event {
    int y;
    int type;
    int x;
    int side;

    public Event(int y, int type, int x, int side) {
        this.y = y;
        this.type = type;
        this.x = x;
        this.side = side;
    }
}

class SegmentTree {
    int n;
    int[] coverCount;
    double[] coveredLen;
    int[] xs;

    public SegmentTree(int[] xs) {
        this.xs = xs;
        this.n = xs.length - 1;
        this.coverCount = new int[4 * n];
        this.coveredLen = new double[4 * n];
    }

    void update(int node, int left, int right, int ql, int qr, int delta) {
        if (qr <= left || right <= ql)
            return;

        if (ql <= left && right <= qr) {
            coverCount[node] += delta;
        } else {
            int mid = (left + right) / 2;
            update(node * 2, left, mid, ql, qr, delta);
            update(node * 2 + 1, mid, right, ql, qr, delta);
        }

        if (coverCount[node] > 0)
            coveredLen[node] = xs[right] - xs[left];
        else if (left + 1 == right)
            coveredLen[node] = 0;
        else
            coveredLen[node] = coveredLen[node * 2] + coveredLen[node * 2 + 1];
    }
}

class Solution {

    public double separateSquares(int[][] squares) {
        List<Event>events= new ArrayList<>();
        Set<Integer>xSet = new HashSet<>();

        for(int[] sq:squares){
            int x = sq[0],y =sq[1],side=sq[2];
            events.add(new Event(y,1,x,side));
            events.add(new Event(y+side,-1,x,side));
            xSet.add(x);
            xSet.add(x+side);
        }

        int[]xs = xSet.stream().sorted().mapToInt(i->i).toArray();
        Map<Integer,Integer> xIndex= new HashMap<>();
        for(int i=0;i<xs.length;i++)xIndex.put(xs[i],i);

        events.sort(Comparator.comparingInt(e ->e.y));

        SegmentTree st = new SegmentTree(xs);
        double totalArea=0;
        int prevY = events.get(0).y;

        for(Event e: events){
            int curY=e.y;
            totalArea+=st.coveredLen[1]* ( curY-prevY);
            st.update(1,0,st.n,xIndex.get(e.x),xIndex.get(e.x+e.side),e.type);
            prevY = curY;
        }

        double half = totalArea/2;
        st = new SegmentTree(xs);
        double areaSoFar = 0;
        prevY = events.get(0).y;
        for(Event e: events){
            int curY = e.y;
            double width = st.coveredLen[1];
            double dy = curY - prevY;

            if(areaSoFar + width * dy >=half){
                return prevY + (half - areaSoFar)/width;
            }

            areaSoFar += width*dy;

            st.update(1,0,st.n,xIndex.get(e.x),xIndex.get(e.x + e.side),e.type);
            prevY = curY;
        }
        return prevY;
    }
}
