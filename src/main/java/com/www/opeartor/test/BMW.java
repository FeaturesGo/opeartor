package com.www.opeartor.test;

/**
 * Created by Vincent on 2017/7/10.
 */
abstract class BMW {

    public BMW(){

    }


    public class  BMW320 extends BMW{
        public BMW320(){
            System.out.println("制造--->BMW320");
        }
    }

    public class BMW520 extends BMW{
        public BMW520(){
            System.out.println("制造--->BMW520");
        }
    }
}
