package main.test.linkedlist;

/**
 * @ClassName SingleOrderLinkedList
 * @Description 有序链表--和添加元素顺序没有关系，按照heroNode 的 no排序,以及反转链表
 * @Author Administrator
 * @Date 2020/12/23 16:02
 * @Version 1.0
 */
public class SingleOrderLinkedList {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
//        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建要给链表
        SingleOrderLinkedList singleLinkedList = new SingleOrderLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        // 测试一下单链表的反转功能
        System.out.println("原来链表的情况~~");
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());
        singleLinkedList = singleLinkedList.reverse(singleLinkedList);
        System.out.println("=============reverse=============");
        singleLinkedList.show();
    }

    private HeroNode head = new HeroNode(0, null, null);

    public boolean isEmpty() {
        return head.next == null;
    }

    public void add(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > node.no) {
                break;
            }
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
    }

    public void add2(HeroNode node) {
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = node;
                return;
            }
            temp = temp.next;
        }
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("当前没有数据");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int length = 0;
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            length++;
            temp = temp.next;
        }
        return length;
    }

    public SingleOrderLinkedList reverse(SingleOrderLinkedList sl) {
        if (sl.isEmpty()) {
            System.out.println("链表为空");
            return sl;
        }
        SingleOrderLinkedList newList = new SingleOrderLinkedList();
        //去除head
        int m = sl.size();
        HeroNode temp = sl.head;
        int n = 0;
        while (true) {
            if (n == m) {
                temp.next = null;
                newList.add2(temp);
                temp = sl.head;
                m--;
                n = 0;
            }
            n++;
            temp = temp.next;
            if (m == 0) {
                break;
            }
        }
        sl = newList;
        return sl;
    }
}


