import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hanbowen on 2014/8/18.
 */
public class IPMask extends IPV4{
    final static String pattern = "(\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3})/(\\d{1,2})";

    public int getMask() {
        return mask;
    }

    protected  int mask;
    public IPMask(String ipAddressMask) {
        super(argprase(ipAddressMask)[0]);
        String strMask = argprase(ipAddressMask)[1];
        this.mask = Integer.parseInt(strMask);
    }
    public IPMask(String ipAddress, String mask) {
        super(ipAddress);
        this.mask = Integer.parseInt(mask);
    }
    private static String [] argprase(String ipAddMask){
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(ipAddMask);
        String result[] = new String[2];
        if(m.find()){
            String ipAddress = m.group(1);
            String mask = m.group(2);
            result[0] = ipAddress;
            result[1] = mask;

        }
        else{
            throw new IllegalArgumentException("ipAddressWithMask format error, "+ipAddMask);
        }
        return result;
    }
    public  boolean isIn(IPV4 ip){
        long masker = (int)Math.pow(2,this.mask) -1;
        int shift = 32 - this.mask;
        masker = masker << shift;
        int l = this.getInt32();
        long left = BinaryUtils.intToUnsignedLong(this.getInt32()) & masker;
        long right = BinaryUtils.intToUnsignedLong(ip.getInt32()) & masker;
        if(left == right)
            return true;
        else
            return false;
    }
}
