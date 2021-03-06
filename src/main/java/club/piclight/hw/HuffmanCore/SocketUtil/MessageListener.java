package club.piclight.hw.HuffmanCore.SocketUtil;

import club.piclight.hw.HuffmanCore.SocketUtil.Binary.ByteToBinary;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class MessageListener extends Thread {
    private static final int DICT_HEAD = 17; //词典头
    private static final int CONTENT_HEAD = 18; //哈夫曼头

    private static final int PROTOCOL_B_LEN = 1; //协议头长度
    private static final int HASH_B_LEN = 3; //哈希字段字节长度
    private static final int CONTENT_LEN_B_LEN = 2; //哈夫曼数据头长度表示字段的长度

    private static final int DICT_HEAD_LEN = 4; //词典请求头总长度
    private static final int CONTENT_HEAD_LEN = 6; //消息请求头总长度

    private ServerSocket ss;

    public MessageListener(ServerSocket ss) {
        this.ss = ss;
    }

    @Override
    public void run() {
        while (true) {
            Logger logger = Logger.getLogger(this.getClass().getName());
            try {
                Socket s = ss.accept();
                logger.info("Get A Request From Remote Host: " + s.getRemoteSocketAddress().toString());

                /*将读取到的二进制数据包装*/
                byte[] byteData = s.getInputStream().readAllBytes();
                List<Byte> byteArray = new ArrayList<Byte>();
                for (byte _byte : byteData) {
                    byteArray.add(_byte);
                }

                /*将读取到的数据头一字节读取，内含协议版本以及协议数据类型*/
                byte head = byteArray.get(0);
                System.out.println(head); //Todo test

                /*将读取到的数据头解码为二进制分析，备用*/
//                String headStr = String.format("%8s", Integer.toBinaryString(head & 0xFF)).replace(' ', '0');
//                if (headStr.substring(0, 4).equals("0001")) {
//                    logger.info("Message Protocol Version 1.0");
//                    /*Protocol version 1.0*/
//                    if (headStr.substring(4, 8).equals("0001")) {
//                        /*Protocol type dict*/
//                        logger.info("Message Data Type Dict");
//                    } else if (headStr.substring(4, 8).equals("0010")) {
//                        /*Protocol type huffman binary code*/
//                        logger.info("Message Data Type Huffman Binary Code");
//                    }
//                }

                /*直接判断字节十六进制值分析协议*/
                if (head == DICT_HEAD) {
                    /*Protocol v1 Type Dict*/ //Todo Refactor to a new class

                } else if (head == CONTENT_HEAD) {
                    /*Protocol v1 Type Data*/ //Todo Refactor to a new class
                    byte[] hashByte = new byte[HASH_B_LEN]; //Hash
                    System.arraycopy(byteData, PROTOCOL_B_LEN, hashByte, 0, HASH_B_LEN);

                    byte[] dataLengthByte = new byte[CONTENT_LEN_B_LEN]; //数据字段01哈夫曼编码长度
                    System.arraycopy(byteData, PROTOCOL_B_LEN + HASH_B_LEN, dataLengthByte, 0, CONTENT_LEN_B_LEN);

                    byte[] dataByte = new byte[byteData.length - CONTENT_HEAD_LEN]; //数据字段字节全拷贝
                    System.arraycopy(byteData, CONTENT_HEAD_LEN, dataByte, 0, byteData.length - CONTENT_HEAD_LEN);

                    int contentBinaryCodeLen = Integer.parseInt(new ByteToBinary(dataLengthByte).getBinary(), 2); //二进制哈夫曼编码长度

                    String contentString = new ByteToBinary(dataByte, contentBinaryCodeLen).getBinary(); //从字节解码二进制哈夫曼编码
                } else {
                    /*No such protocol*/
                    logger.info("Protocol not found");
                }

                /*Response*/
                s.getOutputStream();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
