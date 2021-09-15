package main.test.tree;

import java.io.*;
import java.util.*;

/**
 * @ClassName HuffmanTreeCode
 * @Description �շ�������
 * 1.���ַ���ת�ֽ�����
 * 2.ͳ��ÿ���ֽڳ��ֵĴ���
 * 3.�����շ�����
 * 4.�����շ�������Ȼ����ÿ���ֽڶ�Ӧ�ĺշ�������
 * 5.�����ֽ����飬Ȼ����պշ������룬���ɶ������ַ���
 * 6.�����µ��ֽ�����
 * 7.�����ɵĶ������ַ���ת���ֽ�����
 * @Author Administrator
 * @Date 2020/12/29 11:19
 * @Version 1.0
 */
public class HuffmanTreeCode {
    private static Map<Byte, String> huffCodeMap = new HashMap<>();

    private static StringBuilder sbuilder = new StringBuilder();

    public static void main(String[] args) {
//        String content = "i like like like java do you like a java";
//        //���ַ���ת���ֽ�����
//        byte[] data = getByte(content);
//        byte[] huffCode = huffCode(data);
//        System.out.println(Arrays.toString(huffCode));
//        byte[] bytes = decode(huffCodeMap, huffCode);
//        System.out.println(new String(bytes));
        zipFile("D:\\Java.png", "D:\\Javapng.zip");
        System.out.println("ѹ�����");
        unZipFile("D:\\Javapng.zip", "D:\\Java2.png");
        System.out.println("��ѹ���");
    }

    public static void unZipFile(String srcFile, String dstFile) {
        try (FileOutputStream fos = new FileOutputStream(dstFile);
             FileInputStream fis = new FileInputStream(srcFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            byte[] bytes = (byte[]) ois.readObject();
            Map<Byte, String> huffCodeMap = (Map<Byte, String>) ois.readObject();
            byte[] result = decode(huffCodeMap, bytes);
            fos.write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //ѹ���ļ�
    public static void zipFile(String srcFile, String dstFile) {
        try (FileInputStream fis = new FileInputStream(srcFile);
             OutputStream fos = new FileOutputStream(dstFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            byte[] newBytes = huffCode(bytes);
            oos.writeObject(newBytes);
            oos.writeObject(huffCodeMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static byte[] decode(Map<Byte, String> map, byte[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            byte b = arr[i];
            //���һλ���ܲ���8λ�����Բ���Ҫ�������
            boolean flag = (i == arr.length - 1);
            sb.append(byteToBitString(!flag, b));
        }
        HashMap<String, Byte> stringByteHashMap = new HashMap<>();
        for (Map.Entry<Byte, String> entry : map.entrySet()) {
            stringByteHashMap.put(entry.getValue(), entry.getKey());
        }
        ArrayList<Byte> bytes = new ArrayList<>();
        for (int i = 0; i < sb.length(); ) {
            int count = 1;
            boolean flag = true;
            while (flag) {
                if (i + count < sb.length()) {
                    String s = sb.substring(i, i + count);
                    if (stringByteHashMap.containsKey(s)) {
                        bytes.add(stringByteHashMap.get(s));
                        flag = false;
                    } else {
                        count++;
                    }
                } else {
                    flag = false;
                }
            }
            i += count;
        }
        byte[] buff = new byte[bytes.size()];
        for (int i = 0; i < buff.length; i++) {
            buff[i] = bytes.get(i);
        }
        return buff;
    }

    public static String byteToBitString(boolean flag, byte b) {
        //ת10���ƣ�Ϊ�����ɶ������ַ�������Ϊbyteû����ط���ת
        int temp = b;
        if (flag) {
            //����λ����Ϊ����û�и�λ�����ǹ�ϵ��
            temp |= 256;
        }
        String str = Integer.toBinaryString(temp);
        if (flag) {
            //��ȡ��ʼ��8λ
            return str.substring(str.length() - 8);
        } else {
            return str;
        }
    }

    public static byte[] huffCode(byte[] data) {
        //ͳ��ÿ���ֽ��ظ����ֵĸ�����ӳ���ϵ
        Map<Byte, Integer> byteMap = byteToMap(data);
        //���ظ����ָ���ת�ɼ���
        List<NodeCode> list = mapToList(byteMap);
        //������ת�ɹ�������
        NodeCode root = listToHuffmanTree(list);
        //����ÿ���ַ���Ӧ�Ĺ�����·��
        getHuffCode(root);
        //�����ַ����͹�����·��������һ���������ַ���
        buildHuffCodeString(data);
        //���������ַ���תΪ�ֽ����飬�ﵽѹ����Ŀ��
        byte[] huffCode = huffCodeToByteArr();
        return huffCode;
    }

    public static byte[] getByte(String message) {
        return message == null ? null : message.getBytes();
    }

    public static Map<Byte, Integer> byteToMap(byte[] arr) {
        Map<Byte, Integer> map = new HashMap<>();
        if (arr == null) {
            return null;
        }
        for (byte b : arr) {
            if (map.get(b) == null) {
                map.put(b, 1);
            } else {
                map.put(b, map.get(b) + 1);
            }
        }
        return map;
    }

    public static List<NodeCode> mapToList(Map<Byte, Integer> map) {
        ArrayList<NodeCode> list = new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            list.add(new NodeCode(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    public static NodeCode listToHuffmanTree(List<NodeCode> list) {
        while (list.size() > 1) {
            Collections.sort(list);
            NodeCode left = list.get(0);
            NodeCode right = list.get(1);
            //�˴�Ҫ��ֵnull����Ϊbyte������ܰ���0��ԭ����0��ֵ�����°�0������ˡ�������ʧ�����
            NodeCode parent = new NodeCode(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            list.remove(left);
            list.remove(right);
            list.add(parent);
        }
        return list.get(0);
    }

    public static void getHuffCode(NodeCode node) {
        //�˴���new StringBuilder();Ҳ�ǿ��ԣ�ֻ��Ϊ�˴��ջ�����
        getHuffCode(node.left, "0", sbuilder);
        getHuffCode(node.right, "1", sbuilder);
    }

    public static void getHuffCode(NodeCode node, String code, StringBuilder stringBuilder) {
        //��Ϊ��ͳ��ÿһ���ڵ��·��������ÿ��һ���ڵ㣬��Ҫ�½����������н��ϸ��ڵ��·��
        //����ͳ�Ʋ����
        StringBuilder sb = new StringBuilder(stringBuilder);
        sb.append(code);
        if (node != null) {
            if (node.data == null) {
                getHuffCode(node.left, "0", sb);
                getHuffCode(node.right, "1", sb);
            } else {
                huffCodeMap.put(node.data, sb.toString());
            }
        }
    }

    public static void buildHuffCodeString(byte[] arr) {
        for (byte b : arr) {
            sbuilder.append(huffCodeMap.get(b));
        }
    }

    public static byte[] huffCodeToByteArr() {
        int len = 0;
        //��һ��д��
        //len = sbuilder.length() + 7 /8;
        if (sbuilder.length() % 8 == 0) {
            len = sbuilder.length() / 8;
        } else {
            len = sbuilder.length() / 8 + 1;
        }
        byte[] bytes = new byte[len];
        int index = 0;
        for (int i = 0; i < sbuilder.length(); i += 8) {
            String strByte;
            if (i + 8 > sbuilder.length()) {
                strByte = sbuilder.substring(i);
            } else {
                strByte = sbuilder.substring(i, i + 8);
            }
            bytes[index] = (byte) Integer.parseInt(strByte, 2);
            index++;
        }
        return bytes;
    }

}

class NodeCode implements Comparable<NodeCode> {
    //Ҫ����������Byte����ֵ����Ȼ���ܸ�ֵnull��������������
    public Byte data;
    public int weight;
    public NodeCode left;
    public NodeCode right;

    public NodeCode(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "NodeCode{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(NodeCode o) {
        return this.weight - o.weight;
    }
}