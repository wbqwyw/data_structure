package main.test.linkedlist;

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
//        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
        //����Ҫ������
        SingleOrderLinkedList singleLinkedList = new SingleOrderLinkedList();
        //����
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        // ����һ�µ�����ķ�ת����
        System.out.println("ԭ����������~~");
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
}


