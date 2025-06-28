package train;

//Doubly linked list why:
//
//constant time next/prev navigation ease

public class DoublyList{
        private TrackNode head;

        public void addLastNode(Station station){
            TrackNode newNode = new TrackNode(station);
            if (head == null){
                head = newNode;
            }
            else{
                TrackNode tem = head;

                while(tem.next != null){
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


        public TrackNode findbyCode(String code){
            TrackNode cur = head;

            while(cur != null){
                if(cur.station.getCode().equals(code)){
                    return cur;
                }
                cur = cur.next;
            }

            return null;
        }


        public int indexOf(TrackNode node) {
            TrackNode curr = head;
            int count = 0;
            while (curr != null) {
                if (curr == node) return count;
                curr = curr.next;
                count++;
            }
            return -1; // Not found
        }


}
