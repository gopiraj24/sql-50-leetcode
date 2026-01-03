class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();

        String[] parts = path.split("/");

        for(String part : parts) {
            if(part.equals("") || part.equals(".")) {
                continue;
            }

            // Parent directory ".." -> pop if possible 
            if(part.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(part);
            }
        }
        //  Build result 
        StringBuilder result = new StringBuilder();

        // Stack is LIFO, so add from bottom to top 

        for(String dir : stack) {
            result.insert(0, "/" + dir);
        }

        // If empty, return root "/" 
        return result.length() == 0 ? "/" : result.toString();
        
    }
}