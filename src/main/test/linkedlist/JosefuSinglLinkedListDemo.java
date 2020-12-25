package main.test.linkedlist;

/**
 * @ClassName JosefuSinglLinkedList
 * @Description ����������Լɪ�򻷵�����
 * Լɪ�����⣺����Ϊ1 2 3 ... n�ĸ�����һȦ��Լ�����Ϊk���˿�ʼ��1������Ȼ������m���Ǹ���
 * ���У�����һ���˼�����ʼ��1�������Դ����ƣ�ֱ�������˶����С�������еı��
 * ˼·:
 * 1.�̶�Josefu�����no��kͬ����
 * 2.��Ҫ����ָ�룬firstָ��kλ�ã�lastָ��first�ĺ�һλ������ɾ��m��֮���Ԫ�أ�
 * @Author wbq
 * @Date 2020/12/24 20:42
 * @Version 1.0
 */
public class JosefuSinglLinkedListDemo {
    public static void main(String[] args) {
        JosefuSinglLinkedList jsl = new JosefuSinglLinkedList();
//        for (int i = 1; i <= 2; i++) {
//            jsl.add(new Josefu(i));
//        }
//        jsl.show();
        jsl.josefu(1, 2, 5);
    }
}

class JosefuSinglLinkedList {
    private Josefu head;

    public void josefu(int k, int m, int size) {
        if (k < 1 || m > size) {
            System.out.println("����Ĳ������Ϸ�");
        }
        for (int i = 1; i <= size; i++) {
            add(new Josefu(i));
        }
        Josefu first = head;
        Josefu last = head;
        //��λĩβ
        while (last.next != head) {
            last = last.next;
        }
        //��first�ƶ���kλ��ͬʱlastͬfirst�߶�
        while (true) {
            if (first.no == k) {
                break;
            }
            first = first.next;
            last = last.next;
        }
        while (true) {
            if (first == last) {
                break;
            }
            for (int i = 1; i <= m - 1; i++) {
                first = first.next;
                last = last.next;
            }
            System.out.println("Josefu ���: " + first.no);
            first = first.next;
            last.next = first;
        }
        System.out.println("Josefu ���: " + first.no);
    }

    public void add(Josefu node) {
        if (head == null) {
            head = node;
            head.next = head;
        } else {
            Josefu temp = head;
            while (true) {
                if (temp.next == head) {
                    temp.next = node;
                    node.next = head;
                    break;
                }
                temp = temp.next;
            }
        }
    }

    public void show() {
        if (head == null) {
            System.out.println("��û������");
        }
        Josefu temp = head;
        while (temp.next != head) {
            System.out.println("Josefu ���: " + temp.no);
            temp = temp.next;
        }
        System.out.println("Josefu ���: " + temp.no);
    }

}


class Josefu {
    public int no;
    public Josefu next;

    public Josefu(int no) {
        this.no = no;
    }
}
