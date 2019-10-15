package com.github.dge1992.dubboconsumer.filter;

import org.apache.dubbo.rpc.*;
import org.slf4j.MDC;

/**
 * 消费者dubbo过滤器
 */
public class ConsumerFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        RpcContext.getContext().setAttachment("traceId", MDC.get("traceId"));

        Result result = invoker.invoke(invocation);

        return result;
    }
}
