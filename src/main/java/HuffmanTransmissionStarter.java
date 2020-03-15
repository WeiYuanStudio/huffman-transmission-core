import DB.DBAccess;
import HuffmanUtil.DictBuilder;
import HuffmanUtil.HuffmanBinaryMsgBuilder;
import HuffmanUtil.HuffmanBinaryMsgDecoder;
import Json.DictDecoder;
import Json.DictFormatter;
import Json.DictModel;
import SocketUtil.Binary.BinaryToByte;
import SocketUtil.Binary.ByteToBinary;
import SocketUtil.MessageListener;
import SocketUtil.Pack.MessagePacker;
import SocketUtil.Pack.Type;

import java.io.*;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

public class HuffmanTransmissionStarter {
    public static void main(String[] args) {
//        DBAccess.getInstance();
//        System.exit(0);
//        String hashTest = "419e64";
//        byte[] bytes = new MessagePacker(Type.CONTENT, hashTest, "1111").pack();
////        for(byte _byte : bytes) {
//        System.out.println(new ByteToBinary(bytes, 56).getBinary());
////        }
//
//        System.out.println((byte) 127);
//        System.out.println("123");
//        String content = "Hello_World";
//        Map<Character, String> map = new DictBuilder().loadContent(content).build();
//        map.forEach((k, v) -> {
//            System.out.println(k + ": " + v);
//        });
//        String code = new HuffmanBinaryMsgBuilder(content, map).build();
//        HuffmanBinaryMsgDecoder decoder = new HuffmanBinaryMsgDecoder(map, code);
//        System.out.println(decoder.decode());
//
//        byte[] binaryToByte = new BinaryToByte(code).getByteArray();
//        System.out.println(binaryToByte);
//        System.out.println(new ByteToBinary(binaryToByte, code.length()).getBinary());
//

//        try {
//            ServerSocket ss = new ServerSocket(9999);
//            MessageListener messageListener = new MessageListener(ss);
//            messageListener.start();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Running");
//    }
        Map<Character, String> testDict = new HashMap<>();
        testDict.put('A', "01010");
        DictFormatter formatter = new DictFormatter(testDict);
        String jsonText = formatter.build();
        System.out.println(jsonText);
        DictDecoder decoder = new DictDecoder(jsonText);
        DictModel model = decoder.decode();
    }
}
