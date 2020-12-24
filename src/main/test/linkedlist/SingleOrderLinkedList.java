package main.test.linkedlist;

import java.net.HttpRetryException;

/**
 * @ClassName SingleOrderLinkedList
 * @Description ��������--�����Ԫ��˳��û�й�ϵ������heroNode �� no����,�Լ���ת����
 * @Author Administrator
 * @Date 2020/12/23 16:02
 * @Version 1.0
 */
public class SingleOrderLinkedList {

    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
        //����Ҫ������
        SingleOrderLinkedList singleLinkedList = new SingleOrderLinkedList();
        //����
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        // ����һ�µ�����ķ�ת����
        System.out.println("ԭ����������~~");
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());
//        singleLinkedList = singleLinkedList.reverse(singleLinkedList);
        singleLinkedList.reverse2(singleLinkedList);
        System.out.println("=============reverse=============");
        singleLinkedList.show();
        System.out.println("=============update=============");
        HeroNode hero5 = new HeroNode(2, "¬����", "������~");
        singleLinkedList.update(hero5);
        singleLinkedList.show();
        System.out.println("=============delete=============");
        HeroNode hero6 = new HeroNode(2, "¬����", "������~");
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
            System.out.println("��ǰû������");
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
     * @Description //����ת���˷�����ԭ���½�һ��������ʼ��һ��head����
     * Ȼ������ȡ�����һ��node,�ŵ��µ�head�󣬺������β���head.next
     * 1.����ԭ������m
     * 2.ָ��tempָ��head
     * 3.����n
     * 4.��ָ����β���ߣ���m������n++��¼��������n=mʱ���������ߵ���β��ȡ��
     * Ԫ�أ�Ȼ��m--��temp=sl.head  n=0 ��ʼ����Ϊ�����±���
     * 5.��m=0ʱ����ʾ��ЧԪ��ȫ��ȡ��
     * @Date 9:43 2020/12/24
     * @Param
     */
    public SingleOrderLinkedList reverse(SingleOrderLinkedList sl) {
        if (sl.isEmpty()) {
            System.out.println("����Ϊ��");
            return sl;
        }
        SingleOrderLinkedList newList = new SingleOrderLinkedList();
        //ȥ��head
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
     * @Description ����ת��ʽ2
     * ԭ���ȳ�ʼ��һ��head��Ȼ�����δ�ǰ����ȡ��Ԫ�أ����ӵ�head���棬��Ԫ��Ҫ����head��next֮�䡣��֤��ת
     * Ȼ�󣬽�ԭhead.next = newHead.next
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
            System.out.println("����Ϊ��");
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
            System.out.println("����Ϊ��");
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
            System.out.println("����Ϊ��");
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


