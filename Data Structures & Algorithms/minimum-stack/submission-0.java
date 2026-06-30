class MinStack {

    private ArrayList<Integer> list;
    private ArrayList<Integer> minList;


    public MinStack() {
        list = new ArrayList<>();
        minList = new ArrayList<>();
    }
    
    public void push(int val) {
        list.add(val);
        if(minList.isEmpty()){
            minList.add(val);
        }
        else{
            if(minList.getLast()<val){
                minList.add(minList.getLast());
            }
            else{
                minList.add(val);
            }
        }

    }
    
    public void pop() {
        list.removeLast();
        minList.removeLast();
    }
    
    public int top() {
        return list.getLast();
    }
    
    public int getMin() {
        return minList.getLast();
    }
}
