package main.test.linkedlist;


/**
 * @ClassName SingleLinkedList
 * @Description 单项链表-无序链表-按照元素的添加顺序排序
 * @Author Administrator
 * @Date 2020/12/23 13:45
 * @Version 1.0
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        // 测试一下单链表的反转功能
        System.out.println("原来链表的情况~~");
        singleLinkedList.show();
    }

    private HeroNode head = new HeroNode(0, "", "");

    public boolean isEmpty() {
        return head.next == null;
    }

    public void add(HeroNode node) {
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
            System.out.println("链表为空！");
        }
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                return;
            }
            System.out.println(temp.next.toString());
            temp = temp.next;
        }
    }
}

class HeroNode {
    public int no;
    public String name;
    public String minName;
    public HeroNode next;

    public HeroNode(int no, String name, String minName) {
        this.no = no;
        this.name = name;
        this.minName = minName;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getMinName() {
        return minName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", minName='" + minName + '\'' +
                '}';
    }
}