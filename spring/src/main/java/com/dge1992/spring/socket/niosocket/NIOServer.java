package com.dge1992.spring.socket.niosocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class NIOServer {

    public static void main(String[] args) throws IOException {
        //创建ServerSocketChannel,监听8080端口
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(8080));
        //设置非阻塞模式
        ssc.configureBlocking(false);
        //为ssc注册选择器
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        //创建处理器
        Handler handler = new Handler(1024);
        while (true){
            if(selector.select(3000) == 0){
                System.out.println("等待请求超时......");
                continue;
            }
            System.out.println("处理请求......");
            //获取待处理的SelectionKey
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                try {
                    //接收到连接请求时
                    if(key.isAcceptable()){
                        handler.handleAccept(key);
                    }
                    //读数据
                    if(key.isReadable()){
                        handler.handleRead(key);
                    }
                }catch (IOException ex){
                    iterator.remove();
                    continue;
                }
                //处理完后，从待处理的SelectionKey迭代器中移除当前所使用的key
                iterator.remove();
            }
        }
    }

    private static class Handler{
        private int bufferSize = 1024;
        private String localCharset = "UTF-8";
        public Handler(){

        }
        public Handler(int bufferSize){
            this(bufferSize, null);
        }
        public Handler(String localCharset){
            this(-1, localCharset);
        }
        public Handler(int bufferSize, String localCharset){
            if(bufferSize > 0){
                this.bufferSize = bufferSize;
            }
            if(localCharset != null){
                this.localCharset = localCharset;
            }
        }
        public void handleAccept(SelectionKey key) throws IOException {
            SocketChannel sc = ((ServerSocketChannel)key.channel()).accept();
            sc.configureBlocking(false);
            sc.register(key.selector(), SelectionKey.OP_READ, ByteBuffer.allocate(bufferSize));
        }
        public void handleRead(SelectionKey key) throws IOException {
            //获取channel
            SocketChannel sc = (SocketChannel) key.channel();
            //获取buffer并重置
            ByteBuffer buffer = (ByteBuffer) key.attachment();
            buffer.clear();
            //没有读到内容则关闭
            if(sc.read(buffer) == -1){
                sc.close();
            }else{
                //将buffer转换为可读状态
                buffer.flip();
                String receivedString = Charset.forName(localCharset).newDecoder()
                        .decode(buffer).toString();
                System.out.println("received from client:" + receivedString);

                //返回数据给客户端
                String sendString = "received data:" + receivedString;
                buffer = ByteBuffer.wrap(sendString.getBytes(localCharset));
                sc.write(buffer);
                //关闭socket
                sc.close();
            }
        }
    }
}
