package main.test.linkedlist;

import java.net.HttpRetryException;

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
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建要给链表
        SingleOrderLinkedList singleLinkedList = new SingleOrderLinkedList();
        //加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        // 测试一下单链表的反转功能
        System.out.println("原来链表的情况~~");
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());
//        singleLinkedList = singleLinkedList.reverse(singleLinkedList);
        singleLinkedList.reverse2(singleLinkedList);
        System.out.println("=============reverse=============");
        singleLinkedList.show();
        System.out.println("=============update=============");
        HeroNode hero5 = new HeroNode(2, "卢俊义", "玉麒麟~");
        singleLinkedList.update(hero5);
        singleLinkedList.show();
        System.out.println("=============delete=============");
        HeroNode hero6 = new HeroNode(2, "卢俊义", "玉麒麟~");
        singleLinkedList.delete(hero6);
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

    /**
     * @return
     * @Author wangbq
     * @Description //链表反转，此方法的原理，新建一个链表（初始化一个head），
     * 然后依次取出最后一个node,放到新的head后，后续依次插入head.next
     * 1.计算原链表长度m
     * 2.指针temp指向head
     * 3.变量n
     * 4.让指针往尾部走，走m步长，n++记录步长，当n=m时，及代表走到队尾。取出
     * 元素，然后m--。temp=sl.head  n=0 初始化归为，从新遍历
     * 5.当m=0时，表示有效元素全部取出
     * @Date 9:43 2020/12/24
     * @Param
     */
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

    /**
     * @return
     * @Author wangbq
     * @Description 链表反转方式2
     * 原理：先初始化一个head，然后依次从前到后取出元素，连接到head后面，新元素要插入head和next之间。保证反转
     * 然后，将原head.next = newHead.next
     * 1.HeroNode newHead = new HeroNode(0,null,null);
     * 2.HeroNode temp = sl.head.next;
     * 3. while(true){
     * if(temp.next==null){
     * break;
     * }
     * temp.next=newHead.next;
     * newHead.next = temp;
     * }
     * sl.head.next = newHead.next;
     * @Date 9:52 2020/12/24
     * @Param
     */
    public void reverse2(SingleOrderLinkedList sl) {
        if (isEmpty()) {
            System.out.println("链表为空");
        }
        HeroNode newHead = new HeroNode(0, null, null);
        HeroNode temp = sl.head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            HeroNode node = new HeroNode(temp.no, temp.name, temp.minName);
            HeroNode next = newHead.next;
            newHead.next = node;
            node.next = next;
            temp = temp.next;
        }
        sl.head.next = newHead.next;
    }

    public void update(HeroNode node) {
        if (isEmpty()) {
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                temp.name = node.name;
                temp.minName = node.minName;
            }
            temp = temp.next;
        }
    }

    public void delete(HeroNode node) {
        if (isEmpty()) {
            System.out.println("链表为空");
        }
        HeroNode temp = head.next;
        HeroNode temp_pre = head;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                temp_pre.next = temp.next;
                break;
            }
            temp_pre = temp_pre.next;
            temp = temp.next;
        }

    }

}


