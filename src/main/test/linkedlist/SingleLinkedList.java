package main.test.linkedlist;


/**
 * @ClassName SingleLinkedList
 * @Description ��������-��������-����Ԫ�ص����˳������
 * @Author Administrator
 * @Date 2020/12/23 13:45
 * @Version 1.0
 */
public class SingleLinkedList {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(2, "¬����", "������");
        HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
        //����Ҫ������
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //����
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        // ����һ�µ�����ķ�ת����
        System.out.println("ԭ����������~~");
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
            System.out.println("����Ϊ�գ�");
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