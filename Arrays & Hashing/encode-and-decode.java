//https://neetcode.io/problems/string-encode-and-decode
class Solution {
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(int i=0; i<strs.size(); i++){
            res.append(strs.get(i).length());
            res.append("#");
            res.append(strs.get(i));
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        int i=0;
        System.out.println(str + " " + str.length());
        int num = 0;
        List<String> res = new ArrayList<>();
        while(i<str.length()){
            if(str.charAt(i) == '#'){
                ++i;
                StringBuilder temp = new StringBuilder();
                System.out.println(num);
                int len = i+num;
                System.out.println(len);
                if(num == 0){
                    res.add("");
                    continue;
                }
                while(i < len){
                    System.out.println(i + " = i" + " " + str.charAt(i));
                    temp.append(str.charAt(i));
                    if(i >= str.length()-1)
                        break;
                    i++;
                }
                res.add(temp.toString());
                num = 0;
            }
            if(num != 0)
                num *= 10;
            num += (str.charAt(i)-48);
            i++;
        }
        return res;
    }
}
