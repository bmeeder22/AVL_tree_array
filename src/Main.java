public class Main {

    private static final int OOB = 6969;

    public class Node {
        int value;
        int left;
        int right;
        int height;

        public Node(int value) {
            this.value = value;
            left = OOB;
            right = OOB;
            height = 1;
        }
    }

    private int root;
    private int size;
    private final Node[] tree;

    public Main(int size) {
        tree = new Node[size];
        size = 0;
        root = 0;
    }

    public int getRoot() {
        return root;
    }

    public Node get(int index) {
        return tree[index];
    }

    public void insert(int value) {
        Node n = new Node(value);
        tree[size] = n;
        int startingIndex = size == 0 ? OOB : root;
        root = insert(startingIndex, value);
        size++;
    }

    private int insert(int index, int value) {
        if (index == OOB) {
            return size;
        }

        Node n = tree[index];

        int comparison = n.value - value;
        if (comparison > 0) {
            n.left = insert(n.left, value);
        } else if (comparison < 0) {
            n.right = insert(n.right, value);
        } else {
            throw new RuntimeException("Duplicate value inserted!!!");
        }
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        int heightDiff = heightDiff(index);
        if (heightDiff < -1) {
            if (heightDiff(n.right) > 0) {
                n.right = rightRotate(tree[n.right], n.right);
                return leftRotate(n, index);
            } else {
                return leftRotate(n, index);
            }
        } else if (heightDiff > 1) {
            if (heightDiff(n.left) < 0) {
                n.left = leftRotate(tree[n.left], n.left);
                return rightRotate(n, index);
            } else {
                return rightRotate(n, index);
            }
        } else {
            return index;
        }
    }

    private int leftRotate(Node n, int index) {
        int toReturn = n.right;
        Node toRotate = tree[n.right];
        n.right = toRotate.left;
        toRotate.left = index;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        toRotate.height = Math.max(height(toRotate.left), height(toRotate.right)) + 1;
        return toReturn;
    }

    private int rightRotate(Node n, int index) {
        int toReturn = n.left;
        Node r = tree[n.left];
        n.left = r.right;
        r.right = index;
        n.height = Math.max(height(n.left), height(n.right)) + 1;
        r.height = Math.max(height(r.left), height(r.right)) + 1;
        return toReturn;
    }

    private int heightDiff(int index) {
        if (index == OOB) {
            return 0;
        }

        Node a = tree[index];
        return height(a.left) - height(a.right);
    }

    private int height(int index) {
        if (index == OOB) {
            return 0;
        }
        return tree[index].height;
    }
}
