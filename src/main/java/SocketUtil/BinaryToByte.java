package SocketUtil;

import java.nio.ByteBuffer;

/**
 * String格式二进制序列转至Byte
 */
public class BinaryToByte {
    private String binarySequence;
    private ByteBuffer byteBuffer = ByteBuffer.allocate(1000);

    public BinaryToByte(String binarySequence) {
        this.binarySequence = binarySequence;
    }

    public byte[] getByteArray() {
        StringBuilder binaryCodeBuffer = new StringBuilder(); //存放等待编码的String二进制数据
        binarySequence.chars().forEach(_char -> {
            binaryCodeBuffer.append((char) _char);

            //当集齐8个字符，进行编码
            if (binaryCodeBuffer.length() == 8) {
                byte tempByte = (byte) Integer.parseInt(binaryCodeBuffer.toString(), 2); //编码
                binaryCodeBuffer.delete(0, binaryCodeBuffer.length()); //清空二进制String缓存区
                byteBuffer.put(tempByte); //将编码后的字节数据存放
            }
        });

        //将剩余不足8bit的数据补充到8bit
        if (binaryCodeBuffer.length() != 0) {
            do {
                binaryCodeBuffer.append('0');
            } while (binaryCodeBuffer.length() == 8);
            byte tempByte = (byte) Integer.parseInt(binaryCodeBuffer.toString(), 2); //编码
            binaryCodeBuffer.delete(0, binaryCodeBuffer.length()); //清空二进制String缓存区
            byteBuffer.put(tempByte); //将编码后的字节数据存放
        }

        return byteBuffer.array(); //返回byte数组
    }
}
