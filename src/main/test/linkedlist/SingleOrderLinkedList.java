package main.test.linkedlist;

import java.net.HttpRetryException;
import java.util.Stack;

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

        HeroNode hero5 = new HeroNode(5, "����", "������");
        HeroNode hero6 = new HeroNode(6, "³����", "������");
        HeroNode hero7 = new HeroNode(7, "��־", "������");
        //����Ҫ������
        SingleOrderLinkedList singleLinkedList = new SingleOrderLinkedList();
        //����
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero6);
        singleLinkedList.add(hero7);
        SingleOrderLinkedList singleLinkedList2 = new SingleOrderLinkedList();
        singleLinkedList2.add(hero5);
        singleLinkedList2.add(hero2);
        singleLinkedList2.add(hero4);
        // ����һ�µ�����ķ�ת����
        System.out.println("ԭ����������~~");
        singleLinkedList.show();
        singleLinkedList.merge(singleLinkedList2);
        System.out.println("�ϲ�һ������֮��~~");
        singleLinkedList.show();
        System.out.println(singleLinkedList.size());
//        singleLinkedList = singleLinkedList.reverse(singleLinkedList);
//        singleLinkedList.reverse2(singleLinkedList);
        System.out.println("=============reversePrint=============");
        singleLinkedList.reversePrint(singleLinkedList.head);
        singleLinkedList.reverse3();
        System.out.println("=============reverse=============");
        singleLinkedList.show();
        System.out.println("=============update=============");
        HeroNode hero100 = new HeroNode(2, "¬����", "������~");
        singleLinkedList.update(hero100);
        singleLinkedList.show();
        System.out.println("=============findLast=============");
        singleLinkedList.findLast(3);
        System.out.println("=============delete=============");
//        HeroNode hero6 = new HeroNode(2, "¬����", "������~");
//        singleLinkedList.delete(hero6);
        singleLinkedList.delete2(2);
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
     * @Description ���ҵ�����index���ڵ�
     * @Date 11:07 2020/12/24
     * @Param
     */
    public void findLast(int index) {
        if (isEmpty()) {
            System.out.println("����Ϊ��");
        }
        int size = size();
        if (index <= 0 || index > size) {
            System.out.println("�ýڵ㲻������Χ��");
            return;
        }
        HeroNode temp = head.next;
        for (int i = 0; i < size - index; i++) {
            temp = temp.next;
        }
        System.out.println(temp.toString());
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
        while (!(m == 0)) {
            if (n == m) {
                temp.next = null;
                newList.add2(temp);
                temp = sl.head;
                m--;
                n = 0;
            }
            n++;
            temp = temp.next;
        }
        sl = newList;
        return sl;
    }

    public void reverse3() {
        if (isEmpty()) {
            System.out.println("����Ϊ��");
        }
        HeroNode newHead = new HeroNode(0, null, null);
        int m = size();
        int n = 0;
        HeroNode temp = head;
        while (!(m == n)) {
            n++;
            temp = temp.next;
            HeroNode node = new HeroNode(temp.no, temp.name, temp.minName);
            HeroNode next = newHead.next;
            node.next = next;
            newHead.next = node;
        }
        head.next = newHead.next;
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
        while (temp == null) {
            HeroNode node = new HeroNode(temp.no, temp.name, temp.minName);
            HeroNode next = newHead.next;
            newHead.next = node;
            node.next = next;
            temp = temp.next;
        }
        sl.head.next = newHead.next;
    }

    /**
     * @return
     * @Author wangbq
     * @Description ��ת��ӡ�����ı�ԭ����ṹ
     * @Date 15:14 2020/12/24
     * @Param
     */
    public void reversePrint(HeroNode head) {
        if (head.next == null) {
            System.out.println("����Ϊ�գ����ܴ�ӡ");
        }
        Stack<HeroNode> heroNodes = new Stack<>();
        HeroNode temp = head.next;
        while (temp != null) {
            heroNodes.push(temp);
            temp = temp.next;
        }
        while (!heroNodes.empty()) {
            System.out.println(heroNodes.pop());
        }
    }

    public void update(HeroNode node) {
        if (isEmpty()) {
            System.out.println("����Ϊ��");
        }
        HeroNode temp = head.next;
        while (temp != null) {
            if (temp.no == node.no) {
                temp.name = node.name;
                temp.minName = node.minName;
            }
            temp = temp.next;
        }
    }

    /**
     * ����ϲ�
     */
    public void merge(SingleOrderLinkedList a) {
        if (a.isEmpty()) {
            System.out.println("Ҫ��ӵ�����Ϊ��");
        }
        HeroNode temp = a.head.next;
        while (temp != null) {
            this.add(new HeroNode(temp.no, temp.name, temp.minName));
            temp = temp.next;
        }
    }

    public void delete(HeroNode node) {
        if (isEmpty()) {
            System.out.println("����Ϊ��");
        }
        HeroNode temp = head.next;
        HeroNode temp_pre = head;
        while (temp != null) {
            if (temp.no == node.no) {
                temp_pre.next = temp.next;
                break;
            }
            temp_pre = temp_pre.next;
            temp = temp.next;
        }
    }

    public void delete2(int no) {
        boolean flag = false;
        HeroNode temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("û�иĽڵ�");
        }
    }

}


