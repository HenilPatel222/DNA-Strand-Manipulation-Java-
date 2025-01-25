        public class DnaStrands {
            char bases;
            DnaStrands next;
             public DnaStrands(char bases){
                this.bases=bases;
                this.next=null;
            }
             public int gcContent(DnaStrands node){
                if (node == null) {
                    return -1;
                } else {
                    int count=(node.bases=='G' || node.bases=='C')? 1:0;
                    return count + gcContent(node.next);
                }
            }
               public DnaStrands reverseComplement(DnaStrands node){
                return reversecomplementhelper(node,null);
            }

              private DnaStrands reversecomplementhelper(DnaStrands node, DnaStrands nextnode) {
                if (node == null) {
                    return nextnode;
                } else {
                    char complementStrand=complement(node.bases);
                    DnaStrands newNode = new DnaStrands(complementStrand);
                    newNode.next=nextnode;
                    return reversecomplementhelper(node.next,newNode);
                }
            }

              private char complement(char bases) {
                if (bases == 'A') {
                    return 'T';
                } else if (bases == 'T') {
                    return 'A';
                } else if (bases == 'G') {
                    return 'C';
                } else if (bases == 'C') {
                    return 'G';
                }
                throw new IllegalArgumentException("Invalid DNA base: " + bases);
            }
             public boolean compare(DnaStrands node1, DnaStrands node2) {
                if(node1==null && node2==null){
                    return true;
                }
                if(node1==null || node2==null || node1.bases!=node2.bases){
                    return false;
                }
                return compare(node1.next, node2.next);
            }
            public void generateStrands(int n,int k,int gcRequired ,DnaStrands head,int gcCount){
                 if(k==n){
                     if(gcCount==gcRequired && !isSelfComplimentary(head)){
                         printDnaStrand(head);
                     }
                     return;
                 }
                 char [] dnabases={'A','C','G','T'};
                 for(char base:dnabases){
                     DnaStrands newNode=new DnaStrands(base);

                     if(head==null){
                         generateStrands(n,k+1,gcRequired, newNode,gcCount+((base=='G' || base=='C')?1:0));
                     } else {
                         DnaStrands temp=head;
                         while(temp.next!=null){
                             temp=temp.next;
                         }
                         temp.next=newNode;
                         generateStrands(n,k+1,gcRequired, head, gcCount + ((base == 'G' || base == 'C') ? 1 : 0));
                     temp.next=null;
                     }
                 }
             }

            public boolean isSelfComplimentary(DnaStrands head) {
                 DnaStrands reversedComplement=reverseComplement(head);
                 return compare(head,reversedComplement);

            }

            private void printDnaStrand(DnaStrands head) {
                 StringBuilder str=new StringBuilder();
                 while(head!=null){
                     str.append(head.bases);
                     head=head.next;
                 }
                 System.out.println(str.toString());


            }
        }


