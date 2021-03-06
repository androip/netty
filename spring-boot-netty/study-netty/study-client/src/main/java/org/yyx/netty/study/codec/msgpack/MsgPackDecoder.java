package org.yyx.netty.study.codec.msgpack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import org.msgpack.MessagePack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * MsgPack解码器
 * <p>
 * create by 叶云轩 at 2018/4/12-下午7:31
 * contact by tdg_yyx@foxmail.com
 */
public class MsgPackDecoder extends MessageToMessageDecoder<ByteBuf> {
    /**
     * MsgPackDecoder 日志控制器
     * Create by 叶云轩 at 2018/5/3 下午3:19
     * Concat at tdg_yyx@foxmail.com
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(MsgPackDecoder.class);

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        final byte[] array;
        final int length = msg.readableBytes();
        array = new byte[length];
        msg.getBytes(msg.readerIndex(), array, 0, length);
        MessagePack messagePack = new MessagePack();
        out.add(messagePack.read(array));
    }

}
