package main.test.tree;

/**
 * @ClassName BinarySortTree
 * @Description TODO
 * @Author Administrator
 * @Date 2020/12/30 13:26
 * @Version 1.0
 */
public class BinarySortTree {
    private SortTree root;

    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree bst = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            bst.add(arr[i]);
        }
        bst.add(2);
        bst.add(8);
        bst.add(11);
        bst.delete(10);
        bst.preOrder();
    }

    public void delete(int value) {
        SortTree target = root.search(value);
        if (target == null) {
            System.out.println("没有该节点");
        } else {
            if (target == root) {
                root = null;
            } else {
                SortTree parent = root.searchParent(value);
                if (target.left == null && target.right == null) {
                    if (parent.left == target) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                } else if (target.left != null && target.right != null) {
                    SortTree left = target.left.searchMin(target.left);
                    SortTree right = target.right.searchMin(target.right);
                    SortTree result = left.value < right.value ? left : right;
                    delete(result.value);
                    if (parent.left == target) {
                        parent.left = result;
                        result.left = target.left;
                        result.right = target.right;
                    } else {
                        parent.right = result;
                        result.left = target.left;
                        result.right = target.right;
                    }
                } else {
                    if (parent.left == target) {
                        if (target.right == null) {
                            parent.left = target.left;
                        } else {
                            parent.left = target.right;
                        }
                    } else {
                        if (target.right == null) {
                            parent.right = target.left;
                        } else {
                            parent.right = target.right;
                        }
                    }
                }
            }
        }
    }

    public void add(int value) {
        if (root == null) {
            root = new SortTree(value);
        } else {
            root.add(new SortTree(value));
        }
    }

    public void preOrder() {
        if (root == null) {
            System.out.println("树为空");
            return;
        }
        root.preOrder(root);
    }
}

class SortTree {
    public int value;
    public SortTree left;
    public SortTree right;

    public SortTree(int value) {
        this.value = value;
    }

    public SortTree searchMin(SortTree sortTree) {
        if (sortTree != null) {
            if (sortTree.left == null && sortTree.right == null) {
                return sortTree;
            } else if (sortTree.left != null && sortTree.right != null) {
                SortTree left = searchMin(sortTree.left);
                SortTree right = searchMin(sortTree.right);
                return left.value >= right.value ? left : right;
            } else {
                if (sortTree.left != null) {
                    return sortTree.left.searchMin(sortTree.left);
                } else {
                    return sortTree.right.searchMin(sortTree.right);
                }
            }
        }
        return null;
    }

    public SortTree searchParent(int value) {
        if (this.value > value) {
            if (this.left != null) {
                if (this.left.value == value) {
                    return this;
                } else {
                    return this.left.searchParent(value);
                }
            }
        } else {
            if (this.right != null) {
                if (this.right.value == value) {
                    return this;
                } else {
                    return this.right.searchParent(value);
                }
            }
        }
        return null;
    }

    public SortTree search(int value) {
        if (this.value > value) {
            if (this.left != null) {
                if (this.left.value == value) {
                    return this.left;
                } else {
                    return this.left.search(value);
                }
            }
        } else {
            if (this.right != null) {
                if (this.right.value == value) {
                    return this.right;
                } else {
                    return this.right.search(value);
                }
            }
        }
        return null;
    }

    /**
     * 如果要加入的节点小于父节点，则放在左边（左边为空），否则放在右边（右边为空）
     */
    public SortTree add(SortTree sortTree) {
        if (sortTree == null) {
            return null;
        }
        if (sortTree.value < this.value) {
            if (this.left != null) {
                this.left.add(sortTree);
            } else {
                this.left = sortTree;
            }
        } else {
            if (this.right != null) {
                this.right.add(sortTree);
            } else {
                this.right = sortTree;
            }
        }
        return this;
    }

    public static void preOrder(SortTree sortTree) {
        if (sortTree == null) {
            return;
        }
        System.out.println(sortTree);
        preOrder(sortTree.left);
        preOrder(sortTree.right);

    }

    @Override
    public String toString() {
        return "SortTree{" +
                "value=" + value +
                '}';
    }
}