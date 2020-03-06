import HuffmanUtil.DictBuilder;
import HuffmanUtil.HuffmanBinaryMsgBuilder;
import HuffmanUtil.HuffmanBinaryMsgDecoder;
import SocketUtil.BinaryToByte;
import SocketUtil.ByteToBinary;

import java.util.Map;

public class HuffmanTransmissionStarter {
    public static void main(String[] args) {
        String content = "Hello_World";
        Map<Character, String> map = new DictBuilder().loadContent(content).build();
        map.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
        String code = new HuffmanBinaryMsgBuilder(content, map).build();
        HuffmanBinaryMsgDecoder decoder = new HuffmanBinaryMsgDecoder(map, code);
        System.out.println(decoder.decode());

        byte[] binaryToByte = new BinaryToByte(code).getByteArray();
        System.out.println(binaryToByte);
        System.out.println(new ByteToBinary(binaryToByte, code.length()).getBinary());
    }
}
