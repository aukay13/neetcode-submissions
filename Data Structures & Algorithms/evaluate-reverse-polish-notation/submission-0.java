class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            switch (tokens[i]) {
                case "+":
                    st.push(String.valueOf(Integer.parseInt(st.pop()) + Integer.parseInt(st.pop())));
                    break;
                case "-":
                    String a = st.pop();
                    String b = st.pop();
                    st.push(String.valueOf(Integer.parseInt(b) - Integer.parseInt(a)));
                    break;
                case "*":
                    st.push(String.valueOf(Integer.parseInt(st.pop()) * Integer.parseInt(st.pop())));
                    break;
                case "/":
                    String c = st.pop();
                    String d = st.pop();
                    st.push(String.valueOf(Integer.parseInt(d) / Integer.parseInt(c)));
                    break;
                default:
                    st.push(tokens[i]);
                    break;
            }
        }

        return Integer.parseInt(st.pop());
    }
}
