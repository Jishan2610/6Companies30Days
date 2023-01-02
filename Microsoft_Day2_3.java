import java.util.HashSet;

public class Microsoft_Day2_3{
    public static void main(String[] args) {
        
    }
    class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            //took help from solution
            int smallest_x=Integer.MAX_VALUE;
            int smallest_y=Integer.MAX_VALUE;
            int largest_a=Integer.MIN_VALUE;
            int largest_b=Integer.MIN_VALUE;
            int area=0;
            HashSet<String> hs=new HashSet<>();
            for(int[] points:rectangles){
                smallest_x=Math.min(smallest_x,points[0]);//0
                smallest_y=Math.min(smallest_y,points[1]);//1
                largest_a=Math.max(largest_a,points[2]);//2
                largest_b=Math.max(largest_b,points[3]);//3
                area+=(points[3]-points[1])*(points[2]-points[0]);
                String s1=points[0]+" "+points[1];//lower left
                String s2=points[2]+" "+points[1];//lower right
                String s3=points[0]+" "+points[3];//upper left
                String s4=points[2]+" "+points[3];//upper right
                if(hs.contains(s1))hs.remove(s1);
                else hs.add(s1);
                if(hs.contains(s2))hs.remove(s2);
                else hs.add(s2);
                if(hs.contains(s3))hs.remove(s3);
                else hs.add(s3);
                if(hs.contains(s4))hs.remove(s4);
                else hs.add(s4);
            }
            String final_s1=smallest_x+" "+smallest_y;
            String final_s2=largest_a+" "+smallest_y;
            String final_s3=smallest_x+" "+largest_b;
            String final_s4=largest_a+" "+largest_b;
    
            if(hs.size()!=4 || !hs.contains(final_s1) || !hs.contains(final_s2) || !hs.contains(final_s3) || !hs.contains(final_s4) || (largest_b-smallest_y)*(largest_a-smallest_x)!=area)return false;
            return true; 
            
            
        }
    }
}
