import static java.lang.Integer.min;

class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = 0;
        int res = 0;
        while (l < height.length-1){
            if(height[l] > 0){
                System.out.println("Start" + height[l] + " l: " + l);
                r = l+1;
                int filled = 0;
                boolean flag = false;
                while (height[r] < height[l]){
                    System.out.println(height[r] + " r: " + r);
                    if(r+1 >= height.length){
                        flag = true;
                        break;
                    }
                    r++;
//                    filled += height[r-1];
                }
                int h = 0, pos = r;
                h = min(height[l], height[r]);
                if(flag){
                    int temp = r;
                    while (temp > l+1){
                        if(height[temp] > height[pos]){
                            h = min(height[l], height[temp]);
                            pos = temp;
                        }
                        temp--;
                    }
                    System.out.println("pos: " + pos + " l: " + l);
                    if(pos == temp+1 && height[temp] > height[pos])
                        h = 0;
                }
                int temp;
                if(pos != 0)
                    temp = h * (pos-l-1);
                else
                    temp = h * (r-l-1);
                l++;
                while (l < pos){
                    if(height[l] > h)
                        filled += h;
                    else{
                        filled += height[l];
                    }
                    l++;
                }
                System.out.print(h + " " + temp + " " + filled);
                res += temp-filled;
                System.out.println();
                l = pos;
            }
            else{
                l++;
            }
        }
        return res;
    }
}
