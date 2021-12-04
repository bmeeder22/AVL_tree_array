import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class test {

    @Test
    public void oneElement() {
        Main tree = new Main(1);
        tree.insert(0);
        assertEquals(0, tree.getRoot());

        Main.Node root = tree.get(tree.getRoot());
        assertEquals(0, root.value);
        assertEquals(1, root.height);
    }

    @Test
    public void twoElements() {
        Main tree = new Main(2);
        tree.insert(0);
        tree.insert(1);
        assertEquals(0, tree.getRoot());

        Main.Node root = tree.get(tree.getRoot());
        assertEquals(0, root.value);
        assertEquals(2, root.height);

        Main.Node rightOfRoot = tree.get(root.right);
        assertEquals(1, rightOfRoot.value);
        assertEquals(1, rightOfRoot.height);
    }

    @Test
    public void threeElements() {
        Main tree = new Main(3);
        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        assertEquals(1, tree.getRoot());

        Main.Node root = tree.get(tree.getRoot());
        assertEquals(1, root.value);
        assertEquals(2, root.height);

        Main.Node rightOfRoot = tree.get(root.right);
        assertEquals(2, rightOfRoot.value);
        assertEquals(1, rightOfRoot.height);

        Main.Node leftOfRoot = tree.get(root.left);
        assertEquals(0, leftOfRoot.value);
        assertEquals(1, leftOfRoot.height);
    }

    @Test
    public void fourElements() {
        Main tree = new Main(4);
        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        assertEquals(1, tree.getRoot());

        Main.Node root = tree.get(tree.getRoot());
        assertEquals(1, root.value);
        assertEquals(3, root.height);

        Main.Node leftOfRoot = tree.get(root.left);
        assertEquals(0, leftOfRoot.value);
        assertEquals(1, leftOfRoot.height);

        Main.Node rightOfRoot = tree.get(root.right);
        assertEquals(2, rightOfRoot.value);
        assertEquals(2, rightOfRoot.height);

        Main.Node rightOfRightOfRoot = tree.get(rightOfRoot.right);
        assertEquals(3, rightOfRightOfRoot.value);
        assertEquals(1, rightOfRightOfRoot.height);
    }

    @Test
    public void fiveElements() {
        Main tree = new Main(5);
        tree.insert(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        assertEquals(1, tree.getRoot());

        Main.Node root = tree.get(tree.getRoot());
        assertEquals(1, root.value);

        Main.Node leftOfRoot = tree.get(root.left);
        assertEquals(0, leftOfRoot.value);

        Main.Node rightOfRoot = tree.get(root.right);
        assertEquals(3, rightOfRoot.value);

        Main.Node rightOfRightOfRoot = tree.get(rightOfRoot.right);
        assertEquals(4, rightOfRightOfRoot.value);

        Main.Node leftOfRightOfRoot = tree.get(rightOfRoot.left);
        assertEquals(2, leftOfRightOfRoot.value);
    }

    @Test
    public void fiveElementsReversed() {
        Main tree = new Main(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(0);
        assertEquals(1, tree.getRoot());

        Main.Node root = tree.get(tree.getRoot());
        assertEquals(3, root.value);

        Main.Node leftOfRoot = tree.get(root.left);
        assertEquals(1, leftOfRoot.value);

        Main.Node rightOfRoot = tree.get(root.right);
        assertEquals(4, rightOfRoot.value);

        Main.Node rightOfLeftOfRoot = tree.get(leftOfRoot.right);
        assertEquals(2, rightOfLeftOfRoot.value);

        Main.Node leftOfLeftOfRoot = tree.get(leftOfRoot.left);
        assertEquals(0, leftOfLeftOfRoot.value);
    }

    @Test
    public void throwsErrorOnDuplicateInsertion() {
        Main tree = new Main(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(0);

        assertThrows(RuntimeException.class, () -> {
           tree.insert(0);
        });
    }

}
