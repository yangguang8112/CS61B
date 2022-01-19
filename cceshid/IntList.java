public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public int interativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }
    
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
        // IntList p = this;
        // while (i > 0) {
        //     p = p.rest;
        //     i -= 1;
        // }
        // return p.first;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(10, null);
        L.rest.rest = new IntList(15, null);
        System.out.println(L.size());
        System.out.println(L.interativeSize());
        System.out.println(L.get(2));
    }
}
