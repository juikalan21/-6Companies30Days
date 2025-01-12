class Solution {
    static void linkdelete(Node head, int n, int m) {
        int count = 0;
        Node curr = head;
        while(curr!=null && curr.next!=null){
            count++;
            int x = N;
            if(count==M){
                while(x>0){
                    curr.next=curr.next.next;
                    if(curr.next==null){return;}
                    count=0;
                x--;
            }
            x=N;
            }
            curr=curr.next;
        }
    }
}
