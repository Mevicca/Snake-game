package adt;

public class HashSet<E> implements HashSetInterface<E>{
    
    private HashMap<E, Object> hashMapCustom;
 
    public HashSet(){
        hashMapCustom=new HashMap<>();
    }
    
    @Override
    public boolean add(E value){
           return hashMapCustom.put(value, null);
    }
 
    @Override
    public boolean add(E[] value){
        for(E val:value){
            if(val==null)
                break;
            if(!add(val))
               return false;
        }
        return true;
    }
    
    @Override
    public boolean contains(E obj){
           return hashMapCustom.contains(obj) !=null ? true :false;
           
    }
    
    @Override
    public boolean remove(E obj){
        return hashMapCustom.remove(obj);
    } 
   
    @Override
    public boolean remove(E[] objs){     
        for(E obj:objs){
            if(obj==null)
                break;
            if(!hashMapCustom.remove(obj))
                return false;
        }
        return true;
    }
    
    @Override
    public E[] getAllKey(){
        return (E[])hashMapCustom.getAllKey();
    }
    
    @Override
    public void clear(){
        hashMapCustom=new HashMap<>();
    }
}