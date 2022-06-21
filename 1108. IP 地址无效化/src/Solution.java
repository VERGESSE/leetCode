class Solution {
    public String defangIPaddr(String address) {
//        String[] addrs = address.split("\\.");
//        StringBuilder sb = new StringBuilder();
//        for (String addr : addrs) {
//            sb.append(addr).append("[.]");
//        }
//        return sb.substring(0, sb.length() - 3);
        return address.replace(".", "[.]");
    }
}
