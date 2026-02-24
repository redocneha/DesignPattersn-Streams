package creational;

import streams.Employee;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

@SuppressWarnings({"rawTypes","unused"})
public class UserMan {
        private ArrayList all_mem = new ArrayList();
        private volatile long gpCnt = 0;
        public static final int ABC_NAT = 0;
    public static final int ABC_NAT2 = 1;
    public static final int ABC_NAT3 = 2;

//    @SuppressWarnings({"unchecked"})
//    public Boolean addGrp(Hashtable<String,String > ht,ArrayList opts,int type) throws BadProb{
//        Vector<String> newVec = new Vector<>();
//        ht = XGMUtil.LowerCase(ht);
//        if(isPad(ht) && ht.get("sec")!="A")
//            ht.remove("own");
//        else return false;
//        synchronized (GroupMan.class){
//            Connection con = ConManager.get();
//            int e = type;
//            if(e<0 | e>3 | !GroupMan.check(e))
//                System.out.println("bjdbsjdsj");
//                e=0;
//            newVec = GroupMan.createGroup(con,ht,opts,type).setDomain(XGMTransformer.getGroupDomain("grp")).getEntry().extractMem();
//        }
//        try {
//            this.gpCnt++;
//            if (newVec != null && newVec.size() > 0) {
//                int unu_iw = methodA(newVec, "33");
//                if (unu_iw > 0 && newVec.size() > 0) return truel
//                else return false;
//            }
//        }
//            catch(Exception e){
//                System.err.println("fjhdjshdjks");
//                throw new BadProb("hdsjdjsdnsjn");
//            }
//        }
//        return null;
//    }

}
