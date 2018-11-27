/* 
 * Name:      Jaswinder Pal Singh 
 *
 * Course:     CSC 130
 * 
 * Date:       10/15/2017
 * 
 * Filename:   AvlTree.java
 * 
 * Purpose:    Create, Balance, Find, Swap an AVLTREE
 */
        
import java.util.Random;
import java.util.Scanner;

public class AvlTree {
	static boolean infiLoop;
    AvlNode position;
    AvlNode avlTree;
    
    public AvlNode makeEmpty(AvlNode t) {
        if (t != null) {
            makeEmpty(t.getLeft());
            makeEmpty(t.getRight());
            t = null;
        }
        return null;
    }
    
    public AvlNode findMin(AvlNode t) {
        if (t == null) {
            return null;
        } else if (t.getLeft() == null)
            return t;
        else
            return findMin(t.getLeft());
    }
    
    public AvlNode findMax(AvlNode t) {
        if (t != null)
            while (t.getRight() != null)
                t = t.getRight();
        return t;
    }
    
    public static int getHeight(AvlNode position) {
        if (position == null)
            return -1;
        else
            return position.getHeight();
    }
    
    public static void updateHeight(AvlNode t){
        t.setHeight(Math.max(getHeight(t.getLeft()), getHeight(t.getRight()) + 1)); 
    }
    
    public static int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }
    
    public static AvlNode singleRotateWithLeft(AvlNode k2) {
        AvlNode k1;
        k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(max(getHeight(k2.getLeft()), getHeight(k2.getRight())) + 1);
        k1.setHeight(max(getHeight(k1.getLeft()), k2.getHeight()) + 1);
        return k1;
    }
    
    public static AvlNode singleRotateWithRight(AvlNode k1) {
        AvlNode k2;
        k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.setHeight(max(getHeight(k1.getLeft()), getHeight(k1.getRight())) + 1);
        k2.setHeight(max(getHeight(k2.getRight()), k1.getHeight()) + 1);
        return k2;
    }
    
    public static AvlNode doubleRotateWithLeft(AvlNode k3) {
        k3.setLeft(singleRotateWithRight(k3.getLeft()));
        return singleRotateWithLeft(k3);
    }
    
    public static AvlNode doubleRotateWithRight(AvlNode k1) {
        k1.setRight(singleRotateWithLeft(k1.getRight()));
        return singleRotateWithRight(k1);
    }
    
    public int retrieve(AvlNode t) {
        return t.getValue();
    }

    public AvlNode insert(int value, AvlNode t) {
        if (t == null) {
            t = new AvlNode(value);
        } else if (value < t.getValue()) {
            t.setLeft(insert(value, t.getLeft()));
            if (getHeight(t.getLeft()) - getHeight(t.getRight()) == 2)
                if (value < t.getLeft().getValue())
                    t = singleRotateWithLeft(t);
                else
                    t = doubleRotateWithLeft(t);
        } else if (value > t.getValue()) {
            t.setRight(insert(value, t.getRight()));
            if (getHeight(t.getRight()) - getHeight(t.getLeft()) == 2)
                if (value > t.getRight().getValue())
                    t = singleRotateWithRight(t);
                else
                    t = doubleRotateWithRight(t);
        }
        t.setHeight(max(getHeight(t.getLeft()), getHeight(t.getRight())) + 1);
        return t;
    }
    
    public AvlNode remove(AvlNode t, int x){
        if(t == null)
           return t;
        else if(x < t.getValue()){
           t.setLeft(remove(t.getLeft(), x));
           //balance?
           if(getHeight(t.getRight()) - getHeight(t.getLeft()) == 2){
              if(getHeight(t.getRight().getLeft()) < getHeight(t.getRight().getRight()))
                 t = singleRotateWithRight(t);
              else
                 t = doubleRotateWithRight(t);
           }
        }else if(t.getValue() < x){
           t.setRight(remove(t.getRight(), x));
           //balance?
           if(getHeight(t.getLeft()) - getHeight(t.getRight()) == 2){
              if(getHeight(t.getLeft().getRight()) < getHeight(t.getLeft().getLeft()))
                 t = singleRotateWithLeft(t);
              else
                 t = doubleRotateWithLeft(t);
           }
        }else { //x == t.ele --> this is the node to remove
           if(t.getLeft() != null && t.getRight() != null){ //has 2 children
              t.setValue(findMin(t.getRight()).getValue());
              t.setRight(remove(t.getRight(), t.getValue()));
           }else if(t.getLeft() == null){
              t = t.getRight();
           }else{
              t = t.getLeft();
           }
        }
        if(t == null)
           return t;
        updateHeight(t);
        return t;
     }
    
    public static void swapT1toT2(AvlNode t1, AvlNode t2, AvlTree Tr1, AvlTree Tr2) {
    	t2 = Tr2.makeEmpty(null);
        
        infiLoop = true;
        while(infiLoop) {
        	int min = Tr1.retrieve(Tr1.findMin(t1));
        	int max = Tr1.retrieve(Tr1.findMax(t1));
        	Tr1.remove(t1, min);
        	System.out.println("The process with a priority of " + min + " is now scheduled to run!");
        	System.out.println("The process with a priority of "+ min +" has run out of its timeslice!\"");
        	
        	//System.out.println("Min: " + min);
        	//System.out.println("Max: " + max);
            t2 = Tr2.insert(min, t2);
            
            if( (min == max) || (min+2 == max) || (min+1 == max)) {
            	System.out.println("Tree1_To_Tree2: Every process has got a chance to run; Please press \"Enter\" to start the next round!");
            	Scanner scanner = new Scanner(System.in);
            	scanner.nextLine();
            	infiLoop = false;
            	swapT2toT1(t2, t1, Tr2, Tr1);
            }
        }
    }
    
    public static void swapT2toT1(AvlNode t2, AvlNode t1, AvlTree Tr2, AvlTree Tr1) {
    	t1 = Tr1.makeEmpty(null);
        
        infiLoop = true;
        while(infiLoop) {
        	int min = Tr2.retrieve(Tr2.findMin(t2));
        	int max = Tr2.retrieve(Tr2.findMax(t2));
        	Tr2.remove(t2, min);
        	System.out.println("The process with a priority of " + min + " is now scheduled to run!");
        	System.out.println("The process with a priority of "+ min +" has run out of its timeslice!\"");
        	
        	//System.out.println("Min: " + min);
        	//System.out.println("Max: " + max);
            t1 = Tr1.insert(min, t1);
            
            if( (min == max) || (min+2 == max) || (min+1 == max)) {
            	System.out.println("Tree2_To_Tree1:Every process has got a chance to run; Please press \"Enter\" to start the next round!");
          	    Scanner scanner = new Scanner(System.in);
          	    scanner.nextLine();
          	    infiLoop = false;
          	    swapT1toT2(t1, t2, Tr1, Tr2);
            }
        }
    }

    public static void main(String[] args) {
        AvlTree at = new AvlTree();
        AvlTree at2 = new AvlTree();
        
        AvlNode t;
        AvlNode t2;
        
        int i;
        
        int[] array = new int[4097];
        Random rnd = new Random();
        
        for(i = 0; i< 4095; i++) {
        	array[i] = rnd.nextInt(4097-0+1)+0;
        }
        
        t = at.makeEmpty(null);
        for (i = 0; i < 4095; i++)
            t = at.insert(array[i], t);
       
        t2 = at2.makeEmpty(null);
        swapT1toT2(t, t2, at, at2);
        
    }
}