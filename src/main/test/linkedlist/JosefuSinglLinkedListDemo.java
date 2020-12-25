package main.test.linkedlist;

/**
 * @ClassName JosefuSinglLinkedList
 * @Description 单项链表解决约瑟夫环的问题
 * 约瑟夫问题：设编号为1 2 3 ... n的个人坐一圈，约定编号为k的人开始从1报数，然后数到m的那个人
 * 出列，由下一个人继续开始从1报数，以此类推，直到所有人都出列。输出出列的编号
 * 思路:
 * 1.固定Josefu对象的no和k同类型
 * 2.需要两个指针，first指向k位置，last指向first的后一位（方便删除m步之后的元素）
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
            System.out.println("输入的参数不合法");
        }
        for (int i = 1; i <= size; i++) {
            add(new Josefu(i));
        }
        Josefu first = head;
        Josefu last = head;
        //定位末尾
        while (last.next != head) {
            last = last.next;
        }
        //将first移动到k位，同时last同first走动
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
            System.out.println("Josefu 编号: " + first.no);
            first = first.next;
            last.next = first;
        }
        System.out.println("Josefu 编号: " + first.no);
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
            System.out.println("还没有数据");
        }
        Josefu temp = head;
        while (temp.next != head) {
            System.out.println("Josefu 编号: " + temp.no);
            temp = temp.next;
        }
        System.out.println("Josefu 编号: " + temp.no);
    }

}


class Josefu {
    public int no;
    public Josefu next;

    public Josefu(int no) {
        this.no = no;
    }
}
