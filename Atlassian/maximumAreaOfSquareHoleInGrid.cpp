class Solution {
    public:
        int maximizeSquareHoleArea(int n, int m, vector<int>& h, vector<int>& v) {
            sort(h.begin(),h.end());
            sort(v.begin(),v.end());
             int max1=1;
            
            int count=1;
            for(int i=1;i<h.size();i++)
            {
               if( h[i]==h[i-1]+1)
                   count++;
                else
                count=1;
                max1=max(max1,count);
            }
            
              int max2=1;
              count=1;
            
            for(int i=1;i<v.size();i++)
            {
               if( v[i]==v[i-1]+1)
                   count++;
                else
                count=1;
                max2=max(max2,count);
            }
            //cout<<max1<<" "<<max2<<endl;
            return pow(min(max1+1,max2+1),2);
        }
    };