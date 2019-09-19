package com.hklbigdata.数据结构.双向链表;

/**
 * Created by Kerven-HAN on 2019/9/19 20:10.
 * Talk is cheap , show me the code
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

class DoubleLinkedList{

}

class HeroNode{
    private int no;
    private String name;
    private String nickName;
    private HeroNode next;
    private HeroNode pre;

    public HeroNode(int no,String name,String nickName){
        this.no = no ;
        this.name = name ;
        this.nickName = nickName ;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroNode getNext() {
        return next;
    }

    public void setNext(HeroNode next) {
        this.next = next;
    }

    public HeroNode getPre() {
        return pre;
    }

    public void setPre(HeroNode pre) {
        this.pre = pre;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                ", next=" + next +
                ", pre=" + pre +
                '}';
    }
}