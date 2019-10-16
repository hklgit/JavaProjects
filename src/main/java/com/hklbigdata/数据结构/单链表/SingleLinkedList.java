package com.hklbigdata.数据结构.单链表;

/**
 * Created by Kerven-HAN on 2019/9/19 21:02.
 * Talk is cheap , show me the code
 */
public class SingleLinkedList {

    private HeroNode head = new HeroNode(0, "", "");
    private HeroNode heroNode;


//    获取头结点
    public HeroNode getHead(){
        return head;
    }


    public void add(HeroNode heroNode){
        HeroNode temp  = head;
        while(true){
           if(temp.getNext() == null) {break;}
           temp = temp.getNext();
        }

//        temp.setName()= heroNode;




    }




}
