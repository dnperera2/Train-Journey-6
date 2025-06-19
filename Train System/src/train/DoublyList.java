package train;

public class DoublyList{
        private TrackNode head;

        public void addLastNode(Station station){
            TrackNode newNode = new TrackNode(station);
            if (head == null){
                head = newNode;
            }
            else{
                TrackNode tem = head;

                while(tem.next == null){
                    tem = tem.next;
                }
                tem.next = newNode;
                newNode.prev = tem;

            }
        }

        public void printDoubly(){
            TrackNode curr = head;
            while (curr != null){
                System.out.println(curr.station);
                curr = curr.next;
            }
        }
}
