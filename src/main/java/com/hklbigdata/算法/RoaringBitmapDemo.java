package com.hklbigdata.算法;

import org.roaringbitmap.RoaringBitmap;
import org.roaringbitmap.buffer.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;

/**
 * Created by Kerven-HAN on 2019/10/10 15:54.
 * Talk is cheap , show me the code
 */
public class RoaringBitmapDemo {


    public static void main(String[] args) throws  Exception{


//        RoaringBitmap rr = RoaringBitmap.bitmapOf(1,2,3,1000);
//new ByteArrayInputStream(outBytes))
//
//        byte[] bytes = "abc".getBytes();
//
//        DataInputStream dataInputStream = new DataInputStream(new ByteArrayOutputStream(bytes));
//        ByteBuffer directBuffer = ByteBuffer.allocateDirect(10240);
//        ByteBuffer put = directBuffer.put(bytes);
////        ByteBuffer wrap = ByteBuffer.wrap(bytes);
////        System.out.println(wrap);
//        RoaringBitmap bitmap = new RoaringBitmap();
//        bitmap.serialize(dataInputStream);
//        bitmap.deserialize(put);
//
////        System.out.println(bytes);



/*
        RoaringBitmap rr2 = new RoaringBitmap();
        rr2.add(4000L,4255L);
        rr.select(3); // would return the third value or 1000
        rr.rank(2); // would return the rank of 2, which is index 1
        rr.contains(1000); // will return true
        rr.contains(7); // will return false

        RoaringBitmap rror = RoaringBitmap.or(rr, rr2);// new bitmap
        rr.or(rr2); //in-place computation
        boolean equals = rror.equals(rr);// true
        if(!equals) {throw new RuntimeException("bug");}
        // number of values stored?
        long cardinality = rr.getLongCardinality();
        System.out.println(cardinality);
        // a "forEach" is faster than this loop, but a loop is possible:
        for(int i : rr) {
            System.out.println(i);
        }*/


//        MutableRoaringBitmap rr1 = MutableRoaringBitmap.bitmapOf(1, 2, 3, 1000);
//        MutableRoaringBitmap rr2 = MutableRoaringBitmap.bitmapOf( 2, 3, 1010);


        byte[] bytes = "abc".getBytes();
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        RoaringBitmap rr = new RoaringBitmap();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        DataOutputStream dos = new DataOutputStream(bos);
        // If there were runs of consecutive values, you could
        // call rr1.runOptimize(); or rr2.runOptimize(); to improve compression

        rr.serialize(wrap);
        rr.serialize(dos);




//        rr2.serialize(dos);
//        dos.close();
//        ByteBuffer bb = ByteBuffer.wrap(bos.toByteArray());
//        ImmutableRoaringBitmap rrback1 = new ImmutableRoaringBitmap(bb);
//        bb.position(bb.position() + rrback1.serializedSizeInBytes());
//        ImmutableRoaringBitmap rrback2 = new ImmutableRoaringBitmap(bb);



    }
}
