package com.github.jmpjct.mysql.proto;

import java.util.ArrayList;
import org.apache.log4j.Logger;

public class Com_Stmt_Close extends Packet {
    public byte[] data;
    
    public ArrayList<byte[]> getPayload() {
        ArrayList<byte[]> payload = new ArrayList<byte[]>();
        
        payload.add(this.data);
        
        return payload;
    }
    
    public static Com_Stmt_Close loadFromPacket(byte[] packet) {
        Com_Stmt_Close obj = new Com_Stmt_Close();
        Proto proto = new Proto(packet, 3);
        
        obj.sequenceId = proto.get_fixed_int(1);
        
        int size = packet.length - proto.offset;
        obj.data = new byte[size];
        
        System.arraycopy(packet, proto.offset, obj.data, 0, size);

        return obj;
    }
}
