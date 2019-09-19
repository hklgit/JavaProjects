package com.hklbigdata.数据结构.单链表;

/**
 * Created by Kerven-HAN on 2019/9/19 21:02.
 * Talk is cheap , show me the code
 */
public class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");
    private HeroNode heroNode;

    //    添加数据（到链表的最后位置）
//    1:找到链表的最后节点
//    2：把最后节点的next指向我们要添加的节点
    public void add(HeroNode heroNode) {
//头结点不能动，所以我们需要一个辅助遍历 temp
        HeroNode temp = head;
// 遍历链表，找到最后
        while (true) {
//    找到最后了
            if (temp.getNext() == null) {
                break;
            }
//    把temp往后移动
            temp = temp.getNext();
        }
//while循环结束的时候，temp也就指向了新的节点
//       temp.getNext() = heroNode;

    }
}
